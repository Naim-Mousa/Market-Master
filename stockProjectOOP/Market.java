package stockProjectOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Market {
    public List<Stock> market = new ArrayList<Stock>();
    private double marketTrend;
    private Agent agent = new Agent(10000);
    private static final Random random = new Random();

/**
 * Constructor: Market
 * 
 * INPUT: none
 * PROCESSING: Initializes the market with a default trend and predefined stocks.
 * OUTPUT: none
 */
    public Market(){
        this.marketTrend = 0.02; // Default market trend
        
        // Adding initial stocks to the market
        this.market.add(new Stock("Stock1", 150.00, 1000000));
        this.market.add(new Stock("Stock2", 150.00, 2000000));
        this.market.add(new Stock("Stock3", 150.00, 3000000));
    }

/*------------------
GETTERS AND SETTERS
-------------------*/

    public double getTrend(){
        return this.marketTrend;
    }

/**
 * Method: setTrend
 * 
 * INPUT: none
 * PROCESSING: Randomly sets the market trend within a range of -10% to +10%.
 * OUTPUT: none
 */
    public void setTrend(){
        double minTrend = 0.90; // -10% trend
        double maxTrend = 1.10; // +10% trend
        this.marketTrend = minTrend + (maxTrend - minTrend) * Math.random();
    }

    public void setTrend(double trend){
        this.marketTrend = trend;
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
        for (Stock stock : this.market) {
            stock.simulate(this.marketTrend);
        }

        // executeAgentTrades(); // Agent makes trades during the simulation
    }

/**
 * Method: executeAgentTrades
 * 
 * INPUT: none
 * PROCESSING: Executes agent's trades.
 * OUTPUT: none
 */
    private void executeAgentTrades(){
        
        // Carry out 4 transactions
        for (int i = 1; i <= 4; i++){
            int index = random.nextInt(market.size());
            if(random.nextInt(2) == 1){
                agent.buyShares(market.get(index), 0);
            }

            else{
                agent.sellShares(market.get(index), 0);
            }
        }
    }
}
