import { Router } from "express";

import vaccinesRouter from "./routes/vaccines";

const router = Router();

router.use("/vaccines", vaccinesRouter);

export default router;