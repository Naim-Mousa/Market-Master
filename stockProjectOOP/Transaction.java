package stockProjectOOP;

public class Transaction {
    // Write transactions

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
        double cost = stock.getPrice() * shares;
        if (trader.getBudget() >= cost) {
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
}
