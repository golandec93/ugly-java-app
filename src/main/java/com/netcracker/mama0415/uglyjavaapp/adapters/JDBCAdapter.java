package com.netcracker.mama0415.uglyjavaapp.adapters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class JDBCAdapter {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/UGLY_APP?user=UGLY_APP&password=UGLY_APP");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
