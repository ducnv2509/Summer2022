<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1" style="width: 100%">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td></td>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>
                <a href="/category/edit/${item.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>