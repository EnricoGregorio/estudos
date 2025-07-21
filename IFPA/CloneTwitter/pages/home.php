<?php

if ($usuarioOn === 'false') {
    header('Location: login');
    die();
}
if (!$pesquisou && $existePosts) {
    foreach ($posts as $key => $value) {
        if ($value['nome_usuario'] !== $usuarioAtual) {
            echo
            "
        <div class=\"post\">
            <p class=\"nome-usuario\"><a href=\"", INCLUDE_PATH, "${value['nome_usuario']}\">${value['nome_usuario']}</a></p>
            <p class=\"txt-post\">${value['texto']}</p>
            <div class=\"rodape-publicaco\">
                <!--<button class=\"comentarios\" name=\"comments\"><i class=\"fa-regular fa-comment\"></i> </button>-->
                <p class=\"data-publicacao\">Publicado em ${value['dt_publicacao']}</p>
            </div>
        </div>";
        } else {
            echo
            "
        <div class=\"post\">
            <p class=\"nome-usuario\"><a href=\"", INCLUDE_PATH, "perfil\">${value['nome_usuario']}</a></p>
            <p class=\"txt-post\">${value['texto']}</p>
            <div class=\"rodape-publicaco\">
                <!--<button class=\"comentarios\" name=\"comments\"><i class=\"fa-regular fa-comment\"></i> </button>-->
                <p class=\"data-publicacao\">Publicado em ${value['dt_publicacao']}</p>
            </div>
        </div>";
        }
    }
} else if ($pesquisou) {
    if ($encontrou) {
        foreach ($usuariosEncontrados as $key => $value) {
            if ($value['nome_usuario'] !== $usuarioAtual) {
                echo
                "
            <div class=\"post usuarios\">
                <p class=\"icon-perfil-minimizado\"><i class=\"fa-solid fa-user\"></i></p>
                <div>
                    <p class=\"nome-usuario\"><a href=\"", INCLUDE_PATH, "${value['nome_usuario']}\">${value['nome_usuario']}</a></p>
                    <p class=\"nome-completo-perfil\">${value['nome']} ${value['sobrenome']}</p>
                </div>
            </div>
            ";
            } else {
                echo
                "
            <div class=\"post usuarios\">
                <p class=\"icon-perfil-minimizado\"><i class=\"fa-solid fa-user\"></i></p>
                <div>
                    <p class=\"nome-usuario\"><a href=\"", INCLUDE_PATH, "perfil\">${value['nome_usuario']}</a></p>
                    <p class=\"nome-completo-perfil\">${value['nome']} ${value['sobrenome']}</p>
                </div>
            </div>
            ";
            }
        }
    } else {
        echo "<h2 class=\"sem-posts\"><i class=\"fa-solid fa-user-xmark\"></i> Ops... nenhum usuário encontrado.</h2>";
    }
} else {
    echo "<h2 class=\"sem-posts\"><i class=\"fa-solid fa-comment-slash\"></i> Ops... nada para ver aqui</h2>";
}
