<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 18.09.2016
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Comment</title>
</head>
<body>

<a href="/MenuPage"><img src="/resources/pictures/back.png"></a>

<c:if test="${!empty commentList}">
    <table class="searchTable">
        <tr>
            <th class="searchTh"><spring:message text="date"/></th>
            <th class="searchTh"><spring:message text="message"/></th>
        </tr>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td class="searchTd">${comment.date}</td>
                <td class="searchTd">${comment.message}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
