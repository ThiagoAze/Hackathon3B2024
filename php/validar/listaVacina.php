<?php
    $filtrosUsando = $_POST['filtros'] ?? NULL;
    $buscaUsando = $_POST['busca'] ?? NULL;
    if (is_null($filtrosUsando)) {
        $filtrosUsando = $_SESSION['filtros'] ?? NULL;
    }
    if (is_null($buscaUsando)){
        $buscaUsando = $_SESSION['busca'] ?? NULL;
    }   
    $vacinas = [];
    // As vacinas ainda precisam estar no período de aplicação
    if (isset($filtrosUsando) && isset($buscaUsando)) {
        // Buscando no banco a partir dos filtros selecionados e buscas de nome da vacina feitos

    } elseif (isset($filtrosUsando) && !isset($buscaUsando)) {
        // Buscando no banco a partir dos filtros selecionados

    } elseif (!isset($filtrosUsando) && isset($buscaUsando)) {
        // Buscando no banco a partir das buscas de nome da vacina feitas
    } else {
        // Buscar todas as vacinas disponíveis
    }

    $_SESSION['vacinas'] = $vacinas;
    $_SESSION['filtros'] = $filtrosUsando;
    $_SESSION['busca'] = $buscaUsando;
    echo "<script>location.href='listar/vacina';</script>";
?>