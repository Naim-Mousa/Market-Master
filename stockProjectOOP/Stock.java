package stockProjectOOP;
import java.util.*;

class Stock{
    private String stockName;
    private double price;
    private int shares; // number of available shares
    private double marketCap;
    private double volatility;
    private List<Double> priceHistory;
    private double pif;
    private static final Random random = new Random();

/**
 * Constructor: Stock
 * 
 * @param stockName (String) - the name of the stock.
 * @param stockPrice (double) - the price of the stock.
 * @param numberOfShares (int) - the number of shares.
 * 
 * PROCESSING: Initializes stock properties, updates market cap, generates stock volatility,
 * initializes & adds initial price to price history, generates price impact factor.
 * 
 * @return none
 */
    public Stock(String stockName, double price, int shares){
        this.stockName = stockName;
        this.price = price;
        this.shares = shares;
        updateMarketCap();
        this.volatility = getRandVolatility();
        this.priceHistory = new ArrayList<>();
        this.priceHistory.add(price);
        this.pif = getRandPIF();
    }


/*-------------------
GETTERS AND SETTERS
-------------------*/

public String getStockName(){
    return stockName;
}

public double getPrice(){
    return price;
}

public int getShares(){
    return shares;
}

public double getMarketCap(){
    return marketCap;
}

public double getVolatility(){
    return volatility;
}

public List<Double> getPriceHistory(){
    return new ArrayList<>(priceHistory); // Returning a copy for immutability
}

public double getPIF(){
    return pif;
}

/**
 * METHOD: setPrice
 * 
 * @param newPrice (double) - the new price value.
 * 
 * PROCESSING: Sets the stock price and updates market capitalization.
 * 
 * @return none
 */
    public void setPrice(double price){
        this.price = price;
        updateMarketCap();
    }


/*--------------
GENERAL METHODS
--------------*/

/**
 * METHOD: getRandPIF
 * 
 * @param none
 * 
 * PROCESSING: Generates a random Price Impact Factor within a specified range.
 * 
 * @return double - random PIF value
 */
    private double getRandPIF(){
        return generateRandomValue(0.0005, 0.0015);
    }

/**
 * METHOD: getRandVolatility
 * 
 * @param none
 * 
 * PROCESSING: Generates a random volatility within a specified range.
 * 
 * @return double - random volatility value
 */
    private double getRandVolatility(){
        return generateRandomValue(0.3, 1.5);
    }

/**
 * METHOD: generateRandomValue
 * 
 * @param min (double) - minimum value for the range.
 * @param max (double) - maximum value for the range.
 * 
 * PROCESSING: Generates a random double value within the given range.
 * 
 * @return double - random value within the specified range.
 */
    private static double generateRandomValue(double min, double max){
        return min + (max - min) * random.nextDouble();
    }

/**
 * METHOD: updateMarketCap
 * 
 * @param none
 * 
 * PROCESSING: Updates the market capitalization based on the current price and shares.
 * 
 * @return none
 */
    private void updateMarketCap(){
        this.marketCap = this.price * this.shares;
    }

/**
 * METHOD: addToPriceToHistory
 * 
 * @param none
 * 
 * PROCESSING: Adds the current stock price to the price history list.
 * 
 * @return none
 */
    private void addToPriceToHistory(){
        this.priceHistory.add(this.price);
    }

/**
 * METHOD: updatePrice
 * 
 * @param none
 * 
 * PROCESSING: Updates the stock price based on a random factor influenced by volatility.
 * 
 * @return none
 */
    public void updatePrice(){
        applyPriceChange((random.nextDouble() - 0.5) * volatility);
    }

/**
 * METHOD: buyShares
 * 
 * @param shares (int) - number of shares to buy.
 * 
 * PROCESSING: Decreases the available shares and adjusts the stock price based on the PIF.
 * 
 * @return none
 */
    public void buyShares(int shares){
        if (this.shares < shares){
            System.out.println("Not enough shares available to buy.");
            return;
        }
        this.shares -= shares;
        applyPriceChange(shares * this.pif);
    }

/**
 * METHOD: sellShares
 * 
 * @param shares (int) - number of shares to sell.
 * 
 * PROCESSING: Increases the available shares and adjusts the stock price based on the PIF.
 * 
 * @return none
 */
    public void sellShares(int shares){
        this.shares += shares;
        applyPriceChange(-shares * this.pif);
    }

/**
 * METHOD: simulate
 * 
 * @param marketTrend (double) - market trend as a multiplier.
 * 
 * PROCESSING: Adjusts the stock price based on the market trend and stock's volatility.
 * 
 * @return none
 */
    public void simulate(double marketTrend){
        applyPriceChange((random.nextDouble() - 0.5) * this.volatility * marketTrend);
    }

/**
 * METHOD: applyPriceChange
 * 
 * @param change (double) - price change factor.
 * 
 * PROCESSING: Applies the given price change to the stock price, updates market cap,
 * and adds the new price to the price history.
 * 
 * @return none
 */
    private void applyPriceChange(double change){
        this.price = Math.max(this.price * (1 + change), 0.01);
        updateMarketCap();
        addToPriceToHistory();
    }
}