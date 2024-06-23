<?php

    
    ?>
    <script>
        //Usar Ajax para coletar automaticamente os dados(com a API node) caso o CPF tenha 11 caracteres exista
        //Se o CPF estiver cadastrado, buscar todos os dados mais o ID

        //Quando o idoso colocar seu cpf, buscar no banco e autoincrementar nos inputs
//         $(document).ready(function(){
//             $("input[name ='cpf-idoso']").change(function(){
//                 var $nomeIdoso = $("input[name ='nome-idoso'")
//                 var $dataNasciIdoso = $("input[name = 'data-nasci-idoso']")
//                 var $foneIdoso = $("input[name = 'fone-idoso']")
//                 var $generoIdoso = $("select[name = 'genero-idoso']")
//                 var $emailIdoso = $("input[name = 'email-idoso'")
//                 var $acompIdoso = $("input[name = 'acamp-idoso']")
//                 var $cepidoso = $("input[name = 'cep-idoso']")
//                 var $ruaIdoso = $("input[name = 'rua-idoso']")
//                 var $bairroIdoso = $("input[name = 'bairro-idoso']")
//                 var $estadoIdoso = $("input[name = 'estado-idoso']")
//                 var $numeroIdoso = $("input[name = 'numero-idoso']")
//                 var $complementoIdoso = $("input[name = 'comple-idoso']")
//                 var $nomeAcomp = $("input[name = 'nome-acomp']")
//                 var $cpfAcomp = $("input[name = 'cpf-acomp']")
//                 var $foneAcomp = $("input[name = 'fone-acomp']")
//                 var $emailAcomp = $("input[name = 'email-acomp']")
// 
//                 $nomeIdoso.val('Carregando...')
//                 $foneIdoso.val('Carregando...')
//                 $generoIdoso.val('Carregando...')
//                 $emailIdoso.val('Carregando...')
//                 $cepidoso.val('Carregando...')
//                 $ruaIdoso.val('Carregando...')
//                 $bairroIdoso.val('Carregando...')
//                 $estadoIdoso.val('Carregando...')
//                 $numeroIdoso.val('Carregando...')
//                 $complementoIdoso.val('Carregando...')
//                 $nomeAcomp.val('Carregando...')
//                 $cpfAcomp.val('Carregando...')
//                 $foneAcomp.val('Carregando...')
//                 $emailAcomp.val('Carregando...')
//                 
//                 $.getJSON(
//                     'busca.php',
//                     { cpf: $(this).val() },
//                     function(json){
//                         $nomeIdoso.val(json.nomeIdoso)
//                         $foneIdoso.val(json.foneIdoso)
//                         $generoIdoso.val(json.generoIdoso)
//                         $emailIdoso.val(json.emailIdoso)
//                         $cepidoso.val(json.cepidoso)
//                         $ruaIdoso.val(json.ruaIdoso)
//                         $bairroIdoso.val(json.bairroIdoso)
//                         $estadoIdoso.val(json.estadoIdoso)
//                         $numeroIdoso.val(json.numeroIdoso)
//                         $complementoIdoso.val(json.complementoIdoso)
//                         $nomeAcomp.val(json.nomeAcomp)
//                         $cpfAcomp.val(json.cpfAcomp)
//                         $foneAcomp.val(json.foneAcomp)
//                         $emailAcomp.val(json.emailAcomp)
//                     }
//                 )
//             })
//         })
//     </script>

    <?php 
    if(!empty($cpfIdoso)){
        if(isset($cpfIdoso) && is_numeric($cpfIdoso) && strlen($cpfIdoso) == 11){
            

            $_SESSION["usuario"] = [
                "id" => $dadosDoBanco->id,
                "nome" => $dadosDoBanco->nome,
                "cpf" => $dadosDoBanco->cpf,
                "dataNascimento" => $dadosDoBanco->dataNascimento,
                "genero" => $dadosDoBanco->genero,
                "acomp" => $dadosDoBanco->acomp,
                "cep" => $dadosDoBanco->cep,
                "endereco" => $dadosDoBanco->endereco,
                "bairro" => $dadosDoBanco->bairro,
                "estado" => $dadosDoBanco->estado,
                "numero" => $dadosDoBanco->numero,
                "complemento" => $dadosDoBanco->complemento,
                "nomeAcomp" => $dadosDoBanco->nomeAcomp,
                "cpfAcomp" => $dadosDoBanco->cpfAcomp,
                "foneAcomp" => $dadosDoBanco->foneAcomp,
                "emailAcomp" => $dadosDoBanco->emailAcomp,
            ];
        } else{
            mensagemErro("CPF inválido (precisa conter apenas 11 números");
        }
    }
    
?>

