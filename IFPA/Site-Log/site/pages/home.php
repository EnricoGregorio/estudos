<main>
    <h2>Bate ponto log:</h2>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Projeto</th>
                <th>Entrada/Saída</th>
                <th>Horário</th>
                <th>Data</th>
            </tr>
        </thead>
        <tbody>
            <?php
            for ($i = 0; $i < count($listaBatePonto); $i++) {
                echo '<tr><td>' . $listaBatePonto[$i]['nome'] . '</td>' . '<td>' . $listaBatePonto[$i]['projeto'] . '</td>' . '<td>' . $listaBatePonto[$i]['bateponto'] . '</td><td>' . $listaBatePonto[$i]['hora'] . '</td><td>' . $listaBatePonto[$i]['dia'] . '</td>';
            }
            ?>
        </tbody>
    </table>
</main>