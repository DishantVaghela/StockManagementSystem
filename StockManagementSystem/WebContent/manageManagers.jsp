<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="images/general/favicon.ico">
	<title>manage managers</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">	
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="body">
		<form name="formManageManagers" action="ManageManagersService" method="post" enctype="multipart/form-data">
		<input type="hidden" name="hiddenFieldButtonClicked">
			<div class="row">
				<div class="col-12">
					<table>
						<tr>
							<td colspan="2" class="title">MANAGE MANAGERS</td>
						</tr>
						<tr>
							<td class="information_title">Manager Id</td>
							<td class="information"><input type="text" name="textFieldManagerId"></td>
						</tr>
						<tr>
							<td class="information_title">Password</td>
							<td class="information"><input type="text" name="textFieldPassword"></td>
						</tr>
						<tr>
							<td class="information_title">Recovery Question</td>
							<td class="information"><input type="text" name="textFieldRecoveryQuestion"></td>
						</tr>
						<tr>
							<td class="information_title">Recovery Answer</td>
							<td class="information"><input type="text" name="textFieldRecoveryAnswer"></td>
						</tr>
						<tr>
							<td class="information_title">Email Id</td>
							<td class="information"><input type="text" name="textFieldEmailId"></td>
						</tr>
						<tr>
							<td class="information_title">Picture</td>
							<td class="information"><input type="file" name="filePicture"></td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<div class="col-6">
									<input type="submit" value="search" name="buttonSearch" style="width:100%;" onclick="{document.formManageManagers.hiddenFieldButtonClicked.value=this.name;document.formManageManagers.submit();}">
								</div>
								<div class="col-6">
									<input type="submit" value="add" name="buttonAdd" style="width:100%;" onclick="{document.formManageManagers.hiddenFieldButtonClicked.value=this.name;document.formManageManagers.submit();}">
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
