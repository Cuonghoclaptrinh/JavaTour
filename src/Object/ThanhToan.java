package Object;

import java.time.LocalDate;
import java.util.ArrayList;
import Control.DAO_Queries;

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
    public static String QUERY_SELECT_LIKE_KEY = 
        "SELECT * FROM " + TABLE + " WHERE ma_thanh_toan LIKE ? OR ma_dat_tour LIKE ? OR hinh_thuc LIKE ?";

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
}
