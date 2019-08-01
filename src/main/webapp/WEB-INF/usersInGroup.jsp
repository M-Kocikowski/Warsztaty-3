<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 08.06.19
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Users in Group</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <c:choose>
        <c:when test="${not empty param.admin}">
            <h2>Lista użytkowników:</h2>
            <a href="<c:url value="/userAdmin"/>">Dodaj nowego użytkownika</a>
            <br><br>
        </c:when>
        <c:otherwise>
            <h2>Użytkownicy w grupie: <em>${groupName}</em></h2>
        </c:otherwise>
    </c:choose>
    <table>
        <tr>
            <th>Nazwa</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userName}</td>
                <c:choose>
                    <c:when test="${not empty param.admin}">
                        <td><a href="<c:url value="/userAdmin?userId=${user.id}"/>">Edytuj</a></td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="<c:url value="/userdetails?userId=${user.id}"/>">Szczegóły</a></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
</body>
</html>