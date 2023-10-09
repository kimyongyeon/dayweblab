import jwt, { JwtPayload } from "jsonwebtoken";
import { Request, Response, NextFunction } from "express";
import Company from "../models/companySchema";
import { CustomError } from "./error";

interface Company {
  id: string;
}

declare global {
  namespace Express {
    interface Request {
      company: Company;
    }
  }
}

interface Customer {
  id: string;
}

declare global {
  namespace Express {
    interface Request {
      customer: Customer;
    }
  }
}

const generateRefreshToken = (userId: string, userEmail: string): string => {
  const refreshToken = jwt.sign({ id: userId, email: userEmail }, process.env.SECRET_REFRESH_JWT_KEY as string, {
    expiresIn: process.env.JWT_REFRESH_EXPIRES_IN,
  });
  return refreshToken;
};

export const forCompanyValidateToken = async (req: Request, res: Response, next: NextFunction) => {
  try {
    const accessToken = req.headers.authorization;

    if (!accessToken) {
      throw new CustomError("TOKEN_NOT_FOUND", 401);
    }

    const secretJwtKey = process.env.SECRET_JWT_KEY;
    if (!secretJwtKey) {
      throw new CustomError("SECRET_KEY_NOT_FOUND", 500);
    }

    const payload = jwt.verify(accessToken, secretJwtKey) as JwtPayload;

    if (!payload.id || !payload.email || !payload.iat) {
      throw new CustomError("INVALID_PAYLOAD", 401);
    }

    const currentTimestamp = Math.floor(Date.now() / 1000);
    const tokenExpirationTimestamp = currentTimestamp + Number(process.env.JWT_EXPIRES_IN_FOR_COMPANY);

    if (currentTimestamp > tokenExpirationTimestamp) {
      throw new CustomError("TOKEN_EXPIRED", 401);
    }

    req.company = { id: payload.id };

    const companyRefreshToken = generateRefreshToken(payload.id, payload.email);
    res.set("x-company-refresh-token", companyRefreshToken);

    next();
  } catch (error: unknown) {
    if (error instanceof CustomError) {
      next(error);
    } else {
      next(new CustomError("INTERNAL_SERVER_ERROR", 500));
    }
  }
};

export const forCustomerValidateToken = async (req: Request, res: Response, next: NextFunction) => {
  try {
    const accessToken = req.headers.authorization;

    if (!accessToken) {
      throw new CustomError("TOKEN_NOT_FOUND", 401);
    }

    const secretJwtKey = process.env.SECRET_JWT_KEY_COMPANY;
    if (!secretJwtKey) {
      throw new CustomError("SECRET_KEY_NOT_FOUND", 500);
    }

    const payload = jwt.verify(accessToken, secretJwtKey) as JwtPayload;

    if (!payload.id || !payload.email || !payload.iat) {
      throw new CustomError("INVALID_PAYLOAD", 401);
    }

    const currentTimestamp = Math.floor(Date.now() / 1000);
    const tokenExpirationTimestamp = currentTimestamp + Number(process.env.JWT_EXPIRES_IN_FOR_CUSTOMER);

    if (currentTimestamp > tokenExpirationTimestamp) {
      throw new CustomError("TOKEN_EXPIRED", 401);
    }

    req.customer = { id: payload.id };

    const customerRefreshToken = generateRefreshToken(payload.id, payload.email);
    res.set("x-customer-refresh-token", customerRefreshToken);

    next();
  } catch (error: unknown) {
    if (error instanceof CustomError) {
      next(error);
    } else {
      next(new CustomError("INTERNAL_SERVER_ERROR", 500));
    }
  }
};
