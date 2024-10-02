package tuan6HangHoa;

import java.time.LocalDate;

public class KiemThuHangHoa {
	public static void main(String[] args) {
        QuanLyHangHoa quanLy = new QuanLyHangHoa();

        HangThucPham htp = new HangThucPham("TP01", "Gạo", 100, 20000, LocalDate.of(2023, 9, 1), LocalDate.of(2024, 9, 1), "VinMart");
        HangDienMay hdm = new HangDienMay("DM01", "Tủ lạnh", 2, 5000000, 12, 2.5);
        HangSanhSu hss = new HangSanhSu("SS01", "Chén sứ", 60, 10000, "Minh Long", LocalDate.of(2023, 1, 1));

        // Thêm vào danh sách
        quanLy.themHangHoa(htp);
        quanLy.themHangHoa(hdm);
        quanLy.themHangHoa(hss);

        // In danh sách hàng hóa
        System.out.println("Danh sách hàng hóa:");
        quanLy.inDanhSach();

        // Tính tổng VAT
        System.out.println("Tổng VAT của tất cả hàng hóa: " + HangHoa.nf.format(quanLy.tinhTongVAT()));
    }
}

