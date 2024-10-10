package model;

import java.sql.Date;

public class TacGia {
	private String maTacGia;
	private String tenTacGia;
	private Date ngaySinh;
	private String gioiTinh; 
	private String tieuSu;
	
	//Constructor
	public TacGia(){
		
	}
	public TacGia(String maTacGia, String tenTacGia, Date ngaySinh, String gioiTinh, String tieuSu) {
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tieuSu = tieuSu;
	}
	
	//getter, setter
	public String getMaTacGia() {
		return this.maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
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
	public String getTieuSu() {
		return tieuSu;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	
	@Override
	public String toString() {
		return "Tác giả: " + this.maTacGia + " | " + this.tenTacGia + " | " + this.ngaySinh + " | " + this.gioiTinh + " | " + this.tieuSu;
	}
	
}
