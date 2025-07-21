<main>
    <form action="<?php echo INCLUDE_PATH; ?>pdo.php" method="post">
        <h2>Gestão do blog de notícias - Login</h2>
        <label for="useremail" draggable="false">usuário: </label><br>
            <input type="text" name="usuario" id="useremail" required><br>
        <label for="pass" draggable="false">senha: </label><br>
            <input type="password" name="senha" id="pass" minlength="8" maxlength="20" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Deve contar ao menos um número e letras maiúsculas e minúsculas, e ao menos 8 caracteres." required><br>

        <input type="radio" name="option" id="post" value="noticias" checked>
            <label for="post">Ir para a criação de notícias.</label><br>
        <input type="radio" name="option" id="tabela" value="tabela">
            <label for="tabela">Ir para a configuração da tabela da Coleta.</label>
        <input type="submit" name="login-admin" value="Entrar">
    </form>
</main>