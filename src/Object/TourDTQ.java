package Object;

import Control.DAO_Queries;
import java.util.ArrayList;

public class TourDTQ {
    private String maTour;
    private String maDiemThamQuan;

    // Constructor mặc định
    public TourDTQ() {}

    // Constructor đầy đủ
    public TourDTQ(String maTour, String maDiemThamQuan) {
        this.maTour = maTour;
        this.maDiemThamQuan = maDiemThamQuan;
    }

    // Constructor từ Object[]
    public TourDTQ(Object[] dataRow) {
        this.maTour = dataRow[0].toString();
        this.maDiemThamQuan = dataRow[1].toString();
    }

    // Getters và Setters
    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getMaDiemThamQuan() {
        return maDiemThamQuan;
    }

    public void setMaDiemThamQuan(String maDiemThamQuan) {
        this.maDiemThamQuan = maDiemThamQuan;
    }

    // Phương thức select tất cả các bản ghi
    public static ArrayList<TourDTQ> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<TourDTQ> tourDTQs = new ArrayList<>();
        for (Object[] dataRow : results) {
            tourDTQs.add(new TourDTQ(dataRow));
        }
        return tourDTQs;
    }

    // Phương thức select theo mã tour
    public static ArrayList<TourDTQ> selectByMaTour(String maTour) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_BY_TOUR, maTour);
        ArrayList<TourDTQ> tourDTQs = new ArrayList<>();
        for (Object[] dataRow : results) {
            tourDTQs.add(new TourDTQ(dataRow));
        }
        return tourDTQs;
    }
    
    public static ArrayList<TourDTQ> selectLikeKey(String keyword) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE, "%" + keyword + "%", "%" + keyword + "%");
        ArrayList<TourDTQ> tourDTQs = new ArrayList<>();
        for (Object[] dataRow : results) {
            tourDTQs.add(new TourDTQ(dataRow));
        }
        return tourDTQs;
    }

    public static int insert(TourDTQ tourDTQ) {
        return DAO_Queries.Update(QUERY_INSERT, tourDTQ.maTour, tourDTQ.maDiemThamQuan);
    }

    // Phương thức cập nhật
    public static int update(String matour, String madiemthamquan, String newmadiemthamquan) {
        return DAO_Queries.Update(QUERY_UPDATE_BY_TOUR,newmadiemthamquan , matour , madiemthamquan);
    }

    // Phương thức xóa
    public static int delete(String maTour, String maDiemThamQuan) {
        return DAO_Queries.Update(QUERY_DELETE, maTour, maDiemThamQuan);
    }

    // Các câu truy vấn SQL
     public static final String TABLE = "Tour_DiemThamQuan";
    public static final String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static final String QUERY_SELECT_BY_TOUR = "SELECT * FROM " + TABLE + " WHERE ma_tour = ? AND ma_diem_tham_quan = ?";
    public static final String QUERY_INSERT = "INSERT INTO " + TABLE + " (ma_tour, ma_diem_tham_quan) VALUES (?, ?)";
    public static final String QUERY_UPDATE_BY_TOUR = "UPDATE " + TABLE + " SET ma_diem_tham_quan = ? WHERE ma_tour = ? AND ma_diem_tham_quan =?";
    public static final String QUERY_DELETE = "DELETE FROM " + TABLE + " WHERE ma_tour = ? AND ma_diem_tham_quan = ?";
    public static final String QUERY_SELECT_LIKE = "SELECT * FROM " + TABLE + " WHERE ma_tour LIKE ? OR ma_diem_tham_quan LIKE ?";
}
