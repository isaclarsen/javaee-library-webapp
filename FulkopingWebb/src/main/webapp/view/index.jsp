<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<h1>Välkommen till Fulköpings Bibliotek!</h1>'
<a href="view/login.jsp">Logga in</a>
<a href="view/register.jsp">Registrera dig</a>
<br>


<form action="/search" method="GET">

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
                ${error}
        </div>
    </c:if>

    <label for="search"></label>
    <input type="search" id="search" name="q" placeholder="Sök bok">
    <button type="submit" class="btn btn-primary">Sök</button>
</form>


<%@include file="../WEB-INF/fragments/footer.jsp"%>