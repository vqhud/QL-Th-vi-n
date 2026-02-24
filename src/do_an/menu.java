
package do_an;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 
public class menu {
       public static String Red = "\u001b[31m";
      public static String Black = "\u001b[30m";
      public static String Green = "\u001b[32m";
     public static String chuanHoaTen() {
         String ten=sc.nextLine();
         if (!isValidName(ten)) 
         {
             System.out.println(Green+"\tCHUOI BI LOI"+Black);
             return chuanHoaTen();}
    String[] arr = ten.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (String s : arr) {
        if (s.length() > 0) {
            sb.append(Character.toUpperCase(s.charAt(0)));
            sb.append(s.substring(1).toLowerCase());
            sb.append(" ");
        }
    }
    return sb.toString().trim();
}
     public static String chuanHoaTenSach() {
         String ten=sc.nextLine();
        
    String[] arr = ten.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (String s : arr) {
        if (s.length() > 0) {
            sb.append(Character.toUpperCase(s.charAt(0)));
            sb.append(s.substring(1).toLowerCase());
            sb.append(" ");
        }
    }
    return sb.toString().trim();
}
     public static boolean isValidName(String name) {
    for (int i = 0; i < name.length(); i++) {
        char c = name.charAt(i);
        if (isSpecialCharacter(c)) {
            return false;
        }
    }

    return true;
}

public static boolean isSpecialCharacter(char c) {
    
    return !(Character.isLetter(c) || Character.isWhitespace(c));
}
     public static int nhapXuat(){
         int nhap=0;
         try {
              nhap=Integer.parseInt(sc.nextLine());
              if (nhap<0){
                  System.out.println(Green+"\t TUOI PHAI >0"+Black);
                  return nhapXuat();
              }
         } catch (Exception e) {
             System.out.println(Red+"=== NHAP SAI DINH DANG ==="+Black);
             System.out.println(Green+ "\t Nhap lai nao:) "+Black);
              return nhapXuat();
         }
         return  nhap;

     }
     public static boolean isValidDateFormat(String input) {
        // Định dạng regex cho "dd/mm/yyyy"
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";

        // Tạo đối tượng Pattern
        Pattern pattern = Pattern.compile(regex);

        // Tạo đối tượng Matcher
        Matcher matcher = pattern.matcher(input);

        // Kiểm tra xem chuỗi có khớp với regex hay không
        if (!matcher.matches()) {
            return false;
        }

        // Kiểm tra năm nhuận
        int day = Integer.parseInt(matcher.group(1));
        int month = Integer.parseInt(matcher.group(2));
        int year = Integer.parseInt(matcher.group(3));

        if (month == 2) {
            // Kiểm tra tháng 2 có nằm trong khoảng 1-29 ngày (nếu là năm nhuận)
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return day >= 1 && day <= 29;
            } else {
                return day >= 1 && day <= 28;
            }
        }

