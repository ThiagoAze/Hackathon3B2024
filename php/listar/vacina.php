<?php

$vacinas = $_SESSION['vacinas'] ?? [];
$filtrosUsando = $_SESSION['filtros'] ?? NULL;
$buscaUsando = $_SESSION['busca'] ?? NULL;



?>
<div class="vacinas">
    <h2>Confira as próximas vacinas</h2>

    <div class="row">
        <div class="col-3">
            <div class="breadcrumb">
                Vacinas
                <?php
                // buscar breadcrubm com node
                ?>
            </div>
        </div>
        <div class="col-3">
            <div class="filtros">
                <img src="" alt="icone filtro">
                <form action="validar/listaVacina" method="post">
                    <label for="">Idade</label>
                    <input type="number" name="filtros">
                    <button type="submit">Aplicar</button>
                </form>


            </div>
        </div>
        <div class="col-4">
            <div class="pesquisa">
                <form action="validar/listaVacina" method="post">
                    <input name="busca" type="text" placeholder="pesquise o nome da vacina">
                    <button type="submit" style="border:none">
                        <img src="" alt="icone buscar">
                    </button>
                </form>
            </div>
        </div>
    </div>

    <?php
    foreach ($vacinas as $vacina) {
    ?>
    <div class="vacina">
        <h4><?= $vacina['nome'] ?></h4>
        
        <p>Idade: <?= $vacina['idade_max'], " - ", $vacina['idade_min'] ?></p>
        <p>Data de Início: <?= $vacina['data_inicio'] ?></p>
        <p>Data limite: <?= $vacina['data_limite'] ?></p>
        <p>Doenças evitadas: <?= $vacina['doenca'] ?></p>
        <h5>Observações: </h5>
        <p><?= $vacina['observacao'] ?></p>
    
        <form action="cadastrar/idoso.php" method="get">
            <input type="text" name="id" value="<?=$vacina['id']?>" style="visibility:hidden">
            <button type="submit">Agendar vacinação</button>
        </form>

    </div>
</div>
<br>
<?php } ?>