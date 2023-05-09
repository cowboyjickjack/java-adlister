<div>
    <div>
        <h2>Login Page</h2>
        <p>Please sign in with your Username and Password</p>
    </div>
    <form method="POST" action="/profile.jsp">
        <label for="username">Username:</label>
        <input type="text" placeholder="Enter Username" id="username">

        <br>

        <label for="password">Password:</label>
        <input type="password" placeholder="Enter Password" id="password">

        <br>

        <button type="submit" value="Login">Login</button>
    </form>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            response.sendRedirect("profile.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</div>