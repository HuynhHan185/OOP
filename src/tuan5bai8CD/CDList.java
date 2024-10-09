package tuan5bai8CD;

import java.util.ArrayList;

public class CDList {
    private ArrayList<CD> cds;
    private int maxSize;

    public CDList(int size) {
        this.maxSize = size;
        this.cds = new ArrayList<>(size);
    }

    public boolean themCD(CD cd) {
        for (CD existingCD : cds) {
            if (existingCD.getMaCD() == cd.getMaCD()) {
                return false; // Không thêm nếu mã trùng
            }
        }
        if (cds.size() < maxSize) {
            cds.add(cd);
            return true; // Thêm thành công
        }
        return false; // Không thêm nếu hết chỗ
    }

    public int getSoLuongCD() {
        return cds.size();
    }

    public double tinhTongGiaThanh() {
        double tong = 0;
        for (CD cd : cds) {
            tong += cd.getGiaThanh();
        }
        return tong;
    }

    public void sapXepGiamDanTheoGia() {
        cds.sort((a, b) -> Double.compare(b.getGiaThanh(), a.getGiaThanh()));
    }

    public void sapXepTangDanTheoTua() {
        cds.sort((a, b) -> a.getTuaCD().compareTo(b.getTuaCD()));
    }

    public CD timCD(int maCD) {
        for (CD cd : cds) {
            if (cd.getMaCD() == maCD) {
                return cd;
            }
        }
        return null; // Không tìm thấy
    }

    public boolean suaCD(int maCD, CD cdMoi) {
        CD cdCu = timCD(maCD);
        if (cdCu == null) {
            return false; // Không tìm thấy CD để sửa
        }
        if (cdCu.getMaCD() != cdMoi.getMaCD() && timCD(cdMoi.getMaCD()) != null) {
            return false; // Mã CD mới đã tồn tại
        }
        int index = cds.indexOf(cdCu);
        if (index != -1) {
            cds.set(index, cdMoi);
            return true;
        }
        return false; // Không tìm thấy CD để sửa
    }

    public boolean xoaCD(int maCD) {
        CD cd = timCD(maCD);
        if (cd != null) {
            cds.remove(cd);
            return true; // Xóa thành công
        }
        return false; // Không tìm thấy CD để xóa
    }

    public void xuatDanhSach() {
        for (CD cd : cds) {
            System.out.println(cd);
        }
    }
}
