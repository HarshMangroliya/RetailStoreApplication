package RetailPack;

public class NonMemeber extends User {

    public NonMemeber(String username, String password, String fullname, boolean isMember, int balance,int utype) {
        super(username, password, fullname, isMember, balance,utype);

    }

    @Override
    double getDiscount() {
        return 0;
    }
}
