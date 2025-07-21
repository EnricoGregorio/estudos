<?php
include('config.php');
include('pdo.php');
?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Ellen Melissa Galvão Santos, Enrico Sobrinho Gregório, Gabriela Ramos de Jesus, Romildo Contarini Neto, Thamires Nascimento Costa">
    <meta name="description" content="Cópia do Twitter feito por alunos do IFPA - Campus Paragominas como forma de avaliação do 4º bimestre na matéria 'Linguagens de Marcação e de Estilo'.">
    <meta name="keywords" content="alunos, twitter, clone, rede, social">
    <meta name="theme-color" content="#6C4DE6">
    <title>Pidgey</title>
    <link rel="stylesheet" href="<?php echo INCLUDE_PATH; ?>css/style.css">
    <link rel="apple-touch-icon" sizes="180x180" href="<?php echo INCLUDE_PATH; ?>favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="<?php echo INCLUDE_PATH; ?>favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="<?php echo INCLUDE_PATH; ?>favicon/favicon-16x16.png">
    <link rel="manifest" href="<?php echo INCLUDE_PATH; ?>favicon/site.webmanifest">
    <link rel="shortcut icon" href="<?php echo INCLUDE_PATH; ?>favicon/favicon.ico" type="image/x-icon">
</head>

<body>
    <?php
    if ($usuarioAtual !== '') {
        echo '
    <header>
        <nav>
            <h1><a href="' . INCLUDE_PATH . '"><i class="fa-solid fa-crow"></i></a></h1>
            <ul>
                <li><a href="' . INCLUDE_PATH . '" target="_self"><i class="fa-solid fa-house"></i> Página Inicial</a></li>
                <li><a href="' . INCLUDE_PATH . 'notificacoes" target="_self"><i class="fa-solid fa-bell"></i> Notificacoes</a></li>
                <li><a href="' . INCLUDE_PATH . 'perfil" target="_self"><i class="fa-solid fa-user"></i> Perfil</a></li>
            </ul>
            <button name="post" class="btn-post"><a href="' . INCLUDE_PATH . 'posts">Postar</a></button>
        </nav>
        <form action="" method="post">
            <button name="sair" class="btn-post sair show-modal" type="submit">Sair</button>
            </form>

    <!-- <button class="btn-dark-mode claro" type="button"><i class="fa-solid fa-moon"></i></button> -->
    </header>';
    }
    ?>
    <main>
        <?php
        $url = isset($_GET['url']) ? $_GET['url'] : 'home';
        if (file_exists('pages/' . $url . '.php')) {
            include('pages/' . $url . '.php');
        } else {
            include('pages/404.php');
        }
        ?>
    </main>
    <?php
    if ($usuarioAtual !== '') {
        echo '
    <footer>
        <form action="' . INCLUDE_PATH . 'home" method="get" class="pesquisar-usuario">
            <input type="text" name="usuario-pesquisado" id="usuario-search" placeholder="Procurar @usuário...">
            <button type="hidden"><i class="fa fa-search"></i></button>
        </form>
        <p>© <span id="year"></span> | IFPA - Campus Paragominas, Brasil</p>
    </footer>';
    }
    ?>
    <script src="https://kit.fontawesome.com/f156855bd0.js" crossorigin="anonymous"></script>
    <script src="<?php echo INCLUDE_PATH; ?>js/script.js" type="text/javascript"></script>
</body>

</html>