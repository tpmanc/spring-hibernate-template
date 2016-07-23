<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="<spring:url value='/sign-up/handler' />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div>
        <input name="email" type="email" id="email">
        <label for="email">E-mail</label>
    </div>

    <div>
        <input name="password" type="password" id="password">
        <label for="password">Password</label>
    </div>

    <div>
        <input name="passwordRepeat" type="password" id="passwordRepeat">
        <label for="passwordRepeat">Repeat Password</label>
    </div>

    <button type="submit">Sign Up</button>

    <a href="<spring:url value='/sign-in' />">Sign In</a>
</form>
</body>
</html>
