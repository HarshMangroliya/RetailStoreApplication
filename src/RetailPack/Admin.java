package RetailPack;

import java.util.ArrayList;

public class Admin extends ParentUser implements AdminInterface {

    public Admin(String u, String p, String fname, int utype) {
        username = u;
        password = p;
        fullname = fname;
        userType = utype;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void calculateFine(ArrayList<PurchaseDetail> PurchaseDB) {

        System.out.println("------------------ Purchase Detail -----------------------");
        System.out.println("Cnt \tProduct ID \tName  \tQty   \tReturnPeriod  \tSell price  \tIssuedate   \tReturn Date"  );
        int diff = 0;
        for (int i = 0; i < PurchaseDB.size(); i++) {

            PurchaseDetail pd = PurchaseDB.get(i);
            diff = pd.returnDate.compareTo(pd.issueDate);

            if(pd.isReturned && diff >= pd.returnPeriod && pd.fine==0) {

                System.out.println(pd.cnt+"\t"+pd.getProductID() + "\t" + pd.getProductName() + "\t" + pd.getQty() + "\t" + pd.getReturnPeriod() + "\t" + pd.getSellPrice() + "\t" + pd.getIssueDate() + "\t" + pd.returnDate +"\t"+(diff - pd.returnPeriod) );

            }
        }

        System.out.println("Enter cnt no to calculate fine : ");
        int cnt = UserOperations.scanner.nextInt();

        PurchaseDetail pd = PurchaseDB.get(cnt-1);

        if(pd != null){
            pd.fine = (diff - pd.returnPeriod) * (pd.sellPrice * RetailStore.fineRate);
            System.out.println("Fine for cnt  "+cnt+" is :"+pd.fine);
        }
        else{
            System.out.println("Invalid Input");
        }



    }
}
