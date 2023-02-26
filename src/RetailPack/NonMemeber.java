package RetailPack;

public class NonMemeber extends User {
    public NonMemeber(String username, String password, String fullname, boolean isMember, int balance, int utype) {
        super(username, password, fullname, isMember, balance,utype);
    }

    // The getDiscount member calculates the discount for the non-member customers
    @Override
    double getDiscount() {
        return 0;
    }
}
