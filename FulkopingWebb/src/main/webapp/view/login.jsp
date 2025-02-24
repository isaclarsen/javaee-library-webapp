
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center">Logga in</h1>

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
<div class="container">
    <div class="card w-50 p-3 mx-auto">
        <form action="/login" method="post">
            <div class="form-group m-1">
                <label for="username">Användarnamn</label>
                <input class="form-control" type="text" id="username" name="username" value="${username}" placeholder="Användarnamn">
            </div>
            <div class="form-group m-1">
                <label for="password">Lösenord</label>
                <input class="form-control" type="password" id="password" name="password" placeholder="Lösenord">
            </div>

            <button class="btn btn-primary m-1" type="submit">Logga in</button>
        </form>
        <p>Har du inte ett konto hos oss?<a href="view/register.jsp"> Skapa ett här!</a></p>
    </div>
</div>

<%@include file="../WEB-INF/fragments/footer.jsp"%>