package utils;

import sun.management.ConnectorAddressLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    private static Connection getDatabaseConnection() {
        String databaseUrl = PropertyHelper.getProperty("dburl");
        String databaseUser = PropertyHelper.getProperty("dbuser");
        String databasePassword = PropertyHelper.getProperty("dbpassword");

        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(
                            databaseUrl,
                            databaseUser,
                            databasePassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static ResultSet executeQuery(String query) {
        Connection connection = getDatabaseConnection();
        ResultSet response = null;
        try {
            response = connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static List<String> getDuckNames() {
        String query = "SELECT name FROM `lc_products_info`";

        List<String> result = new ArrayList<>();

        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                result.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
