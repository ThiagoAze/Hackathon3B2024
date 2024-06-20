<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Avisos de Vacinas</title>
    <link rel="stylesheet" href="css/alertas.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: red;
        }

        .lembretes {
            margin-top: 20px;
        }

        .lembrete {
            background-color: #f9f9f9;
            padding: 15px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .lembrete h3 {
            margin-top: 0;
            color: #333;
            font-size: 1.2em;
        }

        .lembrete p {
            margin-bottom: 5px;
            color: #666;
        }

        .lembrete p strong {
            color: #333;
        }

        @media (max-width: 600px) {
            .container {
                width: 95%;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>Avisos e Lembretes</h1>

        <!-- Lista  -->
        <div class="lembretes">
            <?php
            // Conexão com o banco de dados
            $dsn = 'mysql:host=localhost;dbname=vacinet';
            $username = 'root';
            $password = '';
            //try catch feito caso não consiga conectar ao banco
            try {
                $pdo = new PDO($dsn, $username, $password);
                $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

                // Consulta para obter lembretes de vacina do banco de dados
                $sql = "SELECT nome, data_inicio, data_final, idade_minima, idade_maxima FROM vacina ORDER BY data_inicio DESC";
                $stmt = $pdo->query($sql);
                $lembretes = $stmt->fetchAll(PDO::FETCH_ASSOC);
                // Foi feito um If/Else para casa não haver nenhum lembrete de vacinar
                if (!empty($lembretes)) {
                    foreach ($lembretes as $lembrete) {
                        echo "<div class='lembrete'>";
                        echo "<h3>{$lembrete['nome']}</h3>";
                        echo "<p><strong>Data de Inicio:</strong> {$lembrete['data_inicio']}</p>";
                        echo "<p><strong>Data Final:</strong> {$lembrete['data_final']}</p>"; //Strong é usado para deixar o texto em negrito
                        echo "<p><strong>Idade Minima:</strong> {$lembrete['idade_minima']}</p>";
                        echo "<p><strong>Idade Maxima:</strong> {$lembrete['idade_maxima']}</p>";
                        echo "</div>";
                    }
                } else {
                    echo "<p>Nenhum lembrete de vacina encontrado.</p>";
                }

            } catch (PDOException $e) {
                die("Erro ao conectar ao banco de dados: " . $e->getMessage());
            }
            ?>
        </div>
    </div>
</body>

</html>