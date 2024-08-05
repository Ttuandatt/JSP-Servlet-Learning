package model;

public class NhaCungCap {
	private String maNcc;
	private String tenNcc;
	private String diaChi;
	private String email;
	private String sdt;
	
	//Constructor
	public NhaCungCap() {
		
	}
	public NhaCungCap(String maNcc, String tenNcc, String diaChi, String email, String sdt) {
		this.maNcc = maNcc;
		this.tenNcc = tenNcc;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
	}
	
	//getter, setter
	public String getMaNcc() {
		return maNcc;
	}
	public void setMaNcc(String maNcc) {
		this.maNcc = maNcc;
	}
	public String getTenNcc() {
		return tenNcc;
	}
	public void setTenNcc(String tenNcc) {
		this.tenNcc = tenNcc;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
	
}
