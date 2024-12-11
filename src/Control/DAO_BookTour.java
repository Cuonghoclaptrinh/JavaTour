/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import javax.swing.table.DefaultTableModel;
import Control.DAO;
import Object.DatTour;
import java.beans.Statement;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author MYLAP.VN
 */
public class DAO_BookTour {
    public DefaultTableModel getTourDataForBooking() {
        // Khai báo DefaultTableModel với cột đầu tiên là Boolean
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Chọn", "Mã Tour", "Tên Tour", "Giá"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Định nghĩa kiểu của cột đầu tiên là Boolean để hiển thị checkbox
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Chỉ cho phép chỉnh sửa cột "Chọn" (checkbox)
                return column == 0;
            }
        };

        String sql = "SELECT ma_tour, ten_tour, gia FROM Tour";  // Thay tên bảng nếu cần

        try (Connection conn = DAO.getConnection();  
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                boolean chon = false;  // Mặc định là chưa chọn
                String maTour = rs.getString("ma_tour");
                String tenTour = rs.getString("ten_tour");
                double gia = rs.getDouble("gia");

                // Thêm hàng vào DefaultTableModel
                tableModel.addRow(new Object[]{chon, maTour, tenTour, gia});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableModel;
    }
    
    public static boolean BookT(DatTour b) throws SQLException{
        Connection conn=null;
        try {
            conn=DAO.getConnection();
            String sql="INSERT INTO DatTour(ma_dat_tour,ma_tour,ma_kh,ngay_dat,so_luong_nguoi,tong_tien) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, b.getMaDatTour());
            ps.setString(2, b.getMaTour());
            ps.setString(3,b.getMaKhachHang());
            ps.setDate(4,java.sql.Date.valueOf(b.getNgayDat()));
            ps.setInt(5,b.getSoLuongNguoi());
            ps.setDouble(6, b.getTongTien());
            
            return ps.executeUpdate()>0;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "lỗi khi đặt tour" ,"lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            DAO.closeConnection(conn);
        }
    }
    
    public static boolean isMaDatTourExist(String maDatTour) throws SQLException {
        boolean exists = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DAO.getConnection(); // Kết nối đến cơ sở dữ liệu
            String sql = "SELECT COUNT(*) FROM DatTour WHERE ma_dat_tour = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maDatTour);
            
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
    
    //Quản lý tour đã đặt
    // Lấy danh sách chuyến đi đã đặt
public static DefaultTableModel getBookingHistory() {
    DefaultTableModel tableModel = new DefaultTableModel(
            new Object[]{"Mã Đặt Tour", "Tên Tour", "Khách Hàng", "Ngày Đặt", "Số Lượng", "Tổng Tiền", "Trạng Thái Thanh Toán"}, 0){
@Override
        public boolean isCellEditable(int row, int column) {
            return false; // Tất cả các ô trong bảng đều không thể chỉnh sửa
        }
    };
    String sql = "SELECT ma_dat_tour, ten_tour, ten_kh, ngay_dat, so_luong_nguoi, tong_tien, trang_thai " +
                 "FROM DatTour " +
                 "JOIN Tour ON DatTour.ma_tour = Tour.ma_tour " +
                 "JOIN KhachHang ON DatTour.ma_kh = KhachHang.ma_kh";

    try (Connection conn = DAO.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String maDatTour = rs.getString("ma_dat_tour");
            String tenTour = rs.getString("ten_tour");
            String tenKhachHang = rs.getString("ten_kh");
            Date ngayDat = rs.getDate("ngay_dat");
            int soLuong = rs.getInt("so_luong_nguoi");
            double tongTien = rs.getDouble("tong_tien");
            String trangThaiThanhToan = rs.getString("trang_thai");

            tableModel.addRow(new Object[]{maDatTour, tenTour, tenKhachHang, ngayDat, soLuong, tongTien, trangThaiThanhToan});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tableModel;
}

    
    
    // Tìm kiếm chuyến đi đã đặt theo từ khóa
public static DefaultTableModel searchBookings(String keyword) {
    DefaultTableModel tableModel = new DefaultTableModel(
            new Object[]{"Mã Đặt Tour", "Tên Tour", "Khách Hàng", "Ngày Đặt", "Số Lượng", "Tổng Tiền", "Trạng Thái"}, 0);

    String sql = "SELECT ma_dat_tour, ten_tour, ten_kh, ngay_dat, so_luong_nguoi, tong_tien, trang_thai " +
                 "FROM DatTour " +
                 "JOIN Tour ON DatTour.ma_tour = Tour.ma_tour " +
                 "JOIN KhachHang ON DatTour.ma_kh = KhachHang.ma_kh " +
                 "WHERE (ten_tour LIKE ? OR ten_kh LIKE ? OR ma_dat_tour LIKE ?)";

    try (Connection conn = DAO.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String searchKeyword = "%" + keyword + "%";
        stmt.setString(1, searchKeyword);
        stmt.setString(2, searchKeyword);
        stmt.setString(3, searchKeyword);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String maDatTour = rs.getString("ma_dat_tour");
                String tenTour = rs.getString("ten_tour");
                String tenKhachHang = rs.getString("ten_kh");
                Date ngayDat = rs.getDate("ngay_dat");
                int soLuong = rs.getInt("so_luong_nguoi");
                double tongTien = rs.getDouble("tong_tien");
                String trangThaiThanhToan = rs.getString("trang_thai");

                tableModel.addRow(new Object[]{maDatTour, tenTour, tenKhachHang, ngayDat, soLuong, tongTien, trangThaiThanhToan});
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tableModel;
}

 public static boolean updateTourStatus(String maDatTour, String trangThai) throws SQLException {
        String sql = "UPDATE DatTour SET trang_thai = ? WHERE ma_dat_tour = ?";
        try (Connection conn = DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, trangThai);
            stmt.setString(2, maDatTour);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        }
    }

public static ArrayList<String> getTourInfoList(String maDatTour) {
        ArrayList<String> tourInfoList = new ArrayList<>();
        String query = """
                SELECT  
                       kh.dia_chi AS diaChi, 
                       kh.cccd, 
                       t.gia
                       
                FROM DatTour dt
                JOIN KhachHang kh ON dt.ma_kh = kh.ma_kh
                JOIN Tour t ON dt.ma_tour = t.ma_tour
                LEFT JOIN ThanhToan tt ON dt.ma_dat_tour = tt.ma_dat_tour
                WHERE dt.ma_dat_tour = ?;
                """;

        try (Connection connection = DAO.getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            // Set giá trị cho tham số maDatTour
            stmt.setString(1, maDatTour);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    String diaChi = rs.getString("diaChi");
                    String cccd = rs.getString("cccd");
                    double gia = rs.getDouble("gia");
                    

                    // Gộp thông tin thành một chuỗi và thêm vào danh sách
                    String info = String.format(" Địa chỉ: %s, CCCD: %s, Giá: %.2f, ",
                                                diaChi, cccd, gia);
                    tourInfoList.add(info);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tourInfoList;
    }
}
