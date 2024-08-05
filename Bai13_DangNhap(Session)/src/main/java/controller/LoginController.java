package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		//check
		String e_username = "";
		if(username == null || username.trim().length() == 0) {
			e_username += "Username không được để trống!";
		}else if(username.equalsIgnoreCase("abc")) {
			e_username += "Username không hợp lệ!";
		}
		request.setAttribute("e_username", e_username);
		
		String e_password = "";
		if(password == null || password.trim().length() == 0) {
			e_password += "Password không được để trống!";
		}else if(password.equalsIgnoreCase("123")) {
			e_password += "Password không hợp lệ!";
		}
		request.setAttribute("e_password", e_password);
		
		//store value
		request.setAttribute("value_username", username);
		request.setAttribute("value_password", password);
		
		String url = "";
		String errorMessage = "";
		if(username.equalsIgnoreCase("Danny") && password.equals("123")) {
			HttpSession ss = request.getSession();	//Tạo ra session mới
			ss.setAttribute("username", username);	//Lưu trữ username trong session
			url = "/success.jsp";
		}else {
			errorMessage = "Wrong username or password";
			request.setAttribute("errorMessage", errorMessage);
			url = "/login.jsp";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
