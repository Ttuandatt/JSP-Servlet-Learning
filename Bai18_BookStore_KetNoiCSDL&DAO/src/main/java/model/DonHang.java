package model;

public class DonHang {
	private String maDH;
	private String maKH;
	private String diaChiNhanHang;
	private NgayThangNam ngayDat;
	private NgayThangNam ngayGiao;
	private HinhThucThanhToan hinhThucThanhToan;
	private double tongThanhTien;
	private String trangThai;
	
	//Constructor
	public DonHang() {
		
	}
	public DonHang(String maDH, String maKH, String diaChiNhanHang, NgayThangNam ngayDat, NgayThangNam ngayGiao, HinhThucThanhToan httt, double tongThanhTien, String trangThai) {
		this.maDH = maDH;
		this.maKH = maKH;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
		this.hinhThucThanhToan = hinhThucThanhToan;
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
	public NgayThangNam getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(NgayThangNam ngayDat) {
		this.ngayDat = ngayDat;
	}
	public NgayThangNam getNgayGiao() {
		return ngayGiao;
	}
	public void setNgayGiao(NgayThangNam ngayGiao) {
		this.ngayGiao = ngayGiao;
	}
	public HinhThucThanhToan getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
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
	
	
}
