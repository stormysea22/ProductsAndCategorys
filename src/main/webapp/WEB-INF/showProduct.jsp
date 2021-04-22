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
        <h1>${productShow.name}</h1>
    </div>
    <h3>Categories:</h3>
    <ol>
        <c:forEach items="${productShow.categorys}" var="category">
            <li>${category.name}</li>
        </c:forEach>
    </ol>

    <form action="/addCategoryToProduct" method="post">
        <input type="hidden" name="hiddenProductId" value="${productShow.id}">
        <label>Select Categories to add to the Products:</label>
        <select name="selectedCategory">
            <c:forEach items="${allCategorys}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Add">
    </form>

</body>

</html>

</html>