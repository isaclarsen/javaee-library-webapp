
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@include file="/WEB-INF/fragments/navbar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty error}">
    <span>${error}</span>
</c:if>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Titel</th>
        <th scope="col">Författare</th>
        <th scope="col">Genre</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td><a href="/books?id=${book.id}">${book.title}</a></td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%@include file="/WEB-INF/fragments/footer.jsp"%>
