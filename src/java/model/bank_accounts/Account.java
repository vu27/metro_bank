package model.bank_accounts;

public class Account {
    int id;
    String dateOpened;
    boolean isActive;
    int studentId;

    public Account(int id, String dateOpened, boolean isActive, int studentId) {
        this.id = id;
        this.dateOpened = dateOpened;
        this.isActive = isActive;
        this.studentId = studentId;
    }

    public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getDateOpened() {
          return dateOpened;
     }

     public void setDateOpened(String dateOpened) {
          this.dateOpened = dateOpened;
     }

     public boolean isActive() {
          return isActive;
     }

     public void setActive(boolean active) {
          isActive = active;
     }

     public int getStudentId() {
          return studentId;
     }

     public void setStudentId(int studentId) {
          this.studentId = studentId;
     }
}
