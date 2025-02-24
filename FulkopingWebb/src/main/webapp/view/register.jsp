
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center">Registrering</h1>
<c:if test="${empty success}">
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                    ${error}
            </div>
        </c:if>
    <div class="container">
        <div class="card w-50 p-3 mx-auto">
            <form action="/register" method="post">
                <div class="form-group m-1">
                    <label for="username">Användarnamn</label>
                    <input class="form-control" type="text" id="username" name="username" value="${username}">
                </div>
                <div class="form-group m-1">
                    <label for="password">Lösenord</label>
                    <input class="form-control" type="password" id="password" name="password" value="${password}">
                </div>
                <div class="form-group m-1">
                    <label for="password2">Lösenord (igen)</label>
                    <input class="form-control" type="password" id="password2" name="password2" value="${password2}">
                </div>
                <button class="btn btn-primary m-1" type="submit">Registrera dig</button>
            </form>
            <p>Om du redan har ett konto hos oss, kan du<a href="/login"> logga in här.</a></p>
        </div>
    </div>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-alert alert-success" role="alert">
        ${success}
        <span><a href="/login">Logga in här!</a></span>
    </div>
</c:if>
<%@include file="../WEB-INF/fragments/footer.jsp"%>
