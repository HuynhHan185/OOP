package tuan7PhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyPhongHoc {
	private ArrayList<PhongHoc> danhSachPhongHoc;

    public QuanLyPhongHoc() {
        danhSachPhongHoc = new ArrayList<>();
    }

    public boolean themPhongHoc(PhongHoc phong) {
        if (!danhSachPhongHoc.contains(phong)) {
            danhSachPhongHoc.add(phong);
            return true; // Thêm thành công
        }
        return false; // Phòng đã tồn tại
    }

    public PhongHoc timPhong(String maPhong) {
        for (PhongHoc phong : danhSachPhongHoc) {
            if (phong.getMaPhong().equals(maPhong)) {
                return phong;
            }
        }
        return null; // Không tìm thấy
    }

    public void inDanhSach() {
        for (PhongHoc phong : danhSachPhongHoc) {
            System.out.println(phong);  // Gọi phương thức toString() của từng phòng
        }
    }

    public void inPhongDatChuan() {
        for (PhongHoc phong : danhSachPhongHoc) {
            if (phong.datChuan()) {
                System.out.println(phong.getMaPhong());
            }
        }
    }
    
    public void sapXepTangTheoDayNha() {
        Collections.sort(danhSachPhongHoc, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return p1.dayNha.compareTo(p2.dayNha);
            }
        });
    }

    public void sapXepGiamTheoDienTich() {
        Collections.sort(danhSachPhongHoc, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Double.compare(p2.dienTich, p1.dienTich); // Giảm dần
            }
        });
    }

    public void sapXepTangTheoSoBongDen() {
        Collections.sort(danhSachPhongHoc, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Integer.compare(p1.soBongDen, p2.soBongDen);
            }
        });
    }

    public int tongSoPhong() {
        return danhSachPhongHoc.size();
    }

    public void inPhongMay60() {
        for (PhongHoc phong : danhSachPhongHoc) {
            if (phong instanceof PhongMayTinh) {
                PhongMayTinh pmt = (PhongMayTinh) phong;
                if (pmt.getSoMayTinh() == 60) {
                    System.out.println(pmt.getMaPhong());
                }
            }
        }
    }

    public boolean xoaPhong(String maPhong) {
        for (PhongHoc phong : danhSachPhongHoc) {
            if (phong.getMaPhong().equals(maPhong)) {
                danhSachPhongHoc.remove(phong);
                return true; // Xóa thành công
            }
        }
        return false; // Không tìm thấy
    }
    @Override
	public String toString() {
		String s = "Danh sach hang hoa:";
		for (PhongHoc phong : danhSachPhongHoc) {
			s += "\n"+ phong;
		}
		return s;
	}

}

