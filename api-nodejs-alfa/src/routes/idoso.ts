import { Router, Request, Response } from "express";
import knexInstance from "../../knexfile";
import knex from '../database/knex'

const idosoRouter = Router();

idosoRouter.post("/", async (req: Request, res: Response) => {
  const idosoSalvar = req.body
  res.json(idosoSalvar)
    knex("idoso")
      .insert(idosoSalvar)
        .then(() => {
          console.log("Idoso Cadastrado!")
        })
        .catch(() => {
          console.log("Erro")
        })
});

idosoRouter.get("/", async (req: Request, res: Response) => {
  res.json({ message: 'Idoso buscado!' });
});

idosoRouter.get("/:cpf", async (req: Request, res: Response) => {
  const idosoSalvar = req.body
  res.json(idosoSalvar)
    knex("idoso")
      .insert(idosoSalvar).where("'cpf' = {cpf}")
        .then(() => {
          console.log("Idoso buscado!")
        })
        .catch(() => {
          console.log("Erro")
        })
});

idosoRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Idoso Atualizado!' });
});

idosoRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Idoso deletado!' });
});

export default idosoRouter;