package tuan6ChuyenXe;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class ChuyenXe {
	 protected String maChuyenXe;
	    protected String hoTen;
	    protected int soXe;
	    protected double doanhThu;

	    public ChuyenXe(String maChuyenXe, String hoTen, int soXe, double doanhThu) {
	        this.maChuyenXe = maChuyenXe;
	        this.hoTen = hoTen;
	        this.soXe = soXe;
	        this.doanhThu = doanhThu;
	    }

	    public ChuyenXe() {
	    }

	    public String getMaChuyenXe() {
	        return maChuyenXe;
	    }

	    public void setMaChuyenXe(String maChuyenXe) {
	        this.maChuyenXe = maChuyenXe;
	    }

	    public String getHoTen() {
	        return hoTen;
	    }

	    public void setHoTen(String hoTen) {
	        this.hoTen = hoTen;
	    }

	    public int getSoXe() {
	        return soXe;
	    }

	    public void setSoXe(int soXe) {
	        this.soXe = soXe;
	    }

	    public double getDoanhThu() {
	        return doanhThu;
	    }

	    public void setDoanhThu(double doanhThu) throws Exception {
	        if (doanhThu > 0) {
	            this.doanhThu = doanhThu;
	        } else {
	            throw new Exception("Doanh thu phải lớn hơn không");
	        }
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(maChuyenXe);
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        ChuyenXe other = (ChuyenXe) obj;
	        return Objects.equals(maChuyenXe, other.maChuyenXe);
	    }

	    @Override
	    public String toString() {
	        DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	        String doanhThuString = df.format(doanhThu);
	        return String.format("%-15s | %-20s | %-10d | %-15s", maChuyenXe, hoTen, soXe, doanhThuString);
	    }

	    // NgoaiThanh
	    public static class NgoaiThanh extends ChuyenXe {
	        private String noiDen;
	        private int soNgayDiDuoc;

	        public NgoaiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
	            super(maChuyenXe, hoTen, soXe, doanhThu);
	            this.noiDen = noiDen;
	            this.soNgayDiDuoc = soNgayDiDuoc;
	        }

	        public String getNoiDen() {
	            return noiDen;
	        }

	        public void setNoiDen(String noiDen) {
	            this.noiDen = noiDen;
	        }

	        public int getSoNgayDiDuoc() {
	            return soNgayDiDuoc;
	        }

	        public void setSoNgayDiDuoc(int soNgayDiDuoc) {
	            this.soNgayDiDuoc = soNgayDiDuoc;
	        }

	        @Override
	        public String toString() {
	            DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	            String doanhThuString = df.format(doanhThu);
	            return String.format("%-15s | %-20s | %-10d | %-15s | %-20s | %-15d", maChuyenXe, hoTen, soXe, doanhThuString, noiDen, soNgayDiDuoc);
	        }
	    }

	    // NoiThanh
	    public static class NoiThanh extends ChuyenXe {
	        private int soTuyen;
	        private double soKm;

	        public NoiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, int soTuyen, double soKm) {
	            super(maChuyenXe, hoTen, soXe, doanhThu);
	            this.soTuyen = soTuyen;
	            this.soKm = soKm;
	        }

	        public int getSoTuyen() {
	            return soTuyen;
	        }

	        public void setSoTuyen(int soTuyen) {
	            this.soTuyen = soTuyen;
	        }

	        public double getSoKm() {
	            return soKm;
	        }

	        public void setSoKm(double soKm) {
	            this.soKm = soKm;
	        }

	        @Override
	        public String toString() {
	            DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	            DecimalFormat kmFormat = new DecimalFormat("#,##0.00 km");
	            String doanhThuString = df.format(doanhThu);
	            String kmString = kmFormat.format(soKm);
	            return String.format("%-15s | %-20s | %-10d | %-15s | %-10d | %-15s", maChuyenXe, hoTen, soXe, doanhThuString, soTuyen, kmString);
	        }
	    }

	    // DanhSachChuyenXe
	    public static class DanhSachChuyenXe {
	        private ArrayList<ChuyenXe> list = new ArrayList<>();

	        public void them(ChuyenXe chuyenXe) {
	            list.add(chuyenXe);
	        }

	        public void hienThiDanhSach() {
	            System.out.println(String.format("%-15s | %-20s | %-10s | %-15s | %-10s | %-15s",
	                    "Mã Chuyến Xe", "Họ Tên", "Số Xe", "Doanh Thu", "Số Tuyến", "Nơi Đến"));
	            for (ChuyenXe chuyenXe : list) {
	                System.out.println(chuyenXe);
	            }
	        }

	        public double tinhTongDoanhThuNoiThanh() {
	            double total = 0;
	            for (ChuyenXe chuyenXe : list) {
	                if (chuyenXe instanceof NoiThanh) {
	                    total += chuyenXe.getDoanhThu();
	                }
	            }
	            return total;
	        }

	        public double tinhTongDoanhThuNgoaiThanh() {
	            double total = 0;
	            for (ChuyenXe chuyenXe : list) {
	                if (chuyenXe instanceof NgoaiThanh) {
	                    total += chuyenXe.getDoanhThu();
	                }
	            }
	            return total;
	        }
	    }
	}