package RetailPack;

public class Member extends User {
    public Member(String username, String password, String fullname, boolean isMember, int balance, int utype) {
        super(username, password, fullname, isMember, balance,utype);
    }

    // The get discount method returns the discount rate for the member customers
    @Override
    double getDiscount() {
        return RetailStore.discountRate;
    }
}
