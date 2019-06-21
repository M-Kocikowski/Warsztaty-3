<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 08.06.19
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Solution Details</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <br>
    <a href="<c:url value="/"/>">Powrót</a>
    <br>
    Szczegóły rozwiązania zadania:
    <br>
    <c:out value="${solutionDescription.description}"/>

</body>
</html>
