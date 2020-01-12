<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.admin.institutions.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <h2><spring:message code="pages.admin.institutions.header"/></h2>
        <section class="login-page">
            <div class="btn btn--small">
                <c:url var="addInstitution" value="/admin/institutions/add"/>
                <a href="${addInstitution}">
                    <spring:message code="pages.admin.institutions.add"/>
                </a>
            </div>
            <table>
                <tr>
                    <td><strong><spring:message code="pages.admin.institutions.order"/></strong></td>
                    <td><strong><spring:message code="pages.admin.institutions.name"/></strong></td>
                    <td><strong><spring:message code="pages.admin.institutions.description"/></strong></td>
                    <td><strong><spring:message code="pages.admin.institutions.action"/></strong></td>
                </tr>
                <c:forEach items="${institutions}" var="institution" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${institution.name}</td>
                        <td>${institution.description}</td>
                        <td>
                            <c:url var="updateInstitution" value="/admin/institutions/${institution.id}/edit"/>
                            <a href="${updateInstitution}">
                                <spring:message code="pages.admin.institutions.edit"/>
                            </a>
                            <c:url var="deleteInstitution" value="/admin/institutions/${institution.id}/delete"/>
                            <a href="${deleteInstitution}">
                                <spring:message code="pages.admin.institutions.delete"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </section>
</header>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>