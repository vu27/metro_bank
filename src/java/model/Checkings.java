package model;

public class Checkings extends Account{
    double total;
    boolean isOverdrafted;

    public Checkings(int id, String dateOpened, boolean isActive, int studentId, double total, boolean isOverdrafted) {
        super(id, dateOpened, isActive, studentId);
        this.total = total;
        this.isOverdrafted = isOverdrafted;
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
}
