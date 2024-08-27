package model;

import java.sql.Date;

public class DonHang {
	private String maDH;
	private String maKH;
	private String diaChiNhanHang;
	private Date ngayDat;
	private Date ngayGiao;
	private String hinhThucThanhToan;
	private double tongThanhTien;
	private String trangThai;
	
	//Constructor
	public DonHang() {
		
	}
	public DonHang(String maDH, String maKH, String diaChiNhanHang, Date ngayDat, Date ngayGiao, String httt, double tongThanhTien, String trangThai) {
		this.maDH = maDH;
		this.maKH = maKH;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
		this.hinhThucThanhToan = httt;
		this.tongThanhTien = tongThanhTien;
		this.trangThai = trangThai;
	}
	
	//getter, setter
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public Date getNgayGiao() {
		return ngayGiao;
	}
	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
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
	
	@Override
	public String toString() {
		return "Đơn hàng: " + this.maDH + " | " + this.maKH + " | " + this.diaChiNhanHang + " | " + this.ngayDat + " | " + this.ngayGiao + " |  " + this.hinhThucThanhToan + " | " + this.tongThanhTien + " | " + this.trangThai;
	}
	
}
