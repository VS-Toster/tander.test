package dboperation;

import config.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlOperations {
    private final Connection connection;
    private final Statement statement;

    public SqlOperations() throws SQLException {
        DbConnection dbConnection = new DbConnection();
        connection = dbConnection.getConnection();
        statement = connection.createStatement();

    }

    public Boolean existingData(String tableName) {
        try {
            String query = "SELECT * FROM " + tableName + " limit 1";
            ResultSet rs = statement.executeQuery(query);
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void truncateTable(String tableName) {
        try {
            String query = "TRUNCATE " + tableName;
            statement.executeUpdate(query);
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertData(String tableName, long value) {
        try {
            String query = "INSERT INTO " + tableName + " VALUES ( " + value + " )";
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Long> getData(String tableName) {
        try {
            String query = "SELECT * from " +  tableName;
            ResultSet rs = statement.executeQuery(query);
            List<Long> list = new ArrayList<>();
            while (rs.next()) {
                Long value = rs.getLong("field");
                list.add(value);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}




