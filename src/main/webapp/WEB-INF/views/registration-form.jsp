<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.register.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
<nav class="container container--70">
    <ul class="nav--actions">
        <li>
            <c:url var="login" value="/login"/>
            <a href="${login}"><spring:message code="pages.header.login"/></a>
        </li>
        <li class="highlighted">
            <c:url var="registration" value="/registration"/>
            <a href="${registration}"><spring:message code="pages.header.register"/></a>
        </li>
    </ul>

    <ul>
        <li>
            <c:url var="home" value="/"/>
            <a href="${home}" class="btn btn--without-border active">
                <spring:message code="pages.header.menu.start"/>
            </a>
        </li>
        <li>
            <c:url var="steps" value="/#steps"/>
            <a href="${steps}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.what"/>
            </a>
        </li>
        <li>
            <c:url var="aboutUs" value="/#about-us"/>
            <a href="${aboutUs}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.about"/>
            </a>
        </li>
        <li>
            <c:url var="help" value="/#help"/>
            <a href="${help}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.fund"/>
            </a>
        </li>
        <li>
            <c:url var="contact" value="/#contact"/>
            <a href="${contact}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.contact"/>
            </a>
        </li>
    </ul>
</nav>
</header>

<section class="login-page">
    <h2><spring:message code="pages.header.register"/></h2>
    <form:form method="post" modelAttribute="registrationData">
        <div class="form-group">
            <spring:message code="pages.register.email" var="emailPlaceholder"/>
            <form:input path="email" required="true" placeholder="${emailPlaceholder}"/>
            <form:errors path="email" element="p"/>
        </div>
        <div class="form-group">
            <spring:message code="pages.register.name" var="namePlaceholder"/>
            <form:input path="name" required="true" placeholder="${namePlaceholder}"/>
            <form:errors path="name" element="p"/>
        </div>
        <div class="form-group">
            <spring:message code="pages.register.surname" var="surnamePlaceholder"/>
            <form:input path="surname" required="true" placeholder="${surnamePlaceholder}"/>
            <form:errors path="surname" element="p"/>
        </div>
        <div class="form-group">
            <spring:message code="pages.register.password" var="passwordPlaceholder"/>
            <form:password path="password" required="true" placeholder="${passwordPlaceholder}"/>
            <form:errors path="password" element="p"/>
        </div>
        <div class="form-group">
            <spring:message code="pages.register.re-password" var="rePasswordPlaceholder"/>
            <form:password path="rePassword" required="true" placeholder="${rePasswordPlaceholder}"/>
            <form:errors path="rePassword" element="p"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.header.register"/></button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>