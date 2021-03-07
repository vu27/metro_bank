package model.bank_accounts;

public class Savings extends Account {
    double total;
    double interest;

    public Savings(int id, String dateOpened, boolean isActive, int studentId, double total, double interest) {
        super(id, dateOpened, isActive, studentId);
        this.total = total;
        this.interest = interest;
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
}
