<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 30.07.19
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <h2>Panel administracyjny:</h2>
    <a href="<c:url value="/groups?admin=true"/>">Zarządzanie grupami</a>
    <br>
    <a href="<c:url value="#"/>">Zarządzanie zadaniami</a>
    <br>
    <a href="<c:url value="/showUsers?admin=true"/>">Zarządzanie użytkownikami</a>
</body>
</html>
