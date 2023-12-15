package stockProjectOOP;

import java.util.ArrayList;
import java.util.List;

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
     * METHOD: updatePortfolio
     * 
     * @param stock    (Stock) - the stock being bought or sold.
     * @param shares   (int) - the number of shares being bought or sold.
     * @param isBuying (boolean) - Flag indicating if the operation is a buy (TRUE)
     *                 or sell (FALSE).
     * 
     *                 PROCESSING: Updates the portfolio to add a new item or update
     *                 an existing item based on the buy/sell operation.
     * 
     * @return none
     */
    public void updatePortfolio(Stock stock, int shares, boolean isBuying) {

        PortfolioItem existingItem = findPortfolioItem(stock.getStockName());

        if (isBuying) {
            if (existingItem == null)
                this.addPortfolioItem(new PortfolioItem(stock, shares, stock.getPrice()));
            else
                existingItem.setSharesOwned(existingItem.getSharesOwned() + shares);
                existingItem.setPurchasePrice((existingItem.getPurchasePrice() + stock.getPrice()) / 2);
        }

        else {
            if (existingItem.getSharesOwned() > shares)
                existingItem.setSharesOwned(existingItem.getSharesOwned() - shares);

            else
                this.removePortfolioItem(existingItem);
        }
    }

    /**
     * METHOD: findPortfolioItem
     * 
     * @param stockName (String) - the name of the stock to find in the portfolio.
     * 
     *                  PROCESSING: Searches for a PortfolioItem in the user's
     *                  portfolio by stock name.
     * 
     * @return PortfolioItem - the found PortfolioItem, or null if not found.
     */
    public PortfolioItem findPortfolioItem(String stockName) {
        return this.getPortfolioItem(stockName);
    }

}
