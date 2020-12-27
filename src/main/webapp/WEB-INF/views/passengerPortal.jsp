<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Passenger Portal</title>
</head>
<body>

<div class="profilePicture">
    <%-- insert image of generic profile picture--%>
</div
<h3>${savedMessage}</h3>
<table class="info">

    <tr>
        <th>Passenger ID</th>
        <th>Username</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Payment Method</th>

    </tr>

    <c:forEach items="${Passenger}" var="psg">
    <tr>
        <td>${psg.passID}</td>
        <td>${psg.username}</td>
        <td>${psg.firstName}</td>
        <td>${psg.lastName}</td>
        <td>${psg.phoneNumber}</td>
        <td>${psg.email}</td>
        <td>${psg.payMethod}</td>
    </tr>


</table>

<table class="options">
    <tr>
        <td><a href="<c:url value='/DeletePassengerRequest?x=${psg.passID}'/>">Delete</a>
        </td>
        <td><a href="<c:url value='/updatePassengerRequest?x=${psg.passID}'/>">Update</a> <br>
        </td>
        <td><a href="<c:url value='/EmailPassengerRequest?x=${psg.passID}'/>">Email</a> <br>
        </td>
        <td><a href="<c:url value='/tripReservation?x=${psg.passID}'/>">Reserve Trip</a> <br>
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

<h3><a href="<c:url value ="/passengerSignin"/>">Sign in</a></h3>
<h3><a href="<c:url value ="/passRegister"/>">Register</a></h3>

</body>
</html>
