<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 01.08.2019
  Time: 01:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>User Administration</title>
</head>
<body>
<form method="post">
    <label>Nazwa użytkownika:
        <input type="text" name="userName" value="${user.userName}">
    </label>
    <br>
    <c:if test="${empty user}">
        <label>Hasło:
            <input type="password" name="password">
        </label>
        <br>
    </c:if>
    <label>Email:
        <input type="text" name="email" value="${user.email}">
    </label>
    <br>
    <label>Grupa:
        <select name="groupId">
            <c:if test="${not empty group}">
                <option value="${group.id}">${group.name}</option>
            </c:if>
            <c:forEach items="${allGroups}" var="insideGroup">
                <c:if test="${insideGroup.id != group.id}">
                    <option value="${insideGroup.id}">${insideGroup.name}</option>
                </c:if>
            </c:forEach>
        </select>
    </label>
    <br><br>
    <input type="submit" value="Zapisz">
</form>
</body>
</html>
