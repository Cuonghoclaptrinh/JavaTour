package Object;

import Control.DAO_Queries;
import java.util.ArrayList;

public class TourHDV {
    private String maTour;
    private String maHDV;

    // Constructor mặc định
    public TourHDV() {}

    // Constructor đầy đủ
    public TourHDV(String maTour, String maHDV) {
        this.maTour = maTour;
        this.maHDV = maHDV;
    }

    // Constructor từ Object[]
    public TourHDV(Object[] dataRow) {
        this.maTour = dataRow[0].toString();
        this.maHDV = dataRow[1].toString();
    }

    // Getters và Setters
    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getMaHDV() {
        return maHDV;
    }

    public void setMaHDV(String maHDV) {
        this.maHDV = maHDV;
    }

    // Phương thức select tất cả các bản ghi
    public static ArrayList<TourHDV> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<TourHDV> tourHDVs = new ArrayList<>();
        for (Object[] dataRow : results) {
            tourHDVs.add(new TourHDV(dataRow));
        }
        return tourHDVs;
    }

    // Phương thức select theo mã tour
    public static ArrayList<TourHDV> selectByMaTour(String maTour) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_BY_TOUR, maTour);
        ArrayList<TourHDV> tourHDVs = new ArrayList<>();
        for (Object[] dataRow : results) {
            tourHDVs.add(new TourHDV(dataRow));
        }
        return tourHDVs;
    }

    // Phương thức tìm kiếm theo từ khóa
    public static ArrayList<TourHDV> selectLikeKey(String keyword) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE, "%" + keyword + "%", "%" + keyword + "%");
        ArrayList<TourHDV> tourHDVs = new ArrayList<>();
        for (Object[] dataRow : results) {
            tourHDVs.add(new TourHDV(dataRow));
        }
        return tourHDVs;
    }

    // Phương thức thêm mới một bản ghi
    public static int insert(TourHDV tourHDV) {
        return DAO_Queries.Update(QUERY_INSERT, tourHDV.maTour, tourHDV.maHDV);
    }

    // Phương thức cập nhật thông tin
    public static int update(String maTour, String maHDV, String newMaHDV) {
        return DAO_Queries.Update(QUERY_UPDATE_BY_TOUR, newMaHDV, maTour, maHDV);
    }

    // Phương thức xóa một bản ghi
    public static int delete(String maTour, String maHDV) {
        return DAO_Queries.Update(QUERY_DELETE, maTour, maHDV);
    }

    // Các câu truy vấn SQL
    public static final String TABLE = "Tour_HDV";
    public static final String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static final String QUERY_SELECT_BY_TOUR = "SELECT * FROM " + TABLE + " WHERE ma_tour = ?";
    public static final String QUERY_INSERT = "INSERT INTO " + TABLE + " (ma_tour, ma_hdv) VALUES (?, ?)";
    public static final String QUERY_UPDATE_BY_TOUR = "UPDATE " + TABLE + " SET ma_hdv = ? WHERE ma_tour = ? AND ma_hdv = ?";
    public static final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE ma_tour = ? AND ma_hdv = ?";
    public static final String QUERY_SELECT_LIKE = "SELECT * FROM " + TABLE + " WHERE ma_tour LIKE ? OR ma_hdv LIKE ?";
}
