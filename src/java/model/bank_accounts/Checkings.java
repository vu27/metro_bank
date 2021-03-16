package model.bank_accounts;

public class Checkings extends Account {
    double total;
    boolean isOverdrafted;
    long accountNumber;
    long routingNumber;
    long debitCardNumber;

    public Checkings(int id,
                     String dateOpened,
                     boolean isActive,
                     int studentId,
                     double total,
                     boolean isOverdrafted,
                     long accountNumber,
                     long routingNumber,
                     long debitCardNumber) {
        super(id, dateOpened, isActive, studentId);
        this.total = total;
        this.isOverdrafted = isOverdrafted;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
        this.debitCardNumber = debitCardNumber;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isOverdrafted() {
        return isOverdrafted;
    }

    public void setOverdrafted(boolean overdrafted) {
        isOverdrafted = overdrafted;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public long getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(int debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }
}
