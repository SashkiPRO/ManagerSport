<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/jspf/head.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/jspf/header.jspf"%>

	<div id="navbarCollapse" class="collapse navbar-collapse navbar-right">
		<ul class="nav nav-pills">
			<li><a href="index.jsp">Главная</a></li>
			<li><a href="#">Статистика</a></li>
			<li class="active"><a href="controller?command=list_players">Игроки</a></li>
			<li><a href="form">Результаты матчей</a></li>
			<li><a href="contacts.html">Контакты</a></li>
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
				
					<table class="table">
						<tr>
							<td>№</td>
							<td>Фамилия</td>
							<td>Имя</td>
							<td>Красные карточки</td>
							<td>Желтые карточки</td>
							<td></td>
							<td>Голов забито</td>
							<td>Посещение тренеровок</td>
							<td>Посещение игор</td>
							<td>Фото</td>
						</tr>

					

					</table>
	<p>${player}</p>
				</div>
				<%@ include file="/WEB-INF/views/jspf/leftblock.jspf"%>
			</div>

		</div>
	</div>
	<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>