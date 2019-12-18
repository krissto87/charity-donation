<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<header>--%>
<nav class="container container--70">
    <ul class="nav--actions">
        <li class="logged-user">
<%--            Pobieraj imie użytkownika--%>
            Witaj Agata
            <ul class="dropdown">
                <li><a href="#"><fmt:message key="pages.user.header.profile"/></a></li>
                <li><a href="#"><fmt:message key="pages.user.header.settings"/></a></li>
                <li><a href="#"><fmt:message key="pages.user.header.collection"/></a></li>
                <li><a href="#"><fmt:message key="pages.user.header.logout"/></a></li>
            </ul>
        </li>
    </ul>

    <ul>
        <li><a href="index.html" class="btn btn--without-border active"><fmt:message key="pages.header.menu.start"/></a></li>
        <li><a href="index.html#steps" class="btn btn--without-border"><fmt:message key="pages.header.menu.what"/></a></li>
        <li><a href="index.html#about-us" class="btn btn--without-border"><fmt:message key="pages.header.menu.about"/></a></li>
        <li><a href="index.html#help" class="btn btn--without-border"><fmt:message key="pages.header.menu.fund"/></a></li>
        <li><a href="index.html#contact" class="btn btn--without-border"><fmt:message key="pages.header.menu.contact"/></a></li>
    </ul>
</nav>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Oddaj rzeczy, których już nie chcesz<br />
            <span class="uppercase">potrzebującym</span>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span>Wybierz rzeczy</span></div>
                </li>
                <li>
                    <div><em>2</em><span>Spakuj je w worki</span></div>
                </li>
                <li>
                    <div><em>3</em><span>Wybierz fundację</span></div>
                </li>
                <li>
                    <div><em>4</em><span>Zamów kuriera</span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
<%--</header>--%>