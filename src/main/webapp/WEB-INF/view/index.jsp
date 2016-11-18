<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 19.10.16
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/resource/js/jquery.min.js" var="jquery"/>
    <spring:url value="/resource/js/menu.js" var="menu"/>
    <spring:url value="/resource/css/reset.css" var="reset"/>
    <spring:url value="/resource/css/style.css" var="style"/>
    <spring:url value="/resource/img/" var="img"/>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,700|Raleway:200,400&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${reset}">
    <link rel="stylesheet" type="text/css" href="${style}">
    <script src="${jquery}" type="text/javascript"></script>
    <script src="${menu}" type="text/javascript"></script>
    <title>PasSec</title>
</head>
<body>
<header class="flex-container">
    <div class="center">
        <div class="header_left_block">
            <img src="${img}/logo.png">
        </div>
        <div class="header_right_block">
            <a href="#" id="touch_menu">Меню
                <img id="touch_menu_img" src="${img}/menu-ico2.png" width="20px"></a>
            <nav>
                <ul class="nav clearfix">
                    <li><a href="resource.html">Войти </a></li>
                    <li><a href="#">Скачать </a></li>
                    <li><a href="#">Генерация пароля </a></li>
                    <li><a href="#">Как это работает </a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<section>
    <!--<div class="content">-->
    <div class="block_content_left">
        <div class="block_content">
            <img src="${img}/man.png">
        </div>
        <div class="block_content">
            <h1>Мы запомним за вас пароли</h1>
            <h2>Что вам дает PasSEC?</h2>
            <p>&bull; Хранение пароля</p>
            <p>&bull; Генерация случайных паролей</p>
            <p>&bull; Защита ваших данных</p>
            <p>Можете положится на нас и забудете, что такое забытый пароль.</p>
        </div>
    </div>
    <div class="block_content_right">
        <div class="block_content">
            <c:url value="/j_spring_security_check" var="loginUrl" />
            <form action="${loginUrl}" method="post" class="form">
                <h1>Вход</h1>
                <label>Логин</label>
                <br/>
                <input type="text" class="form-control" name="j_username" placeholder="Введите логин">
                <br/>
                <label>Пароль</label>
                <br/>
                <input type="password" class="form-control" name="j_password" placeholder="Введите пароль">
                <a href="/registration">Еще не знакомы с PasSec?</a>
                <div class="submit">
                    <input type="submit" value="Войти" class="btn btn-lg btn-primary btn-block">
                    <br/>
                    <label>Забыли пароль?</label>
                </div>
                <div class="check_box">
                    <label><input type="checkbox">Запомни меня</label>
                </div>
            </form>
        </div>
        <div class="block_content">
            <img src="${img}/cross.png">
        </div>
    </div>
    <!--</div>/-->
</section>
<footer>
    <div class="footer_content">
        <div class="footer_div">
            <p>О НАС</p>
            <p>Информация</p>
            <p>Контакты</p>
            <p>Мы в соц сетях</p>
        </div>
        <div class="footer_div">
            <p>ПОДДЕРЖКА</p>
            <p>Руководство пользователя</p>
            <p>Напиши нам</p>
        </div>
    </div>
</footer>
</body>
</html>
