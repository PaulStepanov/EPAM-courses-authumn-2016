<%--
  Created by IntelliJ IDEA.
  User: frees
  Date: 16.12.2016
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<% request.getAttribute("tickets");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="u"%><html>
<head>
    <title>Tickets</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
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
            <c:forEach items="${tickets}" var="ticket" >
                <tr>
                    <th>${ticket.getCurrentFlight().getFlight().getName()}t</th>
                    <th>${ticket.getFlightCost()}</th>
                    <th>${ticket.getFlightCost()}</th>
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
