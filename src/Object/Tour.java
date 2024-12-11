/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author MYLAP.VN
 */
import Control.DAO_Queries;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tour {
    private String maTour;
    private String tenTour;
    private double gia;
    private LocalDate ngayBd; // Sử dụng LocalDate
    private LocalDate ngayKt; // Sử dụng LocalDate

    public Tour(Object[] dataRow) {
        this.maTour = dataRow[0].toString();
        this.tenTour = dataRow[1].toString();
        this.gia = dataRow[2] != null ? Double.parseDouble(dataRow[2].toString()) : 0;
        // Kiểm tra dữ liệu ngày hợp lệ trước khi chuyển
        this.ngayBd = dataRow[3] != null ? LocalDate.parse(dataRow[3].toString()) : null;
        this.ngayKt = dataRow[4] != null ? LocalDate.parse(dataRow[4].toString()) : null;
    }
    
    // Phương thức select tất cả các TourModel
    public static ArrayList<Tour> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<Tour> tourModels = new ArrayList<>();
        for (Object[] dataRow : results) {
            tourModels.add(new Tour(dataRow));
        }
        return tourModels;
    }

    // Phương thức select theo khóa (ID)
    public static Tour selectByKey(String id) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_BY_KEY, id);
        if (!results.isEmpty()) {
            return new Tour(results.get(0));
        }
        return null;
    }
    
    public static ArrayList<Tour> selectLikeKey(String keyword) {
    ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE, "%" + keyword + "%", "%" + keyword + "%");
    ArrayList<Tour> tours = new ArrayList<>();

    for (Object[] dataRow : results) {
        tours.add(new Tour(dataRow)); // Tạo đối tượng Tour từ kết quả
    }

    return tours;
}


    // Phương thức insert
    public static int insert(Tour tourModel) {
        return DAO_Queries.Update(QUERY_INSERT, tourModel.maTour, tourModel.tenTour, tourModel.gia, tourModel.ngayBd, tourModel.ngayKt);
    }

    // Phương thức update
    public static int update(Tour tourModel) {
        return DAO_Queries.Update(QUERY_UPDATE_BY_KEY, tourModel.tenTour, tourModel.gia, tourModel.ngayBd, tourModel.ngayKt, tourModel.maTour);
    }

    // Phương thức delete
    public static int delete(String id) {
        return DAO_Queries.Update(QUERY_DELETE_BY_KEY, id);
    }

    public static final String TABLE = "Tour";
    public static final String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static final String QUERY_SELECT_BY_KEY = "SELECT * FROM " + TABLE + " WHERE ma_tour = ?";
    public static final String QUERY_INSERT = "INSERT INTO " + TABLE + " (ma_tour, ten_tour, gia, ngay_bd, ngay_kt) VALUES (?, ?, ?, ?, ?)";
    public static final String QUERY_UPDATE_BY_KEY = "UPDATE " + TABLE + " SET ten_tour = ?, gia = ?, ngay_bd = ?, ngay_kt = ? WHERE ma_tour = ?";
    public static final String QUERY_DELETE_BY_KEY = "DELETE FROM " + TABLE + " WHERE ma_tour = ?";
    public static final String QUERY_SELECT_LIKE = "SELECT * FROM " + TABLE + " WHERE ten_tour LIKE ? OR ma_tour LIKE ?";
    
    // Constructor
    public Tour(String maTour, String tenTour, double gia, LocalDate ngayBd, LocalDate ngayKt) {
        this.maTour = maTour;
        this.tenTour = tenTour;
        this.gia = gia;
        this.ngayBd = ngayBd;
        this.ngayKt = ngayKt;
    }
    
    public Tour(){}

    // Getters and Setters
    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public LocalDate getNgayBd() {
        return ngayBd;
    }

    public void setNgayBd(LocalDate ngayBd) {
        this.ngayBd = ngayBd;
    }

    public LocalDate getNgayKt() {
        return ngayKt;
    }

    public void setNgayKt(LocalDate ngayKt) {
        this.ngayKt = ngayKt;
    }
    
    @Override
    public String toString() {
        return "Tour{" +
                "maTour='" + maTour + '\'' +
                ", tenTour='" + tenTour + '\'' +
                ", gia=" + gia +
                ", ngayBd=" + ngayBd +
                ", ngayKt=" + ngayKt +
                '}';
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    

}

