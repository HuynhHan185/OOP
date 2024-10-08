package tuan6GiaoDich;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class GiaoDich implements InterfaceGD {
	protected String maGiaoDich;
    protected String ngayGiaoDich;
    protected double donGia;
    protected int soLuong;

    public GiaoDich(String maGiaoDich, String ngayGiaoDich, double donGia, int soLuong) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public abstract double tinhThanhTien();

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoDich);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        GiaoDich other = (GiaoDich) obj;
        return Objects.equals(maGiaoDich, other.maGiaoDich);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance(); // Khởi tạo NumberFormat
        return String.format("|%-10s|%-15s|%-10s|%-10d|", maGiaoDich, ngayGiaoDich, nf.format(donGia), soLuong);
    }
}

// Lớp GiaoDichVang
class GiaoDichVang extends GiaoDich {
    private String loaiVang; // Thêm thuộc tính loaiVang

    public GiaoDichVang(String maGiaoDich, String ngayGiaoDich, double donGia, int soLuong, String loaiVang) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.loaiVang = loaiVang;
    }

    @Override
    public double tinhThanhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        return String.format("|%-10s|%-15s|%-10s|%-10d|%-10s|", maGiaoDich, ngayGiaoDich, nf.format(donGia), soLuong, loaiVang);
    }
}

// Lớp GiaoDichTienTe
class GiaoDichTienTe extends GiaoDich {
    private double tiGia;
    private String loaiTien;

    public GiaoDichTienTe(String maGiaoDich, String ngayGiaoDich, double donGia, int soLuong, double tiGia, String loaiTien) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.tiGia = tiGia;
        this.loaiTien = loaiTien;
    }

    @Override
    public double tinhThanhTien() {
        if (loaiTien.equals("USD") || loaiTien.equals("Euro")) {
            return soLuong * donGia * tiGia;
        } else {
            return soLuong * donGia;
        }
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        return String.format("|%-10s|%-15s|%-10s|%-10d|%-10s|%-10.2f|", maGiaoDich, ngayGiaoDich, nf.format(donGia), soLuong, loaiTien, tiGia);
    }
}

// Lớp QuanLyGiaoDich
class QuanLyGiaoDich {
    private List<GiaoDich> danhSachGiaoDich;

    public QuanLyGiaoDich() {
        danhSachGiaoDich = new ArrayList<>();
    }

    public void themGiaoDich(GiaoDich gd) {
        danhSachGiaoDich.add(gd);
    }

    public void xuatDanhSach() {
        if (danhSachGiaoDich.isEmpty()) {
            System.out.println("Danh sách giao dịch trống.");
        } else {
            System.out.println("Danh sách giao dịch hiện có:");
            for (GiaoDich gd : danhSachGiaoDich) {
                System.out.println(gd);
            }
        }
    }

    public double tinhTongSoLuongVang() {
        int tong = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd instanceof GiaoDichVang) {
                tong += gd.getSoLuong();
            }
        }
        return tong;
    }

    public double tinhTongSoLuongTienTe() {
        int tong = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd instanceof GiaoDichTienTe) {
                tong += gd.getSoLuong();
            }
        }
        return tong;
    }

    public double tinhTrungBinhThanhTienTienTe() {
        double tongTien = 0;
        int dem = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd instanceof GiaoDichTienTe) {
                tongTien += gd.tinhThanhTien();
                dem++;
            }
        }
        return dem > 0 ? tongTien / dem : 0;
    }

    public void xuatGiaoDichDonGiaLonHon1Ty() {
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd.getDonGia() > 1_000_000_000) {
                System.out.println(gd);
            }
        }
    }
    public GiaoDich timGiaoDichTheoMa(String maGD) {
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd.getMaGiaoDich().equals(maGD)) {
                return gd;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
    public boolean suaGiaoDich(String maGD, GiaoDich giaoDichMoi) {
        for (int i = 0; i < danhSachGiaoDich.size(); i++) {
            if (danhSachGiaoDich.get(i).getMaGiaoDich().equals(maGD)) {
                danhSachGiaoDich.set(i, giaoDichMoi); // Thay thế giao dịch cũ bằng giao dịch mới
                return true;
            }
        }
        return false; // Trả về false nếu không tìm thấy
    }
    public boolean xoaGiaoDich(String maGD) {
        for (int i = 0; i < danhSachGiaoDich.size(); i++) {
            if (danhSachGiaoDich.get(i).getMaGiaoDich().equals(maGD)) {
                danhSachGiaoDich.remove(i); // Xóa giao dịch
                return true;
            }
        }
        return false; // Trả về false nếu không tìm thấy
    }
}

