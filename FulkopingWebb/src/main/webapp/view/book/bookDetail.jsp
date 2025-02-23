<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty message}">
    <div class="alert alert-success">
            ${message}
    </div>
</c:if>

<p><strong>Titel:</strong> ${book.title}</p>
<p><strong>Författare:</strong> ${book.author}</p>
<p><strong>Genre:</strong> ${book.genre}</p>

<c:choose>
    <c:when test="${book.available}">
        <p style="color: green;">Tillgänglig</p>
        <form action="loan" method="post">
            <input type="hidden" name="action" value="borrow" />
            <input type="hidden" name="bookId" value="${book.id}" />
            <button type="submit">Låna boken</button>
        </form>
    </c:when>
    <c:otherwise>
        <p style="color: red;">Ej tillgänglig</p>
        <c:if test="${not empty loan}">
            <p><strong>Förväntas återlämnas:</strong> ${loan.returnDate}</p>
        </c:if>
    </c:otherwise>
</c:choose>

<%@include file="/WEB-INF/fragments/footer.jsp"%>
