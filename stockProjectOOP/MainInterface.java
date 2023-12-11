package stockProjectOOP;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class MainInterface extends javax.swing.JFrame implements EventListener{
    public static int WEEKS = 0;
     Market market = new Market();
    User user = new User(100000);

    /**
     * Creates new form MainInterface
     */
    public MainInterface() {
        initComponents();

        market.setEventListener(this);

        // Getting dimensions of screen and centering the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        // Preventing the window from being moved
        this.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                setLocation(x, y);
            }
        });

        // Initializing graph with 5 weeks of data
        for (int i = 0; i < 5; i++){
            market.Simulate_Week();
            WEEKS++;
        }

        // Adding stocks to the graph
        for (Stock stock : market.market) {
            graphs.add(stock.getStockName(), createChartPanel(stock));
        }

        graphs.setForegroundAt(0, Color.BLUE);
        graphs.setForegroundAt(1, Color.BLUE);
        graphs.setForegroundAt(2, Color.BLUE);

        // Set initial values for text fields
        Stock stock = market.market.get(0);
        updateTextFields(stock);

        weekTxt.setText(Integer.toString(WEEKS));

        // Adding listener to detect when a tab is changed (and accordingly update the text fields/data)
        graphs.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt){
                JTabbedPane pane = (JTabbedPane) evt.getSource();
                int selectedIndex = pane.getSelectedIndex();
                if (selectedIndex != -1){
                    Stock stock = market.market.get(selectedIndex);
                    updateTextFields(stock);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        viewPortfolio = new javax.swing.JButton();
        buyStocks = new javax.swing.JButton();
        sellStocks = new javax.swing.JButton();
        graphs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        currentPricelbl = new javax.swing.JLabel();
        lastPricelbl = new javax.swing.JLabel();
        currentPriceTxt = new javax.swing.JTextField();
        lastPriceTxt = new javax.swing.JTextField();
        percentChangeLbl = new javax.swing.JLabel();
        percentChangeTxt = new javax.swing.JTextField();
        marketCapLbl = new javax.swing.JLabel();
        marketCapTxt = new javax.swing.JTextField();
        priceVolTxt = new javax.swing.JTextField();
        priceVolLbl = new javax.swing.JLabel();
        weeklbl = new javax.swing.JLabel();
        weekTxt = new javax.swing.JTextField();
        simulate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.setResizable(false);
        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // need to make image fit screen and make it dimmer
                super.paintComponent(g);
                g.drawImage(new javax.swing.ImageIcon("long.png").getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
        };

        // Make jButtons blue, and then upon hovering, make them purple
        viewPortfolio.setBackground(new java.awt.Color(73,109,137));
        viewPortfolio.setForeground(new java.awt.Color(255, 255, 255));
        viewPortfolio.setBorderPainted(false);
        viewPortfolio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewPortfolio.setBackground(new java.awt.Color(153, 50, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewPortfolio.setBackground(new java.awt.Color(73,109,137));
            }
        });

        buyStocks.setBackground(new java.awt.Color(73,109,137));
        buyStocks.setForeground(new java.awt.Color(255, 255, 255));
        buyStocks.setBorderPainted(false);
        buyStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buyStocks.setBackground(new java.awt.Color(153, 50, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buyStocks.setBackground(new java.awt.Color(73,109,137));
            }
        });

        sellStocks.setBackground(new java.awt.Color(73,109,137));
        sellStocks.setForeground(new java.awt.Color(255, 255, 255));
        sellStocks.setBorderPainted(false);
        sellStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sellStocks.setBackground(new java.awt.Color(153, 50, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sellStocks.setBackground(new java.awt.Color(73,109,137));
            }
        });

        simulate.setBackground(new java.awt.Color(73,109,137));
        simulate.setForeground(new java.awt.Color(255, 255, 255));
        simulate.setBorderPainted(false);
        simulate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simulate.setBackground(new java.awt.Color(153, 50, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simulate.setBackground(new java.awt.Color(73,109,137));
            }
        });

        viewPortfolio.setText("View Portfolio");
        viewPortfolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPortfolioActionPerformed(evt);
            }
        });

        buyStocks.setText("Buy Stocks");
        buyStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyStocksActionPerformed(evt);
            }
        });

        sellStocks.setText("Sell Stocks");
        sellStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellStocksActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        currentPricelbl.setBackground(new java.awt.Color(0, 0, 0));
        currentPricelbl.setText("Current Price:");

        lastPricelbl.setBackground(new java.awt.Color(0, 0, 0));
        lastPricelbl.setText("Last Price: ");

        currentPriceTxt.setEditable(false);

        lastPriceTxt.setEditable(false);

        percentChangeLbl.setBackground(new java.awt.Color(0, 0, 0));
        percentChangeLbl.setText("Percent Change: ");

        percentChangeTxt.setEditable(false);

        marketCapLbl.setBackground(new java.awt.Color(0, 0, 0));
        marketCapLbl.setText("Market Cap:");

        marketCapTxt.setEditable(false);

        priceVolTxt.setEditable(false);

        priceVolLbl.setBackground(new java.awt.Color(0, 0, 0));
        priceVolLbl.setText("Price Volatility: ");

        weeklbl.setBackground(new java.awt.Color(0, 0, 0));
        weeklbl.setText("Week:");

        weekTxt.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(currentPricelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(currentPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(percentChangeLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(percentChangeTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lastPricelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lastPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(marketCapLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(marketCapTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(priceVolLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceVolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(weeklbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(weekTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPricelbl)
                    .addComponent(currentPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marketCapLbl)
                    .addComponent(marketCapTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastPricelbl)
                    .addComponent(lastPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceVolLbl)
                    .addComponent(priceVolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percentChangeLbl)
                    .addComponent(percentChangeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weeklbl)
                    .addComponent(weekTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        simulate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        simulate.setText("Simulate");
        simulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(graphs)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(simulate, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewPortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyStocks, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellStocks, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(viewPortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyStocks, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simulate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(sellStocks, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(graphs, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>            
    

    // Action listeners for buttons (simulate a week passing)
    private void simulateActionPerformed(java.awt.event.ActionEvent evt) {     
        market.Simulate_Week();
        WEEKS++;
        graphs.removeAll();
        
        for (Stock stock : market.market) {
            graphs.add(stock.getStockName(), createChartPanel(stock));
        }
        graphs.setForegroundAt(0, Color.BLUE);
        graphs.setForegroundAt(1, Color.BLUE);
        graphs.setForegroundAt(2, Color.BLUE);
        weekTxt.setText(Integer.toString(WEEKS));
    }     

    private void viewPortfolioActionPerformed(java.awt.event.ActionEvent evt) {                                              
        ViewPortfolio viewPortfolio = new ViewPortfolio(this);
        viewPortfolio.setVisible(true);
        this.setVisible(false);
    }

    private void buyStocksActionPerformed(java.awt.event.ActionEvent evt) {                                          
        BuyStocks buyStocks = new BuyStocks(this);
        buyStocks.setVisible(true);
        this.setVisible(false);
    }

    private void sellStocksActionPerformed(java.awt.event.ActionEvent evt) {                                           
        SellStocks sellStocks = new SellStocks(this);
        sellStocks.setVisible(true);
        this.setVisible(false);
    }

    private void updateTextFields(Stock stock){
        // setting text fields to stock data and formatting to 2 decimal places
        currentPriceTxt.setText(String.format("%.2f", stock.getPrice()));
        lastPriceTxt.setText(String.format("%.2f", stock.getPriceHistory().get(stock.getPriceHistory().size() - 2)));
        percentChangeTxt.setText(String.format("%.2f", (stock.getPrice() - stock.getPriceHistory().get(stock.getPriceHistory().size() - 2)) / stock.getPriceHistory().get(stock.getPriceHistory().size() - 2) * 100) + "%");
        marketCapTxt.setText(String.format("%.2f", stock.getMarketCap()));
        priceVolTxt.setText(String.format("%.2f", stock.getVolatility()));
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }
    
    // Method to create a chart panel for a stock
    private static ChartPanel createChartPanel(Stock stock){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<Double> priceHistory = stock.getPriceHistory();
        int i = 0;

        // Adding data points to the chart using the stock's price history
        for (Double price : priceHistory) {
            if (i <= WEEKS)
                dataset.addValue(price, stock.getStockName(), (Comparable<?>) i);
                i++;
        }
        
        // Creating the chart
        JFreeChart chart = ChartFactory.createLineChart(
                stock.getStockName() + " Price",
                "Week",
                "Price",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        // Setting the range of the y-axis to be the min/max values of the data points (adjusted for padding)
        double minValue = Double.MAX_VALUE;
        double maxValue = Double.MIN_VALUE;
        for (Object rowKeyObj : dataset.getRowKeys()) {
            Comparable<?> rowKey = (Comparable<?>) rowKeyObj;
            for (Object columnKeyObj : dataset.getColumnKeys()) {
                Comparable<?> columnKey = (Comparable<?>) columnKeyObj;
                Number value = dataset.getValue(rowKey, columnKey);
                if (value != null) {
                    minValue = Math.min(minValue, value.doubleValue());
                    maxValue = Math.max(maxValue, value.doubleValue());
                }
            }
        }

        // Set the range around the data points
        double padding = (maxValue - minValue) * 0.1; // 10% padding
        chart.getCategoryPlot().getRangeAxis().setRange(minValue - padding, maxValue + padding);
        
        return new ChartPanel(chart);
    }

    @Override
    public void onEventOccured(String eventName, Stock stock) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(this, "BREAKING NEWS: " + eventName + " on " + stock.getStockName(), "BREAKING NEWS", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buyStocks;
    private javax.swing.JTextField currentPriceTxt;
    private javax.swing.JLabel currentPricelbl;
    private javax.swing.JTabbedPane graphs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastPriceTxt;
    private javax.swing.JLabel lastPricelbl;
    private javax.swing.JLabel marketCapLbl;
    private javax.swing.JTextField marketCapTxt;
    private javax.swing.JLabel percentChangeLbl;
    private javax.swing.JTextField percentChangeTxt;
    private javax.swing.JLabel priceVolLbl;
    private javax.swing.JTextField priceVolTxt;
    private javax.swing.JButton sellStocks;
    private javax.swing.JButton simulate;
    private javax.swing.JButton viewPortfolio;
    private javax.swing.JTextField weekTxt;
    private javax.swing.JLabel weeklbl;
    // End of variables declaration                   
}
