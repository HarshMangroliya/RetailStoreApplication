package RetailPack;

public class User {
    /**
     * User class that stores the username, password, fullname, balance of a user.
     */

    // Stores the username of the user
    private String username;
    // Stores the password of the user
    private String password;
    // Stores the fullname of the user
    private String fullname;
    // Stores the balance of the user (default balance: 50)
    private int balance;

    /**
     * This constructor assigns the values of the parameters to the local variables for creating an entry in the users HashMap.
     */
    public User(String username, String password, String fullname, int balance) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.balance = balance;
    }

    /**
     * This overloaded constructor is used for authenticating the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** This method returns the username while logging in */
    public String getUsername() {
        return username;
    }

    /** This method returns the password while logging in */
    public String getPassword() {
        return password;
    }

    /** This method returns the fullname of the current user */
    public String getFullname() {
        return fullname;
    }

    /** This method returns the balance of the current user */
    public int getBalance() {
        return balance;
    }

    /** This method is used for setting the new password for the current user */
    public void setPassword(String newPass) {
        this.password = newPass;
    }

    /** This method is used for updating the balance for the current user after a book has been purchased */
    public void updateBalance(int amt){
        this.balance -= amt;
    }
}
