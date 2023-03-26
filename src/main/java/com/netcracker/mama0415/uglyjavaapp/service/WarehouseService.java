package com.netcracker.mama0415.uglyjavaapp.service;

import com.netcracker.mama0415.uglyjavaapp.adapters.JDBCAdapter;
import com.netcracker.mama0415.uglyjavaapp.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Component
public class WarehouseService {
    @Autowired private JDBCAdapter jdbcAdapter;

    public Map<Warehouse, Integer> getAvailabilityReport(final String isbn13) {
        final Connection connection = jdbcAdapter.getConnection();
        try (Statement stmnt = connection.createStatement()){
            ResultSet availability = stmnt.executeQuery("select * from book_availability where book_id = '" + isbn13 + "'");
            HashMap<Warehouse, Integer> report = new HashMap<>();
            while (availability.next()){
                int warehouseId = availability.getInt("warehouse_id");
                int amount = availability.getInt("amount");
                Warehouse warehouse = getWarehouse(warehouseId);
                report.put(warehouse, amount);
            }
            return report;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Warehouse getWarehouse(final int id){
        final Connection connection = jdbcAdapter.getConnection();
        try (Statement stmnt = connection.createStatement()) {
            ResultSet resultSet = stmnt.executeQuery("select * from warehouse where id = '" + id + "'");
            if (resultSet.next()){
                Warehouse warehouse = new Warehouse();
                warehouse.setId(String.valueOf(resultSet.getInt("id")));
                warehouse.setAddress(resultSet.getString("address"));
                warehouse.setName(resultSet.getString("name"));
                warehouse.setManagerName(resultSet.getString("managername"));
                warehouse.setWorkingHours(resultSet.getString("workinghours"));
                return warehouse;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
