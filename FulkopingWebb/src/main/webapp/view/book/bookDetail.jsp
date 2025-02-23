<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>${book.title}</p>
<p>${book.author}</p>
<p>${book.genre}</p>
<c:choose>
    <c:when test="${book.available}">
        Tillgänglig
        <!-- Visa knappen för att låna boken -->
        <form action="loan" method="post">
            <input type="hidden" name="action" value="borrow" />
            <input type="hidden" name="bookId" value="${book.id}" />
            <button type="submit">Låna boken</button>
        </form>
    </c:when>
    <c:otherwise>
        Ej tillgänglig
    </c:otherwise>
</c:choose>

<%@include file="/WEB-INF/fragments/footer.jsp"%>
