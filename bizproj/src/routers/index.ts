import express from "express";
import companyRouter from "./companyRouter";
import customerRouter from "./customerRouter";

const router = express.Router();
router.use("/company", companyRouter);
router.use("/customer", customerRouter);

export default router;
