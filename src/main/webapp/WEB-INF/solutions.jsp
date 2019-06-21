<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 08.06.19
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<table>
    <tr>
        <th>Tytuł</th>
        <th>Autor</th>
        <th>Data</th>
        <th></th>
    </tr>

    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.exercise.title}</td>
            <td>${solution.user.userName}</td>
            <td>${solution.solution.created}</td>
            <td><a href="<c:url value="/solution?id=${solution.solution.id}"/>">Szczegóły</a></td>
        </tr>
    </c:forEach>

</table>
