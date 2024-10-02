package tuan5bai6ThucPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestHangThucPham {
	 public void main(String[] args) throws ParseException {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         HangThucPham hang1 = new HangThucPham("H001", "Sữa tươi", 20000, sdf.parse("01/09/2023"), sdf.parse("01/10/2023"));
         System.out.println(hang1);
         
         System.out.println("---------------------");
         
         HangThucPham hang2 = new HangThucPham("H002", "Bánh mì", 15000, sdf.parse("05/09/2023"), sdf.parse("04/09/2023"));
         System.out.println(hang2);
         
         System.out.println("---------------------");
         
         HangThucPham hang3 = new HangThucPham("H003");
         System.out.println(hang3);
     }
}

