package model;

public class TaiKhoan {
	private String maNguoiDung;
	private String tenDangNhap;
	private String matKhau;
	private String loaiTK;
	
	//Constructor
	public TaiKhoan() {
		
	}

	//getter, setter
	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getLoaiTK() {
		return loaiTK;
	}

	public void setLoaiTK(String loaiTK) {
		this.loaiTK = loaiTK;
	}

	public TaiKhoan(String maNguoiDung, String tenDangNhap, String matKhau, String loaiTK) {
		this.maNguoiDung = maNguoiDung;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.loaiTK = loaiTK;
	}
	
	
}
