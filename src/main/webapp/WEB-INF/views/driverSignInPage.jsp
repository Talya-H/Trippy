<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@page import="users.Driver" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Driver Sign in</title>
    <link href="../css/signInpages.css">
</head>
<body>

<%--<h3>${wrongCredentialsMessage}</h3>--%>

<form:form action="driverSignInFilled" method="post" modelAttribute="DSignin">

    <div class="container">
        <label><b>Username</b></label>
        <form:input path="username" type="text" placeholder="Enter Username" name="username" required="required"/>

        <label><b>Password</b></label>
        <form:input path="password" type="password" placeholder="Enter Password" name="psw" required="required"/>

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container">
        <button type="button" class="cancelbtn">Cancel</button>
        <!--        <span class="psw">Forgot <a href="#">password?</a></span>-->
    </div>
</form:form>

<div class="reg">
    <p>Don't have an account? <a href="driverRegistration.jsp">Register here</a>.</p>
</div>
</body>
</html>