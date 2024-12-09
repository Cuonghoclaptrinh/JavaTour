/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author MYLAP.VN
 */
public class KhachHang {
    private String maKh;
    private String tenKh;
    private String sdt;
    private String cccd;
    private String diaChi;
    

    // Constructor
    public KhachHang(String maKh, String tenKh ,String sdt, String cccd, String diaChi ) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.cccd = cccd;
        this.diaChi = diaChi;
    }

    // Getters and Setters
    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}

