<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%--@elvariable id="student" type=""--%>
<form:form action="/students/saveOrUpdate" method="post" modelAttribute="student" enctype="multipart/form-data">
    Student ID: <form:input path="id"/> <br>
    <form:errors path="id"/>
    Name: <form:input path="name"/> <br>
    <form:errors path="name"/>
    Email: <form:input path="email"/> <br>
    <form:errors path="email"/>
    Mark: <form:input path="mark"/> <br>
    <form:errors path="mark"/>
    Faculty:
    <form:select path="faculty" items="${faculties}"></form:select>
    <br>
    <form:radiobuttons path="gender" items="${genders}"/>
    <br>
    <form:checkboxes path="hobbies" items="${hobbies}"/>
    <br>
    <input type="file" name="imageFile"> <br>

    <form:button>
        Add Student
    </form:button>
</form:form>
</body>
</html>