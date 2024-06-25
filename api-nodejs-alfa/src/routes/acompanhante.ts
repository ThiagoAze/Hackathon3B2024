import { Router, Request, Response } from "express";
import knexInstance from "../../knexfile";
import knex from '../database/knex'

const acompanhanteRouter = Router();

acompanhanteRouter.post("/", async (req: Request, res: Response) => {
    const acompanhanteSalvar = req.body
    res.json(acompanhanteSalvar)
    knex("acompanhante")
      .insert(acompanhanteSalvar)
        .then(() => {
          console.log("Acompanhante salvo!")
        })
        .catch(() => {
          console.log("Erro")
        })
});

acompanhanteRouter.get("/", async (req: Request, res: Response) => {
  res.json({ message: 'Acompanhante buscado!' });
});

acompanhanteRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Acompanhante atualizado' });
});

acompanhanteRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Acompanhante deletado' });
});

export default acompanhanteRouter;