<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.index.head.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--main-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${countOfBags}</em>

            <h3><spring:message code="pages.index.stats.bags.sum"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${countOfInstitutions}</em>
            <h3><spring:message code="pages.index.stats.institutions.count"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>

    <a href="#" class="btn btn--large">Załóż konto</a>
</section>

<section class="about-us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="/resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="/resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section class="help">
    <h2><spring:message code="pages.index.institutions"/></h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p><spring:message code="pages.index.institutions.slogan"/></p>

        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <c:forEach items="${institutions}" var="institution" begin="0" step="2">
                    <div class="title">${institution.name}</div>
                    <div class="subtitle">${institution.description}</div>
                    </c:forEach>
                </div>

                <div class="col">
                    <c:forEach items="${institutions}" var="institution" begin="1" step="2">
                        <div class="title">${institution.name}</div>
                        <div class="subtitle">${institution.description}</div>
                    </c:forEach>
                </div>
            </li>
        </ul>
    </div>

</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
