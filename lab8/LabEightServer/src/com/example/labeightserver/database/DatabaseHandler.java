package com.example.labeightserver.database;

import java.sql.*;

public class DatabaseHandler {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";

    private Connection connection;

    public DatabaseHandler() throws DatabaseException {
//        connectToDatabase("s327630", "wys705", "jdbc:postgresql://pg:5432/studs");
        connectToDatabase("s334645", "eNiIXg15sQmP6nDf", "jdbc:postgresql://localhost:1099/studs");
    }

    public void connectToDatabase(String login, String password, String url) throws DatabaseException {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new DatabaseException("data driver not found");
        }
    }

    public Statement getStatement() throws DatabaseException {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new DatabaseException("cannot get database statement");
        }
    }

    public PreparedStatement getPreparedStatement(String sql) throws DatabaseException {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public PreparedStatement getPreparedStatement(String sql, boolean autoGenerateKey) throws DatabaseException {
        try {
            return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public PreparedStatementWithNull getPreparedStatementWithNull(String sql) throws DatabaseException {
        return new PreparedStatementWithNull(getPreparedStatement(sql));
    }

    public PreparedStatementWithNull getPreparedStatementWithNull(String sql, boolean autoGenerateKey) throws DatabaseException {
        return new PreparedStatementWithNull(getPreparedStatement(sql, true));
    }

    public void closeConnection() {
        try {
            if (connection == null) throw new SQLException();
            connection.close();
        } catch (SQLException e) {
            // todo:
            System.out.println(e.getMessage());
        }
    }

    public void setCommitMode() {
        try {
            if (connection == null) throw new SQLException();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setNormalMode() {
        try {
            if (connection == null) throw new SQLException();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void commit() {
        try {
            if (connection == null) throw new SQLException();
            connection.commit();
            setNormalMode();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void rollback() {
        try {
            if (connection == null) throw new SQLException();
            connection.rollback();
            setNormalMode();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSavepoint() {
        try {
            if (connection == null) throw new SQLException();
            setCommitMode();
            connection.setSavepoint();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
