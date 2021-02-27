package model;

public class Student extends User {
    String dateCreated;

    public Student(int id, String fname, String lname, String phone, String email, String password, String dateCreated, int ssn, String address, String city, String state) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.ssn = ssn;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
