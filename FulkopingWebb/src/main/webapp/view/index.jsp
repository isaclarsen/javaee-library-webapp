<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<h1>Välkommen till Fulköpings Bibliotek!</h1>'
<a href="view/login.jsp">Logga in</a>
<a href="view/register.jsp">Registrera dig</a>
<br>

<form action="search?q=" method="GET">
    <label for="search"></label>
    <input type="search" id="search" name="q" placeholder="Sök bok">
</form>


<%@include file="../WEB-INF/fragments/footer.jsp"%>