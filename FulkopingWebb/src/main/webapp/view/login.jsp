
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Here Login Page Will Be</h1>
<form action="/login" method="post">

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <c:if test="${not empty message}">
        <div class="alert alert-success">
            ${message}
        </div>
    </c:if>

    <div>
        <label for="username">Användarnamn</label>
        <input type="text" id="username" name="username" value="${username}" placeholder="Användarnamn">
    </div>

    <br>
    <div>
        <label for="password">Lösenord</label>
        <input type="password" id="password" name="password" placeholder="Lösenord">
    </div>

    <button type="submit">Logga in</button>
</form>
<p>Har du inte ett konto hos oss?<a href="view/register.jsp"> Skapa ett här!</a></p>
<%@include file="../WEB-INF/fragments/footer.jsp"%>