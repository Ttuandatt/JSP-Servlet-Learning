package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	JDBCConnection jdbc = new JDBCConnection();
	
	@Override
	public ArrayList<TheLoai> selectAll(){
		ArrayList<TheLoai> arr = new ArrayList<TheLoai>();
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM theloai";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				System.out.println("Bạn đã thực thi: "+ query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					TheLoai tl = new TheLoai();
					tl.setMaTheLoai(rs.getString(1));
					tl.setTenTheLoai(rs.getString(2));
					
					arr.add(tl);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return arr;
	}
	
	@Override
	public TheLoai selectById(String matl) {
		TheLoai theLoai = null;
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM theloai WHERE matheloai = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, matl);
				System.out.println("Bạn đã thực thi: "+ query);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					String matheloai = rs.getString(1);
					String tentheloai = rs.getString(2);
					
					theLoai = new TheLoai(matheloai, tentheloai);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return theLoai;
	}
	
	@Override
	public int insert(TheLoai tl) {
		int result=0;
		if(jdbc.openConnection()) {
			try {
				String query = "INSERT INTO theloai VALUES (?,?)";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tl.getMaTheLoai());
				ps.setString(2, tl.getTenTheLoai());
				
				System.out.println("Bạn đã thực thi: "+ query);
				result = ps.executeUpdate();
				System.out.println("Có "+ result + " dòng bị thay đổi!");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		
		return result;
	}
	
	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for(TheLoai tl: arr) {
			dem+=this.insert(tl);
		}
		return dem;
	}
	
	@Override
	public int delete(String matl) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "DELETE FROM theloai WHERE matheloai = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, matl);
				
				System.out.println("Bạn đã thực thi: "+ query);
				result = ps.executeUpdate();
				System.out.println("Có "+ result+" dòng bị thay đổi!");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	
	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for(TheLoai tl: arr) {
			dem+=this.delete(tl.getMaTheLoai());
		}
		return dem;
	}
	
	@Override
	public int update(TheLoai tl) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "UPDATE theloai SET tentheloai = ? WHERE matheloai = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tl.getTenTheLoai());
				ps.setString(2, tl.getMaTheLoai());
				
				System.out.println("Bạn đã thực thi: "+ query);
				result = ps.executeUpdate();
				System.out.println("Có "+ result+" dòng bị thay đổi!");
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	
	public static void main(String [] args) {
		TheLoaiDAO tld = new TheLoaiDAO();
		//selectAll()
		ArrayList<TheLoai> arr = tld.selectAll();
		for(TheLoai tl: arr) {
			System.out.println(tl.toString());
		}
		
		//selectById()
//		TheLoai tl = tld.selectById("TL01");
//		System.out.println(tl);
		
		//insert
//		TheLoai tl2 = new TheLoai("TL41", "Test 1");
//		tld.insert(tl2);
		
		//delete
//		tld.delete("TL41");
		
		//update
//		TheLoai tl3 = tld.selectById("TL43");
//		System.out.println(tl3);
//		tl3.setTenTheLoai("Test -3");
//		tld.update(tl3);
	}
	
		
		
}
