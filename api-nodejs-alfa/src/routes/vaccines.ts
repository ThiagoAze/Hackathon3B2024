import { Router, Request, Response } from "express";
import knexInstance from "./../../knexfile";

const vaccinesRouter = Router();

vaccinesRouter.post("/", async (req: Request, res: Response) => {
  res.json({ message: 'essa rota cadastra uma vacina' });
});

vaccinesRouter.get("/", async (req: Request, res: Response) => {
  res.json({ message: 'Hello from Node.js!' });
});

vaccinesRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'essa rota atualiza uma vacina' });
});

vaccinesRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'essa rota deleta uma vacina' });
});

export default vaccinesRouter;
  