/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tour;

import Control.DAO;
import Object.ThanhToan;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MYLAP.VN
 */
public class ListPayment extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListPayment
     */
    DefaultTableModel model; 
    public ListPayment() {
        initComponents();
        model = (DefaultTableModel) TableListPayment.getModel();
        TableListPayment.setDefaultEditor(Object.class, null);
        loadData();
    } 
    
    private void loadData() {
    model.setRowCount(0); 
    ArrayList<ThanhToan> thanhToanList = ThanhToan.selectAll();

for (ThanhToan thanhToan : thanhToanList) {
        model.addRow(new Object[]{
            thanhToan.getMaThanhToan() != null ? thanhToan.getMaThanhToan() : "",
            thanhToan.getMadatTour() != null ? thanhToan.getMadatTour() : "", 
            thanhToan.getNgayThanhToan() != null ? thanhToan.getNgayThanhToan() : "", 
            thanhToan.getHinhThuc() != null ? thanhToan.getHinhThuc() : "", 
            thanhToan.getTongTien() 
        });
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame_nav = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Entertext = new javax.swing.JTextPane();
        frame_tbdata = new javax.swing.JScrollPane();
        TableListPayment = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        frame_nav.setBackground(new java.awt.Color(76, 148, 189));
        frame_nav.setPreferredSize(new java.awt.Dimension(700, 60));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search_btn.png"))); // NOI18N
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Thông Tin Thanh Toán");

        Entertext.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(Entertext);

        javax.swing.GroupLayout frame_navLayout = new javax.swing.GroupLayout(frame_nav);
        frame_nav.setLayout(frame_navLayout);
        frame_navLayout.setHorizontalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(53, 53, 53)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(47, 47, 47))
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))))
                .addGap(13, 13, 13))
        );

        frame_tbdata.setPreferredSize(new java.awt.Dimension(693, 281));

        TableListPayment.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TableListPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thanh toán", "Mã đặt tour", "Ngày thanh toán", "Hình thức", "Tổng tiền"
            }
        ));
        frame_tbdata.setViewportView(TableListPayment);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame_nav, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
            .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frame_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        searchPayments();
    }//GEN-LAST:event_btnSearchMouseClicked

    public void searchPayments() {
    // Lấy từ khóa tìm kiếm từ ô nhập
    String keyword = Entertext.getText().trim();

    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa để tìm kiếm.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        return;
    }

    ArrayList<ThanhToan> results = ThanhToan.selectLikeKey(keyword);
    model.setRowCount(0);

    for (ThanhToan thanhToan : results) {
        model.addRow(new Object[]{
            thanhToan.getMaThanhToan(),    
            thanhToan.getMadatTour(),      
            thanhToan.getNgayThanhToan(),
            thanhToan.getHinhThuc(),     
            thanhToan.getTongTien()      
        });
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Entertext;
    private javax.swing.JTable TableListPayment;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
