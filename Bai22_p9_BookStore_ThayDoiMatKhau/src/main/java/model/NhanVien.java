package model;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private NgayThangNam ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	private String email;
	private String loaiNV;
	
	//Constructor
	public NhanVien() {
		
	}
	public NhanVien(String maNV, String tenNV, NgayThangNam ngaySinh, String gioiTinh, String diaChi, String sdt, String email, String loaiNV) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.loaiNV = loaiNV;
	}
	
	//getter, setter
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	public String getLoaiNV() {
		return loaiNV;
	}
	public void setLoaiNV(String loaiNV) {
		this.loaiNV = loaiNV;
	}
	
	
}
