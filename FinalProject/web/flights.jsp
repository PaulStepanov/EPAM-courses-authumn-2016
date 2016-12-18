<%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 18-Dec-16
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="u"%>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<u:headerBar></u:headerBar>
<div class="container">
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>Flight name</th>
                <th>Arrival</th>
                <th>Departure</th>
                <th>FlightTime</th>
                <th>Max lagage</th>
            </tr>
            <c:forEach items="${flights}" var="flight">
                <tr>
                    <th>${flight.getName()}</th>
                    <th>${flight.getArrivalCity().getName()}</th>
                    <th>${flight.getDepartureCity().getName()}</th>
                    <%--TODO сделать норм--%>
                    <th>${flight.getFlightTime()}</th>
                    <th>${flight.getMaxLagage()}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
