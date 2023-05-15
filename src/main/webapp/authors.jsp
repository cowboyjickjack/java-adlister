<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Authors</title>
</head>
<body>
    <c:forEach var="author" items="${authors}"> <%-- var = each item in our collection // items = what we're looping through --%>
        <div class="author">
            <p>${author.name}</p>
        </div>
    </c:forEach>
</body>
</html>
