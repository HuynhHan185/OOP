package tuan6HangHoa;

import java.time.LocalDate;
import java.util.Scanner;

public class KiemThuHangHoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyHangHoa quanLy = new QuanLyHangHoa();

        // Tạo một số hàng hóa mẫu
        HangThucPham htp = new HangThucPham("TP01", "Gạo", 100, 20000, LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 1), "VinMart");
        HangDienMay hdm = new HangDienMay("DM01", "Tủ lạnh", 2, 5000000, 12, 2.5);
        HangSanhSu hss = new HangSanhSu("SS01", "Chén sứ", 60, 10000, "Minh Long", LocalDate.of(2023, 1, 1));

        // Thêm vào danh sách
        quanLy.themHangHoa(htp);
        quanLy.themHangHoa(hdm);
        quanLy.themHangHoa(hss);

        // In danh sách hàng hóa
        System.out.println("Danh sách hàng hóa:");
        quanLy.inDanhSach();

        // Đánh giá hàng thực phẩm
        System.out.println("Đánh giá hàng thực phẩm: " + htp.danhGiaMucDoBanBuon());

        // Đánh giá hàng sành sứ
        System.out.println("Đánh giá hàng sành sứ: " + hss.danhGiaMucDoBanBuon());

        // Đánh giá hàng điện máy
        System.out.println("Đánh giá hàng điện máy: " + hdm.danhGiaMucDoBanBuon());
        
        // Tính tổng VAT
        System.out.println("Tổng VAT của tất cả hàng hóa: " + HangHoa.nf.format(quanLy.tinhTongVAT()));
        
        scanner.close();
    }
}
