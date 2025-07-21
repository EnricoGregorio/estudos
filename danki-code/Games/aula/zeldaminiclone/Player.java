package zeldaminiclone;

// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
    protected boolean right, up, down, left;
    private int speed = 4;

    public Player(int x, int y) {
        super(x, y, 32, 32);
    }

    public void update() {
        if (right && World.isFree(x + speed, y)) {
            x += speed;
        } else if (left && World.isFree(x - speed, y)) {
            x -= speed;
        }

        if (up && World.isFree(x, y - speed)) {
            y -= speed;
        } else if (down && World.isFree(x, y + speed)) {
            y += speed;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Spritesheet.player_front, x, y,32, 32, null);
    }
}
