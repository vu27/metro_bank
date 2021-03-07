package model;

public class Student extends User {
    String dateCreated;

    public Student(int id, String fname, String lname, String phone, String email, String password, String dateCreated, int ssn, String address, String city, String state) {
        super(id, fname, lname, phone, email, password, ssn, address, city, state);
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
