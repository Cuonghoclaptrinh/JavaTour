/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author MYLAP.VN
 */
import Control.DAO;
import java.time.LocalDate;
import java.util.ArrayList;
import Control.DAO_Queries;
import java.time.ZoneId;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class DatTour {
    private String maDatTour;
    private String matour;
    private String makhachHang;
    private LocalDate ngayDat; 
    private int soLuongNguoi;
    private double tongTien;
    private String trangThai;
    
    // Constructor
    public DatTour(){}
// Constructor using dataRow (Array of Objects)
 public DatTour(Object[] dataRow) {
        maDatTour = dataRow[0].toString();
        matour = dataRow[1].toString();
        makhachHang = dataRow[2].toString();
        if (dataRow[3] instanceof java.sql.Date) {
        java.sql.Date sqlDate = (java.sql.Date) dataRow[3];
        // Chuyển từ java.sql.Date sang LocalDate
        ngayDat = sqlDate.toLocalDate();  // Sử dụng toLocalDate() thay vì toInstant()
    }
        soLuongNguoi = dataRow[4] != null ? (int) dataRow[4] : 0;
        if (dataRow[5] instanceof java.math.BigDecimal) {
        tongTien = ((java.math.BigDecimal) dataRow[5]).doubleValue();
    } else {
        tongTien = dataRow[5] != null ? (double) dataRow[5] : 0.0;
    }
        trangThai = dataRow[6].toString();
    }
    // Constructor using individual parameters
    public DatTour(String maDatTour, String maTour, String maKh, LocalDate ngayDat, int soLuongNguoi, double tongTien, String trangThai) {
        this.maDatTour = maDatTour;
        this.matour = maTour;
        this.makhachHang = maKh;
        this.ngayDat = ngayDat;
        this.soLuongNguoi = soLuongNguoi;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public static ArrayList<DatTour> selectAll() {
    ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);

    ArrayList<DatTour> datTourModels = new ArrayList<>();

    for (Object[] dataRow : results) {
        datTourModels.add(new DatTour(dataRow));
    }
    return datTourModels;
}

    public static ArrayList<DatTour> selectLikeKey(String keyword) {
    ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE_KEY, "%" + keyword + "%" , "%" + keyword + "%","%" + keyword + "%");

    ArrayList<DatTour> datTourModels = new ArrayList<>();

    for (Object[] dataRow : results) {
        datTourModels.add(new DatTour(dataRow));
    }
    return datTourModels;
}



    // Getters and Setters
    public String getMaDatTour() {
        return maDatTour;
    }

    public void setMaDatTour(String maDatTour) {
        this.maDatTour = maDatTour;
    }

    public String getMaTour() {
        return matour;
    }

    public void setMaTour(String matour) {
        this.matour = matour;
    }

    public String getMaKhachHang() {
        return makhachHang;
    }

    public void setMaKhachHang(String makhachHang) {
        this.makhachHang = makhachHang;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
        
    public static String TABLE = "DatTour";
    
    public static String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static String QUERY_SELECT_LIKE_KEY = "SELECT * FROM " + TABLE + " WHERE ma_dat_tour LIKE ? OR ma_tour LIKE ? OR ma_kh LIKE ? ";
   

    
    @Override
public String toString() {
    return "DatTour{" +
            "maDatTour='" + maDatTour + '\'' +
            ", matour='" + matour + '\'' +
            ", makhachHang='" + makhachHang + '\'' +
            ", ngayDat=" + ngayDat +
            ", soLuongNguoi=" + soLuongNguoi +
            ", tongTien=" + tongTien +
            '}';
}

public static ArrayList<String> getTourInfoList(String maDatTour) {
        ArrayList<String> tourInfoList = new ArrayList<>();
        String query = """
                SELECT  
                       kh.dia_chi AS diaChi, 
                       kh.cccd, 
                       t.gia
                       
                FROM DatTour dt
                JOIN KhachHang kh ON dt.ma_kh = kh.ma_kh
                JOIN Tour t ON dt.ma_tour = t.ma_tour
                LEFT JOIN ThanhToan tt ON dt.ma_dat_tour = tt.ma_dat_tour
                WHERE dt.ma_dat_tour = ?;
                """;

        try (Connection connection = DAO.getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            // Set giá trị cho tham số maDatTour
            stmt.setString(1, maDatTour);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    String diaChi = rs.getString("diaChi");
                    String cccd = rs.getString("cccd");
                    double gia = rs.getDouble("gia");
                    

                    // Gộp thông tin thành một chuỗi và thêm vào danh sách
                    String info = String.format(" Địa chỉ: %s, CCCD: %s, Giá: %.2f, ",
                                                diaChi, cccd, gia);
                    tourInfoList.add(info);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tourInfoList;
    }

}

