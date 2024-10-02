package tuan5bai6ThucPham;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham {
	// Các thuộc tính
    private final String maHang; // không cho phép sửa
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySanXuat, Date ngayHetHan) {
        if (maHang == null || maHang.isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống!");
        }
        this.maHang = maHang;
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }
    // Constructor chỉ có mã hàng
    public HangThucPham(String maHang) {
        if (maHang == null || maHang.isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống!");
        }
        this.maHang = maHang;
        this.tenHang = "Không xác định";
        this.donGia = 0;
        this.ngaySanXuat = new Date();
        this.ngayHetHan = new Date();
    }
    // Getter và Setter
    public String getMaHang() {
        return maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.isEmpty()) {
            this.tenHang = "Không xác định";
        } else {
            this.tenHang = tenHang;
        }
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        if (donGia <= 0) {
            this.donGia = 1; // Gán giá trị mặc định là 1 nếu không hợp lệ
        } else {
            this.donGia = donGia;
        }
    }
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }
    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat == null) {
            this.ngaySanXuat = new Date();
        } else {
            this.ngaySanXuat = ngaySanXuat;
        }
    }
    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan == null || ngayHetHan.before(ngaySanXuat)) {
            this.ngayHetHan = ngaySanXuat; // Gán mặc định bằng ngày sản xuất nếu không hợp lệ
        } else {
            this.ngayHetHan = ngayHetHan;
        }
    }
    // Phương thức kiểm tra hàng hết hạn
    public boolean kiemTraHetHan() {
        Date ngayHienTai = new Date();
        return ngayHienTai.after(ngayHetHan);
    }
    // Phương thức toString
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return String.format("%-10s %-30s %15s %-15s %-15s %s",maHang, tenHang, decimalFormat.format(donGia) + " VND",
                dateFormat.format(ngaySanXuat), 
                dateFormat.format(ngayHetHan), 
                kiemTraHetHan() ? "Hết hạn" : "Còn hạn");
    }
   
}
