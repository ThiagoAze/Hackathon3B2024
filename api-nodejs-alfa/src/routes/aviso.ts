import { Router, Request, Response } from "express";
import knexInstance from "../../knexfile";
import knex from '../database/knex'

const avisoRouter = Router();

avisoRouter.post("/", async (req: Request, res: Response) => {
    const avisoSalvar = req.body
    res.json(avisoSalvar)
    
});

avisoRouter.get("/", async (req: Request, res: Response) => {
  res.json({ message: 'Aviso buscado!' });
});

avisoRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Aviso Atualizado!' });
});

avisoRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Aviso deletado!' });
});

export default avisoRouter;