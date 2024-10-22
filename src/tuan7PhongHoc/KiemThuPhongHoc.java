package tuan7PhongHoc;

import java.util.Scanner;

public class KiemThuPhongHoc {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			QuanLyPhongHoc quanLy = new QuanLyPhongHoc();

			// Thêm một số phòng học mặc định
			PhongLyThuyet phong1 = new PhongLyThuyet("P001", "A", 30, 10, true);
			PhongMayTinh phong2 = new PhongMayTinh("P002", "B", 50, 20, 60);
			PhongThiNghiem phong3 = new PhongThiNghiem("P003", "C", 40, 15, "Hóa học", 20, true);
			quanLy.themPhongHoc(phong1);
			quanLy.themPhongHoc(phong2);
			quanLy.themPhongHoc(phong3);

			// In danh sách mặc định sau khi thêm
			System.out.println("Danh sách phòng học mặc định:");
			quanLy.inDanhSach();  // Thêm dòng này để in ra danh sách mặc định

			// Menu điều khiển
			while (true) {
			    System.out.println("\n--- Menu ---");
			    System.out.println("1. Thêm phòng học");
			    System.out.println("2. Tìm phòng học");
			    System.out.println("3. In danh sách phòng học");
			    System.out.println("4. In danh sách phòng đạt chuẩn");
			    System.out.println("5. Tổng số phòng học");
			    System.out.println("6. In phòng máy tính có 60 máy");
			    System.out.println("7. Sắp xếp theo dãy nhà");
			    System.out.println("8. Sắp xếp giảm dần theo diện tích");
			    System.out.println("9. Sắp xếp tăng dần theo số bóng đèn");
			    System.out.println("10. Xóa phòng học");
			    System.out.println("0. Thoát");
			    System.out.print("Chọn chức năng: ");
			    int choice = scanner.nextInt();
			    scanner.nextLine(); // Đọc dòng mới

			    switch (choice) {
			        case 1:
			            // Thêm phòng học
			            System.out.print("Nhập mã phòng: ");
			            String maPhong = scanner.nextLine();
			            System.out.print("Nhập dãy nhà: ");
			            String dayNha = scanner.nextLine();
			            System.out.print("Nhập diện tích: ");
			            double dienTich = scanner.nextDouble();
			            System.out.print("Nhập số bóng đèn: ");
			            int soBongDen = scanner.nextInt();
			            scanner.nextLine(); // Đọc dòng mới

			            System.out.print("Chọn loại phòng (1 - Lý thuyết, 2 - Máy tính, 3 - Thí nghiệm): ");
			            int loaiPhong = scanner.nextInt();
			            scanner.nextLine(); // Đọc dòng mới

			            if (loaiPhong == 1) {
			                System.out.print("Có máy chiếu không? (true/false): ");
			                boolean coMayChieu = scanner.nextBoolean();
			                PhongLyThuyet phongLyThuyet = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
			                if (quanLy.themPhongHoc(phongLyThuyet)) {
			                    System.out.println("Thêm phòng lý thuyết thành công!");
			                } else {
			                    System.out.println("Mã phòng đã tồn tại!");
			                }
			            } else if (loaiPhong == 2) {
			                System.out.print("Nhập số máy tính: ");
			                int soMayTinh = scanner.nextInt();
			                PhongMayTinh phongMayTinh = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
			                if (quanLy.themPhongHoc(phongMayTinh)) {
			                    System.out.println("Thêm phòng máy tính thành công!");
			                } else {
			                    System.out.println("Mã phòng đã tồn tại!");
			                }
			            } else if (loaiPhong == 3) {
			                System.out.print("Nhập chuyên ngành thí nghiệm: ");
			                String chuyenNganh = scanner.nextLine();
			                System.out.print("Nhập sức chứa: ");
			                int sucChua = scanner.nextInt();
			                System.out.print("Có bồn rửa không? (true/false): ");
			                boolean coBonRua = scanner.nextBoolean();
			                PhongThiNghiem phongThiNghiem = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
			                if (quanLy.themPhongHoc(phongThiNghiem)) {
			                    System.out.println("Thêm phòng thí nghiệm thành công!");
			                } else {
			                    System.out.println("Mã phòng đã tồn tại!");
			                }
			            }
			            break;

			        case 2:
			            // Tìm phòng học
			            System.out.print("Nhập mã phòng cần tìm: ");
			            String maPhongTim = scanner.nextLine();
			            PhongHoc phongTim = quanLy.timPhong(maPhongTim);
			            if (phongTim != null) {
			                System.out.println("Thông tin phòng tìm thấy: " + phongTim);
			            } else {
			                System.out.println("Không tìm thấy phòng với mã: " + maPhongTim);
			            }
			            break;

			        case 3:
			            // In danh sách phòng học
			            System.out.println("Danh sách phòng học:");
			            quanLy.inDanhSach();
			            break;

			        case 4:
			            // In danh sách phòng đạt chuẩn
			            System.out.println("Danh sách phòng đạt chuẩn:");
			            quanLy.inPhongDatChuan();
			            break;

			        case 5:
			            // Tổng số phòng học
			            System.out.println("Tổng số phòng học: " + quanLy.tongSoPhong());
			            break;

			        case 6:
			            // In phòng máy tính có 60 máy
			            System.out.println("Danh sách phòng máy tính có 60 máy:");
			            quanLy.inPhongMay60();
			            break;

			        case 7:
			            // Sắp xếp tăng dần theo dãy nhà
			            quanLy.sapXepTangTheoDayNha();
			            System.out.println("Danh sách phòng học sau khi sắp xếp theo dãy nhà:");
			            quanLy.inDanhSach();
			            break;

			        case 8:
			            // Sắp xếp giảm dần theo diện tích
			            quanLy.sapXepGiamTheoDienTich();
			            System.out.println("Danh sách phòng học sau khi sắp xếp giảm dần theo diện tích:");
			            quanLy.inDanhSach();
			            break;

			        case 9:
			            // Sắp xếp tăng dần theo số bóng đèn
			            quanLy.sapXepTangTheoSoBongDen();
			            System.out.println("Danh sách phòng học sau khi sắp xếp theo số bóng đèn:");
			            quanLy.inDanhSach();
			            break;

			        case 10:
			            // Xóa phòng học
			            System.out.print("Nhập mã phòng cần xóa: ");
			            String maPhongXoa = scanner.nextLine();
			            if (quanLy.xoaPhong(maPhongXoa)) {
			                System.out.println("Xóa thành công phòng có mã: " + maPhongXoa);
			            } else {
			                System.out.println("Không tìm thấy phòng với mã: " + maPhongXoa);
			            }
			            break;

			        case 0:
			            System.out.println("Thoát chương trình.");
			            return;

			        default:
			            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
			    }
			}
		}
    }
}
