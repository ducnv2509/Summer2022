<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>Id: ${student.id}</h3>
<h3>Name: ${student.name}</h3>
<h3>Email: ${student.email}</h3>
<h3>mark: ${student.mark}</h3>
<h3>Hobbies: ${student.hobbies}</h3>
<h3>Gender: ${student.gender == true ? 'Male' : 'Femal'}</h3>
<h3>Gender:
<img src="../images/${student.imageUrl}"/>
</h3>
</body>
</html>
