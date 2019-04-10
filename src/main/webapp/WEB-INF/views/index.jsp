<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<c:forEach items="${names}" var="name">
    ${name} <hr>
</c:forEach>
</body>
</html>