<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../WEB-INF/fragments/header.jsp"%>

<h1 class="text-center">Välkommen till Fulköpings Bibliotek!</h1>

<c:if test="${not empty error}">
    <div class="alert alert-danger">
            ${error}
    </div>
</c:if>
<c:if test="${not empty message}">
    <div class="success alert-success">
            ${message}
    </div>
</c:if>
<div class="card-group">
    <div class="card">
        <img class="card-img-top" src="https://www.kau.se/files/styles/max_650x650/public/2021-02/thought-catalog-o0Qqw21-0NI-unsplash.jpg?itok=EzFFcE_g" alt="Böcker">
        <div class="card-body">
            <h5 class="card-title"><a href="/login">Logga in</a></h5>
            <p class="card-text">Logga in för att få tillgång till att låna böcker, se lånehistorik med mera!</p>
            <p class="card-text"><small class="text-muted">Har du inget konto? <a href="/register">Registrera dig</a></small></p>
        </div>
    </div>
    <div class="card">
        <img class="card-img-top" src="https://olika.nu/cdn/shop/products/Askungen2_2048x.jpg?v=1650956960" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Sök böcker!</h5>
            <form method="get" action="/search">
                <label for="search"></label>
                <input type="search" id="search" name="q" placeholder="Sök bok">
                <button type="submit" class="btn btn-primary">Sök</button>
            </form>
            <p class="card-text">Här kan du söka på titlar, författare och genre!</p>
            <p class="card-text"><small class="text-muted">Finns inte boken du vill ha? Kontakta oss så fixar vi den!</small></p>
        </div>
    </div>
    <div class="card">
        <img class="card-img-top" src="https://www.bibliotekmitt.se/wp-content/uploads/Bibliotek-i-sverige.svg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title"><a href="/books">Bokhyllan</a></h5>
            <p class="card-text">Vet du inte vad du sa söka efter? Kolla in alla böcker istället!</p>
            <p class="card-text"><small class="text-muted">Listan uppdateras frekvent med nya böcker</small></p>
        </div>
    </div>
</div>


<%@include file="../WEB-INF/fragments/footer.jsp"%>