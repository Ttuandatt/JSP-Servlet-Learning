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
	public TheLoai selectById(TheLoai tl) {
		TheLoai theLoai = null;
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM theloai WHERE matheloai = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tl.getMaTheLoai());
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
		if(jdbc.openConnection()) {
			try {
				String query = "INSERT INTO theloai VALUES (?,?)";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tl.getMaTheLoai());
				ps.setString(2, tl.getTenTheLoai());
				
				if(ps.executeUpdate()>0) {
					return 1;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		
		return 0;
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
	public int delete(TheLoai tl) {
		if(jdbc.openConnection()) {
			try {
				String query = "DELETE FROM theloai WHERE matheloai = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tl.getMaTheLoai());
				
				if(ps.executeUpdate()>0) {
					return 1;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return 0;
	}
	
	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for(TheLoai tl: arr) {
			dem+=this.delete(tl);
		}
		return dem;
	}
	
	@Override
	public int update(TheLoai tl) {
		if(jdbc.openConnection()) {
			try {
				String query = "UPDATE theloai SET matheloai = ?, tentheloai = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tl.getMaTheLoai());
				ps.setString(2, tl.getTenTheLoai());
				if(ps.executeUpdate()>0) {
					return 1;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return 0;
	}
}
