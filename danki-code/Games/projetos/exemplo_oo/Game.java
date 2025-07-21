package exemplo_oo;

public class Game {
    private Player p1;
    private Inimigo ini;

    public Game() {
        p1 = new Player();
        ini = new Inimigo();
    }

    public Player getJogador(){
        return this.p1;
    }

    public Inimigo getInimigo(){
        return this.ini;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = game.getJogador();
        player1.attackEnemy(game.getInimigo());
        System.out.println(game.getInimigo().life);
    }
}