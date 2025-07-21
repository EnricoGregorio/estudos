<?php

$pdo = new PDO('mysql:host=localhost;dbname=dbsite', 'root', '');
session_start();

// Verifica se a sessão já existe.
$usuarioAtual = '';

$usuarioOn = isset($_SESSION['usuario']) ? 'true' : 'false';
if ($usuarioOn === 'true') {
    $usuarioAtual = $_SESSION['usuario'];
}

// Página de cadastro
if (isset($_POST['cadastro'])) {
    // Pegando os dados inseridos nos inputs.
    // Parte do Usuário
    $usuario = '@' . $_POST['usuario'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];
    date_default_timezone_set('America/Sao_Paulo');
    $dtCriacaoUsuario = date('Y-m-d', time());
    // Parte do Perfil
    $nome = $_POST['nome'];
    $sobrenome = $_POST['sobrenome'];
    $dtNascimento = $_POST['dt-nascimento'];
    $celular = $_POST['celular'];
    $bio = $_POST['bio'];

    // Verificação de duplicidade por nome de usuário e por email.
    $getIDusuario = $pdo->prepare("SELECT id FROM `Usuarios` WHERE nome_usuario = ?");
    $getIDusuario->execute(array($usuario));
    $idUsuario = $getIDusuario->fetch();
    $getIDusuario2 = $pdo->prepare("SELECT id FROM `Usuarios` WHERE email = ?");
    $getIDusuario2->execute(array($email));
    $idUsuario2 = $getIDusuario2->fetch();
    if ($idUsuario === false && $idUsuario2 === false) {
        // Inserção de dados no banco.
        $setUser = $pdo->prepare("INSERT `Usuarios` VALUES (null, ?, ?, ?, ?)");
        $setUser->execute(array($usuario, $email, $senha, $dtCriacaoUsuario));

        $getIDusuario = $pdo->prepare("SELECT id FROM `Usuarios` WHERE nome_usuario = ?");
        $getIDusuario->execute(array($usuario));
        $idUsuario = $getIDusuario->fetch();

        $setPerfil = $pdo->prepare("INSERT `Perfis` VALUES (null, ?, ?, ?, ?, ?, ?)");
        $setPerfil->execute(array($nome, $sobrenome, $dtNascimento, $celular, $bio, $idUsuario['id']));

        $_SESSION['usuario'] = $usuario;
        header('Location: home');
    } else if ($idUsuario === true && $idUsuario2 === false) {
        echo '<script>window.alert("Esse nome de Usuário já está registrado no site! Escolha outro.");</script>';
    } else if ($idUsuario === false && $idUsuario2 === true) {
        '<script>window.alert("Esse nome de Usuário já existe! Escolha outro.");</script>';
    } else {
        echo '<script>window.alert("Esse nome de Usuário e email já estão registrados no site! Escolha outro.");</script>';
    }
}

// Página de login
if (isset($_POST['login'])) {
    $email = $_POST['email'];
    $senha = $_POST['senha'];

    $getUsuario = $pdo->prepare("SELECT nome_usuario FROM `Usuarios` WHERE email = ? AND senha = ?");
    $getUsuario->execute(array($email, $senha));
    $usuario = $getUsuario->fetch();

    if ($usuario === false) {
        echo '<script>window.alert("Email e/ou senha incorreto(s)!");</script>';
    } else {
        $_SESSION['usuario'] = $usuario['nome_usuario'];
        header('Location: home');
    }
}

if (isset($_POST['sair'])) {
    unset($_SESSION['usuario']);
    header('Location: login');
}

// Pegando as informações para o perfil
$getInforUsuario = $pdo->prepare("SELECT u.nome_usuario AS usuario, p.nome, p.sobrenome, p.bio, DATE_FORMAT(p.data_nascimento, '%d/%m/%Y') AS nascimento, DATE_FORMAT(u.dt_usuario, '%d/%m/%Y') AS ingressou, COUNT(s.id_seguidor) AS seguidores, COUNT(sg.id_seguindo) AS seguindo FROM `Perfis` AS p INNER JOIN Usuarios AS u ON u.id = p.id_usuario LEFT JOIN Seguidores AS s ON s.id_seguindo = p.id LEFT JOIN Seguidores AS sg ON sg.id_seguidor = p.id WHERE u.nome_usuario = ?");
$getInforUsuario->execute(array($usuarioAtual));
$usuarioInfor = $getInforUsuario->fetchAll();

