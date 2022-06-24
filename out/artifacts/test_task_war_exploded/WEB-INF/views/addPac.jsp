<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Add pac</title>
</head>
<body>
<form method="post" id="pac" action="${pageContext.request.contextPath}/kpacs/add"></form>
<h1 class="table_dark">Add car:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Add</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="title" form="pac" required>
        </td>
        <td>
            <input type="text" name="description" form="pac" required>
        </td>
        <td>
            <input type="submit" name="add" form="pac">
        </td>
    </tr>
</table>
</body>
</html>
