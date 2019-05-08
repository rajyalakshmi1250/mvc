<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <table class="table table-bordered" border=1>
        <thead>
            <tr>
                <th>AccountId</th>
            <th>customer_name</th>
        <th>AccountType</th>
    <th>Account_balance</th>
            </tr>
        </thead>
       <tbody>
       <tr>
       <td>${account.accountId}</td>
       <td>${account.accountHolderName}</td>
       <td>${account.accountType}</td>
       <td>${account.accountBalance}</td>
       </tr>
              </tbody>
    </table>


</body>
</html>