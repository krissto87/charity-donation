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

    <section class="login-page">
        <h2>Moje dary</h2>
            <table>
                    <tr>

                        <td> <b> Lp: </b></td>
                        <td> Ilość worków: </td>
                        <td> Status: </td>
                        <td> Data dodania: </td>
                        <td> Szczegóły obioru kuriera:</td>
                        <td> Szczegóły daru:</td>

                    </tr>
                    <for:forEach items="${donations}" var="donation" varStatus="stat">

                        <tr>
                            <td>${stat.count}</td>
                            <td>${donation.quantity}</td>

                            <td>
                            <c:choose>
                                <c:when test = "${donation.delivered==false}">
                                <p> <c:out value ="nieoebrany"/><p>
                                </c:when>
                                <c:otherwise>
                                    <p> <c:out value="odebrany"/></p>
                                </c:otherwise>
                            </c:choose>
                                <c:url var="pickUpConfirm" value="/user/donation/pick-up-confirm/${donation.id}"/>
                                <c:if test="${donation.delivered==false}">
                                    <a href="${pickUpConfirm}">
                                        <strong><c:out value="Potwierdz odbiór"/></strong>
                                    </a>
                                </c:if>
                            </td>
                            <td>
                            <fmt:parseDate value="${donation.createTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                            <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${parsedDateTime}" />
                            </td>
                            <td>
                                <c:url var="donationDetails" value="/user/donation/details"/>
                                <a href="${donationDetails}">Wiecej</a>
                            </td>
                            <td>
                                <c:url var="pickUpDetails" value="/user/donation/pick-up-details"/>
                                <a href="${pickUpDetails}">Wiecej</a>
                            </td>
                        </tr>
                    </for:forEach>
            </table>
    </section>
</header>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>