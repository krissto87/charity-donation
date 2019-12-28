<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.user.edit.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.header.edit.data"/></h2>
    <form:form method="post" modelAttribute="user">
        <form:hidden path="id"/>
<%--        <div class="form-group">--%>
<%--            <spring:message code="pages.register.email" var="emailPlaceholder"/>--%>
<%--            <form:input path="email" required="true" placeholder="${emailPlaceholder}"/>--%>
<%--            <form:errors path="email" element="p"/>--%>
<%--        </div>--%>
        <div class="form-group">
            <form:label path="name"><spring:message code="pages.edit.data.name"/></form:label>
            <spring:message code="pages.register.name" var="namePlaceholder"/>
            <form:input path="name" required="true" placeholder="${namePlaceholder}"/>
            <form:errors path="name" element="p"/>
        </div>
        <div class="form-group">
            <form:label path="name"><spring:message code="pages.edit.data.surname"/></form:label>
            <spring:message code="pages.register.surname" var="surnamePlaceholder"/>
            <form:input path="surname" required="true" placeholder="${surnamePlaceholder}"/>
            <form:errors path="surname" element="p"/>
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