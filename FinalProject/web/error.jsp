<%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 18-Dec-16
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
           prefix="fmt" %>
<html>
<head>
    <title><fmt:message key="ServerError"/></title>
</head>
<body bgcolor="white">
<h3>
    <fmt:message key="ServerError"/>
</h3>
<p>
    : ${pageContext.errorData.throwable.cause}
</body>
</html>
