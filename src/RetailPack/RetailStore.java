package RetailPack;

import java.util.ArrayList;

public class RetailStore {

    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<PurchaseDetail> PurchaseDB = new ArrayList<>();

    static User tmp = (User) UserOperations.active;

    public static double discountRate = 0;

    public static void addProduct(){
        int productID;
        String productName;
        int qty;
        int returnPeriod;
        double  basePrice;
        double sellPrice;

        System.out.print("\nEnter product ID : ");
        productID = UserOperations.scanner.nextInt();

        System.out.print("\nEnter product name : ");
        productName = UserOperations.scanner.next();

        System.out.print("Enter product Qty : ");
        qty = UserOperations.scanner.nextInt();

        System.out.print("Enter product Return period : ");
        returnPeriod = UserOperations.scanner.nextInt();

        System.out.print("Enter product Base price : ");
        basePrice = UserOperations.scanner.nextInt();

        System.out.print("Enter product sell price : ");
        sellPrice = UserOperations.scanner.nextInt();

        products.add(new Product(productID,productName,qty,returnPeriod,basePrice,sellPrice));

        System.out.println("Product Added successfully");

    }

    public static void displayProducts() {
        System.out.println("------------------ List of Books -----------------------");
        System.out.println("Product ID \tName  \tQty   \tReturnPeriod  \tbase price  \tSell price");

        // It iterates through the books ArrayList and display all the books
        for (int i = 0; i < products.size(); i++) {

            Product tmp = products.get(i);
            System.out.println(tmp.getProductID()+"\t"+tmp.getProductName()+"\t"+ tmp.getQty()+"\t"+tmp.getReturnPeriod()+"\t"+tmp.getBasePrice()+"\t"+tmp.getSellPrice());

        }
    }

    public static void calFine(){

        Admin tmp = (Admin) UserOperations.active;

        //tmp.calculateFine();

    }

    public static void calTotalProfit(){
        double profit = 0;

        for (int i = 0; i < products.size(); i++) {
            Product tmp = products.get(i);
            profit += (tmp.getSellPrice() - tmp.getBasePrice()) * tmp.getQty();
        }
        System.out.println("Expected Profit is : "+profit);
    }

    public static void setDiscountRate(){
        System.out.print("Current rate : "+discountRate+"%\nEnter Discount rate : ");
        discountRate = UserOperations.scanner.nextDouble();
    }

    public static int purchaseProduct(){

        System.out.println("Your wallet balance is : " + tmp.getBalance());

        System.out.print("\nEnter the Product ID for purchasing: ");
        int pid = UserOperations.scanner.nextInt();

        for (int i = 0; i < PurchaseDB.size(); i++) {

            Product p = products.get(i);
            double sellPrice = 0;

            if(tmp.getMembership())
                sellPrice = p.sellPrice - (p.sellPrice * discountRate);
            else
                sellPrice = p.sellPrice;

            if (p.productID == pid) {
                if (p.qty > 0 ) {
                    if(!(tmp.getBalance() >= sellPrice))
                        return -1;

                    tmp.updateBalance(p.sellPrice);
                    p.qty--;

                    PurchaseDetail pd = new PurchaseDetail(p, tmp.getUsername(),sellPrice);
                    PurchaseDB.add(pd);
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }

        return pid;
    }

    public static void purchaseDetail(){
        System.out.println("------------------ Purchase Detail -----------------------");
        System.out.println("Product ID \tName  \tQty   \tReturnPeriod  \tSell price  \tIssuedate");

        // It iterates through the books ArrayList and display all the books
        for (int i = 0; i < PurchaseDB.size(); i++) {

            PurchaseDetail pd = PurchaseDB.get(i);

            if(tmp.getUsername() == pd.getUsername())
                System.out.println(pd.getProductID()+"\t"+pd.getProductName()+"\t"+ pd.getQty()+"\t"+pd.getReturnPeriod()+"\t"+pd.getSellPrice()+"\t"+pd.getReturnPeriod());

        }
    }

}
