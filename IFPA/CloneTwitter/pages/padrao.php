<?php
if ($usuarioOn === 'false') {
    header('Location: login');
    die();
}
?>
<section class="perfil">
    <h2 class="icon-perfil"><i class="fa-solid fa-user"></i></h2>
    <?php
    foreach ($usuarioInfor2 as $key => $value) {
        echo
        "<p class=\"nome-usuario-perfil\">${value['usuario']}</p>
        <p class=\"nome-completo-perfil\">${value['nome']} ${value['sobrenome']}</p>
        <p class=\"bio-perfil\">${value['bio']}</p>
        <p class=\"datas-perfil\"><span><i class=\"fa-solid fa-cake-candles\"></i> Nasceu no dia ${value['nascimento']}</span> <span><i class=\"fa-solid fa-calendar-day\"></i> Ingressou em ${value['ingressou']}</span></p>
        <p class=\"seguidres-e-seguindo\"><span>${value['seguindo']} Seguindo</span> <span>${value['seguidores']} Seguidores</span></p>";
    }
    ?>
</section>
<section class="posts">
    <?php
    if ($postsPerfil2['pubs'] === 0) {
        echo "<h2 class=\"sem-posts\"><i class=\"fa-solid fa-comment-slash\"></i>Ops... nada para ver aqui</h2>";
    } else {
        foreach ($postsUsuarioInfo2 as $key => $value) {
            echo
            "
            <div class=\"post\">
                <p class=\"nome-usuario\"><a href=\"", INCLUDE_PATH, "perfil\">${value['nome_usuario']}</a></p>
                <p class=\"txt-post\">${value['texto']}</p>
                <div class=\"rodape-publicaco\">
                    <!--<button class=\"comentarios\" name=\"comments\"><i class=\"fa-regular fa-comment\"></i></button>-->
                    <p class=\"data-publicacao\">Publicado em ${value['dt_publicacao']}</p>
                </div>
            </div>
            ";
        }
    }
    ?>
</section>