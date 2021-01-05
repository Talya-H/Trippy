<%--
  Created by IntelliJ IDEA.
  User: Hacke
  Date: 04/01/2021
  Time: 7:43 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Admin Portal </title>
</head>
<body>
<table class="info">
    <tr>
        <th>Username</th>

    </tr>
    <c:forEach items="${Admin}" var="adm">
    <tr>
        <td>${adm.username}</td>
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
</body>
</html>
