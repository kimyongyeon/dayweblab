import { Request, Response } from "express";
import { signIn, signUp } from "../services/companyService";
import { CustomError, catchAsync } from "../middlewares/error";

export const createUser = catchAsync(async (req: Request, res: Response) => {
  if (req.method !== "POST") {
    throw new CustomError("METHOD_NOT_ALLOWED.", 405);
  }
  const { companyName, phoneNumber, companyEmail, storeManagementCount, companyPw } = req.body;

  if (!companyName || !phoneNumber || !companyEmail || !storeManagementCount || !companyPw) {
    res.status(400).json({ error: "KEY_ERROR: Missing required field." });
  }

  await signUp(companyName, phoneNumber, companyEmail, storeManagementCount, companyPw);

  res.status(200).json({ message: "User created successfully", companyName });
});

export const findUser = catchAsync(async (req: Request, res: Response) => {
  if (req.method !== "POST") {
    throw new CustomError("METHOD_NOT_ALLOWED.", 405);
  }

  const { companyEmail, companyPw } = req.body;

  if (!companyEmail || !companyPw) {
    res.status(400).json({ error: "KEY_ERROR: Missing required fields: email, password." });
    return;
  }

  const { accessToken, refreshToken } = await signIn(companyEmail, companyPw);

  res.json({ message: "Login successful", accessToken, refreshToken });
});
