package stockProjectOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agent implements Trader {
    private Portfolio portfolio;
    private double budget;
    private static final Random random = new Random();

    /**
     * Constructor: Agent
     * 
     * @param budget (double) - the initial budget for the agent.
     * 
     *               Initializes the agent with the given budget and an empty
     *               portfolio.
     * 
     * @return none
     */
    public Agent(double budget) {
        this.budget = budget;
        this.portfolio = new Portfolio();
    }

    /*------------------
    GETTERS AND SETTERS
    -------------------*/

    @Override
    public List<PortfolioItem> getPortfolio() {
        return portfolio.getPortfolioItems();
    }

    @Override
    public double getBudget() {
        return budget;
    }

    /*--------------
    GENERAL METHODS
    ---------------*/

    /**
     * METHOD: buyShares
     * 
     * @param stock  (Stock) - the stock to buy.
     * @param shares (int) - number of shares to buy.
     * 
     *               PROCESSING: Buys the specified number of shares of the given
     *               stock if the budget allows.
     *               Updates the agent's budget and portfolio accordingly.
     * 
     * @return boolean - TRUE if the transaction is successful, FALSE otherwise.
     */
    @Override
    public boolean buyShares(Stock stock, int shares) {

        double cost = stock.getPrice() * shares;

        if (budget >= cost) {
            stock.buyShares(shares);
            budget -= cost;
            portfolio.addPortfolioItem(new PortfolioItem(stock, shares, stock.getPrice()));
            return true;
        }

        return false;
    }

    /**
     * METHOD: sellShares
     * 
     * @param stock  (Stock) - the stock to sell.
     * @param shares (int) - number of shares to sell.
     * 
     *               PROCESSING: Sells the specified number of shares of the given
     *               stock if the shares are owned.
     *               Updates the agent's budget and portfolio accordingly.
     * 
     * @return boolean - TRUE if the transaction is successful, FALSE otherwise.
     */
    @Override
    public boolean sellShares(Stock stock, int shares) {

        PortfolioItem item = findPortfolioItem(stock.getStockName());

        if (item != null && item.getSharesOwned() >= shares) {
            stock.sellShares(shares);
            budget += shares * stock.getPrice();
            updatePortfolio(stock, shares, false);
            return true;
        }

        return false;
    }

    /**
     * METHOD: findPortfolioItem
     * 
     * @param stockName (String) - the name of the stock to find in the portfolio.
     * 
     *                  PROCESSING: Searches for a PortfolioItem in the agent's
     *                  portfolio by stock name.
     * 
     * @return PortfolioItem - the found PortfolioItem, or null if not found.
     */
    private PortfolioItem findPortfolioItem(String stockName) {
        return portfolio.getPortfolioItem(stockName);
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
    private void updatePortfolio(Stock stock, int shares, boolean isBuying) {

        PortfolioItem existingItem = findPortfolioItem(stock.getStockName());

        if (isBuying) {
            if (existingItem == null)
                portfolio.addPortfolioItem(new PortfolioItem(stock, shares, stock.getPrice()));
            else
                existingItem = new PortfolioItem(stock, existingItem.getSharesOwned() + shares, stock.getPrice());
        }

        else {
            if (existingItem != null && existingItem.getSharesOwned() > shares)
                existingItem = new PortfolioItem(stock, existingItem.getSharesOwned() - shares, stock.getPrice());

            else
                portfolio.removePortfolioItem(existingItem);
        }
    }

    /**
     * METHOD: evaluatePortfolioValue
     * 
     * PROCESSING: Calculates the total current value of all stocks in the user's
     * portfolio.
     * Delegates the calculation to the getTotalValue method of the Portfolio class.
     * 
     * @return double - The total value of the user's portfolio.
     */
    @Override
    public double evaluatePortfolioValue() {
        return portfolio.getTotalValue();
    }

    /**
     * METHOD: analyzeStockPerformance
     * 
     * PROCESSING: Analyzes the performance of a specific stock in the user's
     * portfolio.
     * This method utilizes the Portfolio class's getPriceHistory method to retrieve
     * the price history
     * of the specified stock.
     * 
     * @param stock (Stock) - The stock to analyze.
     * 
     * @return List<Double> - A list of historical prices of the specified stock.
     */
    @Override
    public List<Double> analyzeStockPerformance(Stock stock) {
        return portfolio.getPriceHistory(stock.getStockName());
    }

    /**
     * METHOD: viewPortfolioPerformance
     * 
     * PROCESSING: Provides an overview of the user's portfolio performance,
     * including the total
     * value of the portfolio, the total investment, and the overall profit or loss.
     * This method calculates the total investment based on the initial purchase
     * price of each stock
     * in the portfolio and compares it with the current portfolio value to
     * determine the profit or loss.
     * 
     * @return String - A summary of the portfolio's performance, including total
     *         value, total investment, and profit/loss.
     */
    @Override
    public String viewPortfolioPerformance() {
        double totalInvestment = 0.0;
        double currentPortfolioValue = evaluatePortfolioValue();

        for (PortfolioItem item : getPortfolio()) {
            totalInvestment += item.getSharesOwned() * item.getPurchasePrice();
        }

        double profitOrLoss = currentPortfolioValue - totalInvestment;
        return "Portfolio Value: " + currentPortfolioValue + "\n" +
                "Total Investment: " + totalInvestment + "\n" +
                "Profit/Loss: " + profitOrLoss;
    }

    // Additional METHODs for the agent's strategy, etc., can be added here.

}
