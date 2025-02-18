
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${books}" var="book">
  <ul>
    <li>TITEL: ${book.title}</li>
    <li>FÖRFATTARE: ${book.author}</li>
    <li>GENRE: ${book.genre}</li>
  </ul>
</c:forEach>


<%@include file="/WEB-INF/fragments/footer.jsp"%>
