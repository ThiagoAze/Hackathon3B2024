import express, { Request, Response } from 'express';
import mysql, { Connection, FieldPacket, QueryOptions, QueryError, RowDataPacket } from 'mysql2';
import cors from 'cors';

import Routes from './routes';

const app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }))

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
app.use(Routes);



// Porta do servidor
const PORT = 3000;
app.listen(PORT, () => {
    console.log("Servidor Node.js rodando na porta ${PORT}");
});