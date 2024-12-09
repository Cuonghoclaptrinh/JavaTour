/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Control.DAO_TourHDV;
import Object.TourHDV;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class tour_hdvlogic {
    private ArrayList<TourHDV> listTourHDV;
    private DefaultTableModel model;
    
    private javax.swing.JTable tableTourHDV;
    private javax.swing.JTextField txtMaHDV;
    private javax.swing.JTextField txtMaTour;
    private javax.swing.JTextField txtSearchHdv;
    
    public tour_hdvlogic(javax.swing.JTable tableTourHDV,javax.swing.JTextField txtMaHDV
                        , javax.swing.JTextField txtMaTour,javax.swing.JTextField txtSearchHdv, DefaultTableModel model){
        this.listTourHDV = new ArrayList<>();
        this.model = model;
        this.tableTourHDV = tableTourHDV;
        this.txtMaHDV = txtMaHDV;
        this.txtMaTour = txtMaTour;
        this.txtSearchHdv = txtSearchHdv;
    }
    
    public void loadData() {
        model.setRowCount(0); 
        listTourHDV = new DAO_TourHDV().getAllTourHDV();
        for (TourHDV th : listTourHDV) {
            model.addRow(new Object[]{th.getMaTour(), th.getMaHDV()});
        }
    }
    public void clear(){
        txtMaTour.setText("");
        txtMaHDV.setText("");
        txtSearchHdv.setText("");
        txtMaHDV.requestFocus();
    }
    
    public void refresh_tourhdv(){
        listTourHDV = new DAO_TourHDV().getAllTourHDV();
        loadData();
        clear();
    }
    
    public void performsearch(){
         String keyword = txtSearchHdv.getText().trim();

        // Kiểm tra đầu vào tìm kiếm
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã tour hoặc mã HDV để tìm kiếm.");
            return;
        }

        try {
            listTourHDV = new DAO_TourHDV().searchTourHDV(keyword);
            model.setRowCount(0);
            for (TourHDV th : listTourHDV) {
                model.addRow(new Object[]{th.getMaTour(), th.getMaHDV()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm HDV!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void add_tourhdv_logic(){
        String maTour = txtMaTour.getText().trim();
        String maHdv = txtMaHDV.getText().trim();

        // Kiểm tra điều kiện
        if (maTour.isEmpty() || maHdv.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin mã tour và mã HDV.");
            return;
        }

        // Thực hiện thêm nếu không có lỗi
        TourHDV newTourHDV = new TourHDV(maTour, maHdv);
        DAO_TourHDV dao = new DAO_TourHDV();

        if (dao.addTourHDV(newTourHDV)) {
            listTourHDV.add(newTourHDV);
            model.addRow(new Object[]{maTour, maHdv});
            JOptionPane.showMessageDialog(null, "Thêm HDV vào Tour thành công!");
            clear();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại. Kiểm tra mã tour và HDV.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update_tourhdv_logic(){
        listTourHDV = new DAO_TourHDV().getAllTourHDV();
        model = (DefaultTableModel) tableTourHDV.getModel();
        
        int selectedRow = tableTourHDV.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để cập nhật.");
            return;
        }

        String maTour = model.getValueAt(selectedRow, 0).toString();
        String oldMaHdv = model.getValueAt(selectedRow, 1).toString();
        String newMaHdv = txtMaHDV.getText().trim();

        // Kiểm tra đầu vào
        if (newMaHdv.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã HDV mới.");
            return;
        }

        DAO_TourHDV dao = new DAO_TourHDV();
        if (dao.updateTourHDV(maTour, oldMaHdv, newMaHdv)) {
            model.setValueAt(newMaHdv, selectedRow, 1);
            JOptionPane.showMessageDialog(null, "Cập nhật HDV cho Tour thành công!");
            clear();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete_tour_logic(){
        listTourHDV = new DAO_TourHDV().getAllTourHDV();
        model = (DefaultTableModel) tableTourHDV.getModel();
        
        int selectedRow = tableTourHDV.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa.");
            return;
        }

        String maTour = model.getValueAt(selectedRow, 0).toString();
        String maHdv = model.getValueAt(selectedRow, 1).toString();

        // Xác nhận trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa HDV này khỏi tour không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DAO_TourHDV dao = new DAO_TourHDV();
            if (dao.deleteTourHDV(maTour, maHdv)) {
                listTourHDV.remove(selectedRow);
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Xóa thành công.");
                clear();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
