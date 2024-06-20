import { Router, Request, Response } from "express";

const vaccinesRouter = Router();

vaccinesRouter.post("/", async (req: Request, res: Response) => {
  console.log("essa rota cadastra uma vacina");
});

vaccinesRouter.get("/", async (req: Request, res: Response) => {
  console.log("essa rota traz as vacinas cadastradas");
});

vaccinesRouter.put("/:id", async (req: Request, res: Response) => {
  console.log("Essa rota edita vacina por id");
});

vaccinesRouter.delete("/:id", async (req: Request, res: Response) => {
  console.log("Esta rota essta deletando uma vacina por id ");
});

vaccinesRouter.get("/:id", async (req: Request, res: Response) => {
  console.log("busca determinada vacina por id ");
});

export default vaccinesRouter;
