package com.example.session6.exercise02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choose;
    String fullName = "", email= "", phone= "", password= "";

    do {
      System.out.println("\n****************** QUẢN LÝ ĐIỂM SV ****************");
      System.out.println("1. Nhập thông tin người dùng");
      System.out.println("2. Chuẩn hóa họ tên");
      System.out.println("3. Kiểm tra email hợp lệ");
      System.out.println("4. Kiểm tra số điện thoại hợp lệ");
      System.out.println("5. Kiểm tra mật khẩu hợp lệ");
      System.out.println("6. Thoát");
      System.out.print("Mời bạn chọn: ");
      // Thông tin người dùng gồm: Họ và tên, email, điện thoại và mật khẩu
      // Số điện thoại có định dạng số điện thoại di động tại Việt Nam
      // Email có định dạng email theo quy định
      // Mật khẩu có tối thiểu 8 ký tự, gồm ký tự anphabet viết thường, viết hoa, ký
      // tự số và ký tự đặc biệt
      try {
        choose = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        choose = 0;
      }

      switch (choose) {
        case 1:
          System.out.print("Nhập thông tin người dùng: ");

          System.out.print("Họ và tên: ");
          fullName = sc.nextLine();
          System.out.print("Email: ");
          email = sc.nextLine();
          System.out.print("Số điện thoại: ");
          phone = sc.nextLine();
          System.out.print("Mật khẩu: ");
          password = sc.nextLine();
          break;

        case 2:
          System.out.println("--- Chuẩn hóa họ tên ---");
          if(fullName.isEmpty())
          {
            System.out.println("Chưa nhập thông tin!");
          } else {
            fullName = fullName.trim().toLowerCase();
            String[] words = fullName.split(" ");
            String fullNameStandard = "";
            for (String word : words) {
              fullNameStandard += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
            }
            System.out.println("Họ tên chuẩn: " + fullNameStandard);  
          }
          break;

        case 3:
          System.out.println("Kiểm tra email hợp lệ");
          if (email.isEmpty()) {
            System.out.println("Chưa nhập thông tin!");
          } else {
            if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
              System.out.println("Email hợp lệ!");
            } else {
              System.out.println("Email không hợp lệ!");
            }
          }

          break;

        case 4:
          System.out.println("Kiểm tra số điện thoại hợp lệ!");
          if (phone.isEmpty()) {
            System.out.println("Chưa nhập thông tin!");
          } else {
            if (phone.matches("^0\\d{9}$")) {
              System.out.println("Số điện thoại hợp lệ!");
            } else {
              System.out.println("Số điện thoại không hợp lệ!");
            }
          }
          break;

        case 5:
          System.out.println("Kiểm tra mật khẩu hợp lệ");
          if (password.isEmpty()) {
            System.out.println("Chưa nhập thông tin!");
          } else {
            if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
              System.out.println("Mật khẩu hợp lệ!");
            } else {
              System.out.println("Mật khẩu không hợp lệ!");
            }
          }
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
}
