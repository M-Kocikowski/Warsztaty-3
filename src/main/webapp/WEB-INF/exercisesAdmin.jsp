<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 02.08.2019
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Exercise Administration</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <c:choose>
        <c:when test="${not empty exercise}">
            <h2>Edycja zadania:</h2>
        </c:when>
        <c:otherwise>
            <h2>Nowe zadanie:</h2>
        </c:otherwise>
    </c:choose>
    <form method="post">
        <label>Nazwa zadania:
            <input type="text" name="exerciseTitle" value="${exercise.title}">
        </label>
        <br>
        <label>Opis zadania:<br>
            <textarea name="exerciseDescription" cols="100" rows="3">${exercise.description}</textarea>
        </label>
        <br><br>
        <input type="submit" value="Zapisz">
    </form>
</body>
</html>
