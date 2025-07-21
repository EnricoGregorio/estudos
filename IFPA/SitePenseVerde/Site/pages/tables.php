<?php
    if (isset($_SESSION['admin'])) {
        echo '
        <main>
        <form action="pdo.php" method="post">
            <h2>Gestão da tabela</h2>
            <div class="turnos">
                <div class="turno-m">
                    <div class="segunda">
                        <label for="turno-m1">Turno da manhã de Segunda-feira:</label>
                            <input type="text" name="bairro1" id="turno-m1" placeholder="bairro(s)" required><br>
                    </div>
                    <div class="terca">
                        <label for="turno-m2">Turno da manhã de Terça-feira:</label>
                            <input type="text" name="bairro2" id="turno-m2" placeholder="bairro(s)" required><br>
                    </div>
                    <div class="quarta">
                        <label for="turno-m3">Turno da manhã de Quarta-feira:</label>
                            <input type="text" name="bairro3" id="turno-m3" placeholder="bairro(s)" required><br>
                    </div>
                    <div class="quinta">
                        <label for="turno-m4">Turno da manhã de Quinta-feira:</label>
                            <input type="text" name="bairro4" id="turno-m4" placeholder="bairro(s)" required><br>
                    </div>
                    <div class="sexta">
                        <label for="turno-m5">Turno da manhã de Sexta-feira:</label>
                            <input type="text" name="bairro5" id="turno-m5" placeholder="bairro(s)" required><br>
                    </div>
                    <div class="sabado">
                        <label for="turno-m6">Turno da manhã de Sábado:</label>
                            <input type="text" name="bairro6" id="turno-m6" placeholder="bairro(s)" required><br>
                    </div>
                </div>
                <div class="turno-v">
                    <div class="segunda">
                        <label for="turno-v1">Turno da tarde de Segunda-feira:</label>
                            <input type="text" name="bairro7" id="turno-v1" placeholder="bairro(s)" required>
                    </div>
                    <div class="terca">
                        <label for="turno-v2">Turno da tarde de Terça-feira:</label>
                            <input type="text" name="bairro8" id="turno-v2" placeholder="bairro(s)" required>
                    </div>
                    <div class="quarta">
                        <label for="turno-v3">Turno da tarde de Quarta-feira:</label>
                            <input type="text" name="bairro9" id="turno-v3" placeholder="bairro(s)" required>
                    </div>
                    <div class="quinta">
                        <label for="turno-v4">Turno da tarde de Quinta-feira:</label>
                            <input type="text" name="bairro10" id="turno-v4" placeholder="bairro(s)" required>
                    </div>
                    <div class="sexta">
                        <label for="turno-v5">Turno da tarde de Sexta-feira:</label>
                            <input type="text" name="bairro11" id="turno-v5" placeholder="bairro(s)" required>
                    </div>
                    <sabado>
                        <label for="turno-v6">Turno da tarde de Sábado:</label>
                            <input type="text" name="bairro12" id="turno-v6" placeholder="bairro(s)" required>
                    </sabado>
                </div>
            </div>
                <input type="submit" value="Atualizar!" name="tabela" class="sub-tabela">
        </form>
        <p><a turno-mef="/" target="_self">Clique aqui</a> para voltar para a página principal.</p>
    </main>';
    } else {
        header('Location: admin');
    }
?>