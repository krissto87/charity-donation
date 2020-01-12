<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.admin.admins-all.add.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.admin.admins-all.add.header"/></h2>
    <form:form method="post" modelAttribute="admin">
        <div class="form-group">
            <spring:message code="pages.admin.admins-all.add.email" var="emailPlaceholder"/>
            <form:input path="email" required="true" placeholder="${emailPlaceholder}"/>
            <form:errors path="email" element="p"/>
        </div>
        <div class="form-group">
            <spring:message code="pages.admin.admins-all.add.name" var="namePlaceholder"/>
            <form:input path="name" required="true" placeholder="${namePlaceholder}"/>
            <form:errors path="name" element="p"/>
        </div>
        <div class="form-group">
            <spring:message code="pages.admin.admins-all.add.surname" var="surnamePlaceholder"/>
            <form:input path="surname" required="true" placeholder="${surnamePlaceholder}"/>
            <form:errors path="surname" element="p"/>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.admin.admins-all.add"/></button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>