<?php

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Dados recebidos do cadastrarUsuario.php
    $nomeIdoso = $_POST['nomeIdoso'] ?? '';
    $cpfIdoso = $_POST['cpfIdoso'] ?? '';
    $dataNascimentoIdoso = $_POST['dataNascimentoIdoso'] ?? '';
    $foneIdoso = $_POST['foneIdoso'] ?? '';
    $generoIdoso = $_POST['generoIdoso'] ?? '';
    $emailIdoso = $_POST['emailIdoso'] ?? '';
    $cepIdoso = $_POST['cepIdoso'] ?? '';
    $ruaIdoso = $_POST['ruaIdoso'] ?? '';
    $bairroIdoso = $_POST['bairroIdoso'] ?? '';
    $estadoIdoso = $_POST['estadoIdoso'] ?? '';
    $numeroIdoso = $_POST['numeroIdoso'] ?? '';
    $complementoIdoso = $_POST['complementoIdoso'] ?? '';
    $acompanhanteIdoso = $_POST['acompanhanteIdoso'] ?? '';
    $nomeAcomp = $_POST['nomeAcomp'] ?? '';
    $cpfAcomp = $_POST['cpfAcomp'] ?? '';
    $foneAcomp = $_POST['foneAcomp'] ?? '';
    $emailAcomp = $_POST['emailAcomp'] ?? '';

    // URL da API Node.js para registrar os dados
    $url = 'http://localhost:3000/api/register'; // Ajuste conforme a sua configuração

    // Dados a serem enviados para a API Node.js
    $data = array(
        'nomeIdoso' => $nomeIdoso,
        'cpfIdoso' => $cpfIdoso,
        'dataNascimentoIdoso' => $dataNascimentoIdoso,
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

    // Configuração do POST request para a API Node.js
    $options = array(
        'http' => array(
            'header' => "Content-Type: application/json\r\n",
            'method' => 'POST',
            'content' => json_encode($data)
        )
    );

    // Realiza o POST request para a API Node.js
    $context = stream_context_create($options);
    $result = file_get_contents($url, false, $context);

    // Verifica se a requisição foi bem-sucedida
    if ($result === false) {
        // Tratamento de erro ao fazer o request
        echo "Erro ao enviar dados para a API Node.js.";
    } else {
        // Exibe mensagem de sucesso ou redireciona para próxima etapa
        echo "Dados enviados para a API Node.js com sucesso!";
        // Exemplo de redirecionamento após o cadastro
        // header("Location: proxima-etapa.php");
        // exit;
    }
}

?>
