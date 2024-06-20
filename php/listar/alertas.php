
    <div class="container">
        <h1 class="aviso">Avisos e Lembretes</h1>

        <!-- Lista  -->
        <div class="lembretes">
            <?php
            // Conexão com o banco de dados
            $dsn = 'mysql:host=localhost;dbname=vacinet';
            $username = 'root';
            $password = '';

            try {
                $pdo = new PDO($dsn, $username, $password);
                $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

                // Consulta
                $sql = "SELECT nome, data_inicio, data_final, idade_minima, idade_maxima FROM vacina ORDER BY data_inicio DESC";
                $stmt = $pdo->query($sql);
                $lembretes = $stmt->fetchAll(PDO::FETCH_ASSOC);

                if (!empty($lembretes)) {
                    foreach ($lembretes as $lembrete) {
                        // Obtém a data de início da vacina do banco de dados
                        $dataInicio = new DateTime($lembrete['data_inicio']);
                        // Obtém a data atual
                        $dataAtual = new DateTime();
                        // Calcula a diferença entre as datas
                        $intervalo = $dataAtual->diff($dataInicio);

                        // Determina a mensagem baseada no intervalo
                        if ($intervalo->y > 0) {
                            $mensagem = "lançado há " . $intervalo->y . " ano(s)";
                        } elseif ($intervalo->m > 0) {
                            $mensagem = "lançado há " . $intervalo->m . " mês(es)";
                        } elseif ($intervalo->d > 7) {
                            $semanas = floor($intervalo->d / 7);
                            $mensagem = "lançado há " . $semanas . " semana(s)";
                        } elseif ($intervalo->d > 0) {
                            $mensagem = "lançado há " . $intervalo->d . " dia(s)";
                        } else {
                            $mensagem = "lançado hoje";
                        }

                        // Exibe o lembrete com a mensagem calculada
                        echo "<div class='lembrete'>";
                        echo "<h3>{$lembrete['nome']}</h3>";
                        echo "<div class='info'>$mensagem</div>"; 
                        echo "<p><strong>Data de Inicio:</strong> {$lembrete['data_inicio']}</p>";
                        echo "<p><strong>Data Final:</strong> {$lembrete['data_final']}</p>";
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
