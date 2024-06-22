import express, { Request, Response } from 'express';
import mysql, { Connection, FieldPacket, QueryOptions, QueryError, RowDataPacket } from 'mysql2';
import cors from 'cors';


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

// Rota para obter lembretes
app.get('/vaccines', (req: Request, res: Response) => {
    const sql = "SELECT nome, data_inicio, data_final, idade_minima, idade_maxima FROM vacina ORDER BY data_inicio DESC";
    connection.query(sql, (error: QueryError | null, results: RowDataPacket[]) => {
        if (error) {
            console.error('Erro ao executar a consulta:', error.message);
            res.status(500).send('Erro ao obter os lembretes');
            return;
        }
        res.json(results);
    });
});

// Porta do servidor
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Servidor Node.js rodando na porta ${PORT}`);
});
