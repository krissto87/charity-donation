<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.login.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login"><spring:message code="pages.header.login"/></a></li>
            <li class="highlighted"><a href="#"><spring:message code="pages.header.register"/></a></li>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active"><spring:message code="pages.header.menu.start"/></a></li>
            <li><a href="/#steps" class="btn btn--without-border"><spring:message code="pages.header.menu.what"/></a></li>
            <li><a href="/#about-us" class="btn btn--without-border"><spring:message code="pages.header.menu.about"/></a></li>
            <li><a href="/#help" class="btn btn--without-border"><spring:message code="pages.header.menu.fund"/></a></li>
            <li><a href="/#contact" class="btn btn--without-border"><spring:message code="pages.header.menu.contact"/></a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h2><spring:message code="pages.login.login"/></h2>
    <form method="post" action="/login">
        <div class="form-group">
            <spring:message code="pages.login.form.email" var="emailPlaceholder"/>
            <input type="email" name="email" placeholder="${emailPlaceholder}" />
            <c:if test="${param['error'] != null}">
                <p><spring:message code="pages.login.form.login-error"/></p>
            </c:if>
        </div>
        <div class="form-group">
            <spring:message code="pages.login.form.password" var="passPlaceholder"/>
            <input type="password" name="password" required placeholder="${passPlaceholder}" />
            <a href="#" class="btn btn--small btn--without-border reset-password">
                <spring:message code="pages.login.remind"/>
            </a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/registration" class="btn btn--without-border">
                <spring:message code="pages.login.create"/>
            </a>
            <button class="btn" type="submit"><spring:message code="pages.login.login"/></button>
        </div>
        <sec:csrfInput/>
    </form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>