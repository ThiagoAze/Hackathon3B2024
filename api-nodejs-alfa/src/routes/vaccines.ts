import { Router, Request, Response } from "express";
import knexInstance from "./../../knexfile";

const vaccinesRouter = Router();

vaccinesRouter.post("/", async (req: Request, res: Response) => {
  console.log("essa rota cadastra uma vacina");
});

vaccinesRouter.get("/", async (req: Request, res: Response) => {
  console.log("Essa rota trás as vacinas");
});

vaccinesRouter.put("/:id", async (req: Request, res: Response) => {
  console.log("Essa rota edita vacina por id");
});

vaccinesRouter.delete("/:id", async (req: Request, res: Response) => {
  console.log("Esta rota essta deletando uma vacina por id ");
});

export default vaccinesRouter;
  