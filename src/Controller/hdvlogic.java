/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Object.HuongDanVien;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import Control.DAO_HuongDanVien;
import javax.swing.JOptionPane;
import tour.QuanLyHuongDanVienP;

/**
 *
 * @author Dell
 */
public class hdvlogic {
    private DefaultTableModel model;
    private java.util.List<HuongDanVien> ListHdv;
    
    private javax.swing.JTextField EnterSearchHdv;
    private javax.swing.JTextField txtCccd;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtMaHdv;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenHdv;
    private javax.swing.JTable TableHdv;
    
    public hdvlogic(javax.swing.JTextField EnterSearchHdv, javax.swing.JTextField txtCccd,
                    javax.swing.JTextField txtMaHdv, javax.swing.JTextField txtSdt,
                    javax.swing.JTextField txtDiachi, javax.swing.JTextField txtTenHdv, javax.swing.JTable TableHdv, DefaultTableModel model){
        this.EnterSearchHdv = EnterSearchHdv;
        this.ListHdv = ListHdv;
        this.TableHdv = TableHdv;
        this.model = model;
        this.txtCccd = txtCccd;
        this.txtMaHdv = txtMaHdv;
        this.txtSdt = txtSdt;
        this.txtDiachi = txtDiachi;
        this.txtTenHdv = txtTenHdv;
    }
    
    public void loadData() {
        model.setRowCount(0);
        for (HuongDanVien hdv : ListHdv) {
            model.addRow(new Object[]{hdv.getMaHdv(), hdv.getFullname(), hdv.getCccd(), hdv.getSdt(), hdv.getDiachi()});
        }
    }
    
    public void clearInputFields() {
        txtMaHdv.setText(""); // Xóa trường Mã hướng dẫn viên
        txtTenHdv.setText(""); // Xóa trường Tên hướng dẫn viên
        txtCccd.setText("");    // Xóa trường cccd
        txtSdt.setText("");
        txtDiachi.setText("");
        txtMaHdv.requestFocus();
    }
    
    public void refresh_hdv(){
        ListHdv = new DAO_HuongDanVien().getAllHuongDanVien();
        loadData();
        clearInputFields();
    }
    public void PerformSearchGuides() {
        // Lấy từ khóa tìm kiếm từ trường văn bản
        String keyword = EnterSearchHdv.getText().trim();

        // Tìm kiếm hướng dẫn viên dựa trên từ khóa
        ArrayList<HuongDanVien> guides = new DAO_HuongDanVien().searchGuide(keyword);

        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);

        // Kiểm tra kết quả tìm kiếm và cập nhật bảng
        if (guides.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào cho từ khóa: " + keyword, "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (HuongDanVien hdv : guides) {
                model.addRow(new Object[]{hdv.getMaHdv(), hdv.getFullname(), hdv.getCccd(),hdv.getSdt(), hdv.getDiachi()});
            }
        }
    }
    
    public void add_hdv_logic(){
        ListHdv = new DAO_HuongDanVien().getAllHuongDanVien();
        model = (DefaultTableModel) TableHdv.getModel();
        
        String maHdv = txtMaHdv.getText();
        String tenHdv = txtTenHdv.getText();
        String cccd = txtCccd.getText();
        String mail = txtSdt.getText();
        String pword = txtDiachi.getText();

        if (maHdv.isEmpty() || tenHdv.isEmpty() || cccd.isEmpty() || mail.isEmpty() || pword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin hướng dẫn viên!");
            return;
        }

        HuongDanVien hdv = new HuongDanVien(maHdv, tenHdv,cccd, mail, pword);
        boolean isAdded = new DAO_HuongDanVien().addHuongDanVien(hdv);
        if (isAdded) {
            ListHdv.add(hdv);
            loadData();
            JOptionPane.showMessageDialog(null, "Thêm hướng dẫn viên thành công!");
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm hướng dẫn viên thất bại!");
        }
    }
    
    public void update_hdv_logic(){
        ListHdv = new DAO_HuongDanVien().getAllHuongDanVien();
        model = (DefaultTableModel) TableHdv.getModel();
        
        int selectedRow = TableHdv.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hướng dẫn viên để sửa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Xác nhận lại với người dùng trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa HDV này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Nếu người dùng chọn "No", dừng thao tác xóa
        }
        
        String maHdv = txtMaHdv.getText();
        String tenHdv = txtTenHdv.getText();
        String cccd = txtCccd.getText();
        String mail = txtSdt.getText();
        String pword = txtDiachi.getText();

        if (tenHdv.isEmpty() || cccd.isEmpty() || mail.isEmpty() || pword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin hướng dẫn viên!");
            return;
        }

        HuongDanVien hdv = new HuongDanVien(maHdv, tenHdv, cccd, mail, pword);
        boolean isUpdated = new DAO_HuongDanVien().updateHuongDanVien(hdv);
        if (isUpdated) {
            model.setValueAt(maHdv, selectedRow, 0);
            model.setValueAt(tenHdv, selectedRow, 1);
            model.setValueAt(cccd, selectedRow, 2);
            model.setValueAt(mail, selectedRow, 3);
            model.setValueAt(pword, selectedRow, 4);
            JOptionPane.showMessageDialog(null, "Cập nhật hướng dẫn viên thành công!");
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật hướng dẫn viên thất bại!");
        }
    }
    
    public void delete_hdv_logic(){
        ListHdv = new DAO_HuongDanVien().getAllHuongDanVien();
        model = (DefaultTableModel) TableHdv.getModel();
        
        int selectedRow = TableHdv.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hướng dẫn viên để xóa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String maHdv = model.getValueAt(selectedRow, 0).toString();
        System.out.println("Mã hdv cần xóa: " + maHdv);
        boolean isDeleted = new DAO_HuongDanVien().deleteHuongDanVien(maHdv);
        if (isDeleted) {
            model.removeRow(selectedRow);
            ListHdv.remove(selectedRow);
            JOptionPane.showMessageDialog(null, "Xóa hướng dẫn viên thành công!");
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Xóa hướng dẫn viên thất bại!");
        }
    }
}
