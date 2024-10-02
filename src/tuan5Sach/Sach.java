package tuan5Sach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Sach implements Comparable<Sach> {
		protected String maSach;
	    protected LocalDate ngayNhap;
	    protected double donGia;
	    protected int soLuong;
	    protected String nhaXuatBan;
	    protected String tacGia;

	    // Getter và Setter cho các thuộc tính
	    public LocalDate getNgayNhap() {
	        return this.ngayNhap;
	    }

	    public void setNgayNhap(int year, int month, int day) {
	        this.ngayNhap = LocalDate.of(year, month, day);
	    }

	    public String getTacGia() {
	        return tacGia;
	    }

	    // Phương thức trừu tượng tính thành ti�?n
	    public abstract double tinhThanhTien();

	    @Override
	    public String toString() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String ngayNhapString = ngayNhap.format(formatter);
	        return String.format("|%-10s|%-15s|%-10.2f|%-10d|%-20s|%-20s|", 
	                maSach, ngayNhapString, donGia, soLuong, nhaXuatBan, tacGia);
	    }
	    

	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Sach other = (Sach) obj;
			if (maSach == null) {
				if (other.maSach != null)
					return false;
			} else if (!maSach.equals(other.maSach))
				return false;
			return true;
		}

		// So sánh theo tác giả (sắp xếp nếu trùng)
	    @Override
	    public int compareTo(Sach other) {
	        return this.tacGia.compareTo(other.tacGia);
	    }
	}

	class SachGiaoKhoa extends Sach {
	    private boolean tinhTrang; // Tình trạng sách (mới/cũ)

	    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tacGia, boolean tinhTrang) {
	        this.maSach = maSach;
	        this.ngayNhap = ngayNhap;
	        this.donGia = donGia;
	        this.soLuong = soLuong;
	        this.nhaXuatBan = nhaXuatBan;
	        this.tacGia = tacGia;
	        this.tinhTrang = tinhTrang;
	    }

	    @Override
	    public double tinhThanhTien() {
	        return tinhTrang ? soLuong * donGia : soLuong * donGia * 0.5;
	    }
	}

	class SachThamKhao extends Sach {
	    private double thue; // Thuế

	    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tacGia, double thue) {
	        this.maSach = maSach;
	        this.ngayNhap = ngayNhap;
	        this.donGia = donGia;
	        this.soLuong = soLuong;
	        this.nhaXuatBan = nhaXuatBan;
	        this.tacGia = tacGia;
	        this.thue = thue;
	    }

	    @Override
	    public double tinhThanhTien() {
	        return soLuong * donGia + thue;
	    }
	}

	class ThuVien {
	    private List<Sach> danhSachSach;

	    public ThuVien() {
	        danhSachSach = new ArrayList<>();
	    }

	    public void themSach(Sach sach) {
	        danhSachSach.add(sach);
	    }

	    public void inDanhSach() {
	        danhSachSach.forEach(System.out::println);
	    }

	    // Sắp xếp sách theo tác giả nếu trùng
	    public void sapXepTheoTacGia() {
	        Collections.sort(danhSachSach);
	    }

	    // Tính tổng thành ti�?n sách giáo khoa
	    public double tinhTongThanhTienSachGiaoKhoa() {
	    	return danhSachSach.stream()
	                .filter(sach -> sach instanceof SachGiaoKhoa)
	                .mapToDouble(Sach::tinhThanhTien)
	                .sum();
	        }

	        // Tính tổng thành ti�?n sách tham khảo
	        public double tinhTongThanhTienSachThamKhao() {
	            return danhSachSach.stream()
	                .filter(sach -> sach instanceof SachThamKhao)
	                .mapToDouble(Sach::tinhThanhTien)
	                .sum();
	        }

	        // Tính trung bình đơn giá sách tham khảo
	        public double tinhTrungBinhDonGiaSachThamKhao() {
	            return danhSachSach.stream()
	                .filter(sach -> sach instanceof SachThamKhao)
	                .mapToDouble(sach -> sach.donGia)
	                .average()
	                .orElse(0.0);
	        }
	    }

	       
	
