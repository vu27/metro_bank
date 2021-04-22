package model;

import model.bank_accounts.Credit;
import util.MySQLConnect;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    public static void processApp(Credit credit) {
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

    public static boolean makeDepositChecking(long accountNumber, int studentId, double depositAmount) {
        MySQLConnect mysql = new MySQLConnect();
        double originalAmount;
        double newAmount;

        // See if account exists
        String getAccountQuery = "SELECT * FROM checkings WHERE account_number = "
                + accountNumber + " and student_id = " + studentId + ";";

        List<Map<String, Object>> resultList = mysql.getData(getAccountQuery);

        if (resultList.size() == 0) {
            return false;
        } else {
            originalAmount = Double.parseDouble(resultList.get(0).get("total").toString());
            newAmount = depositAmount + originalAmount;
            DecimalFormat f = new DecimalFormat("##.00");

            if (newAmount == originalAmount) {
                return false;
            } else {
                String depositQuery = "UPDATE checkings SET total = " + f.format(newAmount)
                        + " WHERE account_number = " + accountNumber + " AND "
                        + " student_id = " + studentId + ";";
                mysql.executeStatement(depositQuery);
                return true;
            }
        }
    }

    public static boolean makeDepositSavings(long accountNumber, int studentId, double depositAmount) {
        MySQLConnect mysql = new MySQLConnect();
        double originalAmount;
        double newAmount;

        // See if account exists
        String getAccountQuery = "SELECT * FROM savings WHERE account_number = "
                + accountNumber + " and student_id = " + studentId + ";";

        List<Map<String, Object>> resultList = mysql.getData(getAccountQuery);

        if (resultList.size() == 0) {
            return false;
        } else {
            originalAmount = Double.parseDouble(resultList.get(0).get("total").toString());
            newAmount = depositAmount + originalAmount;
            DecimalFormat f = new DecimalFormat("##.00");

            if (newAmount == originalAmount) {
                return false;
            } else {
                String depositQuery = "UPDATE savings SET total = " + f.format(newAmount)
                        + " WHERE account_number = " + accountNumber + " AND "
                        + " student_id = " + studentId + ";";
                mysql.executeStatement(depositQuery);
                return true;
            }
        }
    }

    public static boolean makeWithdrawalChecking(long accountNumber, int studentId, double withdrawalAmount) {
        MySQLConnect mysql = new MySQLConnect();
        double originalAmount;
        double newAmount;

        // See if account exists
        String getAccountQuery = "SELECT * FROM checkings WHERE account_number = "
                + accountNumber + " and student_id = " + studentId + ";";

        List<Map<String, Object>> resultList = mysql.getData(getAccountQuery);

        if (resultList.size() == 0) {
            return false;
        } else {
            originalAmount = Double.parseDouble(resultList.get(0).get("total").toString());
            newAmount = originalAmount - withdrawalAmount;
            DecimalFormat f = new DecimalFormat("##.00");

            if (newAmount == originalAmount) {
                return false;
            } else if (newAmount < 0) {
                return false;
            } else {
                String depositQuery = "UPDATE checkings SET total = " + f.format(newAmount)
                        + " WHERE account_number = " + accountNumber + " AND "
                        + " student_id = " + studentId + ";";
                mysql.executeStatement(depositQuery);
                return true;
            }
        }
    }

    public static boolean makeWithdrawalSavings(long accountNumber, int studentId, double withdrawalAmount) {
        MySQLConnect mysql = new MySQLConnect();
        double originalAmount;
        double newAmount;

        // See if account exists
        String getAccountQuery = "SELECT * FROM savings WHERE account_number = "
                + accountNumber + " and student_id = " + studentId + ";";

        List<Map<String, Object>> resultList = mysql.getData(getAccountQuery);

        if (resultList.size() == 0) {
            return false;
        } else {
            originalAmount = Double.parseDouble(resultList.get(0).get("total").toString());
            newAmount = originalAmount - withdrawalAmount;
            DecimalFormat f = new DecimalFormat("##.00");

            if (newAmount == originalAmount) {
                return false;
            } else if (newAmount < 0) {
                return false;
            } else {
                String depositQuery = "UPDATE savings SET total = " + f.format(newAmount)
                        + " WHERE account_number = " + accountNumber + " AND "
                        + " student_id = " + studentId + ";";
                mysql.executeStatement(depositQuery);
                return true;
            }
        }
    }

    public static void createCheckingAccount(Student student) {
        MySQLConnect mysql = new MySQLConnect();
        long accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        long routingNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

        long first14 = (long) (Math.random() * 100000000000000L);
        long debitCardNumber = 5200000000000000L + first14;

        String getLastUserString = "SELECT * FROM student ORDER BY student_id DESC LIMIT 1";
        List<Map<String, Object>> studentList = mysql.getData(getLastUserString);

        int studentId = Integer.parseInt(studentList.get(0).get("student_id").toString());

        String newCheckingQuery = "INSERT INTO metro_bank.checkings " +
                "(date_opened, is_active, student_id, total, is_overdrafted, account_number, routing_number, debit_card_number)" +
                " VALUES ('" + Instant.now().toString() + "', true, " +  studentId + ", 0, false, " +
                accountNumber + ", " + routingNumber + ", " + debitCardNumber + ");";

        mysql.executeStatement(newCheckingQuery);
    }

    public static void createSavingsAccount(Student student) {
        MySQLConnect mysql = new MySQLConnect();
        long accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        long routingNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

        String getLastUserString = "SELECT * FROM student ORDER BY student_id DESC LIMIT 1";
        List<Map<String, Object>> studentList = mysql.getData(getLastUserString);

        int studentId = Integer.parseInt(studentList.get(0).get("student_id").toString());

        String newCheckingQuery = "INSERT INTO metro_bank.savings " +
                "(date_opened, is_active, student_id, total, interest, account_number, routing_number)" +
                " VALUES ('" + Instant.now().toString() + "', true, " +  studentId + ", 0, 0.02, " +
                accountNumber + ", " + routingNumber + ");";

        mysql.executeStatement(newCheckingQuery);
    }
}