<div class="form-idoso">
    <div class="logo">Vacinet</div>
    <h1>Registre-se para uma maior qualidade de vida</h1>

    <form action="validar/cadastroUsuario" method="POST">

        <div class="row">
            <div class="col">
                <label for="nome-idoso">Nome:</label>
                <input type="text" name="nome-idoso" require id="nome-idoso" class="form-control" value="<?=$dadosDoBanco->nome ?? NULL?>"  placeholder="Digite seu nome completo">
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col">
                <label for="cpf-idoso">CPF: <strong>(Priorize-o caso já tenha se cadastrado)</strong></label>
                <input type="text" name="cpf-idoso" require id="cpf-idoso" class="form-control" value="<?=$dadosDoBanco->cpf ?? NULL?>" placeholder="999.999.999-99">
            </div>
            <div class="col">
                <label for="data-nasci-idoso">Data de Nascimento:</label>
                <input type="date" name="data-nasci-idoso" require id="data-nasci-idoso" class="form-control" value="<?=$dadosDoBanco->dataNascimento ?? NULL?>" placeholder="dd/mm/aaaa">
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col">
                <label for="fone-idoso">Telefone:</label>
                <input type="text" name="fone-idoso" require id="fone-idoso" class="form-control" value="<?=$dadosDoBanco->telefone ?? NULL?>" placeholder="(99)99999-9999">
            </div>

            <div class="col">
                <label for="genero-idoso">Gênero</label>
                <select name="genero-idoso" require id="genero" class="form-select" value="<?=$dadosDoBanco->genero ?? NULL?>" aria-label="Default select example">
                    <option value="m">Masculino</option>
                    <option value="f">Feminino</option>
                    <option value="ni">Não quero me identificar</option>
                </select>
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col">
                <label for="email-idoso">E-mail:</label>
                <input type="email" name="email-idoso" require id="email-idoso" class="form-control" value="<?=$dadosDoBanco->email ?? NULL?>"  placeholder="exemplo@gmail.com">
            </div>
        </div>
        <br>
        
        <div class="row">
            <div class="col">
                <div class="acompanhante">
                    <label for="acomp-idoso">Precisa de acompanhante?</label>
                    <br>
                    <input type="radio" name="acomp-idoso"  onclick="verAcompanhante()" id="acomp-idoso" value="sim">  <!--  value="<?=$dadosDoBanco->acomp ?? NULL?>" -->Sim
                    <input type="radio" name="acomp-idoso"  onclick="verAcompanhante()" id="acomp-idoso" value="nao"> <!-- value="<?=$dadosDoBanco->acomp ?? NULL?>"-->Não
                    <br>
                </div>
            </div>
        </div>
        <br>
        <hr>

        <h2>Endereço para aplicação da vacina</h2>
        <div class="row">
            <div class="col">
                <label for="cep-idoso">CEP:</label>
                <input type="text" name="cep-idoso" require id="cep-idoso" class="form-control" value="<?=$dadosDoBanco->cep ?? NULL?>" placeholder="99999-999">
            </div>
            <div class="col">
                <label for="rua-idoso">Rua:</label>
                <input type="text" name="rua-idoso" require id="rua-idoso" class="form-control" value="<?=$dadosDoBanco->endereco ?? NULL?>" placeholder="Digite o nome da sua rua">
            </div>
        </div>
        <br>
        
        <div class="row">
            <div class="col">
                <label for="bairro-idoso">Bairro:</label>
                <input type="text" name="bairro-idoso" require id="bairro-idoso" class="form-control" value="<?=$dadosDoBanco->bairro ?? NULL?>" placeholder="Digite o nome do seu bairro">
            </div>
            <div class="col">
                <label for="estado-idoso">Estado:</label> 
                <input type="text" name="estado-idoso" require id="estado-idoso" class="form-control" value="<?=$dadosDoBanco->estado ?? NULL?>" placeholder="Digite o nome do seu Estado">
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col">
                <label for="numero-idoso">Número:</label> 
                <input type="text" name="numero-idoso" require id="numero-idoso" class="form-control" value="<?=$dadosDoBanco->numero ?? NULL?>" placeholder="Digite o número da sua residência">
            </div>
            <div class="col">
                <label for="comple-idoso">Complemento</label> 
                <input type="text" name="comple-idoso" id="comple-idoso" class="form-control" value="<?=$dadosDoBanco->complemento ?? NULL?>" placeholder="Casa, apartamento...">
            </div>
        </div>
        <br>

        <hr>

        <div id="info-acomp"> 
            <h2>Credenciais do acompanhante</h2>
            <div class="row">
                <div class="col">
                    <label for="nome-acomp">Nome:</label> 
                    <input type="text" name="nome-acomp" require id="nome-acomp" class="form-control" value="<?=$dadosDoBanco->nomeAcomp ?? NULL?>" placeholder="Nome completo do acompanhante">
                </div> 
            </div>
            <br>
            <div class="row">
                <div class="col">
                    <label for="cpf-acomp">CPF:</label>
                    <input type="text" name="cpf-acomp" require id="cpf-acomp" class="form-control" value="<?=$dadosDoBanco->cpfAcomp ?? NULL?>" placeholder="999.999.999-99">
                </div>
                <div class="col">
                    <label for="fone-acomp">Telefone:</label>
                    <input type="text" name="fone-acomp" require id="fone-acomp" class="form-control" value="<?=$dadosDoBanco->foneAcomp ?? NULL?>" placeholder="(99)99999-9999">
                </div>
            </div>
            <br>

            <div class="row">
                <div class="col">
                    <label for="email-acomp">E-mail:</label>
                    <input type="email" name="email-acomp" require id="email-acomp" class="form-control" value="<?=$dadosDoBanco->emailAcomp ?? NULL?>" placeholder="exemplo@gmail.com">
                </div>
            </div>
            <br>
        </div>
 
        <div class="row">
            <div class="col">
                <button class="botao-cancelar" type="submit" name="botao-cancelar" value="botao-cancelar">Cancelar</button>
            </div>
            <div class="col">
                <button class="botao-continuar" type="submit" name="botao-continuar" value="botao-continuar">Continuar</button>
            </div>
        </div>
    </form>
</div>
