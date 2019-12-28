<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.user.settings.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>

    <section class="login-page">
        <h2><spring:message code="pages.user.settings.slogan"/></h2>
        <div class="about-us--text">
            <p>
                <c:url var="usernameChange" value="/user/settings/username-change"/>
                <a href="${usernameChange}">
                    <spring:message code="pages.user.setting.email-change"/>
                </a>

                <c:url var="PasswordChange" value="/user/settings/password-change"/>
                <a href="${PasswordChange}">
                    <spring:message code="pages.user.setting.password-change"/>
                </a>
            </p>
        </div>
    </section>
</header>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>