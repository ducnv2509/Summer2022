<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<table>
    <tr>
        <td>No.</td>
        <td>Name</td>
        <td>Quantity</td>
        <td>Price</td>
        <td></td>
    </tr>
    <c:set var="no" value="1"></c:set>
    <c:forEach var="item" items="${cartItems}">
        <form action="/shoppingCart/update" method="post">
            <tr>
                <td>${no}</td>
                <td>${item.name}</td>
                <td>
                    <input type="hidden" name="id" value="${item.id}">
                    <input type="number" value="${item.quantity}" name="quantity"
                    onblur="this.form.submit()"
                    />
                </td>
                <td>${total}</td>
                <td>
                    <a href="/shoppingCart/remove/${item.id}">Remove</a>
                </td>
            </tr>
        </form>
        <c:set var="no" value="${no + 1}"></c:set>
    </c:forEach>
</table>
<a href="/products/list">LIst</a>
<a href="/shopCart/checkOut">ChecOUT</a>
</body>
</html>