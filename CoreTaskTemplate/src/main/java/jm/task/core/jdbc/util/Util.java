package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/store?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection to  DB succesfull");
        } catch (Exception e) {
            System.out.println("Connection failed");
            System.out.println(e);
        }
        return connection;
    }
}