// Pegando as informaçõe para os tweets do perfil
$getPostsPerfil = $pdo->prepare("SELECT COUNT(pu.id) AS pubs FROM Publicacoes AS pu INNER JOIN Usuarios AS u ON u.id = pu.id_usuario WHERE u.nome_usuario = ?");
$getPostsPerfil->execute(array($usuarioAtual));
$postsPerfil = $getPostsPerfil->fetch();

$getPostsDoUsuario = $pdo->prepare("SELECT u.nome_usuario, pub.texto, DATE_FORMAT(pub.dt_publicacao, '%d/%m/%Y') AS dt_publicacao FROM Publicacoes AS pub INNER JOIN Usuarios AS u ON u.id = pub.id_usuario WHERE u.nome_usuario = ?");
$getPostsDoUsuario->execute(array($usuarioAtual));
$postsUsuarioInfo = $getPostsDoUsuario->fetchAll();


$usuarioInfor2 = [];
$postsPerfil2['pubs'] = '';
$postsUsuarioInfo2 = [];

// Página Home
// Verificando se há algum post.
$main = "";
if (!isset($_GET['usuario-pesquisado'])) {
    $pesquisou = false;
    $existePosts = true;
    $getCountPost = $pdo->prepare("SELECT COUNT(id) AS pubs FROM Publicacoes");
    $getCountPost->execute();
    $countPosts = $getCountPost->fetch();

    if ($countPosts['pubs'] === 0) {
        $existePosts = false;
    }

    $getPosts = $pdo->prepare("SELECT u.nome_usuario, pub.texto, DATE_FORMAT(pub.dt_publicacao, '%d/%m/%Y') AS dt_publicacao FROM Publicacoes AS pub INNER JOIN Usuarios AS u ON u.id = pub.id_usuario  ORDER BY pub.id DESC");
    $getPosts->execute();
    $posts = $getPosts->fetchAll();
} else {
    $pesquisou = true;
    $encontrou = true;
    $usuarioP = '%' . $_GET['usuario-pesquisado'] . '%';
    $getUsuariosPesquisados = $pdo->prepare("SELECT u.nome_usuario, p.nome, p.sobrenome FROM Usuarios AS u INNER JOIN Perfis AS p ON p.id_usuario = u.id WHERE nome_usuario LIKE :name");
    $getUsuariosPesquisados->bindValue(':name', $usuarioP);
    $getUsuariosPesquisados->execute();
    $usuariosEncontrados = $getUsuariosPesquisados->fetchAll();

    if ($usuariosEncontrados === []) {
        $encontrou = false;
    } else {
        $perfil2 = $usuariosEncontrados[0]['nome_usuario'];
        $getInforUsuario2 = $pdo->prepare("SELECT u.nome_usuario AS usuario, p.nome, p.sobrenome, p.bio, DATE_FORMAT(p.data_nascimento, '%d/%m/%Y') AS nascimento, DATE_FORMAT(u.dt_usuario, '%d/%m/%Y') AS ingressou, COUNT(s.id_seguidor) AS seguidores, COUNT(sg.id_seguindo) AS seguindo FROM `Perfis` AS p INNER JOIN Usuarios AS u ON u.id = p.id_usuario LEFT JOIN Seguidores AS s ON s.id_seguindo = p.id LEFT JOIN Seguidores AS sg ON sg.id_seguidor = p.id WHERE u.nome_usuario = ?");
        $getInforUsuario2->execute(array($perfil2));
        $usuarioInfor2 = $getInforUsuario2->fetchAll();

        // // Pegando as informaçõe para os tweets do perfil
        // $getPostsPerfil2 = $pdo->prepare("SELECT COUNT(pu.id) AS pubs FROM Publicacoes AS pu INNER JOIN Usuarios AS u ON u.id = pu.id_usuario WHERE u.nome_usuario = ?");
        // $getPostsPerfil2->execute(array($perfil2));
        // $postsPerfil2 = $getPostsPerfil2->fetch();

        // $getPostsDoUsuario2 = $pdo->prepare("SELECT u.nome_usuario, pub.texto, DATE_FORMAT(pub.dt_publicacao, '%d/%m/%Y') AS dt_publicacao FROM Publicacoes AS pub INNER JOIN Usuarios AS u ON u.id = pub.id_usuario WHERE u.nome_usuario = ?");
        // $getPostsDoUsuario2->execute(array($perfil2));
        // $postsUsuarioInfo2 = $getPostsDoUsuario2->fetchAll();


        $nomeArquivo = strtolower($perfil2);
        $nomeArquivo = str_replace(" ", "", $nomeArquivo);


        // $conteudo = include('pages/padrao.php');
        $conteudo = '<section class="perfil">
        <h2 class="icon-perfil"><i class="fa-solid fa-user"></i></h2>
        <?php
            echo
            "<p class=\"nome-usuario-perfil\">' . $usuarioInfor2[0]['usuario'] . '</p>
            <p class=\"nome-completo-perfil\">' . $usuarioInfor2[0]['nome'] . ' ' . $usuarioInfor2[0]['sobrenome'] . '</p>
            <p class=\"bio-perfil\">' . $usuarioInfor2[0]['bio'] . '</p>
            <p class=\"datas-perfil\"><span><i class=\"fa-solid fa-cake-candles\"></i> Nasceu no dia ' . $usuarioInfor2[0]['nascimento'] . '</span> <span><i class=\"fa-solid fa-calendar-day\"></i> Ingressou em ' . $usuarioInfor2[0]['ingressou'] . '</span></p>
            <p class=\"seguidres-e-seguindo\"><span>' . $usuarioInfor2[0]['seguindo'] . ' Seguindo</span> <span>' . $usuarioInfor2[0]['seguidores'] . ' Seguidores</span></p>";
        ?>
    </section>';

        file_put_contents('pages/' . $nomeArquivo . '.php', $conteudo);
        // header('Location: ' . $nomeArquivo);
    }
}

