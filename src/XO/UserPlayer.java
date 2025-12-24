package XO;
import java.util.Scanner;

public class UserPlayer extends Player{
    private Scanner scanner;
    public UserPlayer(PlayerType playerType, Game game) {
        super(playerType, game);
        scanner = new Scanner(System.in);
    }
    @Override
    public void run() {
        while (true){
            if (game.getWinner()!=null|| game.isBoardFull()) break;
            if (game.getTurn()!=playerType) {
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    break;
                }
                continue;
            }
            System.out.println("Player " + playerType + ", enter row and column (0-4):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Cell cell = new Cell(row, col);

            boolean success = game.makeMove(cell, playerType);
            if (success) game.printBoard();
            else System.out.println("Invalid move!");
            sleepQuietly();
        }
    }
    private void sleepQuietly() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
