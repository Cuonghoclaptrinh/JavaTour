/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Object.HuongDanVien;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MYLAP.VN
 */
public class DAO_HuongDanVien {
    public boolean addHuongDanVien(HuongDanVien hdv) {
        String sql = "INSERT INTO HuongDanVien ( full_name, cccd, sdt, diachi) VALUES (?, ?, ?, ?)";
        try (Connection conn = DAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
           
            pstmt.setString(1, hdv.getFullname());
            pstmt.setString(2, hdv.getCccd());
            pstmt.setString(3, hdv.getSdt());
            pstmt.setString(4, hdv.getDiachi());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateHuongDanVien(HuongDanVien hdv) {
        String sql = "UPDATE HuongDanVien SET full_name = ?, cccd = ?, sdt = ?, diachi = ? WHERE ma_hdv = ?";
        try (Connection conn = DAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hdv.getFullname());
            pstmt.setString(2, hdv.getCccd());
            pstmt.setString(3, hdv.getSdt());
            pstmt.setString(4, hdv.getDiachi());
            pstmt.setString(5, hdv.getMaHdv());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteHuongDanVien(String maHdv) {
        String sql = "DELETE FROM HuongDanVien WHERE ma_hdv = ?";
        try (Connection conn = DAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maHdv);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<HuongDanVien> getAllHuongDanVien() {
        ArrayList<HuongDanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM HuongDanVien";
        try (Connection conn = DAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                HuongDanVien hdv = new HuongDanVien(
                    rs.getString("ma_hdv"),
                    rs.getString("full_name"),
                    rs.getString("cccd"),
                    rs.getString("sdt"),
                    rs.getString("diachi")
                );
                list.add(hdv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
   public ArrayList<HuongDanVien> searchGuide(String keyword) {
    ArrayList<HuongDanVien> resultList = new ArrayList<>();
    String query = "SELECT * FROM HuongDanVien WHERE full_name LIKE ? OR cccd LIKE ?";

    try (Connection conn = DAO.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, "%" + keyword + "%"); // Tìm kiếm theo tên
        pstmt.setString(2, "%" + keyword + "%"); // Tìm kiếm theo cccd

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            HuongDanVien hdv = new HuongDanVien(
                rs.getString("ma_hdv"),
                rs.getString("full_name"),
                rs.getString("cccd"),
                rs.getString("sdt"),
                rs.getString("diachi")
            );
            resultList.add(hdv);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm hướng dẫn viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    return resultList;
}

}

    

