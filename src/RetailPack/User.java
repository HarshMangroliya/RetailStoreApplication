package RetailPack;

public abstract class User extends ParentUser{


    private double balance;
    private boolean isMember;

    public User(String username, String password, String fullname, boolean isMember,double balance,int utype) {
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

    public boolean getMembership() {
        return isMember;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amt){
        this.balance -= amt;
    }

    abstract double getDiscount();

}
