/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Control.DAO_DiemThamQuan;
import Object.DiemThamQuan;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tour.QuanLyDiemThamQuan;

/**
 *
 * @author Dell
 */
public class DTQlogic {
    private ArrayList<DiemThamQuan> ListAttraction;
    DefaultTableModel model;
    
    private javax.swing.JTextField txtDiaChiDiemThamQuan;
    private javax.swing.JTextField txtMaDiemThamQuan;
    private javax.swing.JTextField txtTenDiemThamQuan;
    private javax.swing.JTextField EnterDtq;
    private javax.swing.JTable TableDiemThamQuan;
    
    public DTQlogic(javax.swing.JTextField txtDiaChiDiemThamQuan, javax.swing.JTextField txtMaDiemThamQuan
                    ,javax.swing.JTextField txtTenDiemThamQuan,javax.swing.JTextField EnterDtq,
                    javax.swing.JTable TableDiemThamQuan, DefaultTableModel model){
        this.EnterDtq = EnterDtq;
        this.ListAttraction = new ArrayList<>();
        this.model = model;
        this.TableDiemThamQuan = TableDiemThamQuan;
        this.txtDiaChiDiemThamQuan = txtDiaChiDiemThamQuan;
        this.txtMaDiemThamQuan = txtMaDiemThamQuan;
        this.txtTenDiemThamQuan = txtTenDiemThamQuan;
    }
    
    public void loadData() {
        model.setRowCount(0); 
        ListAttraction = new DAO_DiemThamQuan().getAllDiemThamQuan();
        for (DiemThamQuan dtq : ListAttraction) {
            model.addRow(new Object[]{dtq.getMaDiemThamQuan(), dtq.getTenDiaDiem(), dtq.getDiaChi()});
            clearInputFields();
        }
    }

    public void clearInputFields() {
        txtMaDiemThamQuan.setText("");
        txtTenDiemThamQuan.setText("");
        txtDiaChiDiemThamQuan.setText("");
        txtMaDiemThamQuan.requestFocus();

    }
    
    public void refreshDtqList() {
           ListAttraction = new DAO_DiemThamQuan().getAllDiemThamQuan();
           loadData();
           clearInputFields();
    }

    public void performSearchAttraction() {
        String keyword = EnterDtq.getText().trim(); // Lấy từ khóa tìm kiếm
        try {
            ListAttraction = new DAO_DiemThamQuan().searchDiemThamQuan(keyword); // Tìm kiếm điểm tham quan
            model.setRowCount(0); // Xóa bảng hiện tại
            for (DiemThamQuan dtq : ListAttraction) {
                model.addRow(new Object[]{dtq.getMaDiemThamQuan(), dtq.getTenDiaDiem(), dtq.getDiaChi()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm điểm tham quan!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void add_dtq_logic(){
        ListAttraction = new DAO_DiemThamQuan().getAllDiemThamQuan();
        model = (DefaultTableModel) TableDiemThamQuan.getModel();
        
        String maDiemThamQuan = txtMaDiemThamQuan.getText(); // Lấy mã điểm tham quan từ ô nhập
        String tenDiaDiem = txtTenDiemThamQuan.getText(); // Lấy tên điểm tham quan từ ô nhập
        String diaChi = txtDiaChiDiemThamQuan.getText(); // Lấy địa chỉ từ ô nhập
        
        if (maDiemThamQuan.isEmpty() || tenDiaDiem.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DiemThamQuan dtq = new DiemThamQuan(maDiemThamQuan, tenDiaDiem, diaChi);
        DAO_DiemThamQuan dao = new DAO_DiemThamQuan();

        try {
            if (dao.addDiemThamQuan(dtq)) {
            ListAttraction.add(dtq);
            JOptionPane.showMessageDialog(null, "Thêm điểm tham quan thành công!");
            loadData();
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm điểm tham quan thất bại!");
            return;
        }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm khác hàng");
        }
    }
    
    public void update_dtq_logic(){
        ListAttraction = new DAO_DiemThamQuan().getAllDiemThamQuan();
        model = (DefaultTableModel) TableDiemThamQuan.getModel();
         
        int selectRow = TableDiemThamQuan.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một điểm tham quan để sửa.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String maDiemThamQuan = txtMaDiemThamQuan.getText(); // Mã điểm tham quan
        String tenDiaDiem = txtTenDiemThamQuan.getText(); // Tên điểm tham quan
        String diaChi = txtDiaChiDiemThamQuan.getText();

        // Kiểm tra xem các trường có trống không
        if (tenDiaDiem.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin điểm tham quan!");
            return;
        }
        
        DiemThamQuan nv = new DiemThamQuan(maDiemThamQuan, tenDiaDiem, diaChi);
        boolean isUpdate = new DAO_DiemThamQuan().updateDiemThamQuan(nv);
        if (isUpdate) {
            model.setValueAt(maDiemThamQuan, selectRow, 0);
            model.setValueAt(tenDiaDiem, selectRow, 1);
            model.setValueAt(diaChi, selectRow, 2);
            
            JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công!");
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thất bại!");
        }
    }
    
    public void delete_dtq_logic(){
        ListAttraction = new DAO_DiemThamQuan().getAllDiemThamQuan();
        model = (DefaultTableModel) TableDiemThamQuan.getModel();
        
        int selectedRow = TableDiemThamQuan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một điểm tham quan để xoá.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lấy mã khách hàng từ hàng được chọn
        String madiemthamquan = TableDiemThamQuan.getValueAt(selectedRow, 0).toString();

        // Xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá điểm tham quan này?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DAO_DiemThamQuan customerDAO = new DAO_DiemThamQuan();
            boolean success = customerDAO.deleteDiemThamQuan(madiemthamquan);

            if (success) {
                ListAttraction.remove(selectedRow);
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Xoá điểm tham quan thành công.");
                loadData(); // Cập nhật lại dữ liệu trong bảng sau khi xoá
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(null, "Xoá điểm tham quan thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
