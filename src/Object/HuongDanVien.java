/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author MYLAP.VN
 */
public class HuongDanVien {
    private String maHdv;
    private String cccd;
    private String fullname;
    private String sdt;
    private String diachi;

    // Constructor
    public HuongDanVien(String maHdv, String fullname,String cccd, String sdt, String diachi) {
        this.maHdv = maHdv;
        this.cccd = cccd;
        this.fullname = fullname;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public HuongDanVien(){}

    // Getters and Setters
    public String getMaHdv() {
        return maHdv;
    }

    public void setMaHdv(String maHdv) {
        this.maHdv = maHdv;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
     public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
     public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}

