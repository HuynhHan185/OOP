package tuan4_phanso;

public class Phanso {
	 private int tuSo;       // Tử số
	 private int mauSo;      // Mẫu số

	    // Constructor
	    public Phanso(int tuSo, int mauSo) {
	        if (mauSo == 0) {
	            throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
	        }
	        this.tuSo = tuSo;
	        this.mauSo = mauSo;
	        toiGian();
	    }

	    // Phương thức tối giản phân số
	    private void toiGian() {
	        int gcd = gcd(tuSo, mauSo);
	        tuSo /= gcd;
	        mauSo /= gcd;
	        // Đảm bảo mẫu số luôn dương
	        if (mauSo < 0) {
	            tuSo = -tuSo;
	            mauSo = -mauSo;
	        }
	    }

	    // Tìm ước số chung lớn nhất (GCD) sử dụng thuật toán Euclid
	    private int gcd(int a, int b) {
	        a = Math.abs(a);
	        b = Math.abs(b);
	        while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	        return a;
	    }

	    // Phương thức trả về phân số nghịch đảo
	    public Phanso nghichDao() {
	        if (tuSo == 0) {
	            throw new ArithmeticException("Không thể lấy nghịch đảo của phân số có tử số bằng 0.");
	        }
	        return new Phanso(mauSo, tuSo);
	    }

	    // Phương thức cộng hai phân số
	    public Phanso cong(Phanso khac) {
	        int tuSoMoi = this.tuSo * khac.mauSo + khac.tuSo * this.mauSo;
	        int mauSoMoi = this.mauSo * khac.mauSo;
	        return new Phanso(tuSoMoi, mauSoMoi);
	    }

	    // Phương thức trừ hai phân số
	    public Phanso tru(Phanso khac) {
	        int tuSoMoi = this.tuSo * khac.mauSo - khac.tuSo * this.mauSo;
	        int mauSoMoi = this.mauSo * khac.mauSo;
	        return new Phanso(tuSoMoi, mauSoMoi);
	    }

	    // Phương thức nhân hai phân số
	    public Phanso nhan(Phanso khac) {
	        int tuSoMoi = this.tuSo * khac.tuSo;
	        int mauSoMoi = this.mauSo * khac.mauSo;
	        return new Phanso(tuSoMoi, mauSoMoi);
	    }

	    // Phương thức chia hai phân số
	    public Phanso chia(Phanso khac) {
	        if (khac.tuSo == 0) {
	            throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0.");
	        }
	        int tuSoMoi = this.tuSo * khac.mauSo;
	        int mauSoMoi = this.mauSo * khac.tuSo;
	        return new Phanso(tuSoMoi, mauSoMoi);
	    }

	    // Phương thức so sánh hai phân số với sai số cho phép
	    public boolean soSanh(Phanso khac, double saiSo) {
	        double giaTriCuaToi = (double) this.tuSo / this.mauSo;
	        double giaTriCuaKhac = (double) khac.tuSo / khac.mauSo;
	        return Math.abs(giaTriCuaToi - giaTriCuaKhac) < saiSo;
	    }

	    @Override
	    public String toString() {
	        return tuSo + "/" + mauSo;
	    }

	    // Phương thức main để thử nghiệm
	    public static void main(String[] args) {
	        Phanso phanSo1 = new Phanso(3, 4);
	        Phanso phanSo2 = new Phanso(5, 6);

	        System.out.println("Phân số 1: " + phanSo1);
	        System.out.println("Phân số 2: " + phanSo2);

	        // Tối giản phân số
	        Phanso phanSo3 = new Phanso(6, 8);
	        System.out.println("Phân số 3 sau khi tối giản: " + phanSo3);

	        // Nghịch đảo phân số
	        System.out.println("Nghịch đảo của phân số 1: " + phanSo1.nghichDao());

	        // Cộng phân số
	        System.out.println("Phân số 1 + Phân số 2: " + phanSo1.cong(phanSo2));

	        // Trừ phân số
	        System.out.println("Phân số 1 - Phân số 2: " + phanSo1.tru(phanSo2));

	        // Nhân phân số
	        System.out.println("Phân số 1 * Phân số 2: " + phanSo1.nhan(phanSo2));

	        // Chia phân số
	        System.out.println("Phân số 1 / Phân số 2: " + phanSo1.chia(phanSo2));

	        // So sánh phân số
	        System.out.println("Phân số 1 và Phân số 2 có bằng nhau không: " + phanSo1.soSanh(phanSo2, 0.0001));
	    }
}


