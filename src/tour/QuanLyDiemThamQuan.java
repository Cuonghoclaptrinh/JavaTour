/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tour;

import Control.DAO_DiemThamQuan;
import Controller.DTQlogic;
import Object.DiemThamQuan;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author MYLAP.VN
 */
public class QuanLyDiemThamQuan extends javax.swing.JInternalFrame {

    /**
     * Creates new form DiemThamQuan
     */
    private ArrayList<DiemThamQuan> ListAttraction;
    DefaultTableModel model;

    public QuanLyDiemThamQuan() {
        initComponents();
        ListAttraction = new DAO_DiemThamQuan().getAllDiemThamQuan();
        model = (DefaultTableModel) TableDiemThamQuan.getModel();
        loadData();

        TableDiemThamQuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDiemThamQuanMouseClicked(evt);
            }
        });
    }

    private void tableDiemThamQuanMouseClicked(java.awt.event.MouseEvent evt) {
        // Lấy chỉ số hàng được chọn trong bảng
        int selectedRow = TableDiemThamQuan.getSelectedRow();

        // Kiểm tra chỉ số hàng được chọn có hợp lệ không
        if (selectedRow != -1) {
            txtMaDiemThamQuan.setText(model.getValueAt(selectedRow, 0).toString());
            txtTenDiemThamQuan.setText(model.getValueAt(selectedRow, 1).toString());
            txtDiaChiDiemThamQuan.setText(model.getValueAt(selectedRow, 2).toString());
        }
    }

    private void loadData() {
        model.setRowCount(0); 
        ListAttraction = new DAO_DiemThamQuan().getAllDiemThamQuan();
        for (DiemThamQuan dtq : ListAttraction) {
            model.addRow(new Object[]{dtq.getMaDiemThamQuan(), dtq.getTenDiaDiem(), dtq.getDiaChi()});
        }
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
        EnterDtq = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_searchDTQ = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        frame_tbdata = new javax.swing.JScrollPane();
        TableDiemThamQuan = new javax.swing.JTable();
        frame_input = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaDiemThamQuan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenDiemThamQuan = new javax.swing.JTextField();
        txtDiaChiDiemThamQuan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        frame_btnfunction = new javax.swing.JPanel();
        btnAddDtq = new javax.swing.JButton();
        btnUpdateDtq = new javax.swing.JButton();
        btnXoaDtq = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(715, 548));

        frame_nav.setBackground(new java.awt.Color(76, 148, 189));
        frame_nav.setPreferredSize(new java.awt.Dimension(700, 60));

        EnterDtq.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EnterDtq.setBorder(null);
        EnterDtq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterDtqActionPerformed(evt);
            }
        });

        btn_searchDTQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search_btn.png"))); // NOI18N
        btn_searchDTQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_searchDTQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchDTQMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Điểm Tham Quan");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout frame_navLayout = new javax.swing.GroupLayout(frame_nav);
        frame_nav.setLayout(frame_navLayout);
        frame_navLayout.setHorizontalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EnterDtq, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frame_navLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(frame_navLayout.createSequentialGroup()
                        .addComponent(btn_searchDTQ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54))))
        );
        frame_navLayout.setVerticalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_navLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(frame_navLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addGroup(frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EnterDtq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_searchDTQ))))
                .addGap(14, 14, 14))
        );

        frame_tbdata.setPreferredSize(new java.awt.Dimension(693, 281));

        TableDiemThamQuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã điểm tham quan ", "Tên điểm tham quan", "Địa chỉ"
            }
        ));
        frame_tbdata.setViewportView(TableDiemThamQuan);

        frame_input.setBackground(new java.awt.Color(204, 204, 204));
        frame_input.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        frame_input.setPreferredSize(new java.awt.Dimension(695, 90));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Mã điểm tham quan :");

        txtMaDiemThamQuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Tên điểm tham quan :");

        txtTenDiemThamQuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDiaChiDiemThamQuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Địa chỉ :");

        javax.swing.GroupLayout frame_inputLayout = new javax.swing.GroupLayout(frame_input);
        frame_input.setLayout(frame_inputLayout);
        frame_inputLayout.setHorizontalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenDiemThamQuan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(txtMaDiemThamQuan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChiDiemThamQuan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_inputLayout.setVerticalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(txtMaDiemThamQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDiemThamQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChiDiemThamQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame_btnfunction.setBackground(new java.awt.Color(204, 204, 204));
        frame_btnfunction.setPreferredSize(new java.awt.Dimension(695, 50));

        btnAddDtq.setBackground(new java.awt.Color(52, 103, 113));
        btnAddDtq.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddDtq.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDtq.setText("Thêm");
        btnAddDtq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddDtq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDtqActionPerformed(evt);
            }
        });

        btnUpdateDtq.setBackground(new java.awt.Color(52, 103, 113));
        btnUpdateDtq.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdateDtq.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateDtq.setText("Câp nhật");
        btnUpdateDtq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateDtq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDtqActionPerformed(evt);
            }
        });

        btnXoaDtq.setBackground(new java.awt.Color(52, 103, 113));
        btnXoaDtq.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaDtq.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaDtq.setText("Xóa");
        btnXoaDtq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaDtq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDtqActionPerformed(evt);
            }
        });

        btnrefresh.setBackground(new java.awt.Color(52, 103, 113));
        btnrefresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnrefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnrefresh.setText("làm mới");
        btnrefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frame_btnfunctionLayout = new javax.swing.GroupLayout(frame_btnfunction);
        frame_btnfunction.setLayout(frame_btnfunctionLayout);
        frame_btnfunctionLayout.setHorizontalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddDtq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateDtq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaDtq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_btnfunctionLayout.setVerticalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_btnfunctionLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnrefresh)
                    .addComponent(btnXoaDtq)
                    .addComponent(btnUpdateDtq)
                    .addComponent(btnAddDtq))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame_nav, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addComponent(frame_btnfunction, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addComponent(frame_input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(frame_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_input, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_btnfunction, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterDtqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterDtqActionPerformed
        DTQlogic logic = new DTQlogic(txtDiaChiDiemThamQuan, txtMaDiemThamQuan, txtTenDiemThamQuan, EnterDtq, TableDiemThamQuan, model);
        logic.performSearchAttraction();
    }//GEN-LAST:event_EnterDtqActionPerformed

    private void btnAddDtqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDtqActionPerformed
       DTQlogic logic = new DTQlogic(txtDiaChiDiemThamQuan, txtMaDiemThamQuan, txtTenDiemThamQuan, EnterDtq, TableDiemThamQuan, model);
       logic.add_dtq_logic();
    }//GEN-LAST:event_btnAddDtqActionPerformed

    private void btnUpdateDtqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDtqActionPerformed
        DTQlogic logic = new DTQlogic(txtDiaChiDiemThamQuan, txtMaDiemThamQuan, txtTenDiemThamQuan, EnterDtq, TableDiemThamQuan, model);
        logic.update_dtq_logic();
    }//GEN-LAST:event_btnUpdateDtqActionPerformed

    private void btnXoaDtqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDtqActionPerformed
        DTQlogic logic = new DTQlogic(txtDiaChiDiemThamQuan, txtMaDiemThamQuan, txtTenDiemThamQuan, EnterDtq, TableDiemThamQuan, model);
        logic.delete_dtq_logic();
    }//GEN-LAST:event_btnXoaDtqActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        DTQlogic logic = new DTQlogic(txtDiaChiDiemThamQuan, txtMaDiemThamQuan, txtTenDiemThamQuan, EnterDtq, TableDiemThamQuan, model);
        logic.refreshDtqList();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void btn_searchDTQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchDTQMouseClicked
        DTQlogic logic = new DTQlogic(txtDiaChiDiemThamQuan, txtMaDiemThamQuan, txtTenDiemThamQuan, EnterDtq, TableDiemThamQuan, model);
        logic.performSearchAttraction();
    }//GEN-LAST:event_btn_searchDTQMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EnterDtq;
    private javax.swing.JTable TableDiemThamQuan;
    private javax.swing.JButton btnAddDtq;
    private javax.swing.JButton btnUpdateDtq;
    private javax.swing.JButton btnXoaDtq;
    private javax.swing.JLabel btn_searchDTQ;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JPanel frame_btnfunction;
    private javax.swing.JPanel frame_input;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDiaChiDiemThamQuan;
    private javax.swing.JTextField txtMaDiemThamQuan;
    private javax.swing.JTextField txtTenDiemThamQuan;
    // End of variables declaration//GEN-END:variables
}