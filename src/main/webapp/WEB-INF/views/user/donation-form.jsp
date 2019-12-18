<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <fmt:message key="pages.donation-form.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/user/user-header.jsp"/>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3><fmt:message key="pages.form.instructions.head"/></h3>
            <p data-step="1" class="active">
                <fmt:message key="pages.form.instructions.step1"/>
            </p>
            <p data-step="2">
                <fmt:message key="pages.form.instructions.step2"/>
            </p>
            <p data-step="3">
                <fmt:message key="pages.form.instructions.step3"/>
            </p>
            <p data-step="4"><fmt:message key="pages.form.instructions.step4"/></p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"><fmt:message key="pages.form.steps.counter"/><span>1</span>/4</div>

        <form action="form-confirmation.html" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3><fmt:message key="pages.form.step1.head"/></h3>

                <c:forEach items="${categories}" var="category">
                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="categories" value="${category.id}"/>
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step"><fmt:message key="pages.form.button.next"/></button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3><fmt:message key="pages.form.step2.head"/></h3>

                <div class="form-group form-group--inline">
                    <label>
                        <fmt:message key="pages.form.step2.label"/>
                        <input type="number" name="bags" step="1" min="1" />
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><fmt:message key="pages.form.button.previous"/></button>
                    <button type="button" class="btn next-step"><fmt:message key="pages.form.button.next"/></button>
                </div>
            </div>

<%--            <!-- STEP 3 -->--%>
            <div data-step="3">
                <h3><fmt:message key="pages.form.step3.head"/> </h3>

                <c:forEach items="${institutions}" var="institution">
                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="radio" name="institution" value="old" />
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">${institution.description}</div>
                </span>
                    </label>
                </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><fmt:message key="pages.form.button.previous"/></button>
                    <button type="button" class="btn next-step"><fmt:message key="pages.form.button.next"/></button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3><fmt:message key="pages.form.step4.head"/> </h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4><fmt:message key="pages.form.step4.address"/></h4>
                        <div class="form-group form-group--inline">
                            <label><fmt:message key="pages.form.step4.street"/> <input type="text" name="address" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><fmt:message key="pages.form.step4.city"/> <input type="text" name="city" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><fmt:message key="pages.form.step4.zip"/> <input type="text" name="postcode" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><fmt:message key="pages.form.step4.phone"/> <input type="phone" name="phone" /> </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4><fmt:message key="pages.form.step4.date"/></h4>
                        <div class="form-group form-group--inline">
                            <label><fmt:message key="pages.form.step4.day"/> <input type="date" name="data" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><fmt:message key="pages.form.step4.hour"/> <input type="time" name="time" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><fmt:message key="pages.form.step4.comment"/> <textarea name="more_info" rows="5"></textarea> </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><fmt:message key="pages.form.button.previous"/></button>
                    <button type="button" class="btn next-step"><fmt:message key="pages.form.button.next"/></button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3><fmt:message key="pages.form.step5.head"/> </h3>

                <div class="summary">
                    <div class="form-section">
                        <h4><fmt:message key="pages.form.step5.sum1"/></h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text"
                                >${bags} worki ubrań w dobrym stanie dla dzieci</span
                                >
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla ${institution}</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>Prosta 51</li>
                                <li>Warszawa</li>
                                <li>99-098</li>
                                <li>123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>13/12/2018</li>
                                <li>15:40</li>
                                <li>Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><fmt:message key="pages.form.button.previous"/></button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form>
    </div>
</section>


<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>