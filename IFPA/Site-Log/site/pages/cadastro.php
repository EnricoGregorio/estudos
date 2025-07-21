<main>
    <form action="<?php echo INCLUDE_PATH; ?>pdo.php" method="post">
        <h2>Registro de usuário</h2>
        <div class="input-container">
            <input type="text" name="nome" id="nome" class="text-input" autocomplete="off" placeholder="Digite seu nome" required>
            <label class="label" for="nome">Nome completo:</label>
        </div>
        <div class="input-container">
            <select name="projeto" id="projeto" class="text-input" required>
                <option value="" disabled selected hidden>Informe o projeto:</option>
                <option value="Computador Amigo">Computador Amigo</option>
                <option value="Lamuca">Lamuca</option>
                <option value="Paragobyte Girls">Paragobyte Girls</option>
                <option value="Vale do Silício">Vale do Silício</option>
            </select>
            <label class="label" for="projeto">Projeto:</label>
        </div>
        <div class="input-container">
            <input type="text" name="tagid" id="tagid" class="text-input" autocomplete="off" placeholder="Digite a tag" required>
            <label class="label" for="tagid">Tag ID:</label>
        </div>
        <input type="submit" name="cadastro" value="Registrar">
    </form>
</main>