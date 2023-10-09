import Company, { ICompany } from "../models/companySchema";
import bcrypt from "bcrypt";
import jwt from "jsonwebtoken";
import { CustomError } from "../middlewares/error";

const hashPassword = async (plaintextPassword: string) => {
  const saltRounds = 10;
  return bcrypt.hash(plaintextPassword, saltRounds);
};

const userEmailRegex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,4}$/;
const userPWRegex = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
const phoneNumberRegex = /^[0-9]{10,11}$/;

export const signUp = async (
  companyName: string,
  phoneNumber: string,
  companyEmail: string,
  storeManagementCount: number,
  companyPw: string
) => {
  try {
    if (!userEmailRegex.test(companyEmail)) {
      throw new CustomError("INVALID_USER_EMAIL", 400);
    }

    if (!userPWRegex.test(companyPw)) {
      throw new CustomError("INVALID_USER_PASSWORD", 400);
    }

    if (!phoneNumberRegex.test(phoneNumber)) {
      throw new CustomError("INVALID_USER_PHONENUMBER", 400);
    }

    const hashedPassword = await hashPassword(companyPw);
    const newCompany = new Company({
      companyName,
      phoneNumber,
      companyEmail,
      storeManagementCount,
      companyPw: hashedPassword,
    });

    return newCompany.save();
  } catch (err) {
    if (err instanceof CustomError) {
      throw err;
    }
    throw new CustomError("An error occurred during signup.", (err as { statusCode?: number }).statusCode || 400);
  }
};

export const signIn = async (companyEmail: string, companyPw: string) => {
  try {
    const company: ICompany | null = await Company.findOne({ companyEmail: companyEmail }).exec();
    if (!company) {
      throw new CustomError("SPECIFIED_COMPANY_USER_DOES_NOT_EXIST", 400);
    }

    const result = await bcrypt.compare(companyPw, company.companyPw);
    if (!result) {
      throw new CustomError("INVALID_PASSWORD", 400);
    }

    const accessToken = jwt.sign({ id: company.id, email: company.companyEmail }, process.env.SECRET_JWT_KEY as string);
    const refreshToken = jwt.sign(
      { id: company.id, email: company.companyEmail },
      process.env.SECRET_REFRESH_JWT_KEY as string
    );

    company.refreshToken = refreshToken;
    await company.save();

    return { accessToken, refreshToken };
  } catch (err) {
    if (err instanceof CustomError) {
      throw err;
    }
    throw new CustomError("An error occurred during signin.", (err as { statusCode?: number }).statusCode || 400);
  }
};
