package model;

public class DanhGia {
	private String maSach;
	private String maNguoiDanhGia;
	private String danhGia;
	
	//Constructor
	public DanhGia() {
		
	}
	public DanhGia(String maSach, String maNguoiDanhGia, String danhGia) {
		this.maSach = maSach;
		this.maNguoiDanhGia = maNguoiDanhGia;
		this.danhGia = danhGia;
	}
	
	//getter, setter
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getMaNguoiDanhGia() {
		return maNguoiDanhGia;
	}
	public void setMaNguoiDanhGia(String maNguoiDanhGia) {
		this.maNguoiDanhGia = maNguoiDanhGia;
	}
	public String getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}
	
	
}
