<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.admin.institution.form.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.admin.institution.form.header"/></h2>
    <form:form method="post" modelAttribute="institution">
        <div class="form-group">
            <spring:message code="pages.admin.institution.form.name"/>
            <form:input path="name" required="true"/>
            <form:errors path="name" element="p"/>
        </div>
        <div class="form-group">
            <spring:message code="pages.admin.institution.form.desc"/>
            <form:textarea path="description" required="true" rows="5" cols="10"/>
            <form:errors path="description" element="p"/>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.admin.institution.add"/></button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>