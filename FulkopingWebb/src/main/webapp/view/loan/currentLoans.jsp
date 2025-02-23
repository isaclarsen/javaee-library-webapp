<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<h2>Mina Aktuella Lån</h2>
<c:if test="${not empty message}">
    <div class="alert alert-success">
            ${message}
    </div>
</c:if>
<table border="1">
    <tr>
        <th>Boktitel</th>
        <th>Lånedatum</th>
        <th>Sista återlämningsdag</th>
        <th>Åtgärd</th>
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
                    <button type="submit">Återlämna</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="/WEB-INF/fragments/footer.jsp"%>
