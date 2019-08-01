<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 08.06.19
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <a href="<c:url value="/groups"/>">Powrót</a>

    <h2>Szczegóły użytkownika: ${user.userName}</h2>
    <p>Nazwa: ${user.userName}</p>
    <p>email: ${user.email}</p>
    <h3>Dodane rozwiązania zadań:</h3>
    <jsp:include page="solutions.jsp"/>

</body>
</html>
