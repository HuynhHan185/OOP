package tuan5ChuyenXe;

import java.text.DecimalFormat;

public class NgoaiThanh extends ChuyenXe {
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
 

