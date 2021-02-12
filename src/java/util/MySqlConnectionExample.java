package util;

import model.User;
import util.MySQLConnect;

import java.sql.SQLException;
import java.util.*;

public class MySqlConnectionExample {
    public static void main(String[] args) throws SQLException {

        // Example of MySQL query/connection
        MySQLConnect mysql = new MySQLConnect();

        String queryString = "SELECT * FROM user WHERE user_role = \"Customer\"";

        List<Map<String, Object>> resultList = mysql.getData(queryString);

        List<User> users = UserMapper.mapUsersFromMySQL(resultList);

        for (User user : users) {
            System.out.println(user.getFname());
        }


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