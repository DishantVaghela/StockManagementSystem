<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%	
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="images/general/favicon.ico">
	<title>manage stock list</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">	
</head>
<body>
	<jsp:include page="manageStock.jsp"></jsp:include>
	<div class="body">
		<form name="ManageStockListform" action="ManageStockListService" method="post">
				<input type="hidden" name="hiddenFieldListId">
			<table>
				<tr>
					<td class="title">LIST OF STOCK</td>
				</tr>
			</table>
<%
    PreparedStatement ps=con.prepareStatement("select * from sms_stock");        
	ResultSet rs=ps.executeQuery();  
	
	int temp=0;
	while (rs.next()){
		if(temp%2!=0){
%>		
			<div class="row">
<%
		}
%>
				<div class="col-6">
				
					<table>
						<tr>
							<td colspan="2" class="information_title">
								<img src="images/stock/<%=rs.getString(9)%>">
							</td>
						</tr>
						<tr>
							<td class="information_title">id</td>
							<td class="information">
<%
		if (rs.getString(1)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(1));
		}
%>
							</td>
						</tr>
						<tr>
							<td class="information_title">Description</td>
							<td class="information">
<%
		if (rs.getString(3)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(3));
		}
%>
							</td>
						</tr>
						<tr>
							<td class="information_title">Delivery day</td>
							<td class="information">
<%
		if (rs.getString(2)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(2));
		}
%>
							
							</td>
						</tr>
						<tr>
							<td class="information_title">Permitted By</td>
							<td class="information">
<%
		if (rs.getString(4)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(4));
		}
%>
							</td>
						</tr>
						<tr>
							<td class="information_title">Grant Name</td>
							<td class="information">
<%
		if (rs.getString(5)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(5));
		}
%>
							</td>
						</tr>
						<tr>
							<td class="information_title">Quantity</td>
							<td class="information">
<%
		if (rs.getString(6)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(6));
		}
%>
							</td>
						</tr>
						<tr>
							<td class="information_title">Cost</td>
							<td class="information">
<%
		if (rs.getString(7)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(7));
		}
%>
							</td>
						</tr>
						<tr>
							<td class="information_title">Is Dead Stock</td>
							<td class="information">
<%
		if (rs.getString(8)==null){
			out.print("");
		}
		else{
			out.print(rs.getString(8));
		}
%>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<div class="col-6">
									<input type="submit" value="remove" name="buttonRemove" id="<%=rs.getInt(1)%>" style="width:100%;" onclick="{document.ManageStockListform.hiddenFieldListId.value=this.id;document.ManageStockListform.submit();}">
								</div>
								<div class="col-6">
									<input type="submit" value="edit" name="buttonEditFetch" id="<%=rs.getInt(1)%>" style="width:100%;" onclick="{document.ManageStockListform.hiddenFieldListId.value=this.id;document.ManageStockListform.submit();}">
								</div>
							</td>
						</tr>
					</table>
					
				</div>
<%
		if(temp%2!=0){
%>
			</div>
<%			
		}
		temp++;
	}
%>
		</form>
	</div>
</body>
</html>
<%
	try {
		if (con != null && !con.isClosed())
		{
			con.close();
			Thread.sleep(1000);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
%>