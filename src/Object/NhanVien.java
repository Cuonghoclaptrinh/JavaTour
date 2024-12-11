package Object;

import Control.DAO_Queries;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class NhanVien {
    private String id;
    private String fullname;
    private String cccd;
    private String email;
    private String password;
    private String chucvu;

    // Constructor từ Object[]
    public NhanVien(Object[] dataRow) {
        this.id = dataRow[0].toString();
        this.fullname = dataRow[1].toString();
        this.cccd = dataRow[2].toString();
        this.email = dataRow[3].toString();
        this.password = dataRow[4].toString();
        this.chucvu = dataRow[5].toString();
    }

    // Constructor đầy đủ
    public NhanVien(String id, String fullname, String cccd, String email, String password, String chucvu) {
        this.id = id;
        this.fullname = fullname;
        this.cccd = cccd;
        this.email = email;
        this.password = password;
        this.chucvu = chucvu;
    }

    public NhanVien() {}

    // Phương thức select tất cả nhân viên
    public static ArrayList<NhanVien> selectAll() {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_ALL);
        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        for (Object[] dataRow : results) {
            nhanViens.add(new NhanVien(dataRow));
        }
        return nhanViens;
    }

    // Phương thức select theo mã nhân viên
    public static NhanVien selectByKey(String id) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_BY_KEY, id);
        if (!results.isEmpty()) {
            return new NhanVien(results.get(0));
        }
        return null;
    }

    // Phương thức select theo từ khóa
    public static ArrayList<NhanVien> selectLikeKey(String keyword) {
        ArrayList<Object[]> results = DAO_Queries.Select(QUERY_SELECT_LIKE, "%" + keyword + "%", "%" + keyword + "%");
        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        for (Object[] dataRow : results) {
            nhanViens.add(new NhanVien(dataRow));
        }
        return nhanViens;
    }

    // Phương thức thêm nhân viên
    public static int insert(NhanVien nv) {
        return DAO_Queries.Update(QUERY_INSERT, nv.id, nv.fullname, nv.cccd, nv.email, nv.password, nv.chucvu);
    }

    // Phương thức cập nhật thông tin nhân viên
    public static int update(NhanVien nv) {
        return DAO_Queries.Update(QUERY_UPDATE_BY_KEY, nv.fullname, nv.cccd, nv.email, nv.chucvu, nv.id);
    }

    // Phương thức xóa nhân viên
    public static int delete(String id) {
        return DAO_Queries.Update(QUERY_DELETE_BY_KEY, id);
    }

    // Câu truy vấn SQL
    public static final String TABLE = "NhanVien";
    public static final String QUERY_SELECT_ALL = "SELECT * FROM " + TABLE;
    public static final String QUERY_SELECT_BY_KEY = "SELECT * FROM " + TABLE + " WHERE id = ?";
    public static final String QUERY_INSERT = "INSERT INTO " + TABLE + " (id, full_name, cccd, email,pass_word, chuc_vu) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String QUERY_UPDATE_BY_KEY = "UPDATE " + TABLE + " SET full_name = ?, cccd = ?, email = ?, chuc_vu = ? WHERE id = ?";
    public static final String QUERY_DELETE_BY_KEY = "DELETE FROM " + TABLE + " WHERE id = ?";
    public static final String QUERY_SELECT_LIKE = "SELECT * FROM " + TABLE + " WHERE full_name LIKE ? OR email LIKE ?";

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
    
