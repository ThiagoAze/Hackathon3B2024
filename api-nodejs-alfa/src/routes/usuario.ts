import { Router, Request, Response } from "express";
import knexInstance from "../../knexfile";
import knex from '../database/knex'

const usuarioRouter = Router();

usuarioRouter.post("/", async (req: Request, res: Response) => {
    const idosoSalvar = req.body
    res.json(idosoSalvar)
    knex("idoso")
      .insert(idosoSalvar)
        .then(() => {
          console.log("awa")
        })
        .catch(() => {
          console.log("Erro")
        })
    
});

usuarioRouter.get("/", async (req: Request, res: Response) => {
  res.json({ message: 'Hello from Node.js!' });
});

usuarioRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'essa rota atualiza uma vacina' });
});

usuarioRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'essa rota deleta uma vacina' });
});

export default usuarioRouter;