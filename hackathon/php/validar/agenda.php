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
    }
    
    if(isset($botaoVoltar)){
        echo "<script>window.location.href='cadastrar/idoso'</script>";
        exit;
    }
    // if(isset($botaoConfirmar)){
    //     mensagemSucesso("Credenciais enviadas com sucesso!");
    //     echo "<script>window.location.href='listar/vacina'</script>";
    //     exit;
    // }
?>