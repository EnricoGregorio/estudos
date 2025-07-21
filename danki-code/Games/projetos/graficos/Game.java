package graficos;                   // Define o pacote em que esta classe está localizada.

import java.awt.Canvas;             // Importa a classe Canvas para permitir desenho gráfico.
import java.awt.Color;              // Importa a classe Color para manipulação de cores.
import java.awt.Dimension;          // Importa a classe Dimension para definir largura e altura.
import java.awt.Font;               // Importa a classe Font para definir estilos e tamanhos de fonte.
import java.awt.Graphics;           // Importa a classe Graphics para desenhar na tela.
import java.awt.Graphics2D;         // Importa a classe Graphics2D, que oferece recursos gráficos avançados (como rotação, escala, etc).
import java.awt.image.BufferStrategy;       // Usado para evitar "flickering" (tremores visuais) ao renderizar.
import java.awt.image.BufferedImage;        // Usado como imagem intermediária para desenhar os gráficos.

import javax.swing.JFrame;          // Importa a classe JFrame para criar uma janela gráfica.

// Define a classe Game que herda de Canvas e implementa Runnable (permite ser usada em uma thread).
public class Game extends Canvas implements Runnable {

    public static JFrame frame;                     // Cria uma variável estática para armazenar a janela principal do jogo.

    private Thread thread;                          // Representa a thread que vai executar o loop do jogo.
    private boolean estaRodando;                    // Flag que controla se o jogo está em execução ou não.

    private final int ESCALA = 5;                   // Fator de escala (aumenta o tamanho da tela final).
    private final int LARGURA = 240;                // Largura base da tela (sem aplicar escala).
    private final int ALTURA = 160;                 // Altura base da tela (sem aplicar escala).

    private BufferedImage imagem;                   // Imagem que será desenhada em cada frame (buffer de renderização).
    private Spritesheet sheet;                      // Objeto que representa a spritesheet (folha de sprites).

    private BufferedImage[] jogador;                // Vetor de imagens contendo os frames da animação do jogador.
    private int frames = 0;                         // Contador de frames que controla o tempo da troca de sprites.
    private int maxFrames = 5;                      // Quantidade de frames antes de trocar para o próximo sprite da animação.
    private int animacaoAtual = 0, animacaoMax = 4; // Índice atual da animação e quantidade total de sprites (0 a 3).

