import express, { Request, Response } from 'express';
import mysql, { Connection, QueryError, RowDataPacket } from 'mysql2';
import cors from 'cors';

const app = express();

app.use(cors());
app.use(express.json()); // Para habilitar o parser de JSON no body das requisições

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

// Rota para registrar dados de agendamento
app.post('/api/register', (req: Request, res: Response) => {
    const {
        nomeIdoso,
        cpfIdoso,
        dataNascimentoIdoso,
        foneIdoso,
        generoIdoso,
        emailIdoso,
        cepIdoso,
        ruaIdoso,
        bairroIdoso,
        estadoIdoso,
        numeroIdoso,
        complementoIdoso,
        acompanhanteIdoso,
        nomeAcomp,
        cpfAcomp,
        foneAcomp,
        emailAcomp,
        dataAgendamento,
        horarioAgendamento
    } = req.body;

    const sql = `
        INSERT INTO agendamentos (
            nomeIdoso,
            cpfIdoso,
            dataNascimentoIdoso,
            foneIdoso,
            generoIdoso,
            emailIdoso,
            cepIdoso,
            ruaIdoso,
            bairroIdoso,
            estadoIdoso,
            numeroIdoso,
            complementoIdoso,
            acompanhanteIdoso,
            nomeAcomp,
            cpfAcomp,
            foneAcomp,
            emailAcomp,
            dataAgendamento,
            horarioAgendamento
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    `;

    const values = [
        nomeIdoso,
        cpfIdoso,
        dataNascimentoIdoso,
        foneIdoso,
        generoIdoso,
        emailIdoso,
        cepIdoso,
        ruaIdoso,
        bairroIdoso,
        estadoIdoso,
        numeroIdoso,
        complementoIdoso,
        acompanhanteIdoso,
        nomeAcomp,
        cpfAcomp,
        foneAcomp,
        emailAcomp,
        dataAgendamento,
        horarioAgendamento
    ];

    connection.query(sql, values, (error: QueryError | null, results: RowDataPacket[]) => {
        if (error) {
            console.error('Erro ao registrar dados:', error.message);
            res.status(500).send('Erro ao registrar dados');
            return;
        }
        res.status(201).send({ message: 'Dados registrados com sucesso!' });
    });
});

// Rota para registrar dados de usuário
app.post('/api/registrarUsuario', (req: Request, res: Response) => {
    const {
        nomeIdoso,
        cpfIdoso,
        dataNasciIdoso,
        foneIdoso,
        generoIdoso,
        emailIdoso,
        cepIdoso,
        ruaIdoso,
        bairroIdoso,
        estadoIdoso,
        numeroIdoso,
        complementoIdoso,
        acompanhanteIdoso,
        nomeAcomp,
        cpfAcomp,
        foneAcomp,
        emailAcomp
    } = req.body;

    const sql = `
        INSERT INTO agendamentos (
            nomeIdoso,
            cpfIdoso,
            dataNascimentoIdoso,
            foneIdoso,
            generoIdoso,
            emailIdoso,
            cepIdoso,
            ruaIdoso,
            bairroIdoso,
            estadoIdoso,
            numeroIdoso,
            complementoIdoso,
            acompanhanteIdoso,
            nomeAcomp,
            cpfAcomp,
            foneAcomp,
            emailAcomp
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    `;

    const values = [
        nomeIdoso,
        cpfIdoso,
        dataNasciIdoso,
        foneIdoso,
        generoIdoso,
        emailIdoso,
        cepIdoso,
        ruaIdoso,
        bairroIdoso,
        estadoIdoso,
        numeroIdoso,
        complementoIdoso,
        acompanhanteIdoso,
        nomeAcomp,
        cpfAcomp,
        foneAcomp,
        emailAcomp
    ];

    connection.query(sql, values, (error: QueryError | null, results: RowDataPacket[]) => {
        if (error) {
            console.error('Erro ao registrar usuário:', error.message);
            res.status(500).send('Erro ao registrar usuário');
            return;
        }
        res.status(201).send({ message: 'Usuário registrado com sucesso!' });
    });
});

// Porta do servidor
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Servidor Node.js rodando na porta ${PORT}`);
});
