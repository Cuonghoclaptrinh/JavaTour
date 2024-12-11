/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MYLAP.VN
 */
public class DAO {
    public static Connection getConnection() {
        Connection c = null;

        try {
            // Từ JDBC 4.0 trở đi, không cần đăng ký driver thủ công nếu driver đã được thêm vào classpath
            // Tuy nhiên, để đảm bảo, bạn có thể sử dụng Class.forName(...)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Các thông số kết nối
            String url = "jdbc:sqlserver://DESKTOP-C2UG3F0:1433;databaseName=dulich_thi;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password = "123";
            
            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver không tìm thấy!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Kết nối đến cơ sở dữ liệu thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        return c;
    }
    
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
