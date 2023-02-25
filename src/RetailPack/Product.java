package RetailPack;

public class Product {
    private int productID;
    private String productName;
    private int qty;
    private int returnPeriod;
    private double  basePrice;
    private double sellPrice;

    public Product(int ProductID,String ProductName,int Qty,int returnPeriod,double basePrice,double sellPrice){
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
