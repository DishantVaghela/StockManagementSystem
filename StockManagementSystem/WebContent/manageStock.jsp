<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="images/general/favicon.ico">
	<title>manage stock</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stockManagementSystem.css">	
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="body">
		<form name="formManageStock" action="ManageStockService" method="post" enctype="multipart/form-data">
		<input type="hidden" name="hiddenFieldButtonClicked">
			<div class="row">
				<div class="col-12">
					<table>
						<tr>
							<td colspan="2" class="title">MANAGE STOCK</td>
						</tr>
						<tr>
							<td class="information_title">Description</td>
							<td class="information"><input type="text" name="textFieldDescription"></td>
						</tr>
						<tr>
							<td class="information_title">Delivery Day (dd-mm-yyyy)</td>
							<td class="information"><input type="text" name="textFieldDeliveryDay"></td>
						</tr>
						<tr>
							<td class="information_title">Permitted By</td>
							<td class="information"><input type="text" name="textFieldPermittedBy"></td>
						</tr>
						<tr>
							<td class="information_title">Grant Name</td>
							<td class="information"><input type="text" name="textFieldGrantName"></td>
						</tr>
						<tr>
							<td class="information_title">Quantity</td>
							<td class="information"><input type="text" name="textFieldQuantity"></td>
						</tr>
						<tr>
							<td class="information_title">Cost</td>
							<td class="information"><input type="text" name="textFieldCost"></td>
						</tr>
						<tr>
							<td class="information_title">Is Dead Stock</td>
							<td class="information"><input type="text" name="textFieldIsDeadStock"></td>
						</tr>
						<tr>
							<td class="information_title">Picture</td>
							<td class="information"><input type="file" name="filePicture"></td>
						</tr>
						<tr>
							<td colspan="2" class="information_title">
								<div class="col-6">
									<input type="submit" value="search" name="buttonSearch" style="width:100%;" onclick="{document.formManageStock.hiddenFieldButtonClicked.value=this.name;document.formManageStock.submit();}">
								</div>
								<div class="col-6">
									<input type="submit" value="add" name="buttonAdd" style="width:100%;" onclick="{document.formManageStock.hiddenFieldButtonClicked.value=this.name;document.formManageStock.submit();}">
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
