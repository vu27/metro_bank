package model;

import model.bank_accounts.Credit;
import util.MySQLConnect;

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

    public static void processApp(Credit credit){
        MySQLConnect mysql = new MySQLConnect();

        String queryString = "INSERT INTO metro_bank.credit " +
                "(date_opened,is_active , student_id, balance, " +
                "statement_balance, available_credit, apr) " +
                "VALUES (" +
                "\"" + credit.getDateOpened() + "\"," +
                "\"" + 1 + "\"," +
                "\"" + credit.getStudentId() + "\"," +
                "\"" + credit.getBalance() + "\"," +
                "\"" + credit.getStatementBalance() + "\"," +
                "\"" + credit.getAvailableCredit() + "\"," +
                "\"" + credit.getApr() + "\"" +
                ");";
        mysql.executeStatement(queryString);

    }

    public static void viewApplicationStatus(){
        //work on later
    }



}
