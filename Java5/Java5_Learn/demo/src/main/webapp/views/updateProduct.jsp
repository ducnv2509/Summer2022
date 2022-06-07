<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.0.2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h1>Do you really want to assign product: <strong>${product.productName}</strong></h1>
    <form:form method="POST"
               action="/products/updateProduct/${product.getProductID()}"
               modelAttribute="product">
        <form:input type="text" value="${product.productName}"
                    path="productName"
        />
        <br>
        <form:errors path="productName" cssClass="text-danger"/>
        <br>
        <form:input type="number" value="${product.price}"
                    path="price"
        />
        <br>
        <form:errors path="price" cssClass="text-danger"/>
        <br>

        <form:input type="text" value="${product.description}"
                    path="description"
        />
        <br>
        <form:errors path="description" cssClass="text-danger"/>
        <br>

        <form:select path="categoryID">
            <c:forEach var="category" items="${categories}">
                <form:option value="${category.getCategoryID()}">
                    ${category.getCategoryName()}
                </form:option>
            </c:forEach>
        </form:select>
        <form:input type="submit" value="Update" path=""/>
    </form:form>

    <form:form method="post" action="/products/deleteProduct/${product.getProductID()}"
               onsubmit="return confirm('Are you sure you want to delete this product') ? true : false">
        <input class="btn btn-sm btn-danger" type="submit" value="Delete">
    </form:form>

</div>
<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>