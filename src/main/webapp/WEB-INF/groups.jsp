<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 08.06.19
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Groups</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<c:choose>
    <c:when test="${not empty param.admin}">
        <h2>Zarządzanie grupami</h2>
        <a href="<c:url value="/groupAdmin"/>">Dodaj nową grupę</a>
        <br><br>
    </c:when>
    <c:otherwise>
        <h2>Lista grup:</h2>
    </c:otherwise>
</c:choose>
<table>
    <tr>
        <th>Nazwa grupy</th>
        <th>Akcje</th>
    </tr>

    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.name}</td>
            <c:choose>
                <c:when test="${not empty param.admin}">
                    <td><a href="<c:url value="/groupAdmin?groupId=${group.id}"/>">Edytuj</a></td>
                </c:when>
                <c:otherwise>
                    <td><a href="<c:url value="/showUsers?groupId=${group.id}"/>">Użytkownicy</a></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

</table>
</body>
</html>
