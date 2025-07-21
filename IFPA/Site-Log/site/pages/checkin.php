<main>
    <form action="<?php echo INCLUDE_PATH; ?>pdo.php" method="post">
        <h2>Bate ponto de usuário</h2>
        <div class="input-container">
            <input type="text" name="tagid" id="tagid" class="text-input" autocomplete="off" placeholder="Digite a tag" required>
            <label class="label" for="tagid">Tag ID:</label>
        </div>
        <input type="submit" name="checkin" value="Bater ponto">
    </form>
</main>