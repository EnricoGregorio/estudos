<?php
    session_start();
    $pdo = new PDO('mysql:host=localhost;dbname=dbsite', 'root', '');
    $admin = 'admin';
    $senha = '123';

    $queryTable = $pdo->prepare("SELECT bairros FROM Bairros");
    $queryTable->execute();
    $dadosTable = $queryTable->fetchAll();

    $queryPosts = $pdo->prepare("SELECT dtpost, titulo, nomearquivo, resumo FROM Posts ORDER BY id DESC");
    $queryPosts->execute();
    $dadosPosts = $queryPosts->fetchAll();

    if(isset($_POST['login-admin'])) {
        $adminInput = $_POST['usuario'];
        $senhaInput = $_POST['senha'];
        $option = $_POST['option'];

        if ($adminInput == $admin && $senhaInput == $senha) {
            $_SESSION['admin'] = 'admin';
            if ($option == 'noticias') {
                header('Location: post');
            } else {
                header('Location: tables');
            }
            
        } else {
            echo '<p>Usuário e/ou senha inválida!</p>';
            header('Location: admin');
        }
    }

    if(isset($_POST['tabela'])){
        $bairro1 = $_POST['bairro1'];
        $bairro2 = $_POST['bairro2'];
        $bairro3 = $_POST['bairro3'];
        $bairro4 = $_POST['bairro4'];
        $bairro5 = $_POST['bairro5'];
        $bairro6 = $_POST['bairro6'];
        $bairro7 = $_POST['bairro7'];
        $bairro8 = $_POST['bairro8'];
        $bairro9 = $_POST['bairro9'];
        $bairro10 = $_POST['bairro10'];
        $bairro11 = $_POST['bairro11'];
        $bairro12 = $_POST['bairro12'];

        $query1 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 1");
        $query2 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 2");
        $query3 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 3");
        $query4 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 4");
        $query5 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 5");
        $query6 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 6");
        $query7 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 7");
        $query8 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 8");
        $query9 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 9");
        $query10 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 10");
        $query11 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 11");
        $query12 = $pdo->prepare("UPDATE Bairros SET bairros = ? WHERE id = 12");

        $query1->execute(array($bairro1));
        $query2->execute(array($bairro2));
        $query3->execute(array($bairro3));
        $query4->execute(array($bairro4));
        $query5->execute(array($bairro5));
        $query6->execute(array($bairro6));
        $query7->execute(array($bairro7));
        $query8->execute(array($bairro8));
        $query9->execute(array($bairro9));
        $query10->execute(array($bairro10));
        $query11->execute(array($bairro11));
        $query12->execute(array($bairro12));

        header('Location: home');
	}

    if(isset($_POST['post'])) {
        $titulo = trim($_POST['titulo']);
        $p1 = $_POST['p1'];
        $p1 = substr($p1, 0, 250);
        $p2 = $_POST['p2'];
        $autor = $_POST['autor'];
        $dtPost = date('Y-m-d');
        $dtPost2 = date('d/m/Y');
        $nomeArquivo = strtolower($titulo);
        $nomeArquivo = str_replace(" ", "", $nomeArquivo);
        $query6 = $pdo->prepare("INSERT INTO `Posts` VALUES(null, ?, ?, ?, ?)");
        $query6->execute(array($dtPost, $titulo, $nomeArquivo, $p1));

        // Criando post .php com PHP.
        $conteudo = '<main>
    <section class="posts">
        <div class="posts-sobre">
            <h1>'.$titulo.'</h1>
            <p>'.$p1.'</p>
            <p>'.$p2.'</p>
            <p id="data">'.$dtPost2.'</p>
            <p id="author">Autor(a): '.$autor.'</p>
        </div>
        <p id="home"><a href="/" target="_self">Clique aqui</a> para voltar à página principal.</p>
    </section>
</main>';
        file_put_contents('pages/posts/'.$nomeArquivo.'.php', $conteudo);
        header('Location: home');
    }
?>