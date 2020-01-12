<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <td><strong><spring:message code="pages.admin.users-all.active"/></strong></td>
                <td><strong><spring:message code="pages.admin.users-all.actions"/></strong></td>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>
                        <c:choose>
                            <c:when test = "${user.active==true}">
                                <p><spring:message code="pages.admin.users-all.active-user"/><p>
                            </c:when>
                            <c:otherwise>
                                <p><spring:message code="pages.admin.users-all.block-user"/></p>
                            </c:otherwise>
                        </c:choose>
                    <td>
                        <c:url var="updateUser" value="/admin/users/${user.id}/edit"/>
                        <a href="${updateUser}"><spring:message code="pages.admin.institutions.edit"/></a>

                        <c:url var="blockUser" value="/admin/users/${user.id}/block"/>
                        <c:url var="activateUser" value="/admin/users/${user.id}/activate"/>
                        <c:choose>
                            <c:when test="${user.active==true}">
                                <a href="${blockUser}">
                                    <spring:message code="pages.admin.users-all.block"/>
                                </a>
                            </c:when>

                            <c:otherwise>
                                <a href="${activateUser}">
                                    <spring:message code="pages.admin.users-all.activate"/>
                                </a>
                            </c:otherwise>
                        </c:choose>

                        <c:url var="deleteUser" value="/admin/users/${user.id}/delete"/>
                        <a href="${deleteUser}"><spring:message code="pages.admin.institutions.delete"/></a>
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