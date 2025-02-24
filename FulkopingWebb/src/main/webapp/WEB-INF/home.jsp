<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="fragments/header.jsp"%>
<%@include file="/WEB-INF/fragments/navbar.jsp"%>
<h1>Välkommen till Fulköpings Bibliotek!</h1>
<h3>
    Inloggad som:
    <small class="text-muted">${sessionScope.user.username}</small>
</h3>


<c:if test="${not empty error}">
    <div class="alert alert-danger">
            ${error}
    </div>
</c:if>
<div class="card-group">
    <div class="card">
        <img class="card-img-top" src="https://www.kau.se/files/styles/max_650x650/public/2021-02/thought-catalog-o0Qqw21-0NI-unsplash.jpg?itok=EzFFcE_g" alt="Böcker">
        <div class="card-body">
            <h5 class="card-title">Hur lånar jag en bok?</h5>
            <ol>
                <li class="card-text font-weight-bold">Sök efter en bok eller välj en bok från bokhyllan <br></li>
                <li class="card-text">Tryck på boktiteln och kolla så att boken är tillgänglig<br></li>
                <li class="card-text">Tryck på "låna boken", kolla sedan på dina nuvarande lån för att se deadline på återlämning</li>
            </ol>

            <p class="card-text"><small class="text-muted">Lätt som en plätt!</small></p>
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


<%@include file="fragments/footer.jsp"%>