<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Принтер</title>
    <style>
        form fieldset {
            width : 40%;
        }
        form fieldset label {
            display : block;
            /*width : 50%;
            float :left;*/
        }
        form fieldset input, form fieldset textarea {
            width : 100%;
        }
    </style>
    <script>
        var disableForm = true;
        <s:authorize access="hasRole('ROLE_USER')">
        disableForm = false;
        </s:authorize>
        window.addEventListener("load", function () {
            if (disableForm) {
                var inputs = document.querySelectorAll("form fieldset input, form fieldset textarea");
                for (var i=0; i<inputs.length; i++)
                    inputs[i].disabled = true;
            }
        })
    </script>
</head>
<body>
<h1>Принтер</h1>
<form method="POST">
    <fieldset>
        <div>
            <label>Модель: </label>
            <input  type="number" name="model" value="${printer.model}">
        </div>
        <div>
            <label>Тип: </label>
            <input  type="text" name="type" value="${printer.type}">
        </div>
        <div>
            <label>Цена: </label>
            <input type="number" name="price" value="${printer.price}">
        </div>
        <div>
            <label>Цвет: </label>
            <input type="text" name="color" value="${printer.color}">
        </div>
        <div>
            <input type="submit" value="Сохранить">
        </div>
    </fieldset>

</form>

</body>
</html>
