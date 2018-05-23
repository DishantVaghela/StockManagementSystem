<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%	
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="images/general/favicon.ico">
	<title>recover password</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">
</head>
<body>
	<div class="header">
  		<img src="images/general/entityLogo.png">
	</div>
	<div class="body">
		<div class="row">
			<div class="col-6">
	  			<img class="systemLogo" src="images/general/applicationLogo.png">
			</div>
			<div class="col-6">
				<form action="RecoverPasswordService" method="post">
					<table>
						<%
							try{  
								String signInId=request.getParameter("textFieldId");
								PreparedStatement ps=con.prepareStatement("select * from sms_managers where manager_id=?");  
								ps.setString(1,signInId);  
								ResultSet rs = ps.executeQuery(); 
								if (rs.next())
								{
						%>
						<tr>
							<td colspan="2" class="title">RECOVER PASSWORD</td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<img src="images/managers/<%=rs.getString(7)%>">
							</td>
						</tr>
						<tr>
							<td class="information_title">Recovery Question</td>
							<td class="information"><%=rs.getString(4)%></td>
						</tr>
						<tr>
							<td class="information_title">Recovery Answer</td>
							<td class="information"><input type="text" name="textFieldRecoveryAnswer"></td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<input type="hidden" name="hiddenFieldManagerId" value="<%=rs.getString(2)%>">
								<input type="hidden" name="hiddenFieldEmailId" value="<%=rs.getString(6)%>">
								<div class="col-6">
									<input type="submit" value="go back" name="buttonGoBack" style="width:100%;">
								</div>
								<div class="col-6">
									<input type="submit" value="go ahead" name="buttonGoAhead" style="width:100%;">
								</div>
							</td>
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
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
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