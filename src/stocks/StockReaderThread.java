//Haim Guetta- 209500585 ,Shahar Harel-211869490
package stocks;

import java.util.Random;

public class StockReaderThread extends Thread{
    private final Random random = new Random();
    private StockServer stockServer;
    private StockServer.Stock stock;
    private String name;

    public StockReaderThread(StockServer stockServer, StockServer.Stock stock, String name) {
        this.stockServer = stockServer;
        this.stock = stock;
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 10; i++){
            int value = stockServer.GetStock(stock);
            System.out.println("Name: " + name + ", " + stock + " Stock: "+ value + " USD" );

            int sleepTime = 1000+random.nextInt(2000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
