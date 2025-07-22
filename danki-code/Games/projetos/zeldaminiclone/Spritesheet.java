package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
    private final int WIDTH = 16, HEIGHT = 16;

    protected static BufferedImage spritesheet;
    protected static BufferedImage[] playerDown;
    protected static BufferedImage[] playerRight;
    protected static BufferedImage[] playerUP;
    protected static BufferedImage[] playerLeft;


    protected static BufferedImage tileWall;

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("res/spritesheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        playerDown = new BufferedImage[2];
        playerRight = new BufferedImage[2];
        playerUP = new BufferedImage[2];
        playerLeft = new BufferedImage[2];

        playerDown[0] = Spritesheet.getSprite(0, 11, WIDTH, HEIGHT);
        playerDown[1] = Spritesheet.getSprite(18, 11, WIDTH, HEIGHT);

        playerRight[0] = Spritesheet.getSprite(35, 11, WIDTH, HEIGHT);
        playerRight[1] = Spritesheet.getSprite(51, 11, WIDTH, HEIGHT);

        playerUP[0] = Spritesheet.getSprite(69, 11, WIDTH, HEIGHT);
        playerUP[1] = Spritesheet.getSprite(86, 11, WIDTH, HEIGHT);

        playerLeft[0] = Spritesheet.getSprite(35, 28, WIDTH, HEIGHT);
        playerLeft[1] = Spritesheet.getSprite(51, 28, WIDTH, HEIGHT);

        tileWall = Spritesheet.getSprite(280, 221, WIDTH, HEIGHT);
    }

    public static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}
