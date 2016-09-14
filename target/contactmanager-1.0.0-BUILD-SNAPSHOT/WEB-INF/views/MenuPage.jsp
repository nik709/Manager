<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 12.09.2016
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><spring:message code="label.menu"/></title>
</head>
<body>
<a href="/BasicSearch"><spring:message code="label.basicSearch"/></a>
<br>
<a href="/AdditionalSearch"><spring:message code="label.additionalSearch"/></a>
</body>
</html>
