/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Object.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class DAO_NhanVien {
    public static boolean addNhanVien(NhanVien nv)throws SQLException{
        Connection conn = null;
        try {
            conn=DAO.getConnection();
            String sql="INSERT INTO NhanVien(id,full_name,cccd,email,pass_word,chuc_vu) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, nv.getId());
            ps.setString(2,nv.getFullname());
            ps.setString(3, nv.getCccd());
            ps.setString(4, nv.getEmail());
            ps.setString(5, nv.getPassword());
            ps.setString(6, nv.getChucvu());
            
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Nhân Viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            DAO.closeConnection(conn);
        }
        
    }

    public ArrayList<NhanVien> getAllNhanVien(){
        ArrayList<NhanVien> ListNhanVien = new ArrayList<>();
        Connection conn=null;
        
        try {
            conn=DAO.getConnection();
            String sql="SELECT * FROM NhanVien";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
                String id = rs.getString("id");
                String tennv=rs.getString("full_name");
                String cccd=rs.getString("cccd");
                String email=rs.getString("email");
                String pass=rs.getString("pass_word");
                String chucvu=rs.getString("chuc_vu");
                
                
                NhanVien nv=new NhanVien(id,tennv,cccd,email,pass,chucvu);
                ListNhanVien.add(nv);
        }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "lỗi khi lấy danh sách nhân viên" , "lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return ListNhanVien;
    }

    
    public boolean deleteNhanVien(String id) {
        Connection conn = null;

        try {
            conn = DAO.getConnection();
            String sql = "DELETE FROM NhanVien WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAO.closeConnection(conn);
        }
        return false;
    }
    
    public static boolean UpdateNhanVien(NhanVien nv){
        String sql="UPDATE NhanVien SET full_name=? , cccd=?, email=? , pass_word=? ,chuc_vu = ? WHERE id=?";
        Connection conn=null;
        try {
            conn=DAO.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ps.setString(1, nv.getFullname());
            ps.setString(2, nv.getCccd());
            ps.setString(3, nv.getEmail());
            ps.setString(4, nv.getPassword());
            ps.setString(5, nv.getChucvu());
            ps.setString(6, nv.getId());
            
            int rowUpdate=ps.executeUpdate();
            return rowUpdate>0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật Nhân Viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } 
    
    
    
    public ArrayList<NhanVien> searchNhanVien(String keyword) {
    ArrayList<NhanVien> resultList = new ArrayList<>();
    String query = "SELECT * FROM NhanVien WHERE full_name LIKE ? OR cccd LIKE ?";
    try (Connection conn = DAO.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, "%" + keyword + "%");
        pstmt.setString(2, "%" + keyword + "%");

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
           NhanVien nv = new NhanVien(
                rs.getString("id"),
                rs.getString("full_name"),
                rs.getString("cccd"),
                rs.getString("email"),
                rs.getString("pass_word"),
                rs.getString("chuc_vu")
            );
            resultList.add(nv);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    return resultList;
}
    
    public static NhanVien getUserInfo(String email,String password) {
    NhanVien userInfo = null;
    String query = "SELECT * FROM NhanVien WHERE email = ? AND pass_word = ?";

    try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, email);
        stmt.setString(2, password);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Đăng nhập thành công, tạo đối tượng NhanVien để lưu thông tin
                userInfo = new NhanVien(
                    rs.getString("id"),
                    rs.getString("full_name"),
                    rs.getString("cccd"),
                    rs.getString("email"),
                    rs.getString("pass_word"),
                    rs.getString("chuc_vu")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra đăng nhập.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    return userInfo;
}

}