// Página notificações
if ($usuarioAtual !== '') {
    $getUsuarioID = $pdo->prepare("SELECT id FROM `Usuarios` WHERE nome_usuario = ?");
    $getUsuarioID->execute(array($usuarioAtual));
    $usuarioID = $getUsuarioID->fetch();

    // Verificando se o usuário possui alguma notificação.
    $getCountNotfications = $pdo->prepare("SELECT COUNT(u.nome_usuario) AS seguidores FROM Seguidores AS s INNER JOIN Usuarios AS u ON u.id = s.id_seguidor WHERE s.id_seguindo = ?");
    $getCountNotfications->execute(array($usuarioID['id']));
    $notificationsCount = $getCountNotfications->fetch();


    $getNotifications = $pdo->prepare("SELECT u.nome_usuario AS seguidor, DATE_FORMAT(s.data_registro, '%d/%m/%Y') AS dt_seguiu FROM Seguidores AS s INNER JOIN Usuarios AS u ON u.id = s.id_seguidor WHERE s.id_seguindo = ? ORDER BY dt_seguiu DESC");
    $getNotifications->execute(array($usuarioID['id']));
    $notifications = $getNotifications->fetchAll();
}


// Página de postar
if (isset($_POST['postar'])) {
    // pegando o ID do Usuário
    $getUserID = $pdo->prepare("SELECT id FROM `Usuarios` WHERE nome_usuario = ?");
    $getUserID->execute(array($usuarioAtual));
    $userID = $getUserID->fetch();

    // Pegando as informações do post na página.
    $postagem = $_POST['postagem'];
    date_default_timezone_set('America/Sao_Paulo');
    $dtPublicacao = date('Y-m-d', time());

    $setPost = $pdo->prepare("INSERT `Publicacoes` VALUES (null, ?, ?, ?)");
    $setPost->execute(array($postagem, $dtPublicacao, $userID['id']));
}
