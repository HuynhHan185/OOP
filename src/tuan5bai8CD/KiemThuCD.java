package tuan5bai8CD;

public class KiemThuCD {
    public static void main(String[] args) {
        checkCDFunctionality();
    }

    public static void checkCDFunctionality() {
        CDList cdList = new CDList(10);

        // Kiểm thử thêm CD
        System.out.println("---- Kiểm thử thêm CD ----");
        CD cd1 = new CD(1, "Tựa CD 1", "Ca Sỹ 1", 10, 150.0);
        CD cd2 = new CD(2, "Tựa CD 2", "Ca Sỹ 2", 8, 200.0);
        CD cd3 = new CD(1, "Tựa CD 3", "Ca Sỹ 3", 5, 100.0); // Mã trùng

        if (cdList.themCD(cd1)) {
            System.out.println("Thêm CD 1 thành công!");
        } else {
            System.out.println("Thêm CD 1 thất bại!");
        }

        if (cdList.themCD(cd2)) {
            System.out.println("Thêm CD 2 thành công!");
        } else {
            System.out.println("Thêm CD 2 thất bại!");
        }

        if (cdList.themCD(cd3)) {
            System.out.println("Thêm CD 3 thành công (không nên có)!");
        } else {
            System.out.println("Thêm CD 3 thất bại do mã trùng!");
        }

        System.out.println("Số lượng CD hiện có: " + cdList.getSoLuongCD());

        // Kiểm thử tính tổng giá thành
        double tongGiaThanh = cdList.tinhTongGiaThanh();
        System.out.println("Tổng giá thành của các CD: " + tongGiaThanh);

        // Kiểm thử sắp xếp
        System.out.println("---- Kiểm thử sắp xếp ----");
        cdList.sapXepGiamDanTheoGia();
        System.out.println("Danh sách CD sau khi sắp xếp giảm dần theo giá:");
        cdList.xuatDanhSach();

        cdList.sapXepTangDanTheoTua();
        System.out.println("Danh sách CD sau khi sắp xếp tăng dần theo tựa:");
        cdList.xuatDanhSach();

        // Kiểm thử tìm kiếm
        System.out.println("---- Kiểm thử tìm kiếm ----");
        CD foundCD = cdList.timCD(1);
        if (foundCD != null) {
            System.out.println("Tìm thấy CD: " + foundCD);
        } else {
            System.out.println("Không tìm thấy CD với mã 1.");
        }

        // Kiểm thử sửa
        System.out.println("---- Kiểm thử sửa ----");
        CD cdMoi = new CD(1, "Tựa CD sửa", "Ca Sỹ 1", 10, 180.0);
        if (cdList.suaCD(1, cdMoi)) {
            System.out.println("Sửa CD thành công!");
        } else {
            System.out.println("Sửa CD thất bại!");
        }
        System.out.println("Danh sách CD sau khi sửa:");
        cdList.xuatDanhSach();

        // Kiểm thử xóa
        System.out.println("---- Kiểm thử xóa ----");
        if (cdList.xoaCD(2)) {
            System.out.println("Xóa CD thành công!");
        } else {
            System.out.println("Xóa CD thất bại!");
        }
        System.out.println("Danh sách CD sau khi xóa:");
        cdList.xuatDanhSach();
    }
}
