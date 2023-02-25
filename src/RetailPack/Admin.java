package RetailPack;

public class Admin extends ParentUser implements AdminInterface {

    public Admin(String u, String p, String fname,int utype) {
        username = u;
        password = p;
        fullname = fname;
        userType = utype;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void calculateFine(User customer, Product product) {
        return;
    }
}
