# Object Oriented Programming - Final Project

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
  - Every 10 seconds, a day passes
