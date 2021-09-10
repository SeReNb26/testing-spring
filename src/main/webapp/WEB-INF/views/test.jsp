<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>name</th>
            <th>age</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
