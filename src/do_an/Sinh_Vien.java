package do_an;

import java.io.Serializable;

public class Sinh_Vien implements Serializable{
    private String hoTen;
    private int tuoi;
    private String lop;

    public Sinh_Vien(String hoTen, int tuoi, String lop) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.lop = lop;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
     public int getTuoi() {
        return tuoi;
    }
public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public String getLop() {
        return lop;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
   @Override
    public String toString() {
        return "Họ tên = " + hoTen + ", Tuổi = " + tuoi + ", Lớp = " + lop ;
    }
     public  String ten (){
     String s=this.hoTen.trim();
     int x=s.lastIndexOf(" ");
     s=s.substring(x+1);
     return s;
 }
}
