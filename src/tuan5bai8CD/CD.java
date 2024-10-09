package tuan5bai8CD;

public class CD {
    private int maCD;
    private String tuaCD;
    private String caSy;
    private int soBaiHat;
    private double giaThanh;

    // Constructor
    public CD(int maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        if (soBaiHat <= 0) {
            throw new IllegalArgumentException("Số bài hát phải lớn hơn 0.");
        }
        if (giaThanh <= 0) {
            throw new IllegalArgumentException("Giá thành phải lớn hơn 0.");
        }
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    // Getters and Setters
    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public String getCaSy() {
        return caSy;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat <= 0) {
            throw new IllegalArgumentException("Số bài hát phải lớn hơn 0.");
        }
        this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh <= 0) {
            throw new IllegalArgumentException("Giá thành phải lớn hơn 0.");
        }
        this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-20s %-20s %-15d %-20.2f", 
            maCD, tuaCD, caSy, soBaiHat, giaThanh);
    }

    public static String getHeader() {
        return String.format("%-10s %-20s %-20s %-15s %-20s", 
            "Mã CD", "Tựa CD", "Ca Sỹ", "Số bài hát", "Giá thành");
    }
}
	    	