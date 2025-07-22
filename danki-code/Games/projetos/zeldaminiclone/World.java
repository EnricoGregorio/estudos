package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
    protected final int WIDTH = Game.WIDTH;
    protected final int HEIGHT = Game.HEIGHT;

    public static List<Block> blocks = new ArrayList<Block>();

    public World() {
        for (int xx = 0; xx < 15 * 2; xx++) {
            blocks.add(new Block(xx * 32, 0));
        }

        for (int xx = 0; xx < 15 * 2; xx++) {
            blocks.add(new Block(xx * 32, HEIGHT - 32));
        }

        for (int yy = 0; yy < 15 * 2; yy++) {
            blocks.add(new Block(0, yy * 32));
        }

        for (int yy = 0; yy < 15 * 2; yy++) {
            blocks.add(new Block(WIDTH - 32, yy * 32));
        }
    }

    public static boolean isFree(int x, int y) {
        for (int i = 0; i < blocks.size(); i++) {
            Block actualBlock = blocks.get(i);
            if (actualBlock.intersects(new Rectangle(x, y, 32, 32))) {
                return false;
            }
        }

        return true;
    }

    public void render(Graphics g) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);
        }
    }
}
