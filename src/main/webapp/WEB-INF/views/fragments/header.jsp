<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<header>--%>
<nav class="container container--70">
    <ul class="nav--actions">
        <sec:authorize access="isAuthenticated()">
        <li class="logged-user">
                <spring:message code="pages.user.header.welcome"/> ${pageContext.request.userPrincipal.name}

                <ul class="dropdown">
                    <sec:authorize access="hasRole('USER')">
                    <li class="btn btn--small nav--actions">
                        <c:url var="userDashboard" value="/user/profile"/>
                        <a href="${userDashboard}">
                            <spring:message code="pages.user.header.profile"/>
                        </a>
                    </li>
                    <li class="btn btn--small nav--actions">
                        <c:url var="userSettings" value="/user/settings"/>
                        <a href="${userSettings}">
                            <spring:message code="pages.user.header.settings"/>
                        </a>
                    </li>
                    <li class="btn btn--small nav--actions">
                        <c:url var="userDonations" value="/user/donation/all"/>
                        <a href="${userDonations}">
                            <spring:message code="pages.user.header.collection"/>
                        </a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li class="btn btn--small nav--actions">
                            <c:url var="allInstitutions" value="/admin/institutions"/>
                            <a href="${allInstitutions}">
                                <spring:message code="pages.user.header.admin.institution"/>
                            </a>
                        </li>
                        <li class="btn btn--small nav--actions">
                            <c:url var="allAdmins" value="/admin/admins-all"/>
                            <a href="${allAdmins}">
                                <spring:message code="pages.user.header.admin.all-admins"/>
                            </a>
                        </li>
                        <li class="btn btn--small nav--actions">
                            <c:url var="allUsers" value="/admin/users-all"/>
                            <a href="${allUsers}">
                                <spring:message code="pages.user.header.admin.all-users"/>
                            </a>
                        </li>
                    </sec:authorize>
                    <li class="btn btn--small nav--actions">
                        <c:url var="logoutURL" value="/logout"/>
                        <form method="post" action="${logoutURL}">
                            <button class="btn btn--small nav--actions" type="submit">
                                <spring:message code="pages.user.header.logout"/></button>
                            <sec:csrfInput/>
                        </form>
                    </li>
                </ul>
        </li>
        </sec:authorize>
    </ul>

    <ul class="nav--actions">
        <sec:authorize access="!isAuthenticated()">
        <li>
            <c:url var="login" value="/login"/>
            <a href="${login}" class="btn btn--small btn--without-border">
                <spring:message code="pages.header.login"/>
            </a>
        </li>
        <li>
            <c:url var="registration" value="/registration"/>
            <a href="${registration}" class="btn btn--small btn--highlighted">
                <spring:message code="pages.header.register"/>
            </a>
        </li>
        </sec:authorize>
    </ul>

    <ul>
        <li>
            <c:url var="home" value="/"/>
            <a href="${home}" class="btn btn--without-border active">
                <spring:message code="pages.header.menu.start"/>
            </a>
        </li>
        <li>
            <c:url var="steps" value="/#steps"/>
            <a href="${steps}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.what"/>
            </a>
        </li>
        <li>
            <c:url var="aboutUs" value="/#about-us"/>
            <a href="${aboutUs}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.about"/>
            </a>
        </li>
        <li>
            <c:url var="help" value="/#help"/>
            <a href="${help}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.fund"/>
            </a>
        </li>
        <li>
            <c:url var="userDonation" value="/user/donation"/>
            <a href="${userDonation}" class="btn btn--without-border">
                <spring:message code="pages.header.menu.give"/>
            </a>
        </li>
        <li><a href="#contact" class="btn btn--without-border"><spring:message code="pages.header.menu.contact"/></a></li>
    </ul>
</nav>
<%--</header>--%>