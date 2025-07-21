package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
    private final int WIDTH = 16, HEIGHT = 16;

    protected static BufferedImage spritesheet;
    protected static BufferedImage player_front;
    protected static BufferedImage tileWall;

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("res/spritesheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        player_front = Spritesheet.getSprite(0, 11, WIDTH, HEIGHT);
        tileWall = Spritesheet.getSprite(280, 221, WIDTH, HEIGHT);
    }

    public static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}
