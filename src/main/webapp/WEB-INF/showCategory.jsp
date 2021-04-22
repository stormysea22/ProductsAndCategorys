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
        <h1>${categoryShow.name}</h1>
    </div>
    <h3>Products:</h3>
    <ol>
        <c:forEach items="${categoryShow.products}" var="product">
            <li>${product.name}</li>
        </c:forEach>
    </ol>

    <form action="/addProductToCategory" method="post">
        <input type="hidden" name="hiddenCategoryId" value="${categoryShow.id}">
        <label>Select Products to add to the Category:</label>
        <select name="selectedProduct">
            <c:forEach items="${allProducts}" var="product">
                <option value="${product.id}">${product.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Add">
    </form>

</body>

</html>