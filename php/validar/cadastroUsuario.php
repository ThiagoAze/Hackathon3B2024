<?php

    //Informações do idoso 
    $nomeIdoso = $_POST['nome-idoso'] ?? NULL;
    $cpfIdoso = $_POST['cpf-idoso'] ?? NULL;
    $dataNascimentoIdoso = $_POST['data-nascimento-idoso'] ?? NULL;
    $foneIdoso = $_POST['fone-idoso'] ?? NULL;
    $generoIdoso = $_POST['genero-idoso'] ?? NULL;
    $emailIdoso = $_POST['email-idoso'] ?? NULL;
    $cepIdoso = $_POST['cep-idoso'] ?? NULL;
    $ruaIdoso = $_POST['rua-idoso'] ?? NULL;
    $bairroIdoso = $_POST['bairro-idoso'] ?? NULL;
    $estadoIdoso = $_POST['estado-idoso'] ?? NULL;
    $numeroIdoso = $_POST['numero-idoso'] ?? NULL;
    $complementoIdoso = $_POST['complemento-idoso'] ?? NULL;
    $acompanhanteIdoso = $_POST['acompanhante-idoso'] ?? NULL;

    //Informações do acompanhante(caso selecionado)
    $nomeAcomp = $_POST['nome-acompanhante']  ?? NULL;
    $cpfAcomp = $_POST['cpf-acompanhante']  ?? NULL;
    $foneAcomp = $_POST['fone-acompanhante']  ?? NULL;
    $emailAcomp = $_POST['email-acompanhante']  ?? NULL;

    //Informações do agendamento
    $dataAgendamento = $_POST['data-agendamento'] ?? NULL;
    $horarioAgendamento = $_POST['horario-agendamento'] ?? NULL;

    // Botões de confirmações
    $botaoContinuar = $_POST['botao-continuar'] ?? NULL;
    $botaoCancelar = $_POST['botao-cancelar'] ?? NULL;
    $botaoVoltar = $_POST['botao-voltar'] ?? NULL;
    $botaoConfirmar = $_POST['botao-confirmar'] ?? NULL;

    // Verificando apenas se o usuario não clicar em cancelar
    if(empty($botaoCancelar)){
        // Se não clicar, verificando se  todos foram adicionados
        if(!empty($nomeIdoso && $dataNascimentoIdoso && $foneIdoso && $generoIdoso && $emailIdoso && $cepIdoso && $enderecoIdoso && $bairroIdoso && $estadoIdoso && $numeroIdoso && $complementoIdoso && $acompanhanteIdoso)){

            // Verificando e formatando CPF do idoso
            if(is_numeric($cpfIdoso) && strlen($cpfIdoso) == 11){
                $cpfIdosoFormatado = mask($cpfIdoso, "###.###.###-##");
            } else{
                mensagemErro("CPF inválido (precisa conter apenas 11 números");
            }

            // Verificando e formatando telefone
            if(is_numeric($foneIdoso) && strlen($foneIdoso) == 11){
                $foneIdosoFormatado = mask($foneIdoso, "(##)#####-####");
            } else{
                mensagemErro("Telefone inválido (precisa conter ddd e 9 digitos)");
            }

            // Verificando e formatando CEP
            if(is_numeric($cepIdoso) && strlen($cepIdoso) == 8){
                $cepIdosoFormatado = mask($cepIdoso, "#####-###");
            } else{
                mensagemErro("CEP inválido (precisa conter 8 números)");
            }

            // Verificando e formatando caso tenha acompanhante
            if($acompanhanteIdoso == 'sim'){
                if(is_numeric($cpfAcomp) && strlen($cpfAcomp) == 11){
                    $cpfAcompFormatado = mask($cpfAcomp, "###.###.###-##");
                } else{
                    mensagemErro("CPF inválido (precisa conter apenas 11 números");
                }

                if(is_numeric($foneAcomp) && strlen($foneAcomp) == 11){
                    $foneAcompFormatado = mask($foneAcomp, "(##)#####-####");
                } else{
                    mensagemErro("Telefone inválido (precisa conter ddd e 9 digitos)");
                }
            } else{ //Caso não tenha acompanhante
                mensagemAviso('Caso tenha certeza, apenas clique em Continue');
            }

            // Verificando se a data está para os dias atuais
            $dataAgendamento = date('d/m/y');
            if($dataAgendamento){
                $dataAtual = date('d/m/y');
                if(strtotime($dataAgendamento) < strtotime($dataAtual)){
                    mensagemErro("Necessário agendar um dia atual");
                }
            }
        } mensagemErro("Necessário preencher todos os campos");
    }

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
        mensagemSucesso("Credenciais enviadas com sucesso!");
        echo "<script>window.location.href='listar/vacina'</script>";
        exit;
    }

?>