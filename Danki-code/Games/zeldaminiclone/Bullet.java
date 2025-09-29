package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle {

    private int dir = 1;
    private int speed = 4;
    private int frames = 0;
    private int curState = Player.curState;

    protected Bullet(int x, int y, int dir) {
        super(x + 16, y, 10, 10);
        this.dir = dir;
    }

    protected void update() {
        switch (curState) {
            case 0:
                y += speed * dir;
                frames++;
                break;
            case 1:
                x += speed * dir;
                frames++;
                break;
            case 2:
                y -= speed * dir;
                frames++;
                break;
            case 3:
                x -= speed * dir;
                frames++;
                break;
            default:
                break;
        }

        if (frames == 60) {
            Player.bullets.remove(this);
        }
    }

    protected void render(Graphics g) {
        switch (curState) {
            case 0:
                g.drawImage(Spritesheet.bullet[0], x - 8, y + 4, 16, 32, null);
                break;
            case 1:
                g.drawImage(Spritesheet.bullet[1], x, y, 32, 32, null);
                break;
            case 2:
                g.drawImage(Spritesheet.bullet[2], x - 8, y - 4, 16, 32, null);
                break;
            case 3:
                g.drawImage(Spritesheet.bullet[3], x - 16, y, 32, 32, null);
                break;
            default:
                break;
        }
    }
}
