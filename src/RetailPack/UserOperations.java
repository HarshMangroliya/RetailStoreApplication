package RetailPack;

import java.util.*;

public class UserOperations {

    public static HashMap<String, ParentUser> users = new HashMap<>();


    private static String AdminKey = "Admin@123";

    public  static Scanner scanner = new Scanner(System.in);
    public static ParentUser active;
    public static Admin PAdmin ;
    public static User PUser;



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
