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
    <meta name="theme-color" content="#4fca3f">
    <meta name="keywords" content="Lixo, coleta, seletiva, verde, pense, SEMMA">
    <meta name="description" content="A Coleta Seletiva é um mecanismo de recolha dos resíduos, os quais são classificados de acordo com sua origem e depositados em contentores indicados por cores. Ou seja, eles podem ser resíduos orgânicos ou materiais recicláveis como papel, plástico, vidro, dentre outros. Além deles, materiais hospitalares e radioativos têm um destino diferente.">
    <title>Pense Verde</title>
    <link rel="stylesheet" href="<?php echo INCLUDE_PATH; ?>css/style.css">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

<body>
    <header>
    <img id="logos" src="<?php echo INCLUDE_PATH; ?>img/logos/logos2.png" alt="Logo do Pense Verde." draggable="false">
        <nav class="desktop">
            <ul>
                <li><a href="#acompanhe" target="_self" draggable="false">Acompanhe a coleta</a></li>
                <li><a href="#sobre-nos" target="_self" draggable="false">Sobre nós</a></li>
                <li><a href="#noticias" target="_self" draggable="false">Notícias</a></li>
            </ul>
        </nav>
        <button class="menu-button">
            <i class="fas fa-bars"></i>
            <i class="fas fa-times"></i>
        </button>
        <nav class="mobile">
            <ul>
                <li><a href="#acompanhe" target="_self" draggable="false">Acompanhe a coleta</a></li>
                <li><a href="#sobre-nos" target="_self" draggable="false">Sobre nós</a></li>
                <li><a href="#noticias" target="_self" draggable="false">Notícias</a></li>
            </ul>
        </nav>
    </header>
    <?php
        $url = isset($_GET['url']) ? $_GET['url'] : 'home';

        if (file_exists('pages/'.$url.'.php')) {
            include('pages/'.$url.'.php');
        }else if (file_exists('pages/posts/'.$url.'.php')) {
            include('pages/posts/'.$url.'.php');
        } else {
            include('pages/404.php');
        }
    ?>
    <button id="return-button" title="Voltar ao topo">
        <i class="fas fa-chevron-up"></i>
    </button>
    <script src="https://kit.fontawesome.com/f156855bd0.js" crossorigin="anonymous"></script>
    <script src="<?php echo INCLUDE_PATH; ?>js/jquery.js"></script>
    <script src="<?php echo INCLUDE_PATH; ?>js/scripts.js"></script>
    <footer>
        <div class="endereco">
            <p>Prefeitura de Paragominas</p>
            <address>
                End.: Rua<br>
                Bairro - Cidade - Estado<br>
                CEP: 00000-000<br>
            </address>
            <p>(DDD) 9 0000-0000 / 0000-0000</p>
            <p>Horário de atendimento: 08:00 às 12:00 - 14:00 às 18:00</p>
        </div>
        <div class="rodape-img">
            <img src="<?php echo INCLUDE_PATH; ?>img/logos/logos2.png" alt="Logo dos órgãos públicos." draggable="false">
        </div>
    </footer>
</body>

</html>
