/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import static Control.DAO.getConnection;
import Object.KhachHang;
import Control.DAO_KhachHang;
import Control.DAO;
import com.sun.source.tree.WhileLoopTree;
import java.util.ArrayList;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author MYLAP.VN
 */
public class DAO_KhachHang {
    public static boolean addKhachHang(KhachHang kh)throws SQLException{
        Connection conn = null;
        try {
            conn=DAO.getConnection();
            String sql="INSERT INTO KhachHang(ma_kh,ten_kh,sdt,cccd,dia_chi) VALUES (?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,kh.getMaKh());
            ps.setString(2, kh.getTenKh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getCccd());
            ps.setString(5, kh.getDiaChi());
            
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Khách hàng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            DAO.closeConnection(conn);
        }
        
    }

    public ArrayList<KhachHang> getAllCustomers(){
        ArrayList<KhachHang> ListCusstomer=new ArrayList<>();
        Connection conn=null;
        
        try {
            conn=DAO.getConnection();
            String sql="SELECT * FROM KhachHang";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
                String makh=rs.getString("ma_kh");
                String tenkh=rs.getString("ten_kh");
                String sdt=rs.getString("sdt");
                String cccd=rs.getString("cccd");
                String diachi=rs.getString("dia_chi");
                
                
                KhachHang kh=new KhachHang(makh,tenkh,sdt,cccd,diachi);
                ListCusstomer.add(kh);
        }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "lỗi khi lấy danh sách tour" , "lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return ListCusstomer;
    }

    
    public boolean deleteCustomer(String maKH) {
        Connection conn = null;

        try {
            conn = DAO.getConnection();
            String sql = "DELETE FROM KhachHang WHERE ma_kh=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKH);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAO.closeConnection(conn);
        }
        return false;
    }
    
    public static boolean UpdateKhachHang(KhachHang kh){
        String sql="UPDATE KhachHang SET ten_kh=? , sdt=?, cccd=? , dia_chi=? WHERE ma_kh=?";
        Connection conn=null;
        try {
            conn=DAO.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ps.setString(1, kh.getTenKh());
            ps.setString(2, kh.getSdt());
            ps.setString(3, kh.getCccd());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getMaKh());
            
            int rowUpdate=ps.executeUpdate();
            return rowUpdate>0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật Tour.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } 
    
    // Booking
    public static KhachHang getCustomerByMaKh(String MaKh) throws SQLException {
    Connection conn = null;
    KhachHang customer = null;
    try {
        conn = DAO.getConnection();
        String sql = "SELECT * FROM KhachHang WHERE ma_kh = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, MaKh);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            customer = new KhachHang(
                rs.getString("ma_kh"),
                rs.getString("ten_kh"),
                rs.getString("sdt"),
                rs.getString("cccd"),
                rs.getString("dia_chi")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DAO.closeConnection(conn);
    }
    return customer;
}
    
    public ArrayList<KhachHang> searchCustomer(String keyword) {
    ArrayList<KhachHang> resultList = new ArrayList<>();
    String query = "SELECT * FROM KhachHang WHERE ten_kh LIKE ? OR cccd LIKE ?";
    try (Connection conn = DAO.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, "%" + keyword + "%");
        pstmt.setString(2, "%" + keyword + "%");

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            KhachHang kh = new KhachHang(
                rs.getString("ma_kh"),
                rs.getString("ten_kh"),
                rs.getString("sdt"),
                rs.getString("cccd"),
                rs.getString("dia_chi")
            );
            resultList.add(kh);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm khách hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    return resultList;
}
    
    
}
