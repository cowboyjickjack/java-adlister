<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <div>
        <c:if test="${empty search}">
            <h1>Here are all the ads!</h1>
        </c:if>
        <c:if test="${not empty search}">
            <h1>You are searching for <c:out value="" </h1>
        </c:if>
        <form action="/ads/search" method="POST">
            <input type="text" name="search">
            <button type="submit">Search</button>
        </form>

    </div>
</div>

</body>
</html>
