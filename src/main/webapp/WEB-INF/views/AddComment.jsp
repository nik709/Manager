<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 18.09.2016
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title><spring:message code="label.addComment"/></title>
</head>
<body>
<form:form method="post" action="newComment" commandName="comment">
    <table id="commentTable">
        <tr>
            <td style="font-size: 50px">
                <form:label path="message">
                    <spring:message code="entity.Comment"/>
                </form:label>
            </td>
            <td>
                <form:input path="message"/>
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
