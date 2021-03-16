package model.bank_accounts;

public class Savings extends Account {
    double total;
    double interest;
    long accountNumber;
    long routingNumber;

    public Savings(int id,
                   String dateOpened,
                   boolean isActive,
                   int studentId,
                   double total,
                   double interest,
                   long accountNumber,
                   long routingNumber) {
        super(id, dateOpened, isActive, studentId);
        this.total = total;
        this.interest = interest;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
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
}

