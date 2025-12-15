package com.example.session6.exercise03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise03 {
    static  Scanner sc = new Scanner(System.in);
    static ArrayList<String> danhSachBienSoXe = new ArrayList<>();
    public static void main(String[] args) {
    int choose;

    do {
      System.out.println("\n****************** QUẢN LÝ ĐIỂM SV ****************");
      System.out.println("1. Thêm các biển số xe");
      System.out.println("2. Hiển thị danh sách biển số xe");
      System.out.println("3. Tìm kiếm biển số xe");
      System.out.println("4. Tìm biển số xe theo mã tỉnh");
      System.out.println("5. Sắp xếp biển số xe tăng dần");
      System.out.println("6. Thoát");
      System.out.print("Mời bạn chọn: ");

      try {
        choose = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        choose = 0;
      }

      switch (choose) {
        case 1:
                    themBienSo();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    timKiemChinhXac();
                    break;
                case 4:
                    timKiemTheoMaTinh();
                    break;
                case 5:
                    sapXepBienSo();
                    break;

        case 6:
          System.out.println("Kết thúc chương trình.");
          break;

        default:
          System.out.println("Lựa chọn không hợp lệ!");
      }
    } while (choose != 6);

    sc.close();
    }

    public static void themBienSo() {
      String bienSoXe = "";
      Integer n = 0;

      System.out.println("Nhap vao so luong xe: ");
      try {
        n = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Vui long nhap vao so nguyen!");
        return;
      }
      String regex = "[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}";
      for (int i = 0; i < n; i++) {
        System.out.println("Nhap vao bien so xe: ");
        bienSoXe = sc.nextLine();
        if (Pattern.matches(regex, bienSoXe)) {
          
          danhSachBienSoXe.add(bienSoXe);
        } else {
          System.out.println("Nhap sai dinh dang bien so xe!!!");
          i--;
        }
      }
    }

    public static void hienThiDanhSach() {
      System.out.println("--- DANH SÁCH BIỂN SỐ XE ---");
        if (danhSachBienSoXe.isEmpty()) {
            System.out.println("(Danh sách trống)");
        } else {
            for (String bienSo : danhSachBienSoXe) {
                System.out.println(bienSo);
            }
        }
    }

    public static void timKiemChinhXac(){
      System.out.println("Nhap vao bien so xe can tim!");
      String timKiem = sc.nextLine().trim().toUpperCase();
      if (danhSachBienSoXe.contains(timKiem)) {
            System.out.println("Kết quả: Có tìm thấy biển số " + timKiem + " trong danh sách.");
        } else {
            System.out.println("Kết quả: Không tìm thấy biển số này.");
        }
    }

    public static void timKiemTheoMaTinh(){
      System.out.println("Nhap vao ma tinh can tim!");
      String maTinh = sc.nextLine().trim();
      boolean found = false;
      for (String bienSo : danhSachBienSoXe) {
        if (bienSo.startsWith(maTinh)) {
          System.out.println(bienSo);
                found = true;
        }
      }

      if (!found) {
            System.out.println("Không tìm thấy biển số nào thuộc tỉnh " + maTinh);
        }
    }

    public static void sapXepBienSo(){
      if(danhSachBienSoXe.isEmpty()){
        System.out.println("Danh sách trống!");
        return;
      } else {
        Collections.sort(danhSachBienSoXe);
        System.out.println("Danh sách sau khi sắp xếp: ");
        hienThiDanhSach();
      }
    }
}
