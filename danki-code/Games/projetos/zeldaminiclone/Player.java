package zeldaminiclone;

// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
    protected boolean down, right, up, left;
    private int speed = 1;

    private int curFrames = 0, targetFrames = 30;
    private int[] curAnimation = { 0, 0, 0, 0}; // Baixo, Direita, Cima, Esquerda.
    private int curState = 0;

    public Player(int x, int y) {
        super(x, y, 32, 32);
    }

    public int anime(int indexCurAnimation, boolean isMove) {
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

    public void update() {
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
    }

    public void render(Graphics g) {
        if (down || curState == 0) {
            g.drawImage(Spritesheet.playerDown[curAnimation[0]], x, y, 32, 32, null);
        } else if (right || curState == 1) {
            g.drawImage(Spritesheet.playerRight[curAnimation[1]], x, y, 32, 32, null);
        } else if (up || curState == 2) {
            g.drawImage(Spritesheet.playerUP[curAnimation[2]], x, y, 32, 32, null);
        } else if (left || curState == 3) {
            g.drawImage(Spritesheet.playerLeft[curAnimation[3]], x, y, 32, 32, null);
        }
    }
}
