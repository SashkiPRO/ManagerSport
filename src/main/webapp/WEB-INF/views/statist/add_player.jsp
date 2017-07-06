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
        <div class="col-lg-9">
          <a href="#">На главную</a>
          <a href="#">	<button type="button" class="btn btn-default add_tournament">
            + Добавить турнир
          </button></a>


          <form:form modelAttribute="newPlayer">


              <div class="form-group"> <!-- Full Name -->
                <label for="full_name_id" class="control-label">Full Name</label>
                <form:input type="text" class="form-control" id="full_name_id" path="firstName" placeholder="John Deer"/>
              </div>

              <div class="form-group">
                <label for="lastName" class="control-label">Фамилия</label>
                <form:input type="text" class="form-control" id="lastName" placeholder="Last name" path="lastName"/>
              </div>

              <div class="form-group"> <!-- Street 2 -->
                <label for="number" class="control-label">Номер</label>
                <form:input type="text" class="form-control" id="number" path="number" placeholder="Номер"/>
              </div>

              <div class="form-group"> <!-- City-->
                <label for="team" class="control-label">Комманда</label>
                <form:select cssClass="form-control" path="team" id="team">

                  <form:option selected="true" value="${team.id}" >${team}</form:option>
                </form:select>
              </div>


            <div class="form-group">
              <div class='input-group date' id='datetimepicker9'>
                <form:input path="birthDate" id="birthDate" cssClass="form-control"  />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
              </div>
            </div>



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
<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>
<script>
    $('#birthDate').datepicker({dateFormat:'yy-mm-dd'});
</script>
</body>
</html>
