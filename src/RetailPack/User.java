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

    public void updateBalance(double amt,char sign){
        switch (sign){
            case '-':
                this.balance -= amt;
                break;
            case '+':
                this.balance += amt;
                break;
            default:
                System.out.println("invalid input");
        }

    }

    abstract double getDiscount();

}
