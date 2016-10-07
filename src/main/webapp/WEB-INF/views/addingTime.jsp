<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 03.10.2016
  Time: 20:32
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
    <title>Adding time</title>
</head>
<body>

<a href="/MenuPage"><img src="/resources/pictures/back.png"></a>


<h1>
    <spring:message code="entity.Time"/>
</h1>

<form:form method="post" action="addTime" commandName="time">
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
                <form:label path="name">
                    <spring:message text="name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
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
