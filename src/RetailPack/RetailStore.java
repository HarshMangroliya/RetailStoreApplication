package RetailPack;

import java.util.ArrayList;

public class RetailStore {
    // Array list of items in the store
    public static ArrayList<Product> products = new ArrayList<>();

    // Array list for items purchased by the user
    public static ArrayList<PurchaseDetail> PurchaseDB = new ArrayList<>();

    // Object for current user
    static User tmp = (User) UserOperations.active;

    // Variable for setting the discount rate
    public static double discountRate = 0;

    // Method for adding products
    public static void addProduct() {
        // Variables related to a product
        int productID = 0;
        String productName;
        int qty;
        int returnPeriod;
        double  basePrice;
        double sellPrice;

        boolean ch = true;
        boolean tm = true;

        // Infinite while loop allows of adding products seamlessly
        while(ch) {
            System.out.print("\nEnter product ID : ");
            productID = UserOperations.scanner.nextInt();
            tm = true;
            for (int i = 0; i < products.size(); i++) {
                Product tmp = products.get(i);
                if (tmp.productID == productID) {
                    tm = false;
                    System.out.println("Product ID already exist please enter Another Product ID");
                    break;
                }
            }
            if(tm){
                ch = false;
            }
        }

        // Asking the admin for product name
        System.out.print("\nEnter product name : ");
        productName = UserOperations.scanner.next();

        // Asing the admin for product quantity
        System.out.print("Enter product Quantity : ");
        qty = UserOperations.scanner.nextInt();

        // Asking the admin for product return period
        System.out.print("Enter product Return period : ");
        returnPeriod = UserOperations.scanner.nextInt();

        // Asking the admin for base price for the product
        System.out.print("Enter product Base price : ");
        basePrice = UserOperations.scanner.nextInt();

        // Asking the admin for sell-price for the product
        System.out.print("Enter product sell price : ");
        sellPrice = UserOperations.scanner.nextInt();

        // Adding the product to the Products  Array List
        products.add(new Product(productID, productName, qty, returnPeriod, basePrice, sellPrice));

        // Success message
        System.out.println("Product Added successfully");
    }

    // This method displays the products list for the admins
    public static void adminDisplayProducts() {
        System.out.println("----------------------- List of Books -----------------------");
        System.out.println("Product ID \tName  \tQty   \tReturnPeriod  \tbase price  \tSell price");

        // It iterates through the products ArrayList and display all the products for the admin
        for (int i = 0; i < products.size(); i++) {
            Product tmp = products.get(i);
            System.out.println(tmp.getProductID()+"\t\t\t"+tmp.getProductName()+"\t"+ tmp.getQty()+"\t\t"+tmp.getReturnPeriod()+"\t\t\t\t"+tmp.getBasePrice()+"\t\t\t"+tmp.getSellPrice());
        }
    }

    // This method displays the products list for the customers
    public static void displayProducts() {
        tmp = (User) UserOperations.active;
        System.out.println("----------------------- List of Products -----------------------");
        System.out.println("Product ID\tName\tQty\tReturnPeriod\tSell price");

        // It iterates through the products ArrayList and display all the products for customers
        for (int i = 0; i < products.size(); i++) {
            Product tmp1 = products.get(i);
            double sellPrice;
            if( tmp.getMembership() ) {
                sellPrice = tmp1.sellPrice - (tmp1.sellPrice * discountRate);
            }
            else
                sellPrice = tmp1.sellPrice;
            System.out.println(tmp1.getProductID()+"\t"+tmp1.getProductName()+"\t"+ tmp1.getQty()+"\t"+tmp1.getReturnPeriod()+"\t"+sellPrice);
        }
    }

    // This method calculates the fine for the late returned/replaced products
    public static void calFine(){
        Admin tmp = (Admin) UserOperations.active;
        //tmp.calculateFine();
    }

    // This method calculates total profit for the admins
    public static void calTotalProfit(){
        double profit = 0;
        for (int i = 0; i < products.size(); i++) {
            Product tmp = products.get(i);
            profit += (tmp.getSellPrice() - tmp.getBasePrice()) * tmp.getQty();
        }
        System.out.println("Expected Profit is : " + profit);
    }

    // This method sets a discount rate for the admins
    public static void setDiscountRate(){
        System.out.print("Current rate : " + discountRate + "%\nEnter Discount rate : ");
        discountRate = UserOperations.scanner.nextDouble();
    }

    // This method is called when the customers are purchasing a product
    public static int purchaseProduct(){
        tmp = (User) UserOperations.active;
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
                    PurchaseDB.add(new PurchaseDetail(p, tmp.getUsername(),sellPrice));
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
        return pid;
    }

    // This method displays the purchase details of the products purchased by the customers
    public static void purchaseDetail(){
        tmp = (User) UserOperations.active;
        System.out.println("------------------ Purchase Detail -----------------------");
        System.out.println("Product ID\tName\tQty\tReturn Period\tSell price\tIssue date");

        // It iterates through the products ArrayList and display all the products for the customer
        for (int i = 0 ; i < PurchaseDB.size() ; i++) {
            PurchaseDetail pd = PurchaseDB.get(i);
            if(tmp.getUsername() == pd.getUsername())
                System.out.println(pd.getProductID() + "\t" + pd.getProductName() + "\t" + pd.getQty() + "\t" + pd.getReturnPeriod() + "\t" + pd.getSellPrice() + "\t" + pd.getReturnPeriod());
        }
    }
}
