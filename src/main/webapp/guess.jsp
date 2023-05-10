<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guessing Game</title>
</head>
<body>
  <div>
    <h1>Guess a Number Between 1 and 3...</h1>

    <form action="${pageContext.request.contextPath}/guess" method="POST">
      <label for="number">Choose Wisely:</label>
      <input type="text" min="1" max="3" name="number" id="number">
      <input type="submit" value="submit">
    </form>

  </div>
</body>
</html>
