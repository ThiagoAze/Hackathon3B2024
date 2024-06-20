<?php
    //Usar Ajax para coletar automaticamente os dados(com a API node) caso o CPF tenha 11 caracteres exista
    //Se o CPF estiver cadastrado, buscar todos os dados mais o ID

?>

<div class="form-idoso">
    <div class="logo">Vacinet</div>
    <h1>Registre-se para uma maior qualidade de vida</h1>

    <form action="validar/cadastroIdoso" method="POST">

        <div class="row">
            <div class="col">
                <label for="nome-idoso">Nome:</label>
                <input type="text" name="nome-idoso" require id="nome-idoso" class="form-control" required placeholder="Digite seu nome completo">
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col">
                <label for="cpf-idoso">CPF:</label>
                <input type="text" name="cpf-idoso" require id="cpf-idoso" class="form-control" required placeholder="999.999.999-99">
            </div>
            <div class="col">
                <label for="data-nascimento-idoso">Data de Nascimento:</label>
                <input type="date" name="data-nascimento-idoso" require id="data-nascimento-idoso" class="form-control" required placeholder="dd/mm/aaaa">
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col">
                <label for="fone-idoso">Telefone:</label>
                <input type="text" name="fone-idoso" require id="fone-idoso" class="form-control" required placeholder="(99)99999-9999">
            </div>

            
            <div class="col">
                <label for="genero-idoso">Gênero</label>
                <select name="genero-idoso" require id="genero" class="form-select" aria-label="Default select example">
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
                <input type="text" name="email-idoso" id="email-idoso" class="form-control" required placeholder="exemplo@gmail.com">
            </div>
        </div>
        <br>
        
        <div class="row">
            <div class="col">
                <div class="acompanhante">
                    <label for="acompanhante-idoso">Precisa de acompanhante?</label>
                    <br>
                    <input type="radio" name="acompanhante-idoso" require value="sim" id="">Sim
                    <br>
                    <input type="radio" name="acompanhante-idoso" require value="nao" id="">Não
                </div>
            </div>
        </div>
        <br>
        <hr>

        <h2>Endereço para aplicação da vacina</h2>
        <div class="row">
            <div class="col">
                <label for="cep-idoso">CEP:</label>
                <input type="text" name="cep-idoso" require id="cep-idoso" class="form-control" required placeholder="99999-999">
            </div>
            <div class="col">
                <label for="endereco-idoso">Endereço:</label>
                <input type="text" name="endereco-idoso" require id="endereco-idoso" class="form-control" required placeholder="Digite o nome da sua rua">
            </div>
        </div>
        <br>
        
        <div class="row">
            <div class="col">
                <label for="bairro-idoso">Bairro:</label>
                <input type="text" name="bairro-idoso" require id="bairro-idoso" class="form-control" placeholder="Digite o nome do seu bairro">
            </div>
            <div class="col">
                <label for="estado-idoso">Estado:</label> 
                <input type="text" name="estado-idoso" require id="estado-idoso" class="form-control" placeholder="Digite o nome do seu Estado">
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col">
                <label for="numero-idoso">Número:</label> 
                <input type="text" name="numero-idoso" require id="numero-idoso" class="form-control" placeholder="Digite o número da sua residência">
            </div>
            <div class="col">
                <label for="complemento-idoso">Complemento</label> 
                <input type="text" name="complemento-idoso" id="complemento-idoso" class="form-control" placeholder="Casa, apartamento...">
            </div>
        </div>
        <br>

        <div class="row">
            
        </div>
        <br>
 
        <div class="row">
            <div class="col">
                <button class="cancelar" type="submit" name="cancelar" value="cancelar">Cancelar</button>
            </div>
            <div class="col">
                <button class="confirmar" type="submit" name="confirmar" value="confirmar">Continuar</button>
            </div>
        </div>
    </form>
</div>