    // Construtor da classe Game.
    public Game() {
        sheet = new Spritesheet("res/spritesheet.png");              // Carrega a spritesheet com os frames do personagem.
        jogador = new BufferedImage[4];                                      // Inicializa o vetor que armazenará os 4 sprites do jogador.
        jogador[0] = sheet.getSprite(0, 0, 20, 20);       // Extrai o primeiro sprite da spritesheet.
        jogador[1] = sheet.getSprite(20, 0, 20, 20);      // Extrai o segundo sprite da spritesheet.
        jogador[2] = sheet.getSprite(40, 0, 20, 20);      // Extrai o terceiro sprite da spritesheet.
        jogador[3] = sheet.getSprite(60, 0, 20, 20);      // Extrai o quarto sprite da spritesheet.

        this.setPreferredSize(new Dimension(LARGURA * ESCALA, ALTURA * ESCALA));    // Define o tamanho do Canvas com base na resolução e escala.
        iniciarFrame();                                                             // Cria e exibe a janela do jogo.
        imagem = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_RGB); 
        // Cria uma imagem do tipo RGB com a resolução base. Usada para desenhar os gráficos antes de exibir na tela.
    }

    // Método para criar uma nova janela gráfica.
    public void iniciarFrame() {
        frame = new JFrame("Game #1");                        // Cria a janela com título "Game #1".
        frame.add(this);                                            // Adiciona o Canvas à janela.
        frame.setResizable(false);                        // Impede o redimensionamento da janela.
        frame.pack();                                               // Ajusta o tamanho da janela para caber no Canvas.
        frame.setLocationRelativeTo(null);                        // Centraliza a janela na tela.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // Encerra o programa ao fechar a janela.
        frame.setVisible(true);                                   // Torna a janela visível.
    }

    // Método sincronizado que inicia o jogo em uma nova thread.
    public synchronized void iniciarJogo() {
        thread = new Thread(this);       // Cria uma nova thread que usará o método run().
        estaRodando = true;              // Define que o jogo está ativo.
        thread.start();                  // Inicia a thread (executará o método run()).
    }

    // Método sincronizado que irá parar o jogo (ainda não implementado).
    public synchronized void pararJogo() {
        // Aqui normalmente você mudaria "estaRodando" para false
        // e usaria thread.join() para esperar a thread finalizar.
        estaRodando = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método principal: ponto de entrada do programa.
    public static void main(String[] args) {
        Game game = new Game();           // Cria uma instância do jogo (e a janela).
        game.iniciarJogo();               // Inicia o loop do jogo.
    }

    // Método de atualização do jogo (lógica, física etc.)
    public void atualizarJogo() {
        // Onde a lógica do jogo será atualizada a cada frame.
        frames++;
        if (frames > maxFrames) {
            frames = 0;
            animacaoAtual++;
            if (animacaoAtual >= animacaoMax) {
                animacaoAtual = 0;
            }
        }
    }

    // Método de renderização do jogo (desenha na tela).
    public void renderizarJogo() {
        BufferStrategy bs = this.getBufferStrategy();     // Tenta obter o buffer de renderização existente.
        if (bs == null) {                                 // Se ainda não existe...
            this.createBufferStrategy(3);      // Cria um triplo buffer para suavizar os gráficos.
            return;                                       // Aguarda o próximo frame após criação.
        }

        Graphics g = imagem.getGraphics();                // Obtém um contexto gráfico da imagem (off-screen).

        // Renderizando um retângulo.
        g.setColor(new Color(100, 100, 100));         // Define a cor rosa para o fundo.
        g.fillRect(0, 0, LARGURA, ALTURA);            // Preenche todo o fundo da imagem de um retângulo com a cor definida.

        // Renderização do jogador.
        // g2.setColor(new Color(0, 0,0, 100));           // Layer no jogo.
        // g2.fillRect(0, 0, LARGURA, ALTURA);
        Graphics2D g2 = (Graphics2D) g;                   // Converte o contexto gráfico para Graphics2D, permitindo efeitos avançados.
        // g2.rotate(Math.toRadians(45), 90, 90);         // Exemplo comentado de rotação da imagem (não está sendo usado no momento).
        g2.drawImage(jogador[animacaoAtual], 90, 90, null);      // Desenha o sprite atual do jogador na posição (90, 90).


        // 
        g.dispose();    // Libera os recursos usados pelo contexto gráfico da imagem.
        
        // Renderizando um círculo;
        g.setColor(Color.CYAN);                           // Define a cor ciano para o objeto.
        g.fillOval(20, 20, 80, 80);      // Preenche todo o fundo do objeto oval com a cor definida.

        // Renderizando uma String.
        g.setColor(Color.BLACK);                                // Definindo a cor da fonte.
        g.setFont(new Font("Arial", Font.BOLD, 20));  // Definindo a fonte (nome da fonte, estilização, tamanho).
        g.drawString("Olá, Mundo!", 30, 30);
        
        g = bs.getDrawGraphics();                         // Obtém o contexto gráfico do buffer atual da tela.
        g.drawImage(imagem, 0, 0, LARGURA * ESCALA, ALTURA * ESCALA, null); 
        // Desenha a imagem bufferizada (já pintada) ampliada com a escala definida.

        bs.show();                                        // Exibe o frame na tela, trocando os buffers.
    }

    // Loop principal do jogo, executado pela thread.
    @Override
    public void run() {
        long ultimoMomento = System.nanoTime();             // Armazena o tempo da última atualização.
        double qtdDeFrames = 60.0;                          // Alvo de 60 frames por segundo.
        double nanoSegundo = 1000000000 / qtdDeFrames;      // Tempo (em nanossegundos) entre cada frame.
        double delta = 0;                                   // Acumula frações de frame até chegar a 1.
        int frames = 0;                                     // Contador de frames para medir FPS.
        double timer = System.currentTimeMillis();          // Marca o tempo inicial em milissegundos.

        while (estaRodando) {                               // Loop de execução do jogo.
            long agora = System.nanoTime();                 // Marca o tempo atual.
            delta += (agora - ultimoMomento) / nanoSegundo; // Soma o tempo passado em "frações de frame".
            ultimoMomento = agora;                          // Atualiza o tempo de referência.

            if (delta >= 1) {                               // Quando acumular o tempo de 1 frame...
                atualizarJogo();                            // Atualiza a lógica do jogo.
                renderizarJogo();                           // Renderiza um novo frame.
                frames++;                                   // Conta mais um frame.
                delta--;                                    // Reduz o delta (tempo restante para o próximo frame).
            }

            // Se passou 1 segundo, exibe o número de frames gerados no período.
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);       // Mostra o FPS atual no console.
                frames = 0;                                 // Reinicia o contador de frames.
                timer += 1000;                              // Reinicia o temporizador.
            }
        }
        pararJogo();
    }
}