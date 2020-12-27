<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Hacke
  Date: 05/11/2020
  Time: 2:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Driver Portal</title>
</head>
<body>
<div class="profilePicture">
    <%-- insert image of generic profile picture--%>
</div>
<h3>${savedMessage}</h3>
<table class="info">
    <tr>
        <th>Username</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
        <th>Car Brand</th>
        <th>Email</th>
        <th>Score</th>
    </tr>
    <c:forEach items="${Driver}" var="drv">
    <tr>

        <td>${drv.driverID}</td>
        <td>${drv.username}</td>
        <td>${drv.firstName}</td>
        <td>${drv.lastName}</td>
        <td>${drv.phoneNumber}</td>
        <td>${drv.carBrand}</td>
        <td>${drv.email}</td>
        <td>${drv.score}</td>
    </tr>


</table>
<table class="options">
    <tr>
        <td><a href="<c:url value='/DeleteDriverRequest?x=${drv.driverID}'/>">Delete</a>
        </td>
        <td><a href="<c:url value='/updateDriverRequest?x=${drv.driverID}'/>">Update</a> <br>
        </td>
        <td><a href="<c:url value='/EmailDriverRequest?x=${drv.driverID}'/>">Email</a> <br>
        </td>
    </tr>
    </c:forEach>
</table>

<table class="trips">
    <tr>
        <th>Trip ID</th>
        <th>Pickup Address</th>
        <th>Drop Address</th>
        <th>Time</th>
        <th>Date</th>

    </tr>
    <c:forEach items="${Trip}" var="trp">
    <tr>

        <td>${trp.tripID}</td>
        <td>${trp.pickup}</td>
        <td>${trp.drop}</td>
        <td>${trp.pickupTime}</td>
        <td>${trp.pickupDate}</td>

    </tr>
    </c:forEach>
</table>



<h3><a href="<c:url value="/driverSignIn"/>">Sign in</a></h3>
<h3><a href="<c:url value="/driverRegister"/>">Register</a></h3>
</body>
</html>