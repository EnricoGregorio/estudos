<?php
$pdo = new PDO('mysql:host=localhost;dbname=dbbateponto', 'root', '');

$umDia = new DateInterval('P1D');
$hoje = new DateTimeImmutable();
$amanha = $hoje->add($umDia);
$hora = new DateTime();
$strHoje = $hoje->format('Y-m-d');
$strAmanha = $amanha->format('Y-m-d');
$strHora = $hora->setTimezone(new DateTimeZone('America/Sao_Paulo'))->format('H:i');

$getBatePonto = $pdo->prepare('SELECT p.nome, t.projeto, IF(h.bateponto, "Entrou", "Saiu") bateponto, DATE_FORMAT(h.hora, "%H:%i") AS hora, DATE_FORMAT(h.dia, "%d/%m/%Y") AS dia FROM Horario AS h INNER JOIN Discentes AS p ON p.id = h.estudante INNER JOIN Projetos AS t ON t.id = p.projeto WHERE dia >= ? AND dia < ? ORDER BY hora;');
$getBatePonto->execute(array($strHoje, $strAmanha));
$listaBatePonto = $getBatePonto->fetchAll();

if (isset($_POST['cadastro'])) {
    $nome = $_POST['nome'];
    $tagid = $_POST['tagid'];
    $projeto = $_POST['projeto'];
    if ($projeto == '') {
        echo '<script>window.alert("Projeto não informado!"); window.location.replace("cadastro");</script>';
    } else {
        $getProjetoID = $pdo->prepare('SELECT id FROM Projetos WHERE projeto = ?');
        $getProjetoID->execute(array($projeto));
        $projetoID = $getProjetoID->fetch();

        $getTag = $pdo->prepare('SELECT tagid FROM Discentes WHERE tagid = ?');
        $getTag->execute(array($tagid));
        $tagExist = $getTag->fetch();

        $getTagListaEspera = $pdo->prepare('SELECT tagid FROM Espera WHERE tagid = ?');
        $getTagListaEspera->execute(array($tagid));
        $tagListaEspera = $getTagListaEspera->fetch();
        // Verifica se a tag já foi registrada.
        if (isset($tagExist[0])) {
            echo '<script>window.alert("Essa tag já foi registrada!"); window.location.replace("cadastro");</script>';
        } else {
            // Se a tag existe na lista de espera
            if (isset($tagListaEspera[0])) {
                $query = $pdo->prepare("DELETE FROM Espera WHERE tagid = ?");
                $query->execute(array($tagid));

                $query = $pdo->prepare("INSERT INTO Discentes(nome, tagid, projeto) VALUES(?, ?, ?);");
                $query->execute(array($nome, $tagid, $projetoID[0]));
                echo '<script>window.alert("Discente cadastrado com sucesso!"); window.location.replace("home");</script>';
            } else {
                $query = $pdo->prepare("INSERT INTO Discentes(nome, tagid, projeto) VALUES(?, ?, ?)");
                $query->execute(array($nome, $tagid, $projetoID[0]));
                echo '<script>window.alert("Discente cadastrado com sucesso!"); window.location.replace("home");</script>';
            }
        }
    }
}
// Se a pessoa bater ponto.
if (isset($_POST['checkin'])) {
    $tagid = $_POST['tagid'];
    $getTag = $pdo->prepare('SELECT id FROM Discentes WHERE tagid = ?');
    $getTag->execute(array($tagid));
    $userID = $getTag->fetch();

    // se a tag existe na tabela discentes
    if (isset($userID[0])) {
        $verifyBateuPonto = $pdo->prepare('SELECT h.bateponto FROM Horario AS h INNER JOIN Discentes AS p ON p.id = h.estudante WHERE p.tagid = ? ORDER BY h.hora DESC');
        $verifyBateuPonto->execute(array($tagid));
        $userBateuPonto = $verifyBateuPonto->fetch();

        // se a tag já bateu o ponto de entrada/saída.
        if ($userBateuPonto[0] === 1) {
            $bateuPonto = 0;
            $insertHorario = $pdo->prepare('INSERT INTO Horario(estudante, bateponto, hora, dia) VALUES(?, ?, ?, ?);');
            $insertHorario->execute(array($userID[0], $bateuPonto, $strHora, $strHoje));
        } else {
            $bateuPonto = 1;
            $insertHorario = $pdo->prepare('INSERT INTO Horario(estudante, bateponto, hora, dia) VALUES(?, ?, ?, ?);');
            $insertHorario->execute(array($userID[0], $bateuPonto, $strHora, $strHoje));
        }
        echo '<script>alert("Bateu ponto"); window.location.replace("home");</script>';
    } else {
        try {
            $query = $pdo->prepare("INSERT INTO Espera(tagid) VALUES(?)");
            $query->execute(array($tagid));
            echo '<script>alert("Essa tag não está cadastrada!"); window.location.replace("cadastro");</script>';
        } catch (\Throwable $th) {
            echo '<script>alert("Essa tag está na lista de espera para ser cadastrada!"); window.location.replace("cadastro");</script>';
        }
    }
}
