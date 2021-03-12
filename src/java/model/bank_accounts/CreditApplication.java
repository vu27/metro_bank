package model.bank_accounts;

public class CreditApplication {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String email;
    String phone;
    int SSN;
    int creditSore;
    double income;
    String password;
    String studentId;
    String status;
    String dateApplied;
    int id;

    public CreditApplication(int id, String firstName, String lastName, String address, String city, String state, String email, String phone, int SSN, int creditSore, double income, String password, String studentId, String status, String dateApplied) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.SSN = SSN;
        this.creditSore = creditSore;
        this.income = income;
        this.password = password;
        this.studentId = studentId;
        this.status = status;
        this.dateApplied = dateApplied;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getCreditSore() {
        return creditSore;
    }

    public void setCreditSore(int creditSore) {
        this.creditSore = creditSore;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }
}
