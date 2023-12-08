package stockProjectOOP;

public class Transaction {

    /**
     * Checks if the trader has enough funds to buy a specified number of shares of
     * a stock.
     *
     * @param trader The trader (User or Agent).
     * @param stock  The stock to be purchased.
     * @param shares Number of shares to buy.
     * @return true if the trader has enough funds, false otherwise.
     */
    private static boolean checkFunds(Trader trader, Stock stock, int shares) {
        if (trader == null || stock == null) {
            return false;
        }
        double cost = stock.getPrice() * shares;
        return trader.getBudget() >= cost;
    }

    /**
     * Buys stocks for a trader.
     *
     * @param trader The trader (User or Agent) buying the stock.
     * @param stock  The stock to be purchased.
     * @param shares Number of shares to buy.
     * @return true if the transaction was successful, false otherwise.
     */
    public static boolean buy(Trader trader, Stock stock, int shares) {
        if (stock == null || trader == null) {
            return false;
        }

        // Check if the trader has enough budget
        if (checkFunds(trader, stock, shares)) {
            return trader.buyShares(stock, shares);
        }
        return false;
    }

    /**
     * Sells stocks for a trader.
     * 
     * @param trader The trader (User or Agent) selling the stock.
     * @param stock  The stock to be sold.
     * @param shares Number of shares to sell.
     * @return true if the transaction was successful, false otherwise.
     */
    public static boolean sell(Trader trader, Stock stock, int shares) {
        if (stock == null || trader == null) {
            return false;
        }

        return trader.sellShares(stock, shares);
    }

    /**
     * Performs a stock purchase transaction for a trader.
     * It deducts the total cost of the shares from the trader's budget
     * and updates the trader's portfolio by adding or increasing the shares of
     * the specified stock.
     *
     * @param trader The trader (User or Agent) buying the stock.
     * @param stock  The stock to be purchased.
     * @param shares The number of shares to be purchased.
     * @return true if the transaction was successful (i.e., the trader had enough
     *         funds and the portfolio was updated), false otherwise.
     */
    public static boolean portfolioBuy(Trader trader, Stock stock, int shares) {

        // Check if necessary funds exist
        double cost = stock.getPrice() * shares;
        if (!checkFunds(trader, stock, shares)) {
            return false;
        }

        // Set the new budget
        trader.setBudget(trader.getBudget() - cost);

        // Get the current portfolioItem
        PortfolioItem item = trader.findPortfolioItem(stock.getStockName());

        // Update shares if stock is already in portfolio
        if (item != null) {
            item.setSharesOwned(shares);
        }

        // If not, add stock to portfolio
        else {
            Portfolio portfolio = trader.getPortfolioObject();
            portfolio.addPortfolioItem(new PortfolioItem(stock, shares, stock.getPrice()));
        }
        return true;

    }

    /**
     * Performs a stock sell transaction for a trader.
     * It adds the revenue from the sold shares to the trader's budget
     * and updates the trader's portfolio by decreasing the shares of the
     * specified stock or removing the stock if all shares are sold.
     *
     * @param trader The trader (User or Agent) selling the stock.
     * @param stock  The stock being sold.
     * @param shares The number of shares to be sold.
     * @return true if the transaction was successful (i.e., the trader had enough
     *         shares and the portfolio and budget were updated accordingly),
     *         false otherwise.
     */
    public static boolean portfolioSell(Trader trader, Stock stock, int shares) {

        PortfolioItem item = trader.findPortfolioItem(stock.getStockName());

        if (item != null && item.getSharesOwned() >= shares) {
            double revenue = shares * stock.getPrice();

            trader.setBudget(trader.getBudget() + revenue); // Add revenue to budget

            // Decrease share count or remove the item if all shares are sold
            if (item.getSharesOwned() > shares) {
                item.setSharesOwned(item.getSharesOwned() - shares);
            } else {
                Portfolio portfolio = trader.getPortfolioObject();
                portfolio.removePortfolioItem(item);
            }
            return true;
        }
        return false;
    }
}
