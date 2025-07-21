package graficos;                       // Define o pacote onde a classe está localizada.

import java.awt.image.BufferedImage;    // Representa uma imagem em memória.
import java.io.IOException;             // Trata exceções de entrada/saída.

import javax.imageio.ImageIO;           // Classe utilitária para ler/escrever imagens.

public class Spritesheet {              // Classe responsável por carregar e fornecer partes de uma imagem (sprites).
    private BufferedImage spritesheet;  // Armazena a imagem completa da spritesheet.

    public Spritesheet(String caminho) { // Construtor que recebe o caminho da imagem da spritesheet.
        try {
            // Tenta carregar a imagem a partir do caminho fornecido dentro do diretório de recursos do projeto.
            spritesheet = ImageIO.read(getClass().getResource(caminho));
        } catch (IOException e) {
            // Caso ocorra erro ao carregar a imagem, imprime a exceção.
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y, int largura, int altura) {
        // Retorna uma subimagem (sprite) recortada da spritesheet, com base nas coordenadas e tamanho passados.
        return spritesheet.getSubimage(x, y, largura, altura);
    }
}
