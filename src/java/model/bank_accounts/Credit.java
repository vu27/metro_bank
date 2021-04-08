package model.bank_accounts;

public class Credit extends Account {
    double balance;
    double statementBalance;
    double availableCredit;
    double apr;
    boolean paymentMade;

    public Credit(int id, String dateOpened, boolean isActive, int studentId, double balance, double statementBalance, double availableCredit, double apr, boolean paymentMade) {
        super(id, dateOpened, isActive, studentId);
        this.balance = balance;
        this.statementBalance = statementBalance;
        this.availableCredit = availableCredit;
        this.apr = apr;
        this.paymentMade = paymentMade;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getStatementBalance() {
        return statementBalance;
    }

    public void setStatementBalance(double statementBalance) {
        this.statementBalance = statementBalance;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(double availableCredit) {
        this.availableCredit = availableCredit;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public boolean getPaymentMade(){
        return paymentMade;
    }

    public void setPayMade(boolean paid){
         this.paymentMade = paid;
    }

}
