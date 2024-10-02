package tuan6ChuyenXe;

import tuan6ChuyenXe.ChuyenXe.NgoaiThanh;
import tuan6ChuyenXe.ChuyenXe.NoiThanh;

public class TestChuyenXe {
    public static void main(String[] args) {
        try {
            ChuyenXe.DanhSachChuyenXe dsChuyenXe = new ChuyenXe.DanhSachChuyenXe();

            // Providing valid data for test cases
            NoiThanh xeNoiThanh1 = new ChuyenXe.NoiThanh("NT01", "Nguyen Van A", 123, 1000000, 5, 50);
            NgoaiThanh xeNgoaiThanh1 = new ChuyenXe.NgoaiThanh("OT01", "Tran Van B", 456, 2000000, "Hanoi", 3);

            dsChuyenXe.them(xeNoiThanh1);
            dsChuyenXe.them(xeNgoaiThanh1);

            System.out.println("Danh sách các chuyến xe:");
            dsChuyenXe.hienThiDanhSach();

            System.out.println("Tổng doanh thu xe nội thành: " + dsChuyenXe.tinhTongDoanhThuNoiThanh());
            System.out.println("Tổng doanh thu xe ngoại thành: " + dsChuyenXe.tinhTongDoanhThuNgoaiThanh());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

