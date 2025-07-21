<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="<?php
                                    include('pdo.php');
                                    foreach ($autores as $key => $value) {
                                        echo "${value['nomes']}, ";
                                    } ?>">
    <meta name="description" content="Advinhe o número gerado pelo site!!">
    <meta name="keywords" content="jogo, advinhar, meu, número, game">
    <title>Advinhe Meu Número!</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <header>
        <h1>Advinhe meu número!</h1>
        <p class="between">(Entre 1 e <span class="max-number"></span>)</p>
        <button class="btn again">Recomeçar!</button>
        <div class="number">?</div>
    </header>
    <main>
        <section class="left">
            <input type="number" name="score" class="guess" autofocus />
            <button class="btn check" name="verificacao">Verificar!</button>
        </section>
        <section class="right">
            <p class="message">Comece a advinhar...</p>
            <p class="label-score">💯 Pontuação: <span class="score"></span></p>
            <p class="label-highscore">🥇 Sua Melhor Pontuação: <span class="highscore">0</span></p>
            <p class="label-highscore-global">🌎🏅 Melhor Pontuação Global: <span class="highscore">0</span></p>
        </section>
    </main>
    <script type="text/javascript" src="script.js"></script>
</body>

</html>