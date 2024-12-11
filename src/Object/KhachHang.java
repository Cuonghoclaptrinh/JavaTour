/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import Control.DAO_Queries;
import java.util.ArrayList;

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
    

        // Constructor từ Object[]
    public KhachHang(Object[] dataRow) {
        this.maKh = dataRow[0].toString();
        this.tenKh = dataRow[1].toString();
        this.sdt = dataRow[2].toString();
        this.cccd = dataRow[3].toString();
        this.diaChi = dataRow[4].toString();
    }

    // Constructor đầy đủ
    public KhachHang(String maKh, String tenKh, String sdt, String cccd, String diaChi) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.cccd = cccd;
        this.diaChi = diaChi;
    }

    public KhachHang() {}

    // Phương thức select tất cả khách hàng
    public static ArrayList<KhachHang> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        for (Object[] dataRow : results) {
            khachHangs.add(new KhachHang(dataRow));
        }
        return khachHangs;
    }

    // Phương thức select theo mã khách hàng
    public static KhachHang selectByKey(String id) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_BY_KEY, id);
        if (!results.isEmpty()) {
            return new KhachHang(results.get(0));
        }
        return null;
    }

    // Phương thức select theo từ khóa
    public static ArrayList<KhachHang> selectLikeKey(String keyword) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE, "%" + keyword + "%", "%" + keyword + "%");
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        for (Object[] dataRow : results) {
            khachHangs.add(new KhachHang(dataRow));
        }
        return khachHangs;
    }

    // Phương thức thêm khách hàng
    public static int insert(KhachHang kh) {
        return DAO_Queries.Update(QUERY_INSERT, kh.maKh, kh.tenKh, kh.sdt, kh.cccd, kh.diaChi);
    }

    // Phương thức cập nhật thông tin khách hàng
    public static int update(KhachHang kh) {
        return DAO_Queries.Update(QUERY_UPDATE_BY_KEY, kh.tenKh, kh.sdt, kh.cccd, kh.diaChi, kh.maKh);
    }

    // Phương thức xóa khách hàng
    public static int delete(String id) {
        return DAO_Queries.Update(QUERY_DELETE_BY_KEY, id);
    }

    // Câu truy vấn SQL
    public static final String TABLE = "KhachHang";
    public static final String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static final String QUERY_SELECT_BY_KEY = "SELECT * FROM " + TABLE + " WHERE ma_kh = ?";
    public static final String QUERY_INSERT = "INSERT INTO " + TABLE + " (ma_kh, ten_kh, sdt, cccd, dia_chi) VALUES (?, ?, ?, ?, ?)";
    public static final String QUERY_UPDATE_BY_KEY = "UPDATE " + TABLE + " SET ten_kh = ?, sdt = ?, cccd = ?, dia_chi = ? WHERE ma_kh = ?";
    public static final String QUERY_DELETE_BY_KEY = "DELETE FROM " + TABLE + " WHERE ma_kh = ?";
    public static final String QUERY_SELECT_LIKE = "SELECT * FROM " + TABLE + " WHERE ma_kh LIKE ? OR ten_kh LIKE ?";



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

