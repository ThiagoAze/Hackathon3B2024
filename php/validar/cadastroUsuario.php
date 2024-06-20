<?php

    //Informações do idoso 
    $nomeIdoso = $_POST['nome-idoso'] ?? NULL;
    $dataNascimentoIdoso = $_POST['data-nascimento-idoso'] ?? NULL;
    $foneIdoso = $_POST['fone-idoso'] ?? NULL;
    $generoIdoso = $_POST['genero-idoso'] ?? NULL;
    $emailIdoso = $_POST['email-idoso'] ?? NULL;
    $cepIdoso = $_POST['cep-idoso'] ?? NULL;
    $enderecoIdoso = $_POST['endereco-idoso'] ?? NULL;
    $bairroIdoso = $_POST['bairro-idoso'] ?? NULL;
    $estadoIdoso = $_POST['estado-idoso'] ?? NULL;
    $numeroIdoso = $_POST['numero-idoso'] ?? NULL;
    $complementoIdoso = $_POST['complemento-idoso'] ?? NULL;
    $acompanhanteIdoso = $_POST['acompanhante-idoso'] ?? NULL;
    
    //Informações do acompanhante(caso selecionado)
    $nomeAcompanhante = $_POST['nome-acompanhante']  ?? NULL;
    $cpfAcompanhante = $_POST['cpf-acompanhante']  ?? NULL;
    $foneAcompanhante = $_POST['fone-acompanhante']  ?? NULL;
    $emailAcompanhante = $_POST['email-acompanhante']  ?? NULL;

    //Informações do agendamento
    $dataAgendamento = $_POST['data-agendamento'] ?? NULL;
    $horarioAgendamento = $_POST['horario-agendamento'] ?? NULL;

    // Botões de confirmações
    $botaoContinuar = $_POST['botao-continuar'] ?? NULL;
    $botaoCancelar = $_POST['botao-cancelar'] ?? NULL;
    $botaoVoltar = $_POST['botao-voltar'] ?? NULL;
    $botaoConfirmar = $_POST['botao-confirmar'] ?? NULL;

    if(isset($botaoContinuar)){
        echo "<script>window.location.href='cadastrar/agendamento'</script>";
        exit;
    }
    if(isset($botaoCancelar)){
        echo "<script>window.location.href='listar/vacina'</script>";
        exit;
    }
    if(isset($botaoVoltar)){
        echo "<script>window.location.href='cadastrar/idoso'</script>";
        exit;
    }
    if(isset($botaoConfirmar)){
        echo "<script>window.location.href='listar/vacina'</script>";
        exit;
    }

    


    

    
?>