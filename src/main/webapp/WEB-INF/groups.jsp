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

Lista grup:
<table>
    <tr>
        <th>Nazwa grupy</th>
        <th>Akcje</th>
    </tr>

    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.name}</td>
            <td><a href="<c:url value="/showusersbygroup?groupId=${group.id}"/>">Użytkownicy</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
