package do_an;

import java.io.Serializable;

public class The implements Serializable {
    private String maPhieu;
    private String ngayMuon,ngayTra;
    private sach Sach;
    private Sinh_Vien sinhVien;

    public The(String maPhieu, String ngayMuon,String ngayTra, sach Sach, Sinh_Vien sinhVien) {
        this.maPhieu = maPhieu;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.Sach = Sach;
        this.sinhVien = sinhVien;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public sach getSach() {
        return Sach;
    }

    public void setSach(sach Sach) {
        this.Sach = Sach;
    }

    public Sinh_Vien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(Sinh_Vien sinhVien) {
        this.sinhVien = sinhVien;
    }

    @Override
    public String toString() {
        return  "Ma phieu = " + maPhieu + ", Ngay muon = " + ngayMuon + ", Ngay tra = " + ngayTra +" \nSACH : " +  Sach + " \nSINH VIEN: "+ sinhVien ;
    }

  
    
}
