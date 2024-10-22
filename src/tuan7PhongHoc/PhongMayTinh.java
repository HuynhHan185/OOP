package tuan7PhongHoc;

public class PhongMayTinh extends PhongHoc {
	private int soMayTinh;

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    @Override
    public boolean datChuan() {
        return (soBongDen >= dienTich / 10) && (dienTich / soMayTinh <= 1.5);
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

	public int getSoMayTinh() {
		return soMayTinh;
	}
	@Override
	public String toString() {
	    return super.toString() + String.format(" | %-12d |", soMayTinh);
	}

}
