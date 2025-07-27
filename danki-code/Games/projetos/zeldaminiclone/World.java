package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final int MAX_BLOCKS_W = Game.WIDTH * Game.SCALE;
    private final int MAX_BLOCKS_H = Game.HEIGHT * Game.SCALE;

    private static List<Block> blocks = new ArrayList<Block>();

    protected World() {
        for (int xx = 0; xx < MAX_BLOCKS_W / 32; xx++) {
            blocks.add(new Block(xx * 32, 0));
        }

        for (int xx = 0; xx < MAX_BLOCKS_W / 32; xx++) {
            blocks.add(new Block(xx * 32, MAX_BLOCKS_H - 32));
        }

        for (int yy = 0; yy < MAX_BLOCKS_H / 32; yy++) {
            blocks.add(new Block(0, yy * 32));
        }

        for (int yy = 0; yy < MAX_BLOCKS_H / 32; yy++) {
            blocks.add(new Block(MAX_BLOCKS_W - 32, yy * 32));
        }

        blocks.add(new Block(140, 90));
    }

    protected static boolean isFree(int x, int y) {
        for (int i = 0; i < blocks.size(); i++) {
            Block actualBlock = blocks.get(i);
            if (actualBlock.intersects(new Rectangle(x, y, 32, 32))) {
                return false;
            }
        }

        return true;
    }

    protected void render(Graphics g) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);
        }
    }
}
