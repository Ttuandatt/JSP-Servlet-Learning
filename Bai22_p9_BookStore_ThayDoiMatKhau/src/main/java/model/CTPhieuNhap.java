package model;

public class CTPhieuNhap {
	private String maPN;
	private String maSach;
	private String tenSach;
	private double giaSach;
	private int soLuong;
	
	//Constructor
	public CTPhieuNhap() {
		
	}

	public CTPhieuNhap(String maPN, String maSach, String tenSach, double giaSach, int soLuong) {
		this.maPN = maPN;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.giaSach = giaSach;
		this.soLuong = soLuong;
	}
	
	//getter, setter
	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public double getGiaSach() {
		return giaSach;
	}

	public void setGiaSach(double giaSach) {
		this.giaSach = giaSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
}
