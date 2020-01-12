<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.admin.admins-all.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <h2><spring:message code="pages.admin.admins-all.header"/></h2>
    <section class="login-page">
        <div class="btn btn--small">
            <c:url var="addAdmin" value="/admin/add"/>
            <a href="${addAdmin}">
                <spring:message code="pages.admin.admins-all.add"/>
            </a>
        </div>
        <table>
            <tr>
                <td><strong><spring:message code="pages.admin.admins-all.order"/></strong></td>
                <td><strong><spring:message code="pages.admin.admins-all.email"/></strong></td>
                <td><strong><spring:message code="pages.admin.admins-all.name"/></strong></td>
                <td><strong><spring:message code="pages.admin.admins-all.surname"/></strong></td>
                <td><strong><spring:message code="pages.admin.admins-all.actions"/></strong></td>
            </tr>
            <c:forEach items="${admins}" var="admin" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${admin.email}</td>
                    <td>${admin.name}</td>
                    <td>${admin.surname}</td>
                    <td>
                        <c:url var="updateAdmin" value="/admin/${admin.id}/edit"/>
                        <a href="${updateAdmin}"><spring:message code="pages.admin.institutions.edit"/></a>
                        <c:url var="deleteAdmin" value="/admin/${admin.id}/delete"/>
                        <a href="${deleteAdmin}"><spring:message code="pages.admin.institutions.delete"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </section>
</header>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>