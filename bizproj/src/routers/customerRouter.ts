import express, { Router } from "express";
const router: Router = express.Router();
import { createCustomer, findCustoemr } from "../controllers/customerController";

//회원가입로그인
router.use("/signUp", createCustomer);
router.use("/signIn", findCustoemr);

export default router;
