package RetailPack;

public abstract class User extends ParentUser{


    private int balance;
    private boolean isMember;

    public User(String username, String password, String fullname, boolean isMember,int balance,int utype) {
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

    public int getBalance() {
        return balance;
    }

    public void updateBalance(int amt){
        this.balance -= amt;
    }

    abstract double getDiscount();

}
