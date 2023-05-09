<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

    }

%>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
    <div>
        <h2>Login Page</h2>
        <p>Please sign in with your Username and Password</p>
    </div>
    <form method="POST" action="${pageContext.request.contextPath}/login.jsp">
        <label for="username">Username:</label>
        <input type="text" placeholder="Enter Username" id="username">

        <br>

        <label for="password">Password:</label>
        <input type="password" placeholder="Enter Password" id="password">

        <br>

        <input type="submit" value="Login">
    </form>
    </body>
</html>

<c:if test="${param.username == 'admin' && param.password == 'password'}">
    <c:redirect url="profile.jsp" />
</c:if>