package tuan6HangHoa;

import java.util.ArrayList;
import java.util.List;

public class QuanLyHangHoa {
    private List<HangHoa> danhSachHangHoa;

    public QuanLyHangHoa() {
        this.danhSachHangHoa = new ArrayList<>(); // Khởi tạo danh sách
    }

    public void themHangHoa(HangHoa hangHoa) {
        for (HangHoa h : danhSachHangHoa) {
            if (h.getmaHang() != null && h.getmaHang().equals(hangHoa.getmaHang())) {
                System.out.println("Mã hàng đã tồn tại.");
                return;
            }
        }
        danhSachHangHoa.add(hangHoa);
        System.out.println("Đã thêm hàng hóa: " + hangHoa);
    }

    public HangHoa timHangHoa(String maHangTim) {
        // Kiểm tra xem mã hàng có hợp lệ không
        if (maHangTim == null || maHangTim.trim().isEmpty()) {
            System.out.println("Mã hàng không hợp lệ.");
            return null;
        }

        // Hiển thị thông tin tìm kiếm
        System.out.println("Đang tìm mã hàng: " + maHangTim.trim());

        // Lặp qua danh sách hàng hóa để tìm kiếm
        for (HangHoa hang : danhSachHangHoa) {
            // Kiểm tra mã hàng của hàng hóa có hợp lệ không
            if (hang.getmaHang() != null) {
                // So sánh mã hàng
                if (hang.getmaHang().trim().equalsIgnoreCase(maHangTim.trim())) {
                    return hang;  // Tìm thấy hàng hóa
                }
            }
        }
        
        // Nếu không tìm thấy hàng hóa
        System.out.println("Không tìm thấy hàng hóa với mã: " + maHangTim);
        return null; // Không tìm thấy
    }

    
    public void inDanhSach() {
        if (danhSachHangHoa.isEmpty()) {
            System.out.println("Danh sách hàng hóa rỗng.");
        } else {
            System.out.println("Danh sách hàng hóa:");
            for (HangHoa hang : danhSachHangHoa) {
                System.out.println(hang);
            }
        }
    }

    public double tinhTongVAT() {
        double tongVAT = 0;
        for (HangHoa hang : danhSachHangHoa) {
            tongVAT += hang.tinhVAT();
        }
        return tongVAT;
    }

     public boolean suaHangHoa(String maHang, HangHoa hangMoi) {
        if (maHang == null || hangMoi == null) {
            System.out.println("Thông tin không hợp lệ.");
            return false; // Trả về false nếu thông tin không hợp lệ
        }

        for (int i = 0; i < danhSachHangHoa.size(); i++) {
            HangHoa hangHienTai = danhSachHangHoa.get(i);
            
            // Kiểm tra xem mã hàng hiện tại có null không trước khi gọi equals
            if (hangHienTai.getmaHang() != null && hangHienTai.getmaHang().equals(maHang)) {
                danhSachHangHoa.set(i, hangMoi);
                System.out.println("Sửa hàng hóa thành công.");
                return true; // Trả về true nếu sửa thành công
            }
        }
        return false;
    }

    public boolean xoaHangHoa(String maHang) {
        if (maHang == null) {
            System.out.println("Mã hàng không hợp lệ.");
            return false; // Trả về false nếu mã hàng không hợp lệ
        }

        for (int i = 0; i < danhSachHangHoa.size(); i++) {
            HangHoa hangHienTai = danhSachHangHoa.get(i);
            
            // Kiểm tra xem mã hàng hiện tại có null không trước khi gọi equals
            if (hangHienTai.getmaHang() != null && hangHienTai.getmaHang().equals(maHang)) {
                danhSachHangHoa.remove(i);
                System.out.println("Đã xóa hàng hóa với mã: " + maHang);
                return true; // Trả về true nếu xóa thành công
            }
        }
        return false;
    }

    // Phương thức này trả về danh sách hàng hóa
    public HangHoa[] getDanhSachHangHoa() {
        return danhSachHangHoa.toArray(new HangHoa[0]); // Trả về mảng từ danh sách
    }
}
