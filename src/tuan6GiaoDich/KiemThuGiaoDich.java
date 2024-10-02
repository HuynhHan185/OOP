package tuan6GiaoDich;

public class KiemThuGiaoDich {
	 private static QuanLyGiaoDich qlGiaoDich = new QuanLyGiaoDich(); // Khởi tạo ngay từ đầu

	    public static void main(String[] args) {
	        // Tạo giao dịch
	        GiaoDichVang gdVang = new GiaoDichVang("GD001", "12/09/2024", 30000000, 10, "SJC");
	        GiaoDichTienTe gdTienTe1 = new GiaoDichTienTe("GD002", "28/09/2024", 23000, 1000, 1, "VN");
	        GiaoDichTienTe gdTienTe2 = new GiaoDichTienTe("GD003", "28/09/2024", 1_200_000_000, 500, 1.1, "USD");

	        // Thêm vào danh sách
	        qlGiaoDich.themGiaoDich(gdVang);
	        qlGiaoDich.themGiaoDich(gdTienTe1);
	        qlGiaoDich.themGiaoDich(gdTienTe2);

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

