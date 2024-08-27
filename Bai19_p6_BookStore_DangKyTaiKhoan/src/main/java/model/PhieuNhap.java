package model;

import java.time.LocalDate;

public class PhieuNhap {
	private String maPN;
	private String maNCC;
	private String maNguoiTao;
	private String maKho;
	private LocalDate thoiGianTao;
	private double tongThanhTien;
	private String trangThai;
	
	//Constructor
	public PhieuNhap() {
		
	}

	public PhieuNhap(String maPN, String maNCC, String maNguoiTao, String maKho, LocalDate thoiGianTao, double tongThanhTien, String trangThai) {
		this.maPN = maPN;
		this.maNCC = maNCC;
		this.maNguoiTao = maNguoiTao;
		this.maKho = maKho;
		this.thoiGianTao = thoiGianTao;
		this.tongThanhTien = tongThanhTien;
		this.trangThai = trangThai;
	}
	
	//getter, setter
	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getMaNguoiTao() {
		return maNguoiTao;
	}

	public void setMaNguoiTao(String maNguoiTao) {
		this.maNguoiTao = maNguoiTao;
	}

	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public LocalDate getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(LocalDate thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public double getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
}
