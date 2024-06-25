import { Router } from "express";

import vacinaRouter from "./vacina";
import idosoRouter from "./idoso";
import acompanhanteRouter from "./acompanhante";
import agendaRouter from "./agenda";
import avisoRouter from "./aviso";

const router = Router();

router.use("/vacina", vacinaRouter);
router.use("/idoso", idosoRouter);
router.use("/acompanhante", acompanhanteRouter);
router.use("/agenda", agendaRouter);
router.use("/aviso", avisoRouter);
    
export default router;