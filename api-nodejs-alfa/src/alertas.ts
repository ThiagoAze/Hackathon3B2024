import express, { Request, Response } from 'express';
import mysql, { Connection, FieldPacket, QueryOptions, QueryError, RowDataPacket } from 'mysql2';
import cors from 'cors';
import { format } from 'date-fns';
import { ptBR } from 'date-fns/locale';

const app = express();

app.use(cors());

// Configuração do banco de dados
const connection: Connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'vacinet'
});

// Conectar ao banco de dados
connection.connect((err: QueryError | null) => {
    if (err) {
        console.error('Erro ao conectar ao banco de dados:', err.message);
        return;
    }
    console.log('Conexão bem-sucedida ao banco de dados');
});

// Função para formatar a data
function formatarData(data: string): string {
    return format(new Date(data), 'dd MMMM yyyy', { locale: ptBR });
}

// Rota para obter lembretes
app.get('/vaccines', (req: Request, res: Response) => {
    const sql = "SELECT nome, dataInicio, dataFinal, idadeMinima, idadeMaxima FROM vacina ORDER BY dataInicio DESC";
    connection.query(sql, (error: QueryError | null, results: RowDataPacket[]) => {
        if (error) {
            console.error('Erro ao executar a consulta:', error.message);
            res.status(500).send('Erro ao obter os lembretes');
            return;
        }
        // Formatando as datas antes de enviar a resposta
        const formattedResults = results.map(lembrete => ({
            ...lembrete,
            data_inicio: formatarData(lembrete.data_inicio),
            data_final: formatarData(lembrete.data_final)
        }));
        res.json(formattedResults);
    });
});

// Porta do servidor
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Servidor Node.js rodando na porta ${PORT}`);
});
