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

public class Tour {
    private String maTour;
    private String tenTour;
    private double gia;
    private LocalDate ngayBd; // Sử dụng LocalDate
    private LocalDate ngayKt; // Sử dụng LocalDate

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

