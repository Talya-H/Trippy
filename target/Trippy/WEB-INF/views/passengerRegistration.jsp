<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Passenger Registration page</title>
    <link href="../registrationPageTheme/css/registrationPages.css">

</head>
<body>
<form:form action="FilledPassengerRegistration" method="post" modelAttribute="P">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create a passenger account.</p>
        <hr>
        <label><b>Username</b></label>
        <form:input path="username" type="text" placeholder="Enter Username" name="username" required="required"/>

        <label><b>First Name</b></label>
        <form:input path="firstName" type="text" placeholder="Enter First Name" name="firstName" required="required"/>

        <label><b>Last Name</b></label>
        <form:input path="lastName" type="text" placeholder="Enter Last Name" name="lastName" required="required"/>

        <label><b>Phone Number</b></label>
        <form:input path="phoneNumber" type="number" placeholder="Enter Phone Number" name="phoneNumber"
                    required="required"/>

        <label><b>Payment Method</b></label>
        <form:input path="payMethod" type="text" placeholder="Enter Visa or MasterCard" name="payMethod"
                    required="required"/>

        <label><b>Email</b></label>
        <form:input path="email" type="email" placeholder="Enter Email" name="email" required="required"/>

        <label><b>Password</b></label>
        <form:input path="password" type="password" placeholder="Enter Password" name="psw" required="required"/>

            <%-- <label><b>Repeat Password</b></label>--%>
            <%-- input:form path="password" type="password" placeholder="Repeat Password" name="psw-repeat" required="required"/>--%>


        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>

        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <div class="confirm">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
        <div class="container signin">
                <%-- link to sign in the controller instead???--%>
            <p>Already have an account? <a href="passengerSignInPage.jsp">Sign in</a>.</p>
        </div>
    </div>
</form:form>

</body>
</html>