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
        <h1>New Category</h1>
        <div class="col-8">
            <form:form action="/categorys/create" method="post" modelAttribute="category">
                <div class="form-group">
                    <form:label path="name">Category Name</form:label>
                    <form:errors path="name" />
                    <form:input path="name" />
                </div>
                <input type="submit" value="Submit" />
            </form:form>
        </div>
    </div>
</body>

</html>