package stockProjectOOP;

import java.util.List;

public class Agent implements Trader {
    private Portfolio portfolio;
    private double budget;

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
    public List<PortfolioItem> getPortfolioItems() {
        return portfolio.getPortfolioItems();
    }

    @Override
    public Portfolio getPortfolioObject() {
        return this.portfolio;
    }

    @Override
    public double getBudget() {
        return budget;
    }

    @Override
    public void setBudget(double newBudget) {
        budget = newBudget;
    }

    /*--------------
    GENERAL METHODS
    ---------------*/
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

        for (PortfolioItem item : getPortfolioItems()) {
            totalInvestment += item.getSharesOwned() * item.getPurchasePrice();
        }

        double profitOrLoss = currentPortfolioValue - totalInvestment;
        return "Portfolio Value: " + currentPortfolioValue + "\n" +
                "Total Investment: " + totalInvestment + "\n" +
                "Profit/Loss: " + profitOrLoss;
    }

    // Additional METHODs for the agent's strategy, etc., can be added here.

}
