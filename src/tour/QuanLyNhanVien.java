/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tour;

import Object.NhanVien;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MYLAP.VN
 */
public class QuanLyNhanVien extends javax.swing.JInternalFrame {

    DefaultTableModel model;

    public QuanLyNhanVien() throws SQLException {
        initComponents();
        model = (DefaultTableModel) TableNhanVien.getModel();
        loadData();

        TableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNhanVienMouseClicked(evt);
            }
        });

//        EnterNhanVien.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                EntertextActionPerformed(evt);
//            }
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame_nav = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_searchNV = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EnterNhanVien = new javax.swing.JTextPane();
        frame_tbdata = new javax.swing.JScrollPane();
        TableNhanVien = new javax.swing.JTable();
        frame_input = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_tennv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_cccd = new javax.swing.JTextField();
        txt_mail3 = new javax.swing.JTextField();
        txt_chucvu = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JTextField();
        frame_btnfunction = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        RefreshTour = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(714, 548));

        frame_nav.setBackground(new java.awt.Color(76, 148, 189));
        frame_nav.setPreferredSize(new java.awt.Dimension(700, 60));

        btn_searchNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search_btn.png"))); // NOI18N
        btn_searchNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_searchNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchNVMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Nhân Viên");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        EnterNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(EnterNhanVien);

        javax.swing.GroupLayout frame_navLayout = new javax.swing.GroupLayout(frame_nav);
        frame_nav.setLayout(frame_navLayout);
        frame_navLayout.setHorizontalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_searchNV)
                .addGap(123, 123, 123)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(60, 60, 60))
        );
        frame_navLayout.setVerticalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_navLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(frame_navLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_searchNV)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );

        frame_tbdata.setPreferredSize(new java.awt.Dimension(693, 281));

        TableNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên ", "Cccd", "Email", "Chức Vụ"
            }
        ));
        TableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNhanVienMouseClicked(evt);
            }
        });
        frame_tbdata.setViewportView(TableNhanVien);

        frame_input.setBackground(new java.awt.Color(204, 204, 204));
        frame_input.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        frame_input.setPreferredSize(new java.awt.Dimension(695, 90));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("ID");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Họ và Tên");

        txt_tennv.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("CCCD");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Email");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Chức Vụ");

        txt_cccd.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txt_mail3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txt_chucvu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_chucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Quản Lý" }));

        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout frame_inputLayout = new javax.swing.GroupLayout(frame_input);
        frame_input.setLayout(frame_inputLayout);
        frame_inputLayout.setHorizontalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_inputLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18))
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)))
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addComponent(txt_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(29, 29, 29)
                        .addComponent(txt_mail3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txt_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        frame_inputLayout.setVerticalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txt_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel10)
                        .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_mail3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        frame_btnfunction.setBackground(new java.awt.Color(204, 204, 204));
        frame_btnfunction.setPreferredSize(new java.awt.Dimension(695, 50));

        btnUpdate.setBackground(new java.awt.Color(52, 103, 113));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Câp nhật");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(52, 103, 113));
        btnDel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("Xóa");
        btnDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        RefreshTour.setBackground(new java.awt.Color(52, 103, 113));
        RefreshTour.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RefreshTour.setForeground(new java.awt.Color(255, 255, 255));
        RefreshTour.setText("Làm mới");
        RefreshTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RefreshTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshTourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frame_btnfunctionLayout = new javax.swing.GroupLayout(frame_btnfunction);
        frame_btnfunction.setLayout(frame_btnfunctionLayout);
        frame_btnfunctionLayout.setHorizontalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(btnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(RefreshTour)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        frame_btnfunctionLayout.setVerticalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDel)
                    .addComponent(RefreshTour))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame_nav, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(frame_input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(frame_btnfunction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(frame_tbdata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frame_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_btnfunction, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) TableNhanVien.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        ArrayList<NhanVien> nhanVienList = NhanVien.selectAll();
        for (NhanVien nv : nhanVienList) {
            model.addRow(new Object[]{
                nv.getId(),
                nv.getFullname(),
                nv.getCccd(),
                nv.getEmail(),
                nv.getChucvu()
            });
        }
    }

    public void clearInputFields() {
        txt_id.setText("");
        txt_tennv.setText("");
        txt_mail3.setText("");
        txt_chucvu.setSelectedIndex(0);
        txt_cccd.setText("");
    }

    private void btn_searchNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchNVMouseClicked
        performSearchNhanVien();
    }//GEN-LAST:event_btn_searchNVMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = TableNhanVien.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần cập nhật!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = txt_id.getText();
        String fullname = txt_tennv.getText();
        String cccd = txt_cccd.getText();
        String email = txt_mail3.getText();
        String chucvu = txt_chucvu.getSelectedItem().toString();

        NhanVien nv = new NhanVien(id, fullname, cccd, email, "", chucvu);
        int result = NhanVien.update(nv);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công!");
            loadData();
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int selectedRow = TableNhanVien.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = TableNhanVien.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int result = NhanVien.delete(id);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
                loadData(); // Tải lại dữ liệu
            } else {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void RefreshTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshTourActionPerformed
        clearInputFields();
        loadData();
    }//GEN-LAST:event_RefreshTourActionPerformed

    private void TableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableNhanVienMouseClicked
        int selectedRow = TableNhanVien.getSelectedRow();
        txt_id.setText(model.getValueAt(selectedRow, 0).toString());
        txt_tennv.setText(model.getValueAt(selectedRow, 1).toString());
        txt_cccd.setText(model.getValueAt(selectedRow, 2).toString());
        txt_mail3.setText(model.getValueAt(selectedRow, 3).toString());
        txt_chucvu.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
    }//GEN-LAST:event_TableNhanVienMouseClicked

    private void performSearchNhanVien() {
        String keyword = EnterNhanVien.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa để tìm kiếm.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ArrayList<NhanVien> results = NhanVien.selectLikeKey(keyword);
        model.setRowCount(0); // Xóa dữ liệu cũ
        for (NhanVien nv : results) {
            model.addRow(new Object[]{
                nv.getId(),
                nv.getFullname(),
                nv.getCccd(),
                nv.getEmail(),
                nv.getChucvu()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane EnterNhanVien;
    private javax.swing.JButton RefreshTour;
    private javax.swing.JTable TableNhanVien;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel btn_searchNV;
    private javax.swing.JPanel frame_btnfunction;
    private javax.swing.JPanel frame_input;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JComboBox<String> txt_chucvu;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_mail3;
    private javax.swing.JTextField txt_tennv;
    // End of variables declaration//GEN-END:variables
}
