package stockProjectOOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {

    private List<PortfolioItem> items;

    /*
     * Constructor for Portfolio class.
     * Initializes the Portfolio instance with an
     * empty list of PortfolioItem objects.
     * 
     */
    public Portfolio() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a PortfolioItem to the portfolio.
     * 
     * @param item The PortfolioItem object to be added.
     */
    public void addPortfolioItem(PortfolioItem item) {
        this.items.add(item);
    }

    /**
     * Removes a PortfolioItem from the portfolio.
     * 
     * @param item The PortfolioItem object to be removed.
     * @return true if the item was successfully removed, false otherwise.
     */
    public boolean removePortfolioItem(PortfolioItem item) {
        return this.items.remove(item);
    }

    /**
     * Retrieves a specific PortfolioItem based on the stock name.
     * 
     * @param stockName The name of the stock.
     * @return The PortfolioItem with the matching stock name, or null if not found.
     */
    public PortfolioItem getPortfolioItem(String stockName) {
        for (PortfolioItem item : this.items) {
            if (item.getStockName().equals(stockName)) {
                return item;
            }
        }
        return null; // Return null if the item is not found
    }

    /**
     * Calculates the total current value of all stocks in the portfolio.
     * 
     * @return The total value of the portfolio.
     */
    public double getTotalValue() {
        double totalValue = 0.0;
        for (PortfolioItem item : this.items) {
            totalValue += item.getCurrentValue();
        }
        return totalValue;
    }

    /**
     * Calculates the total profit or loss of the portfolio
     * since the stocks were purchased.
     * 
     * @return The total profit or loss of the portfolio.
     */
    public double getProfitOrLoss() {
        double profitOrLoss = 0.0;
        for (PortfolioItem item : this.items) {
            double currentPrice = item.getCurrentValue();
            double purchasePrice = item.getPurchasePrice() * item.getSharesOwned();
            profitOrLoss += (currentPrice - purchasePrice);
        }
        return profitOrLoss;
    }

    /**
     * Provides a list of all PortfolioItem objects in the portfolio.
     * 
     * @return A list of all portfolio items.
     */
    public List<PortfolioItem> getPortfolioItems() {
        return new ArrayList<>(this.items); // Return a copy
    }

    /**
     * Retrieves the price history of a specific stock in the portfolio.
     *
     * @param stockName The name of the stock.
     * @return List<Double> representing the price history of the stock, or null if
     *         the stock is not in the portfolio.
     */
    public List<Double> getPriceHistory(String stockName) {
        for (PortfolioItem item : items) {
            if (item.getStockName().equals(stockName)) {
                return item.getStockPriceHistory();
            }
        }
        return null; // Stock not found in the portfolio
    }

    /**
     * Retrieves the price history for each stock in the portfolio.
     *
     * @return A map where each key is a stock name and each value is the price
     *         history of that stock.
     */
    public Map<String, List<Double>> getAllPriceHistories() {
        Map<String, List<Double>> priceHistoryMap = new HashMap<>();

        for (PortfolioItem item : items) {
            String stockName = item.getStockName();
            List<Double> stockPriceHistory = getPriceHistory(stockName);
            priceHistoryMap.put(stockName, stockPriceHistory);
        }

        return priceHistoryMap;
    }
}
