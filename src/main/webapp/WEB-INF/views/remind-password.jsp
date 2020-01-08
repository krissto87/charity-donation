<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.remind-password.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.remind-password.header"/></h2>
    <form method="post">
        <div class="form-group">
            <div class="control has-icons-left">
                <spring:message code="pages.remind-password.email" var="emailPlaceholder"/>
                <input type="email" name="email" placeholder="${emailPlaceholder}" />
            </div>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="pages.remind-password.send"/></button>
        </div>
<%--        <sec:csrfInput/>--%>
    </form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>