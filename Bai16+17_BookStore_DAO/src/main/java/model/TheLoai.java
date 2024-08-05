package model;

public class TheLoai {
	private String maTheLoai;
	private String tenTheLoai;
	
	//Constructor
	public TheLoai() {
		
	}
	public TheLoai(String maTheLoai, String tenTheLoai) {
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}
	
	//getter, setter
	public String getMaTheLoai() {
		return this.maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
}
