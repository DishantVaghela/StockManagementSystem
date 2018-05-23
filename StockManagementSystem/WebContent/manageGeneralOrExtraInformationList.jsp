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
	<title>manage extra information list</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">	
</head>
<body>
	<jsp:include page="manageGeneralOrExtraInformation.jsp"></jsp:include>
	<div class="body">
		<form name="ManageGeneralOrExtraInformationListform" action="ManageGeneralOrExtraInformationListService" method="post">
				<input type="hidden" name="hiddenFieldListId">
			<table>
				<tr>
					<td class="title">LIST OF EXTRA INFORMATION</td>
				</tr>
			</table>
<%
/*
	String entity,contact,social,email,location;

	if(((String)request.getAttribute("entity")).equals("")){
		entity="dontFetch";
	}
	else{
		entity = (String)request.getAttribute("entity");
	}
	if(((String)request.getAttribute("contact")).equals("")){
		contact="dontFetch";
	}
	else{
		contact = (String)request.getAttribute("contact");
	}
	if(((String)request.getAttribute("social")).equals("")){
		social="dontFetch";
	}
	else{
		social = (String)request.getAttribute("social");
	}
	if(((String)request.getAttribute("email")).equals("")){
		email="dontFetch";
	}
	else{
		email = (String)request.getAttribute("email");
	}
	if(((String)request.getAttribute("location")).equals("")){
		location="dontFetch";
	}
	else{
		location = (String)request.getAttribute("location");
	}*/
	String select="select * from sms_extra ";
	
	/*	entity = (String)request.getAttribute("entity");
	contact = (String)request.getAttribute("contact");
	social = (String)request.getAttribute("social");
	email = (String)request.getAttribute("email");
	location = (String)request.getAttribute("location");
	*/
    PreparedStatement ps=con.prepareStatement(select);        
    
    
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
							<td class="information_title">Entity</td>
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
							<td class="information_title">Contact</td>
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
							<td class="information_title">Social</td>
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
							<td class="information_title">Email</td>
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
							<td class="information_title">Location</td>
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
							<td colspan="2" class="information_title">
								<div class="col-6">
									<input type="submit" value="remove" name="buttonRemoveExtra" id="<%=rs.getInt(1)%>" style="width:100%;" onclick="{document.ManageGeneralOrExtraInformationListform.hiddenFieldListId.value=this.id;document.ManageGeneralOrExtraInformationListform.submit();}">
								</div>
								<div class="col-6">
									<input type="submit" value="edit" name="buttonEditExtraFetch" id="<%=rs.getInt(1)%>" style="width:100%;" onclick="{document.ManageGeneralOrExtraInformationListform.hiddenFieldListId.value=this.id;document.ManageGeneralOrExtraInformationListform.submit();}">
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