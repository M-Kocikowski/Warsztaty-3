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
    Użytkownicy w grupie: ${groupName}
    <br>
    <table>
        <tr>
            <th>Nazwa</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="user" items="${usersInGroup}">
            <tr>
                <td>${user.userName}</td>
                <td><a href="<c:url value="/userdetails?userId=${user.id}"/>">Szczegóły</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
