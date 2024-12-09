/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tour;

import Control.DAO;
import Control.DAO_KhachHang;
import Object.KhachHang;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MYLAP.VN
 */
public class QuanLyKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKhachHang
     */
    private ArrayList<KhachHang> ListCustomer;
    DefaultTableModel model;

    public QuanLyKhachHang() {
        initComponents();
        ListCustomer = new DAO_KhachHang().getAllCustomers();
        model = (DefaultTableModel) TableKhachHang.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã khách hàng", "Tên khách hàng", "SĐT", "CCCD", "Địa Chỉ"});
        loadData();

        TableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablekhachhangMouseClicked(evt);
            }
        });
    }

    private void tablekhachhangMouseClicked(java.awt.event.MouseEvent evt) {
        // Lấy chỉ số hàng được chọn trong bảng
        int selectedRow = TableKhachHang.getSelectedRow();

        txtMaKh.setText(model.getValueAt(selectedRow, 0).toString());
        txtTenKh.setText(model.getValueAt(selectedRow, 1).toString());
        txtSDT.setText(model.getValueAt(selectedRow, 2).toString());
        txtCCCD.setText(model.getValueAt(selectedRow, 3).toString());
        txtDiaChi.setText(model.getValueAt(selectedRow, 4).toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        frame_content = new javax.swing.JPanel();
        frame_nav = new javax.swing.JPanel();
        txtEnterKhachHang = new javax.swing.JTextField();
        btnSearchKhachHang = new javax.swing.JLabel();
        frame_tbdata = new javax.swing.JScrollPane();
        TableKhachHang = new javax.swing.JTable();
        frame_input = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenKh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        frame_btnfunction = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        frame_category = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PageTour = new javax.swing.JLabel();
        PageKhachHang = new javax.swing.JLabel();
        PageHuongDanVien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PageBookTour = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(906, 506));

        frame_content.setPreferredSize(new java.awt.Dimension(700, 500));

        frame_nav.setBackground(new java.awt.Color(0, 144, 133));
        frame_nav.setPreferredSize(new java.awt.Dimension(700, 60));

        txtEnterKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEnterKhachHang.setBorder(null);
        txtEnterKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnterKhachHangActionPerformed(evt);
            }
        });

        btnSearchKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search_btn.png"))); // NOI18N
        btnSearchKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchKhachHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout frame_navLayout = new javax.swing.GroupLayout(frame_nav);
        frame_nav.setLayout(frame_navLayout);
        frame_navLayout.setHorizontalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEnterKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchKhachHang)
                .addContainerGap(479, Short.MAX_VALUE))
        );
        frame_navLayout.setVerticalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_navLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchKhachHang)
                    .addComponent(txtEnterKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        frame_tbdata.setPreferredSize(new java.awt.Dimension(693, 281));

        TableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "sdt", "Số điện thoại", "Địa Chỉ"
            }
        ));
        frame_tbdata.setViewportView(TableKhachHang);

        frame_input.setBackground(new java.awt.Color(204, 204, 204));
        frame_input.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        frame_input.setPreferredSize(new java.awt.Dimension(695, 90));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã khách hàng");

        txtMaKh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tên khách hàng");

        txtTenKh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Địa chỉ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("CCCD");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Số điện thoại");

        javax.swing.GroupLayout frame_inputLayout = new javax.swing.GroupLayout(frame_input);
        frame_input.setLayout(frame_inputLayout);
        frame_inputLayout.setHorizontalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 229, Short.MAX_VALUE))
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        frame_inputLayout.setVerticalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        frame_btnfunction.setBackground(new java.awt.Color(204, 204, 204));
        frame_btnfunction.setPreferredSize(new java.awt.Dimension(695, 50));

        btnAdd.setBackground(new java.awt.Color(52, 103, 113));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(52, 103, 113));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Câp nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(52, 103, 113));
        btnDel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("Xóa");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(52, 103, 113));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Thoát");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frame_btnfunctionLayout = new javax.swing.GroupLayout(frame_btnfunction);
        frame_btnfunction.setLayout(frame_btnfunctionLayout);
        frame_btnfunctionLayout.setHorizontalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnAdd)
                .addGap(94, 94, 94)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btnDel)
                .addGap(100, 100, 100)
                .addComponent(jButton4)
                .addGap(48, 48, 48))
        );
        frame_btnfunctionLayout.setVerticalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_btnfunctionLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDel)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout frame_contentLayout = new javax.swing.GroupLayout(frame_content);
        frame_content.setLayout(frame_contentLayout);
        frame_contentLayout.setHorizontalGroup(
            frame_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_contentLayout.createSequentialGroup()
                .addGroup(frame_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(frame_nav, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(frame_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(frame_btnfunction, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(frame_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(frame_tbdata, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(frame_input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_contentLayout.setVerticalGroup(
            frame_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_contentLayout.createSequentialGroup()
                .addComponent(frame_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_tbdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_btnfunction, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        frame_category.setBackground(new java.awt.Color(0, 102, 102));
        frame_category.setPreferredSize(new java.awt.Dimension(200, 500));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Category");

        PageTour.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        PageTour.setForeground(new java.awt.Color(204, 204, 204));
        PageTour.setText("Tour");
        PageTour.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        PageTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PageTourMouseClicked(evt);
            }
        });

        PageKhachHang.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        PageKhachHang.setForeground(new java.awt.Color(204, 204, 204));
        PageKhachHang.setText("Khách hàng");
        PageKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        PageKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PageKhachHangMouseClicked(evt);
            }
        });

        PageHuongDanVien.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        PageHuongDanVien.setForeground(new java.awt.Color(204, 204, 204));
        PageHuongDanVien.setText("Hướng dẫn viên");
        PageHuongDanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        PageHuongDanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PageHuongDanVienMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Điểm tham quan");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        PageBookTour.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        PageBookTour.setForeground(new java.awt.Color(204, 204, 204));
        PageBookTour.setText("Đặt tour");
        PageBookTour.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        PageBookTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PageBookTourMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout frame_categoryLayout = new javax.swing.GroupLayout(frame_category);
        frame_category.setLayout(frame_categoryLayout);
        frame_categoryLayout.setHorizontalGroup(
            frame_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_categoryLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(frame_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PageTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PageKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PageHuongDanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PageBookTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        frame_categoryLayout.setVerticalGroup(
            frame_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_categoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(PageTour)
                .addGap(18, 18, 18)
                .addComponent(PageKhachHang)
                .addGap(18, 18, 18)
                .addComponent(PageHuongDanVien)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(PageBookTour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frame_category, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_content, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frame_category, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(frame_content, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnterKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnterKhachHangActionPerformed
        performSearch();
    }//GEN-LAST:event_txtEnterKhachHangActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String MaKh = txtMaKh.getText();
        String TenKh = txtTenKh.getText();
        String Cccd = txtCCCD.getText();
        String DiaChi = txtDiaChi.getText();
        String Sdt = txtSDT.getText();

        KhachHang Customer = new KhachHang(MaKh, TenKh, Sdt, Cccd, DiaChi);
        DAO_KhachHang CustomerDAO = new DAO_KhachHang();

        try {
            if (DAO_KhachHang.addKhachHang(Customer)) {
                ListCustomer.add(Customer);  // Thêm vào danh sách chỉ khi thành công
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
                showResult();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm khác hàng");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    public void showResult() {
        KhachHang t = ListCustomer.get(ListCustomer.size() - 1);
        model.addRow(new Object[]{
            t.getMaKh(), t.getTenKh(), t.getSdt(), t.getCccd(), t.getDiaChi()
        });
    }

    private void clearInputFields() {
        txtMaKh.setText("");
        txtTenKh.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtCCCD.setText("");
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int selectRow = TableKhachHang.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Tour để sửa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String makh = txtMaKh.getText();
        String tenKh = txtTenKh.getText();
        String sdt = txtSDT.getText();
        String cccd = txtCCCD.getText();
        String diaChi = txtDiaChi.getText();

        // Kiểm tra xem các trường có trống không
        if (tenKh.isEmpty() || sdt.isEmpty() || cccd.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin khách hàng!");
            return;
        }

        KhachHang custemer = new KhachHang(makh, tenKh, sdt, cccd, diaChi);
        boolean isUpdate = new DAO_KhachHang().UpdateKhachHang(custemer);
        if (isUpdate) {
            model.setValueAt(makh, selectRow, 0);
            model.setValueAt(tenKh, selectRow, 1);
            model.setValueAt(sdt, selectRow, 2);
            model.setValueAt(cccd, selectRow, 3);
            model.setValueAt(diaChi, selectRow, 4);
            JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thất bại!");
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int selectedRow = TableKhachHang.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để xoá.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lấy mã khách hàng từ hàng được chọn
        String maKH = TableKhachHang.getValueAt(selectedRow, 0).toString();

        // Xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá khách hàng này?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DAO_KhachHang customerDAO = new DAO_KhachHang();
            boolean success = customerDAO.deleteCustomer(maKH);

            if (success) {
                ListCustomer.remove(selectedRow);
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Xoá khách hàng thành công.");
                loadData(); // Cập nhật lại dữ liệu trong bảng sau khi xoá
            } else {
                JOptionPane.showMessageDialog(this, "Xoá khách hàng thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void loadData() {
        model.setRowCount(0);
        for (KhachHang customer : ListCustomer) {
            model.addRow(new Object[]{
                customer.getMaKh(),
                customer.getTenKh(),
                customer.getSdt(),
                customer.getCccd(),
                customer.getDiaChi()
            });
        }
    }

    private void performSearch() {
        String keyword = txtEnterKhachHang.getText().trim(); // Lấy từ khóa tìm kiếm từ ô nhập
        try {
            ListCustomer = new DAO_KhachHang().searchCustomer(keyword); // Tìm kiếm khách hàng
            model.setRowCount(0); // Xóa bảng hiện tại
            for (KhachHang kh : ListCustomer) {
                model.addRow(new Object[]{kh.getMaKh(), kh.getTenKh(), kh.getSdt(), kh.getCccd(), kh.getDiaChi()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm khách hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void PageKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageKhachHangMouseClicked
        this.dispose();
        new QuanLyKhachHang().setVisible(true);
    }//GEN-LAST:event_PageKhachHangMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton4MouseClicked

    private void txtTenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhActionPerformed

    private void PageTourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageTourMouseClicked
        this.dispose();
        try {
            new QuanLyTour().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PageTourMouseClicked

    private void PageHuongDanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageHuongDanVienMouseClicked

    }//GEN-LAST:event_PageHuongDanVienMouseClicked

    private void PageBookTourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageBookTourMouseClicked

    }//GEN-LAST:event_PageBookTourMouseClicked

    private void btnSearchKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchKhachHangMouseClicked
        performSearch();
    }//GEN-LAST:event_btnSearchKhachHangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PageBookTour;
    private javax.swing.JLabel PageHuongDanVien;
    private javax.swing.JLabel PageKhachHang;
    private javax.swing.JLabel PageTour;
    private javax.swing.JTable TableKhachHang;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JLabel btnSearchKhachHang;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel frame_btnfunction;
    private javax.swing.JPanel frame_category;
    private javax.swing.JPanel frame_content;
    private javax.swing.JPanel frame_input;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEnterKhachHang;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKh;
    // End of variables declaration//GEN-END:variables
}