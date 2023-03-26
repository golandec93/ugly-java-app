package com.github.golandec93.uglyjavaapp.adapters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class JDBCAdapter {

    private final String connectionString;

    public JDBCAdapter(@Value("${ugly-app.jdbc.host}") final String host,
                       @Value("${ugly-app.jdbc.port}") final String port,
                       @Value("${ugly-app.jdbc.dbName}") final String dbName,
                       @Value("${ugly-app.jdbc.user}") final String user,
                       @Value("${ugly-app.jdbc.password}") final String password) {
        this.connectionString = String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s",
                host, port, dbName, user, password);
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
