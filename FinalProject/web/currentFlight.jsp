<%--
  Created by IntelliJ IDEA.
  User: frees
  Date: 16.12.2016
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="u"%><html>
<head>
    <title>MyTickets</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
<u:headerBar></u:headerBar>
<div class="container">
    <div class="row">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center"><h2>${currentFlight.getFlight().getName()}</h2></div>
                <div class="col-md-6 "><h3>Date and Time:</h3></div>
                <div class="col-md-6 text-center"><h3>${DateTimeParser.parseDateTime(currentFlight.getDateTime())}</h3></div>
                <div class="col-md-6 "><h3>Arrival City:</h3></div>
                <div class="col-md-6 text-center"><h3>${currentFlight.getFlight().getArrivalCity().getName()}</h3></div>
                <div class="col-md-6 "><h3>Departure City:</h3></div>
                <div class="col-md-6 text-center"><h3>${currentFlight.getFlight().getDepartureCity().getName()}</h3></div>
                <div class="col-md-6 "><h3>Flight Time:</h3></div>
                <div class="col-md-6 text-center"><h3>${DurationParser.parseDuration(currentFlight.getFlight().getFlightTime())}</h3></div>
                <div class="col-md-6 "><h3>Ticket Cost:</h3></div>
                <div class="col-md-6 text-center"><h3>${currentFlight.getTicketCost()}</h3></div>
                <div class="col-md-6 "><h3>Luggage Cost:</h3></div>
                <div class="col-md-6 text-center"><h3>${currentFlight.getLagageCost()}</h3></div>
                <div class="col-md-6 "><h3>Max Luggage :</h3></div>
                <div class="col-md-6 text-center"><h3>${currentFlight.getFlight().getMaxLagage()}</h3></div>
            </div>
            <div class="row">
                <c:if test="${user!=null}">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center"><h2>Buy Ticket:</h2></div>
                        <div class="col-md-offset-3 col-md-6 input-group input-group-lg">
                            <form id="ticketBuyForm">
                                <input name="FlightId" type="text" value="${currentFlight.getId()}" class="hidden" >
                                <span class="input-group-addon" id="sizing-addon1">Luggage capacity:</span>
                                <input name="luggage" type="text" class="form-control" placeholder="Luggage capacity" aria-label="sizing-addon1" value="0">
                                <span class="input-group-addon " id="sizing-addon2">VIP:</span>
                                <input name="vip" type="checkbox" id="vip" aria-describedby="sizing-addon2"/>
                                <label for="vip">VIP</label>
                                <button type="button" class="btn btn-primary btn-lg btn-block" id="buyTickBut">Buy Ticket</button>
                            </form>
                        </div>
                    </div>
                </div>
                </c:if>
                <c:if test="${user==null}">
                    <div class="col-md-12 text-center"><h2>Log In to buy a ticket</h2></div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script src="/static/js/ticketBuy.js"></script>
</body>
</html>
