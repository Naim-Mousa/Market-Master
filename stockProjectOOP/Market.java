package stockProjectOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Market {
    public List<Stock> market = new ArrayList<Stock>();
    private double marketTrend;
    private Agent agent = new Agent(100000);
    private Events events;
    private static final Random random = new Random();

    /**
     * Constructor: Market
     * 
     * INPUT: none
     * PROCESSING: Initializes the market with a default trend and predefined
     * stocks.
     * OUTPUT: none
     */
    public Market() {
        this.marketTrend = 0.02; // Default market trend
        this.events = new Events(); // Initialize Events

        // Adding initial stocks to the market
        this.market.add(new Stock("ByteMe Technologies", 20.0, 1000));
        this.market.add(new Stock("Overhyped Holdings Ltd.", 20.0, 2000));
        this.market.add(new Stock("Legit a Ponzi Scheme Inc.", 20.0, 3000));
    }

    /*------------------
    GETTERS AND SETTERS
    -------------------*/

    public double getTrend() {
        return this.marketTrend;
    }

    /**
     * Method: setTrend
     * 
     * INPUT: none
     * PROCESSING: Randomly sets the market trend within a range of -10% to +10%.
     * OUTPUT: none
     */
    public void setTrend() {
        double minTrend = 0.90; // -10% trend
        double maxTrend = 1.10; // +10% trend
        this.marketTrend = minTrend + (maxTrend - minTrend) * Math.random();
    }

    public void setTrend(double trend) {
        this.marketTrend = trend;
    }

    public void setEventListener(EventListener listener) {
        this.events.setEventListener(listener);
    }

    /*--------------
    GENERAL METHODS
    ----------------*/

    /**
     * Method: Simulate_Week
     * 
     * INPUT: none
     * PROCESSING: Simulates a week's market activity, including agent trading.
     * OUTPUT: none
     */
    public void Simulate_Week() {
        executeAgentTrades(); // Agent makes trades during the simulation
        for (Stock stock : this.market) {
            events.applyRandomEvent(stock);
            stock.simulate(this.marketTrend);
        }
    }

    /**
     * Method: executeAgentTrades
     * 
     * INPUT: none
     * PROCESSING: Executes agent's trades.
     * OUTPUT: none
     */
    private void executeAgentTrades() {

        // Carry out 4 transactions
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(market.size());
            if (random.nextInt(2) == 1){
                int shares = random.nextInt(market.get(index).getShares()/10);
                Transaction.buy(agent, market.get(index), shares);
            }

            else{
                if (agent.getPortfolioObject().getPortfolioItem(market.get(index).getStockName()) == null){
                    continue;
                }
                else{
                    int shares = random.nextInt(agent.getPortfolioObject().getPortfolioItem(market.get(index).getStockName()).getSharesOwned()/2);
                    Transaction.sell(agent, market.get(index), shares);
                }
            }
        }
    }
}
