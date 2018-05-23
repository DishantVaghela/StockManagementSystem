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
	<title>manage general or extra information</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">	
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="body">
		<form name="formManageGeneralOrExtraInformation" action="ManageGeneralOrExtraInformationService" method="post" enctype="multipart/form-data">
			<input type="hidden" name="hiddenFieldButtonClicked">
			<div class="row">
				<div class="col-6">
					<%
						PreparedStatement ps=con.prepareStatement("select * from sms_general where id=0"); 
					    
						ResultSet rs=ps.executeQuery();  
						rs.next();
					%>
					<table>
						<tr>
							<td colspan="2" class="title">MANAGE GENERAL INFORMATION</td>
						</tr>
						<tr>
							<td class="information_title">Application Version</td>
							<td class="information"><input type="text" name="textFieldApplicationVersion" value="<%=rs.getString(4)%>"></td>
						</tr>
						<tr>
							<td class="information_title">Right Year</td>
							<td class="information"><input type="text" name="textFieldRightYear" value="<%=rs.getString(1)%>"></td>
						</tr>
						<tr>
							<td class="information_title">Right Entity</td>
							<td class="information"><input type="text" name="textFieldRightEntity" value="<%=rs.getString(2)%>"></td>
						</tr>
						<tr>
							<td class="information_title">Right Reserved</td>
							<td class="information"><input type="text" name="textFieldRightReserved" value="<%=rs.getString(3)%>"></td>
						</tr>
						<tr>
							<td class="information_title">Application Email Id</td>
							<td class="information"><input type="text" name="textFieldApplicationEmailId" value="<%=rs.getString(6)%>"></td>
						</tr>
						<tr>
							<td class="information_title">Application Email password</td>
							<td class="information"><input type="password" name="textFieldApplicationEmailPassword" value="<%=rs.getString(7)%>"></td>
						</tr>
						<tr>
							<td class="information_title">Background Image</td>
							<td class="information"><input type="file" name="fileBackgroundImage"></td>
						</tr>
						<tr>
							<td class="information_title">Entity Logo</td>
							<td class="information"><input type="file" name="fileEntityLogo"></td>
						</tr>
						<tr>
							<td class="information_title">Application Logo</td>
							<td class="information"><input type="file" name="fileApplicationLogo"></td>
						</tr>
						<tr>
							<td class="information_title">Contact Logo</td>
							<td class="information"><input type="file" name="fileContactLogo"></td>
						</tr>
						<tr>
							<td class="information_title">Social Logo</td>
							<td class="information"><input type="file" name="fileSocialLogo"></td>
						</tr>
						<tr>
							<td class="information_title">Mail Logo</td>
							<td class="information"><input type="file" name="fileMailLogo"></td>
						</tr>
						<tr>
							<td class="information_title">Location Logo</td>
							<td class="information"><input type="file" name="fileLocationLogo"></td>
						</tr>
						<tr>
							<td class="information_title">favicon</td>
							<td class="information"><input type="file" name="fileFavicon"></td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<div class="col-12">
									<input type="submit" value="edit" name="buttonEditGeneral" style="width:100%;" onclick="{document.formManageGeneralOrExtraInformation.hiddenFieldButtonClicked.value=this.name;document.formManageGeneralOrExtraInformation.submit();}">
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div class="col-6">
					<table>
						<tr>
							<td colspan="2" class="title">MANAGE EXTRA INFORMATION</td>
						</tr>
						<tr>
							<td class="information_title">Entity</td>
							<td class="information"><input type="text" name="textFieldEntity"></td>
						</tr>
						<tr>
							<td class="information_title">Contact</td>
							<td class="information"><input type="text" name="textFieldContact"></td>
						</tr>
						<tr>
							<td class="information_title">Social</td>
							<td class="information"><input type="text" name="textFieldSocial"></td>
						</tr>
						<tr>
							<td class="information_title">Email</td>
							<td class="information"><input type="text" name="textFieldEmail"></td>
						</tr>
						<tr>
							<td class="information_title">Location</td>
							<td class="information"><input type="text" name="textFieldLocation"></td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<div class="col-6">
									<input type="submit" value="search" name="buttonSearchExtra" style="width:100%;" onclick="{document.formManageGeneralOrExtraInformation.hiddenFieldButtonClicked.value=this.name;document.formManageGeneralOrExtraInformation.submit();}">
								</div>
								<div class="col-6">
									<input type="submit" value="add" name="buttonAddExtra" style="width:100%;" onclick="{document.formManageGeneralOrExtraInformation.hiddenFieldButtonClicked.value=this.name;document.formManageGeneralOrExtraInformation.submit();}">
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
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