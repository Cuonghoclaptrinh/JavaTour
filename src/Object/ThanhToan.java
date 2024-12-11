package Object;

import Control.DAO;
import java.time.LocalDate;
import java.util.ArrayList;
import Control.DAO_Queries;
import java.sql.*;

public class ThanhToan {
    private String maThanhToan;
    private String madatTour;
    private LocalDate ngayThanhToan;
    private String hinhThuc;
    private double tongTien;

    // Constructor mặc định
    public ThanhToan() {}

    // Constructor đầy đủ
    public ThanhToan(String maThanhToan, String madatTour, LocalDate ngayThanhToan, String hinhThuc, double tongTien) {
        this.maThanhToan = maThanhToan;
        this.madatTour = madatTour;
        this.ngayThanhToan = ngayThanhToan;
        this.hinhThuc = hinhThuc;
        this.tongTien = tongTien;
    }

    // Constructor sử dụng từ dataRow
    public ThanhToan(Object[] dataRow) {
        this.maThanhToan = dataRow[0].toString();
        this.madatTour = dataRow[1].toString();
        if (dataRow[2] instanceof java.sql.Date) {
            java.sql.Date sqlDate = (java.sql.Date) dataRow[2];
            this.ngayThanhToan = sqlDate.toLocalDate();
        }
        this.hinhThuc = dataRow[3].toString();
        if (dataRow[4] instanceof java.math.BigDecimal) {
            this.tongTien = ((java.math.BigDecimal) dataRow[4]).doubleValue();
        } else {
            this.tongTien = dataRow[4] != null ? (double) dataRow[4] : 0.0;
        }
    }

    // Phương thức lấy tất cả dữ liệu
    public static ArrayList<ThanhToan> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<ThanhToan> thanhToanList = new ArrayList<>();
        for (Object[] dataRow : results) {
            thanhToanList.add(new ThanhToan(dataRow));
        }
        return thanhToanList;
    }

    // Phương thức tìm kiếm theo từ khóa
    public static ArrayList<ThanhToan> selectLikeKey(String keyword) {
        ArrayList<Object[]> results = DAO_Queries.Select(
            QUERY_SELECT_LIKE_KEY, 
            "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%"
        );
        ArrayList<ThanhToan> thanhToanList = new ArrayList<>();
        for (Object[] dataRow : results) {
            thanhToanList.add(new ThanhToan(dataRow));
        }
        return thanhToanList;
    }
    
    public static int insert(ThanhToan tt) {
        return DAO_Queries.Update(QUERY_INSERT, tt.maThanhToan, tt.madatTour ,tt.ngayThanhToan , tt.hinhThuc , tt.tongTien);
    }

    // Getters and Setters
    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getMadatTour() {
        return madatTour;
    }

    public void setMadatTour(String madatTour) {
        this.madatTour = madatTour;
    }

    public LocalDate getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDate ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    // Các câu truy vấn
    public static String TABLE = "ThanhToan";
    public static String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static String QUERY_INSERT = "INSERT INTO ThanhToan(ma_thanh_toan, ma_dat_tour, ngay_thanh_toan, hinh_thuc, tong_tien) VALUES (?, ?, ?, ?, ?)";
    public static String QUERY_SELECT_LIKE_KEY ="SELECT * FROM " + TABLE + " WHERE ma_thanh_toan LIKE ? OR ma_dat_tour LIKE ? OR hinh_thuc LIKE ?";
    

    // toString để kiểm tra
    @Override
    public String toString() {
        return "ThanhToan{" +
                "maThanhToan='" + maThanhToan + '\'' +
                ", madatTour='" + madatTour + '\'' +
                ", ngayThanhToan=" + ngayThanhToan +
                ", hinhThuc='" + hinhThuc + '\'' +
                ", tongTien=" + tongTien +
                '}';
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
}
