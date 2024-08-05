package model;

public class NhaXuatBan {
	private String maNhaXB;
	private String tenNXB;
	private String diaChi;
	private String email;
	private String sdt;
	
	//Constructor
	public NhaXuatBan() {
		
	}
	public NhaXuatBan(String maNhaXB, String tenNXB, String diaChi, String email, String sdt) {
		this.maNhaXB = maNhaXB;
		this.tenNXB = tenNXB;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
	}
	public String getMaNhaXB() {
		return maNhaXB;
	}
	public void setMaNhaXB(String maNhaXB) {
		this.maNhaXB = maNhaXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
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
	
	//getter, setter
	
	
}
	