<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>edit student</h1>
<form action="students/update" method="post">
    Student ID: <input type="text" name="id" value="${student.id}"> <br>
    Name: <input type="text" name="name" id="" value="${student.name}"> <br>
    <button>Update</button>
    <button formmethod="get" formaction="students/list">List</button>
    <button formmethod="get" formaction="students/search">Search</button>
</form>
</body>
</html>