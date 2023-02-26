package RetailPack;

public abstract class User extends ParentUser{

    // Variable for storing the balance credits for the customer
    private double balance;
    // Variable for denoting if the customer is a member or not
    private boolean isMember;

    // Setting the customer details for registering the customer
    public User(String username, String password, String fullname, boolean isMember, double balance, int utype) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.isMember = isMember;
        this.balance = balance;
        this.userType = utype;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method for checking the membership for the current customer
    public boolean getMembership() {
        return isMember;
    }

    // Method for fetchign the balance for the current user
    public double getBalance() {
        return balance;
    }

    // Method for updating the balance for the current user after a product is purchased
    public void updateBalance(double amt){
        this.balance -= amt;
    }

    // Method for calculating the discount for the current customer
    abstract double getDiscount();
}
