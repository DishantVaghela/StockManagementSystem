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
	<title>header</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">	
</head>
<body>
	<div class="header">
		<div class="row">
			<div class="col-6">
	  			<img src="images/general/entityLogo.png">
	  			<img src="images/general/applicationLogo.png">
			</div>
			<div class="col-6">
				<img src="images/managers/<%=session.getAttribute("session_id")%>.png">
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<form action="HeaderService" method="post">
					<table>
						<tr>
							<td >
								<div class="col-12">
								<input type="submit" value="sign out <%=session.getAttribute("session_id")%>" name="buttonSignOut" style="width:100%;">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="col-4">
									<input type="submit" value="manage general or extra information" name="buttonManageGeneralOrExtraInformation" style="width:100%;">
								</div>
								<div class="col-4">
									<input type="submit" value="manage managers" name="buttonManageManagers" style="width:100%;">
								</div>
								<div class="col-4">
									<input type="submit" value="manage stock" name="buttonManageStock" style="width:100%;">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
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