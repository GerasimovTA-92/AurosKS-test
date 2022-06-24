<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>All packs</title>
</head>
<body>
<h1 class="table_dark">All packs:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Creation Date</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="kPac" items="${set}">
        <tr>
            <td>
                <c:out value="${kPac.id}"/>
            </td>
            <td>
                <c:out value="${kPac.title}"/>
            </td>
            <td>
                <c:out value="${kPac.description}"/>
            </td>
            <td>
                <c:out value="${kPac.creationDate}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/kpacs/delete/${kPac.id}">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
