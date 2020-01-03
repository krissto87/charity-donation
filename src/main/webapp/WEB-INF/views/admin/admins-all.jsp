<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:url var="addAdmin" value="/admin/admins-all/add"/>
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
            <for:forEach items="${admins}" var="admin" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${admin.email}</td>
                    <td>${admin.name}</td>
                    <td>${admin.surname}</td>
                    <td>
                        <c:url var="updateAdmin" value="/admin/admins-all/${admin.id}/edit"/>
                        <a href="${updateAdmin}">
                            <spring:message code="pages.admin.institutions.edit"/>
                        </a>
                        <c:url var="deleteAdmin" value="/admin/admins-all/${admin.id}/delete"/>
                        <a href="${deleteAdmin}">
                            <spring:message code="pages.admin.institutions.delete"/>
                        </a>
                    </td>
                </tr>
            </for:forEach>
        </table>
    </section>
</header>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>