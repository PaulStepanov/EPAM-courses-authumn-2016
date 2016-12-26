
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
           prefix="fmt" %>
<html>
<head>
    <title>Server Error</title>
</head>
<body bgcolor="white">
<h3>
    <%Integer stat=((HttpServletResponse) response).getStatus();%>
    Error status:${stat}
</h3>
<p>
</body>
</html>
