package tuan6ChuyenXe;

import java.text.DecimalFormat;

	public class NoiThanh extends ChuyenXe {
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

