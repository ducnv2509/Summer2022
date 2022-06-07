<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <base href="/">
</head>
<body>
<h1>List</h1>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td></td>
    </tr>
    <c:forEach var="item" items="${students}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td> <a href="students/saveOrUpdate/${item.id}">View</a>
                <a href="students/edit/${item.id}">Edit</a>
                <a href="students/delete/${item.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>