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
public class HuongDanVien {
    private String maHdv;
    private String cccd;
    private String fullname;
    private String sdt;
    private String diachi;

    // Constructor
// Constructor với Object[] để chuyển đổi dữ liệu từ SQL
    public HuongDanVien(Object[] dataRow) {
        this.maHdv = dataRow[0].toString();
        this.fullname = dataRow[1].toString();
        this.cccd = dataRow[2].toString();
        this.sdt = dataRow[3].toString();
        this.diachi = dataRow[4].toString();
    }

    // Constructor đầy đủ
    public HuongDanVien(String maHdv, String fullname, String cccd, String sdt, String diachi) {
        this.maHdv = maHdv;
        this.fullname = fullname;
        this.cccd = cccd;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    // Constructor không tham số
    public HuongDanVien() {}

    // Getter và Setter
    public String getMaHdv() {
        return maHdv;
    }

    public void setMaHdv(String maHdv) {
        this.maHdv = maHdv;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    // Phương thức Select tất cả hướng dẫn viên
    public static ArrayList<HuongDanVien> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<HuongDanVien> huongDanViens = new ArrayList<>();
        for (Object[] dataRow : results) {
            huongDanViens.add(new HuongDanVien(dataRow));
        }
        return huongDanViens;
    }

    // Phương thức Select theo mã HDV
    public static HuongDanVien selectByKey(String id) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_BY_KEY, id);
        if (!results.isEmpty()) {
            return new HuongDanVien(results.get(0));
        }
        return null;
    }

    // Phương thức Select theo từ khóa
    public static ArrayList<HuongDanVien> selectLikeKey(String keyword) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE, "%" + keyword + "%", "%" + keyword + "%");
        ArrayList<HuongDanVien> huongDanViens = new ArrayList<>();
        for (Object[] dataRow : results) {
            huongDanViens.add(new HuongDanVien(dataRow));
        }
        return huongDanViens;
    }

    // Phương thức Insert
    public static int insert(HuongDanVien hdv) {
        return DAO_Queries.Update(QUERY_INSERT, hdv.maHdv, hdv.fullname, hdv.cccd, hdv.sdt, hdv.diachi);
    }

    // Phương thức Update
    public static int update(HuongDanVien hdv) {
        return DAO_Queries.Update(QUERY_UPDATE_BY_KEY, hdv.fullname, hdv.cccd, hdv.sdt, hdv.diachi, hdv.maHdv);
    }

    // Phương thức Delete
    public static int delete(String id) {
        return DAO_Queries.Update(QUERY_DELETE_BY_KEY, id);
    }

    // Các câu lệnh SQL
    public static final String TABLE = "HuongDanVien";
    public static final String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static final String QUERY_SELECT_BY_KEY = "SELECT * FROM " + TABLE + " WHERE ma_hdv = ?";
    public static final String QUERY_SELECT_LIKE = "SELECT * FROM " + TABLE + " WHERE full_name LIKE ? OR ma_hdv LIKE ?";
    public static final String QUERY_INSERT = "INSERT INTO " + TABLE + " (ma_hdv, full_name, cccd, sdt, diachi) VALUES (?, ?, ?, ?, ?)";
    public static final String QUERY_UPDATE_BY_KEY = "UPDATE " + TABLE + " SET full_name = ?, cccd = ?, sdt = ?, diachi = ? WHERE ma_hdv = ?";
    public static final String QUERY_DELETE_BY_KEY = "DELETE FROM " + TABLE + " WHERE ma_hdv = ?";

}

