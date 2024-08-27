package model;

import java.util.Scanner;

public class NgayThangNam {
	private int ngay;
	private int thang;
	private int nam;
	
	//Constructor
	public NgayThangNam() {
		
	}
	public NgayThangNam(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	
	//getter, setter
	public int getNgay() {
		return this.ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return this.thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return this.nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	
	@Override
	public String toString() {
		return this.ngay + "/" + this.thang + "/" + this.nam;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập ngày: ");
		int ngay = Integer.parseInt(scanner.nextLine());
		System.out.println("Nhập tháng: ");
		int thang = Integer.parseInt(scanner.nextLine());
		System.out.println("Nhập năm: ");
		int nam = Integer.parseInt(scanner.nextLine());
		
		NgayThangNam ns = new NgayThangNam();
		ns.setNgay(ngay);
		ns.setThang(thang);
		ns.setNam(nam);
		System.out.println(ns.toString());
		
		
	}
}
