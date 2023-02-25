package RetailPack;

public abstract class ParentUser {
    public String username;
    public String password;
    public String fullname;
    public int userType; // 0-Admin 1-Customer

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setPassword(String newPass) {
        this.password = newPass;
    }


}
