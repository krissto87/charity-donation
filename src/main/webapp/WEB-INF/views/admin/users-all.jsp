<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.admin.users-all.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <h2><spring:message code="pages.admin.users-all.header"/></h2>
    <section class="login-page">
        <table>
            <tr>
                <td><strong><spring:message code="pages.users-all.order"/></strong></td>
                <td><strong><spring:message code="pages.admin.users-all.email"/></strong></td>
                <td><strong><spring:message code="pages.admin.users-all.name"/></strong></td>
                <td><strong><spring:message code="pages.admin.users-all.surname"/></strong></td>
                <td><strong><spring:message code="pages.admin.users-all.actions"/></strong></td>
            </tr>
            <for:forEach items="${users}" var="user" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>
                        <c:url var="updateUser" value="/admin/${user.id}/edit"/>
                        <a href="${updateUser}"><spring:message code="pages.admin.institutions.edit"/></a>
                        <c:url var="blockUser" value="/admin/${user.id}/block"/>
                        <a href="${blockUser}"><spring:message code="pages.admin.users-all.block"/></a>
                        <c:url var="deleteUser" value="/admin/${user.id}/delete"/>
                        <a href="${deleteUser}"><spring:message code="pages.admin.institutions.delete"/></a>
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