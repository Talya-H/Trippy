<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Hacke
  Date: 01/12/2020
  Time: 4:16 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Driver Form</title>
</head>
<body>

<form:form action="driverUpdateFilled" method="post" modelAttribute="drv">

    <div class="container">

        <label><b>Username</b></label>
        <form:input path="username" type="text" value="${drv.username}" placeholder="${drv.username}" name="username"
                    required="required"/>

        <label><b>First Name</b></label>
        <form:input path="firstName" type="text" value="${drv.firstName}" placeholder="${drv.firstName}"
                    name="firstName" required="required"/>

        <label><b>Last Name</b></label>
        <form:input path="lastName" type="text" value="${drv.lastName}" placeholder="${drv.lastName}" name="lastName"
                    required="required"/>

        <label><b>Phone Number</b></label>
        <form:input path="phoneNumber" type="number" value="${drv.phoneNumber}" placeholder="${drv.phoneNumber}"
                    name="phoneNumber" required="required"/>

        <label><b>Car Brand</b></label>
        <form:input path="carBrand" type="text" value="${drv.carBrand}" placeholder="${drv.carBrand}" name="carBrand"
                    required="required"/>

        <label><b>Email</b></label>
        <form:input path="email" type="email" value="${drv.email}" placeholder="${drv.email}" name="email"
                    required="required"/>

        <label><b>Password</b></label>
        <form:input path="password" type="password" value="${drv.password}" placeholder="${drv.password}" name="psw"
                    required="required"/>

    </div>
    <div class="confim">
        <button type="button" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Submit</button>
    </div>
</form:form>

</body>
</html>
