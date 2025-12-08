package stocks;

public class Main {
    public static void main(String[] args) {
        StockServer stockServer = new StockServer();
        StockReaderThread T1 = new StockReaderThread(stockServer, StockServer.Stock.MICROSOFT, "Tami Tan");
        StockReaderThread T2 = new StockReaderThread(stockServer, StockServer.Stock.APPLE, "Tim Sroly");
        StockReaderThread T3 = new StockReaderThread(stockServer, StockServer.Stock.GOOGLE, "Sima Didse");
        StockUpdateThread updater = new StockUpdateThread(stockServer);
        T1.start();
        T2.start();
        T3.start();
        updater.start();
    }
}
