/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author MYLAP.VN
 */
import java.time.LocalDate;

public class ThanhToan {
    private String maThanhToan;
    private String madatTour;
    private LocalDate ngayThanhToan;
    private String hinhThuc;
    private double tongTien;

    // Constructor
    public ThanhToan(String maThanhToan, String madatTour, LocalDate ngayThanhToan, String hinhThuc, double tongTien) {
        this.maThanhToan = maThanhToan;
        this.madatTour = madatTour;
        this.ngayThanhToan = ngayThanhToan;
        this.hinhThuc = hinhThuc;
        this.tongTien = tongTien;
    }

    // Getters and Setters
    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getDatTour() {
        return madatTour;
    }

    public void setDatTour(String madatTour) {
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
}


//Chuyển từ SQL DATE sang LocalDate:LocalDate ngayBd = resultSet.getDate("ngay_bd").toLocalDate();
//Chuyển từ LocalDate sang SQL DATE:preparedStatement.setDate(1, java.sql.Date.valueOf(ngayBd));


