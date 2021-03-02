package model;

import util.MySQLConnect;
import util.UserMappers;
//import util.UserMapper;

import java.util.List;
import java.util.Map;

public class Manager extends User {
    double salary;

    public Manager(int id, String fname, String lname, String phone, String email, String password, double salary, int ssn, String address, String city, String state) {
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

    /**
     * get list of Employees from MySQL server and returns it
     *
     * @return arraylist of employees
     */
    public static List<Employee> getEmployees() {

        MySQLConnect mysql = new MySQLConnect();
        String queryString = "SELECT * FROM employee;"; //query to get employees

        List<Map<String, Object>> resultList = mysql.getData(queryString); // get employees
        List<Employee> employees = UserMappers.mapEmployees(resultList); // put into list

        return employees;
    }

    /**
     * get list of Employees from MySQL server and returns it
     *
     * @return arraylist of employees
     */
    public static List<Student> getStudents() {

        MySQLConnect mysql = new MySQLConnect();
        String queryString = "SELECT * FROM student;"; //query to get employees

        List<Map<String, Object>> resultList = mysql.getData(queryString); // get employees
        List<Student> students = UserMappers.mapStudents(resultList); // put into list

        return students;
    }

    public static List<Manager> getManagers() {

        MySQLConnect mysql = new MySQLConnect();
        String queryString = "SELECT * FROM manager;"; //query to get employees

        List<Map<String, Object>> resultList = mysql.getData(queryString); // get employees
        List<Manager> managers = UserMappers.mapManagers(resultList); // put into list

        return managers;
    }


    public static void updateEmployee(Employee employee, String fName, String lName, String email, int ID,
                                      String phone, String password, double salary, String address, String city,
                                      String state, int ssn) {

        MySQLConnect mysql = new MySQLConnect();
        String queryString = "UPDATE employee SET employee_email = \"" + email +
                "\"" + " , employee_id = \"" + ID + "\"" + " , employee_fname =  \"" + fName + "\"" +
                " ,  employee_lname = \"" + lName + "\"" + " , employee_phone = \"" + phone + "\"" +
                "  , employee_password = \"" + password + "\"" + "  , employee_ssn = \"" + ssn + "\"" +
                "  , employee_address = \"" + address + "\"" + "  , employee_city = \"" + city + "\"" +
                "  , employee_state = \"" + state + "\"" + " , employee_salary = \"" + salary + "\"" +
                "WHERE employee_email = \"" + employee.getEmail() + "\";";

        mysql.executeStatement(queryString);
    }


    public static void updateStudent(Student student, String fName, String lName, String email, int ID,
                                     String phone, String password, String date, String address, String city,
                                     String state, int ssn) {
        MySQLConnect mysql = new MySQLConnect();

        String queryString = "UPDATE student SET student_email = \"" + email +
                "\"" + " , student_id = \"" + ID + "\"" + " , student_fname =  \"" + fName + "\"" +
                " ,  student_lname = \"" + lName + "\"" + " , student_phone = \"" + phone + "\"" +
                "  , student_password = \"" + password + "\"" +
                " , date_created = \"" + date + "\"" + "  , student_ssn = \"" + ssn + "\"" +
                "  , student_address = \"" + address + "\"" +
                "  , student_city = \"" + city + "\"" + "  , student_state = \"" + state + "\"" +
                "WHERE student_email = \"" + student.getEmail() + "\";";
        mysql.executeStatement(queryString);
    }


    public static void updateManager(Manager manager, String fName, String lName, String email, int ID,
                                     String phone, String password, Double salary, String address, String city,
                                     String state, int ssn) {

        MySQLConnect mysql = new MySQLConnect();
        String queryString = "UPDATE manager SET manager_email = \"" + email +
                "\"" + " , manager_id = \"" + ID + "\"" + " , manager_fname =  \"" + fName + "\"" +
                " ,  manager_lname = \"" + lName + "\"" + " , manager_phone = \"" + phone + "\"" +
                "  , manager_password = \"" + password + "\"" + "  , manager_ssn = \"" + ssn + "\"" +
                "  , manager_address = \"" + address + "\"" + "  , manager_city = \"" + city + "\"" +
                "  , manager_state = \"" + state + "\"" + " , manager_salary = \"" + salary + "\"" +
                "WHERE manager_email = \"" + manager.getEmail() + "\";";

        mysql.executeStatement(queryString);
    }

    public static void addEmployee(Employee employee) {
        MySQLConnect mysql = new MySQLConnect();
        String queryString = "INSERT INTO metro_bank.employee " +
                "(employee_fname, employee_lname, employee_phone, employee_email, " +
                "employee_password, employee_salary, employee_ssn, employee_address, " +
                "employee_city, employee_state) VALUES (" +
                "\"" + employee.getFname() + "\"," +
                "\"" + employee.getLname() + "\"," +
                "\"" + employee.getPhone() + "\"," +
                "\"" + employee.getEmail() + "\"," +
                "\"" + employee.getPassword() + "\"," +
                "\"" + employee.getSalary() + "\"," +
                "\"" + employee.getSsn() + "\"," +
                "\"" + employee.getAddress() + "\"," +
                "\"" + employee.getCity() + "\"," +
                "\"" + employee.getState() + "\");";
        mysql.executeStatement(queryString);
        System.out.println("New employee added successfully.");
    }

    public static void addManager(Manager manager) {
        MySQLConnect mysql = new MySQLConnect();
        String queryString = "INSERT INTO metro_bank.manager " +
                "(manager_fname, manager_lname, manager_phone, manager_email, " +
                "manager_password, manager_salary, manager_ssn, manager_address, " +
                "manager_city, manager_state) VALUES (" +
                "\"" + manager.getFname() + "\"," +
                "\"" + manager.getLname() + "\"," +
                "\"" + manager.getPhone() + "\"," +
                "\"" + manager.getEmail() + "\"," +
                "\"" + manager.getPassword() + "\"," +
                "\"" + manager.getSalary() + "\"," +
                "\"" + manager.getSsn() + "\"," +
                "\"" + manager.getAddress() + "\"," +
                "\"" + manager.getCity() + "\"," +
                "\"" + manager.getState() + "\");";
        mysql.executeStatement(queryString);
        System.out.println("New manager added successfully.");
    }

    public static void addStudent(Student student) {
        MySQLConnect mysql = new MySQLConnect();
        String queryString = "INSERT INTO metro_bank.student " +
                "(student_fname, student_lname, student_phone, student_email, " +
                "student_password, date_created, student_ssn, student_address, " +
                "student_city, student_state) VALUES (" +
                "\"" + student.getFname() + "\"," +
                "\"" + student.getLname() + "\"," +
                "\"" + student.getPhone() + "\"," +
                "\"" + student.getEmail() + "\"," +
                "\"" + student.getPassword() + "\"," +
                "\"" + student.getDateCreated() + "\"," +
                "\"" + student.getSsn() + "\"," +
                "\"" + student.getAddress() + "\"," +
                "\"" + student.getCity() + "\"," +
                "\"" + student.getState() + "\");";
        mysql.executeStatement(queryString);
        System.out.println("New student added successfully.");
    }
}
