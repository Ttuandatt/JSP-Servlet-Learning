package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import model.KhachHang;
import model.TacGia;


public class KhachHangDAO implements DAOInterface<KhachHang>{
	JDBCConnection jdbc = new JDBCConnection();
	
	@Override
	public ArrayList<KhachHang> selectAll(){
		ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM khachhang";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				System.out.println("Bạn đã thực thi: " + query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					KhachHang kh = new KhachHang();
					kh.setMaKH(rs.getString(1));
					kh.setTenKH(rs.getString(2));
					kh.setNgaySinh(rs.getDate(3));
					kh.setGioiTinh(rs.getString(4));
					kh.setEmail(rs.getString(5));
					kh.setSdt(rs.getString(6));
					kh.setDiaChiNhanHang(rs.getString(7));
					kh.setTenDangNhap(rs.getString(8));
					kh.setMatKhau(rs.getString(9));
					arr.add(kh);
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
	public KhachHang selectById(String makh) {
		KhachHang kh = null;
		
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM khachhang WHERE makhachhang = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				System.out.println("Bạn đã thực thi: " + query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					String maKH = rs.getString(1);
					String tenKH = rs.getString(2);
					Date ngaySinh = rs.getDate(3);
					String gioiTinh = rs.getString(4);
					String email = rs.getString(5);
					String sdt = rs.getString(6);
					String diaChiNhanHang = rs.getString(7);
					String tenDangNhap = rs.getString(8);
					String matKhau = rs.getString(9);
					kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, sdt, email, diaChiNhanHang, tenDangNhap, matKhau);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return kh;
	}
	
	@Override
	public int insert(KhachHang kh) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "INSERT INTO khachhang VALUES (?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, kh.getMaKH());
				ps.setString(2, kh.getTenKH());
				ps.setString(3, kh.getGioiTinh());
				ps.setDate(4, kh.getNgaySinh());
				ps.setString(5, kh.getEmail());
				ps.setString(6, kh.getSdt());
				ps.setString(7, kh.getDiaChiNhanHang());
				ps.setString(8, kh.getTenDangNhap());
				ps.setString(9, kh.getMatKhau());
				
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
	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for(KhachHang kh: arr) {
			dem+=this.insert(kh);
		}
		return dem;
	}
	
	@Override
	public int delete(String makh) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "DELETE FROM khachhang WHERE makhachhang = ?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, makh);
				
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
	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for(KhachHang kh: arr) {
			dem+=this.delete(kh.getMaKH());
		}
		return dem;
	}
	
	@Override
	public int update(KhachHang kh) {
		int result = 0;
		if(jdbc.openConnection()) {
			try {
				String query = "UPDATE khachhang SET tenkhachhang = ?, gioitinh = ?, ngaysinh = ?, email = ?, sdt = ?, diachinhanhang = ?, tendangnhap=?, matkhau=? WHERE makhachhang = ?";
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return result;
	}
	
	public boolean kiemTraTenDangNhapTonTai(String tenDangNhap) {
		boolean tontai = false;
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT COUNT(*) FROM khachhang WHERE tendangnhap=?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, tenDangNhap);
				System.out.println("Bạn đã thực thi: " + query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					int count = rs.getInt(1);
					tontai = (count>0);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return tontai;
	}
	
	public boolean kiemTraEmailTonTai(String email) {
		boolean tontai = false;
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT COUNT(*) FROM khachhang WHERE email=?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, email);
				System.out.println("Bạn đã thực thi: " + query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					int count = rs.getInt(1);
					tontai = (count>0);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return tontai;
	}
	
	public boolean kiemTraSdtTonTai(String sdt) {
		boolean tontai = false; 
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT COUNT(*) FROM khachhang WHERE sdt=?";	//đếm số dòng có sdt=?	
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, sdt );
				System.out.println("Bạn đã thực thi: " + query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					int count = rs.getInt(1);	//Giả sử bạn đã thực hiện một câu truy vấn SQL như SELECT COUNT(*) FROM KhachHang WHERE sdt = ?. Câu lệnh SQL này sẽ trả về một kết quả duy nhất là số lượng bản ghi (rows) phù hợp với điều kiện WHERE.
												//Khi bạn gọi rs.getInt(1);, bạn đang lấy giá trị của cột đầu tiên trong kết quả truy vấn, chính là số lượng bản ghi phù hợp với điều kiện. Giá trị này sau đó được lưu vào biến count.
					tontai = (count>0);	
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return tontai;
	}
	
	public KhachHang selectByUsernamAndPassword(String username, String password) {
		KhachHang kh = null;
		if(jdbc.openConnection()) {
			try {
				String query = "SELECT * FROM khachhang WHERE tendangnhap=?, matkhau=?";
				PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, password);
				System.out.println("Bạn đã thực thi: " + query);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					String maKH = rs.getString(1);
					String tenKH = rs.getString(2);
					Date ngaySinh = rs.getDate(3);
					String gioiTinh = rs.getString(4);
					String email = rs.getString(5);
					String sdt = rs.getString(6);
					String diaChiNhanHang = rs.getString(7);
					String tenDangNhap = rs.getString(8);
					String matKhau = rs.getString(9);
					kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, sdt, email, diaChiNhanHang, tenDangNhap, matKhau);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				jdbc.closeConnection();
			}
		}
		return kh;
	}
}
