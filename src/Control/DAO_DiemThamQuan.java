/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Object.DiemThamQuan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYLAP.VN
 */
public class DAO_DiemThamQuan {
     public boolean addDiemThamQuan(DiemThamQuan dtq) {
        String sql = "INSERT INTO DiemThamQuan (ma_diem_tham_quan, ten_dia_diem, dia_chi) VALUES (?, ?, ?)";
        try (Connection conn = DAO.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, dtq.getMaDiemThamQuan());
            pstmt.setString(2, dtq.getTenDiaDiem());
            pstmt.setString(3, dtq.getDiaChi());
            
            return pstmt.executeUpdate() > 0; // Nếu thêm thành công, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Nếu có lỗi xảy ra, trả về false
        }
    }

    // Cập nhật điểm tham quan
    public boolean updateDiemThamQuan(DiemThamQuan dtq) {
        String sql = "UPDATE DiemThamQuan SET ten_dia_diem = ?, dia_chi = ? WHERE ma_diem_tham_quan = ?";
        try (Connection conn = DAO.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, dtq.getTenDiaDiem());
            pstmt.setString(2, dtq.getDiaChi());
            pstmt.setString(3, dtq.getMaDiemThamQuan());
            
            return pstmt.executeUpdate() > 0; // Nếu cập nhật thành công, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Nếu có lỗi xảy ra, trả về false
        }
    }

    // Xóa điểm tham quan
    public boolean deleteDiemThamQuan(String maDiemThamQuan) {
        String sql = "DELETE FROM DiemThamQuan WHERE ma_diem_tham_quan = ?";
        try (Connection conn = DAO.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, maDiemThamQuan);
            
            return pstmt.executeUpdate() > 0; // Nếu xóa thành công, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Nếu có lỗi xảy ra, trả về false
        }
    }

    // Lấy danh sách điểm tham quan
    public ArrayList<DiemThamQuan> getAllDiemThamQuan() {
    ArrayList<DiemThamQuan> list = new ArrayList<>(); // Sử dụng ArrayList
    String sql = "SELECT * FROM DiemThamQuan";
    
    try (Connection conn = DAO.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql); 
         ResultSet rs = pstmt.executeQuery()) {
         
        while (rs.next()) {
            DiemThamQuan dtq = new DiemThamQuan(
                    rs.getString("ma_diem_tham_quan"),
                    rs.getString("ten_dia_diem"),
                    rs.getString("dia_chi")
            );
            list.add(dtq); // Thêm đối tượng vào danh sách
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return list; // Trả về danh sách điểm tham quan
}
    
    // Tìm kiếm điểm tham quan theo tên hoặc địa chỉ
public ArrayList<DiemThamQuan> searchDiemThamQuan(String keyword) {
    ArrayList<DiemThamQuan> list = new ArrayList<>(); // Danh sách kết quả tìm kiếm
    String sql = "SELECT * FROM DiemThamQuan WHERE ten_dia_diem LIKE ? OR dia_chi LIKE ?";

    try (Connection conn = DAO.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, "%" + keyword + "%"); // Thêm từ khóa tìm kiếm cho tên
        pstmt.setString(2, "%" + keyword + "%"); // Thêm từ khóa tìm kiếm cho địa chỉ
        
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            DiemThamQuan dtq = new DiemThamQuan(
                    rs.getString("ma_diem_tham_quan"),
                    rs.getString("ten_dia_diem"),
                    rs.getString("dia_chi")
            );
            list.add(dtq); // Thêm đối tượng vào danh sách
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list; // Trả về danh sách điểm tham quan tìm được
}

}
