package RetailPack;

import java.util.*;

public class UserOperations {

    protected static HashMap<String, ParentUser> users = new HashMap<>();


    public static double discountRate = 0;

    public static ArrayList<Product> products = new ArrayList<>();

    private static String AdminKey = "Admin@123";

    public  static Scanner scanner = new Scanner(System.in);
    public static ParentUser active;

    public static void register() {

        boolean f = true;
        while(f){

            int choice;
            System.out.println("Register as : \n1)Customer \n2)Admin \n3)Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();

            switch (choice){
                case 1: {
                    System.out.print("\nEnter your full name: ");
                    String fname = null, lname = null;
                    fname = scanner.next();
                    lname = scanner.next();
                    String fullname = fname + " " + lname;

                    System.out.print("Enter your username: ");
                    String username = scanner.next();

                    ParentUser user = UserOperations.users.get(username);
                    if (user != null && user.getUsername().equals(username)) {
                        boolean flag = true;
                        while (flag) {
                            System.out.println("\nUser already exists.");
                            System.out.print("Enter your username: ");
                            username = scanner.next();

                            if (!user.getUsername().equals(username))
                                flag = false;
                        }
                    }

                    String password1 = null, password2 = null;
                    boolean f1 = true;
                    while (f1) {
                        //uncomment the following lines for running in intelliJ IDEA
                        System.out.print("Enter your password: ");
                        password1 = scanner.next();
                        System.out.print("Re-enter your password: ");
                        password2 = scanner.next();

                        //uncomment the following lines for running in VS Code
                        //Console cnsl = System.console();
                        //if(cnsl == null) {
                        //    System.out.println("No console available.");
                        //}
                        //char[] passwd1 = cnsl.readPassword("Enter your password: ");
                        //password1 = new String(passwd1);
                        //char[] passwd2 = cnsl.readPassword("Re-enter your password: ");
                        //password2 = new String(passwd2);

                        if (password1.equals(password2))
                            f1 = false;
                        else
                            System.out.println("\nPlease enter same password\n");
                    }

                    int isMember;
                    System.out.print("Would you like to be a Member? (Yes: 1 / No: 0) : ");
                    isMember = scanner.nextInt();

                    if (isMember == 1)
                        user = new Member(username, password1, fullname, true, 100,2);
                    else
                        user = new NonMemeber(username, password1, fullname, false, 100,2);

                    UserOperations.users.put(username, user);
                    System.out.println("\nUser registered successfully.");
                    break;
                }

                case 2:{



                    System.out.print("\nEnter your full name: ");
                    String fname = null, lname = null;
                    fname = scanner.next();
                    lname = scanner.next();
                    String fullname = fname + " " + lname;

                    System.out.print("Enter your username: ");
                    String username = scanner.next();

                    ParentUser admin = UserOperations.users.get(username);
                    if (admin != null && admin.getUsername().equals(username)) {
                        boolean flag = true;
                        while (flag) {
                            System.out.println("\nAdmin already exists.");
                            System.out.print("Enter your username: ");
                            username = scanner.next();

                            if (!admin.getUsername().equals(username))
                                flag = false;
                        }
                    }

                    String password1 = null, password2 = null;
                    boolean f1 = true;
                    while (f1) {
                        //uncomment the following lines for running in intelliJ IDEA
                        System.out.print("Enter your password: ");
                        password1 = scanner.next();
                        System.out.print("Re-enter your password: ");
                        password2 = scanner.next();

                        //uncomment the following lines for running in VS Code
                        //Console cnsl = System.console();
                        //if(cnsl == null) {
                        //    System.out.println("No console available.");
                        //}
                        //char[] passwd1 = cnsl.readPassword("Enter your password: ");
                        //password1 = new String(passwd1);
                        //char[] passwd2 = cnsl.readPassword("Re-enter your password: ");
                        //password2 = new String(passwd2);

                        if (password1.equals(password2))
                            f1 = false;
                        else
                            System.out.println("\nPlease enter same password\n");
                    }


                    int cnt = 3;
                    while(true) {
                        if(cnt-- == 0){
                            System.out.println("Maximum attempts exhausted!");
                            break;
                        }

                        System.out.print("Enter the admin key (Remaining tries "+(cnt+1) +") : " );
                        String key;
                        key = scanner.next();

                        if(key.equals(AdminKey)){

                            UserOperations.users.put(username, new Admin(username, password1, fullname,1));
                            System.out.println("\nAdmin registered successfully.");
                            break;
                        }
                        else
                            System.out.println("Invalid Admin key.");
                    }
                    break;
                }

                case 3:{
                    f = false;
                    break;
                }

                default:
                    System.out.println("Please Enter valid choice !");
            }

        }

    }

    public static boolean login() {

        UserOperations.users.put("a",new Admin("a","a","Admin bhai",1));
        UserOperations.users.put("m",new Member("m", "m", "Member bhai", true, 100,2));
        UserOperations.users.put("nm",new NonMemeber("nm", "nm", "Non-Member bhai", false, 100,2));

        products.add(new Product(1,"Apple",4,15,95,100));
        products.add(new Product(2,"Ball",6,15,5,10));
        products.add(new Product(3,"Cup",8,15,15,30));
        products.add(new Product(4,"Doll",10,15,25,50));

        System.out.print("\nEnter your username: ");
        String username = scanner.next();

        //uncomment the following lines for running in intelliJ IDEA
        System.out.print("Enter your password: ");
        String password = scanner.next();


        //uncomment the following lines for running in VS Code
                        /*  Console cnsl = System.console();
                        if(cnsl == null)
                            System.out.println("No console available.");

                        char[] passwd = cnsl.readPassword("Enter password: ");
                        String password = new String(passwd);*/

        ParentUser user = UserOperations.users.get(username);
        if (user != null && user.getPassword().equals(password) ){
            System.out.println("\nLogin successfully.");
            UserOperations.active = user;
            return true;
        } else {
            System.out.println("\nLogin failed. Invalid username or password.");
        }

        return false;
    }

    public static boolean resetPassword() {
        System.out.print("\nEnter your fullname: ");
        String fname = null , lname = null;
        fname = scanner.next();
        lname =  scanner.next();
        String fullname = fname+" "+lname;
        System.out.print("Enter your username: ");
        String username = scanner.next();
        ParentUser user = UserOperations.users.get(username);


        if (user != null && user.getUsername().equals(username) && user.getFullname().equals(fullname)) {
            boolean flag = true;
            while(flag) {
                //uncomment the following lines for running in intelliJ IDEA
                System.out.print("Enter your new password: ");
                String password1 = scanner.next();
                System.out.print("Re-enter your new password: ");
                String password2 = scanner.next();


                //uncomment the following lines for running in VS Code
                /*//Console cnsl = System.console();
                //if(cnsl == null) {
                //    System.out.println("No console available.");
                //}
                //char[] passwd1 = cnsl.readPassword("Enter your new password: ");
                //String password1 = new String(passwd1);
                //char[] passwd2 = cnsl.readPassword("Re-enter your new password: ");
                //String password2 = new String(passwd2);
                */

                if(password1.equals(password2)){
                    flag = false;
                    System.out.println("\nPassword reset successfully.");
                    user.setPassword(password1);
                }
                else
                    System.out.println("\nPlease enter same password.");
            }
            return true;
        }

        System.out.println("\nNo such user exists.");

        return false;
    }

    public static boolean logout() {
        UserOperations.active = null;
        return true;
    }

    public static void addProduct(){
        int productID;
        String productName;
        int qty;
        int returnPeriod;
        double  basePrice;
        double sellPrice;

        System.out.print("\nEnter product ID : ");
        productID = scanner.nextInt();

        System.out.print("\nEnter product name : ");
        productName = scanner.next();

        System.out.print("Enter product Qty : ");
        qty = scanner.nextInt();

        System.out.print("Enter product Return period : ");
        returnPeriod = scanner.nextInt();

        System.out.print("Enter product Base price : ");
        basePrice = scanner.nextInt();

        System.out.print("Enter product sell price : ");
        sellPrice = scanner.nextInt();

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

        Admin tmp = (Admin) active;

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
        UserOperations.discountRate = scanner.nextDouble();
    }

    public static void printUser() {
        Iterator<Map.Entry<String, ParentUser>> new_Iterator = UserOperations.users.entrySet().iterator();

        while (new_Iterator.hasNext()) {
            Map.Entry<String, ParentUser> new_Map = (Map.Entry<String, ParentUser>)
                    new_Iterator.next();
            ParentUser temp = new_Map.getValue();

            // Displaying HashMap
            System.out.println(new_Map.getKey() + "  fn:" + temp.getFullname() + " u:" + temp.getUsername() + " p:" + temp.getPassword() + "\n");
        }
    }

}
