<?php
if ($usuarioOn === 'true') {
    header('Location: home');
    die();
}
?>
<form action="" method="post" class="login">
    <i class="fa-solid fa-crow"></i>
    <div class="form-cadastro">
        <div class="form-cadastro">
            <label for="nome">Nome<span class="obg">*</span></label>
            <input type="text" id="nome" name="nome" maxlength="15" placeholder="Nome" required>
            <label for="sobrenome">Sobrenome<span class="obg">*</span></label>
            <input type="text" id="sobrenome" name="sobrenome" maxlength="32" placeholder="Sobrenome" required>
            <label for="usuario">Nome de Usuário<span class="obg">*</span> <strong>(Nome único)</strong></label>
            <input type="text" id="usuario" name="usuario" maxlength="16" placeholder="Nome de usuário" required>
            <label for="email">E-mail<span class="obg">*</span></label>
            <input type="email" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="nome@exemplo.com" required>
            <label for="senha">Senha<span class="obg">*</span></label>
            <input type="password" name="senha" id="senha" minlength="8" maxlength="16" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Deve contar ao menos um número e letras maiúsculas e minúsculas, e ao menos 8 caracteres." required>
        </div>
        <div class="form-login">
            <label for="dt-nascimento">Data de Nascimento<span class="obg"></span></label>
            <input type="date" name="dt-nascimento" id="dt-nascimento">
            <label for="celular">Celular</label>
            <input type="tel" name="celular" id="celular" maxlength="15" pattern="^\([1-9]{2}\) (?:[2-8]|9[1-9])[0-9]{3}\-[0-9]{4}$" placeholder="(00) 90000-0000" title="Digite o número como no formato: (XX) 9XXXX-XXXX">
            <label for="bio">Biografia</label>
            <textarea name="bio" class="bio" maxlength="160"></textarea>
        </div>
        <input type="submit" name="cadastro" value="Cadasrar">
    </div>
</form>