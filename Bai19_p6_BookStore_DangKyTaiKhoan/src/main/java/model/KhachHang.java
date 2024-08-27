package model;

import java.sql.Date;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private Date ngaySinh;
	private String gioiTinh;
	private String sdt;
	private String email;
	private String diaChiNhanHang;
	private String tenDangNhap;
	private String matKhau;
	
	//Constructor
	public KhachHang() {
		
	}
	public KhachHang(String maKH, String tenKH, String gioiTinh, Date ngaySinh, String sdt, String email, String diaChiNhanHang, String tenDangNhap, String matKhau) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
		this.diaChiNhanHang = diaChiNhanHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
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
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
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
	

}
