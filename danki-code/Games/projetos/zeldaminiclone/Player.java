package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle {
    protected boolean down, right, up, left, shoot;
    private int speed = 2;

    private int curFrames = 0, targetFrames = 30;
    private int[] curAnimation = { 0, 0, 0, 0 }; // Baixo, Direita, Cima, Esquerda.
    protected static int curState = 0;

    protected static List<Bullet> bullets = new ArrayList<Bullet>();

    protected Player(int x, int y) {
        super(x, y, 32, 32);
    }

    private int anime(int indexCurAnimation, boolean isMove) {
        if (isMove) {
            curFrames++;
            if (curFrames == targetFrames) {
                curFrames = 0;
                curAnimation[indexCurAnimation]++;
                if (curAnimation[indexCurAnimation] == Spritesheet.playerDown.length) {
                    curAnimation[indexCurAnimation] = 0;
                }
            }
        } else {
            curAnimation[indexCurAnimation] = 0;
        }
        return indexCurAnimation;
    }

    protected void update() {
        boolean moved = false;

        if (right && World.isFree(x + speed, y)) {
            x += speed;
            moved = true;
            anime(1, moved); // O "1" é o index do "curAnimation", ou seja, estamos solicitando para realizar
                             // os movimentos do "playerRight"
            curState = anime(1, moved);
        } else if (left && World.isFree(x - speed, y)) {
            x -= speed;
            moved = true;
            anime(3, moved);
            curState = anime(3, moved);
        }

        if (up && World.isFree(x, y - speed)) {
            y -= speed;
            moved = true;
            anime(2, moved);
            curState = anime(2, moved);
        } else if (down && World.isFree(x, y + speed)) {
            y += speed;
            moved = true;
            anime(0, moved);
            curState = anime(0, moved);
        }

        if (shoot) {
            shoot = false;
            bullets.add(new Bullet(x, y, 1));
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
        }
    }

    protected void render(Graphics g) {
        if (down || curState == 0) {
            g.drawImage(Spritesheet.playerDown[curAnimation[0]], x, y, 32, 32, null);
        } else if (right || curState == 1) {
            g.drawImage(Spritesheet.playerRight[curAnimation[1]], x, y, 32, 32, null);
        } else if (up || curState == 2) {
            g.drawImage(Spritesheet.playerUP[curAnimation[2]], x, y, 32, 32, null);
        } else if (left || curState == 3) {
            g.drawImage(Spritesheet.playerLeft[curAnimation[3]], x, y, 32, 32, null);
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).render(g);
            ;
        }
    }
}
