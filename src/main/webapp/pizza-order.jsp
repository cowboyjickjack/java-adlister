<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Papa's Pizzaria - Order</title>
</head>
<body>
    <h1>Customize Your Papa Pizza</h1>

    <form action="${pageContext.request.contextPath}pizza-order" method="POST">

        <label for="crust">Select Crust:</label>
        <select name="crust" id="crust">
            <option value="classic">Classic</option>
            <option value="thin">Thin</option>
            <option value="deep-dish">Deep Dish</option>
        </select>

        <br>

        <label for="sauce">Select Sauce:</label>
        <select name="sauce" id="sauce">
            <option value="tomato">Tomato</option>
            <option value="alfredo">Alfredo</option>
            <option value="pesto">Pesto</option>
        </select>

        <br>

        <label for="size">Select Size:</label>
        <select name="size" id="size">
            <option value="10">10"</option>
            <option value="12">12"</option>
            <option value="14">14"</option>
        </select>

        <br>

        <fieldset>
            <legend>Select Toppings:</legend>
            <label for="cheese">Cheese</label>
            <input type="checkbox" name="topping" value="cheese" id="cheese">
            <br>
            <label for="pepperoni">Pepperoni</label>
            <input type="checkbox" name="topping" value="pepperoni" id="pepperoni">
            <br>
            <label for="mushroom">Mushroom</label>
            <input type="checkbox" name="topping" value="mushroom" id="mushroom">
            <br>
            <label for="sausage">Sausage</label>
            <input type="checkbox" name="topping" value="sausage" id=sausage>
            <br>
        </fieldset>

        <br>

        <label for="address">Delivery Address:</label>
        <input type="text" name="address" id="address">

        <input type="submit" value="submit">
    </form>

    <c:if test="${order != null}">
        <h2>Please review your order:</h2>
        <p>Crust: ${order.crust}</p>
        <p>Sauce: ${order.sauce}</p>
        <p>Size: ${order.size}</p>
        <p>Toppings:</p>
        <ul>
            <c:forEach var="topping" items="${order.topping}">
                <li>${topping}</li>
            </c:forEach>
        </ul>

        <p>Delivery Address:</p>
        <p>${order.address}</p>
    </c:if>
</body>
</html>
