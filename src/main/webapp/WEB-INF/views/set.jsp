<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>All sets</title>
</head>
<body>
<h1 class="table_dark">All sets:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Pacs</th>
        <th>ADD Pac</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="set" items="${sets}">
        <tr>
            <td>
                <c:out value="${set.id}"/>
            </td>
            <td>
                <c:out value="${set.title}"/>
            </td>
            <td>
                <c:forEach var="kPac" items="${set.kPacs}">
                    ${kPac.id} ${kPac.title} <br>
                </c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/sets/kpacs/add">ADD PAC</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/sets/delete?id=${set.id}">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>