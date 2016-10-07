<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 12.09.2016
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="/resources/css/menu.css">
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><spring:message code="label.menu"/></title>
</head>
<body>
<div id="header">
    <center>
        <h1><spring:message code="label.menu"/></h1>
    </center>
</div>
<div id="sidebar">
    <center>
        <p style="line-height: 50px;">
            <a style="font-style: italic;" href="/BasicSearch"><spring:message code="label.basicSearch"/></a>
        </p>
        <p>
            <a style="font-style: italic;" href="/AdditionalSearch"><spring:message code="label.additionalSearch"/></a>
        </p>
        <p>
            <a style="font-style: italic;" href="/adding"><spring:message code="label.add"/></a>
        </p>
    </center>
</div>
<div id="content">
    <c:if test="${additional}">

        <center>
            <h2><spring:message code="entity.Time"/></h2>
            <a href="/time"><img src="/resources/pictures/time.png"></a>
            <br>

            <h2><spring:message code="entity.CookMethod"/></h2>
            <a href="/CookingMethod"><img src="/resources/pictures/cookingMethod.png"></a>
            <br>

            <h2><spring:message code="entity.Cuisune"/></h2>
            <a href="/cuisine"><img src="/resources/pictures/cuisine.png"></a>
            <br>

            <h2><spring:message code="entity.category"/></h2>
            <a href="/category"><img src="/resources/pictures/category.png"></a>
            <br>
        </center>

    </c:if>

    <c:if test="${adding}">
        <center>
            <h2><spring:message code="entity.Recipe"/></h2>
            <a href="/addingRecipe"><img src="/resources/pictures/Recipe.png"></a>
            <br>

            <h2><spring:message code="entity.Time"/></h2>
            <a href="/addingTime"><img src="/resources/pictures/time.png"></a>
            <br>

            <h2><spring:message code="entity.CookMethod"/></h2>
            <a href="/addingCookMethod"><img src="/resources/pictures/cookingMethod.png"></a>
            <br>

            <h2><spring:message code="entity.Cuisune"/></h2>
            <a href="/addingCuisine"><img src="/resources/pictures/cuisine.png"></a>
            <br>

            <h2><spring:message code="entity.category"/></h2>
            <a href="/addingCategory"><img src="/resources/pictures/category.png"></a>
            <br>
        </center>
    </c:if>
</div>
</body>
</html>
