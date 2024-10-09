package tuan5bai8CD;

import java.util.Scanner;

public class TestCD {
    public static void main(String[] args) {
        TestCD test = new TestCD();
        test.nhapCD();
    }

    public void nhapCD() {
        Scanner scanner = new Scanner(System.in);
        CDList cdList = new CDList(100); // Thay đổi kích thước của danh sách CD

        // Hiển thị menu chỉ một lần
        menu();
        
        while (true) {
            System.out.print("Chọn chức năng (nhập số): ");
            int chucNang = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (chucNang) {
                case 1:
                    themCD(scanner, cdList);
                    break;
                case 2:
                    System.out.println("Số lượng CD hiện có: " + cdList.getSoLuongCD());
                    break;
                case 3:
                    System.out.println("Tổng giá thành của các CD: " + cdList.tinhTongGiaThanh());
                    break;
                case 4:
                    cdList.sapXepGiamDanTheoGia();
                    System.out.println("Danh sách CD đã được sắp xếp giảm dần theo giá thành:");
                    cdList.xuatDanhSach(); // In danh sách sau khi sắp xếp
                    break;
                case 5:
                    cdList.sapXepTangDanTheoTua();
                    System.out.println("Danh sách CD đã được sắp xếp tăng dần theo tựa CD:");
                    cdList.xuatDanhSach(); // In danh sách sau khi sắp xếp
                    break;
                case 6:
                    System.out.println("Danh sách CD:");
                    System.out.println(CD.getHeader());
                    cdList.xuatDanhSach();
                    break;
                case 7:
                    timCD(scanner, cdList);
                    break;
                case 8:
                    suaCD(scanner, cdList);
                    break;
                case 9:
                    xoaCD(scanner, cdList);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
                    break;
            }
            // Không hiển thị menu lại sau khi chọn chức năng
        }
    }

    public void menu() {
        System.out.println("Menu:");
        System.out.println("1. Thêm CD");
        System.out.println("2. Tính số lượng CD");
        System.out.println("3. Tính tổng giá thành");
        System.out.println("4. Sắp xếp danh sách CD giảm dần theo giá thành");
        System.out.println("5. Sắp xếp danh sách CD tăng dần theo tựa CD");
        System.out.println("6. Xuất toàn bộ danh sách");
        System.out.println("7. Tìm CD theo mã");
        System.out.println("8. Sửa thông tin CD");
        System.out.println("9. Xóa CD theo mã");
        System.out.println("0. Thoát");
    }

    private void themCD(Scanner scanner, CDList cdList) {
        System.out.println("\t Nhập CD: ");
        int maCD = 0;
        while (true) {
            System.out.print("Nhập mã CD: ");
            if (scanner.hasNextInt()) {
                maCD = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng mới
                break; // Thoát khỏi vòng lặp nếu nhập thành công
            } else {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
                scanner.nextLine(); // Bỏ qua dòng không hợp lệ
            }
        }

        System.out.print("Nhập tựa CD: ");
        String tuaCD = scanner.nextLine();
        System.out.print("Nhập ca sỹ: ");
        String caSy = scanner.nextLine();

        int soBaiHat = 0;
        while (true) {
            System.out.print("Nhập số bài hát: ");
            if (scanner.hasNextInt()) {
                soBaiHat = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng mới
                break; // Thoát khỏi vòng lặp nếu nhập thành công
            } else {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
                scanner.nextLine(); // Bỏ qua dòng không hợp lệ
            }
        }

        double giaThanh = 0.0;
        while (true) {
            System.out.print("Nhập giá thành: ");
            if (scanner.hasNextDouble()) {
                giaThanh = scanner.nextDouble();
                scanner.nextLine(); // Đọc dòng mới
                break; // Thoát khỏi vòng lặp nếu nhập thành công
            } else {
                System.out.println("Vui lòng nhập một số hợp lệ cho giá thành.");
                scanner.nextLine(); // Bỏ qua dòng không hợp lệ
            }
        }

        CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
        if (cdList.themCD(cd)) {
            System.out.println("Thêm CD thành công!");
        } else {
            System.out.println("Thêm CD thất bại!");
        }
    }

    private void timCD(Scanner scanner, CDList cdList) {
        System.out.print("Nhập mã CD cần tìm: ");
        int maCD = scanner.nextInt();
        CD foundCD = cdList.timCD(maCD);
        if (foundCD != null) {
            System.out.println("Tìm thấy CD: " + foundCD);
        } else {
            System.out.println("Không tìm thấy CD với mã " + maCD);
        }
    }

    private void suaCD(Scanner scanner, CDList cdList) {
        System.out.print("Nhập mã CD cần sửa: ");
        int maCD = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mã CD mới: ");
        int maCDMoi = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tựa CD mới: ");
        String tuaCD = scanner.nextLine();
        System.out.print("Nhập ca sỹ mới: ");
        String caSy = scanner.nextLine();
        System.out.print("Nhập số bài hát mới: ");
        int soBaiHat = scanner.nextInt();
        System.out.print("Nhập giá thành mới: ");
        double giaThanh = scanner.nextDouble();
        scanner.nextLine();

        CD cdMoi = new CD(maCDMoi, tuaCD, caSy, soBaiHat, giaThanh);
        if (cdList.suaCD(maCD, cdMoi)) {
            System.out.println("Sửa CD thành công!");
        } else {
            System.out.println("Sửa CD thất bại!");
        }
        System.out.println("Danh sách CD sau khi sửa:");
        cdList.xuatDanhSach(); // In danh sách sau khi sửa
    }

    private void xoaCD(Scanner scanner, CDList cdList) {
        System.out.print("Nhập mã CD cần xóa: ");
        int maCD = scanner.nextInt();
        if (cdList.xoaCD(maCD)) {
            System.out.println("Xóa CD thành công!");
        } else {
            System.out.println("Xóa CD thất bại!");
        }
        System.out.println("Danh sách CD sau khi xóa:");
        cdList.xuatDanhSach(); // In danh sách sau khi xóa
    }
}
