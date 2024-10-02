package tuan6ChuyenXe;

import java.util.ArrayList;

import tuan6ChuyenXe.ChuyenXe.NgoaiThanh;
import tuan6ChuyenXe.ChuyenXe.NoiThanh;

public class DanhSachChuyenXe {
	public static class DanhSachChuyenXe1 {
   	 private ArrayList<ChuyenXe> list = new ArrayList<>();

			public void DanhSachChuyenXe() {
				// TODO Auto-generated constructor stub
			}

			public void them(ChuyenXe chuyenXe) {
   	        list.add(chuyenXe);
   	    }

   	    public void hienThiDanhSach() {
   	        System.out.println(String.format("%-15s | %-20s | %-10s | %-15s | %-10s | %-15s",
   	                "Mã Chuyến Xe", "Họ Tên", "Số Xe", "Doanh Thu", "Số Tuyến", "Nơi Đến"));
   	        for (ChuyenXe chuyenXe : list) {
   	            System.out.println(chuyenXe);
   	        }
   	    }

   	    public double tinhTongDoanhThuNoiThanh() {
   	        double total = 0;
   	        for (ChuyenXe chuyenXe : list) {
   	            if (chuyenXe instanceof NoiThanh) {
   	                total += chuyenXe.getDoanhThu();
   	            }
   	        }
   	        return total;
   	    }

   	    public double tinhTongDoanhThuNgoaiThanh() {
   	        double total = 0;
   	        for (ChuyenXe chuyenXe : list) {
   	            if (chuyenXe instanceof NgoaiThanh) {
   	                total += chuyenXe.getDoanhThu();
   	            }
   	        }
   	        return total;
   	    }
   }
}