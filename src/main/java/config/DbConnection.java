package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/Test_Database";
    private static final String USER = "postgres";
    private static final String PASS = "123";
    private Connection connection;


    public DbConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");


        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            this.connection.setAutoCommit(false);

        } catch (
                SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (this.connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");

        }

    }

    public Connection getConnection() {
        return connection;
    }
}
