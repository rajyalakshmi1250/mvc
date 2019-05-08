<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<form action="updatedetails.do" method="post">
		accountId <input type="text" name="accountId"
			value="${account.accountId}" readonly="readonly"><br>
		customer name <input type="text" name="customername"
			value="${account.accountHolderName}"><br>
		<br> account type <select name="accounttype">
			<option>${account.accountType}</option>
			<option value="saving">Saving Account</option>
			<option value="current">current Account</option>
		</select> <br> <br>account balance <input type="text"
			name="accountbalance" value="${account.accountBalance}" readonly="readonly"><br>
			<br><input type="submit" value="update">
	</form>

</body>
</html>