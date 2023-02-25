package RetailPack;

public class Member extends User {




    public Member(String username, String password, String fullname, boolean isMember, int balance,int utype) {
        super(username, password, fullname, isMember, balance,utype);

    }

    @Override
    double getDiscount() {
        return UserOperations.discountRate;
    }
}
