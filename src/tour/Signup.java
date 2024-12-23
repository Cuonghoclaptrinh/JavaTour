/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tour;

import Control.DAO;
import Object.NhanVien;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MYLAP.VN
 */
public class Signup extends javax.swing.JPanel {

    /**
     * Creates new form Signup
     */
    private MainFrm mainFrm; 
    public Signup(MainFrm mainFrm) {
        this.mainFrm = mainFrm; // Lưu tham chiếu đến MainFrm
        initComponents();
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        can_cuoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailaddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        signupbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 590));

        jPanel4.setPreferredSize(new java.awt.Dimension(800, 590));
        jPanel4.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(32, 86, 108));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 590));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.jpg"))); // NOI18N
        jLabel1.setText("DNC");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Welcom to DNC's Travel Agency System");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(71, 71, 71))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5);
        jPanel5.setBounds(0, 0, 400, 590);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 590));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 86, 108));
        jLabel3.setText("SIGN UP");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Họ Và Tên");

        fname.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fname.setForeground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Căn Cước Công Dân");

        can_cuoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        can_cuoc.setForeground(new java.awt.Color(102, 102, 102));
        can_cuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                can_cuocActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Email");

        emailaddress.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailaddress.setForeground(new java.awt.Color(102, 102, 102));
        emailaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailaddressActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Mật Khẩu");

        pass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pass.setForeground(new java.awt.Color(102, 102, 102));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        signupbtn.setBackground(new java.awt.Color(32, 86, 108));
        signupbtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        signupbtn.setForeground(new java.awt.Color(255, 255, 255));
        signupbtn.setText("Đăng Ký");
        signupbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("I've an account ");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 51, 51));
        btnLogin.setText("Đăng Nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fname, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(can_cuoc, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(emailaddress)
                            .addComponent(pass)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4)
                                    .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLogin)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(can_cuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emailaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailaddressActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        
        String id,fullname1, email1, password1, cccd1;
    try {
        // Kết nối với cơ sở dữ liệu
        Connection con = DAO.getConnection();

        // Kiểm tra trường nhập liệu
        if (fname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ tên là bắt buộc", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (emailaddress.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email là bắt buộc", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isValidEmailAddress(emailaddress.getText())) {
            JOptionPane.showMessageDialog(this, "Định dạng email không hợp lệ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (pass.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Mật khẩu là bắt buộc", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Gán dữ liệu
        id="";
        fullname1 = fname.getText();
        email1 = emailaddress.getText();
        cccd1 = can_cuoc.getText();
        password1 = new String(pass.getPassword()); // Lấy mật khẩu từ JPasswordField
        String defaultRole = "Nhân Viên"; // Vai trò mặc định

        // Kiểm tra xem email đã tồn tại trong bảng NhanVien
        String emailCheckQuery = "SELECT email FROM NhanVien WHERE email = ?";

        PreparedStatement emailCheckStmt = con.prepareStatement(emailCheckQuery);
        emailCheckStmt.setString(1, email1);
        ResultSet rs = emailCheckStmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Tài khoản với email này đã tồn tại", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
//            // Chèn người dùng mới vào bảng NhanVien với vai trò mặc định là "Nhân Viên"
//            String insertQuery = "INSERT INTO NhanVien(full_name, cccd, email, pass_word, chuc_vu) VALUES (?, ?, ?, ?, ?)";
//
//            PreparedStatement insertStmt = con.prepareStatement(insertQuery);
//            insertStmt.setString(1, fullname1);
//            insertStmt.setString(2, cccd1);
//            insertStmt.setString(3, email1);
//            insertStmt.setString(4, password1);
//            insertStmt.setString(5, defaultRole); // Vai trò mặc định là "Nhân Viên"
//
//            // Thực thi truy vấn
//            insertStmt.executeUpdate();
//            
            NhanVien nv=new NhanVien(id, fullname1, cccd1, email1, password1, defaultRole);
            NhanVien.insert(nv);
            
            // Xóa các trường nhập
            fname.setText("");
            emailaddress.setText("");
            pass.setText("");
            can_cuoc.setText("");

            JOptionPane.showMessageDialog(this, "Tài khoản mới đã được tạo thành công!");

            // Chuyển về trang đăng nhập
            btnLoginActionPerformed(null);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi cơ sở dữ liệu: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_signupbtnActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        javax.swing.JFrame frame = new javax.swing.JFrame("Login Form");
        frame.setContentPane(new Login(mainFrm)); // Truyền MainFrm vào Login
        frame.setSize(800, 500); // Kích thước mong muốn cho form
        frame.setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Đóng cửa sổ mà không ảnh hưởng đến MainFrm

        // Thêm WindowListener để hiển thị lại MainFrm khi đóng Login
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                mainFrm.setVisible(true); // Hiển thị lại MainFrm
            }
        });
        frame.setVisible(true); // Hiển thị form đăng nhập

        // Ẩn JFrame hiện tại (Signup)
        javax.swing.SwingUtilities.getWindowAncestor(this).setVisible(false);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void can_cuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_can_cuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_can_cuocActionPerformed

    private boolean isValidEmailAddress(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField can_cuoc;
    private javax.swing.JTextField emailaddress;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton signupbtn;
    // End of variables declaration//GEN-END:variables
}
