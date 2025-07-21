<?php

if ($usuarioOn === 'false') {
    header('Location: login');
    die();
}
?>
<div class="post">
    <?php
    if ($notificationsCount['seguidores'] === 0) {
        echo "<h2 class=\"sem-posts\"><i class=\"fa-solid fa-comment-slash\"></i>Ops... nada para ver aqui</h2>";
    } else {
        foreach ($notifications as $key => $value) {
            echo
            "<p class=\"nome-usuario\"><a href=\"", INCLUDE_PATH, "${value['seguidor']}\">${value['seguidor']}</a> seguiu você!</p>
            <p class=\"date\">Começou a te seguir a partir de ${value['dt_seguiu']}</p>";
        }
    } ?>
</div>