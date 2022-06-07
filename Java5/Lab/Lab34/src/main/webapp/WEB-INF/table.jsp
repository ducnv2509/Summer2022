<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/user/index">
    filter
    <input type="text" name="keyword">
    <button type="submit">Search</button>
    <button type="submit">Clear</button>
</form>

<table class="table">
    <tr>
        <td>ID</td>
        <td>FullName</td>
        <td>Username</td>
        <td>Role</td>
<%--        <td>Image</td>--%>
        <td>DateCreate</td>
        <td></td>
    </tr>

    <c:forEach var="i" items="${users}">
        <tr>
            <td>${i.id}</td>
            <td>${i.fullName}</td>
            <td>${i.username}</td>
            <td>${i.userType}</td>
<%--            <td>${i.image}</td>--%>
            <td>${i.createDate}</td>
            <td>
                <a href="/user/edit/${i.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>

</table>
