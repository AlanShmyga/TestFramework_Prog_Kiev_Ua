package utils;

import sun.management.ConnectorAddressLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static Connection getDatabaseConnection() {
        String databaseUrl = PropertyHelper.getProperty("dburl");
        String databaseUser = "root";
        String databasePassword = "";

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
}
