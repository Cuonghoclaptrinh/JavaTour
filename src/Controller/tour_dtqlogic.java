/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Control.DAO_TourDTQ;
import Object.TourDTQ;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class tour_dtqlogic {
    private ArrayList<TourDTQ> listTourDTQ;
    private DefaultTableModel model;
    
    private javax.swing.JTable tableTourDTQ;
    private javax.swing.JTextField txtMaDTQ;
    private javax.swing.JTextField txtMaTour;
    private javax.swing.JTextField txtSearchDTQ;
    
    public tour_dtqlogic(javax.swing.JTable tableTourDTQ, javax.swing.JTextField txtMaDTQ,
                        javax.swing.JTextField txtMaTour,javax.swing.JTextField txtSearchDTQ, DefaultTableModel model){
        this.listTourDTQ = new ArrayList<>();
        this.model = model;
        this.tableTourDTQ = tableTourDTQ;
        this.txtMaDTQ = txtMaDTQ;
        this.txtMaTour = txtMaTour;
        this.txtSearchDTQ = txtSearchDTQ;
    }
    
    public void loadData() {
        model.setRowCount(0); // Xóa dữ liệu cũ
        listTourDTQ =new DAO_TourDTQ().getAllTourDTQ();
        for (TourDTQ tdq : listTourDTQ) {
            model.addRow(new Object[]{tdq.getMaTour(), tdq.getMaDTQ()});
        }
    }
    
    public void clear(){
        txtMaTour.setText("");
        txtMaDTQ.setText("");
        txtMaTour.requestFocus();
    }
    
    public void refresh_tourdtq(){
        listTourDTQ = new DAO_TourDTQ().getAllTourDTQ();
        loadData();
        clear();
    }
    public void performsearch(){
         // Lấy từ khóa tìm kiếm từ txtSearchDTQ
        String keyword = txtSearchDTQ.getText().trim();

        // Kiểm tra đầu vào tìm kiếm
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã tour hoặc mã điểm tham quan để tìm kiếm.");
            return;
        }

        try {
            // Tìm kiếm từ khóa trong cơ sở dữ liệu qua DAO
            listTourDTQ = new DAO_TourDTQ().searchTourDTQ(keyword);

            // Xóa dữ liệu cũ trong bảng
            model.setRowCount(0);

            // Kiểm tra nếu không có kết quả tìm kiếm nào
            if (listTourDTQ.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào!");
            } else {
                // Thêm dữ liệu vào bảng
                for (TourDTQ tdq : listTourDTQ) {
                    model.addRow(new Object[]{tdq.getMaTour(), tdq.getMaDTQ()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm điểm tham quan!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void add_tourdtq_logic(){
        String maTour = txtMaTour.getText();
        String maDiemThamQuan = txtMaDTQ.getText();
        TourDTQ tourDTQ = new TourDTQ(maTour, maDiemThamQuan);
        
        if (maTour.isEmpty() || maDiemThamQuan.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (new DAO_TourDTQ().addTourDiemThamQuan(tourDTQ)) {
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
            listTourDTQ.add(tourDTQ);
            loadData();
            clear();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
        }
    }
    
    public void update_tourdtq_logic(){
        listTourDTQ = new DAO_TourDTQ().getAllTourDTQ();
        model = (DefaultTableModel) tableTourDTQ.getModel();
        
        String maTour = txtMaTour.getText();
        String maDiemThamQuan = txtMaDTQ.getText();
        TourDTQ tourDTQ = new TourDTQ(maTour, maDiemThamQuan);
        
        if (maTour.isEmpty() || maDiemThamQuan.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (new DAO_TourDTQ().updateTourDiemThamQuan(tourDTQ)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            loadData();
            clear();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
        }
    }
    
    public void delete_tourdtq_logic(){
        listTourDTQ = new DAO_TourDTQ().getAllTourDTQ();
        model = (DefaultTableModel) tableTourDTQ.getModel();
        
        String maTour = txtMaTour.getText();
        String maDiemThamQuan = txtMaDTQ.getText();
        
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (new DAO_TourDTQ().deleteTourDiemThamQuan(maTour, maDiemThamQuan)) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                loadData();
                clear();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
            }
        }
    }

}
