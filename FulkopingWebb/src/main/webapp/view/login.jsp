
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Here Login Page Will Be</h1>
<form action="/login" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username" placeholder="Användarnamn">
    <br>
    <label for="password">Lösenord</label>
    <input type="password" id="password" name="password" placeholder="Lösenord">
</form>
<%@include file="../WEB-INF/fragments/footer.jsp"%>