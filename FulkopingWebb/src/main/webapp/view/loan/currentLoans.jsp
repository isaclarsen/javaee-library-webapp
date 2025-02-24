<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@include file="/WEB-INF/fragments/navbar.jsp"%>
<h2>${sessionScope.user.username}'s aktuella lån</h2>
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
        <th scope="col">Sista återlämningsdag</th>
        <th scope="col">Åtgärd</th>
    </tr>
    <c:forEach var="loan" items="${currentLoans}">
        <tr>
            <td>${loan.book.title}</td>
            <td>${loan.loanDate}</td>
            <td>${loan.returnDate}</td>
            <td>
                <!-- Knapp för att återlämna boken -->
                <form action="loan" method="post">
                    <input type="hidden" name="action" value="return" />
                    <input type="hidden" name="bookId" value="${loan.book.id}" />
                    <button type="submit" class="btn btn-primary">Lämna tillbaka</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
<%@include file="/WEB-INF/fragments/footer.jsp"%>
