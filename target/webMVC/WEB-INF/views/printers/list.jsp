<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Printers</title>
</head>
<body>
<h1>Принтеры: </h1>
<div id="userInfo">
    <s:authorize access="isAuthenticated()">
        Привет, <s:authentication property="principal.username"/>!
        <br/>
        <a href="../j_spring_security_logout">Выход: </a>
    </s:authorize>
</div>

<s:authorize access="isAnonymous()">
    <form action="../j_spring_security_check" method="POST">
        <label>Логин: </label>
        <input type="text" name="j_username">
        <label>Пароль: </label>
        <input type="password" name="j_password">
        <input type="submit" name="submit" value="Войти">
    </form>
</s:authorize>

<c:if test="${not empty printers}">
    <table border="1">
        <tr>
            <td>Модель</td>
            <td>Тип</td>
            <td>Цвет</td>
            <td>Цена</td>
            <s:authorize access="hasRole('ROLE_USER')">
            <td></td>
            <td></td>
            </s:authorize>
        </tr>
        <c:forEach items="${printers}" var="printer">
            <tr>
                <td>${printer.model}</td>
                <td>${printer.type}</td>
                <td>${printer.color}</td>
                <td>${printer.price}</td>
                <s:authorize access="hasRole('ROLE_USER')">
                <td><a href="update/${printer.code}">Изменить</a></td>
                <td><a href="delete/${printer.code}">Удалить</a></td>
                </s:authorize>
            </tr>
        </c:forEach>
    </table>
    <s:authorize access="hasRole('ROLE_USER')">
    <a href="update/0">Добавить...</a>
    </s:authorize>
</c:if>
</body>
</html>