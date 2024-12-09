/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

public class TourDTQ {
    private String maTour;
    private String maDiemThamQuan;

    // Constructor
    public TourDTQ(){}
    public TourDTQ(String maTour, String maDiemThamQuan) {
        this.maTour = maTour;
        this.maDiemThamQuan = maDiemThamQuan;
    }

    // Getters và Setters
    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getMaDTQ() {
        return maDiemThamQuan;
    }

    public void getMaDTQ(String maDiemThamQuan) {
        this.maDiemThamQuan = maDiemThamQuan;
    }
}
