<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <!DOCTYPE html>
    <!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
    <!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
    <!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
    <!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>

    <link href="${contextPath}/resources/css/form-style.css" rel="stylesheet">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>22 лучших формы входа и регистрации | Vladmaxi.net</title>
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>


<section class="container">
    <div class="login">

        <h1>Войти в личный кабинет</h1>
        <form method="post" action="${contextPath}/login">
            <p><input type="text" name="username" value="" placeholder="Логин"></p>
            <p><input type="password" name="password" value="" placeholder="Пароль"></p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            ${error}
            <p class="remember_me">
                <label>
                    <input type="checkbox" checked="true" name="rememb" id="remember_me" value="true">
                    Запомнить меня
                </label>
            </p>
            <p class="submit"><input type="submit" name="commit" value="Войти"></p>
        </form>
    </div>

    <div class="login-help">
        <a href="#">Забыли пароль?</a> Восстановите его!
    </div>
</section>
</body>
</html>



