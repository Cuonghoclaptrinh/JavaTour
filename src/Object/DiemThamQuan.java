package Object;

import Control.DAO_Queries;
import java.util.ArrayList;

public class DiemThamQuan {
    private String maDiemThamQuan;
    private String tenDiaDiem;
    private String diaChi;

    // Constructor sử dụng mảng Object[] từ dữ liệu trả về
    public DiemThamQuan(Object[] dataRow) {
        this.maDiemThamQuan = dataRow[0].toString();
        this.tenDiaDiem = dataRow[1].toString();
        this.diaChi = dataRow[2].toString();
    }

    // Constructor
    public DiemThamQuan(String maDiemThamQuan, String tenDiaDiem, String diaChi) {
        this.maDiemThamQuan = maDiemThamQuan;
        this.tenDiaDiem = tenDiaDiem;
        this.diaChi = diaChi;
    }

    // Constructor mặc định
    public DiemThamQuan() {}

    // Phương thức select tất cả các DiemThamQuan
    public static ArrayList<DiemThamQuan> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<DiemThamQuan> diemThamQuanList = new ArrayList<>();
        for (Object[] dataRow : results) {
            diemThamQuanList.add(new DiemThamQuan(dataRow));
        }
        return diemThamQuanList;
    }

    // Phương thức select theo khóa (ID)
    public static DiemThamQuan selectByKey(String id) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_BY_KEY, id);
        if (!results.isEmpty()) {
            return new DiemThamQuan(results.get(0));
        }
        return null;
    }
    
    // Phương thức select theo từ khóa (tìm kiếm)
    public static ArrayList<DiemThamQuan> selectLikeKey(String keyword) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE, "%" + keyword + "%", "%" + keyword + "%");
        ArrayList<DiemThamQuan> diemThamQuanList = new ArrayList<>();

        for (Object[] dataRow : results) {
            diemThamQuanList.add(new DiemThamQuan(dataRow));
        }

        return diemThamQuanList;
    }

    // Phương thức insert
    public static int insert(DiemThamQuan diemThamQuan) {
        return DAO_Queries.Update(QUERY_INSERT, diemThamQuan.maDiemThamQuan, diemThamQuan.tenDiaDiem, diemThamQuan.diaChi);
    }

    // Phương thức update
    public static int update(DiemThamQuan diemThamQuan) {
        return DAO_Queries.Update(QUERY_UPDATE_BY_KEY, diemThamQuan.tenDiaDiem, diemThamQuan.diaChi, diemThamQuan.maDiemThamQuan);
    }

    // Phương thức delete
    public static int delete(String id) {
        return DAO_Queries.Update(QUERY_DELETE_BY_KEY, id);
    }

    // Các câu lệnh SQL
    public static final String TABLE = "DiemThamQuan";
    public static final String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static final String QUERY_SELECT_BY_KEY = "SELECT * FROM " + TABLE + " WHERE ma_diem_tham_quan = ?";
    public static final String QUERY_INSERT = "INSERT INTO " + TABLE + " (ma_diem_tham_quan, ten_dia_diem, dia_chi) VALUES (?, ?, ?)";
    public static final String QUERY_UPDATE_BY_KEY = "UPDATE " + TABLE + " SET ten_dia_diem = ?, dia_chi = ? WHERE ma_diem_tham_quan = ?";
    public static final String QUERY_DELETE_BY_KEY = "DELETE FROM " + TABLE + " WHERE ma_diem_tham_quan = ?";
    public static final String QUERY_SELECT_LIKE = "SELECT * FROM " + TABLE + " WHERE ten_dia_diem LIKE ? OR ma_diem_tham_quan LIKE ?";

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

    @Override
    public String toString() {
        return "DiemThamQuan{" +
                "maDiemThamQuan='" + maDiemThamQuan + '\'' +
                ", tenDiaDiem='" + tenDiaDiem + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
