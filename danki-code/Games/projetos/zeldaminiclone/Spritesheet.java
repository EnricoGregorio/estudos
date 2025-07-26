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

    protected static BufferedImage[] bullet;

    protected static BufferedImage enemy;

    protected static BufferedImage tileWall;

    protected Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("res/spritesheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        playerDown = new BufferedImage[2];
        playerRight = new BufferedImage[2];
        playerUP = new BufferedImage[2];
        playerLeft = new BufferedImage[2];

        bullet = new BufferedImage[4];

        playerDown[0] = Spritesheet.getSprite(3, 14, WIDTH, HEIGHT);
        playerDown[1] = Spritesheet.getSprite(21, 14, WIDTH, HEIGHT);

        playerRight[0] = Spritesheet.getSprite(38, 14, WIDTH, HEIGHT);
        playerRight[1] = Spritesheet.getSprite(54, 14, WIDTH, HEIGHT);

        playerUP[0] = Spritesheet.getSprite(72, 14, WIDTH, HEIGHT);
        playerUP[1] = Spritesheet.getSprite(89, 14, WIDTH, HEIGHT);

        playerLeft[0] = Spritesheet.getSprite(37, 31, WIDTH, HEIGHT);
        playerLeft[1] = Spritesheet.getSprite(53, 31, WIDTH, HEIGHT);

        tileWall = Spritesheet.getSprite(283, 224, WIDTH, HEIGHT);

        enemy = Spritesheet.getSprite(37, 235, WIDTH, HEIGHT);

        bullet[0] = Spritesheet.getSprite(23, 205, 7, HEIGHT);
        bullet[1] = Spritesheet.getSprite(13, 188, WIDTH, HEIGHT);
        bullet[2] = Spritesheet.getSprite(5, 188, 7, HEIGHT);
        bullet[3] = Spritesheet.getSprite(6, 205, WIDTH, HEIGHT);

    }

    private static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}
