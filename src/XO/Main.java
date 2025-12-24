//Haim Guetta- 209500585 ,Shahar Harel-211869490
package XO;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Choose game mode:");
        System.out.println("1 - Computer vs Computer");
        System.out.println("2 - Computer vs User");
        int mode = new Scanner(System.in).nextInt();
        Game game;
        Player player1;
        Player player2;
        if (mode==1){
            game=new SelfGame();
            player1= new SelfPlayer(PlayerType.X, game);
            player2= new SelfPlayer(PlayerType.O, game);
        }
        else{
            game=new UserGame();
            player1= new UserPlayer(PlayerType.X, game);
            player2= new SelfPlayer(PlayerType.O, game);
        }
        game.printBoard();
        player1.start();
        player2.start();

        try {
            player1.join();
            player2.join();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        PlayerType winner = game.getWinner();
        if (winner!=null) System.out.println("Winner is: " + winner);
        else System.out.println("Draw!");
    }

}
