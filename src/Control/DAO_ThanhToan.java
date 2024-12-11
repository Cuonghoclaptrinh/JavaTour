/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Object.ThanhToan;
import Control.DAO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MYLAP.VN
 */
public class DAO_ThanhToan {
    public static boolean savePayment(ThanhToan payment) throws SQLException {
        String sql = "INSERT INTO ThanhToan(ma_thanh_toan, ma_dat_tour, ngay_thanh_toan, hinh_thuc, tong_tien) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DAO.getConnection().prepareStatement(sql)) {
            ps.setString(1, payment.getMaThanhToan());
            ps.setString(2, payment.getMadatTour()); 
            ps.setDate(3, java.sql.Date.valueOf(payment.getNgayThanhToan()));
            ps.setString(4, payment.getHinhThuc());
            ps.setDouble(5, payment.getTongTien());
            return ps.executeUpdate() > 0; // Trả về true nếu lưu thành công
        }
    }
    
    public static boolean isMaThanhToanExist(String maThanhToan) throws SQLException {
    boolean exists = false;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = DAO.getConnection(); // Kết nối đến cơ sở dữ liệu
        String sql = "SELECT COUNT(*) FROM ThanhToan WHERE ma_thanh_toan = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, maThanhToan);
        
        rs = stmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            exists = true; // Mã đã tồn tại
        }
    } catch (SQLException e) {
        e.printStackTrace(); // In ra lỗi nếu có
        throw e; // Ném lại ngoại lệ để xử lý bên ngoài
    } finally {
        // Đóng kết nối và tài nguyên
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return exists;
}
    
    public static DefaultTableModel getPaymentHistory() {
    DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Mã Thanh Toán", "Mã Đặt Tour", "Ngày Thanh Toán", "Hình Thức", "Tổng Tiền"}, 0);

    String sql = "SELECT ma_thanh_toan, ma_dat_tour, ngay_thanh_toan, hinh_thuc, tong_tien " +
                 "FROM ThanhToan";

    try (Connection conn = DAO.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String maThanhToan = rs.getString("ma_thanh_toan");
            String maDatTour = rs.getString("ma_dat_tour");
            Date ngayThanhToan = rs.getDate("ngay_thanh_toan");
            String hinhThuc = rs.getString("hinh_thuc");
            double tongTien = rs.getDouble("tong_tien");

            tableModel.addRow(new Object[]{maThanhToan, maDatTour, ngayThanhToan, hinhThuc, tongTien});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tableModel;
}


    public static DefaultTableModel searchPayments(String keyword) {
    DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Mã Đặt Tour", "Tên Tour", "Khách Hàng", "Ngày Thanh Toán", "Hình Thức", "Tổng Tiền"}, 0);
    String sql = "SELECT ma_thanh_toan, ma_dat_tour, ten_tour, ten_kh, ngay_thanh_toan, hinh_thuc, tong_tien " +
                 "FROM ThanhToan " +
                 "JOIN DatTour ON ThanhToan.ma_dat_tour = DatTour.ma_dat_tour " +
                 "JOIN Tour ON DatTour.ma_tour = Tour.ma_tour " +
                 "JOIN KhachHang ON DatTour.ma_kh = KhachHang.ma_kh " +
                 "WHERE ma_thanh_toan LIKE ? OR ten_tour LIKE ? OR ten_kh LIKE ?";

    try (Connection conn = DAO.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String searchKeyword = "%" + keyword + "%"; // Thêm dấu % để tìm kiếm như từ khóa chứa keyword
        stmt.setString(1, searchKeyword);
        stmt.setString(2, searchKeyword);
        stmt.setString(3, searchKeyword);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String maThanhToan = rs.getString("ma_thanh_toan");
                String maDatTour = rs.getString("ma_dat_tour");
                String tenTour = rs.getString("ten_tour");
                String tenKhachHang = rs.getString("ten_kh");
                Date ngayThanhToan = rs.getDate("ngay_thanh_toan");
                String hinhThuc = rs.getString("hinh_thuc");
                double tongTien = rs.getDouble("tong_tien");

                tableModel.addRow(new Object[]{maDatTour, tenTour, tenKhachHang, ngayThanhToan, hinhThuc, tongTien});
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tableModel;
}
    
    
}
