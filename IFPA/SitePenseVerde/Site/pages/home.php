<main>
    <section id="acompanhe">
        <div class="mapa">
            <iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d7968.7388987665545!2d-47.350712617653855!3d-2.994772042714856!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spt-BR!2sbr!4v1639960342007!5m2!1spt-BR!2sbr" loading="lazy"></iframe>
            <p>Para ver o sistema em tempo real basta copiar o usuário <mark>prefeituraparagominas@gmail.com</mark> e a senha <mark>123</mark> ao entrar <a href="http://www.gpsbs.com.br/login" target="_blank">neste link</a>!</p>
        </div>
        <div class="tabela">
            <table>
                <tr>
                    <th></th>
                    <th scope="col">Segunda-feira</th>
                    <th scope="col">Terça-feira</th>
                    <th scope="col">Quarta-feira</th>
                    <th scope="col">Quinta-feira</th>
                    <th scope="col">Sexta-feira</th>
                    <th scope="col">Sábado</th>
                </tr>
                <tr>
                    <th scope="row">Manhã</th>
                    <?php
                    for ($i=0; $i <= 5; $i++) { 
                        echo '<td>' . $dadosTable[$i]['bairros'] . '</td>';
                    }
                    ?>
                </tr>
                <tr>
                    <th scope="row">Tarde</th>
                    <?php
                    for ($i=6; $i <= 11; $i++) { 
                        echo '<td>' . $dadosTable[$i]['bairros'] . '</td>';
                    }
                    ?>
                </tr>
            </table>
    </section>
    <section id="sobre-nos">
        <h2><em>Sobre nós</em></h2>
        <p class="sobre">O programa de coleta seletiva foi implantado no município de Paragominas no ano de 2018 e é gerenciado pela Prefeitura Municipal, através da <abbr title="Secretaria Municipal do Verde e Meio Ambiente">SEMMA</abbr> e <abbr title="Secretaria Municipal de Urbanismo">SEMUR</abbr>, sendo as atividades no galpão de triagem de responsabilidade da Cooperativa de Materiais Recicláveis de Paragominas - COOPERCAMARE, localizada na Rodovia Clodomiro de Figueiredo Bicalho, S/N, bairro Distrito Industrial.</p>
        <p class="sobre">A COOPERCAMARE foi criada em 2008, por um grupo de catadores autônomos, que realizavam a catação de materiais recicláveis diretamente na célula de destinação final dos resíduos domiciliares urbanos, em condições totalmente insalubres. Como forma de reverter este cenário, a Prefeitura de Paragominas firmou parceria com a cooperativa, trabalhando primeiramente na sua regularização institucional e posteriormente transferindo-os para um galpão com toda a estrutura necessária para coleta, triagem e comercialização dos resíduos.</p>
        <p class="sobre">Visando o aperfeiçoamento e consolidação da cooperativa, a empresa Hydro, em cumprimento a uma condicionante socioambiental estabelecida pela <abbr title="Secretaria Municipal do Verde e Meio Ambiente">SEMMA</abbr>, subsidiou por um período de dois anos e meio, o projeto de fortalecimento da COOPERCAMARE, por meio do suporte técnico da <abbr title="Organização Não Governamental">ONG</abbr> Gaia Negócios Sociais. No decorrer desse tempo, foram realizadas mentorias em Desenvolvimento de Lideranças; capacitação em Marco regulatório e Políticas Públicas (Estadual e Federal); treinamento em Elaboração de Projetos e Captação de Recursos; orientação e acompanhamento técnico sobre Ferramentas de Gestão Administrativo-Financeira, etc.</p>
        <p class="sobre">Atualmente a COOPERCAMARE é uma sociedade civil de responsabilidade limitada e possui 27 membros, tem a missão de enfatizar a importância da reciclagem, gerar renda e emprego e promover o desenvolvimento sustentável do município. Dessa forma, a cooperativa tem um importante papel na logística da rota tecnológica dos resíduos sólidos urbanos e na introdução do modelo de economia circular em Paragominas, minimizando a quantidade de resíduos que seriam destinados diretamente às células de tratamento do aterro e mantendo os materiais em uso ao serem re-inseridos no ciclo de produção.</p>
    </section>
    <section id="noticias">
        <div id="noticias-hub">
            <?php
            foreach ($dadosPosts as $key => $value) {
                echo 
                '<a class="post" href="posts/'.$value['nomearquivo'].'" target="_self">
                    <div class="resumo-item">
                        <h3>'.$value['titulo'].'</h3>
                        <p>'.$value['resumo'].'</p>
                    </div>
                </a>';
            }
            ?>
        </div>
        <div id="paginacao">
            <button id="anterior" disabled>&lsaquo;</button>
            <span id="numeracao"></span>
            <button id="proximo" disabled>&rsaquo;</button>
        </div>
    </section>
</main>