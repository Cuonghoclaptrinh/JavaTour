/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

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
    
    public NhanVien(String id,String fullname, String cccd, String email, String password, String chucvu) {
        this.id = id;
        this.fullname = fullname;
        this.cccd = cccd;
        this.email = email;
        this.password = password;
        this.chucvu = chucvu;
    }

   public NhanVien(){
   }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
