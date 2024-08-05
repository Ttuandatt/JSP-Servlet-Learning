package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/dang-nhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String url = "";

		if (tenDangNhap.equalsIgnoreCase("danny") && matKhau.equalsIgnoreCase("123")) {
			url = "/success.jsp";
		} else {
			request.setAttribute("thongBao", "Đăng nhập thất bại do sai tên người dùng hoặc mật khẩu");	
			url = "/login.jsp";	//"url là login.jsp vì ta đang muốn hiển thị thông báo động từ thuộc tính thongBao nên ta phải trỏ về ngay trang login.jsp chứu k phải trang fail.jsp. Nếu trỏ về trang fail.jsp sẽ hiển thị thông báo ở trang fail.jsp mà không hiển thị thông báo đã đượ set ở thuộc tính thongBao"
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
