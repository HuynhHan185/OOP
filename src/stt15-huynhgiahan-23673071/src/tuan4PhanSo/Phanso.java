package tuan4PhanSo;

import java.util.Scanner;

public class Phanso {
	 private int tu;
	 private int mau;

	    // Constructor
	    public Phanso(int tu, int mau) {
	        if (mau == 0) {
	            throw new IllegalArgumentException("Mẫu số không được bằng 0.");
	        }
	        this.tu = tu;
	        this.mau = mau;
	        reduce(); // Tối giản phân số khi khởi tạo
	    }

	    // Phương thức tối giản phân số
	    private void reduce() {
	        int gcd = gcd(tu, mau);
	        tu /= gcd;
	        mau /= gcd;
	    }

	    // Hàm tìm ước số chung lớn nhất (GCD)
	    private int gcd(int a, int b) {
	        while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	        return a;
	    }

	    // Phương thức cộng 2 phân số
	    public Phanso cong(Phanso other) {
	        int newTu = this.tu * other.mau + other.tu * this.mau;
	        int newMau = this.mau * other.mau;
	        return new Phanso(newTu, newMau);
	    }

	    // Phương thức trừ 2 phân số
	    public Phanso tru(Phanso other) {
	        int newTu = this.tu * other.mau - other.tu * this.mau;
	        int newMau = this.mau * other.mau;
	        return new Phanso(newTu, newMau);
	    }

	    // Phương thức nhân 2 phân số
	    public Phanso nhan(Phanso other) {
	        int newTu = this.tu * other.tu;
	        int newMau = this.mau * other.mau;
	        return new Phanso(newTu, newMau);
	    }

	    // Phương thức chia 2 phân số
	    public Phanso chia(Phanso other) {
	        if (other.tu == 0) {
	            throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0.");
	        }
	        return this.nhan(other.reciprocal());
	    }

	    // Phương thức lấy nghịch đảo phân số
	    public Phanso reciprocal() {
	        if (tu == 0) {
	            throw new ArithmeticException("Phân số không thể có tử số bằng 0 để lấy nghịch đảo.");
	        }
	        return new Phanso(mau, tu);
	    }

	    // Phương thức so sánh 2 phân số
	    public boolean bangNhau(Phanso other) {
	        double thisValue = (double) this.tu / this.mau;
	        double otherValue = (double) other.tu / other.mau;
	        return Math.abs(thisValue - otherValue) < 0.0001;
	    }
	    @Override
	    public String toString() {
	        return tu + "/" + mau;
	    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Nhập phân số thứ nhất
            System.out.print("Nhập tử số của phân số thứ nhất: ");
            int tu1 = scanner.nextInt();
            System.out.print("Nhập mẫu số của phân số thứ nhất: ");
            int mau1 = scanner.nextInt();
            Phanso ps1 = new Phanso(tu1, mau1);

            // Nhập phân số thứ hai
            System.out.print("Nhập tử số của phân số thứ hai: ");
            int tu2 = scanner.nextInt();
            System.out.print("Nhập mẫu số của phân số thứ hai: ");
            int mau2 = scanner.nextInt();
            Phanso ps2 = new Phanso(tu2, mau2);

            // Thực hiện các phép toán
            Phanso tong = ps1.cong(ps2);
            Phanso hieu = ps1.tru(ps2);
            Phanso tich = ps1.nhan(ps2);
            Phanso thuong = ps1.chia(ps2);

            // In kết quả
            System.out.println("Tổng: " + tong);
            System.out.println("Hiệu: " + hieu);
            System.out.println("Tích: " + tich);
            System.out.println("Thương: " + thuong);
            
            System.out.println("Nghịch đảo của phân số 1: " + ps1.reciprocal());
            System.out.println("Nghịch đảo của phân số 2: " + ps2.reciprocal());

            // So sánh hai phân số
            boolean bangNhau = ps1.bangNhau(ps2);
            System.out.println("Hai phân số có bằng nhau không: " + bangNhau);
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

	
}



