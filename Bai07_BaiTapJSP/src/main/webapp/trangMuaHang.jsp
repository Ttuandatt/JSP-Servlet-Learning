<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang thanh toán</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- Giả sử: 	
	Processor:	Core I9: 7.000.000, I7: 5.000.000, I5: 3.000.000
	RAM: 16GB: 2.000.000, 8GB: 1.000.000
	Monitor: 21": 4.000.000, 22": 4.500.000, 23": 5.000.000
	Accessories: Camera: 1.000.000, Printer:600.000, Scanner: 800.000
	Tính giá các sản phẩm khi khác hàng chọn
	-->
	<%
	double tongTien = 0;

	//Processor
	String processor = request.getParameter("processor");
	double processorPrice = 0;
	if (processor != null) {
		if (processor.equals("COREI9")) {
			processorPrice = 7000000;
		} else if (processor.equals("COREI7")) {
			processorPrice = 5000000;
		} else if (processor.equals("COREI5")) {
			processorPrice = 3000000;
		}

		tongTien += processorPrice;
	}

	//RAM
	String ram = request.getParameter("ram");
	double ramPrice = 0;
	if (ram != null) {
		if (ram.equals("16GB"))
			ramPrice = 2000000;
		else if (ram.equals("8GB"))
			ramPrice = 1000000;

		tongTien += ramPrice;
	}

	//Monitor
	String monitor = request.getParameter("monitor");
	double monitorPrice = 0;
	if (monitor != null) {
		monitorPrice = 1000000;
		tongTien += monitorPrice;
	}

	String[] accessories = request.getParameterValues("accessories");
	if (accessories != null)
		for (String luaChon : accessories) {
			if (luaChon.equals("Camera")) {
		tongTien += 800000;
			}
			if (luaChon.equals("Scanner")) {
		tongTien += 1500000;
			}
			if (luaChon.equals("Printer")) {
		tongTien += 1500000;
			}
		}
	
	%>
	<h2>TẠM TÍNH</h2><hr>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Tên sản phẩm</th>
				<th scope="col">Giá tiền</th>
			</tr>
		</thead>
		<tbody>
			<%if(processor!=null){%>
				<tr>
					<td><%=processor %></td>
					<td><%=processorPrice %></td>
				</tr>
			<%}%>
			
			<%if(ram!=null) {%>
			<tr>
				<td><%=ram %></td>
				<td><%=ramPrice %></td>
			</tr>
			<%} %>
			
			<%if(monitor!=null) {%>
			<tr>
				<td><%=monitor %></td>
				<td><%=monitorPrice %></td>
			</tr>
			<%} %>
			
			<%if(accessories!=null)
				for(String luaChon: accessories){
					double price=0;
					if(luaChon.equals("Camera"))
						price=1000000;
					if(luaChon.equals("Printer"))
						price=600000;
					if(luaChon.equals("Scanner"))
						price=800000;
			%>
			<tr>
				<td><%=luaChon %></td>
				<td><%=price %></td>
			</tr>
			<%} %>
			
			<tr>
				<td>Tổng tiền</td>
				<td><%=Math.round(tongTien) %></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
