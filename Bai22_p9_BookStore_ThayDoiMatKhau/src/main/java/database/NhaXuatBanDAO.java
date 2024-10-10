package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhaXuatBan;

public class NhaXuatBanDAO implements DAOInterface<NhaXuatBan>{
	JDBCConnection jdbc = new JDBCConnection();
	
	@Override
	public ArrayList<NhaXuatBan> selectAll(){
		ArrayList<NhaXuatBan> arr = new ArrayList<NhaXuatBan>();
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM nhaxuatban";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					NhaXuatBan nxb = new NhaXuatBan();
					nxb.setMaNhaXB(rs.getString(1));
					nxb.setTenNXB(rs.getString(2));
					nxb.setDiaChi(rs.getString(3));
					nxb.setEmail(rs.getString(4));
					nxb.setSdt(rs.getString(5));
					
					arr.add(nxb);
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
	public NhaXuatBan selectById(String manxb) {
		NhaXuatBan nhaXuatBan = null;
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT FROM nhaxuatban WHERE manxb = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, manxb);
				System.out.println("Bạn đã thực thi: "+ query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					String maNXB = rs.getString(1);
					String tenNXB = rs.getString(2);
					String diachi = rs.getString(3);
					String email = rs.getString(4);
					String sdt = rs.getString(5);
					
					nhaXuatBan = new NhaXuatBan(maNXB, tenNXB, diachi, email, sdt);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return nhaXuatBan;
	}
	
	@Override
	public int insert(NhaXuatBan nxb) {
		if(jdbc.openConnection()) {
			try {
				String query = "INSERT INTO nhaxuatban VALUE (?,?,?,?,?)";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, nxb.getMaNhaXB());
				ps.setString(2, nxb.getTenNXB());
				ps.setString(3, nxb.getDiaChi());
				ps.setString(4, nxb.getEmail());
				ps.setString(5, nxb.getSdt());
				
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
	public int insertAll(ArrayList<NhaXuatBan> arr) {
		int dem=0;
		for(NhaXuatBan nxb: arr) {
			dem+=this.insert(nxb);
		}
		return dem;
	}
	
	@Override
	public int delete(String manxb) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "DELETE FROM nhaxuatban WHERE manxb = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, manxb);
				
				System.out.println("Bạn đã thực thi: " + query);
				result = ps.executeUpdate();
				System.out.println("Có " + result + " dòng bị thay đổi");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	
	@Override
	public int deleteAll(ArrayList<NhaXuatBan> arr) {
		int dem = 0;
		for(NhaXuatBan nxb: arr) {
			dem+=this.delete(nxb.getMaNhaXB());
		}
		return dem;
	}
	
	@Override
	public int update(NhaXuatBan nxb) {
		String manxb = nxb.getMaNhaXB();
		if(jdbc.openConnection()) {
			try {
				String query = "UPDATE nhaxuatban SET tennxb = ?, diachi = ?, email = ?, sdt = ? WHERE manxb = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, nxb.getTenNXB());
				ps.setString(2, nxb.getDiaChi());
				ps.setString(3, nxb.getEmail());
				ps.setString(4, nxb.getSdt());
				ps.setString(5, nxb.getMaNhaXB());
				
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
