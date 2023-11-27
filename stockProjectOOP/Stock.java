package stockProjectOOP;
import java.util.*;

class Stock{
    private String stockName;
    private double price;
    private double marketCap;
    private double volatility;
    private List<Double> priceHistory = new ArrayList<Double>();

    // Stocks upon creation when program is launched
    public Stock(String stockName, double price, double marketCap, double volatility){
        this.stockName = stockName;
        this.price = price;
        this.marketCap = marketCap;
        this.volatility = volatility;
        this.priceHistory = new ArrayList<Double>();
        this.priceHistory.add(price); // adding initial price to price history
    }

    // updating price randomly based on volatility
    public void updatePrice(){
        double priceChange = (Math.random() - 0.5) * volatility;
        this.price = Math.max(this.price * (1 + priceChange), 0.01); //price not going below a minimum of 0.01
        this.marketCap = this.price * this.marketCap; // updating market cap based on updated price
        this.priceHistory.add(this.price); // adding updated price to price history
    }

    // getters
    public String getStockName(){
        return this.stockName;
    }
    public double getPrice(){
        return this.price;
    }
    public double getMarketCap(){
        return this.marketCap;
    }
    public double getVolatility(){
        return this.volatility;
    }
    public List<Double> getPriceHistory(){
        return this.priceHistory;
    }
    
    // setters
    public void setPrice(double price){
        this.price = price;
    }
    public void setMarketCap(double marketCap){
        this.marketCap = marketCap;
    }
    public void setVolatility(double volatility){
        this.volatility = volatility;
    }
}