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
<link href="${contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet" >

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
        <div class="col-lg-9">
          <a href="#">На главную</a>
          <a href="#">	<button type="button" class="btn btn-default add_tournament">
            + Добавить турнир
          </button></a>


          <form:form modelAttribute="newGame">

        <div class="form-group">
            <label for="awayTeamSelect" class="control-label">Команда хозяин</label>
            <form:select cssClass="form-control" path="awayTeam" id="awayTeamSelect">
              <form:option value="">Select AwayTeam</form:option>
              <c:forEach items="${item.teams}" var="team">
                <form:option value="${team.id}" >${team}</form:option>
              </c:forEach>
            </form:select>

        </div>
              <div class="form-group">
            <label for="homeTeamSelect" class="control-label">Команда гость</label>
            <form:select cssClass="form-control" path="homeTeam" id="homeTeamSelect">
              <form:option value="">Select AwayTeam</form:option>
              <c:forEach items="${item.teams}" var="team">
                <form:option value="${team.id}">${team}</form:option>
              </c:forEach>
            </form:select>
              </div>
              <div class="form-group">
            <label for="hallSelect" class="control-label">Спортивный зал</label>
            <form:select cssClass="form-control" path="hall" id="hallSelect">
              <form:option value="">Select Hall</form:option>
              <c:forEach items="${halls}" var="hall">
                <form:option value="${hall.id}">${hall}</form:option>
              </c:forEach>
            </form:select>
              </div>
              <div class="form-group">
            <label for="tourSelect" class="control-label">Выберете тур</label>
            <form:select cssClass="form-control" path="tour" id="tourSelect">
              <form:option value="">Select Hall</form:option>
              <c:forEach items="${tours}" var="tour">
                <form:option value="${tour.id}">${tour}</form:option>
              </c:forEach>
            </form:select>
              </div>
              <div class="form-group">
              <label for="tournamentSelect" class="control-label">Турнир</label>
              <form:select cssClass="form-control" path="tournament" id="tournamentSelect">

                      <form:option selected="true" value="${item.id}" >${item}</form:option>
              </form:select>
              </div>

              <div class="form-group">
                  <div class='input-group date' id='datetimepicker9'>
                      <form:input path="date" id="date" cssClass="form-control"  />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
                  </div>
              </div>
              <div class="form-group">
            <input class="btn btn-warning" type="submit" value="Add">
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
<script src="${contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
<script >

    $('#date').datetimepicker();
</script>
</body>
</html>
