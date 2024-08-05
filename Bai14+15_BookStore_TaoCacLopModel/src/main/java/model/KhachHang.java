package model;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private NgayThangNam ngaySinh;
	private String gioiTinh;
	private String sdt;
	private String email;
	private String diaChiNhanHang;

	
	//Constructor
	public KhachHang() {
		
	}
	public KhachHang(String maKH, String tenKH, NgayThangNam ngaySinh, String gioiTinh, String sdt, String email, String diaChiNhanHang) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.email = email;
		this.diaChiNhanHang = diaChiNhanHang;
	}
	
	//getter, setter
	public String getMaKH() {
		return this.maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public NgayThangNam getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(NgayThangNam ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

}
