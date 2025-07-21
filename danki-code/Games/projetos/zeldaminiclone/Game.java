package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

    private static final int WIDTH = 480, HEIGHT = 480;
    private Thread thread;
    private boolean isRunning;

    protected Player player;
    protected World world;

    public Game() {
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        new Spritesheet();
        initFrame();
        player = new Player(36, 36);
        world = new World();
    }

    public void initFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Mini Zelda");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void startGame() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public void stopGame() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        player.update();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graph = bs.getDrawGraphics();
        graph.setColor(new Color(0, 135, 13));
        graph.fillRect(0, 0, WIDTH, HEIGHT);
        player.render(graph);
        world.render(graph);
        bs.show();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long now;
        double timer = System.currentTimeMillis();
        double fps = 60.0;
        double ns = 1000000000 / fps;
        double delta = 0;
        int frames = 0;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                frames++;
                delta--;
            }

            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }
        }
        stopGame();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = false;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
