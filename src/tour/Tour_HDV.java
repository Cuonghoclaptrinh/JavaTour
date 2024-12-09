/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tour;

import Control.DAO_TourHDV;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Object.TourHDV;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import Controller.tour_hdvlogic;
/**
 *
 * @author MYLAP.VN
 */
public class Tour_HDV extends javax.swing.JInternalFrame {

    /**
     * Creates new form Tour_HDV
     */
    
    private ArrayList<TourHDV> listTourHDV;
    private DefaultTableModel model;
    
    public Tour_HDV() {
        initComponents();      
        listTourHDV = new DAO_TourHDV().getAllTourHDV();
        model = (DefaultTableModel) tableTourHDV.getModel();
        loadData();
        
        tableTourHDV.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableHdvMouseClicked(evt);
            }
        });
    }
    
    
    private void loadData() {
        model.setRowCount(0); 
        listTourHDV = new DAO_TourHDV().getAllTourHDV();
        for (TourHDV th : listTourHDV) {
            model.addRow(new Object[]{th.getMaTour(), th.getMaHDV()});
        }
    }

    private void tableHdvMouseClicked(MouseEvent evt) {
    int selectedRow = tableTourHDV.getSelectedRow(); // Lấy chỉ số dòng được chọn
    if (selectedRow != -1) {
        // Lấy giá trị từ bảng và điền vào các trường nhập liệu
        String maTour = tableTourHDV.getValueAt(selectedRow, 0).toString();
        String maHdv = tableTourHDV.getValueAt(selectedRow, 1).toString();
        
        txtMaTour.setText(maTour);
        txtMaHDV.setText(maHdv);
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
        txtSearchHdv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_search = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        frame_tbdata = new javax.swing.JScrollPane();
        tableTourHDV = new javax.swing.JTable();
        frame_input = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaHDV = new javax.swing.JTextField();
        txtMaTour = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        frame_btnfunction = new javax.swing.JPanel();
        btnAddHdvTour = new javax.swing.JButton();
        btnUpdateHdvTour = new javax.swing.JButton();
        btnXoaHdvTour = new javax.swing.JButton();
        RefreshHdv = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        frame_nav.setBackground(new java.awt.Color(76, 148, 189));
        frame_nav.setPreferredSize(new java.awt.Dimension(700, 60));

        txtSearchHdv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchHdv.setBorder(null);
        txtSearchHdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchHdvActionPerformed(evt);
            }
        });

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search_btn.png"))); // NOI18N
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Hành trình HDV");

        javax.swing.GroupLayout frame_navLayout = new javax.swing.GroupLayout(frame_nav);
        frame_nav.setLayout(frame_navLayout);
        frame_navLayout.setHorizontalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchHdv, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(69, 69, 69))
        );
        frame_navLayout.setVerticalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_navLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btn_search)
                    .addComponent(jLabel7)
                    .addComponent(txtSearchHdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        frame_tbdata.setPreferredSize(new java.awt.Dimension(693, 281));

        tableTourHDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Tour", "Mã HDV"
            }
        ));
        frame_tbdata.setViewportView(tableTourHDV);

        frame_input.setBackground(new java.awt.Color(204, 204, 204));
        frame_input.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        frame_input.setPreferredSize(new java.awt.Dimension(695, 90));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã HDV");

        txtMaHDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mã Tour");

        javax.swing.GroupLayout frame_inputLayout = new javax.swing.GroupLayout(frame_input);
        frame_input.setLayout(frame_inputLayout);
        frame_inputLayout.setHorizontalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaHDV, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_inputLayout.setVerticalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaHDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        frame_btnfunction.setBackground(new java.awt.Color(204, 204, 204));
        frame_btnfunction.setPreferredSize(new java.awt.Dimension(695, 50));

        btnAddHdvTour.setBackground(new java.awt.Color(52, 103, 113));
        btnAddHdvTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddHdvTour.setForeground(new java.awt.Color(255, 255, 255));
        btnAddHdvTour.setText("Thêm");
        btnAddHdvTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHdvTourActionPerformed(evt);
            }
        });

        btnUpdateHdvTour.setBackground(new java.awt.Color(52, 103, 113));
        btnUpdateHdvTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdateHdvTour.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateHdvTour.setText("Câp nhật");
        btnUpdateHdvTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateHdvTourActionPerformed(evt);
            }
        });

        btnXoaHdvTour.setBackground(new java.awt.Color(52, 103, 113));
        btnXoaHdvTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaHdvTour.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaHdvTour.setText("Xóa");
        btnXoaHdvTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHdvTourActionPerformed(evt);
            }
        });

        RefreshHdv.setBackground(new java.awt.Color(52, 103, 113));
        RefreshHdv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefreshHdv.setForeground(new java.awt.Color(255, 255, 255));
        RefreshHdv.setText("làm mới");
        RefreshHdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshHdvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frame_btnfunctionLayout = new javax.swing.GroupLayout(frame_btnfunction);
        frame_btnfunction.setLayout(frame_btnfunctionLayout);
        frame_btnfunctionLayout.setHorizontalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddHdvTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateHdvTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaHdvTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RefreshHdv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_btnfunctionLayout.setVerticalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddHdvTour)
                    .addComponent(btnUpdateHdvTour)
                    .addComponent(btnXoaHdvTour)
                    .addComponent(RefreshHdv))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame_nav, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
            .addComponent(frame_btnfunction, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
            .addComponent(frame_input, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
            .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(frame_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_input, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_btnfunction, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchHdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchHdvActionPerformed
       tour_hdvlogic logic = new tour_hdvlogic(tableTourHDV, txtMaHDV, txtMaTour, txtSearchHdv, model);
       logic.performsearch();
    }//GEN-LAST:event_txtSearchHdvActionPerformed

    private void btnAddHdvTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHdvTourActionPerformed
        tour_hdvlogic logic = new tour_hdvlogic(tableTourHDV, txtMaHDV, txtMaTour, txtSearchHdv, model);
        logic.add_tourhdv_logic();
    }//GEN-LAST:event_btnAddHdvTourActionPerformed

    private void btnUpdateHdvTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateHdvTourActionPerformed
       tour_hdvlogic logic = new tour_hdvlogic(tableTourHDV, txtMaHDV, txtMaTour, txtSearchHdv, model);
       logic.update_tourhdv_logic();
    }//GEN-LAST:event_btnUpdateHdvTourActionPerformed

    private void btnXoaHdvTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHdvTourActionPerformed
       tour_hdvlogic logic = new tour_hdvlogic(tableTourHDV, txtMaHDV, txtMaTour, txtSearchHdv, model);
       logic.delete_tour_logic();
    }//GEN-LAST:event_btnXoaHdvTourActionPerformed

    private void RefreshHdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshHdvActionPerformed
       tour_hdvlogic logic = new tour_hdvlogic(tableTourHDV, txtMaHDV, txtMaTour, txtSearchHdv, model);
       logic.refresh_tourhdv();
    }//GEN-LAST:event_RefreshHdvActionPerformed

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
       tour_hdvlogic logic = new tour_hdvlogic(tableTourHDV, txtMaHDV, txtMaTour, txtSearchHdv, model);
       logic.performsearch();
    }//GEN-LAST:event_btn_searchMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshHdv;
    private javax.swing.JButton btnAddHdvTour;
    private javax.swing.JButton btnUpdateHdvTour;
    private javax.swing.JButton btnXoaHdvTour;
    private javax.swing.JLabel btn_search;
    private javax.swing.JPanel frame_btnfunction;
    private javax.swing.JPanel frame_input;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable tableTourHDV;
    private javax.swing.JTextField txtMaHDV;
    private javax.swing.JTextField txtMaTour;
    private javax.swing.JTextField txtSearchHdv;
    // End of variables declaration//GEN-END:variables
}