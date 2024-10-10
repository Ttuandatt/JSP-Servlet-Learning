package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

/**
 * Servlet implementation class DangKy
 */
@WebServlet("/dang-ky")
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SaveProduct servlet is called");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String nhapLai = request.getParameter("nhapLai");
		String hoTen = request.getParameter("hoTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh_str = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		
		boolean checkError = false;
		KhachHangDAO khd = new KhachHangDAO();
		
		//Check
		String e_tenDangNhap = "";
		if(tenDangNhap == null || tenDangNhap.trim().length()==0) {
			checkError = true;
			e_tenDangNhap += "Tên đăng nhập không được để trống!";
		}else if(khd.kiemTraTenDangNhapTonTai(tenDangNhap)) {
			checkError = true;
			e_tenDangNhap += "Tên đăng nhập đã tồn tại";
		}
		request.setAttribute("e_tenDangNhap", e_tenDangNhap);
		
		String e_matKhau = "";
		if(matKhau == null || matKhau.trim().length()==0) {
			checkError = true;
			e_matKhau += "Mật khẩu không được để trống!";
		}else {
			//Mã hóa mật khẩu trước khi lưu xuống database
			matKhau = MaHoa.toSHA1(matKhau);
		}
		request.setAttribute("e_matKhau", e_matKhau);
		
		String e_nhapLai = "";
		if(nhapLai == null || nhapLai.trim().length()==0) {
			checkError = true;
			e_nhapLai += "Vui lòng nhập lại mật khẩu!";
		}
		request.setAttribute("e_nhapLai", e_nhapLai);
		
		String e_hoTen = "";
		if(hoTen == null || hoTen.trim().length()==0) {
			checkError = true;
			e_hoTen += "Họ và tên không được để trống!";
		}else {
			Pattern hoTenPattern = Pattern.compile("^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$"); //Tạo một biểu thức chính quy kiểm tra nếu chuỗi hoTen chữ cái (a-z, A-Z) hoặc khoảng trắng
			Matcher hoTenMatcher = hoTenPattern.matcher(hoTen);
			if(!hoTenMatcher.matches()) {
				checkError = true;
				e_hoTen += "Họ tên không hợp lệ!";
			}
		}
		request.setAttribute("e_hoTen", e_hoTen);
		
		// Convert String to java.sql.Date
		Date ngaySinh = null;
		String e_ngaySinh = "";
		if (ngaySinh_str != null && !ngaySinh_str.trim().isEmpty()) {
		    try {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        java.util.Date utilDate = dateFormat.parse(ngaySinh_str);
		        ngaySinh = new Date(utilDate.getTime()); // Chuyển đổi từ java.util.Date sang java.sql.Date
		    } catch (Exception e) {
		        checkError = true;
		        e_ngaySinh = "Ngày sinh không hợp lệ!";
		    }
		} else {
		    checkError = true;
		    e_ngaySinh = "Ngày sinh không được để trống!";
		}
		request.setAttribute("e_ngaySinh", e_ngaySinh);

		
		String e_diaChi = "";
		if(diaChi == null || diaChi.trim().length()==0) {
			checkError = true;
			e_diaChi += "Địa chỉ không được để trống";
		}
		request.setAttribute("e_diaChi", e_diaChi);
		
		String e_email="";
		if(email == null|| email.trim().length()==0) {
			checkError = true;
			e_email += "Email không được để trống!";
		}else {
			Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)*");
			Matcher emailMatcher = emailPattern.matcher(email);
			if(!emailMatcher.matches()) {
				checkError = true;
				e_email += "Vui lòng nhập đúng định dạng email!";
			}else if(khd.kiemTraEmailTonTai(email)) {
				checkError = true;
				e_email += "Email đã tồn tại";
			}
		}
		request.setAttribute("e_email",e_email);
		
		String e_sdt = "";
		if(sdt == null || sdt.trim().length()==0) {
			checkError = true;
			e_sdt += "Số điện thoại không được để trống!";
		}else {
			Pattern sdtPattern = Pattern.compile("\\d{10}");
			Matcher sdtMatcher = sdtPattern.matcher(sdt);
			if(!sdtMatcher.matches()) {
				checkError = true;
				e_sdt += "Số điện thoại gồm 10 chữ số!";
			}else if(khd.kiemTraSdtTonTai(sdt)) {
				checkError = true;
				e_sdt += "Số điện thoại đã tồn tại!";
			}
		}
		request.setAttribute("e_sdt", e_sdt);
		
		
		//store value
		request.setAttribute("value_tenDangNhap", tenDangNhap);
		request.setAttribute("value_hoTen", hoTen);
		request.setAttribute("value_gioiTinh", gioiTinh);
		request.setAttribute("value_ngaySinh", ngaySinh);
		request.setAttribute("value_diaChi", diaChi);
		request.setAttribute("value_email", email);
		request.setAttribute("value_sdt", sdt);
		
		
		
		//Phải có mới hiển thị lỗi ở phía backend được
		//url
		String url = "";
		
		if(checkError) {	//nếu có lỗi thì return cái url là cái trang đang thao tác để hiển thị mấy cái lỗi vừa bắt ở trên
			url = "/dangky.jsp";
		}else {
			//Tạo mã khách hàng
			String makh = "";
			if(gioiTinh.equals("Nam")) {
				makh = "KH"+ sdt.substring(sdt.length()-5)+"M";	
			}else if(gioiTinh.equals("Nữ")) {
				makh = "KH"+ sdt.substring(sdt.length()-5)+"F";
			}
			
			//Lưu thông tin khách hàng mới vào database
			KhachHang kh = new KhachHang(makh, hoTen, gioiTinh, ngaySinh, sdt, email, diaChi,tenDangNhap, matKhau);
			khd.insert(kh);
			
			url = "/thanhcong.jsp";
		}
		
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
