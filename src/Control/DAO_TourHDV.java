package Control;

import Object.TourHDV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAO_TourHDV {

    // Thêm TourHDV mới
    public boolean addTourHDV(TourHDV tourHDV) {
        String query = "INSERT INTO Tour_HDV (ma_tour, ma_hdv) VALUES (?, ?)";

        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, tourHDV.getMaTour());
            stmt.setString(2, tourHDV.getMaHDV());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Tour-HDV", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Xóa TourHDV
    public boolean deleteTourHDV(String maTour, String maHDV) {
        String query = "DELETE FROM Tour_HDV WHERE ma_tour = ? AND ma_hdv = ?";

        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, maTour);
            stmt.setString(2, maHDV);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xoá Tour-HDV", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Lấy danh sách tất cả các mục Tour_HDV
    public ArrayList<TourHDV> getAllTourHDV() {
        ArrayList<TourHDV> list = new ArrayList<>();
        String query = "SELECT ma_tour, ma_hdv FROM Tour_HDV";

        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maTour = rs.getString("ma_tour");
                String maHDV = rs.getString("ma_hdv");
                list.add(new TourHDV(maTour, maHDV));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi truy xuất dữ liệu Tour-HDV", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        return list;
    }

    // Kiểm tra sự tồn tại của một Tour_HDV
    public boolean existsTourHDV(String maTour, String maHDV) {
        String query = "SELECT 1 FROM Tour_HDV WHERE ma_tour = ? AND ma_hdv = ?";

        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, maTour);
            stmt.setString(2, maHDV);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kiểm tra Tour-HDV", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Thêm phương thức cập nhật trong DAO_TourHDV
    public boolean updateTourHDV(String maTour, String oldMaHDV, String newMaHDV) {
        String query = "UPDATE Tour_HDV SET ma_hdv = ? WHERE ma_tour = ? AND ma_hdv = ?";

        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newMaHDV);
            stmt.setString(2, maTour);
            stmt.setString(3, oldMaHDV);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật Tour-HDV", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ArrayList<TourHDV> searchTourHDV(String keyword) {
        ArrayList<TourHDV> list = new ArrayList<>();
        String sql = "SELECT * FROM Tour_HDV WHERE ma_tour LIKE ? OR ma_hdv LIKE ?";

        try (Connection conn = DAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Cài đặt từ khóa tìm kiếm cho cả ma_tour và ma_hdv
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");

            // Thực thi truy vấn
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maTour = rs.getString("ma_tour");
                String maHdv = rs.getString("ma_hdv");
                list.add(new TourHDV(maTour, maHdv)); // Thêm đối tượng TourHDV vào danh sách
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
