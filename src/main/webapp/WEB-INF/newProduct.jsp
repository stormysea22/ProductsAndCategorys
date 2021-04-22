<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Product and Categorys</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <h1>New Product</h1>
        <form:form action="/products/create" method="post" modelAttribute="product">
            <p>
                <form:label path="name">Product Name</form:label>
                <form:errors path="name" />
                <form:input path="name" />
            </p>
            <p>
                <form:label path="description">Description</form:label>
                <form:errors path="description" />
                <form:input path="description" />
            </p>
            <p>
                <form:label path="price">Price</form:label>
                <form:errors path="price" />
                <form:input type="number" path="price" />
            </p>
            <input type="submit" value="Submit" />
        </form:form>
    </div>
</body>

</html>