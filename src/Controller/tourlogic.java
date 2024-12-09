/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javax.swing.*;
import java.util.List;
import javax.swing.*;
import java.util.List;
import Object.Tour;
import tour.QuanLyTourP;
import Control.DAO_Tour;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tour.QuanLyTour;
/**
 *
 * @author Dell
 */
public class tourlogic {
    private ArrayList<Tour> ListTour;
    DefaultTableModel model;
    
    
            
    private javax.swing.JTextField Entertext;
    private javax.swing.JButton RefreshTour;
    private javax.swing.JTable TableTour;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel btn_SearchTour;
    private javax.swing.JPanel frame_btnfunction;
    private javax.swing.JPanel frame_input;
    private javax.swing.JPanel frame_nav;
    private javax.swing.JScrollPane frame_tbdata;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaTour;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextField txtTenTour;
    
    public void showResult() {
        Tour t = ListTour.get(ListTour.size() - 1);
        model.addRow(new Object[]{
            t.getMaTour(), t.getTenTour(), t.getGia(), t.getNgayBd(), t.getNgayKt()
        });
    }
    public void showtable() {
        for (Tour t : ListTour) {
            model.addRow(new Object[]{t.getMaTour(), t.getTenTour(), t.getGia(), t.getNgayBd(), t.getNgayKt()});
        }
    }
    
    public tourlogic(javax.swing.JTextField Entertext, javax.swing.JTextField txtMaTour, javax.swing.JTextField txtTenTour, 
                     javax.swing.JTextField txtGia, com.toedter.calendar.JDateChooser txtNgayBD, 
                     com.toedter.calendar.JDateChooser txtNgayKT, DefaultTableModel model, 
                     javax.swing.JTable TableTour) {
        this.Entertext = Entertext;
        this.txtMaTour = txtMaTour;
        this.txtTenTour = txtTenTour;
        this.txtGia = txtGia;
        this.txtNgayBD = txtNgayBD;
        this.txtNgayKT = txtNgayKT;
        this.model = model;
        this.TableTour = TableTour;
        this.ListTour = new ArrayList<>();
    }
    
    public void clearInputFields() {
    txtMaTour.setText("");
    txtTenTour.setText("");
    txtGia.setText("");
    txtNgayBD.setDate(null);
    txtNgayKT.setDate(null);
    txtMaTour.requestFocus(); // Đưa con trỏ về trường mã tour
    }
    
