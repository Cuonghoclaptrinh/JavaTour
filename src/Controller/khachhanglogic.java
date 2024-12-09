/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javax.swing.*;
import java.util.List;
import java.util.List;
import Object.KhachHang;
import tour.QuanLyKhachHangP;
import Control.DAO_KhachHang;
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

/**
 *
 * @author Dell
 */
public class khachhanglogic {
    private ArrayList<KhachHang> ListCustomer;
    DefaultTableModel model;
            
    private javax.swing.JTable TableKhachHang;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEnterKhachHang;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKh;
            
    public khachhanglogic( javax.swing.JTextField txtEnterKhachHang, javax.swing.JTextField txtTenKh,
                            javax.swing.JTextField txtSDT, javax.swing.JTextField txtMaKh,javax.swing.JTextField txtDiaChi,
                            javax.swing.JTextField txtCCCD, javax.swing.JTable TableKhachHang, DefaultTableModel model){
        this.model = model;
        this.txtCCCD = txtCCCD;
        this.txtDiaChi = txtDiaChi;
        this.TableKhachHang = TableKhachHang;
        this.txtEnterKhachHang = txtEnterKhachHang;
        this.txtMaKh = txtMaKh;
        this.txtSDT = txtSDT;
        this.txtTenKh = txtTenKh;
        this.ListCustomer = new ArrayList<>();
    }
    
    public void showResult() {
        KhachHang t = ListCustomer.get(ListCustomer.size() - 1);
        model.addRow(new Object[]{
            t.getMaKh(), t.getTenKh(), t.getSdt(), t.getCccd(), t.getDiaChi()
        });
    }
    public void loadData() {
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
    public void clearInputFields() {
        txtMaKh.setText("");
        txtTenKh.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtCCCD.setText("");
        txtMaKh.requestFocus();
    }
    
    public void performSearch() {
        String keyword = txtEnterKhachHang.getText().trim(); // Lấy từ khóa tìm kiếm từ ô nhập
        try {
            ListCustomer = new DAO_KhachHang().searchCustomer(keyword); // Tìm kiếm khách hàng
            model.setRowCount(0); // Xóa bảng hiện tại
            for (KhachHang kh : ListCustomer) {
                model.addRow(new Object[]{kh.getMaKh(), kh.getTenKh(), kh.getSdt(), kh.getCccd(), kh.getDiaChi()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm khách hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void add_kh_logic () {
        String MaKh = txtMaKh.getText();
        String TenKh = txtTenKh.getText();
        String Cccd = txtCCCD.getText();
        String DiaChi = txtDiaChi.getText();
        String Sdt = txtSDT.getText();
        
        if (MaKh.isEmpty() || TenKh.isEmpty() || Cccd.isEmpty() || DiaChi.isEmpty() || Sdt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        KhachHang Customer = new KhachHang(MaKh, TenKh, Sdt, Cccd, DiaChi);
        DAO_KhachHang CustomerDAO = new DAO_KhachHang();

        try {
            if (DAO_KhachHang.addKhachHang(Customer)) {
                ListCustomer.add(Customer);  // Thêm vào danh sách chỉ khi thành công
                JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
                showResult();
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm khác hàng");
        }
    }
    
    public void update_kh_logic(){
        ListCustomer = new DAO_KhachHang().getAllCustomers();
        model = (DefaultTableModel) TableKhachHang.getModel();
        
        int selectRow = TableKhachHang.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Tour để sửa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String makh = txtMaKh.getText();
        String tenKh = txtTenKh.getText();
        String sdt = txtSDT.getText();
        String cccd = txtCCCD.getText();
        String diaChi = txtDiaChi.getText();

        // Kiểm tra xem các trường có trống không
        if (tenKh.isEmpty() || sdt.isEmpty() || cccd.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin khách hàng!");
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
            JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công!");
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thất bại!");
        }
    }
    
    public void delete_kh_logic(){
        ListCustomer = new DAO_KhachHang().getAllCustomers();
        model = (DefaultTableModel) TableKhachHang.getModel();
        
        int selectedRow = TableKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng để xoá.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lấy mã khách hàng từ hàng được chọn
        String maKH = TableKhachHang.getValueAt(selectedRow, 0).toString();

        // Xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá khách hàng này?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DAO_KhachHang customerDAO = new DAO_KhachHang();
            boolean success = customerDAO.deleteCustomer(maKH);

            if (success) {
                ListCustomer.remove(selectedRow);
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Xoá khách hàng thành công.");
//                loadData(); // Cập nhật lại dữ liệu trong bảng sau khi xoá
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "Xoá khách hàng thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void refres_kh(){
        ListCustomer = new DAO_KhachHang().getAllCustomers();
        loadData();
        clearInputFields();
    }
    
    
    
    
}
