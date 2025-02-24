<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand text-weight-bold" href="/home">Fulköping Bibliotek</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link" href="/books">Bokhyllan</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Profil
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/loanHistory">Min Lånehistorik</a></li>
                        <li><a class="dropdown-item" href="/currentLoans">Mina nuvarande lån</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/login?logout=true">Logga ut</a></li>
                    </ul>
                </li>
            </ul>
            <form method="get" action="/search">
                <label for="search"></label>
                <input type="search" id="search" name="q" placeholder="Sök bok">
                <button type="submit" class="btn btn-primary">Sök</button>
            </form>
        </div>
    </div>
</nav>
