import { Router } from "express";

import vaccinesRouter from "./vaccines";

const router = Router();


router.use("/usuario", vaccinesRouter);
    
export default router;