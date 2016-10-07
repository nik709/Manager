<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/resources/css/checkbox.css">
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title"/></title>
</head>
<body>

<a href="<c:url value="/WelcomePage" />">
    <img src="/resources/pictures/back.png">
</a>

<br/>

<c:if test="${not empty param.error}">
    <font color="red"> <spring:message code="label.loginerror"/>
        : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />">
    <table id="loginTable">
        <tr>
            <td style="font-size: 40px" align="center"><spring:message code="label.login"/></td>
            <td><input style="font-size: 40px" type="text" name="j_username"/></td>
        </tr>
        <tr>
            <td style="font-size: 40px" align="center"><spring:message code="label.password"/></td>
            <td><input style="font-size: 40px" type="password" name="j_password"/></td>
        </tr>
        <tr>
            <td style="font-size: 40px" align="center"><spring:message code="label.remember"/></td>
            <td><input id="payt2" type="checkbox" name="_spring_security_remember_me"/><label for="payt2">ON</label></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input style="font-size: 40px" type="submit" value="Login"/>
                <input style="font-size: 40px" type="reset" value="Reset"/></td>
        </tr>
    </table>
</form>
</body>
</html>