/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Control.DAO;
import Object.TourDTQ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAO_TourDTQ {
    
    public ArrayList<TourDTQ> getAllTourDTQ() {
    ArrayList<TourDTQ> result = new ArrayList<>();
    String query = "SELECT * FROM Tour_DiemThamQuan";
    
    try (Connection conn = DAO.getConnection();
         PreparedStatement pst = conn.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            String maTour = rs.getString("ma_tour");
            String maDiemThamQuan = rs.getString("ma_diem_tham_quan");
            result.add(new TourDTQ(maTour, maDiemThamQuan));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi lấy dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    return result;
}
    
    // Thêm mới Tour_DiemThamQuan
    public boolean addTourDiemThamQuan(TourDTQ tourDiemThamQuan) {
        String query = "INSERT INTO Tour_DiemThamQuan (ma_tour, ma_diem_tham_quan) VALUES (?, ?)";
        try (Connection conn = DAO.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, tourDiemThamQuan.getMaTour());
            pst.setString(2, tourDiemThamQuan.getMaDTQ());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Cập nhật Tour_DiemThamQuan
    public boolean updateTourDiemThamQuan(TourDTQ tourDiemThamQuan) {
        String query = "UPDATE Tour_DiemThamQuan SET ma_diem_tham_quan = ? WHERE ma_tour = ?";
        try (Connection conn = DAO.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, tourDiemThamQuan.getMaDTQ());
            pst.setString(2, tourDiemThamQuan.getMaTour());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Xóa Tour_DiemThamQuan
    public boolean deleteTourDiemThamQuan(String maTour, String maDiemThamQuan) {
        String query = "DELETE FROM Tour_DiemThamQuan WHERE ma_tour = ? AND ma_diem_tham_quan = ?";
        try (Connection conn = DAO.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, maTour);
            pst.setString(2, maDiemThamQuan);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Tìm kiếm Tour_DiemThamQuan
    public ArrayList<TourDTQ> searchTourDTQ(String keyword) {
    ArrayList<TourDTQ> list = new ArrayList<>();
    String sql = "SELECT * FROM Tour_DiemThamQuan WHERE ma_tour LIKE ? OR ma_diem_tham_quan LIKE ?";

    try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        // Cài đặt từ khóa tìm kiếm cho cả ma_tour và ma_diem_tham_quan
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");

        // Thực thi truy vấn
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String maTour = rs.getString("ma_tour");
            String maDiemThamQuan = rs.getString("ma_diem_tham_quan");
            list.add(new TourDTQ(maTour, maDiemThamQuan)); // Thêm đối tượng TourDTQ vào danh sách
        }

        // Kiểm tra nếu không có kết quả
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    return list;
}

}

