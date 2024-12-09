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

public class DatTour {
    private String maDatTour;
    private String matour;
    private String makhachHang;
    private LocalDate ngayDat; 
    private int soLuongNguoi;
    private double tongTien;

    // Constructor
    public DatTour(){}
    public DatTour(String maDatTour, String matour, String makhachHang, LocalDate ngayDat, int soLuongNguoi, double tongTien) {
        this.maDatTour = maDatTour;
        this.matour = matour;
        this.makhachHang = makhachHang;
        this.ngayDat = ngayDat;
        this.soLuongNguoi = soLuongNguoi;
        this.tongTien = tongTien;
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
}

