<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form action="/user/create" modelAttribute="item">
    <form:input type="hidden" path="id" placeholder="Category Id?"/>
    <div class="mb-3">
        <label class="form-label">FullName</label>
        <form:input cssClass="form-control" path="fullName"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Username</label>
        <form:input cssClass="form-control" path="username"/>
    </div>
    <div class="mb-3">
        <label class="form-label">password</label>
        <form:input type="password" cssClass="form-control" path="password"/>
    </div>
    <form:select cssClass="form-select" path="userType">
        <c:forEach var="ty" items="${typeRole}">
            <form:option value="${ty}">
                ${ty}
            </form:option>
        </c:forEach>
    </form:select>
    <hr>
    <%--    <button type="submit" class="btn btn-sm">Create</button>--%>
    <button formaction="/user/create">Create</button>
    <button formaction="/user/update">Update</button>
    <a href="/user/delete/${item.id}">Delete</a>
    <a href="/user/index">Reset</a>

</form:form>

