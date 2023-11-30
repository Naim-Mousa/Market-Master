package stockProjectOOP;

import java.util.List;

public class PortfolioItem {
    private String stockName;
    private int sharesOwned;
    private double purchasePrice;
    private Stock stockReference;

/*=======================
CONSTRUCTOR: PortfolioItem
INPUT: stock (Stock) - the stock object, sharesOwned (int) - number of shares owned,
        purchasePrice (double) - the price at which the shares were purchased.
PROCESSING: Initializes a PortfolioItem with stock details and ownership information.
OUTPUT: none
=======================*/
    public PortfolioItem(Stock stock, int sharesOwned, double purchasePrice) {
        this.stockName = stock.getStockName();
        this.sharesOwned = sharesOwned;
        this.purchasePrice = purchasePrice;
        this.stockReference = stock;
    }

/*------------------
GETTERS AND SETTERS
-------------------*/

    public String getStockName() {
        return stockName;
    }

    public int getSharesOwned() {
        return sharesOwned;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getCurrentValue() {
        return sharesOwned * stockReference.getPrice();
    }

    public double getStockMarketCap() {
        return stockReference.getMarketCap();
    }

    public double getStockVolatility() {
        return stockReference.getVolatility();
    }

    public List<Double> getStockPriceHistory() {
        return stockReference.getPriceHistory();
    }
}
