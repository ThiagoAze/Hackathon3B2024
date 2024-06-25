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
  res.json({ message: 'Idoso buscado!' });
});

usuarioRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Idoso Atualizado!' });
});

usuarioRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Idoso deletado!' });
});

export default usuarioRouter;