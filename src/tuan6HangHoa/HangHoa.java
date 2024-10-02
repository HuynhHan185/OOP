package tuan6HangHoa;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public abstract class HangHoa {
		 protected String maHang;
		    protected String tenHang;
		    protected int sLTon;
		    protected double donGia;

		    // Khởi tạo Locale và NumberFormat
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

		    // Phương thức trừu tượng
		    public abstract double tinhVAT();
		    public abstract String danhGiaMucDoBanBuon();

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
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
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
		}

		// DS Hàng hóa
		class QuanLyHangHoa {
		    private List<HangHoa> danhSachHangHoa;

		    public QuanLyHangHoa() {
		        this.danhSachHangHoa = new ArrayList<>();
		    }

		    public void themHangHoa(HangHoa hh) {
		        for (HangHoa hang : danhSachHangHoa) {
		            if (hang.maHang.equals(hh.maHang)) {
		                System.out.println("Hàng hóa đã tồn tại.");
		                return;
		            }
		        }
		        danhSachHangHoa.add(hh);
		        System.out.println("Thêm hàng hóa thành công.");
		    }

		    public void inDanhSach() {
		        for (HangHoa hang : danhSachHangHoa) {
		            System.out.println(hang);
		        }
		    }

		    public double tinhTongVAT() {
		        double tongVAT = 0;
		        for (HangHoa hang : danhSachHangHoa) {
		            tongVAT += hang.tinhVAT();
	}
		        return tongVAT;
		    }
		    public HangHoa timHangHoa(String maHang) {
		        for (HangHoa hang : danhSachHangHoa) {
		            if (hang.maHang.equals(maHang)) {
		                return hang;
		            }
		        }
		        return null; // Không tìm thấy
		    }

		    public void suaHangHoa(String maHang, HangHoa hangMoi) {
		        for (int i = 0; i < danhSachHangHoa.size(); i++) {
		            if (danhSachHangHoa.get(i).maHang.equals(maHang)) {
		                danhSachHangHoa.set(i, hangMoi);
		                System.out.println("Sửa hàng hóa thành công.");
		                return;
		            }
		        }
		        System.out.println("Không tìm thấy hàng hóa với mã: " + maHang);
		    }

		    public void xoaHangHoa(String maHang) {
		        for (int i = 0; i < danhSachHangHoa.size(); i++) {
		            if (danhSachHangHoa.get(i).maHang.equals(maHang)) {
		                danhSachHangHoa.remove(i);
		                System.out.println("Đã xóa hàng hóa với mã: " + maHang);
		                return;
		            }
		        }
		        System.out.println("Không tìm thấy hàng hóa với mã: " + maHang);
		    }
		}

