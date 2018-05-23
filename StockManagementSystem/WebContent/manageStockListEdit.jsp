<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<title>edit stock</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">	
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="body">
		<form name="formManageStockListEdit"  action="ManageStockListEditService" method="post" enctype="multipart/form-data">
		<input type="hidden" name="hiddenFieldButtonClicked">
<%
	String editId = (String)request.getAttribute("editId");
	
    PreparedStatement ps=con.prepareStatement("select * from sms_stock where id=?"); 
	ps.setString(1,editId);  
    
	ResultSet rs=ps.executeQuery();  
	rs.next();
%>	
			<table>
				<tr>
					<td colspan="2" class="title">EDIT STOCK
						<input type="hidden" name="hiddenFieldId" value="<%=rs.getInt(1)%>">
					</td>
				</tr>
				<tr>
					<td class="information_title">Description</td>
					<td class="information"><input type="text" name="textFieldDescription" value="<%=rs.getString(3)%>"></td>
				</tr>
				<tr>
					<td class="information_title">Delivery Day (dd-mm-yyyy)</td>
					<td class="information"><input type="text" name="textFieldDeliveryDay" value="<%=rs.getString(2)%>"></td>
				</tr>
				<tr>
					<td class="information_title">Permitted By</td>
					<td class="information"><input type="text" name="textFieldPermittedBy" value="<%=rs.getString(4)%>"></td>
				</tr>
				<tr>
					<td class="information_title">Grant Name</td>
					<td class="information"><input type="text" name="textFieldGrantName" value="<%=rs.getString(5)%>"></td>
				</tr>
				<tr>
					<td class="information_title">Quantity</td>
					<td class="information"><input type="text" name="textFieldQuantity" value="<%=rs.getString(6)%>"></td>
				</tr>
				<tr>
					<td class="information_title">Cost</td>
					<td class="information"><input type="text" name="textFieldCost" value="<%=rs.getString(7)%>"></td>
				</tr>
				<tr>
					<td class="information_title">Is Dead Stock</td>
					<td class="information"><input type="text" name="textFieldIsDeadStock" value="<%=rs.getString(8)%>"></td>
				</tr>
				<tr>
					<td class="information_title">Picture</td>
					<td class="information"><input type="file" name="filePicture"></td>
				</tr>
				<tr>
					<td colspan="2" class="information_title">
						<input type="submit" value="edit" name="buttonEdit" style="width:100%;" onclick="{document.formManageStockListEdit.hiddenFieldButtonClicked.value=this.name;document.formManageStockListEdit.submit();}">
					</td>
				</tr>
			</table>
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