<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.remind-password.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.remind-password.header"/></h2>
    <form:form modelAttribute="remindPassword" method="post">
        <div class="form-group">
            <div class="control has-icons-left">
                <spring:message code="pages.remind-password.email" var="emailPlaceholder"/>
                <c:input path="email" placeholder="${emailPlaceholder}" />
                <form:errors path="email" element="p"/>
            </div>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.remind-password.send"/></button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>