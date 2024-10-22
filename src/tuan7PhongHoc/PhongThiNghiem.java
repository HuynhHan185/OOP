package tuan7PhongHoc;

public class PhongThiNghiem extends PhongHoc {
		private String chuyenNganh;
	    private int sucChua;
	    private boolean coBonRua;

	    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonRua) {
	        super(maPhong, dayNha, dienTich, soBongDen);
	        this.chuyenNganh = chuyenNganh;
	        this.sucChua = sucChua;
	        this.coBonRua = coBonRua;
	    }

	    @Override
	    public boolean datChuan() {
	        return (soBongDen >= dienTich / 10) && coBonRua;
	    }

		public String getChuyenNganh() {
			return chuyenNganh;
		}

		public void setChuyenNganh(String chuyenNganh) {
			this.chuyenNganh = chuyenNganh;
		}

		public int getSucChua() {
			return sucChua;
		}

		public void setSucChua(int sucChua) {
			this.sucChua = sucChua;
		}

		public boolean isCoBonRua() {
			return coBonRua;
		}

		public void setCoBonRua(boolean coBonRua) {
			this.coBonRua = coBonRua;
		}
		@Override
		public String toString() {
		    return super.toString() + String.format(" | %-12s | %-10d | %-10s |", chuyenNganh, sucChua, (coBonRua ? "Có" : "Không"));
		}

	}

