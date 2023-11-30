package stockProjectOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agent implements Trader {
    private List<PortfolioItem> portfolio;
    private double budget;
    private static final Random random = new Random();

/*=======================
Constructor: Agent
INPUT: budget (double) - the initial budget for the agent.
PROCESSING: Initializes the agent with the given budget and an empty portfolio.
OUTPUT: none
=======================*/
    public Agent(double budget) {
        this.budget = budget;
        this.portfolio = new ArrayList<>();
    }


/*------------------
GETTERS AND SETTERS
-------------------*/

    @Override
    public List<PortfolioItem> getPortfolio() {
        return new ArrayList<>(portfolio);
    }

    @Override
    public double getBudget() {
        return budget;
    }


/*--------------
GENERAL METHODS
---------------*/

/*=======================
METHOD: buyShares
INPUT: stock (Stock) - the stock to buy, shares (int) - number of shares to buy.
PROCESSING: Buys the specified number of shares of the given stock if the budget allows.
            Updates the agent's budget and portfolio accordingly.
OUTPUT: boolean - TRUE if the transaction is successful, FALSE otherwise.
=======================*/
    @Override
    public boolean buyShares(Stock stock, int shares) {
        double cost = stock.getPrice() * shares;
        if (budget >= cost) {
            stock.buyShares(shares);
            budget -= cost;
            portfolio.add(new PortfolioItem(stock, shares, stock.getPrice()));
            return true;
        }

        return false;
    }

/*=======================
METHOD: sellShares
INPUT: stock (Stock) - the stock to sell, shares (int) - number of shares to sell.
PROCESSING: Sells the specified number of shares of the given stock if the shares are owned.
            Updates the agent's budget and portfolio accordingly.
OUTPUT: boolean - TRUE if the transaction is successful, FALSE otherwise.
=======================*/
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

/*=======================
METHOD: findPortfolioItem
INPUT: stockName (String) - the name of the stock to find in the portfolio.
PROCESSING: Searches for a PortfolioItem in the agent's portfolio by stock name.
OUTPUT: PortfolioItem - the found PortfolioItem, or null if not found.
=======================*/
    private PortfolioItem findPortfolioItem(String stockName) {
        for (PortfolioItem item : portfolio) {
            if (item.getStockName().equals(stockName)) return item;
        }

        return null;
    }

/*=======================
METHOD: updatePortfolio
INPUT: stock (Stock) - the stock being bought or sold,
        shares (int) - the number of shares being bought or sold,
        isBuying (boolean) - Flag indicating if the operation is a buy (TRUE) or sell (FALSE).
PROCESSING: Updates the portfolio to add a new item or update an existing item based on the buy/sell operation.
OUTPUT: none
=======================*/
    private void updatePortfolio(Stock stock, int shares, boolean isBuying) {
        
        PortfolioItem existingItem = findPortfolioItem(stock.getStockName());
        
        if (isBuying) {
            if (existingItem == null)
                portfolio.add(new PortfolioItem(stock, shares, stock.getPrice()));
            else 
                existingItem = new PortfolioItem(stock, existingItem.getSharesOwned() + shares, stock.getPrice());
            
        }
        
        else
            if (existingItem != null && existingItem.getSharesOwned() > shares)
                existingItem = new PortfolioItem(stock, existingItem.getSharesOwned() - shares, stock.getPrice());
            
            else portfolio.remove(existingItem);
    }


    // Additional METHODs for the agent's strategy, etc., can be added here.


}
