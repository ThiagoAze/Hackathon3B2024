<?php 
    //Informações do agendamento
    $dataAgend = $_POST['data-agend'] ?? NULL;
    $horarioAgend = $_POST['hora-agend'] ?? NULL;

    $botaoVoltar = $_POST['botao-voltar'] ?? NULL;
    $botaoConfirmar = $_POST['botao-confirmar'] ?? NULL;

    // Verificando se a data está para os dias atuais
    if(!empty($dataAgend)){
        $dataAtual = date('Y-m-d');
        if($dataAgend < $dataAtual){
            mensagemErro("Necessário agendar um dia atual");   
        }
        //Salvar no Session
//         $idNaoExiste = !isset($dadosDoBanco->id);
// 
//         $_SESSION["agenda"] = [
//             "data" => $dadosDoBanco->data,
//             "horario" => $dadosDoBanco->horario,
//         ];
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