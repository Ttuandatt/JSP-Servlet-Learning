package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
	JDBCConnection jdbc = new JDBCConnection();
	@Override
	public ArrayList<TacGia> selectAll(){
		ArrayList<TacGia> arr = new ArrayList<TacGia>();
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM tacgia";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					TacGia tg = new TacGia();
					tg.setMaTacGia(rs.getString(1));
					tg.setTenTacGia(rs.getString(2));
					tg.setNgaySinh(rs.getString(3));
					tg.setGioiTinh(rs.getString(4));
					tg.setTieuSu(rs.getString(5));
					
					arr.add(tg);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				jdbc.closeConnection();
			}
		}
		return arr;
	}
	
	@Override
	public TacGia selectById(TacGia tg) {
		TacGia tacGia = null;

		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM tacgia WHERE matacgia = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tg.getMaTacGia());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					String maTG = rs.getString(1);
					String tenTG = rs.getString(2);
					String ngaySinh = rs.getString(3);
					String gioiTinh = rs.getString(4);
					String tieuSu = rs.getString(5);
					
					tacGia = new TacGia(maTG, tenTG, ngaySinh, gioiTinh, tieuSu);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return tacGia;
	}
	public boolean has(TacGia tg) {
		boolean result = false;
		String id = tg.getMaTacGia();
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM tacgia WHERE matacgia = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				result = rs.next(); //rs.next() trả về true khi có 1 dòng thỏa điều kiện ở query, false nếu ngược lại
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	@Override
	public int insert(TacGia tg) {
		if(jdbc.openConnection()) {
			try {
				String query = "INSERT INTO tacgia VALUES (?,?,?,?,?)";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tg.getMaTacGia());
				ps.setString(2, tg.getTenTacGia());
				ps.setString(3, tg.getNgaySinh());
				ps.setString(4, tg.getGioiTinh());
				ps.setString(5, tg.getTieuSu());
				
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
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for(TacGia tg: arr) {
			dem+=this.insert(tg);
		}
		return dem;
	}
	
	@Override
	public int delete(TacGia tg) {
		if(jdbc.openConnection()) {
			try {
				String query = "DELETE FROM tacgia WHERE matacgia = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tg.getMaTacGia());
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
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for(TacGia tg: arr) {
			dem+=this.delete(tg);
		}
		return dem;
	}
	
	@Override
	public int update(TacGia tg) {
		if(jdbc.openConnection()) {
			try {
				String query = "UPDATE tacgia SET matacgia = ?, tentacgia = ?, ngaysinh = ?, gioitinh = ?, tieusu = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tg.getMaTacGia());
				ps.setString(2, tg.getTenTacGia());
				ps.setString(3, tg.getNgaySinh());
				ps.setString(4, tg.getGioiTinh());
				ps.setString(5, tg.getTieuSu());
				
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
