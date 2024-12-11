/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tour;

import Object.Tour;
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
public class QuanLyTourP extends javax.swing.JInternalFrame {

    /**
     * Creates new form QuanLyTourP
     */
    DefaultTableModel model;

    public void setupPermissions(String chucVu) {
        if ("Nhân Viên".equals(chucVu)) {
            btnAdd.setEnabled(false); // Tắt nút Thêm
            btnUpdate.setEnabled(false); // Tắt nút Sửa
            btnDel.setEnabled(false); // Tắt nút Xoá
        }
    }

    public QuanLyTourP() throws SQLException {
        initComponents();
        model = (DefaultTableModel) TableTour.getModel();
        TableTour.setDefaultEditor(Object.class, null);
        loadData();

        TableTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTourMouseClicked(evt);
            }
        });

//        Entertext.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                EntertextActionPerformed(evt);
//            }
//        });
    }

    private void loadData() {
        model.setRowCount(0);
        ArrayList<Tour> tours = Tour.selectAll();
        for (Tour tour : tours) {
            model.addRow(new Object[]{tour.getMaTour(), tour.getTenTour(), tour.getGia(), tour.getNgayBd(), tour.getNgayKt()});
        }
    }

    private void tableTourMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = TableTour.getSelectedRow(); 
        btnAdd.setEnabled(false);
        txtMaTour.enable(false);
        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng đã chọn và điền vào các trường nhập liệu
            txtMaTour.setText(model.getValueAt(selectedRow, 0).toString());
            txtTenTour.setText(model.getValueAt(selectedRow, 1).toString());
            txtGia.setText(model.getValueAt(selectedRow, 2).toString());

            // Định dạng ngày tháng năm
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày từ cơ sở dữ liệu và mong muốn

            try {
                // Chuyển đổi ngày bắt đầu
                String ngayBDString = model.getValueAt(selectedRow, 3).toString();
                Date ngayBD = dateFormat.parse(ngayBDString);
                txtNgayBD.setDate(ngayBD);

                // Chuyển đổi ngày kết thúc
                String ngayKTString = model.getValueAt(selectedRow, 4).toString();
                Date ngayKT = dateFormat.parse(ngayKTString);
                txtNgayKT.setDate(ngayKT);
            } catch (Exception e) {
                e.printStackTrace(); // Xử lý ngoại lệ nếu có
            }
        } else {
            clearInputFields();
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
        TableTour = new javax.swing.JTable();
        frame_btnfunction = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        RefreshTour = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        frame_input = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenTour = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        txtMaTour = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(714, 548));

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
        jLabel1.setText("Tour");

        Entertext.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(Entertext);

        javax.swing.GroupLayout frame_navLayout = new javax.swing.GroupLayout(frame_nav);
        frame_nav.setLayout(frame_navLayout);
        frame_navLayout.setHorizontalGroup(
            frame_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(53, 53, 53)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
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

        TableTour.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TableTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tour", "Tên tour", "Giá", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        frame_tbdata.setViewportView(TableTour);

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

        btnAdd.setBackground(new java.awt.Color(52, 103, 113));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frame_btnfunctionLayout = new javax.swing.GroupLayout(frame_btnfunction);
        frame_btnfunction.setLayout(frame_btnfunctionLayout);
        frame_btnfunctionLayout.setHorizontalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RefreshTour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_btnfunctionLayout.setVerticalGroup(
            frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_btnfunctionLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(frame_btnfunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDel)
                    .addComponent(RefreshTour))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        frame_input.setBackground(new java.awt.Color(204, 204, 204));
        frame_input.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        frame_input.setPreferredSize(new java.awt.Dimension(695, 90));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Mã tour");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Tên tour");

        txtTenTour.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtGia.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Ngày bắt đầu");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Ngày kết thúc");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Giá");

        txtNgayBD.setDateFormatString("yyyy-MM-dd");
        txtNgayBD.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtNgayKT.setDateFormatString("yyyy-MM-dd");
        txtNgayKT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtMaTour.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout frame_inputLayout = new javax.swing.GroupLayout(frame_input);
        frame_input.setLayout(frame_inputLayout);
        frame_inputLayout.setHorizontalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_inputLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)))
                .addGap(6, 6, 6)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenTour, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(txtMaTour))
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_inputLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        frame_inputLayout.setVerticalGroup(
            frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_inputLayout.createSequentialGroup()
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame_inputLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(frame_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11)
                        .addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frame_nav, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(frame_btnfunction, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(frame_input, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frame_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_tbdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frame_btnfunction, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void performSearch() {
        String keyword = Entertext.getText().trim(); // Lấy từ khóa tìm kiếm

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa để tìm kiếm.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ArrayList<Tour> result = Tour.selectLikeKey(keyword);
        model.setRowCount(0); // Xóa toàn bộ dữ liệu cũ trong bảng
        for (Tour t : result) {
            model.addRow(new Object[]{
                t.getMaTour(),
                t.getTenTour(),
                t.getGia(),
                t.getNgayBd(),
                t.getNgayKt()
            });
        }
    }
    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        performSearch();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtMaTour.getText().isEmpty() || txtTenTour.getText().isEmpty() || txtGia.getText().isEmpty()
                || txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Tour t = new Tour();
        t.setMaTour(txtMaTour.getText());
        t.setTenTour(txtTenTour.getText());

        // Kiểm tra và thiết lập giá trị cho giá tour
        try {
            double gia = Double.parseDouble(txtGia.getText());
            if (gia <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Giá tour phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            t.setGia(gia);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Giá tour không hợp lệ. Vui lòng nhập số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Định dạng ngày
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Lấy và định dạng ngày bắt đầu
            Date ngaybdDate = txtNgayBD.getDate();
            String ngaybdStr = formatter.format(ngaybdDate);
            LocalDate ngaybd = LocalDate.parse(ngaybdStr);
            t.setNgayBd(ngaybd);

            // Lấy và định dạng ngày kết thúc
            Date ngayktDate = txtNgayKT.getDate();
            String ngayktStr = formatter.format(ngayktDate);
            LocalDate ngaykt = LocalDate.parse(ngayktStr);
            t.setNgayKt(ngaykt);

            // Kiểm tra xem ngày kết thúc có sau ngày bắt đầu không
            if (ngaykt.isBefore(ngaybd)) {
                JOptionPane.showMessageDialog(rootPane, "Ngày kết thúc phải sau ngày bắt đầu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Định dạng ngày không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AddTour(t);
        clearInputFields();
        loadData();

    }//GEN-LAST:event_btnAddActionPerformed

    private void AddTour(Tour t) {
        Tour.insert(t);
    }

    private void clearInputFields() {
        txtMaTour.setText("");
        txtTenTour.setText("");
        txtGia.setText("");
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtMaTour.requestFocus(); // Đưa con trỏ về trường mã tour
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = TableTour.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Tour để sửa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Thu thập dữ liệu từ các trường nhập liệu
        String maTour = txtMaTour.getText().trim();
        String tenTour = txtTenTour.getText().trim();
        String giaStr = txtGia.getText().trim();

        if (maTour.isEmpty() || tenTour.isEmpty() || giaStr.isEmpty() || txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Định dạng ngày
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Xác thực và chuyển đổi giá từ String sang double
        double gia;
        try {
            gia = Double.parseDouble(giaStr);
            if (gia <= 0) {
                JOptionPane.showMessageDialog(this, "Giá phải là số dương.", "Lỗi Giá", JOptionPane.ERROR_MESSAGE);
                txtGia.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá phải là số.", "Lỗi Giá", JOptionPane.ERROR_MESSAGE);
            txtGia.requestFocus();
            return;
        }

        // Xử lý ngày bắt đầu và ngày kết thúc
        LocalDate ngayBd = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(txtNgayBD.getDate()));
        LocalDate ngayKt = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(txtNgayKT.getDate()));

        if (ngayKt.isBefore(ngayBd)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không thể trước ngày bắt đầu.", "Lỗi Ngày", JOptionPane.ERROR_MESSAGE);
            txtNgayKT.requestFocus();
            return;
        }

        // Tạo đối tượng Tour đã cập nhật
        Tour updatedTour = new Tour();
        updatedTour.setMaTour(maTour);
        updatedTour.setTenTour(tenTour);
        updatedTour.setGia(gia);
        updatedTour.setNgayBd(ngayBd);
        updatedTour.setNgayKt(ngayKt);

        Tour.update(updatedTour);
        JOptionPane.showMessageDialog(this, "Sửa Tour thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        loadData();
        clearInputFields(); // Làm sạch các trường nhập liệu
        btnAdd.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int selectedRow = TableTour.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Tour để xóa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Xác nhận lại với người dùng trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Tour này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Nếu người dùng chọn "No", dừng thao tác xóa
        }

        String maTour = model.getValueAt(selectedRow, 0).toString();
        Tour.delete(maTour);
        JOptionPane.showMessageDialog(this, "Xóa Tour thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        loadData();
        clearInputFields();
        btnAdd.setEnabled(true);
    }//GEN-LAST:event_btnDelActionPerformed

    private void RefreshTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshTourActionPerformed
        loadData();
        clearInputFields();
        btnAdd.setEnabled(true);
    }//GEN-LAST:event_RefreshTourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Entertext;
    private javax.swing.JButton RefreshTour;
    private javax.swing.JTable TableTour;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel frame_btnfunction;
    private javax.swing.JPanel frame_input;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaTour;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextField txtTenTour;
    // End of variables declaration//GEN-END:variables
}
