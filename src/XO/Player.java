//Haim Guetta- 209500585 ,Shahar Harel-211869490
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
