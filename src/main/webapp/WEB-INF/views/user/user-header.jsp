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
                <li><a href="#"><spring:message code="pages.user.header.profile"/></a></li>
                <li><a href="#"><spring:message code="pages.user.header.settings"/></a></li>
                <li><a href="#"><spring:message code="pages.user.header.collection"/></a></li>
                <li><a href="#"><spring:message code="pages.user.header.logout"/></a></li>
            </ul>
        </li>
    </ul>

    <ul>
        <li><a href="index.html" class="btn btn--without-border active"><spring:message code="pages.header.menu.start"/></a></li>
        <li><a href="index.html#steps" class="btn btn--without-border"><spring:message code="pages.header.menu.what"/></a></li>
        <li><a href="index.html#about-us" class="btn btn--without-border"><spring:message code="pages.header.menu.about"/></a></li>
        <li><a href="index.html#help" class="btn btn--without-border"><spring:message code="pages.header.menu.fund"/></a></li>
        <li><a href="index.html#contact" class="btn btn--without-border"><spring:message code="pages.header.menu.contact"/></a></li>
    </ul>
</nav>

<%--</header>--%>