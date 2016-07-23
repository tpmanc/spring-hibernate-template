<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="<spring:url value='/j_spring_security_check' />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div>
        <input type="text" id="email">
        <label for="email">E-mail</label>
    </div>

    <div>
        <input name="j_password" type="password" id="password">
        <label for="password">Password</label>
    </div>

    <button type="submit">Sign In</button>

    <a href="<spring:url value='/sign-up' />">Sign Up</a>
</form>
</body>
</html>
