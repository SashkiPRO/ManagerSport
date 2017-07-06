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
<%@ include file="/WEB-INF/views/jspf/head.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>


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


        <div class="col-lg-3">
          <c:if test="${player.photo!=null}">
            <img src="ImageShow?type=player&id=${player.id}">
          </c:if>
          <c:if test="${player.photo==null}">
            <img src="${contextPath}/resources/images/question.jpg">
          </c:if>
          ${team}
        </div>

            <!-- Default panel contents -->

              <div class="col-lg-7">

            <!-- Table -->
            <table class="table table-hover" style="background-color: #ffffff">
              <tr><td>№</td><td>Игрок</td><td><img src="${contextPath}/resources/images/game.png"></td><td><img src="${contextPath}/resources/images/ball.png"></td><td><img src="${contextPath}/resources/images/yellow.png"></td><td><img src="${contextPath}/resources/images/red.png"></td><td><img src="${contextPath}/resources/images/position.png"></td><td></td></tr>



              <tr><td>${player.number}</td><td>${player.games.size()}</td><td>${player.goals.size()}</td><td>${player.yellowCards.size()}</td><td>${player.redCards.size()}</td><td>GK</td></tr>
<tr><td colspan="7">    <H4>Статистика выступлений</H4></td></tr>
              <tr><td></td><td>№</td><td><img src="${contextPath}/resources/images/game.png"></td><td><img src="${contextPath}/resources/images/ball.png"></td><td><img src="${contextPath}/resources/images/yellow.png"></td><td><img src="${contextPath}/resources/images/red.png"></td><td><img src="${contextPath}/resources/images/position.png"></td><td></td></tr>
              <tr><td>${player.firstName} ${player.lastName}</td><td>${player.number}</td><td>${player.games.size()}</td><td>${player.goals.size()}</td><td>${player.yellowCards.size()}</td><td>${player.redCards.size()}</td><td>GK</td></tr>

            </table>
              </div>

        </div>






    </div>
      <div class="col-lg-3 col-lg-pull-9">
        <ul class="nav nav-pills stat_nav nav-stacked">
          <li><a href="#">Личная информация</a></li>
          <li ><a href="#">Турниры</a></li>
          <li class="active"><a href="#">Комманды</a></li>
          <li><a href="#">Игроки</a></li>
          <li><a href="#">Матчи</a></li>
          <li><a href="#">Мультимедиа</a></li>
          <li><a href="#">Messages</a></li>
        </ul>

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
