<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://example.com/functions" prefix="f" %>
<%@ page import="java.time.LocalDateTime" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:if test="empty meal.description">
        <c:set var="var">add</c:set>
    </c:if>
    <c:if test="not empty meal.description">
        <c:set var="var">update</c:set>
    </c:if>
    <p>Форма работы с пользователем</p>
    <form action="${var}" method="post">
        <c:if test="${!empty meal.description}">
            <input type="hidden" name="id" value="${meal.id}">
        </c:if>
        <label for="dateTime"> mealtime</label>
        <input type="datetime-local" name="dateTime" id="dateTime" value="<%= LocalDateTime.now().toString().substring(0, 16)%>")}"><br>
        <label for="description"> description of meal</label>
        <input type="text" name="description" id="description" value="${meal.description}"><br>
        <label for="calories"> calories of meal</label>
        <input type="text" name="calories" id="calories" value="${meal.calories}"><br>
        <input type="submit" value="<c:out value="${not empty meal.description ? 'редактировать еду' : 'добавить еду'}" />">
    </form>
</body>
</html>
