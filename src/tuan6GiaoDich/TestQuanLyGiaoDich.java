package tuan6GiaoDich;

import java.util.Scanner;

public class TestQuanLyGiaoDich {
    private static QuanLyGiaoDich qlGiaoDich = new QuanLyGiaoDich(); // Khởi tạo ngay từ đầu
		    private static Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) {
		        // Nhập số lượng giao dịch
		        System.out.println("Nhập số lượng giao dịch vàng: ");
		        int soLuongVang = scanner.nextInt();
		        scanner.nextLine(); // Đọc bỏ dòng trống

		        // Nhập giao dịch vàng
		        for (int i = 0; i < soLuongVang; i++) {
		            System.out.println("Nhập thông tin giao dịch vàng thứ " + (i + 1) + ":");
		            System.out.print("Mã giao dịch: ");
		            String maGD = scanner.nextLine();
		            System.out.print("Ngày giao dịch (dd/MM/yyyy): ");
		            String ngayGD = scanner.nextLine();
		            System.out.print("Đơn giá: ");
		            double donGia = scanner.nextDouble();
		            System.out.print("Số lượng: ");
		            int soLuong = scanner.nextInt();
		            scanner.nextLine(); // Đọc bỏ dòng trống
		            System.out.print("Loại vàng: ");
		            String loaiVang = scanner.nextLine();

		            GiaoDichVang gdVang = new GiaoDichVang(maGD, ngayGD, donGia, soLuong, loaiVang);
		            qlGiaoDich.themGiaoDich(gdVang);
		        }

		        // Nhập số lượng giao dịch tiền tệ
		        System.out.println("Nhập số lượng giao dịch tiền tệ: ");
		        int soLuongTienTe = scanner.nextInt();
		        scanner.nextLine(); // Đọc bỏ dòng trống

		        // Nhập giao dịch tiền tệ
		        for (int i = 0; i < soLuongTienTe; i++) {
		            System.out.println("Nhập thông tin giao dịch tiền tệ thứ " + (i + 1) + ":");
		            System.out.print("Mã giao dịch: ");
		            String maGD = scanner.nextLine();
		            System.out.print("Ngày giao dịch (dd/MM/yyyy): ");
		            String ngayGD = scanner.nextLine();
		            System.out.print("Đơn giá: ");
		            double donGia = scanner.nextDouble();
		            System.out.print("Số lượng: ");
		            int soLuong = scanner.nextInt();
		            System.out.print("Tỉ giá: ");
		            double tiGia = scanner.nextDouble();
		            scanner.nextLine(); // Đọc bỏ dòng trống
		            System.out.print("Loại tiền tệ (VD: USD, VNĐ): ");
		            String loaiTienTe = scanner.nextLine();

		            GiaoDichTienTe gdTienTe = new GiaoDichTienTe(maGD, ngayGD, donGia, soLuong, tiGia, loaiTienTe);
		            qlGiaoDich.themGiaoDich(gdTienTe);
		        }

		        // Xuất danh sách giao dịch
		        System.out.println("Danh sách giao dịch:");
		        qlGiaoDich.xuatDanhSach();

		        // Tính tổng số lượng từng loại
	System.out.println("Tổng số lượng vàng: " + qlGiaoDich.tinhTongSoLuongVang());
		        System.out.println("Tổng số lượng tiền tệ: " + qlGiaoDich.tinhTongSoLuongTienTe());

		        // Tính trung bình thành tiền giao dịch tiền tệ
		        System.out.println("Trung bình thành tiền giao dịch tiền tệ: " + qlGiaoDich.tinhTrungBinhThanhTienTienTe());

		        // Xuất giao dịch có đơn giá > 1 tỷ
		        System.out.println("Giao dịch có đơn giá > 1 tỷ:");
		        qlGiaoDich.xuatGiaoDichDonGiaLonHon1Ty();
		    }
		}

