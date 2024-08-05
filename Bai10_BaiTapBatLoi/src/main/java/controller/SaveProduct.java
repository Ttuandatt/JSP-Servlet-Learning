package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/save-product")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveProduct() {
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
		
		String maSanPham = request.getParameter("maSanPham");
		String tenSanPham = request.getParameter("tenSanPham");
		String giaBan_String = request.getParameter("giaBan");
		String giaNhap_String = request.getParameter("giaNhap");
		String hanSuDung_String = request.getParameter("hanSuDung");
		String vat_String =  request.getParameter("vat");
		String moTa =  request.getParameter("moTa");
		
		// check
		String e_maSanPham = "";
		if(maSanPham == null || maSanPham.trim().length()==0) {
			e_maSanPham += "Mã sản phẩm không được để trống!";
		}else if(maSanPham.equals("123")) {
			e_maSanPham += "Mã sản phẩm 123 đã tồn tại, vui lòng nhập lại MSP!";
		}
		request.setAttribute("e_maSanPham", e_maSanPham);
		
		String e_tenSanPham = "";
		if(tenSanPham == null || tenSanPham.trim().length()==0) {
			e_tenSanPham += "Tên sản phẩm không được để trống!";
		}else if(tenSanPham.equals("ABC")) {
			e_tenSanPham += "Tên sản phẩm ABC đã tồn tại, vui lòng nhập lại TSP!";
		}
		request.setAttribute("e_tenSanPham", e_tenSanPham);
		
		String e_giaNhap = "";
		if(giaNhap_String == null || giaNhap_String.trim().length() == 0) {
			e_giaNhap += "Giá nhập không được để trống!"; 
		}else if(giaNhap_String.equals("0")) {
			e_giaNhap += "Giá nhập phải lớn hơn 0";
		}
		request.setAttribute("e_giaNhap", e_giaNhap);
		
		String e_giaBan = "";
		if(giaBan_String == null || giaBan_String.trim().length()==0) {
			e_giaBan += "Giá bán không được để trống!";
		}else if(giaBan_String.equals("0")) {
			e_giaBan +="Giá bán phải lớn hơn 0";
		}
		request.setAttribute("e_giaBan", e_giaBan);
		
		
		// store value
		request.setAttribute("value_maSanPham", maSanPham);
		request.setAttribute("value_tenSanPham", tenSanPham);
		request.setAttribute("value_giaBan", giaBan_String);
		request.setAttribute("value_giaNhap", giaNhap_String);
		request.setAttribute("value_hanSuDung", hanSuDung_String);
		request.setAttribute("value_vat", vat_String);
		request.setAttribute("value_moTa", moTa);
		
		// url
		String url = "/success.jsp";
		
		if(e_maSanPham.length()>0 || e_tenSanPham.length()>0|| e_giaNhap.length()>0 || e_giaBan.length()>0) {
			url = "/product.jsp";
		}
		
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}