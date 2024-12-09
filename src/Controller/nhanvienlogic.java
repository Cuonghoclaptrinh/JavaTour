/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Object.NhanVien;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import Control.DAO_NhanVien;
import javax.swing.JOptionPane;
import tour.QuanLyNhanVien;
/**
 *
 * @author Dell
 */
public class nhanvienlogic {
    private ArrayList<NhanVien> ListNhanVien;
    DefaultTableModel model;
    
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JTextField txt_chucvu;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_mail3;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_tennv;
    private javax.swing.JTextField EnterNhanVien;
    private javax.swing.JTable TableNhanVien;
    
    public nhanvienlogic(javax.swing.JTextField txt_cccd,javax.swing.JTextField txt_chucvu,
                        javax.swing.JTextField txt_id, javax.swing.JTextField txt_mail3,
                        javax.swing.JTextField txt_pass, javax.swing.JTextField txt_tennv
                        , javax.swing.JTextField EnterNhanVien, javax.swing.JTable TableNhanVien,DefaultTableModel model){
        this.EnterNhanVien = EnterNhanVien;
        this.ListNhanVien = ListNhanVien;
        this.TableNhanVien = TableNhanVien;
        this.model = model;
        this.txt_cccd = txt_cccd;
        this.txt_chucvu = txt_chucvu;
        this.txt_id = txt_id;
        this.txt_mail3 = txt_mail3;
        this.txt_pass = txt_pass;
        this.txt_tennv = txt_tennv;
    }
    
    public void showtable() {
        model.setRowCount(0);
        for (NhanVien customer : ListNhanVien) {
            model.addRow(new Object[]{
                customer.getId(),
                customer.getFullname(),
                customer.getCccd(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getChucvu()
            });
        }
    }

    public void clearInputFields() {
        txt_id.setText("");
        txt_tennv.setText("");
        txt_pass.setText("");
        txt_mail3.setText("");
        txt_chucvu.setText("");
        txt_cccd.setText("");
        txt_id.requestFocus(); // Đưa con trỏ về trường mã tour
    }
    
    public void performSearch() {
        String keyword = EnterNhanVien.getText().trim(); // Lấy từ khóa tìm kiếm từ ô nhập
        try {
            ListNhanVien = new DAO_NhanVien().searchNhanVien(keyword); // Tìm kiếm khách hàng
            model.setRowCount(0); // Xóa bảng hiện tại
            for (NhanVien kh : ListNhanVien) {
                model.addRow(new Object[]{kh.getId(), kh.getFullname(), kh.getCccd(), kh.getEmail(), kh.getPassword(), kh.getChucvu()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm Nhân Viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void showResult() {
        NhanVien t = ListNhanVien.get(ListNhanVien.size() - 1);
        model.addRow(new Object[]{
            t.getId(), t.getFullname(), t.getCccd(), t.getEmail(), t.getPassword(), t.getChucvu()
        });
    }
    
    public void refresh_nv(){
        ListNhanVien = new DAO_NhanVien().getAllNhanVien();
        showtable();
        clearInputFields();
    }
    
    public void add_nv_logic(){
        ListNhanVien = new DAO_NhanVien().getAllNhanVien();
        model = (DefaultTableModel) TableNhanVien.getModel();
        
        String id = txt_id.getText();
        String tennv = txt_tennv.getText();
        String cccd = txt_cccd.getText();
        String email = txt_mail3.getText();
        String pass = txt_pass.getText();
        String chucvu = txt_chucvu.getText();
        
        if (id.isEmpty() || tennv.isEmpty() || cccd.isEmpty() || email.isEmpty() || pass.isEmpty() || chucvu.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        NhanVien nv = new NhanVien(id, tennv, cccd, email, pass, chucvu);
        DAO_NhanVien nvDAO = new DAO_NhanVien();

        try {
            if (DAO_NhanVien.addNhanVien(nv)) {
                ListNhanVien.add(nv);  
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
                showResult();
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm khác hàng");
        }
    }
    
    public void update_nv_logic(){
        ListNhanVien = new DAO_NhanVien().getAllNhanVien();
        model = (DefaultTableModel) TableNhanVien.getModel();
        
        int selectRow = TableNhanVien.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Nhân Viên để sửa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = txt_id.getText();
        String tennv = txt_tennv.getText();
        String cccd = txt_cccd.getText();
        String email = txt_mail3.getText();
        String pass = txt_pass.getText();
        String chucvu = txt_chucvu.getText();

        // Kiểm tra xem các trường có trống không
        if (id.isEmpty() || tennv.isEmpty() || cccd.isEmpty() || email.isEmpty() || pass.isEmpty() || chucvu.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin nhân viên!");
            return;
        }

        NhanVien nv = new NhanVien(id, tennv, cccd, email, pass, chucvu);
        boolean isUpdate = new DAO_NhanVien().UpdateNhanVien(nv);
        if (isUpdate) {
            model.setValueAt(id, selectRow, 0);
            model.setValueAt(tennv, selectRow, 1);
            model.setValueAt(cccd, selectRow, 2);
            model.setValueAt(email, selectRow, 3);
            model.setValueAt(pass, selectRow, 4);
            model.setValueAt(chucvu, selectRow, 5);
            
            JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công!");
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thất bại!");
        }
    }
    
    public void delete_nv_logic(){
        ListNhanVien = new DAO_NhanVien().getAllNhanVien();
        model = (DefaultTableModel) TableNhanVien.getModel();
        
        int selectedRow = TableNhanVien.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên để xoá.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lấy mã khách hàng từ hàng được chọn
        String id = TableNhanVien.getValueAt(selectedRow, 0).toString();

        // Xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá nhân viên này?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DAO_NhanVien customerDAO = new DAO_NhanVien();
            boolean success = customerDAO.deleteNhanVien(id);

            if (success) {
                ListNhanVien.remove(selectedRow);
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Xoá nhân viên thành công.");
                showtable(); // Cập nhật lại dữ liệu trong bảng sau khi xoá
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "Xoá nhân viên thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
