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

    <h3>Szczegóły użytkownika: ${user.userName}</h3>
    <p>Nazwa: ${user.userName}</p>
    <p>email: ${user.email}</p>
    <br>
    Dodane rozwiązania zadań:
    <jsp:include page="solutions.jsp"/>

</body>
</html>
