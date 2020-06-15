<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://example.com/functions" prefix="f" %>
<html>
<head>
    <title>MealsList</title>
</head>
<body>

<h2>Таблица еды</h2>
    <table border="3">
        <tr>
            <th>Id еды</th>
            <th>Время</th>
            <th>Описание</th>
            <th>Колории</th>
        </tr>
        <c:forEach var="num" items="${list}">
            <c:if test="${num.excess}">
                <c:set var="item" scope="request">red</c:set>
            </c:if>
            <c:if test="${!num.excess}">
                <c:set var="item" scope="request">green</c:set>
            </c:if>
            <tr style="color: ${item}">
                <td>${num.id}</td>
                <td>${f:formatLocalDateTime(num.dateTime, "dd.MM.yyyy HH-mm")}</td>
                <td>${num.description}</td>
                <td>${num.calories}</td>
                <td>
                    <a href="update?id=${num.id}">edit</a>
                    <a href="delete?id=${num.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<p><a href="add">Добавить еду</a></p>
</body>
</html>
