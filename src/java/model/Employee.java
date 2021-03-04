package model;

public class Employee extends User {
    double salary;

    public Employee(int id, String fname, String lname, String phone, String email, String password, double salary, int ssn, String address, String city, String state) {
        super(id, fname, lname, phone, email, password, ssn, address, city, state);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
