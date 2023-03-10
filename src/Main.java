import RetailPack.*;

public class Main {
    public static void main(String[] args) {

        UserOperations.users.put("a",new Admin("a","a","Admin bhai",1));
        UserOperations.users.put("m",new Member("m", "m", "Member bhai", true, 1000,2));
        UserOperations.users.put("nm",new NonMemeber("nm", "nm", "Non-Member bhai", false, 1000,2));

        RetailStore.products.add(new Product(101,"Appl12",4,5,95,100));
        RetailStore.products.add(new Product(102,"Ball",  6,9,5, 100));
        RetailStore.products.add(new Product(103,"Cupp",8,3,15,30));
        RetailStore.products.add(new Product(104,"Doll",10,15,25,50));

        boolean f1 = true;
        while(f1) {

            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Forgot password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = UserOperations.scanner.nextInt();


            switch (choice) {
                case 1:
                    // The register method from the UserOperations class is called
                    UserOperations.register();
                    break;
                case 2:

                    if (UserOperations.login() ) {
                        System.out.println("---------------------------------------------------------------------");
                        if(UserOperations.active.userType == 1){
                            //Admin
                            UserOperations.PAdmin = (Admin) UserOperations.active;
                            boolean f2 = true;
                            while(f2){

                                // The menu is displayed after the user has successfully logged in,
                                // This menu is wrapped inside an infinite while loop
                                System.out.println("\nWelcome Admin, "+UserOperations.active.getFullname());
                                RetailStore.adminDisplayProducts();
                                System.out.println("\n1. Add Product");
                                System.out.println("2. Calculate fine");
                                System.out.println("3. Calculate Total profit");
                                System.out.println("4. Set discount Rate");
                                System.out.println("5. Set Fine rate Rate");
                                System.out.println("6. Logout");
                                System.out.print("Enter your choice: ");
                                choice = UserOperations.scanner.nextInt();

                                switch (choice) {

                                    case 1: {
                                        RetailStore.addProduct();
                                        break;
                                    }

                                    case 2: {
                                        RetailStore.calculateFine();
                                        break;
                                    }

                                    case 3: {
                                        RetailStore.calTotalProfit();
                                        break;
                                    }

                                    case 4:{
                                        RetailStore.setDiscountRate();
                                        break;
                                    }
                                    case 5:{
                                        RetailStore.setFineRate();
                                        break;
                                    }

                                    case 6: {
                                        if (UserOperations.logout()) {
                                            System.out.println("\nUser logged out successfully.");
                                            f2 = false;
                                        }
                                        break;
                                    }

                                    default: {
                                        System.out.println("\nInvalid choice.");
                                        break;
                                    }

                                }
                            }
                        }

                        else if (UserOperations.active.userType == 2){
                            //Customer
                            UserOperations.PUser = (User) UserOperations.active;
                            boolean f2 = true;
                            while(f2) {
                                System.out.println("\nWelcome Customer, " + UserOperations.active.getFullname());
                                RetailStore.displayProducts();

                                System.out.println("\n1. Purchase Product");
                                System.out.println("2. Cancel product");
                                System.out.println("3. Display product");
                                System.out.println("4. Logout");
                                System.out.print("Enter your choice: ");
                                choice = UserOperations.scanner.nextInt();


                                switch (choice) {

                                    case 1: {
                                        int result = RetailStore.purchaseProduct();

                                        if(result == 1) {
                                            System.out.println("\nProduct Purchased successfully");
                                        }
                                        else if (result == -1) {
                                            System.out.println("Your wallet balance is not sufficient");
                                        }
                                        else if (result == -2) {
                                            System.out.println("Invalid Product ID");
                                        }
                                        else {
                                            System.out.println("Product is out of stock");
                                        }

                                        break;
                                    }

                                    case 2: {
                                        RetailStore.cancelPurchase();
                                        break;
                                    }

                                    case 3: {
                                        System.out.println("Your wallet balance is : " + UserOperations.PUser.getBalance());
                                        RetailStore.purchaseDetail();
                                        break;
                                    }

                                    case 4: {
                                        if (UserOperations.logout()) {
                                            System.out.println("\nUser logged out successfully.");
                                            f2 = false;
                                        }
                                        break;
                                    }

                                    default: {
                                        System.out.println("\nInvalid choice.");
                                        break;
                                    }

                                }
                            }

                        }


                    }

                    break;
                case 3:
                    //UserOperations.printUser();
                    UserOperations.resetPassword();
                    //UserOperations.printUser();
                    break;
                case 4:
                    f1 = false;
                    System.out.println("\nProgram exit successful.");
                    break;
                default:
                    System.out.println("\nInvalid choice.");
                    break;
            }
        }

    }
}