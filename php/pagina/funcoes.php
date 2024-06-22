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
            text: '<?=$msgErro?>',
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