





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tour;

import Object.NhanVien;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author MYLAP.VN
 */
public class MainPage extends javax.swing.JPanel {

    private String chucVu;
    private NhanVien userInfo;

    public void setUserInfo(NhanVien userInfo) {
        idLable.setText(userInfo.getId());
        nameLabel.setText(userInfo.getFullname());
        emailLabel.setText(userInfo.getEmail());
        roleLabel.setText(userInfo.getChucvu());
        this.chucVu = userInfo.getChucvu();
    }
    

    
    
  // Phương thức kiểm tra quyền truy cập
private boolean hasPermission(String buttonName) {
    // Kiểm tra quyền truy cập vào từng nút
    switch (buttonName) {
        case "btn_tour":
        case "btn_khach":
        case "btn_hdv":
        case "btn_tourhdv":
        case "btn_diemtq":
        case "btn_booking":
        case "btn_listbooked":
        case "btn_listpayment":
        case "btn_tourdiemthamquan":
            // Cả Quản Lý và Nhân Viên đều có quyền truy cập các chức năng này
            if ("Quản Lý".equals(chucVu) || "Nhân Viên".equals(chucVu)) {
                return true; // Cho phép truy cập
            }
            break;

        // Nút Quản lý nhân viên chỉ Quản Lý mới có quyền vào
        case "btn_NhanVien":
            if ("Quản Lý".equals(chucVu)) {
                return true; // Chỉ Quản Lý có quyền vào
            }
            break;

    }

    // Các trường hợp không thỏa mãn điều kiện đều trả về false (không có quyền)
    return false;
}

private JInternalFrame currentForm = null;
// Phương thức để xử lý khi người dùng nhấn nút
private void handleButtonClick(String buttonName) {
    if (hasPermission(buttonName)) {
        try {
            // Nếu đã có cửa sổ hiện tại đang mở, thì đóng cửa sổ cũ
            if (currentForm != null && currentForm.isVisible()) {
                currentForm.setVisible(false); // Ẩn cửa sổ hiện tại
                currentForm.dispose(); // Giải phóng tài nguyên của cửa sổ hiện tại
            }

            JInternalFrame newForm = null;  // Khởi tạo cửa sổ mới
            
            // Dựa vào buttonName để xác định cửa sổ cần mở
            switch (buttonName) {
                case "btn_booking":

                    BookTourP booktour = new BookTourP();
                booktour.setVisible(true);
                booktour.setLocationRelativeTo(null);
                    break;
                case "btn_diemtq":
                    newForm = new QuanLyDiemThamQuan();
                    break;
                case "btn_hdv":
                    newForm = new QuanLyHuongDanVienP();
                    break;
                case "btn_khach":
                    newForm = new QuanLyKhachHangP();
                    break;
                case "btn_tour":
                    newForm = new QuanLyTourP();
                    break;
                case "btn_NhanVien":
                    newForm = new QuanLyNhanVien();
                    break;
                case "btn_listbooked":
                    newForm = new ListBooked();
                    break;
                case "btn_listpayment":
                    newForm = new ListPayment();
                    break;
                case "btn_tourhdv":
                    newForm = new Tour_HDV();
                    break;
                case "btn_tourdiemthamquan":
                    newForm = new Tour_DTQ();
                    break;
            }

            // Nếu cửa sổ mới được khởi tạo, thêm vào MyDesktop và hiển thị
            if (newForm != null) {
                MyDesktop.add(newForm);
                newForm.setVisible(true);
//                newForm.setLocationRelativeTo(null); // Đảm bảo cửa sổ mới được hiển thị ở vị trí hợp lý

                // Cập nhật currentForm để theo dõi cửa sổ mới
                currentForm = newForm;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi mở trang quản lý!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Nếu không có quyền, hiển thị thông báo
        JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào chức năng này.", "Lỗi quyền", JOptionPane.ERROR_MESSAGE);
    }
}



    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        setAccountPanelLocation();
        Account1.setVisible(true);
    }

    private void setAccountPanelLocation() {
        int x = this.getWidth() - 160; // Căn phải với khoảng cách nhỏ từ cạnh phải
        int y = 10; // Vị trí từ trên xuống
        Account1.setBounds(x, y, 150, 100); // Đặt vị trí và kích thước cho accountPanel
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame_category = new javax.swing.JPanel();
        btn_tour = new javax.swing.JButton();
        btn_khach = new javax.swing.JButton();
        btn_hdv = new javax.swing.JButton();
        btn_diemtq = new javax.swing.JButton();
        btn_booking = new javax.swing.JButton();
        btn_Nhanvien = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_listbooked = new javax.swing.JButton();
        btn_listpayment = new javax.swing.JButton();
        btn_tourhdv = new javax.swing.JButton();
        btn_tourdiemthamquan = new javax.swing.JButton();
        MyDesktop = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        nabar = new javax.swing.JPanel();
        Account = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Account1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        idLable = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();

        frame_category.setBackground(new java.awt.Color(57, 125, 148));
        frame_category.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        frame_category.setPreferredSize(new java.awt.Dimension(200, 500));

        btn_tour.setBackground(new java.awt.Color(0, 102, 102));
        btn_tour.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_tour.setForeground(new java.awt.Color(204, 204, 204));
        btn_tour.setText("Các Chuyến Đi");
        btn_tour.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_tour.setContentAreaFilled(false);
        btn_tour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tourMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tourMouseExited(evt);
            }
        });
        btn_tour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tourActionPerformed(evt);
            }
        });

        btn_khach.setBackground(new java.awt.Color(0, 102, 102));
        btn_khach.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_khach.setForeground(new java.awt.Color(204, 204, 204));
        btn_khach.setText("Khách Hàng");
        btn_khach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_khach.setContentAreaFilled(false);
        btn_khach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_khach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_khachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_khachMouseExited(evt);
            }
        });
        btn_khach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khachActionPerformed(evt);
            }
        });

        btn_hdv.setBackground(new java.awt.Color(0, 102, 102));
        btn_hdv.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_hdv.setForeground(new java.awt.Color(204, 204, 204));
        btn_hdv.setText("Hướng Dẫn Viên");
        btn_hdv.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_hdv.setContentAreaFilled(false);
        btn_hdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hdvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hdvMouseExited(evt);
            }
        });
        btn_hdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hdvActionPerformed(evt);
            }
        });

        btn_diemtq.setBackground(new java.awt.Color(0, 102, 102));
        btn_diemtq.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_diemtq.setForeground(new java.awt.Color(204, 204, 204));
        btn_diemtq.setText("Điểm Tham Quan");
        btn_diemtq.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_diemtq.setContentAreaFilled(false);
        btn_diemtq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_diemtq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_diemtqMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_diemtqMouseExited(evt);
            }
        });
        btn_diemtq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_diemtqActionPerformed(evt);
            }
        });

        btn_booking.setBackground(new java.awt.Color(0, 102, 102));
        btn_booking.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_booking.setForeground(new java.awt.Color(204, 204, 204));
        btn_booking.setText("Đặt Chuyến Đi");
        btn_booking.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_booking.setContentAreaFilled(false);
        btn_booking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_bookingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_bookingMouseExited(evt);
            }
        });
        btn_booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bookingActionPerformed(evt);
            }
        });

        btn_Nhanvien.setBackground(new java.awt.Color(0, 102, 102));
        btn_Nhanvien.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_Nhanvien.setForeground(new java.awt.Color(204, 204, 204));
        btn_Nhanvien.setText("Nhân Viên");
        btn_Nhanvien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_Nhanvien.setContentAreaFilled(false);
        btn_Nhanvien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NhanvienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_NhanvienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_NhanvienMouseExited(evt);
            }
        });
        btn_Nhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhanvienActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Danh Mục");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btn_listbooked.setBackground(new java.awt.Color(0, 102, 102));
        btn_listbooked.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_listbooked.setForeground(new java.awt.Color(204, 204, 204));
        btn_listbooked.setText("Chuyến Đi Đã Đặt");
        btn_listbooked.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_listbooked.setContentAreaFilled(false);
        btn_listbooked.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_listbooked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_listbookedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_listbookedMouseExited(evt);
            }
        });
        btn_listbooked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listbookedActionPerformed(evt);
            }
        });

        btn_listpayment.setBackground(new java.awt.Color(0, 102, 102));
        btn_listpayment.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_listpayment.setForeground(new java.awt.Color(204, 204, 204));
        btn_listpayment.setText("Thông Tin Thanh Toán");
        btn_listpayment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_listpayment.setContentAreaFilled(false);
        btn_listpayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_listpayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_listpaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_listpaymentMouseExited(evt);
            }
        });
        btn_listpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listpaymentActionPerformed(evt);
            }
        });

        btn_tourhdv.setBackground(new java.awt.Color(0, 102, 102));
        btn_tourhdv.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_tourhdv.setForeground(new java.awt.Color(204, 204, 204));
        btn_tourhdv.setText("Hành Trình HDV");
        btn_tourhdv.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_tourhdv.setContentAreaFilled(false);
        btn_tourhdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tourhdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tourhdvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tourhdvMouseExited(evt);
            }
        });
        btn_tourhdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tourhdvActionPerformed(evt);
            }
        });

        btn_tourdiemthamquan.setBackground(new java.awt.Color(0, 102, 102));
        btn_tourdiemthamquan.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        btn_tourdiemthamquan.setForeground(new java.awt.Color(204, 204, 204));
        btn_tourdiemthamquan.setText("Tham Quan Địa Danh");
        btn_tourdiemthamquan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        btn_tourdiemthamquan.setContentAreaFilled(false);
        btn_tourdiemthamquan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tourdiemthamquan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tourdiemthamquanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tourdiemthamquanMouseExited(evt);
            }
        });
        btn_tourdiemthamquan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tourdiemthamquanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frame_categoryLayout = new javax.swing.GroupLayout(frame_category);
        frame_category.setLayout(frame_categoryLayout);
        frame_categoryLayout.setHorizontalGroup(
            frame_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_categoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frame_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_khach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_diemtq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_listbooked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_listpayment, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addGroup(frame_categoryLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_booking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tourhdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tourdiemthamquan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btn_Nhanvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frame_categoryLayout.setVerticalGroup(
            frame_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_categoryLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btn_tour)
                .addGap(18, 18, 18)
                .addComponent(btn_khach)
                .addGap(18, 18, 18)
                .addComponent(btn_hdv)
                .addGap(18, 18, 18)
                .addComponent(btn_diemtq)
                .addGap(24, 24, 24)
                .addComponent(btn_Nhanvien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tourhdv)
                .addGap(18, 18, 18)
                .addComponent(btn_tourdiemthamquan)
                .addGap(18, 18, 18)
                .addComponent(btn_listbooked)
                .addGap(18, 18, 18)
                .addComponent(btn_listpayment)
                .addGap(18, 18, 18)
                .addComponent(btn_booking)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        MyDesktop.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(153, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dulichc#.png"))); // NOI18N

        MyDesktop.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MyDesktopLayout = new javax.swing.GroupLayout(MyDesktop);
        MyDesktop.setLayout(MyDesktopLayout);
        MyDesktopLayout.setHorizontalGroup(
            MyDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        MyDesktopLayout.setVerticalGroup(
            MyDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        nabar.setBackground(new java.awt.Color(76, 148, 189));

        Account.setForeground(new java.awt.Color(255, 255, 255));
        Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user_2.png"))); // NOI18N
        Account.setText("Tài Khoản");
        Account.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Account.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AccountMouseExited(evt);
            }
        });

        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/out.png"))); // NOI18N
        btn_logout.setText("Thoát");
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo_11.jpg"))); // NOI18N
        jLabel4.setText("DNC");

        javax.swing.GroupLayout nabarLayout = new javax.swing.GroupLayout(nabar);
        nabar.setLayout(nabarLayout);
        nabarLayout.setHorizontalGroup(
            nabarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nabarLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 845, Short.MAX_VALUE)
                .addComponent(Account)
                .addGap(48, 48, 48)
                .addComponent(btn_logout)
                .addGap(65, 65, 65))
        );
        nabarLayout.setVerticalGroup(
            nabarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nabarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nabarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nabarLayout.createSequentialGroup()
                        .addGroup(nabarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Account)
                            .addComponent(btn_logout))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nabarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())))
        );

        Account1.setBackground(new java.awt.Color(212, 234, 246));
        Account1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(0, 51, 102))); // NOI18N

        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("ID :");

        idLable.setForeground(new java.awt.Color(0, 51, 102));
        idLable.setText("1");

        nameLabel.setForeground(new java.awt.Color(0, 51, 102));
        nameLabel.setText("Đỗ Cường");

        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Họ và tên :");

        emailLabel.setForeground(new java.awt.Color(0, 51, 102));
        emailLabel.setText("C@gmail.com");

        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Email :");

        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Chức vụ :");

        roleLabel.setForeground(new java.awt.Color(0, 51, 102));
        roleLabel.setText("Quản lý");

        javax.swing.GroupLayout Account1Layout = new javax.swing.GroupLayout(Account1);
        Account1.setLayout(Account1Layout);
        Account1Layout.setHorizontalGroup(
            Account1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Account1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(Account1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Account1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63)
                        .addComponent(idLable, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Account1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(23, 23, 23)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Account1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45)
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Account1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Account1Layout.setVerticalGroup(
            Account1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Account1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Account1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(idLable))
                .addGap(17, 17, 17)
                .addGroup(Account1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(nameLabel))
                .addGap(12, 12, 12)
                .addGroup(Account1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Account1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7))
                    .addComponent(emailLabel))
                .addGap(17, 17, 17)
                .addGroup(Account1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(Account1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(roleLabel))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frame_category, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MyDesktop))
            .addComponent(nabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(1043, Short.MAX_VALUE)
                    .addComponent(Account1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frame_category, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(MyDesktop)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(Account1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(445, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_bookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bookingActionPerformed
        handleButtonClick("btn_booking");
    }//GEN-LAST:event_btn_bookingActionPerformed

    private void btn_diemtqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diemtqActionPerformed
        handleButtonClick("btn_diemtq");
    }//GEN-LAST:event_btn_diemtqActionPerformed

    private void btn_hdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hdvActionPerformed
        handleButtonClick("btn_hdv");
    }//GEN-LAST:event_btn_hdvActionPerformed

    private void btn_khachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khachActionPerformed
        handleButtonClick("btn_khach");
    }//GEN-LAST:event_btn_khachActionPerformed

    private void btn_tourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tourActionPerformed
        handleButtonClick("btn_tour");
    }//GEN-LAST:event_btn_tourActionPerformed

    private void btn_NhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhanvienActionPerformed
        handleButtonClick("btn_NhanVien");
    }//GEN-LAST:event_btn_NhanvienActionPerformed

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
        MainFrm Mainfrm = new MainFrm();
        Mainfrm.setVisible(true);
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_listbookedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listbookedActionPerformed
        handleButtonClick("btn_listbooked");
    }//GEN-LAST:event_btn_listbookedActionPerformed

    private void btn_listpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listpaymentActionPerformed
        handleButtonClick("btn_listpayment");
    }//GEN-LAST:event_btn_listpaymentActionPerformed

    private void btn_tourhdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tourhdvActionPerformed
        handleButtonClick("btn_tourhdv");
    }//GEN-LAST:event_btn_tourhdvActionPerformed

    private void btn_tourdiemthamquanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tourdiemthamquanActionPerformed
        handleButtonClick("btn_tourdiemthamquan");
    }//GEN-LAST:event_btn_tourdiemthamquanActionPerformed

    private void AccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountMouseClicked
            Account1.setVisible(!Account1.isVisible());
        
    }//GEN-LAST:event_AccountMouseClicked

    private void btn_tourMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tourMouseEntered
        btn_tour.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_tourMouseEntered

    private void btn_tourMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tourMouseExited
        btn_tour.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_tourMouseExited

    private void btn_khachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_khachMouseEntered
        btn_khach.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_khachMouseEntered

    private void btn_khachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_khachMouseExited
        btn_khach.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_khachMouseExited

    private void btn_hdvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hdvMouseEntered
        btn_hdv.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_hdvMouseEntered

    private void btn_hdvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hdvMouseExited
        btn_hdv.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_hdvMouseExited

    private void btn_diemtqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_diemtqMouseEntered
        btn_diemtq.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_diemtqMouseEntered

    private void btn_diemtqMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_diemtqMouseExited
        btn_diemtq.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_diemtqMouseExited

    private void btn_NhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NhanvienMouseClicked
        ///Bỏ thừa
    }//GEN-LAST:event_btn_NhanvienMouseClicked

    private void btn_NhanvienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NhanvienMouseEntered
       btn_Nhanvien.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_NhanvienMouseEntered

    private void btn_NhanvienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NhanvienMouseExited
        btn_Nhanvien.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_NhanvienMouseExited

    private void btn_tourhdvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tourhdvMouseEntered
        btn_tourhdv.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_tourhdvMouseEntered

    private void btn_tourhdvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tourhdvMouseExited
       btn_tourhdv.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_tourhdvMouseExited

    private void btn_tourdiemthamquanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tourdiemthamquanMouseEntered
        btn_tourdiemthamquan.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_tourdiemthamquanMouseEntered

    private void btn_tourdiemthamquanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tourdiemthamquanMouseExited
        btn_tourdiemthamquan.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_tourdiemthamquanMouseExited

    private void btn_listbookedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listbookedMouseEntered
        btn_listbooked.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_listbookedMouseEntered

    private void btn_listbookedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listbookedMouseExited
        btn_listbooked.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_listbookedMouseExited

    private void btn_listpaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listpaymentMouseEntered
        btn_listpayment.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_listpaymentMouseEntered

    private void btn_listpaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listpaymentMouseExited
        btn_listpayment.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_listpaymentMouseExited

    private void btn_bookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bookingMouseEntered
        btn_booking.setForeground(new Color(255, 255, 204));
    }//GEN-LAST:event_btn_bookingMouseEntered

    private void btn_bookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bookingMouseExited
        btn_booking.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_btn_bookingMouseExited

    private void AccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountMouseEntered
        Account.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_AccountMouseEntered

    private void AccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountMouseExited
        Account.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_AccountMouseExited

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        btn_logout.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        btn_logout.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btn_logoutMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Account;
    private javax.swing.JPanel Account1;
    private javax.swing.JDesktopPane MyDesktop;
    private javax.swing.JButton btn_Nhanvien;
    private javax.swing.JButton btn_booking;
    private javax.swing.JButton btn_diemtq;
    private javax.swing.JButton btn_hdv;
    private javax.swing.JButton btn_khach;
    private javax.swing.JButton btn_listbooked;
    private javax.swing.JButton btn_listpayment;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JButton btn_tour;
    private javax.swing.JButton btn_tourdiemthamquan;
    private javax.swing.JButton btn_tourhdv;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel frame_category;
    private javax.swing.JLabel idLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel nabar;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel roleLabel;
    // End of variables declaration//GEN-END:variables
}
