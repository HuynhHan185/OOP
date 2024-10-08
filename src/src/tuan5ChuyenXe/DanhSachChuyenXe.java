package tuan5ChuyenXe;

import tuan5ChuyenXe.ChuyenXe.NgoaiThanh;
import tuan5ChuyenXe.ChuyenXe.NoiThanh;

public class DanhSachChuyenXe {
	private ChuyenXe[] DS;
    private int count;

    public DanhSachChuyenXe(int maxSize) {
        DS = new ChuyenXe[maxSize];
        count = 0;
    }

    public void them(ChuyenXe xe) throws Exception {
        if (timKiem(xe.getMaChuyenXe()) == null) {
            if (count < DS.length) {
                DS[count] = xe;
                count++;
            } else {
                throw new Exception("Danh sách chuyến xe đã đầy");
            }
        } else {
            throw new Exception("Mã chuyến xe đã trùng");
        }
    }

    public int timKiemViTri(String maCX) {
        for (int i = 0; i < count; i++) {
            if (DS[i].getMaChuyenXe().equalsIgnoreCase(maCX)) {
                return i;
            }
        }
        return -1;
    }

    public ChuyenXe timKiem(String maCX) {
        int viTri = timKiemViTri(maCX);
        return (viTri != -1) ? DS[viTri] : null;
    }

    public void xoa(String maCX) {
        int viTri = timKiemViTri(maCX);
        if (viTri != -1) {
            for (int i = viTri; i < count - 1; i++) {
                DS[i] = DS[i + 1];
            }
            count--;
        }
    }

    public void sua(ChuyenXe xe) {
        int viTri = timKiemViTri(xe.getMaChuyenXe());
        if (viTri != -1) {
            DS[viTri] = xe;
        }
    }

    public double tinhTongDoanhThuNoiThanh() {
        double tongDoanhThu = 0;
        for (int i = 0; i < count; i++) {
            if (DS[i] instanceof NoiThanh) {
                tongDoanhThu += DS[i].getDoanhThu();
            }
        }
        return tongDoanhThu;
    }

    public double tinhTongDoanhThuNgoaiThanh() {
        double tongDoanhThu = 0;
        for (int i = 0; i < count; i++) {
            if (DS[i] instanceof NgoaiThanh) {
                tongDoanhThu += DS[i].getDoanhThu();
            }
        }
        return tongDoanhThu;
    }

    public void hienThiDanhSach() {
        for (int i = 0; i < count; i++) {
            System.out.println(DS[i].toString());
        }
    }
}


