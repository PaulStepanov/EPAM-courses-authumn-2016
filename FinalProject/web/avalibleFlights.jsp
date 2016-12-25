
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="u"%><html>
<head>
    <title>Avalible Flights</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="${request.getHeader("Host")}/static/css/style.css">
<u:headerBar></u:headerBar>
<div class="container">
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>Name</th>
                <th>Arrival</th>
                <th>Departure</th>
                <th>Flight Duration</th>
                <th>Ticket Cost</th>
                <th>Lagage Cost</th>
                <th>Max Lagage</th>
                <th>Buy</th>
            </tr>
            <c:forEach items="${currentFlights}" var="currentFlight">
                <tr>
                    <th>${currentFlight.getFlight().getName()}</th>
                    <th>${currentFlight.getFlight().getArrivalCity().getName()}</th>
                    <th>${currentFlight.getFlight().getDepartureCity().getName()}</th>
                    <th>${DurationParser.parseDuration(currentFlight.getFlight().getFlightTime())}</th>
                    <th>${currentFlight.getTicketCost()}</th>
                    <th>${currentFlight.getLagageCost()}</th>
                    <th>${currentFlight.getFlight().getMaxLagage()}</th>
                    <th><a href="${request.getHeader("Host")}/html/currentFlight?id=${currentFlight.getId()}"><button  value="${currentFlight.getId()}" type="button" class="btn btn-success buybtn">Buy</button></a></th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script src="${request.getHeader("Host")}/static/js/bootstrap.js"></script>
</body>
</html>
