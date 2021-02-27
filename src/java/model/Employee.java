package model;

public class Employee extends User {
    double salary;

    public Employee(int id, String fname, String lname, String phone, String email, String password, double salary, int ssn, String address, String city, String state) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.ssn = ssn;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
