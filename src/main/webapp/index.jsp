<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Trippy</title>
    <link href="WEB-INF/css/main.css">
</head>

<body>
<h1>Welcome to Trippy</h1>



<h3><a href="<c:url value ="/driverRegister"/>">Driver registration</a></h3>
<h3><a href="<c:url value ="/passRegister"/>">Passenger registration</a></h3>

<h3><a href="<c:url value ="/driverSignin"/>">Driver sign in</a></h3>
<h3><a href="<c:url value ="/passengerSignin"/>">Passenger sign in</a></h3>




  </body>
</html>