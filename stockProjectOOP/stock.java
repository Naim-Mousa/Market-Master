package stockProjectOOP;

class stock{
    private String stockName;
    private double buyPrice;
    private double sellPrice;
    private double change;
    private int quantity;

    // Stocks upon creation when program is launched
    public stock(String stockName, double buyPrice, double SellPrice){
        this.stockName = stockName;
        this.buyPrice = buyPrice;
        this.sellPrice = SellPrice;
        this.change = 0;
    }
    
    // Stock upon buying
    public stock(String stockName, double buyPrice, double SellPrice, int quantity){
        this.stockName = stockName;
        this.buyPrice = buyPrice;
        this.sellPrice = SellPrice;
        this.quantity = quantity;
    }

    // Getters
    public String getStockName(){
        return stockName;
    }
    public double getBuyPrice(){
        return buyPrice;
    }
    public double getSellPrice(){
        return sellPrice;
    }
    public double getChange(){
        return change;
    }
    public int getQuantity(){
        return quantity;
    }

    // Setters
    public void setBuyPrice(double buyPrice){
        this.buyPrice = buyPrice;
    }
    public void setSellPrice(double sellPrice){
        this.sellPrice = sellPrice;
    }
    public void setChange(double change){
        this.change = change;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}