package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import model.DonHang;

public class DonHangDAO implements DAOInterface<DonHang>{
	JDBCConnection jdbc = new JDBCConnection();
	
	@Override
	public ArrayList<DonHang> selectAll(){
		ArrayList<DonHang> arr = new ArrayList<DonHang>();
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM donhang";
				PreparedStatement ps = jdbc.getConnection().prepareCall(query);
				System.out.println("Bạn đã thực thi: "+ query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					DonHang dh = new DonHang();
					dh.setMaDH(rs.getString(1));
					dh.setMaKH(rs.getString(2));
					dh.setNgayDat(rs.getDate(3));
					dh.setNgayGiao(rs.getDate(4));
					dh.setDiaChiNhanHang(rs.getString(5));
					dh.setHinhThucThanhToan(rs.getString(6));
					dh.setTongThanhTien(rs.getDouble(7));
					dh.setTrangThai(rs.getString(8));
					
					arr.add(dh);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return arr;
	}
	
	@Override
	public DonHang selectById(String madh) {
		DonHang dh = null;
		if(jdbc.openConnection()){
			try {
				String query = "SELECT * FROM donhang WHERE madonhang = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, madh);
				System.out.println("Bạn đã thực thi: "+ query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					String madonhang = rs.getString(1);
					String makh = rs.getString(2);
					Date ngaydat = rs.getDate(3);
					Date ngaygiao = rs.getDate(4);
					String diachinhanhang = rs.getString(5);
					String httt = rs.getString(6);
					Double tongthanhtien = rs.getDouble(7);
					String trangthai = rs.getString(8);
					
					dh = new DonHang(madonhang, makh, diachinhanhang, ngaydat, ngaygiao, httt, tongthanhtien, trangthai);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return dh;
	}
	
	@Override
	public int insert(DonHang dh) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "INSERT INTO donhang VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, dh.getMaDH());
				ps.setString(2, dh.getMaKH());
				ps.setDate(3, dh.getNgayDat());
				ps.setDate(4, dh.getNgayGiao());
				ps.setString(5, dh.getDiaChiNhanHang());
				ps.setString(6, dh.getHinhThucThanhToan());
				ps.setDouble(7, dh.getTongThanhTien());
				ps.setString(8, dh.getTrangThai());
				
				System.out.println("Bạn đã thực thi: "+ query);
				result = ps.executeUpdate();
				System.out.println("Có "+ result+" dòng bị thay đổi!");
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	
	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for(DonHang dh: arr) {
			dem+=this.insert(dh);
		}
		return dem;
	}
	
	@Override
	public int delete(String madh) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "DELETE FROM donhang WHERE madonhang = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, madh);
				
				System.out.println("Bạn đã thực thi: "+ query);
				result = ps.executeUpdate();
				System.out.println("Có "+ result + " dòng bị thay đổi!");
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	
	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for(DonHang dh: arr) {
			dem+=this.delete(dh.getMaDH());
		}
		return dem;
	}
	
	@Override
	public int update(DonHang dh) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "UPDATE donhang SET makhachhang=?, ngaydat=?, ngaygiao=?, diachinhanhang=?, hinhthucthanhtoan=?, tongthanhtien=?, trangthai=? WHERE madonhang=?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, dh.getMaDH());
				ps.setString(2, dh.getMaKH());
				ps.setDate(3, dh.getNgayDat());
				ps.setDate(4, dh.getNgayGiao());
				ps.setString(5, dh.getDiaChiNhanHang());
				ps.setString(6, dh.getHinhThucThanhToan());
				ps.setDouble(7, dh.getTongThanhTien());
				ps.setString(8, dh.getTrangThai());
				
				System.out.println("Bạn đã thực thi: "+ query);
				result = ps.executeUpdate();
				System.out.println("Có "+ result+" dòng bị thay đổi!");
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	
	public static void main(String [] args) {
		DonHangDAO dhd = new DonHangDAO();
		
		//selectAll()
		ArrayList<DonHang> arr = dhd.selectAll();
		for(DonHang dh: arr) {
			System.out.println(dh.toString());
		}
		
		//selectById()
		DonHang dh = dhd.selectById("DH0192KH01");
		System.out.println(dh);
		
		//insert
		
	}
}