        return true;
    }
     public static String ngay(){
         String s=sc.nextLine();
         if (!isValidDateFormat(s)){
             System.out.println(Green+"\t! NHAP SAI DINH DANG ROI NHE!"+Black);
             return ngay();
         }
         return s;
     }
     public static boolean compareDates(String date1, String date2) throws ParseException {
        // Định dạng ngày tháng
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Chuyển đổi chuỗi ngày tháng thành đối tượng Date
        Date dateObj1 = sdf.parse(date1);
        Date dateObj2 = sdf.parse(date2);

        // So sánh hai đối tượng Date
        return dateObj1.before(dateObj2);
    }
     public static boolean checkbf(String a, String b){
         try {
             boolean res=compareDates(a, b);
             return res;
         } catch (Exception e) {
         }
         return false;
     }
     public static String ngayTra(){
            String s=sc.nextLine();
         if (!isValidDateFormat(s)){
             System.out.println(Green+"\t! NHAP SAI DINH DANG ROI NHE!"+Black);
             return ngay();
         }
         if (!checkbf(ngayMuon,s)){
             System.out.println(Green+"\t! NGAY TRA PHAI SAU NGAY MUON !"+Black);
             return ngayTra();
         
         }
         return s;
     }
 
         public static String ngayMuon;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int luaChon=0;
        QuanLyThuVien ds = new QuanLyThuVien();
        while(true){
            Menu();
            System.out.println("Ban hay nhap lua chon : ");
            try {
                 luaChon=Integer.parseInt(sc.nextLine());
            
           
            if (luaChon==1)
            {
                String maPhieu;
                int ck=1;
                do{
                   ck=1;
                   System.out.println("Nhap vao ma phieu");
                 maPhieu=sc.nextLine();
                if(!ds.check(maPhieu)){
               System.out.println(Red+ "!!! Ma phieu da ton tai !!!"+Black
               );
               
               ck=0;
                }
                    
                }while(ck==0);
                System.out.println("Nhap vao ten hoc sinh: ");
                String name=chuanHoaTen();
                
                System.out.println("Nhap vao tuoi: ");
                int tuoi= nhapXuat();
                
                System.out.println("Nhap vao lop: ");
                String lop=sc.nextLine();
                
                Sinh_Vien student= new Sinh_Vien(name, tuoi, lop);
                System.out.println("Nhap vao ngay muon (DD/MM/YYYY): ");
                 ngayMuon=ngay();
                 System.out.println("Nhap vao ngay tra (DD/MM/YYYY): ");
                String ngayTra=ngayTra();
                
                String maSach;
                 ck=1;
                do{
                   ck=1;
                System.out.println("Nhap vao ma sach");
                 maSach=sc.nextLine();
                if(!ds.checkmaSach(maSach)){
               System.out.println(Red+ "!!! Ma phieu da ton tai !!!"+Black
               );
               
               ck=0;
                }
                    
                }while(ck==0);
                
                
                System.out.println("Nhap vao ten sach: ");
                String tenSach= chuanHoaTenSach();
                
                System.out.println("Nhap vao ten tac gia: ");
                String tenTG= chuanHoaTen();
                
                sach sach_new = new sach(maSach, tenSach, tenTG);
               
               The the_new= new The(maPhieu, ngayMuon, ngayTra, sach_new, student);
                ds.them(the_new);
            }else if(luaChon==2){
                if (ds.size()==0){
                    System.out.println(Green+"\t Danh sach rong"+Black);
                }else {
                    System.out.println("Nhap vao ma phieu can xoa : ");
                     String ma= sc.nextLine();
                if (!ds.check(ma)){
                 
                    ds.xoaMa(ma);
                    System.out.println(Green+"\t XOA THANH CONG "+Black);
                }else {
                    System.out.println(Red+"!!! Ma khong ton tai !!!"+Black);
                }
                }
             }else if (luaChon==3){
                System.out.println("Nhap vao ten sach : ");
                String ten=sc.nextLine();
                
                ds.timKiemSach(ten);
            }else if (luaChon==4){
                System.out.println("Nhap vao ten tac gia: ");
                String ten= chuanHoaTen();
           
                ds.timKiemTG(ten);
            }else if(luaChon==5){
                if (ds.size()==0){
                    System.out.println(Green+" \t Danh sach rong"+Black);
                }else
                ds.In();
            }else if (luaChon==6){

ds.ghiFile();
            }else if (luaChon==7){

                ds.docFile();
            }else if (luaChon==8)
            {System.out.println(Green+"\t Hen gap lai !!!"+Black); return;}
            else System.out.println(Green+"\t Nhap tu 1 -> 8"+Black);
            } catch (Exception e) {
                System.out.println("\n"+Red+ "!!  Nhap so tu nhien !! "+"\n"+Black);  
            }
        }
    }
    public static void Menu(){
        System.out.println(Red+ "===== WELCOME ======"+Black);
        System.out.println("1.0 Them phieu muon");
        System.out.println("2.0 Xoa phieu muon");
        System.out.println("3.0 Tim sach theo ten sach");
        System.out.println("4.0 Tim sach theo ten tac gia ");
        System.out.println("5.0 In thong tin cac the muon");
        System.out.println("6.0 Ghi xuong File");
        System.out.println("7.0 Doc tu File");
        System.out.println("8.0 Thoat Chuong Trinh ");
         System.out.println(Red+ "===================="+Black);
        
    } 
}
