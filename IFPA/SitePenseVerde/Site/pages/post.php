<?php 
    if (isset($_SESSION['admin'])) {
        echo '
            <main>
                <form action="pdo.php" method="post">
                    <h2>Gestão do blog de notícias</h2>
                    <div class="linha">
                        <label for="titulo" draggable="false">Título: </label><br>
                            <input type="text" name="titulo" id="titulo" maxlength="64" required><br>
                        <label for="p1" draggable="false">1º Parágrafo: </label><br>
                            <textarea name="p1" id="p1" cols="80" rows="10" maxlength="1000" required></textarea><br>
                        <label for="p2" draggable="false">2º Parágrafo: </label><br>
                            <textarea name="p2" id="p2" cols="80" rows="10" maxlength="1000"></textarea>
                        <label for="author">Autor: </label>
                            <input type="text" name="autor" id="author" maxlength="64" required>
                        <p>A data do post será salva automaticamente.</p>
                            <input type="submit" name="post" value="Publicar" class="sub-tabela">
                    </div>
                </form>

                <p><a href="/" target="_self">Clique aqui</a> para voltar para a página principal.</p>
            </main>';
} else {
    header('Location: admin');
}
?>