/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tour;

import Object.DatTour;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MYLAP.VN
 */
public class ListBooked extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListBooked
     */
    private DefaultTableModel model;

    public ListBooked() {
        initComponents();
        model = (DefaultTableModel) TableListBooked.getModel();
        TableListBooked.setDefaultEditor(Object.class, null);
        loadData();

        TableListBooked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Kiểm tra nếu số lần nhấn chuột là 2 (double-click)
                if (evt.getClickCount() == 2) {
                    System.out.println(".mouseClicked()");
                    int selectedRow = TableListBooked.getSelectedRow();

                    // Kiểm tra trạng thái thanh toán
                    String trangThaiThanhToan = TableListBooked.getValueAt(selectedRow, 6).toString();

                    if ("Chưa Thanh Toán".equals(trangThaiThanhToan)) {
                        String maDatTour = TableListBooked.getValueAt(selectedRow, 0).toString();
                        String tenTour = TableListBooked.getValueAt(selectedRow, 1).toString();
                        String tenKh = TableListBooked.getValueAt(selectedRow, 2).toString();
                        LocalDate ngayDat = LocalDate.parse(TableListBooked.getValueAt(selectedRow, 3).toString());
                        int soLuong = Integer.parseInt(TableListBooked.getValueAt(selectedRow, 4).toString());
                        double tongTien = Double.parseDouble(TableListBooked.getValueAt(selectedRow, 5).toString());

                        // Lấy danh sách thông tin tour từ phương thức getTourInfoList
                        ArrayList<String> tourInfoList = DatTour.getTourInfoList(maDatTour);

                        if (!tourInfoList.isEmpty()) {
                            // Giả sử thông tin đầu tiên trong danh sách chứa dữ liệu của tour
                            String info = tourInfoList.get(0); // Lấy thông tin tour từ danh sách

                            // Tách các thông tin từ chuỗi info
                            String[] infoParts = info.split(", ");
                            String diaChi = infoParts[0].split(": ")[1]; // Lấy địa chỉ
                            String cccd = infoParts[1].split(": ")[1]; // Lấy CCCD
                            double gia = Double.parseDouble(infoParts[2].split(": ")[1]); // Lấy giá

                            try {
                                // Hiển thị form thanh toán với thông tin đã tách
                                showPaymentForm(maDatTour, tenKh, diaChi, cccd, tenTour, soLuong, gia, tongTien, ngayDat);
                            } catch (SQLException ex) {
                                Logger.getLogger(ListPayment.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin tour.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Đơn đặt tour đã tha"
                                + ".nh toán.");
                    }
                }
            }
        });

    }

    private void showPaymentForm(String maDatTour, String tenKh, String diaChi, String cccd, String tenTour,
            int soLuong, double gia, double tongTien, LocalDate ngayDat) throws SQLException {
        Payment payment = new Payment(maDatTour, tenKh, diaChi, cccd, tenTour, soLuong, gia, tongTien, ngayDat);

        payment.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                loadData();
            }
        });

        payment.setVisible(true);

    }

    private void loadData() {
        model.setRowCount(0);
        ArrayList<DatTour> datTourList = DatTour.selectAll();

        for (DatTour datTour : datTourList) {
            model.addRow(new Object[]{
                datTour.getMaDatTour(),
                datTour.getMaTour(),
                datTour.getMaKhachHang(),
                datTour.getNgayDat(),
                datTour.getSoLuongNguoi(),
                datTour.getTongTien(),
                datTour.getTrangThai()
            });
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
        jLabel7 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Entertext = new javax.swing.JTextPane();
        frame_tbdata = new javax.swing.JScrollPane();
        TableListBooked = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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
        jLabel1.setText("Chuyến Đi Đã Đặt");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

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
                .addGap(52, 52, 52))
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

        TableListBooked.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TableListBooked.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt tour", "Mã tour", "Mã kh", "Ngày đặt", "Số người", "Tổng tiền", "Trạng thái"
            }
        ));
        frame_tbdata.setViewportView(TableListBooked);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame_nav, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
            .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
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
        searchBookings();
    }//GEN-LAST:event_btnSearchMouseClicked

    public void searchBookings() {
        String keyword = Entertext.getText().trim();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa để tìm kiếm.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ArrayList<DatTour> results = DatTour.selectLikeKey(keyword);
        model.setRowCount(0);
        for (DatTour datTour : results) {
            model.addRow(new Object[]{
                datTour.getMaDatTour(),
                datTour.getMaTour(),
                datTour.getMaKhachHang(),
                datTour.getNgayDat(),
                datTour.getSoLuongNguoi(),
                datTour.getTongTien(),
                datTour.getTrangThai()
            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Entertext;
    private javax.swing.JTable TableListBooked;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
