package RetailPack;

public class Product {
    // variable for product ID
    public int productID;
    // variable for product name
    public String productName;
    // variable for product quantity
    public int qty;
    // variable for product return period
    public int returnPeriod;
    // variable for product base price
    private double  basePrice;
    // variable for product sell price
    public double sellPrice;

    // method for setting the product details
    public Product(int ProductID, String ProductName, int Qty, int returnPeriod, double basePrice, double sellPrice) {
        this.productID = ProductID;
        this.productName = ProductName;
        this.qty = Qty;
        this.returnPeriod = returnPeriod;
        this.basePrice = basePrice;
        this.sellPrice = sellPrice;
    }

    public int getProductID(){
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQty() {
        return qty;
    }

    public int getReturnPeriod() {
        return returnPeriod;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }
}
