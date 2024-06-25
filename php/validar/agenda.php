<?php 
    //Informações do agendamento
    $dataAgend = $_POST['data-agend'] ?? NULL;
    $periodoAgend = $_POST['periodo-agend'] ?? NULL;

    $botaoVoltar = $_POST['botao-voltar'] ?? NULL;
    $botaoConfirmar = $_POST['botao-confirmar'] ?? NULL;

    // Verificando se a data está para os dias atuais
    if(!empty($dataAgend)){
        $dataAtual = date('Y-m-d');
        if($dataAgend < $dataAtual){
            mensagemErro("Necessário agendar um dia atual");   
        }

        //Passando rota POST para o node
        $url = "localhost:3000/agenda";
        $ch = curl_init($url);
        $dadosAgendaCadastrar = array(
            'data' => $dataAgend,
            'periodo' => $periodoAgend,
        );
        curl_setopt_array($ch, [
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => json_encode($dadosAgendaCadastrar),
            CURLOPT_HTTPHEADER => ['Content-Type: application/json'],
            CURLOPT_CUSTOMREQUEST => "POST"
        ]);
        $response = curl_exec($ch);
        $data = json_decode($response);
        curl_close($ch);
    }
    
    if(isset($botaoVoltar)){
        echo "<script>location.href='cadastrar/idoso'</script>";
        exit;
    }
    if(isset($botaoConfirmar)){
        mensagemSucesso("Credenciais enviadas com sucesso!");
        echo "<script>location.href='listar/vacina'</script>";
        exit;
    }
?>