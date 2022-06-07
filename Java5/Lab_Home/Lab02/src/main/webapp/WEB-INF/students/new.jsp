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
<form action="students/saveOrUpdate" method="post">
    Student ID: <input type="text" name="id"> <br>
    Name: <input type="text" name="name" id=""> <br>
    <button >Save</button>
    <button formmethod="get" formaction="students/list" >List</button>
    <button formmethod="get" formaction="students/search">Search</button>
</form>
</body>
</html>