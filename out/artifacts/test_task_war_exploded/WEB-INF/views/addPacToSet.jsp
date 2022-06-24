<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Add driver to car</title>
</head>
<body>
<form method="post" id="set" action="${pageContext.request.contextPath}/sets/kpacs/add"></form>
<h1 class="table_dark">Add driver to car:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Set ID</th>
        <th>KPac ID</th>
        <th>Add</th>
    </tr>
    <tr>
        <td>
            <input type="number" name="setId" form="set" required>
        </td>
        <td>
            <input type="number" name="kPacId" form="set" required>
        </td>
        <td>
            <input type="submit" name="add" form="set">
        </td>
    </tr>
</table>
</body>
</html>