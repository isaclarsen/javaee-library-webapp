<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@include file="/WEB-INF/fragments/navbar.jsp"%>
<h2>${sessionScope.user.username}'s låne-historik</h2>
<c:if test="${not empty message}">
    <div class="alert alert-success">
            ${message}
    </div>
</c:if>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Boktitel</th>
        <th scope="col">Lånedatum</th>
        <th scope="col">Returdatum</th>
    </tr>
    <c:forEach var="loan" items="${loanHistory}">
        <tr>
            <td>${loan.book.title}</td>
            <td>${loan.loanDate}</td>
            <td>${loan.returnDate}</td>
        </tr>
    </c:forEach>
    </thead>
</table>
<%@include file="/WEB-INF/fragments/footer.jsp"%>
