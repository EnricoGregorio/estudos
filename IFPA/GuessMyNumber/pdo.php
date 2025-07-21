<?php
$pdo = new PDO('mysql:host=sql211.epizy.com;dbname=epiz_32965820_dbguessmynumber', 'epiz_32965820', '6XvjvwtIboMo');

$getAutores = $pdo->prepare("SELECT nomes FROM Autores");
$getAutores->execute();
$autores = $getAutores->fetchAll();
