package RetailPack;

import java.time.LocalDate;

public class PurchaseDetail extends Product{
    public int cnt;
    private String Username;
    public LocalDate issueDate;
    public boolean isReturned;
    public LocalDate returnDate;
    public double fine;




    public PurchaseDetail(Product tmp, String username, double sellPrice) {
        super(tmp.productID, tmp.productName, 1,  tmp.returnPeriod, tmp.getBasePrice(), sellPrice);
        this.Username = username;
        this.isReturned = false;
        this.issueDate = LocalDate.now().minusDays(10);
        this.fine = 0;
        this.cnt = ++RetailStore.cnt;


        /*
        import java.time.Period;

        LocalDate from = LocalDate.of(2020, 5, 4);
        LocalDate to = LocalDate.of(2020, 10, 10);

        Period period = Period.between(from, to);

        */

    }

    public String getUsername(){
        return this.Username;
    }

    public LocalDate getIssueDate(){
        return this.issueDate;
    }

}
