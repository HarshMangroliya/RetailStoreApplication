import RetailPack.*;

public class Main {
    public static void main(String[] args) {

        UserOperations.users.put("a",new Admin("a","a","Admin bhai",1));
        UserOperations.users.put("m",new Member("m", "m", "Member bhai", true, 100,2));
        UserOperations.users.put("nm",new NonMemeber("nm", "nm", "Non-Member bhai", false, 100,2));

        RetailStore.products.add(new Product(1,"Apple",4,15,95,100));
        RetailStore.products.add(new Product(2,"Ball",6,15,5,10));
        RetailStore.products.add(new Product(3,"Cup",8,15,15,30));
        RetailStore.products.add(new Product(4,"Doll",10,15,25,50));

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

                        if(UserOperations.active.userType == 1){
                            //Admin
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
                                System.out.println("5. Logout");
                                System.out.print("Enter your choice: ");
                                choice = UserOperations.scanner.nextInt();

                                switch (choice) {

                                    case 1: {
                                        RetailStore.addProduct();
                                        break;
                                    }

                                    case 2: {
                                        RetailStore.calFine();
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

                                    case 5: {
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
                                        else {
                                            System.out.println("Product is out of stock");
                                        }

                                        break;
                                    }

                                    case 2: {

                                        break;
                                    }

                                    case 3: {
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