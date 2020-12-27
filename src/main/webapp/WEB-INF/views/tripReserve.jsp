<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trip Reservation</title>
</head>
<body>
<form:form action="tripReservationFilled" method="post" modelAttribute="T">
    <div class="container">
        <h1>Book you trip</h1>
        <p>Please fill in this form to book your trip.</p>
        <!--google maps plug in? -->
        <label><b>Username</b></label>
        <label>
            <input type="text" value="${passengerUsername}" placeholder="${passengerUsername}" name="username"
                        required="required"/>
        </label>

        <label><b>Pick-up Address</b></label>
        <form:input path="pickup" type="text" placeholder="Enter address" name="pickup" required="required"/>

        <label><b>Drop-off Address</b></label>
        <form:input path="drop" type="text" placeholder="Enter address" name="drop" required="required"/>

        <!--pick up and drop must not be the same-->
        <label><b>Time</b></label>
        <form:input path="pickupTime" type="time" placeholder="Enter pick-up time" name="time" required="required"/>

        <label><b>Date</b></label>
        <form:input path="pickupDate" type="date" placeholder="Enter date" name="date" required="required"/>

        <div class="confirm">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Book</button>
            <!--confirmation page w/ message for email confirmation-->
        </div>

    </div>
</form:form>
</body>
</html>