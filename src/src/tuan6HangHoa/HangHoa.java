package tuan6HangHoa;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public abstract class HangHoa implements InterfaceHH {
    protected String maHang;
    protected String tenHang;
    protected int sLTon;
    protected double donGia;

    // Khởi tạo Locale và NumberFormat
    @SuppressWarnings("deprecation")
	protected static final Locale VN = new Locale("vi", "VN");
    protected static final NumberFormat nf = NumberFormat.getCurrencyInstance(VN);

    public HangHoa(String maHang, String tenHang, int sLTon, double donGia) {
        if (maHang == null || maHang.isEmpty()) throw new IllegalArgumentException("Mã hàng không được rỗng");
        if (tenHang == null || tenHang.isEmpty()) throw new IllegalArgumentException("Tên hàng không được rỗng");
        if (sLTon < 0) throw new IllegalArgumentException("Số lượng tồn phải >= 0");
        if (donGia <= 0) throw new IllegalArgumentException("Đơn giá phải > 0");

        this.maHang = maHang;
        this.tenHang = tenHang;
        this.sLTon = sLTon;
        this.donGia = donGia;
    }

    @Override
    public String getmaHang() {
        return maHang; // Trả về mã hàng
    }

    @Override
    public String gettenHang() {
        return tenHang; // Trả về tên hàng
    }

    @Override
    public int getslTon() {
        return sLTon; // Trả về số lượng tồn
    }

    @Override
    public double getdonGia() {
        return donGia; // Trả về đơn giá
    }

    public abstract double tinhVAT(); // Phương thức trừu tượng tính VAT

    public String danhGiaMucDoBanBuon() {
        return null;
    }

    // Định dạng ngày
    public String formatDate(LocalDate date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHang);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        HangHoa other = (HangHoa) obj;
        return Objects.equals(maHang, other.maHang);
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-20s|%-10s|%-10d|", maHang, tenHang, nf.format(donGia), sLTon);
    }
}

// Hàng thực phẩm
class HangThucPham extends HangHoa {
    private LocalDate ngaySX;
    private LocalDate ngayHH;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int sLTon, double donGia, LocalDate ngaySX, LocalDate ngayHH, String nhaCungCap) {
        super(maHang, tenHang, sLTon, donGia);
        if (ngayHH.isBefore(ngaySX)) throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất");
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.05;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (sLTon > 0 && ngayHH.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-15s|%-15s|%-20s|", formatDate(ngaySX), formatDate(ngayHH), nhaCungCap);
    }

    // Kiểm tra còn hạn sử dụng
    public boolean conHanSuDung() {
        return ngayHH.isAfter(LocalDate.now());
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        // Nhập thông tin hàng thực phẩm
    }
}

// Hàng sành sứ
class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, int sLTon, double donGia, String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, sLTon, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.1;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        long thoiGianLuuKho = java.time.temporal.ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
        if (sLTon > 50 && thoiGianLuuKho > 10) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-20s|%-15s|", nhaSanXuat, formatDate(ngayNhapKho));
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        // Nhập thông tin hàng sành sứ
    }
}

// Hàng điện máy
class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(String maHang, String tenHang, int sLTon, double donGia, int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, sLTon, donGia);
        if (thoiGianBaoHanh < 0) throw new IllegalArgumentException("Thời gian bảo hành phải >= 0");
        if (congSuat <= 0) throw new IllegalArgumentException("Công suất phải > 0");
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.1;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        return sLTon < 3 ? "Bán được" : "Không đánh giá";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("|%-10d|%-10.2f|", thoiGianBaoHanh, congSuat);
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        // Nhập thông tin hàng điện máy
    }
}
