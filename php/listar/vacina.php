<?php

$vacinas = $_SESSION['vacinas'] ?? [];

?>
<h2>Confira as próximas vacinas</h2>
<div class="row">
    <div class="col-3">
        <div class="breadcrumb">
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
                <input type="number" name="filtroIdade">
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
    <p>Idade: <?= $vacina['idade_max'] + "-" + $vacina['idade_in'] ?></p>
    <p>Data de Início: <?= $vacina['data_inicio'] ?></p>
    <p>Data limite: <?= $vacina['data_limite'] ?></p>
    <p>Doenças evitadas: <?= $vacina['doenca'] ?></p>
    <h5>Observações: </h5>
    <p><?= $vacina['observacao'] ?></p>
</div>
<br>
<?php } ?>