//Haim Guetta- 209500585 ,Shahar Harel-211869490
package stocks;

import java.security.InvalidParameterException;
import java.util.Random;

public class StockServer {
        private final Random random = new Random();

        private int microsoftValue = 220;
        private int appleValue = 110;
        private int googleValue = 1512;

        public enum Stock {
            MICROSOFT,
            APPLE,
            GOOGLE
        }

        public synchronized int GetStock(Stock stock) {
            switch(stock) {
                case MICROSOFT:
                    return microsoftValue;
                case APPLE:
                    return appleValue;
                case GOOGLE:
                    return googleValue;
                default:
                    throw new InvalidParameterException("no such stock type");
            }
        }

        public synchronized void UpdateStock(Stock stock) {
            int newValue = 100 + random.nextInt(401);
            switch(stock) {
                case MICROSOFT:
                    microsoftValue = newValue;
                    break;
                case APPLE:
                    appleValue = newValue;
                    break;
                case GOOGLE:
                    googleValue = newValue;
            }
        }

    }



