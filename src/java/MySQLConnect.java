import java.sql.*;
import java.util.*;

// Class used to make raw SQL queries to local MySQL database
public class MySQLConnect {

    // CONNECTION INFO
    final String MYSQL_USER = "root";
    final String MYSQL_PASSWORD = "ics499";
    final String MYSQL_URL = "jdbc:mysql://localhost:3306/metro_bank";


    // Method to query the MySQL db and then returns a list of HashMap<String, Object> values
    public List<Map<String, Object>> getData(String queryString) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String, Object> row = null;

        try {
            // Initialize and open MySQL connection
            Properties connectionProps = new Properties();
            connectionProps.put("user", MYSQL_USER);
            connectionProps.put("password", MYSQL_PASSWORD);
            Connection conn = DriverManager.getConnection(MYSQL_URL, connectionProps);

            // Statement used to make raw SQL query
            Statement statement = conn.createStatement();

            // ResultSet used to store returned SQL data from query
            ResultSet rs = statement.executeQuery(queryString);

            ResultSetMetaData metaData = rs.getMetaData();
            Integer columnCount = metaData.getColumnCount();

            while (rs.next()) {
                row = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }

            // Close MySQL connection
            conn.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return resultList;
    }
}