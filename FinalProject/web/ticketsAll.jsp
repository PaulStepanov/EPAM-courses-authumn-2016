
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="u"%><html>
<head>
    <title>Tickets</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="${request.getHeader("Host")}/static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${request.getHeader("Host")}/static/css/style.css">
<u:headerBar></u:headerBar>
<div class="container">
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>Flight</th>
                <th>Cost</th>
                <th>lagage</th>
                <th>VIP</th>
                <th>Client name</th>
                <th>Client surname</th>
            </tr>
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <th>${ticket.getCurrentFlight().getFlight().getName()}</th>
                    <th>${ticket.getFlightCost()}</th>
                    <th>${ticket.getLagageCapacity()}</th>
                    <th>${ticket.getVip()}</th>
                    <th>${ticket.getClient().getName()}</th>
                    <th>${ticket.getClient().getSurname()}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
