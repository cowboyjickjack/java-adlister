<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Color View</title>
    <style>
        body{
            display: flex;
            text-align: center;
            align-items: center;
            justify-content: center;
            font-size: 64px;
            color: white;
            <c:if test="${userColor != null}">
                background-color: ${userColor};
            </c:if>
        }
    </style>
</head>
<body>

    <h1>${userColor} IS THE BEST!</h1>

</body>
</html>
