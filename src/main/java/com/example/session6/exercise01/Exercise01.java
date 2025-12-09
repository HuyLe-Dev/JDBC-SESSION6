package com.example.session6.exercise01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise01 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choose;
    ArrayList<Double> marks = new ArrayList<>();

    do {
      System.out.println("\n****************** QUẢN LÝ ĐIỂM SV ****************");
      System.out.println("1. Nhập danh sách điểm sinh viên");
      System.out.println("2. In danh sách điểm");
      System.out.println("3. Tính điểm trung bình");
      System.out.println("4. Tìm điểm cao nhất và thấp nhất");
      System.out.println("5. Đếm số lượng ĐẠT và TRƯỢT");
      System.out.println("6. Sắp xếp điểm tăng dần");
      System.out.println("7. Thống kê GIỎI và XUẤT SẮC");
      System.out.println("8. Thoát");
      System.out.print("Mời bạn chọn: ");

      try {
        choose = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        choose = 0;
      }

      switch (choose) {
        case 1:
          System.out.print("Nhập điểm (nhập số âm để dừng nhập): ");

          while (true) {
            try {
              String inputStr = sc.nextLine();
              double val = Double.parseDouble(inputStr);
              if (val < 0)
                break;
              if (val > 10) {
                System.out.println("Điểm không hợp lệ (0-10). Nhập lại:");
                continue;
              }
              marks.add(val);
              System.out.print("Nhập tiếp (hoặc số âm để dừng): ");
            } catch (NumberFormatException e) {
              System.out.println("Vui lòng nhập số!");
            }
          }
          break;

        case 2:
          System.out.println("--- Danh sách điểm ---");
          if (marks.isEmpty()) {
            System.out.println("Danh sách trống!");
          } else {

            for (Double mark : marks) {
              System.out.print(mark + "  ");
            }
            System.out.println();
          }
          break;

        case 3:
          if (marks.isEmpty()) {
            System.out.println("Danh sách trống!");
          } else {
            double sum = 0;
            for (Double mark : marks) {
              sum += mark;
            }
            System.out.println("Điểm trung bình: " + (sum / marks.size()));
          }
          break;

        case 4:
          if (marks.isEmpty()) {
            System.out.println("Danh sách trống!");
          } else {

            double maxVal = Collections.max(marks);
            double minVal = Collections.min(marks);
            System.out.println("Cao nhất: " + maxVal);
            System.out.println("Thấp nhất: " + minVal);
          }
          break;

        case 5:
          int pass = 0, fail = 0;
          for (Double mark : marks) {
            if (mark >= 5)
              pass++;
            else
              fail++;
          }
          System.out.println("Số lượng ĐẠT (>=5): " + pass);
          System.out.println("Số lượng TRƯỢT (<5): " + fail);
          break;

        case 6:

          Collections.sort(marks);
          System.out.println("Đã sắp xếp tăng dần! Chọn menu 2 để xem.");
          break;

        case 7:

          int excellent = 0;
          for (Double mark : marks) {
            if (mark >= 8)
              excellent++;
          }
          System.out.println("Số lượng sinh viên Giỏi/Xuất sắc (>=8): " + excellent);
          break;

        case 8:
          System.out.println("Kết thúc chương trình.");
          break;

        default:
          System.out.println("Lựa chọn không hợp lệ!");
      }
    } while (choose != 8);

    sc.close();
  }
}