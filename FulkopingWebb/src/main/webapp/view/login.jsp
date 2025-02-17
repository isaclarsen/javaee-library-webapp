<%--
  Created by IntelliJ IDEA.
  User: IsacL
  Date: 2025-02-13
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <h1>Here Login Page Will Be</h1>
</head>
<body>
<p>test</p>
<c:forEach items="${books}" var="book">
    <!--Test-->
    <ul>
        <li>${book.id}</li>
        <li>${book.title}</li>
        <li>${book.author}</li>
        <li>${book.genre}</li>
    </ul>
</c:forEach>
</body>
</html>
