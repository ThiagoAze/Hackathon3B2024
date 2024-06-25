<?php
    //função para máscara
    function mask($val, $mask){
        $maskared = '';
        $k = 0;
        for ($i = 0; $i <= strlen($mask) - 1; ++$i) {
            if ($mask[$i] == '#') {
                if (isset($val[$k])) {
                    $maskared .= $val[$k++];
                }
            } else {
                if (isset($mask[$i])) {
                    $maskared .= $mask[$i];
                }
            }
        }
        return $maskared;
        exit;
    }

    // Função de mensagem de erro
    function mensagemErro($msgErro) {
        ?>
        <script>
            Swal.fire({
            icon: 'error',
            title: 'Ocorreu um problema',
            text: '<?=$msgErro?>'
            }).then((result) => {
                history.back(); 
            })
        </script>
        <?php
        exit;
    }

    // Função de mensagem de sucesso
    function mensagemSucesso($msgSucesso){
        ?>
        <script>
        Swal.fire({
            icon: 'success',
            title: 'Tudo certo!',
            text: '<?=$msgSucesso?>',
        }).then((result) => {
                location.href='listar/vacina'
            })
        </script>
        <?php 
        exit;
    }

    // Função de mensagem de aviso
    function mensagemAviso($msgAviso){
        ?>
        <script>
        Swal.fire({
            title: 'Você não escolheu nenhum acompanhante, tem certeza da sua escolha?',
            text: '<?=$msgAviso?>',
            type: 'warning',
            icon: 'warning',
            confirmButtonColor: 'green',
            cancelButtonColor: 'red',
            showCancelButton: true,
            confirmButtonText: 'Continue',
            cancelButtonText: 'Gostaria de um acompanhante'
        }).then((result) =>{
            if(result.value){
                swal('Certo!', 'Direcionando para Agendamento', 'success', location.href='cadastrar/agendamento')
            }else{
                location.href='cadastrar/idoso'
            }
        });
        </script>
        <?php
        exit;
    }

    function cadastroAcompanhante($nomeIdoso, $cpfIdosoFormatado, $foneIdosoFormatado, $emailIdoso){
        // Rota POST para banco acompanhante
            $url = "localhost:3000/acompanhante";
            $ch = curl_init($url);
            $dadosAcompCadastrar = array(
                'nome' => $nomeIdoso,
                'cpf' => $cpfIdosoFormatado,
                'telefone' => $foneIdosoFormatado,
                'email' => $emailIdoso,
                'senha' => "",
            );
            curl_setopt_array($ch, [
                CURLOPT_RETURNTRANSFER => true,
                CURLOPT_POST => true,
                CURLOPT_POSTFIELDS => json_encode($dadosAcompCadastrar),
                CURLOPT_HTTPHEADER => ['Content-Type: application/json'],
                CURLOPT_CUSTOMREQUEST => "POST"
            ]);
            $response = curl_exec($ch);
            print_r($response);
            $data = json_decode($response);
            curl_close($ch);
    }