<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Driver Registration page</title>
    <link href="../css/registrationPages.css">
</head>
<body>
<form:form action="FilledDriverRegistration" method="post" modelAttribute="D" >
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create a driver account.</p>
        <hr>

        <label><b>Username</b></label>
        <form:input path="username" type="text" placeholder="Enter Username" name="username" required="required"/>

        <label><b>First Name</b></label>
        <form:input path="firstName" type="text" placeholder="Enter First Name" name="firstName" required="required"/>

        <label><b>Last Name</b></label>
        <form:input path="lastName" type="text" placeholder="Enter Last Name" name="lastName" required="required"/>

        <label><b>Phone Number</b></label>
        <form:input path="phoneNumber" type="number" placeholder="Enter Phone Number" name="phoneNumber" required="required"/>

        <label><b>Car Brand</b></label>
        <form:input path="carBrand" type="text" placeholder="Enter Car Brand" name="carBrand" required="required"/>

        <label><b>Email</b></label>
        <form:input path="email" type="email" placeholder="Enter Email" name="email" required="required"/>

        <label><b>Password</b></label>
        <form:input path="password" type="password" placeholder="Enter Password" name="psw" required="required"/>

<%--        <label><b>Repeat Password</b></label>--%>
<%--        <form:input path="password" type="password" placeholder="Repeat Password" name="psw-repeat" required="required"/>--%>


        <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"/> Remember me
        </label>

        <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

        <div class="confim">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
        <div class="container signin">
<%--            link to sign in controller instead--%>
            <p>Already have an account? <a href="<c:url value ="driverSignInPage.jsp"/>">Sign in</a>.</p>
        </div>
    </div>
</form:form>

</body>
</html>