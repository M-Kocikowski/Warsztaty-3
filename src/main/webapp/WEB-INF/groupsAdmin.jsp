<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 31.07.2019
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Groups Administration</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <c:choose>
        <c:when test="${not empty group}">
            <h2>Edycja grupy:</h2>
        </c:when>
        <c:otherwise>
            <h2>Nowa grupa:</h2>
        </c:otherwise>
    </c:choose>
    <form method="post">
        <label> Nazwa grupy:
            <input type="text" name="groupName" value="${group.name}">
        </label>
        <br>
        <br>
        <input type="submit" value="Zapisz">
    </form>
</body>
</html>
