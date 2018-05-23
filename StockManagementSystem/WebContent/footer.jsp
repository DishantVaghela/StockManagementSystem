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
	<title>footer</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">
</head>
<body>
	<div class="footer">
		<div class="row">
			<div class="col-6">
				<table>
					<tr>
						<td class="information_title" colspan="2"><img src="images/general/contactLogo.png"></td>
					</tr>
					<%
						try{  
							PreparedStatement ps=con.prepareStatement("select entity, contact from sms_extra where contact is not null");  
							ResultSet rs = ps.executeQuery();
							while (rs.next()){
					%>
					<tr>
						<td class="information_title"><%=rs.getString(1)%></td>
						<td class="information"><%=rs.getString(2)%></td>
					</tr>
					<%
							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					%>
				</table>
			</div>
			<div class="col-6">
				<table>
					<tr>
						<td class="information_title" colspan="2"><img src="images/general/socialLogo.png"></td>
					</tr>
					<%
						try{  
							PreparedStatement ps=con.prepareStatement("select entity, social from sms_extra where social is not null");  
							ResultSet rs = ps.executeQuery();
							while (rs.next()){
					%>
					<tr>
						<td class="information_title"><%=rs.getString(1)%></td>
						<td class="information"><%=rs.getString(2)%></td>
					</tr>
					<%
							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					%>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-6">
				<table>
					<tr>
						<td class="information_title" colspan="2"><img src="images/general/mailLogo.png"></td>
					</tr>
					<%
						try{  
							PreparedStatement ps=con.prepareStatement("select entity, email from sms_extra where email is not null");  
							ResultSet rs = ps.executeQuery();
							while (rs.next()){
					%>
					<tr>
						<td class="information_title"><%=rs.getString(1)%></td>
						<td class="information"><%=rs.getString(2)%></td>
					</tr>
					<%
							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					%>
				</table>
			</div>
			<div class="col-6">
				<table>
					<tr>
						<td class="information_title" colspan="2"><img src="images/general/locationLogo.png"></td>
					</tr>
					<%
						try{  
							PreparedStatement ps=con.prepareStatement("select entity, location from sms_extra where location is not null");  
							ResultSet rs = ps.executeQuery();
							while (rs.next()){
					%>
					<tr>
						<td class="information_title"><%=rs.getString(1)%></td>
						<td class="information"><%=rs.getString(2)%></td>
					</tr>
					<%
							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					%>
				</table>
			</div>
		</div><br><br>
		
		
		
		<div class="row" style="background-color:rgba(174,87,65,0.9); font-size:12px">
			<%
				try{  
					PreparedStatement ps=con.prepareStatement("select * from sms_general");  
					ResultSet rs = ps.executeQuery();
					while (rs.next()){
			%>
			<div class="col-6">
				<%=rs.getString(4)%>
			</div>
			<div class="col-6">
				<%=rs.getString(1)%><br><%=rs.getString(2)%><br><%=rs.getString(3)%>
			</div>
			<%
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			%>
		</div>
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