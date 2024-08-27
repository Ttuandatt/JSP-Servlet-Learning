package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	private String url = "jdbc:mySQL://localhost:3306/myweb";
	private String username = "root";
	private String password = "";
	private Connection con;
	
	//Hàm thiết lập kết nối với database
	public boolean openConnection() {
		try {
			// Đăng ký MySQL Driver với DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection(url, username, password);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Hàm đóng kết nối với database
	public void closeConnection() {
		try {
			if(con!=null) {	//Khi kết nối thành công, con sẽ mang giá trị là một đối tượng Connection. Đối tượng này đại diện cho kết nối đang hoạt động đến cơ sở dữ liệu mà bạn đã chỉ định bằng dbUrl, username, và password.
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Hàm trả về đối tượng Connection
	public Connection getConnection() {
		return con;
	}
}
