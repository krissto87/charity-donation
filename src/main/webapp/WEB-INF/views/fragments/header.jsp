<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<header>--%>
<nav class="container container--70">
    <ul class="nav--actions">
        <sec:authorize access="hasRole('USER')">
        <li class="logged-user">
                <spring:message code="pages.user.header.welcome"/> ${pageContext.request.userPrincipal.name}

                <ul class="dropdown">
                    <li><a href="/user"><spring:message code="pages.user.header.profile"/></a></li>
                    <li><a href="/user/settings"><spring:message code="pages.user.header.settings"/></a></li>
                    <li><a href="/user/collection"><spring:message code="pages.user.header.collection"/></a></li>
                    <li>
                        <c:url var="logoutURL" value="/logout"/>
                        <form method="post" action="${logoutURL}">
                            <button class="btn btn--small btn--without-border" type="submit">
                                <spring:message code="pages.user.header.logout"/></button>
                            <sec:csrfInput/>
                        </form>
                    </li>
                </ul>
        </li>
        </sec:authorize>
    </ul>

    <ul class="nav--actions">
        <sec:authorize access="!isAuthenticated()">
        <li><a href="/login" class="btn btn--small btn--without-border"><spring:message code="pages.header.login"/></a></li>
        <li><a href="/registration" class="btn btn--small btn--highlighted"><spring:message code="pages.header.register"/></a></li>
        </sec:authorize>
    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border active"><spring:message code="pages.header.menu.start"/></a></li>
        <li><a href="#steps" class="btn btn--without-border"><spring:message code="pages.header.menu.what"/></a></li>
        <li><a href="#about-us" class="btn btn--without-border"><spring:message code="pages.header.menu.about"/></a></li>
        <li><a href="#help" class="btn btn--without-border"><spring:message code="pages.header.menu.fund"/></a></li>
        <sec:authorize access="!isAuthenticated()">
        <li><a href="/user/donation" class="btn btn--without-border"><spring:message code="pages.header.menu.give"/></a></li>
        </sec:authorize>
        <li><a href="#contact" class="btn btn--without-border"><spring:message code="pages.header.menu.contact"/></a></li>
    </ul>
</nav>
<%--</header>--%>