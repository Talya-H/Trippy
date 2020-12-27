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
    <title>Update Passenger Form</title>
</head>
<body>
<form:form action="passengerUpdateFilled" method="post" modelAttribute="psg">

<div class="container">

    <label><b>Username</b></label>
        <form:input path="username" type="text" value="${psg.username}" placeholder="Enter Username" name="username"
                    required="required"/>

    <label><b>First Name</b></label>
        <form:input path="firstName" type="text" value="${psg.firstName}" placeholder="Enter First Name"
                    name="firstName"
                    required="required"/>

    <label><b>Last Name</b></label>
        <form:input path="lastName" type="text" value="${psg.lastName}" placeholder="Enter Last Name" name="lastName"
                    required="required"/>

    <label><b>Phone Number</b></label>
        <form:input path="phoneNumber" type="number" value="${psg.phoneNumber}" placeholder="Enter Phone Number"
                    name="phoneNumber"
                    required="required"/>

    <label><b>Payment Method</b></label>
        <form:input path="payMethod" type="text" value="${psg.payMethod}" placeholder="Enter Visa or MasterCard"
                    name="payMethod" required="required"/>

    <label><b>Email</b></label>
        <form:input path="email" type="email" value="${psg.email}" placeholder="Enter Email" name="email"
                    required="required"/>

    <label><b>Password</b></label>
        <form:input path="password" type="password" value="${psg.password}" placeholder="Enter Password" name="password"
                    required="required"/>


    <div class="confirm">
        <button type="button" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Update</button>
    </div>
    </form:form>
</body>
</html>
