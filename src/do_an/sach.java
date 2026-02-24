package do_an;

import java.io.Serializable;


public class sach implements Serializable{
    private String maSach,tenSach,tacGia;

    public sach(String maSach, String tenSach, String tacGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    @Override
    public String toString() {
        return  "Ma sach = " + maSach + ", Ten sach = " + tenSach + ", Tac gia= " + tacGia ;
    } 
    
    
}
