<div class="container">
        <h1 class="aviso">Avisos e Lembretes</h1>

        <!-- Lista de lembretes -->
        <div class="lembretes" id="lembretes-container">
            <!-- Os lembretes serão carregados aqui via JavaScript -->
        </div>
    </div>

    <script>
        // Função para carregar dados via AJAX
        function carregarLembretes() {
            var xhr = new XMLHttpRequest();

            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        var data = JSON.parse(xhr.responseText);
                        var lembretesContainer = document.getElementById('lembretes-container');

                        // Limpar o conteúdo antes de adicionar novos lembretes
                        lembretesContainer.innerHTML = '';

                        if (data.length > 0) {
                            data.forEach(lembrete => {
                                var dataInicio = new Date(lembrete.data_inicio);
                                var dataAtual = new Date();
                                var diffTime = Math.abs(dataAtual - dataInicio);
                                var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
                                var mensagem;
                                if (diffDays > 0) {
                                    mensagem = `lançado há ${diffDays} dia(s)`;
                                } else {
                                    mensagem = `lançado hoje`;
                                }

                                lembretesContainer.innerHTML += `
                                    <div class="lembrete">
                                        <h3>${lembrete.nome}</h3>
                                        <p><strong>Data de Início:</strong> ${lembrete.data_inicio}</p>
                                        <p><strong>Data Final:</strong> ${lembrete.data_final}</p>
                                        <p><strong>Idade Mínima:</strong> ${lembrete.idade_minima}</p>
                                        <p><strong>Idade Máxima:</strong> ${lembrete.idade_maxima}</p>
                                        <p><strong>Status:</strong> ${mensagem}</p>
                                    </div>
                                `;
                            });
                        } else {
                            lembretesContainer.innerHTML = `<p>Nenhum lembrete de vacina encontrado.</p>`;
                        }
                    } else {
                        console.error('Erro ao carregar dados:', xhr.status);
                        document.getElementById('lembretes-container').innerHTML = `<p>Erro ao carregar dados.</p>`;
                    }
                }
            };

            xhr.open('GET', 'http://localhost:3000/vaccines'); // Ajuste o URL para o seu servidor Node.js
            xhr.send();
        }

        // Chamar a função para carregar os lembretes ao carregar a página
        window.onload = carregarLembretes;
    </script>
