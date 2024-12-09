/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author MYLAP.VN
 */
public class DiemThamQuan {
    private String maDiemThamQuan;
    private String tenDiaDiem;
    private String diaChi;

    // Constructor
    public DiemThamQuan(String maDiemThamQuan, String tenDiaDiem, String diaChi) {
        this.maDiemThamQuan = maDiemThamQuan;
        this.tenDiaDiem = tenDiaDiem;
        this.diaChi = diaChi;
    }

    // Getters and Setters
    public String getMaDiemThamQuan() {
        return maDiemThamQuan;
    }

    public void setMaDiemThamQuan(String maDiemThamQuan) {
        this.maDiemThamQuan = maDiemThamQuan;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
