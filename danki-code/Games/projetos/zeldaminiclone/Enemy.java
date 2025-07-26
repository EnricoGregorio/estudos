package zeldaminiclone;

// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle {
    private int speed = 2;
    private Random rand = new Random();

    protected static List<Bullet> bullets = new ArrayList<Bullet>();

    protected Enemy(int x, int y) {
        super(x, y, 32, 32);
    }

    private void followPlayer() {
        Player p = Game.player;
        if (x < p.x && World.isFree(x + speed, y)) {
            if (rand.nextInt(100) < 50)
                x += speed;
        } else if (x > p.x && World.isFree(x - speed, y)) {
            if (rand.nextInt(100) < 50)
                x -= speed;
        }

        if (y < p.y && World.isFree(x, y + speed)) {
            if (rand.nextInt(100) < 50)
                y += speed;
        } else if (y > p.y && World.isFree(x, y - speed)) {
            if (rand.nextInt(100) < 50)
                y -= speed;
        }
    }

    protected void update() {
        followPlayer();
    }

    protected void render(Graphics g) {
        g.drawImage(Spritesheet.enemy, x, y, 32, 32, null);
    }
}
