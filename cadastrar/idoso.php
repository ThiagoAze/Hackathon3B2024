<?php
    //Usar Ajax para coletar automaticamente os dados(com a API node) caso o CPF tenha 11 caracteres exista
    //Se o CPF estiver cadastrado, buscar todos os dados mais o ID

?>

<div class="form-idoso">
    <div class="logo">Vacinet</div>
    <h1>Registre-se para uma maior qualidade de vida</h1>
    <form action="validar/cadastroIdoso" method="POST">
        <label for="nome-idoso">Nome</label>
        <input type="text" name="nome-idoso" id="nome-idoso" require placeholder="Nome completo">

        <br>

        <label for="cpf-idoso">CPF</label>
        <input type="text" name="cpf-idoso" id="cpf-idoso" require placeholder="999.999.999-99">

        <label for="data-nascimento-idoso">Data de Nascimento</label>
        <input type="date" name="data-nascimento-idoso" id="data-nascimento-idoso" require placeholder="dd//mm/yyyy">
        
        <br>

        <label for="fone-idoso">Telefone</label>
        <input type="text" name="fone-idoso" id="fone-idoso" require placeholder="(99)99999-9999">
        
        <label for="genero-idoso">Gênero</label>
        <select name="genero-idoso" id="genero">
            <option value="m">Masculino</option>
            <option value="f">Feminino</option>
            <option value="ni">Não quero me identificar</option>
        </select>
        
        <br>

        <label for="email-idoso">E-mail</label>
        <input type="email" name="email-idoso" id="email-idoso" require placeholder="exemplo@gmail.com">

        <br>
        
        <label for="acompanhante-idoso">Precisa de acompanhante?</label>
        <input type="radio" name="acompanhante-idoso" require value="sim" id="">Sim
        <input type="radio" name="acompanhante-idoso" require value="nao" id="">Não
        
        <br>
        <hr>

        <h2>Endereço para aplicação da vacina</h2>
        <label for="cep-idoso">CEP</label>
        <input type="text" name="cep-idoso" id="cep-idoso" require placeholder="999.999.999-99">
        
        <label for="endereco-idoso">Endereço</label> 
        <input type="text" name="endereco-idoso" id="endereco-idoso" require placeholder="Digite o nome da sua rua">

        <br>

        <label for="bairro-idoso">Bairro</label> 
        <input type="text" name="bairro-idoso" id="bairro-idoso" require placeholder="Digite o nome do seu bairro">
        
        <label for="estado-idoso">Estado</label> 
        <input type="text" name="estado-idoso" id="estado-idoso" require placeholder="Digite o nome do seu estado">
 
        <br>

        <label for="numero-idoso">Número da residência</label> 
        <input type="text" name="numero-idoso" id="numero-idoso" require placeholder="Digite o número da sua residência">

        <label for="complemento-idoso">Complemento</label> 
        <input type="text" name="complemento-idoso" id="complemento-idoso" placeholder="Casa, apartamento...">

        <br>
 
        <button class="cancelar" type="submit" name="cancelar" value="cancelar">Cancelar</button>
        <button class="confirmar" type="submit" name="confirmar" value="confirmar">Continuar</button>
    </form>
</div>