import { Router } from "express";

import vaccinesRouter from "./vaccines";

const router = Router();

router.use("/vaccines", vaccinesRouter);

export default router;