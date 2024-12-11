/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Control.DAO;
/**
 *
 * @author MYLAP.VN
 */
import java.sql.*;
import java.util.ArrayList;

public class DAO_Queries {

    private static Connection _connection;

    // Hàm Select
    public static ArrayList<Object[]> Select(String stmt, Object... args) {
        ArrayList<Object[]> resultSet = new ArrayList<>();

        try {
            // Đảm bảo kết nối
            _connection =DAO.getConnection();
            if (_connection == null) return resultSet;

            try (PreparedStatement cmd = _connection.prepareStatement(stmt)) {
                // Thêm tham số vào câu lệnh SQL
                for (int i = 0; i < args.length; ++i) {
                    cmd.setObject(i + 1, args[i]);
                }

                // Thực thi truy vấn và đọc dữ liệu
                try (ResultSet reader = cmd.executeQuery()) {
                    while (reader.next()) {
                        // Tạo một ArrayList con chứa dữ liệu của từng hàng
                        ArrayList<Object> row = new ArrayList<>();
                        for (int i = 1; i <= reader.getMetaData().getColumnCount(); i++) {
                            row.add(reader.getObject(i)); // Thêm giá trị của từng cột vào hàng
                        }
                        resultSet.add(row.toArray()); // Thêm hàng vào danh sách kết quả
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Đảm bảo kết nối luôn được đóng
            try {
                if (_connection != null && !_connection.isClosed()) {
                    _connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultSet;
    }

    // Hàm Update
    public static int Update(String stmt, Object... args) {
        int totalAffectedRows = 0;

        try {
            // Đảm bảo kết nối
            _connection = DAO.getConnection();
            if (_connection == null) return totalAffectedRows;

            try (PreparedStatement cmd = _connection.prepareStatement(stmt)) {
                // Thêm tham số vào câu lệnh SQL
                for (int i = 0; i < args.length; ++i) {
                    cmd.setObject(i + 1, args[i]);
                }

                // Thực thi câu lệnh SQL
                totalAffectedRows = cmd.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Đảm bảo kết nối luôn được đóng
            try {
                if (_connection != null && !_connection.isClosed()) {
                    _connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return totalAffectedRows;
    }
}

