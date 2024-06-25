<?php

    //Informações do idoso 
    $nomeIdoso = $_POST['nome-idoso'] ?? NULL;
    $cpfIdoso = $_POST['cpf-idoso'] ?? NULL;
    $dataNasciIdoso = $_POST['data-nasci-idoso'] ?? NULL;
    $foneIdoso = $_POST['telefone-idoso'] ?? NULL;
    $generoIdoso = $_POST['genero-idoso'] ?? NULL;
    $emailIdoso = $_POST['email-idoso'] ?? NULL;
    $acompanhanteIdoso = $_POST['acomp-idoso'] ?? NULL;

    //codigo get:
    /*$url = "localhost:3000/php/";
    $ch = curl_init($url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    
    $response = curl_exec($ch);
    curl_close($ch);
    $data = json_decode($response);
    echo $data->message;*/

    //Endereço do idoso
    $cepIdoso = $_POST['cep-idoso'] ?? NULL;
    $ruaIdoso = $_POST['rua-idoso'] ?? NULL;
    $cidadeIdoso = $_POST['cidade-idoso'] ?? NULL;
    $estadoIdoso = $_POST['estado-idoso'] ?? NULL;
    $numeroIdoso = $_POST['numero-idoso'] ?? NULL;
    $complementoIdoso = $_POST['comple-idoso'] ?? NULL;
    
    //Informações do acompanhante(caso selecionado)
    $nomeAcomp = $_POST['nome-acomp']  ?? NULL;
    $cpfAcomp = $_POST['cpf-acomp']  ?? NULL;
    $foneAcomp = $_POST['fone-acomp']  ?? NULL;
    $emailAcomp = $_POST['email-acomp']  ?? NULL;

    // Botões de confirmações
    $botaoContinuar = $_POST['botao-continuar'] ?? NULL;
    $botaoCancelar = $_POST['botao-cancelar'] ?? NULL;
    
    // Verificando apenas se o usuario não clicar em cancelar
    if(!isset($botaoCancelar)){
        // Se não clicar, verificando se  todos foram adicionados
        if(!empty($nomeIdoso && $dataNasciIdoso && $foneIdoso && $generoIdoso && $emailIdoso && $cepIdoso && $ruaIdoso && $cidadeIdoso && $estadoIdoso && $numeroIdoso && $acompanhanteIdoso)){

            if(!empty($dataNasciIdoso)){
                $dataAtual = date('Y-m-d');
                if($dataNasciIdoso > $dataAtual){
                    mensagemErro("Coloque sua data de nascimento corretamente");   
                }
            }

            // Verificando e formatando CPF do idoso
            if(is_numeric($cpfIdoso) && strlen($cpfIdoso) == 11){
                $cpfIdosoFormatado = mask($cpfIdoso, "###.###.###-##");
            } else{
                mensagemErro("CPF inválido (precisa conter apenas 11 números");
            }

            // Verificando e formatando telefone do idoso
            if(is_numeric($foneIdoso) && strlen($foneIdoso) == 11){
                $foneIdosoFormatado = mask($foneIdoso, "(##)#####-####");
            } else{
                mensagemErro("Telefone inválido (precisa conter apenas ddd e 9 digitos)");
            }

            // Verificando e formatando CEP do idoso
            if(is_numeric($cepIdoso) && strlen($cepIdoso) == 8){
                $cepIdosoFormatado = mask($cepIdoso, "#####-###");
            } else{
                mensagemErro("CEP inválido (precisa conter 8 números)");
            }

            // Verificando número de residencia do idoso
            if(!is_numeric($numeroIdoso)){
                mensagemErro("Número inválido(Precisa conter apenas números)");
            }

            // Verificando e formatando caso tenha acompanhante
            if($acompanhanteIdoso == 'sim'){
                if(!empty($nomeAcomp && $cpfAcomp && $foneAcomp && $emailAcomp)){
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
                } else{
                    mensagemErro("Necessário preencher todos os campos de acompanhante");
                }
                
            } else{ //Caso não tenha acompanhante
                mensagemAviso('Caso tenha certeza, apenas clique em Continue');
            }

//             $idNaoExiste = !isset($dadosDoBanco->id);
// 
//             if($idNaoExiste){
//                 $_SESSION["idoso"] = [
//                     "id" => $dadosDoBanco->id,
//                     "nome" => $dadosDoBanco->nome,
//                     "cpf" => $dadosDoBanco->cpf,
//                     "dataNascimento" => $dadosDoBanco->dataNascimento,
//                     "telefone" => $dadosDoBanco->telefone,
//                     "genero" => $dadosDoBanco->genero,
//                     "email" => $dadosDoBanco->email,
//                     "acompanhante" => $dadosDoBanco->acompanhante,
//                 ];
//                 $_SESSION["agenda"] = [
//                     "cep" => $dadosDoBanco->cep,
//                     "rua" => $dadosDoBanco->rua,
//                     "cidade" => $dadosDoBanco->cidade,
//                     "estado" => $dadosDoBanco->estado,
//                     "numero" => $dadosDoBanco->numero,
//                     "complemento" => $dadosDoBanco->complemento,
//                 ];
//                 $_SESSION["acompanhante"] = [
//                     "nomeAcomp" => $dadosDoBanco->nomeAcomp,
//                     "cpfAcomp" => $dadosDoBanco->cpfAcomp,
//                     "telefoneAcomp" => $dadosDoBanco->telefoneAcomp,
//                     "emailAcomp" => $dadosDoBanco->emailAcomp,
//                 ];
//             }
            $url = "localhost:3000/usuario";
            $ch = curl_init($url);
            $dadosIdosoCadastrar = array(
                'nome' => $nomeIdoso,
                'cpf' => $cpfIdosoFormatado,
                'dataNascimento' => $dataNasciIdoso,
                'telefone' => $foneIdosoFormatado,
                'email' => $emailIdoso,
                'senha' => null,
                'genero' => $generoIdoso,
            );
            curl_setopt_array($ch, [
                CURLOPT_RETURNTRANSFER => true,
                CURLOPT_POST => true,
                CURLOPT_POSTFIELDS => json_encode($dadosIdosoCadastrar),
                CURLOPT_HTTPHEADER => ['Content-Type: application/json'],
                CURLOPT_CUSTOMREQUEST => "POST"
            ]);
            $response = curl_exec($ch);

            $data = json_decode($response);
            echo $data->message;
            //echo "<script>location.href='cadastrar/agendamento'</script>";
            //exit;
            //se tudo der certo, fazer uma busca do id no banco
            

        } else{
            mensagemErro("Necessário preencher todos os campos");
        } 
    }

    if(isset($botaoContinuar)){
        //echo "<script>location.href='cadastrar/agendamento';</script>";
        //exit;
    }
    if(isset($botaoCancelar)){
        //echo "<script>location.href='listar/vacina';</script>";
        //exit;
    }
?>