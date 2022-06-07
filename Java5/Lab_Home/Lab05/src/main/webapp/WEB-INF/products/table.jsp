<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1" style="width: 100%">
    <tr>
        <td>
            <a href="/product/sort?field=id">ID</a>
        </td>
        <td>
            <a href="/product/sort?field=name">Name</a>
        </td>
        <td>
            <a href="/product/sort?field=price">Price</a>
        </td>
        <td>
            <a href="/product/sort?field=available">available</a>
        </td>
        <td></td>
    </tr>
    <c:forEach var="item" items="${page.content}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.available}</td>
            <td>
                <a href="/category/edit/${item.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/product/page?p=0">First</a>
<a href="/product/page?p=${page.number-1}">Previous</a>
<a href="/product/page?p=${page.number+1}">Next</a>
<a href="/product/page?p=${page.totalPages-1}">Last</a>
<ul>
    <li>Số thực thể hiện tại: ${page.numberOfElements}</li>
    <li>Trang số: ${page.number}</li>
    <li>Kích thước trang: ${page.size}</li>
    <li>Tổng số thực thể: ${page.totalElements}</li>
    <li>Tổng số trang: ${page.totalPages}</li>
</ul>
