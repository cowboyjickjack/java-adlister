<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Color Picker 2000</title>
</head>
<body>

    <h1>Welcome to Color Picker 2000!</h1>

    <h3>Please select your favorite color:</h3>

    <form action="${pageContext.request.contextPath}/pickcolor" method="POST">
        <label for="userColor">Select your favorite color:</label>
        <input type="text" name="userColor" id="userColor">
        <input type="submit" value="submit">
    </form>
</body>
</html>
