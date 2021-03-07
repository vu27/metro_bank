package util;

import model.Checkings;
import model.Employee;
import model.Manager;
import model.User;
import util.MySQLConnect;

import java.sql.SQLException;
import java.time.Instant;
import java.util.*;

public class MySqlConnectionExample {
    public static void main(String[] args) throws SQLException {

        Checkings checkingsEx = new Checkings(1, Instant.now().toString(), true, 1, 122.22, false);

        System.out.println(checkingsEx.getTotal());


//        // Example of MySQL query/connection
//        MySQLConnect mysql = new MySQLConnect();
//
//        String queryString = "INSERT INTO metro_bank.user (user_fname, user_lname, user_phone, user_role, user_email, user_password) " +
//                "VALUES ('New', 'Person', '922-555-2222', 'Manager', 'new@gmail.com', '123');";
//
//        mysql.executeStatement(queryString);
//
//                List<Map<String, Object>> resultList = mysql.getData(queryString);

//        List<Employee> employees = Manager.getEmployees();
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getFname());
//        }

//        Employee newEmployee = new Employee(1,
//                "Toby",
//                "Smith",
//                "612",
//                "email@gmail.com",
//                "passwprd",
//                50000,
//                123231232,
//                "Address",
//                "City",
//                "MN");
//
//        Manager.addEmployee(newEmployee);


//        String queryString = "SELECT * FROM user WHERE user_role = \"Customer\"";

//        List<Map<String, Object>> resultList = mysql.getData(queryString);
//
//        List<User> users = UserMapper.mapUsersFromMySQL(resultList);
//
//        for (User user : users) {
//            System.out.println(user.getFname());
//        }


        // Example of how the returned data is stored in resultList:
//        for (Map<String, Object> data : resultList) {
//            System.out.println(data);
//        }

        // Example of how to get individual pieces of data from resultList
        // ("emp_fname" and "emp_lname" is the column name in MySQL db)
        // .get(0) is the first row, .get(1) would be the second, etc.
//        String firstName = resultList.get(0).get("emp_fname").toString();
//        String lastName = resultList.get(0).get("emp_lname").toString();
//        System.out.println("\n" + firstName + " " + lastName);
    }
}