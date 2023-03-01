package RetailPack;

public abstract class ParentUser {
    // username of all the admin, customers
    public String username;
    // password of all the admin, customers
    public String password;
    // fullname of all the admin, customers
    public String fullname;
    // usertype 1-Admin,2-Customer
    public int userType;

    // this method returns the username
    public String getUsername() {
        return username;
    }
    // this method returns the password
    public String getPassword() {
        return password;
    }
    // this method returns the fullname
    public String getFullname() {
        return fullname;
    }
    // this method sets the password
    public void setPassword(String newPass) {
        this.password = newPass;
    }
}
