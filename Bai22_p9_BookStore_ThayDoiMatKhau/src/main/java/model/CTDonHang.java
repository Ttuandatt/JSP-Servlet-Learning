package model;

public class CTDonHang {
	private String maCTDH;
	private String maSach;
	private String tenSach;
	private int soLuong;
	private double giaBia;
	private double giamGia;
	private double giaBan;
	
	//Constructor
	public CTDonHang() {
		
	}
	public CTDonHang(String maCTDH, String maSach, String tenSach, int soLuong, double giaBia, double giamGia, double giaBan) {
		this.maCTDH = maCTDH;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
	}
	
	//getter, setter
	public String getMaCTDH() {
		return maCTDH;
	}
	public void setMaCTDH(String maCTDH) {
		this.maCTDH = maCTDH;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaBia() {
		return giaBia;
	}
	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	
	
}
