package database;

import java.sql.Date;
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
				//In câu lệnh ra để test
				System.out.println("Bạn đã thực thi: "+ query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					TacGia tg = new TacGia();
					tg.setMaTacGia(rs.getString(1));
					tg.setTenTacGia(rs.getString(2));
					tg.setNgaySinh(rs.getDate(3));
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
	public TacGia selectById(String matg) {
		TacGia tacGia = null;

		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM tacgia WHERE matacgia = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, matg);
				//In câu lệnh ra để test
				System.out.println("Bạn đã thực thi: "+ query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					String maTG = rs.getString(1);
					String tenTG = rs.getString(2);
					Date ngaySinh = rs.getDate(3);
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

	@Override
	public int insert(TacGia tg) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "INSERT INTO tacgia VALUES (?,?,?,?,?)";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tg.getMaTacGia());
				ps.setString(2, tg.getTenTacGia());
				ps.setDate(3, tg.getNgaySinh());
				ps.setString(4, tg.getGioiTinh());
				ps.setString(5, tg.getTieuSu());
				
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
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for(TacGia tg: arr) {
			dem+=this.insert(tg);
		}
		return dem;
	}
	
	@Override
	public int delete(String matg) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "DELETE FROM tacgia WHERE matacgia = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, matg);
				
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
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for(TacGia tg: arr) {
			dem+=this.delete(tg.getMaTacGia());
		}
		return dem;
	}
	
	@Override
	public int update(TacGia tg) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "UPDATE tacgia SET tentacgia = ?, ngaysinh = ?, gioitinh = ?, tieusu = ? WHERE  matacgia = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tg.getTenTacGia());
				ps.setDate(2, tg.getNgaySinh());
				ps.setString(3, tg.getGioiTinh());
				ps.setString(4, tg.getTieuSu());
				ps.setString(5, tg.getMaTacGia());

				
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
	
	public static void main(String[] args) {
		TacGiaDAO tgd = new TacGiaDAO();
		
		//selectAll()
		ArrayList<TacGia> arr = tgd.selectAll();
		for (TacGia tacGia : arr) {
			System.out.println(tacGia.toString());
		}
		
		//selectById()
//		TacGia tg = tgd.selectById("TG01");
//		System.out.println(tg);
		
		//insert()
//		TacGia tg = new TacGia("TG33", "Tác giả test 3", Date.valueOf("1968-11-10"), "Nam", "Tiểu sử nfyareasd");
//		tgd.insert(tg);
		
		//delete()
//		tgd.delete("TG32");

		//update
//		TacGia tg = tgd.selectById("TG31");
//		System.out.println(tg);
//		tg.setTieuSu("TIỂU SỬ ĐÃ BỊ THAY ĐỔI");
//		tgd.update(tg);
	}
}