    public void performSearch() {
        String keyword = Entertext.getText().trim(); // Lấy từ khóa tìm kiếm từ ô nhập
        try {
            ListTour = new DAO_Tour().searchTour(keyword); // Tìm kiếm tour
            model.setRowCount(0); // Xóa bảng hiện tại
            showtable(); // Cập nhật bảng với kết quả tìm kiếm
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm tour!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void add_logic_tour(){
        if (txtMaTour.getText().isEmpty() || txtTenTour.getText().isEmpty() || txtGia.getText().isEmpty()
                || txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Tour t = new Tour();
        t.setMaTour(txtMaTour.getText());
        t.setTenTour(txtTenTour.getText());

        // Kiểm tra và thiết lập giá trị cho giá tour
        try {
            double gia = Double.parseDouble(txtGia.getText());
            if (gia <= 0) {
                JOptionPane.showMessageDialog(null, "Giá tour phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            t.setGia(gia);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá tour không hợp lệ. Vui lòng nhập số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Định dạng ngày
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Lấy và định dạng ngày bắt đầu
            LocalDate ngaybd = LocalDate.parse(formatter.format(txtNgayBD.getDate()));
            t.setNgayBd(ngaybd);

            // Lấy và định dạng ngày kết thúc
            LocalDate ngaykt = LocalDate.parse(formatter.format(txtNgayKT.getDate()));
            t.setNgayKt(ngaykt);

            // Kiểm tra xem ngày kết thúc có sau ngày bắt đầu không
            if (ngaykt.isBefore(ngaybd)) {
                JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Thêm tour vào cơ sở dữ liệu
        try {
            if (new DAO_Tour().addTour(t)) {
                JOptionPane.showMessageDialog(null, "Thêm tour thành công");
                // Sau khi thêm thành công, thêm tour vào danh sách và xóa các trường nhập
                ListTour.add(t);
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "Không thể thêm tour", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        showResult();
    }
    
    public void update_logic_tour () throws SQLException {
        //đồng bộ số dòng trong db với table thì mới gán giá trị được
        ListTour = new DAO_Tour().getListTour();
        model = (DefaultTableModel) TableTour.getModel();
        
        int selectedRow = TableTour.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Tour để sửa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Thu thập dữ liệu từ các trường nhập liệu
        String maTour = txtMaTour.getText().trim();
        String tenTour = txtTenTour.getText().trim();
        String giaStr = txtGia.getText().trim();

        if (maTour.isEmpty() || tenTour.isEmpty() || giaStr.isEmpty() || txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Định dạng ngày
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Xác thực và chuyển đổi giá từ String sang double
        double gia;
        try {
            gia = Double.parseDouble(giaStr);
            if (gia <= 0) {
                JOptionPane.showMessageDialog(null, "Giá phải là số dương.", "Lỗi Giá", JOptionPane.ERROR_MESSAGE);
                txtGia.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá phải là số.", "Lỗi Giá", JOptionPane.ERROR_MESSAGE);
            txtGia.requestFocus();
            return;
        }

        // Xử lý ngày bắt đầu và ngày kết thúc
        LocalDate ngayBd = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(txtNgayBD.getDate()));
        LocalDate ngayKt = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(txtNgayKT.getDate()));

        if (ngayKt.isBefore(ngayBd)) {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc không thể trước ngày bắt đầu.", "Lỗi Ngày", JOptionPane.ERROR_MESSAGE);
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

        // Cập nhật đối tượng trong danh sách
        boolean isUpdated = DAO_Tour.updateTour(updatedTour);
        if (isUpdated) {
            // Cập nhật đối tượng trong danh sách và JTable
            ListTour.set(selectedRow, updatedTour);
            model.setValueAt(updatedTour.getMaTour(), selectedRow, 0);
            model.setValueAt(updatedTour.getTenTour(), selectedRow, 1);
            model.setValueAt(updatedTour.getGia(), selectedRow, 2);
            model.setValueAt(updatedTour.getNgayBd().format(formatter), selectedRow, 3);
            model.setValueAt(updatedTour.getNgayKt().format(formatter), selectedRow, 4);

            JOptionPane.showMessageDialog(null, "Sửa Tour thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            clearInputFields(); // Làm sạch các trường nhập liệu
        } else {
            JOptionPane.showMessageDialog(null, "Sửa Tour thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void delete_logic_tour() throws SQLException {
        ListTour = new DAO_Tour().getListTour();
        model = (DefaultTableModel) TableTour.getModel();
        
        int selectedRow = TableTour.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Tour để xóa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Xác nhận lại với người dùng trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa Tour này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Nếu người dùng chọn "No", dừng thao tác xóa
        }

        String maTour = model.getValueAt(selectedRow,0).toString();
        System.out.println("Mã Tour cần xóa: " + maTour);
        // Xóa tour khỏi danh sách ArrayList
        boolean isDeleted = new DAO_Tour().deleteTour(maTour);
        if (isDeleted) {
            // Xóa hàng khỏi JTable
            model.removeRow(selectedRow);
            // Xóa tour khỏi danh sách ArrayList
            ListTour.remove(selectedRow);
            // Hiển thị thông báo đã xóa thành công
            JOptionPane.showMessageDialog(null, "Xóa Tour thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Xóa Tour thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void refresh_tour(){
        clearInputFields();
        model.setRowCount(0);
        try {
            ListTour = new DAO_Tour().getListTour();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTourP.class.getName()).log(Level.SEVERE, null, ex);
        }
        showtable();
    }
}
