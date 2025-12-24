//Haim Guetta- 209500585 ,Shahar Harel-211869490
package XO;

import java.util.ArrayList;
import java.util.List;

abstract class Game {
    private PlayerType[][] gameBoard;
    private PlayerType currentPlayer;

    protected Game(){
        gameBoard = new PlayerType[5][5];
        currentPlayer = PlayerType.X;
    }
    protected synchronized PlayerType getTurn(){
        return currentPlayer;
    }
    protected void printBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("["+gameBoard[i][j] + "] ");
                }
            }
            System.out.println();
        }
        System.out.println("* * * * * * * * * *");
    }

    protected synchronized List<Cell> getFreeCells() {
        List<Cell> freeCells = new ArrayList<>();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == null) {
                    freeCells.add(new Cell(i, j));
                }
            }
        }
        return freeCells;
    }
    protected synchronized boolean makeMove(Cell cell, PlayerType player){
        int row = cell.getRow();
        int col = cell.getCol();
        if(player!=currentPlayer) return false;
        if(gameBoard[row][col]!=null) return false;
        gameBoard[row][col] = player;
        currentPlayer = (currentPlayer==PlayerType.X)?PlayerType.O:PlayerType.X;
        return true;
    }
    protected synchronized boolean isBoardFull(){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if(gameBoard[i][j]==null) return false;
            }
        }
        return true;
    }
    protected synchronized PlayerType getWinner(){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if(gameBoard[i][j]==PlayerType.X){
                    if (j+3<5){
                        if(gameBoard[i][j+1]==PlayerType.X&&gameBoard[i][j+2]==PlayerType.X&&gameBoard[i][j+3]==PlayerType.X) return PlayerType.X;
                    }
                    if(i+3<5){
                        if(gameBoard[i+1][j]==PlayerType.X&&gameBoard[i+2][j]==PlayerType.X&&gameBoard[i+3][j]==PlayerType.X) return PlayerType.X;
                    }
                    if(j+3<5 && i+3<5){
                        if(gameBoard[i+1][j+1]==PlayerType.X&&gameBoard[i+2][j+2]==PlayerType.X&&gameBoard[i+3][j+3]==PlayerType.X) return PlayerType.X;
                    }
                    if(j-3>=0 && i+3<5){
                        if(gameBoard[i+1][j-1]==PlayerType.X&&gameBoard[i+2][j-2]==PlayerType.X&&gameBoard[i+3][j-3]==PlayerType.X) return PlayerType.X;
                    }
                }
                if(gameBoard[i][j]==PlayerType.O){
                    if (j+3<5){
                        if(gameBoard[i][j+1]==PlayerType.O&&gameBoard[i][j+2]==PlayerType.O&&gameBoard[i][j+3]==PlayerType.O) return PlayerType.O;
                    }
                    if(i+3<5){
                        if(gameBoard[i+1][j]==PlayerType.O&&gameBoard[i+2][j]==PlayerType.O&&gameBoard[i+3][j]==PlayerType.O) return PlayerType.O;
                    }
                    if(j+3<5 && i+3<5){
                        if(gameBoard[i+1][j+1]==PlayerType.O&&gameBoard[i+2][j+2]==PlayerType.O&&gameBoard[i+3][j+3]==PlayerType.O) return PlayerType.O;
                    }
                    if(j-3>=0 && i+3<5){
                        if(gameBoard[i+1][j-1]==PlayerType.O&&gameBoard[i+2][j-2]==PlayerType.O&&gameBoard[i+3][j-3]==PlayerType.O) return PlayerType.O;
                    }
                }
            }
        }
        return null;
    }




}
