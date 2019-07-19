<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="2">
    <tr>
        <td>Name</td>
        <td>Surname</td>
        <td>Account</td>
    </tr>
    <tr>
        <td>${user.getName()}</td>
        <td>${user.getSurName()}</td>
        <td>${user.getAccount()}</td>
    </tr>
</table>
</body>
</html>