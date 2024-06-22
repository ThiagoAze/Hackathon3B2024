<?php
    # buscar e configurar a api node

    session_start();
?>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="<?php echo "http://" . $_SERVER["HTTP_HOST"] . $_SERVER["SCRIPT_NAME"]; ?>">
    <!-- Favicon -->
    <link rel="shortcut icon" href="https://cdn.iconscout.com/icon/free/png-256/free-emergency-call-2199806-1833385.png" type="image/x-icon">
    <!-- Ícones -->
    <script src="https://kit.fontawesome.com/b82f5ae24a.js" crossorigin="anonymous"></script>
    <!-- JavaScript -->
    <script src="js/form.js"></script>
    <script src="js/jquery.inputmask.min.js"></script>
    <script src="js/sweetalert2.min.js"></script>
    <!-- Estilização -->
    <link rel="stylesheet" href="./css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="./css/form.css">
    <link rel="stylesheet" href="./css/alerta.css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <title>Vacinet</title>
</head>

<body>
    <?php
        require 'pagina/funcoes.php';

        if (isset($_GET['param'])) {
            if ($_GET['param'] == "index"){
                $pasta = "listar";
                $arquivo = "vacina";
            } else {
                $page = explode("/", $_GET['param']);
                $pasta = $page[0] ?? NULL;
                $arquivo = $page[1] ?? NULL;
                $id = $page[2] ?? NULL;
            }
                
            $page = "$pasta/$arquivo";
                
            require "header.php";
                
            if (file_exists("$page.php")) {
                require "$page.php";
            } else {
                require "pagina/erro.php";
            }
            require "footer.php";
        }
    ?>

    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous">
    </script>
</body>

</html>