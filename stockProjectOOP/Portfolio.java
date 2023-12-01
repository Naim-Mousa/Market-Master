package stockProjectOOP;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<PortfolioItem> items;

    /*
     * Purpose: Initializes the Portfolio instance.
     * Process: Sets up an empty list (ArrayList) of PortfolioItem objects to store
     * the user's portfolio items.
     */
    public Portfolio() {
        this.items = new ArrayList<>();
    }

    /*
     * Input: PortfolioItem item - the PortfolioItem object to add to the portfolio.
     * Purpose: Adds a new stock item to the user's portfolio.
     * Process: Appends the given PortfolioItem to the items list.
     * Output: None.
     */
    public void addPortfolioItem(PortfolioItem item) {
        this.items.add(item);
    }

    /*
     * Input: PortfolioItem item - the PortfolioItem object to remove from the
     * portfolio.
     * Purpose: Removes a specified stock item from the user's portfolio.
     * Process: Attempts to remove the given PortfolioItem from the items list.
     * Output: boolean - Returns true if the item was successfully removed, false
     * otherwise.
     */
    public boolean removePortfolioItem(PortfolioItem item) {
        return this.items.remove(item);
    }

    /*
     * Input: String stockName - the name of the stock to search for in the
     * portfolio.
     * Purpose: Retrieves a specific PortfolioItem based on the stock name.
     * Process: Iterates through the items list and returns the PortfolioItem with a
     * matching stock name.
     * Output: PortfolioItem - Returns the found item, or null if no matching item
     * is found.
     */
    public PortfolioItem getPortfolioItem(String stockName) {
        for (PortfolioItem item : this.items) {
            if (item.getStockName().equals(stockName)) {
                return item;
            }
        }
        return null; // Return null if the item is not found
    }

    /*
     * Input: None.
     * Purpose: Calculates the total current value of all stocks in the portfolio.
     * Process: Sums up the current value (getCurrentValue()) of each PortfolioItem
     * in the items list.
     * Output: double - The total value of the portfolio.
     */
    public double getTotalValue() {
        double totalValue = 0.0;
        for (PortfolioItem item : this.items) {
            totalValue += item.getCurrentValue();
        }
        return totalValue;
    }

    /*
     * Input: None.
     * Purpose: Calculates the total profit or loss of the portfolio since the
     * stocks were purchased.
     * Process: For each PortfolioItem, calculates the difference between its
     * current value and the total purchase price (purchase price per share
     * multiplied by the number of shares owned). Sums up these differences to
     * determine the overall profit or loss.
     * Output: double - The total profit or loss of the portfolio.
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

    /*
     * Input: None.
     * Purpose: Provides a list of all PortfolioItem objects in the portfolio.
     * Process: Returns a new list (ArrayList) containing all PortfolioItem objects
     * from the items list. This approach ensures that the original list cannot be
     * modified directly, preserving data integrity.
     * Output: List<PortfolioItem> - A list of all portfolio items.
     */
    public List<PortfolioItem> getPortfolioItems() {
        return new ArrayList<>(this.items); // Return a copy for immutability
    }
}
