# Сервлет Spring Web MVC для работы с базой данных на MySQL
Задача поиска, обновления, удаления данных в таблицах. Обновление и удаление доступно лишь через авторизацию пользователя (реализовано посредством Spring Security)
Используются две таблицы printerstest и pctest из базы данных computers, имеющие соответственно вид:
![Printer](https://sun9-71.userapi.com/impg/pcPMGrvnDu3CfqYMi5yLSV_oLRVaUK2Txj0HNQ/FLx0hZqVMRI.jpg?size=392x126&quality=96&sign=9fdc18511499b9b80dfb9cc90bdb36f5&type=album)
![PC](https://sun9-66.userapi.com/impg/4T0EP8WTFBqtZWiU7cKnTcYfBvZ6-QB2wrGz_A/_31yRchzfYk.jpg?size=455x156&quality=96&sign=abf8745a7dcf55a9b3f5040d354675d2&type=album)
Модель реализована пакетом объектов доступа к данным и содержит реализации сущностей Printer и PC, а также сервисов для операций поиска, обновления и удаления данных сущностей
Контроллеры возвращают представления для соответствующих действий над реализациями сущностей
Представление написано на html + angular
Сервлет был развёрнут на локальном хосте под управлением веб-сервера Tomcat 9.0.341