<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="${pageContext.request.contextPath}/login.jsp" method="POST">
    <label for="username">Username</label>
    <input type="text" name="username" id="username" />
    <label for="password">Password</label>
    <input type="password" name="password" id="password" />
    <input type="submit" value="Login" />
</form>
</body>
</html>


<c:if test="${param.username == 'admin' && param.password == 'password'}">
    <c:redirect url="profile.jsp" />
</c:if>
=======
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile");
        }
    }
%>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Please Log In</h1>
    <form action="${pageContext.request.contextPath}/login.jsp" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Log In">
    </form>
</div>
</body>
</html>
>>>>>>> servlets-with-jsps
