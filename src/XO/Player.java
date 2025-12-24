package XO;

public abstract class Player extends Thread{
    protected PlayerType playerType;
    protected Game game;
    public Player(PlayerType playerType, Game game){
        this.playerType = playerType;
        this.game = game;
    }
    public abstract void run();
}
