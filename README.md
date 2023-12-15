# Object Oriented Programming - Final Project

# IMPORTANT:
  To read through the code of the program without it showing errors, download the respective `JAR` files 
  present in the folder and add them to your external library section of your IDE. This program uses
  `JFreeChart` and `JCommon` which are not present within the native build of Java. 

  In addition, for background image, open `JAR` file within project folder. Program will still work if `JAR` file outside,
  but to have a background, open the executable `stockOOP.jar` file within the project folder.

# Project Description:
  This project will simulate a stock market for the user, enabling them to participate in stock
  market actions including buying and selling stocks. The stocks the user will be interacting with
  will be simulated (i.e. not real stocks with real-time data). At the same time, the value of the
  stocks will change depending on various factors including the user’s actions, each stock’s value
  relative to their competitors, as well as randomized events that will impact the stock market as a
  whole. The purpose of the project is to educate people about the stock market.
# Structure
  The reservation system will be divided into a variety of classes. Potential classes that we have
  thought of include (and not limited to):
  1) class Stock: A stock object containing the name of the stock, stock price, market
  capitalization, stock price change over time
  2) class Portfolio: used to represent all the stocks owned by the user and corresponding
  information such as total value, profit/loss on each stock, purchase and sell history.
  3) class PortfolioItem: aggregated from Portfolio class. Used to further examine the user’s
  individual portfolios of each stock. The user will be able to buy and sell stocks for the specific
  portfolio item company.
  4) class Transaction: interface to enable the user to buy/sell stock.
  5) class Main: enables user interaction with the stock system, allowing the user to buy and sell
  stocks, view their portfolio, and view specific companies.
# Considerations
  - Limited to only 3 stocks
  - Timeline starts upon the first opening of the application and continues forward from there
    until user exits program.

## File Descriptions

### 1. Agent.java
- **Description:** Represents an agent in the stock market simulation. Agents may have specific behaviors or strategies in buying and selling stocks.

### 2. BuyStocks.java
- **Description:** Implements the GUI for buying stocks. This class includes a graphical interface allowing users to purchase stocks. It is associated with the `MainInterface` class.

### 3. EventListener.java
- **Description:** Manages events that occur in the stock market simulation. This class could include logic for handling various events that impact stock prices.

### 4. Events.java
- **Description:** Enumerates different types of events that can occur in the stock market simulation. This file defines event constants for easy reference.

### 5. Main.java
- **Description:** The main entry point for the stock market simulation. Manages the overall flow of the program, allowing users to buy and sell stocks, view their portfolio, and interact with specific companies.

### 6. MainInterface.java
- **Description:** Defines the main user interface for interacting with the stock market simulation. This interface likely includes methods for user input and display.

### 7. Market.java
- **Description:** Represents the overall stock market environment. Manages the state of the market, including stock prices, events, and agent interactions.

### 8. Portfolio.java
- **Description:** Represents a user's portfolio, including the stocks they own, the total portfolio value, and purchase/sell history.

### 9. PortfolioItem.java
- **Description:** Represents an individual item within a user's portfolio. Contains information about a specific stock, quantity owned, and profit/loss.

### 10. SellStocks.java
- **Description:** Implements the GUI for selling stocks. This class includes a graphical interface allowing users to sell stocks. It is associated with the `MainInterface` class.

### 11. Stock.java
- **Description:** Represents a stock with properties such as name, price, market capitalization, and price change over time.

### 12. Trader.java
- **Description:** Represents a trader participating in the stock market simulation. Traders may have specific behaviors or strategies.

### 13. Transaction.java
- **Description:** Provides an interface for buying and selling stocks. This file defines methods for executing transactions.

### 14. User.java
- **Description:** Represents a user participating in the stock market simulation. Manages user-specific data and interactions.

### 15. ViewPortfolio.java
- **Description:** Implements the GUI for viewing a user's portfolio. This class includes a graphical interface allowing users to view their portfolio. It is associated with the `MainInterface` class.

## Usage

1. **Compile and Run:**
   - Compile the Java files using an IDE or command line.
   - Run the `Main` class to start the stock market simulation.

2. **Interaction:**
   - Use the provided GUI to buy and sell stocks, view the portfolio, and interact with the simulation.

3. **Customization:**
   - Modify specific files to customize the simulation behavior, such as adding more stocks, adjusting event probabilities, or enhancing user interactions.
