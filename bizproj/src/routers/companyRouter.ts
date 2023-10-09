import express, { Router } from "express";
const router: Router = express.Router();

import { findUser, createUser } from "../controllers/companyController";

//회원가입 로그인
router.use("/signIn", findUser);
router.use("/signUp", createUser);

export default router;
