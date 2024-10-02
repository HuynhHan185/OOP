package tuan5Sach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestSach {
	 public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         ThuVien thuVien = new ThuVien();

         while (true) {
             System.out.println("Ch�?n thao tác:");
             System.out.println("1. Thêm sách");
             System.out.println("2. In danh sách sách");
             System.out.println("3. Tính tổng thành ti�?n sách giáo khoa");
             System.out.println("4. Tính tổng thành ti�?n sách tham khảo");
             System.out.println("5. Tính trung bình đơn giá sách tham khảo");
             System.out.println("6. Sắp xếp sách theo tác giả");
             System.out.println("7. Thoát");

             int luaChon = scanner.nextInt();
             scanner.nextLine(); // �?�?c ký tự newline còn lại

             switch (luaChon) {
                 case 1:
                     System.out.println("Nhập loại sách (1: Sách giáo khoa, 2: Sách tham khảo):");
                     int loaiSach = scanner.nextInt();
                     scanner.nextLine();

                     System.out.println("Nhập mã sách:");
                     String maSach = scanner.nextLine();

                     System.out.println("Nhập ngày nhập (dd/MM/yyyy):");
                     String ngayNhapString = scanner.nextLine();
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                     LocalDate ngayNhap = LocalDate.parse(ngayNhapString, formatter);

                     System.out.println("Nhập đơn giá:");
                     double donGia = scanner.nextDouble();

                     System.out.println("Nhập số lượng:");
                     int soLuong = scanner.nextInt();
                     scanner.nextLine();

                     System.out.println("Nhập nhà xuất bản:");
                     String nhaXuatBan = scanner.nextLine();

                     System.out.println("Nhập tác giả:");
                     String tacGia = scanner.nextLine();

                     if (loaiSach == 1) {
                         System.out.println("Tình trạng sách (true: mới, false: cũ):");
                         boolean tinhTrang1 = false;
					Sach sachGiaoKhoa = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tacGia, tinhTrang1);
                     thuVien.themSach(sachGiaoKhoa);
                 }  int loaiSach1 = 0;
					if (loaiSach1 == 2) {
                     System.out.println("Nhập thuế:");
                     double thue = scanner.nextDouble();
                     double donGia1 = 0;
						Sach sachThamKhao = new SachThamKhao(maSach, ngayNhap, donGia1, soLuong, nhaXuatBan, tacGia, thue);
                     thuVien.themSach(sachThamKhao);
                 }
                 break;

             case 2:
                 thuVien.inDanhSach();
                 break;

             case 3:
                 System.out.println("Tổng thành ti�?n sách giáo khoa: " + thuVien.tinhTongThanhTienSachGiaoKhoa());
                 break;

             case 4:
                 System.out.println("Tổng thành ti�?n sách tham khảo: " + thuVien.tinhTongThanhTienSachThamKhao());
                 break;

             case 5:
                 System.out.println("Trung bình đơn giá sách tham khảo: " + thuVien.tinhTrungBinhDonGiaSachThamKhao());
                 break;

             case 6:
                 thuVien.sapXepTheoTacGia();
                 System.out.println("Danh sách sách đã được sắp xếp theo tác giả.");
                 break;

             case 7:
                 System.out.println("Thoát chương trình.");
                 scanner.close();
                 return;

             default:
                 System.out.println("Lựa ch�?n không hợp lệ.");
                 break;
         }
     }
     }
 }

