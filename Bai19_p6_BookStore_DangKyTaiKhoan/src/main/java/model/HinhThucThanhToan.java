package model;

public class HinhThucThanhToan {
	private String maHinhThucThanhToan;
	private String tenHinhThucThanhToan;
	
	//Constructor
	public HinhThucThanhToan() {
		
	}
	public HinhThucThanhToan(String maHTTT, String tenHTTT) {
		this.maHinhThucThanhToan = maHTTT;
		this.tenHinhThucThanhToan = tenHTTT;
	}
	
	//getter, setter
	public String getMaHinhThucThanhToan() {
		return maHinhThucThanhToan;
	}
	public void setMaHinhThucThanhToan(String maHinhThucThanhToan) {
		this.maHinhThucThanhToan = maHinhThucThanhToan;
	}
	public String getTenHinhThucThanhToan() {
		return tenHinhThucThanhToan;
	}
	public void setTenHinhThucThanhToan(String tenHinhThucThanhToan) {
		this.tenHinhThucThanhToan = tenHinhThucThanhToan;
	}
	
	
}
