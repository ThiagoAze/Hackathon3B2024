import { Router, Request, Response } from "express";
import knexInstance from "../database/knex";

const vaccinesRouter = Router();

vaccinesRouter.post("/", async (req: Request, res: Response) => {
  console.log("essa rota cadastra uma vacina");
});

vaccinesRouter.get("/", async (req: Request, res: Response) => {
  const vaccines = await knexInstance("vacina").select("*");
  res.json(vaccines);
});

vaccinesRouter.put("/:id", async (req: Request, res: Response) => {
  console.log("Essa rota edita vacina por id");
});

vaccinesRouter.delete("/:id", async (req: Request, res: Response) => {
  console.log("Esta rota essta deletando uma vacina por id ");
});

vaccinesRouter.get("/:id", async (req: Request, res: Response) => {
  const id = req.params.id;
  
  const vaccine = await knexInstance("vacina").where("id", id);
  
  res.json(vaccine);
});

export default vaccinesRouter;
  