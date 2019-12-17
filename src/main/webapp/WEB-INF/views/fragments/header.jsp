<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<header>--%>
<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href="" class="btn btn--small btn--without-border"><fmt:message key="pages.header.login"/></a></li>
        <li><a href="#" class="btn btn--small btn--highlighted"><fmt:message key="pages.header.register"/></a></li>
    </ul>

    <ul>
        <li><a href="#" class="btn btn--without-border active"><fmt:message key="pages.header.menu.start"/></a></li>
        <li><a href="#" class="btn btn--without-border"><fmt:message key="pages.header.menu.what"/></a></li>
        <li><a href="#" class="btn btn--without-border"><fmt:message key="pages.header.menu.about"/></a></li>
        <li><a href="#" class="btn btn--without-border"><fmt:message key="pages.header.menu.fund"/></a></li>
        <li><a href="#" class="btn btn--without-border"><fmt:message key="pages.header.menu.contact"/></a></li>
    </ul>
</nav>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            <fmt:message key="pages.header.menu.slogan.main"/> <br/>
            <fmt:message key="pages.header.menu.slogan.sub"/>
        </h1>
    </div>
</div>
<%--</header>--%>