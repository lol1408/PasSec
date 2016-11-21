<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 09.10.16
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <spring:url value="/resource/js/jquery.min.js" var="jquery"/>
    <spring:url value="/resource/css/reset.css" var="reset"/>
    <spring:url value="/resource/css/style.css" var="style"/>
    <spring:url value="/resource/css/resource.css" var="table"/>
    <spring:url value="/resource/img/" var="img"/>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,700|Raleway:200,400&amp;subset=cyrillic,cyrillic-ext" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${reset}">
    <link rel="stylesheet" type="text/css" href="${style}">
    <link rel="stylesheet" type="text/css" href="${table}">
    <link rel="stylesheet" type="text/css" href="resource/css/popup.css">
    <script src="${jquery}" type="text/javascript"></script>
    <script src="${menu}" type="text/javascript"></script>
    <script src="/resource/js/jquery-validation-1.15.1/dist/jquery.validate.min.js" type="text/javascript"></script>
    <script src="/resource/js/popup.js" type="text/javascript"></script>
    <script src="/resource/js/addresform.js" type="text/javascript"></script>
    <script type="text/javascript">
        function table() {
            $.getJSON('/list', function(data) {
                var elem = document.getElementById("table");
                data.forEach(function (item, i, data) {
                    var row = elem.insertRow(i+1);
                    var nameRes = row.insertCell(0);
                    var log = row.insertCell(1);
                    var pass = row.insertCell(2);
                    nameRes.innerHTML=data[i].nameResource;
                    log.innerHTML=data[i].login;
                    pass.innerHTML=data[i].password;
                    //document.body.appendChild(elem);
                })
            }).fail(function (jqxhr, testStatus, error) {
                var err = testStatus + ',' + error;
                console.log("Request failed: " + err);
                document.getElementById("table").style.display = "none";
            });
        }
    </script>
</head>
<body onload="table()">
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
                    <li><a href="#">Скачать </a></li>
                    <li><a href="#">Генерация пароля </a></li>
                    <li><a href="#">Как это работает </a></li>
                    <li><a href="/logout">Выйти</a> </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<section>
    <h1>Ваши пароли</h1>
    <table id="table" class="table_blur">
        <tr>
            <th>Ресурс</th><th>Логин</th><th>Пароль</th>
        </tr>
    </table>
    <input type="button" id="add-res-butt" onclick="popup_show()" value="Добавить запись">
    <div id="popup_div">
        <div class="popup_content" id="popup_content">
            <form action="/#" method="post" id="popup_form" name="popup_form">
                <img src="resource/img/fileclose_5805.ico" id="close" onclick="popup_hide()">
                <h2>Введите данные о рессурсе</h2>
                <hr>
                <div id="inputs_popup">
                    <label class="label_resource">Имя ресурса</label>
                    <input id="name_resource" type="text" name="name_resource" placeholder="Имя">
                    <label class="label_resource">Логин от ресурса</label>
                    <input id="login_resource" type="text" name="login_resource" placeholder="Логин">
                    <label class="label_resource">Пароль от ресурса</label>
                    <input id="password_resource" type="text" name="password_resource" placeholder="Пароль">
                </div>
                <input id="submit_popup_form" type="submit" name="submit_popup_form">
            </form>
        </div>
    </div>
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
    <div id="feedback"></div>
</footer>
</body>
</html>

