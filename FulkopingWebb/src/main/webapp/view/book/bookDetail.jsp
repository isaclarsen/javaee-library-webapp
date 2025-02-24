<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<%@ include file="/WEB-INF/fragments/navbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">

    <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>

    <div class="card">
        <div class="card-header">
            <h2>${book.title}</h2>
        </div>
        <div class="card-body">
            <p><strong>Författare:</strong> ${book.author}</p>
            <p><strong>Genre:</strong> ${book.genre}</p>
            <c:choose>
                <c:when test="${book.available}">
                    <p class="text-success"><strong>Status:</strong> Tillgänglig</p>
                    <form action="loan" method="post" class="mt-3">
                        <input type="hidden" name="action" value="borrow" />
                        <input type="hidden" name="bookId" value="${book.id}" />
                        <button type="submit" class="btn btn-primary">Låna boken</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <p class="text-danger"><strong>Status:</strong> Ej tillgänglig</p>
                    <c:if test="${not empty loan}">
                        <p><strong>Förväntas återlämnas:</strong> ${loan.returnDate}</p>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/fragments/footer.jsp" %>
