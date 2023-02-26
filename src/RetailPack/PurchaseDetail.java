package RetailPack;

import java.time.LocalDate;

public class PurchaseDetail extends Product{
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean isReturned;
    private String Username;

    public PurchaseDetail(Product tmp, String username, double sellPrice) {
        super(tmp.productID, tmp.productName, tmp.qty,  tmp.returnPeriod, tmp.getBasePrice(), sellPrice);
        this.Username = username;
        this.isReturned = false;
        this.issueDate = LocalDate.now();



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
