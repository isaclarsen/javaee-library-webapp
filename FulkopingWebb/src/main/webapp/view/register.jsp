
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Registrering</h1>
<c:if test="${empty success}">
    <form action="/register" method="post">
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                    ${error}
            </div>
        </c:if>
        <div>
            <label for="username">Användarnamn</label>
            <input type="text" id="username" name="username" value="${username}">
        </div>
        <div>
            <label for="password">Lösenord</label>
            <input type="password" id="password" name="password" value="${password}">
        </div>
        <div>
            <label for="password2">Lösenord (igen)</label>
            <input type="password" id="password2" name="password2" value="${password2}">
        </div>
        <button type="submit" class="btn btn-primary">Registrera</button>
    </form>
    <p>Om du redan har ett konto hos oss, kan du<a href="view/login.jsp"> logga in här.</a></p>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-alert alert-success" role="alert">
        ${success}
        <span><a href="view/login.jsp">Logga in här!</a></span>
    </div>
</c:if>
<%@include file="../WEB-INF/fragments/footer.jsp"%>