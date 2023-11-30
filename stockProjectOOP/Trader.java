package stockProjectOOP;

import java.util.List;

public interface Trader{
    /**
     * Buys a specified number of shares of a given stock.
     * 
     * @param stock The stock to buy.
     * @param shares The number of shares to buy.
     * @return boolean indicating if the transaction was successful.
     */
    boolean buyShares(Stock stock, int shares);

    /**
     * Sells a specified number of shares of a given stock.
     * 
     * @param stock The stock to sell.
     * @param shares The number of shares to sell.
     * @return boolean indicating if the transaction was successful.
     */
    boolean sellShares(Stock stock, int shares);

    /**
     * Gets the current portfolio of the trader.
     * 
     * @return A map of stock names to the number of shares owned.
     */
    List<PortfolioItem> getPortfolio();

    /**
     * Gets the current budget or balance of the trader.
     * 
     * @return The trader's budget.
     */
    double getBudget();
}
