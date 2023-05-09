<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- 'jsp tags' --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%! int count = 0; %> <%-- %! 'declaration' --%>
<% count += 1; %>
<html>
<head>
    <title><%= "Index JSP" %></title>
</head>
<body>

    <jsp:include page="partials/navbar.jsp"></jsp:include>

    <h1> The current count is <%= count %></h1> <%-- %= 'variable' --%>

    <h1>Implicit Objects in Action:</h1>
    <p>Path: <%= request.getRequestURL()%></p>
    <p>Query String: <%= request.getQueryString()%></p>
    <p>"name" parameter: <%= request.getParameter("name")%> </p>
    <p>"method" attribute: <%= request.getMethod()%></p>

    <h2>EL / Expression Language</h2>
    <p>"name" parameter: ${param["name"]}</p>

    <p>${2 + 2}</p>

    <% request.setAttribute("numbers", new int []{222, 777, 21, 7, 14, 6}); %>

    <ul>
        <c:forEach var="number" items="${numbers}"> <%-- var is what you're loopin through --%>
            <li>${number}</li>
        </c:forEach>
    </ul>

    <% request.setAttribute("five", 5); %>
    <c:choose>
        <c:when test="${five < 3}">
            <p>Expression 1 is true</p>
        </c:when>
        <c:when test="${five > 2}">
            <p>Expression 2 is false</p>
        </c:when>
        <c:otherwise>
            <p>Both expressions are false</p>
        </c:otherwise>
    </c:choose>

    <c:if test="true"> <%-- c:if = 'tag library' --%>
        <h1>Variable names should be very descriptive</h1>
    </c:if>
    <c:if test="false">
        <h1>single letter variable names are good</h1>
    </c:if>
</body>
</html>
