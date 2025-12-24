//Haim Guetta- 209500585 ,Shahar Harel-211869490
package stocks;

public class StockUpdateThread extends Thread{
    private StockServer server;

    public StockUpdateThread(StockServer server){
        this.server = server;
    }

    public void run(){
        for (int i = 0; i < 10; i++){
            server.UpdateStock(StockServer.Stock.MICROSOFT);
            server.UpdateStock(StockServer.Stock.APPLE);
            server.UpdateStock(StockServer.Stock.GOOGLE);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
