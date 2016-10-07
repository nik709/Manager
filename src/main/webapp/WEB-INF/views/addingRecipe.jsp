<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 03.10.2016
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<html>
<head>
    <title>Adding recipe</title>
</head>
<body>

<a href="/MenuPage"><img src="/resources/pictures/back.png"></a>

<h1>
    <spring:message code="entity.Recipe"/>
</h1>

<form:form method="post" action="addRecipe" commandName="recipe">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="id"/>
                </form:label>
            </td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="descript">
                    <spring:message text="descript"/>
                </form:label>
            </td>
            <td>
                <form:input path="descript"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="categoryString">
                    <spring:message text="category"/>
                </form:label>
            </td>
            <td>
                <form:select path="categoryString">
                    <c:forEach var="i" items="${categoryList}">
                        <form:option value="${i}" label="${i.name}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="cuisineString">
                    <spring:message text="cuisine"/>
                </form:label>
            </td>
            <td>
                <form:select path="cuisineString">
                    <c:forEach var="i" items="${cuisineList}">
                        <form:option value="${i}" label="${i.name}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="methodString">
                    <spring:message text="method"/>
                </form:label>
            </td>
            <td>
                <form:select path="methodString">
                    <c:forEach var="i" items="${methodList}">
                        <form:option value="${i}" label="${i.name}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="timeString">
                    <spring:message text="time"/>
                </form:label>
            </td>
            <td>
                <form:select path="timeString">
                    <c:forEach var="i" items="${timeList}">
                        <form:option value="${i}" label="${i.name}"/>
                        <br>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ingredients">
                    <spring:message text="ingredients: "/>
                </form:label>
            </td>
            <td>
                <form:checkboxes cssClass="bigbox" path="ingredients" items="${ingredientList}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="ADD"/>"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
