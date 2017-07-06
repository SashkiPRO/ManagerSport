<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 02.05.2017
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/datepicker.css" rel="stylesheet" >



<div id="navbarCollapse" class="collapse navbar-collapse navbar-right">
  <ul class="nav nav-pills">
    <li class="active"><a href="controller?command=list_players" >Главная</a></li>
    <li ><a  href="#"  >Статистика</a></li>
    <li ><a href="/players" >Игроки</a></li>
    <li ><a href="results.jsp"  >Результаты матчей</a></li>
    <li ><a href="contacts.html">Контакты</a></li>
  </ul>
</div>

</div>
</nav>
</div>
</div>
<div class="wrapper">
  <div class="container">
    <div class="row">
      <div class="col-lg-9 col-lg-push-3 tournament_block">
        <div class="col-lg-12">
          <a href="#">На главную</a>
          <a href="#">	<button type="button" class="btn btn-default add_tournament">
            + Добавить турнир
          </button></a>
            <div class="col-lg-12">dsadsa</div>
          <form:form modelAttribute="game" method="post" >
       <%--<table><form:checkboxes path="players" items="${players}"  itemLabel=""  itemValue="id"  cssClass="checkbox-inline " delimiter="<br/>"/>
         </tr>--%>
              <table class="table" style="background-color: #ffffff" width="100%">
                  <tr><td>Выбрать</td><td>Фамилия</td><td>Имя</td><td>№</td></tr>
              <c:forEach items="${players}" var="player">


                  <tr><td><form:checkbox path="players" value="${player}" cssClass="checkbox"/></td><td> ${player.lastName}</td><td> ${player.firstName}</td><td>${player.number}</td></tr>

              </c:forEach>

              </table>

            <div class="form-group"> <!-- Submit Button -->
              <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>


</form:form>


        </div>


      </div>

      <div class="col-lg-3 col-lg-pull-9">
        <ul class="nav nav-pills stat_nav nav-stacked">
          <li><a href="#">Личная информация</a></li>
          <li class="active"><a href="#">Турниры</a></li>
          <li><a href="#">Комманды</a></li>
          <li><a href="#">Игроки</a></li>
          <li><a href="#">Матчи</a></li>
          <li><a href="#">Мультимедиа</a></li>
          <li><a href="#">Messages</a></li>
        </ul>

      </div>
    </div>

  </div>
</div>


<div class="margin-8"></div>
<div class="clear"></div>
</div>


<footer>
  <div class="container">
    <p class="text-center"><a href="#">ciklum</a></p>
  </div>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
