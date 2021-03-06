<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.reset-password.form.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.reset-password.form.title"/></h2>
    <form:form method="post" modelAttribute="changePassword">
        <div class="form-group">
            <div class="control has-icons-left">
                <spring:message code="pages.reset-password.form.password.placeholder"
                                var="newPasswordPlaceholder"/>
                <form:password path="password" required="true" placeholder="${newPasswordPlaceholder}"/>
                <form:errors path="password" element="p"/>
            </div>
            <div class="control has-icons-left">
                <spring:message code="pages.reset-password.form.re-password.placeholder"
                                var="rePasswordPlaceholder"/>
                <form:password path="rePassword" required="true" placeholder="${rePasswordPlaceholder}"/>
                <form:errors path="rePassword" element="p"/>
            </div>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.edit.data.confirm"/></button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>