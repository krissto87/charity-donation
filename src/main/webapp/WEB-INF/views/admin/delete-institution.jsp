<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.admin.institution.delete.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.admin.institution.delete.header"/></h2>

    <form:form method="post" modelAttribute="institution">
        <input:hidden path="id"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.admin.institutions.delete"/></button>
        </div>
        <sec:csrfInput/>
    </form:form>
    <form:form method="get" action="/admin/institutions">
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.admin.institutions.cancel"/></button>
        </div>
    </form:form>

</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>