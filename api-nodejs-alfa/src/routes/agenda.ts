import { Router, Request, Response } from "express";
import knexInstance from "../../knexfile";
import knex from '../database/knex'

const agendaRouter = Router();

agendaRouter.post("/", async (req: Request, res: Response) => {
    const agendaSalvar = req.body
    res.json(agendaSalvar)
    knex("agenda")
      .insert(agendaSalvar)
        .then(() => {
          console.log("Agenda salva!")
        })
        .catch(() => {
          console.log("Erro")
        })
});

agendaRouter.get("/", async (req: Request, res: Response) => {
  res.json({ message: 'Agenda Buscada!' });
});

agendaRouter.put("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Agenda Atualizada!' });
});

agendaRouter.delete("/:id", async (req: Request, res: Response) => {
  res.json({ message: 'Agenda deletada!' });
});

export default agendaRouter;