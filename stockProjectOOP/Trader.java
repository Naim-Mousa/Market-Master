package stockProjectOOP;

import java.util.List;

public interface Trader {

    /**
     * Gets the current portfolio items of the trader.
     * 
     * @return A map of stock names to the number of shares owned.
     */
    List<PortfolioItem> getPortfolioItems();

    /**
     * Gets the current portfolio object of the trader.
     * 
     * @return The portfolio object.
     */
    Portfolio getPortfolioObject();

    /**
     * Gets the current budget or balance of the trader.
     * 
     * @return The trader's budget.
     */
    double getBudget();

    /**
     * Sets the current budget or balance of the trader.
     * 
     * @param newBudget The trader's new budget.
     * @return none.
     */
    void setBudget(double newBudget);

    /**
     * Calculates the total value of the trader's portfolio.
     * 
     * @return double representing the total value of the portfolio.
     */
    double evaluatePortfolioValue();

    /**
     * Provides an overview of the trader's portfolio performance, including total
     * profit or loss.
     * 
     * @return String summary of portfolio performance.
     */
    String viewPortfolioPerformance();

}
