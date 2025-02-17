
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Here Login Page Will Be</h1>
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


<%@include file="../WEB-INF/fragments/footer.jsp"%>