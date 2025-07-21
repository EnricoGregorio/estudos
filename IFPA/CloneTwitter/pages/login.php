<?php
if ($usuarioOn === 'true') {
    header('Location: home');
    die();
}
?>
<form action="" method="post" class="login">
    <i class="fa-solid fa-crow"></i>
    <div class="form-login">
        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="nome@exemplo.com" required>
        <label for="senha">Senha</label>
        <input type="password" name="senha" id="senha" minlength="8" maxlength="16" required>
        <input type="submit" name="login" value="Entrar">
    </div>
    <p>Ainda não possui uma conta? <a href="<?php echo INCLUDE_PATH; ?>cadastro" target="_self">Cadastre-se</a> aqui.</p>
</form>