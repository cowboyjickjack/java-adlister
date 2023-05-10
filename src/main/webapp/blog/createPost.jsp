<%--
  Created by IntelliJ IDEA.
  User: gabriellamartinez
  Date: 5/9/23
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<jsp:include page="/partials/head.jsp">
    <jsp:param name="title" value="Create a Blog Post" />
</jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />
<div class="container">
    <h1>Create a Blog Post</h1>
    <form action="createPost" method="POST">
        <label for="title">Title:</label>
        <input type="text" name="title" id="title">
        <br>
        <label for="post">Your Post:</label>
        <textarea name="post" id="post" cols="30" rows="10"></textarea>
        <br>
        <fieldset>
            <legend>Topic:</legend>
            <label for="programming">Programming:</label>
            <input type="checkbox" name="topic" value="programming" id="programming">
            <br>
            <label for="AI">AI:</label>
            <input type="checkbox" name="topic" value="AI" id="AI">
            <br>
            <label for="security">Security:</label>
            <input type="checkbox" name="topic" value="security" id="security">
        </fieldset>
        <br>
        <input type="submit" value="Submit">
    </form>
    <c:if test="${post != null}">
        <h3>Your Blog Post:</h3>
        <h3>${post.title}</h3>
        <p>${post.post}</p>
        <p>Topics:</p>
        <c:forEach var="topic" items="${post.topics}">
            <li>${topic}</li>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
