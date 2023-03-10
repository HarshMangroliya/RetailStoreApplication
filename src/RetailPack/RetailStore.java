package RetailPack;

import java.time.LocalDate;
import java.util.ArrayList;

public class RetailStore {

    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<PurchaseDetail> PurchaseDB = new ArrayList<>();
    public static int cnt = 0;


    public static double discountRate = 0.05;
    public static double fineRate = 0.01;


    public static void addProduct(){
        int productID = 0;
        String productName;
        int qty;
        int returnPeriod;
        double  basePrice;
        double sellPrice;

        boolean ch = true;
        boolean tm = true;

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

    public static void adminDisplayProducts() {
        System.out.println("------------------ List of Products -----------------------");
        System.out.println("Product ID \tName  \tQuantity   \tReturnPeriod  \tbase price  \tSell price");

        // It iterates through the books ArrayList and display all the books
        for (int i = 0; i < products.size(); i++) {

            Product tmp = products.get(i);
            System.out.println(tmp.getProductID()+"\t\t\t"+tmp.getProductName()+"\t\t"+ tmp.getQty()+"\t\t\t"+tmp.getReturnPeriod()+"\t\t\t"+tmp.getBasePrice()+"\t\t\t"+tmp.getSellPrice());

        }
    }

    public static void displayProducts() {

        boolean f1 = UserOperations.PUser.getMembership();

        System.out.println("------------------ List of Products -----------------------");
        System.out.println("Product ID \tName  \tQuantity   \tReturnPeriod  \tSell price");


        // It iterates through the books ArrayList and display all the books
        for (int i = 0; i < products.size(); i++) {

            Product pro = products.get(i);
            double sellPrice = 0;

            if( f1 ) {
                /*System.out.println("Yes calling");*/
                sellPrice = pro.sellPrice - (pro.sellPrice * discountRate);
            }
            else
                sellPrice = pro.sellPrice;

           System.out.println(pro.getProductID()+"\t\t\t"+pro.getProductName()+"\t\t"+ pro.getQty()+"\t\t\t"+pro.getReturnPeriod()+"\t\t\t"+sellPrice);

        }
    }


    public static void calTotalProfit(){
        double profit = 0;

        for (int i = 0; i < products.size(); i++) {
            Product tmp = products.get(i);
            profit += (tmp.getSellPrice() - tmp.getBasePrice()) * tmp.getQty();
        }
        System.out.println("Expected Profit is : "+profit);

        double fine =0;

        for(PurchaseDetail pd : PurchaseDB){
            if(pd.isReturned && pd.fine!=0)
                fine+=pd.fine;
        }
        System.out.println("Total fine is : "+fine);
    }

    public static void setDiscountRate(){
        System.out.print("Current rate : "+discountRate+"%\nEnter Discount rate : ");
        discountRate = UserOperations.scanner.nextDouble();
    }

    public static void setFineRate(){
        System.out.print("Current rate : "+fineRate+"%\nEnter Discount rate : ");
        fineRate = UserOperations.scanner.nextDouble();
    }

    public static int purchaseProduct(){

        RetailStore.displayProducts();
        System.out.println("Your wallet balance is : " + UserOperations.PUser.getBalance());

        System.out.print("\nEnter the Product ID for purchasing: ");
        int pid = UserOperations.scanner.nextInt();

        for (int i = 0; i < products.size(); i++) {

            Product p = products.get(i);

            double sellPrice = 0;

            if(UserOperations.PUser.getMembership()) {
                sellPrice = p.sellPrice - (p.sellPrice * discountRate);
            }
            else
                sellPrice = p.sellPrice;

            if (p.productID == pid) {
                if (p.qty > 0 ) {
                    if(!(UserOperations.PUser.getBalance() >= sellPrice))
                        return -1;

                    UserOperations.PUser.updateBalance(sellPrice,'-');
                    p.qty--;

                    PurchaseDB.add(new PurchaseDetail(p, UserOperations.PUser.getUsername(),sellPrice));
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }

        return -2;
    }

    public static void purchaseDetail(){


        System.out.println("------------------ Purchase Detail -----------------------");
        System.out.println("OrderID\tProduct ID \tName  \tQuantity   \tReturnPeriod  \tSell price  \tIssuedate   \tReturn Date"  );


        for (int i = 0; i < PurchaseDB.size(); i++) {

            PurchaseDetail pd = PurchaseDB.get(i);

            if(UserOperations.PUser.getUsername() == pd.getUsername())
                System.out.println(pd.cnt+"\t\t\t"+pd.getProductID()+"\t\t\t"+pd.getProductName()+"\t"+ pd.getQty()+"\t\t\t"+pd.getReturnPeriod()+"\t\t\t"+pd.getSellPrice()+"\t\t\t"+pd.getIssueDate()+"\t\t\t"+ (pd.isReturned?pd.returnDate:"NULL"));

        }
    }

    public static void cancelPurchase(){
        System.out.println("------------------ Purchase Detail -----------------------");
        System.out.println("order ID\tProduct ID \tName  \tQty   \tReturnPeriod  \tSell price  \tIssuedate   \tReturn Date"  );

        for (int i = 0; i < PurchaseDB.size(); i++) {

            PurchaseDetail pd = PurchaseDB.get(i);
            if(UserOperations.PUser.getUsername() == pd.getUsername() && !pd.isReturned)
                System.out.println(pd.cnt+"\t\t\t"+pd.getProductID()+"\t\t\t"+pd.getProductName()+"\t"+ pd.getQty()+"\t\t\t"+pd.getReturnPeriod()+"\t\t\t"+pd.getSellPrice()+"\t\t\t"+pd.getIssueDate()+ "\t\t\t"+pd.returnDate);

        }
        int limit =3;
        while(limit-- != 0) {
            System.out.print("\nEnter the Order ID for Cancel: ");
            int oid = UserOperations.scanner.nextInt();

            for (int i = 0; i < PurchaseDB.size(); i++) {

                PurchaseDetail pd = PurchaseDB.get(i);
                if (UserOperations.PUser.getUsername() == pd.getUsername() && !pd.isReturned && pd.cnt == oid) {

                    pd.isReturned = true;
                    pd.returnDate = LocalDate.now();

                    System.out.println("Purchase cancelled successfully for OID : " + oid);
                    UserOperations.PUser.updateBalance(pd.sellPrice, '+');

                    Product p;
                    for (int j = 0; j < products.size(); j++) {
                        p = products.get(j);
                        if (p.productID == pd.productID) {
                            p.qty++;
                            break;
                        }
                    }

                    return;
                }
            }

            System.out.println("Invalid Order ID");
        }

    }

    public static void calculateFine(){
        UserOperations.PAdmin.calculateFine(PurchaseDB);
    }

}
