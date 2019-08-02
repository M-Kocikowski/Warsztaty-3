<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 02.08.2019
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Exercises</title>
</head>
<body>
    <jsp:include page="header.jsp"/>

        <h2>Zarządzanie zadaniami</h2>
        <a href="<c:url value="/exerciseAdmin"/>">Dodaj nowe zadanie</a>
        <br><br>

<table>
    <tr>
        <th>Nazwa zadania</th>
        <th>Akcje</th>
    </tr>

    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.title}</td>
            <td><a href="<c:url value="/exerciseAdmin?exerciseId=${exercise.id}"/>">Edytuj</a></td>
        </tr>
    </c:forEach>

</table>
</body>

</html>
