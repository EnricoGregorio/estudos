<?php
include('config.php');
include('pdo.php');
?>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Site de bate ponto do Vale do Silício.">
    <meta name="keywords" content="bate, ponto, vale, silício, ifpa">
    <meta name="author" content="Enrico Sobrinho Gregório">
    <title>Laboratório 4</title>
    <link rel="stylesheet" href="<?php echo INCLUDE_PATH; ?>css/style.css">
</head>

<body>
    <header>
        <h1>Laboratório 4</h1>
    </header>
    <?php
    $url = isset($_GET['url']) ? $_GET['url'] : 'home';

    if (file_exists('pages/' . $url . '.php')) {
        include('pages/' . $url . '.php');
    } else {
        include('pages/404.php');
    }
    ?>
    <footer>
        <div class="text">
            <p><a href="https://paragominas.ifpa.edu.br/" target="_blank"><abbr title="Instituto Federal de Educação, Ciência e Tecnologia do Pará.">IFPA</abbr> - Campus Paragominas</a> Todos os direitos reservados || <span id="year-copyright"></span></p>
            <address>
                Bairro Juparana<br>
                Paragominas - PA
            </address>
        </div>
        <img src="imgs/ifpaLogo.png" alt="Logo do IFPA - Campus Paragominas">
    </footer>
    <script src="https://kit.fontawesome.com/f156855bd0.js" crossorigin="anonymous"></script>
    <script src="<?php echo INCLUDE_PATH; ?>js/jquery.js"></script>
    <script src="<?php echo INCLUDE_PATH; ?>js/scripts.js"></script>
</body>

</html>