<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 24.10.16
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:url value="/resource/js/jquery.min.js" var="jquery"/>
    <c:url value="/resource/js/jquery-validation-1.15.1/dist/jquery.validate.min.js" var="validator"/>
    <c:url value="/resource/js/sha1.js" var="sha1"/>
    <c:url value="/resource/js/registrationform.js" var="custom"/>
    <script src="${jquery}"></script>
    <script src="${validator}"></script>
    <script src="${sha1}"></script>
    <script src="${custom}"></script>
</head>
<div id="feedback"></div>

<div class="container">
    <h3 class="form-title">Заполните форму</h3>
    <form action="#" method="post"  class="form" id="js-register-form">
        <div class="message js-form-message"></div>
        <div class="form-group">
            <input type="text" placeholder="Логин" name="form_login" id="form_login" class="form-input"/>
        </div>
        <div class="form-group">
            <input type="email" placeholder="e-mail" name="form_email" id="form_email" class="form-input"/>
        </div>
        <div class="form-group">
            <input type="password" placeholder="Пароль" name="form_pswd1" id="form-pswd1" class="form-input"/>
        </div>
        <div class="form-group">
            <input type="password" placeholder="Повторите пароль" name="form_pswd2" class="form-input">
        </div>
        <div class="form-group">
            <input type="submit" class="form-btn" id="btn-add" value="Отправить"/>
        </div>
    </form>
</div>

</body>
</html>
