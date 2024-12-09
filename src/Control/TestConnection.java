package Control;
import Control.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // Gọi phương thức getConnection từ class DAO
        Connection conn = DAO.getConnection();

        // Kiểm tra kết nối
        if (conn != null) {
            System.out.println("Kết nối thành công!");

            // Câu lệnh SQL truy vấn
            String sql = "SELECT * FROM HuongDanVien";

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                // Duyệt qua kết quả trả về
                while (rs.next()) {
                    // Lấy dữ liệu từ ResultSet
                    String ten = rs.getString("full_name"); // Giả sử có cột "Ten" trong bảng HuongDanVien
                    String email = rs.getString("cccd"); // Giả sử có cột "Email"
                    String soDienThoai = rs.getString("email"); // Giả sử có cột "SoDienThoai"
                    String pass = rs.getString("pass_word");
                    // In ra dữ liệu
                    System.out.println("Tên: " + ten + ", Email: " + email + ", Số điện thoại: " + soDienThoai +",pass: " + pass);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Lỗi khi truy vấn dữ liệu.");
            }

            DAO.closeConnection(conn); // Đóng kết nối sau khi dùng xong
        } else {
            System.out.println("Kết nối thất bại!");
        }
    }
}
