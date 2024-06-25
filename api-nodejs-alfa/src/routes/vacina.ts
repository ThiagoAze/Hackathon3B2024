import { Router, Request, Response } from "express";
import knexInstance from "../../knexfile";
import knex from '../database/knex'

const vacinaRouter = Router();

vacinaRouter.post("/", async (req: Request, res: Response) => {
  res.json({ message: 'Vacina criada!' });
});

vacinaRouter.get("/", async (req: Request, res: Response) => {
  res.json({ message: 'Vacina buscada!' });
});

vacinaRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Vacina atualizada!' });
});

vacinaRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Vacina deletada!' });
});

export default vacinaRouter;
  