package tuan7PhongHoc;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

    public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    @Override
    public boolean datChuan() {
        return (dienTich / soBongDen <= 10) && coMayChieu;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-15s|%-10.2f m2|%-10d|%-15s|", 
                             maPhong, dayNha, dienTich, soBongDen, (coMayChieu ? "Có" : "Không"));
    }
}

