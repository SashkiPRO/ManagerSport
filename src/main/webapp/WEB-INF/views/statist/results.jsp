
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<div class="col-lg-9 col-lg-push-3">
			
		<c:forEach items="${tournament.tours}" var="tour">

			<div class="panel panel-info">
				<div class="panel-heading">${tour}</div>
				<div class="panel-body">
					<table class="table">
						<c:forEach items="${tour.games}" var="game">
							<tr><td>${game.dateString}</td><td><a class="link_team" href="show_team?id=${game.homeTeam.id}">${game.homeTeam}</a></td><td><a href="form_aplication?game_id=${game.id}&team_id=${game.homeTeam.id}"><img src="resources/images/edit.png" title="Заполнить заявку"></a></td> <td class="goals_value"><span class="badge">${game.homeTeamGoals}</span></td><td>:</td>  <td class="goals_value"><span class="badge">${game.awayTeamGoals}</span></td><td><a class="link_team" href="show_team?id=${game.awayTeam.id}"> ${game.awayTeam}</a></td><td><a href="form_aplication?game_id=${game.id}&team_id=${game.awayTeam.id}"><img src="resources/images/edit.png" title="Заполнить заявку"></a></td><td class="hall_td">${game.hall}</td><td><a href="#"><img src="resources/images/remove.png" title="Удалить"></a></td><td><a href="#"><img src="resources/images/game.png" title="Заполнить протокол"></a></td></tr>

						</c:forEach>


					</table>

				</div>
			</div>

		</c:forEach>


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
</div>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>