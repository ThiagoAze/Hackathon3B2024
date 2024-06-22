<?php


// Função para exibir mensagens de aviso

// Verificar se o formulário foi submetido
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Informações do idoso
    $nomeIdoso = $_POST['nome-idoso'] ?? '';
    $cpfIdoso = $_POST['cpf-idoso'] ?? '';
    $dataNasciIdoso = $_POST['data-nasci-idoso'] ?? '';
    $foneIdoso = $_POST['fone-idoso'] ?? '';
    $generoIdoso = $_POST['genero-idoso'] ?? '';
    $emailIdoso = $_POST['email-idoso'] ?? '';
    $cepIdoso = $_POST['cep-idoso'] ?? '';
    $ruaIdoso = $_POST['rua-idoso'] ?? '';
    $bairroIdoso = $_POST['bairro-idoso'] ?? '';
    $estadoIdoso = $_POST['estado-idoso'] ?? '';
    $numeroIdoso = $_POST['numero-idoso'] ?? '';
    $complementoIdoso = $_POST['complemento-idoso'] ?? '';
    $acompanhanteIdoso = $_POST['acompanhante-idoso'] ?? '';

    // Informações do acompanhante (caso selecionado)
    $nomeAcomp = $_POST['nome-acompanhante'] ?? '';
    $cpfAcomp = $_POST['cpf-acompanhante'] ?? '';
    $foneAcomp = $_POST['fone-acompanhante'] ?? '';
    $emailAcomp = $_POST['email-acompanhante'] ?? '';

    // Botões de confirmação
    $botaoContinuar = $_POST['botao-continuar'] ?? NULL;
    $botaoCancelar = $_POST['botao-cancelar'] ?? NULL;
    
    // Verificar se o botão de cancelar não foi clicado
    if (!isset($botaoCancelar)) {
        // Verificar se todos os campos obrigatórios foram preenchidos
        if (!empty($nomeIdoso) && !empty($dataNasciIdoso) && !empty($foneIdoso) && !empty($generoIdoso) && !empty($emailIdoso) && !empty($cepIdoso) && !empty($ruaIdoso) && !empty($bairroIdoso) && !empty($estadoIdoso) && !empty($numeroIdoso) && !empty($acompanhanteIdoso)) {

            // Verificar e formatar CPF do idoso
            if (is_numeric($cpfIdoso) && strlen($cpfIdoso) == 11) {
                $cpfIdosoFormatado = mask($cpfIdoso, "###.###.###-##");
            } else {
                mensagemErro("CPF inválido (precisa conter apenas 11 números)");
            }

            // Verificar e formatar telefone do idoso
            if (is_numeric($foneIdoso) && strlen($foneIdoso) == 11) {
                $foneIdosoFormatado = mask($foneIdoso, "(##)#####-####");
            } else {
                mensagemErro("Telefone inválido (precisa conter ddd e 9 dígitos)");
            }

            // Verificar e formatar CEP do idoso
            if (is_numeric($cepIdoso) && strlen($cepIdoso) == 8) {
                $cepIdosoFormatado = mask($cepIdoso, "#####-###");
            } else {
                mensagemErro("CEP inválido (precisa conter 8 dígitos)");
            }

            // Verificar e formatar caso tenha acompanhante
            if ($acompanhanteIdoso == 'sim') {
                if (is_numeric($cpfAcomp) && strlen($cpfAcomp) == 11) {
                    $cpfAcompFormatado = mask($cpfAcomp, "###.###.###-##");
                } else {
                    mensagemErro("CPF do acompanhante inválido (precisa conter apenas 11 números)");
                }

                if (is_numeric($foneAcomp) && strlen($foneAcomp) == 11) {
                    $foneAcompFormatado = mask($foneAcomp, "(##)#####-####");
                } else {
                    mensagemErro("Telefone do acompanhante inválido (precisa conter ddd e 9 dígitos)");
                }
            } else {
                mensagemAviso('Caso tenha certeza, apenas clique em Continue');
            }

            // Se tudo estiver correto, enviar os dados para registrarUsuario.php via POST

            // URL para onde os dados serão enviados
            $url = 'http://localhost/registrarUsuario.php'; // Ajuste conforme sua configuração

            // Dados a serem enviados para registrarUsuario.php
            $data = array(
                'nomeIdoso' => $nomeIdoso,
                'cpfIdoso' => $cpfIdoso,
                'dataNascimentoIdoso' => $dataNasciIdoso,
                'foneIdoso' => $foneIdoso,
                'generoIdoso' => $generoIdoso,
                'emailIdoso' => $emailIdoso,
                'cepIdoso' => $cepIdoso,
                'ruaIdoso' => $ruaIdoso,
                'bairroIdoso' => $bairroIdoso,
                'estadoIdoso' => $estadoIdoso,
                'numeroIdoso' => $numeroIdoso,
                'complementoIdoso' => $complementoIdoso,
                'acompanhanteIdoso' => $acompanhanteIdoso,
                'nomeAcomp' => $nomeAcomp,
                'cpfAcomp' => $cpfAcomp,
                'foneAcomp' => $foneAcomp,
                'emailAcomp' => $emailAcomp
            );

            // Configuração do POST request para registrarUsuario.php
            $options = array(
                'http' => array(
                    'header' => "Content-Type: application/x-www-form-urlencoded\r\n",
                    'method' => 'POST',
                    'content' => http_build_query($data)
                )
            );

            // Realiza o POST request para registrarUsuario.php
            $context = stream_context_create($options);
            $result = file_get_contents($url, false, $context);

            // Verifica se a requisição foi bem-sucedida
            if ($result === false) {
                // Tratamento de erro ao fazer o request
                mensagemErro("Erro ao enviar dados para registrarUsuario.php.");
            } else {
                // Exibe mensagem de sucesso ou redireciona para próxima etapa
                echo "Dados enviados para registrarUsuario.php com sucesso!";
                // Exemplo de redirecionamento após o cadastro
                // header("Location: proxima-etapa.php");
                // exit;
            }

        } else {
            mensagemErro("Necessário preencher todos os campos obrigatórios.");
        }
    }

    // if(isset($botaoContinuar)){
    //     echo "<script>window.location.href='cadastrar/agendamento?<?php echo htmlspecialchars(SID);'</script>";
    //     exit;
    // }
    // if(isset($botaoCancelar)){
    //     echo "<script>window.location.href='listar/vacina'</script>";
    //     exit;
    // }
}
?>
