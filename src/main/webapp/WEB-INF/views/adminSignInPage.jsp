<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration page</title>
</head>
<body>
<form:form action="adminSignInFilled" method="post" modelAttribute="ASignin">

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

</body>
</html>
