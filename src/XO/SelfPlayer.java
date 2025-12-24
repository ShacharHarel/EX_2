package XO;

import java.util.List;

public class SelfPlayer extends Player {
    public SelfPlayer(PlayerType playerType, Game game) {
        super(playerType, game);
    }
    @Override
    public void run() {
        while (true){
            if (game.isBoardFull()|| game.getWinner()!=null){
                break;
            }
            if (game.getTurn()!= playerType) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                break;
            }
            List<Cell> freeCells = game.getFreeCells();
            if (!freeCells.isEmpty()){
                int randomIndex = (int) (Math.random() * freeCells.size());
                Cell randomCell = freeCells.get(randomIndex);
                boolean success = game.makeMove(randomCell, playerType);
                if (success) game.printBoard();
            }
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
