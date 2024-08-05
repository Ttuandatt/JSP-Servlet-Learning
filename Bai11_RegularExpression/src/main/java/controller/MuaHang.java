package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MuaHang
 */
@WebServlet("/mua-hang")
public class MuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuaHang() {
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
		
		String soLuong_String = request.getParameter("soLuong");
		String sdt_String = request.getParameter("sdt");
		String email_String = request.getParameter("email");
		
		boolean checkError = false;
		//Kiểm tra số lượng
		double soLuong = 0;
		try {
			soLuong = Double.parseDouble(soLuong_String);	//Khi parse thất bại, biến soLuong sẽ được set mặc định là 0 
			if(soLuong<=0) {
				checkError = true;
				request.setAttribute("e_soLuong", "Số lượng mua phải lớn hơn 0*");
			}
		}catch (Exception e) {
			checkError = true;
			request.setAttribute("e_soLuong", "Vui lòng nhập đúng định dạng số*");
		}
		 
		//Kiểm tra sdt
		if(sdt_String == null || sdt_String.trim().length() == 0) {
			checkError = true;
			request.setAttribute("e_sdt", "Vui lòng nhập số điện thoại*");
		}else {
			Pattern sdtPattern = Pattern.compile("\\d{10}");
			Matcher sdtMatcher = sdtPattern.matcher(sdt_String);
			if(!sdtMatcher.matches()) {
				checkError = true;
				request.setAttribute("e_sdt", "Số điện thoại gồm 10 chữ số*");
			}
		}
		
		if(email_String == null || email_String.trim().length() == 0) {
			checkError = true;
			request.setAttribute("e_email", "Vui lòng nhập email*");
		}else {
			Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)*");
			Matcher emailMatcher = emailPattern.matcher(email_String);
			if(!emailMatcher.matches()) {
				checkError = true;
				request.setAttribute("e_email", "Vui lòng nhập đúng định dạng email (abc@gmail.com)");
			}
		}
		
		//forward value
		request.setAttribute("value_soLuong", soLuong_String);
		request.setAttribute("value_sdt", sdt_String);
		request.setAttribute("value_email", email_String);
		
		String url = "/success.jsp";
		if(checkError) {
			url = "/index.jsp";
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
/*
Pattern: sdtPattern
This is an instance of the Pattern class from the java.util.regex package.
Method: compile(String regex)
The compile method compiles the given regular expression (regex) into a pattern.
Regex: "\\d{10}"
The regular expression \\d{10} represents a sequence of exactly 10 digits.
\\d is a shorthand character class for any digit (0-9).
{10} is a quantifier specifying that exactly 10 of the preceding element (\\d) should be matched.
In summary, this line creates a pattern that matches any string consisting of exactly 10 digits.

Matcher: sdtMatcher
This is an instance of the Matcher class from the java.util.regex package.
Method: matcher(CharSequence input)
The matcher method creates a matcher that will match the given input string against the pattern.
Input: sdt_String
This is the string input for the phone number provided by the user.
In summary, this line creates a matcher that will check if sdt_String conforms to the pattern \\d{10}.

Method: matches()
The matches method attempts to match the entire input sequence against the pattern.
If the input string matches the pattern, it returns true; otherwise, it returns false.
The ! operator negates the result.
In summary, this line checks if sdt_String does not match the pattern of exactly 10 digits.
*/
