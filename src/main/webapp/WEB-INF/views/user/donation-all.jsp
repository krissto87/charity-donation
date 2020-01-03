<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.user.donation-all.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <h2><spring:message code="pages.user.donation-all.header"/></h2>
</header>
<section class="login-page">
    <table>
        <tr>
            <td><strong><spring:message code="pages.user.donation-all.order-number"/></strong></td>
            <td><strong><spring:message code="pages.user.donation-all.status"/></strong></td>
            <td><strong><spring:message code="pages.user.donation-all.add-date"/></strong></td>
            <td><strong><spring:message code="pages.user.donation-all.details"/></strong></td>
            <td><strong><spring:message code="pages.user.donation-all.courier-details"/></strong></td>
        </tr>
        <for:forEach items="${donations}" var="donation" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>
                    <c:choose>
                        <c:when test = "${donation.delivered==false}">
                            <p><spring:message code="pages.user.donation-all.no-picked-up"/><p>
                        </c:when>
                        <c:otherwise>
                            <p><spring:message code="pages.user.donation-all.picked-up"/></p>
                        </c:otherwise>
                    </c:choose>
                    <c:url var="pickUpConfirm" value="/user/donation/pick-up-confirm/${donation.id}"/>
                    <c:if test="${donation.delivered==false}">
                        <a href="${pickUpConfirm}">
                            <strong><spring:message code="pages.user.donation-all.confirm"/></strong>
                        </a>
                    </c:if>
                </td>
                <td>
                    <fmt:parseDate value="${donation.createTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${parsedDateTime}" />
                </td>
                <td>
                    <c:url var="donationDetails" value="/user/donation/${donation.id}/details"/>
                    <a href="${donationDetails}"><spring:message code="pages.user.donation-all.more"/></a>
                </td>
                <td>
                    <c:url var="pickUpDetails" value="/user/donation/${donation.id}/pick-up-details"/>
                    <a href="${pickUpDetails}"><spring:message code="pages.user.donation-all.more"/></a>
                </td>
            </tr>
        </for:forEach>
    </table>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>