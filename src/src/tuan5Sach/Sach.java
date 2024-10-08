package tuan5Sach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Sach {
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

    // Phương thức trừu tượng tính thành tiền
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
		return Objects.hash(maSach);
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
		return Objects.equals(maSach, other.maSach);
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
 // Tìm vị trí của sách trong danh sách dựa trên mã sách
    public int timVitri(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.maSach.equalsIgnoreCase(maSach)) { // So sánh mã sách
                return danhSachSach.indexOf(s);
            }
        }
        return -1; // Không tìm thấy
    }

    // Tìm sách trong danh sách dựa trên mã sách
    public Sach timSach(String maSach) {
        int viTri = timVitri(maSach);
        if (viTri != -1) { // Nếu tìm thấy
            return danhSachSach.get(viTri);
        }
        return null; // Không tìm thấy
    }

    // Phương thức thêm sách có kiểm tra trùng mã
    public void themData(Sach object) throws Exception {
        if (!danhSachSach.contains(object)) {
            danhSachSach.add(object);
        } else {
            throw new Exception("Trùng mã sách");
        }
    }
    public void inDanhSach() {
        danhSachSach.forEach(System.out::println);
    }

    // Tính tổng thành tiền sách giáo khoa
    public double tinhTongThanhTienSachGiaoKhoa() {
        return danhSachSach.stream()
            .filter(sach -> sach instanceof SachGiaoKhoa)
            .mapToDouble(Sach::tinhThanhTien)
            .sum();
    }

    // Tính tổng thành tiền sách tham khảo
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThuVien thuVien = new ThuVien();

        while (true) {
            System.out.println("Chọn thao tác:");
            System.out.println("1. Thêm sách");
            System.out.println("2. In danh sách sách");
            System.out.println("3. Tính tổng thành tiền sách giáo khoa");
            System.out.println("4. Tính tổng thành tiền sách tham khảo");
            System.out.println("5. Tính trung bình đơn giá sách tham khảo");
            System.out.println("6. Sắp xếp sách theo tác giả");
            System.out.println("7. Thoát");

            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline còn lại

            switch (luaChon) {
            case 1:
                System.out.println("Nhập loại sách (1: Sách giáo khoa, 2: Sách tham khảo):");
                int loaiSach = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Nhập mã sách:");
                String maSach = scanner.nextLine();

                System.out.println("Nhập ngày nhập (dd/MM/yyyy):");
                String ngayNhapString = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ngayNhap = LocalDate.parse(ngayNhapString, formatter);

                System.out.println("Nhập đơn giá:");
                double donGia = scanner.nextDouble();

                System.out.println("Nhập số lượng:");
                int soLuong = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Nhập nhà xuất bản:");
                String nhaXuatBan = scanner.nextLine();

                System.out.println("Nhập tác giả:");
                String tacGia = scanner.nextLine();

                try {
                    if (loaiSach == 1) {
                        System.out.println("Tình trạng sách (true: mới, false: cũ):");
                        boolean tinhTrang = scanner.nextBoolean();
                        Sach sachGiaoKhoa = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tacGia, tinhTrang);
                        thuVien.themData(sachGiaoKhoa); // Thêm sách vào thư viện
                    } else if (loaiSach == 2) {
                        System.out.println("Nhập thuế:");
                        double thue = scanner.nextDouble();
                        Sach sachThamKhao = new SachThamKhao(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tacGia, thue);
                        thuVien.themData(sachThamKhao); // Thêm sách vào thư viện
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

                case 2:
                    thuVien.inDanhSach();
                    break;

                case 3:
                    System.out.println("Tổng thành tiền sách giáo khoa: " + thuVien.tinhTongThanhTienSachGiaoKhoa());
                    break;

                case 4:
                    System.out.println("Tổng thành tiền sách tham khảo: " + thuVien.tinhTongThanhTienSachThamKhao());
                    break;

                case 5:
                    System.out.println("Trung bình đơn giá sách tham khảo: " + thuVien.tinhTrungBinhDonGiaSachThamKhao());
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
}
