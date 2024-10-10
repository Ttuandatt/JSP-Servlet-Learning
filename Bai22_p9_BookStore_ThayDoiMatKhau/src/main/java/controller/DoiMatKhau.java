package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

/**
 * Servlet implementation class DoiMatKhau
 */
@WebServlet("/doi-mat-khau")
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String matKhauHienTai = request.getParameter("matKhauHienTai");
		String matKhauMoi = request.getParameter("matKhauMoi");
		String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
		String matKhauHienTai_SHA1 = MaHoa.toSHA1(matKhauHienTai);
		String url="";
		String thongBao="";
		KhachHangDAO khd = new KhachHangDAO();
		KhachHang kh = (KhachHang)session.getAttribute("khachHang");
		
		//Kiểm tra mật khẩu hiện tại có tồn tại dưới CSDL
		if(!khd.checkPassword(kh.getMaKH(), matKhauHienTai_SHA1)) {
			thongBao += "Mật khẩu vừa nhập không tồn tại!";
			url="/doimatkhau.jsp";
		}else {
			if(!matKhauMoiNhapLai.equals(matKhauMoi)) {
				thongBao += "Mật khẩu nhập lại không khớp!";
				url="/doimatkhau.jsp";
			}else {
				String matKhauMoi_SHA1 = MaHoa.toSHA1(matKhauMoi);
				kh.setMatKhau(matKhauMoi_SHA1);
				khd.changePassword(kh);
				thongBao += "Đổi mật khẩu thành công";
				url="/doimatkhau.jsp";
			}
		}
		request.setAttribute("thongBao", thongBao);
		
		//restore values
		request.setAttribute("value_matKhauHienTai", matKhauHienTai);
		request.setAttribute("value_matKhauMoi", matKhauMoi);
		request.setAttribute("value_matKhauMoiNhapLai", matKhauMoiNhapLai);
		
		if(khd.changePassword(kh)>0) {
			response.sendRedirect("index.jsp"); // Chuyển hướng về trang chủ
		}else {
			// Đổi mật khẩu thất bại, quay lại form và hiển thị thông báo lỗi
	        request.setAttribute("thongBao", "Đổi mật khẩu thất bại!");
	        request.getRequestDispatcher("/doiMatKhau.jsp").forward(request, response);
		}
		
		
	}

}
