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

}
