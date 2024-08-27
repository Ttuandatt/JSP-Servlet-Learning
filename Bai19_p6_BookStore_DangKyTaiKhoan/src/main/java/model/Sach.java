package model;

public class Sach {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private String theLoai;
	private String nhaXB;
	private int namXB;
	private double giaNhap;
	private double giaBia;
	private int soLuong;
	private String moTa;
	
	//Constructor
	public Sach() {
		
	}
	
	public Sach(String maSach, String tenSach, String tacGia, String theLoai, String nhaXB, int namXB, double giaNhap, double giaBia, int soLuong, String moTa) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
		this.nhaXB = nhaXB;
		this.namXB = namXB;
		this.giaNhap = giaNhap;
		this.giaBia = giaBia;
		this.soLuong = soLuong;
		this.moTa = moTa;
	}
	
	//getter, setter
	public String getMaSach() {
		return this.maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
}
