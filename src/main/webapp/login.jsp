<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div>
        <h2>Login Page</h2>
        <p>Please sign in with your Username and Password</p>
    </div>
    <form method="POST" action="${pageContext.request.contextPath}/profile.jsp">
        <label for="username">Username:</label>
        <input type="text" placeholder="Enter Username" id="username">

        <br>

        <label for="password">Password:</label>
        <input type="password" placeholder="Enter Password" id="password">

        <br>

        <button type="submit" value="Login">Login</button>
    </form>

    <c:if test="${param.username == 'admin' && param.password == 'password'}">
        <c:redirect url="profile.jsp" />
    </c:if>
</div>