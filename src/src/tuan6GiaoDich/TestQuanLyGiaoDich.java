package tuan6GiaoDich;

import java.util.Scanner;

public class TestQuanLyGiaoDich {
    private static QuanLyGiaoDich qlGiaoDich = new QuanLyGiaoDich(); // Khởi tạo ngay từ đầu
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Tạo một số giao dịch mặc định
        khoiTaoGiaoDichMacDinh();

        boolean thoat = false;

        while (!thoat) {
            System.out.println("Chọn chức năng: 1. Thêm giao dịch, 2. Tìm giao dịch, 3. Sửa giao dịch, 4. Xóa giao dịch, 5. Thoát");
            int chon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (chon) {
                case 1:
                    // Thêm giao dịch
                    themGiaoDich();
                    break;
                case 2:
                    // Tìm giao dịch
                    timGiaoDich();
                    break;
                case 3:
                    // Sửa giao dịch
                    suaGiaoDich();
                    break;
                case 4:
                    // Xóa giao dịch
                    xoaGiaoDich();
                    break;
                case 5:
                    thoat = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            
            // Tính toán và in kết quả mỗi lần thêm giao dịch
            if (chon == 1) {
                // Xuất danh sách giao dịch sau khi thêm
                System.out.println("Danh sách giao dịch hiện tại:");
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
    }

    private static void khoiTaoGiaoDichMacDinh() {
        // Tạo một số giao dịch mặc định
        GiaoDichVang gdVang1 = new GiaoDichVang("GD001", "12/09/2024", 30000000, 10, "SJC");
        GiaoDichVang gdVang2 = new GiaoDichVang("GD002", "15/09/2024", 31000000, 5, "PNJ");

        GiaoDichTienTe gdTienTe1 = new GiaoDichTienTe("GD003", "28/09/2024", 23000, 1000, 1, "VN");
        GiaoDichTienTe gdTienTe2 = new GiaoDichTienTe("GD004", "28/09/2024", 1_200_000_000, 500, 1.1, "USD");

        // Thêm các giao dịch vào danh sách
        qlGiaoDich.themGiaoDich(gdVang1);
        qlGiaoDich.themGiaoDich(gdVang2);
        qlGiaoDich.themGiaoDich(gdTienTe1);
        qlGiaoDich.themGiaoDich(gdTienTe2);
    }

    private static void themGiaoDich() {
        // Nhập số lượng giao dịch vàng
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
    }

    private static void timGiaoDich() {
        System.out.print("Nhập mã giao dịch cần tìm: ");
        String maGD = scanner.nextLine();
        GiaoDich gd = qlGiaoDich.timGiaoDichTheoMa(maGD);
        if (gd != null) {
            System.out.println(gd);
        } else {
            System.out.println("Không tìm thấy giao dịch.");
        }
    }

    private static void suaGiaoDich() {
        System.out.print("Nhập mã giao dịch cần sửa: ");
        String maGD = scanner.nextLine();
        GiaoDich giaoDichCu = qlGiaoDich.timGiaoDichTheoMa(maGD);

        if (giaoDichCu != null) {
            System.out.print("Nhập thông tin giao dịch mới (ngày giao dịch, đơn giá, số lượng, tỉ giá/loại vàng): \n");
            System.out.print("Ngày giao dịch (dd/MM/yyyy): ");
            String ngayGD = scanner.nextLine();
            System.out.print("Đơn giá: ");
            double donGia = scanner.nextDouble();
            System.out.print("Số lượng: ");
            int soLuong = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            if (giaoDichCu instanceof GiaoDichVang) {
                System.out.print("Loại vàng: ");
                String loaiVang = scanner.nextLine();
                GiaoDichVang gdVangMoi = new GiaoDichVang(maGD, ngayGD, donGia, soLuong, loaiVang);
                qlGiaoDich.suaGiaoDich(maGD, gdVangMoi);
            } else if (giaoDichCu instanceof GiaoDichTienTe) {
                System.out.print("Tỉ giá: ");
                double tiGia = scanner.nextDouble();
                scanner.nextLine(); // Đọc bỏ dòng trống
                System.out.print("Loại tiền tệ (VD: USD, VNĐ): ");
                String loaiTienTe = scanner.nextLine();
                GiaoDichTienTe gdTienTeMoi = new GiaoDichTienTe(maGD, ngayGD, donGia, soLuong, tiGia, loaiTienTe);
                qlGiaoDich.suaGiaoDich(maGD, gdTienTeMoi);
            }
            System.out.println("Sửa giao dịch thành công.");
            
            // In lại danh sách giao dịch sau khi sửa
            System.out.println("Danh sách giao dịch hiện tại:");
            qlGiaoDich.xuatDanhSach();
        } else {
            System.out.println("Không tìm thấy giao dịch.");
        }
    }

    private static void xoaGiaoDich() {
        System.out.print("Nhập mã giao dịch cần xóa: ");
        String maGD = scanner.nextLine();
        boolean xoaThanhCong = qlGiaoDich.xoaGiaoDich(maGD);
        if (xoaThanhCong) {
            System.out.println("Xóa thành công.");
            // In lại danh sách giao dịch sau khi xóa
            System.out.println("Danh sách giao dịch hiện tại:");
            qlGiaoDich.xuatDanhSach();
        } else {
            System.out.println("Không tìm thấy giao dịch.");
        }
    }

}