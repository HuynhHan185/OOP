package tuan6HangHoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestHangHoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyHangHoa quanLy = new QuanLyHangHoa();

        // Tạo một số hàng hóa mặc định
        HangThucPham htp = new HangThucPham("TP01", "Gạo", 100, 20000, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 1), "VinMart"); // Ngày hết hạn đã qua
        HangDienMay hdm = new HangDienMay("DM01", "Tủ lạnh", 2, 5000000, 12, 2.5);
        HangSanhSu hss = new HangSanhSu("SS01", "Chén sứ", 60, 10000, "Minh Long", LocalDate.of(2023, 1, 1));

        // Thêm vào danh sách
        quanLy.themHangHoa(htp);
        quanLy.themHangHoa(hdm);
        quanLy.themHangHoa(hss);

        int luaChon;
        do {
            System.out.println("\n=== QUẢN LÝ HÀNG HÓA ===");
            System.out.println("1. Thêm hàng hóa");
            System.out.println("2. Tìm hàng hóa");
            System.out.println("3. Sửa hàng hóa");
            System.out.println("4. Xóa hàng hóa");
            System.out.println("5. In danh sách hàng hóa");
            System.out.println("6. Tính tổng VAT");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (luaChon) {
                case 1:
                    // Nhập thông tin hàng hóa từ người dùng
                    System.out.print("Nhập mã hàng: ");
                    String maHang = scanner.nextLine().trim();
                    System.out.print("Nhập tên hàng: ");
                    String tenHang = scanner.nextLine();
                    System.out.print("Nhập số lượng tồn: ");
                    int sLTon = scanner.nextInt();
                    System.out.print("Nhập đơn giá: ");
                    double donGia = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng trống
                    System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
                    String ngaySXStr = scanner.nextLine();
                    System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
                    String ngayHHStr = scanner.nextLine();
                    System.out.print("Nhập nhà cung cấp: ");
                    String nhaCungCap = scanner.nextLine();

                    // Chuyển đổi chuỗi ngày thành LocalDate
                    LocalDate ngaySX = LocalDate.parse(ngaySXStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate ngayHH = LocalDate.parse(ngayHHStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    // Tạo hàng thực phẩm và thêm vào danh sách
                    HangThucPham hangThucPham = new HangThucPham(maHang, tenHang, sLTon, donGia, ngaySX, ngayHH, nhaCungCap);
                    quanLy.themHangHoa(hangThucPham);
                    System.out.println("Đã thêm hàng hóa: " + hangThucPham);
                    break;

                case 2:
                    System.out.println("Danh sách hàng hóa hiện tại:");
                    quanLy.inDanhSach();

                    // Tìm hàng hóa
                    System.out.print("Nhập mã hàng để tìm: ");
                    String maHangTim = scanner.nextLine();
                    HangHoa hangTim = quanLy.timHangHoa(maHangTim);
                    if (hangTim != null) {
                        System.out.println("Thông tin hàng hóa: " + hangTim);
                    } else {
                        System.out.println("Không tìm thấy hàng hóa với mã: " + maHangTim);
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã hàng để sửa: ");
                    String maHangSua = scanner.nextLine().trim();
                    System.out.print("Nhập tên hàng mới: ");
                    String tenHangMoi = scanner.nextLine();
                    System.out.print("Nhập số lượng tồn mới: ");
                    int sLTonMoi = scanner.nextInt();
                    System.out.print("Nhập đơn giá mới: ");
                    double donGiaMoi = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng trống
                    System.out.print("Nhập ngày sản xuất mới (dd/MM/yyyy): ");
                    String ngaySXMoiStr = scanner.nextLine();
                    System.out.print("Nhập ngày hết hạn mới (dd/MM/yyyy): ");
                    String ngayHHMoiStr = scanner.nextLine();
                    System.out.print("Nhập nhà cung cấp mới: ");
                    String nhaCungCapMoi = scanner.nextLine();

                    // Chuyển đổi chuỗi ngày thành LocalDate
                    LocalDate ngaySXMoi = LocalDate.parse(ngaySXMoiStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate ngayHHMoi = LocalDate.parse(ngayHHMoiStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    // Tạo hàng thực phẩm mới và sửa
                    HangThucPham hangThucPhamMoi = new HangThucPham(maHangSua, tenHangMoi, sLTonMoi, donGiaMoi, ngaySXMoi, ngayHHMoi, nhaCungCapMoi);
                    if (quanLy.suaHangHoa(maHangSua, hangThucPhamMoi)) {
                        System.out.println("Đã sửa hàng hóa: " + hangThucPhamMoi);
                    } else {
                        System.out.println("Không tìm thấy hàng hóa với mã: " + maHangSua);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã hàng để xóa: ");
                    String maHangXoa = scanner.nextLine().trim();
                    if (quanLy.xoaHangHoa(maHangXoa)) {
                        System.out.println("Đã xóa hàng hóa với mã: " + maHangXoa);
                    } else {
                        System.out.println("Không tìm thấy hàng hóa với mã: " + maHangXoa);
                    }
                    break;

                case 5:
                    System.out.println("In danh sách hàng hóa:");
                    quanLy.inDanhSach();
                    break;

                case 6:
                    System.out.println("Tổng VAT của tất cả hàng hóa: " + HangHoa.nf.format(quanLy.tinhTongVAT()));
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}
