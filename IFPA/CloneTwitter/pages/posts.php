<?php

if ($usuarioOn === 'false') {
    header('Location: login');
    die();
}
?>

<div class="postar">
    <form action="" method="post" class="criar-post">
        <textarea class="bio postagem" name="postagem" placeholder="O que você está pensando?" required></textarea>
        <input type="submit" value="Postar" name="postar" class="btn-post">
    </form>
</div>