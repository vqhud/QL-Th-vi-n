package do_an;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuanLyThuVien implements Serializable{
    ArrayList<The> arr= new ArrayList<>();
    static String Red = "\u001b[31m";
     static String Green = "\u001b[32m";
         static String Black = "\u001b[30m";

    public QuanLyThuVien() {
    }

    public void set(ArrayList<The> mang){
        this.arr=mang;
    }
    public void them(The THE){
        arr.add(THE);
    }
    public int size(){
        return arr.size();
    }
   public boolean check(String kt){
        if (arr==null) return true;
        for(The x : arr){
            if (x.getMaPhieu().equals(kt)) return false;
        }
        return true;
    }
   public boolean checkmaSach(String kt){
       if  (arr==null) return true;
       for (The x:arr){
           if(x.getSach().getMaSach().equals(kt)) return false;
       }
       return true;
   }
  
    public void xoaMa(String ma){

       for (int i=0;i<arr.size();i++){
           if (arr.get(i).getMaPhieu().equals(ma)){
               arr.remove(i);
               break;
           }
       }
    }
    public void timKiemSach(String s){
        s=s.toLowerCase();
         int ok=0;
        for (The th:arr){
            if (th.getSach().getTenSach().toLowerCase().contains(s)){
                System.out.println(th.getSach());
                ok=1;
            }
        }
        if (ok==0){
            System.out.println("\n    Ten sach khong ton tai   \n");
        }
    }
    public ArrayList<The> getDS(){
        return this.arr;
    }
    public void timKiemTG(String s){
        int ok=0;
        s=s.toLowerCase();
        for (The th:arr){
            if (th.getSach().getTacGia().toLowerCase().contains(s)){
                System.out.println(th.getSach());
                ok=1;
            }
        }
        if (ok==0){
            System.out.println("\n    Ten tac gia khong ton tai   \n");
        }
    }
    public void sapXep(){
        Collections.sort(arr, new Comparator<The>(){
            @Override
            public int compare(The o1, The o2) {
                if (o1.getSinhVien().ten().compareTo(o2.getSinhVien().ten())<0 ) return -1;
                else return 1;
            }
            
        });
    }
    public void In(){
        Collections.sort(arr, new Comparator<The>(){
            @Override
            public int compare(The o1, The o2) {
                if (o1.getSinhVien().ten().compareTo(o2.getSinhVien().ten())<0 ) return -1;
                else return 1;
            }
            
        });
        
        for (int i=0;i<arr.size();i++){
            System.out.println(Green+ " Thong tin the "+(i+1)+Black);
            System.out.println(arr.get(i));
        }
    }
    public void ghiFile(){
        
        try {
            FileOutputStream os = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(arr);
            oos.close();
            os.close();
            System.out.println(Green+ "Ghi File thanh cong"+Black);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println(Red+ "Ghi File that bai"+Black);
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void docFile(){
        try {
            FileInputStream is = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            this.arr=(ArrayList<The>) ois.readObject();
            System.out.println(Green+"Doc FIle thanh cong"+Black);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyThuVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public The getThe(int i){
        return arr.get(i);
    }
}
