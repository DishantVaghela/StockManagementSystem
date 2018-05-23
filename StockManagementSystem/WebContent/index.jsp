<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="images/general/favicon.ico">
	<title>sign in</title>
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
	  			<img  class="systemLogo" src="images/general/applicationLogo.png">
			</div>
			<div class="col-6">
    			<form action="AuthenticationService" method="post">
					<table>
						<tr>
							<td colspan="2" class="title">AUTHENTICATION</td>
						</tr>
						<tr>
							<td class="information_title">Id</td>
							<td class="information"><input type="text" name="textFieldId"></td>
						</tr>
						<tr>
							<td class="information_title">Password</td>
							<td class="information"><input type="password" name="passwordFieldPassword"></td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<div class="col-6">
									<input type="submit" value="recover password" name="buttonRecoverPassword" style="width:100%;">
								</div>
								<div class="col-6">
									<input type="submit" value="sign in" name="buttonSignIn" style="width:100%;">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>