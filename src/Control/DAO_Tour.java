/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import static Control.DAO.getConnection;
import Object.Tour;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MYLAP.VN
 */
public class DAO_Tour {
    public static boolean addTour(Tour t) throws SQLException{
        String query="INSERT INTO Tour(ma_tour,ten_tour,gia,ngay_bd,ngay_kt) VALUES (?, ?, ?, ?, ?)";
        try(Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(query)){
                pstmt.setString(1,t.getMaTour());
                pstmt.setString(2,t.getTenTour());
                pstmt.setDouble(3,t.getGia());
                pstmt.setDate(4, java.sql.Date.valueOf(t.getNgayBd()));
                pstmt.setDate(5, java.sql.Date.valueOf(t.getNgayKt()));
                
                int RowInserted=pstmt.executeUpdate();
                return RowInserted > 0;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Tour.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } 
    
    public static ArrayList<Tour> getListTour() throws SQLException{
        ArrayList<Tour> listTour=new ArrayList<>();
        String query="SELECT * FROM Tour";
        
        try (Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery()){
                while(rs.next()){
                    Tour t=new Tour();
                    t.setMaTour(rs.getString("ma_tour"));
                    t.setTenTour(rs.getString("ten_tour"));
                    t.setGia(rs.getDouble("gia"));
                    java.sql.Date sqlNgayBd = rs.getDate("ngay_bd");
                    java.sql.Date sqlNgayKt = rs.getDate("ngay_kt");
                    if (sqlNgayBd != null) {
                        t.setNgayBd(sqlNgayBd.toLocalDate());
                    }
                    if (sqlNgayKt != null) {
                        t.setNgayKt(sqlNgayKt.toLocalDate());
                    }
                    listTour.add(t);
                }
                System.out.println("Lấy danh sách Tour thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
                JOptionPane.showMessageDialog(null,"lỗi khi lấy danh sách tour","lỗi" ,JOptionPane.ERROR_MESSAGE);
        }
        return listTour;
    }
    
    public static boolean updateTour(Tour t) {
        String query = "UPDATE Tour SET ten_tour = ?, gia = ?, ngay_bd = ?, ngay_kt = ? WHERE ma_tour = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, t.getTenTour());
            pstmt.setDouble(2, t.getGia());
            pstmt.setDate(3, java.sql.Date.valueOf(t.getNgayBd()));
            pstmt.setDate(4, java.sql.Date.valueOf(t.getNgayKt()));
            pstmt.setString(5, t.getMaTour());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật Tour.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean deleteTour(String maTour) {
        String query = "DELETE FROM Tour WHERE ma_tour = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, maTour);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Tour.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    
   public static ArrayList<Tour> searchTour(String keyword) {
    ArrayList<Tour> listTour = new ArrayList<>();
    String query = "SELECT * FROM Tour WHERE ten_tour LIKE ?"; // Câu lệnh SQL tìm kiếm

    try (Connection conn = DAO.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, "%" + keyword + "%"); // Sử dụng LIKE để tìm kiếm

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Tour tour = new Tour();
            tour.setMaTour(rs.getString("ma_tour"));
            tour.setTenTour(rs.getString("ten_tour"));
            tour.setGia(rs.getDouble("gia"));
            tour.setNgayBd(rs.getDate("ngay_bd").toLocalDate());
            tour.setNgayKt(rs.getDate("ngay_kt").toLocalDate());
            listTour.add(tour);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm Tour.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    return listTour;
}


}
