package logica_games;

import java.util.ArrayList;

public class Game implements Runnable {

    private boolean estaRodando;
    private Thread th;

    private ArrayList<Entidade> entidades = new ArrayList<>();

    public Game() {
        entidades.add(new Entidade());
        entidades.add(new Entidade());
        entidades.add(new Entidade());

        for (int i = 0; i < entidades.size(); i++) {
            Entidade e = entidades.get(0);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.iniciar();
    }

    public synchronized void iniciar() {
        estaRodando = true;
        th = new Thread(this);
        th.start();
    }

    public void atualizar() {
        // Atualizar o jogo.
        System.out.println("Atualizado");
    }

    public void renderizar() {
        // Renderizar o jogo.
        System.out.println("Renderizado");
    }

    @Override
    public void run() {
        while (estaRodando) {
            // atualizar();
            // renderizar();
            // Método de principante para limitar a velocidade de atualização para 60 quadros por segundo.
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
