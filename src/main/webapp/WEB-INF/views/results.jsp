<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	
  					<div id="navbarCollapse" class="collapse navbar-collapse navbar-right">
  						<ul class="nav nav-pills">
  							<li><a href="index.jsp" >Главная</a></li>
  							<li ><a  href="#">Статистика</a></li>
  							<li ><a href="controller?command=list_players" >Игроки</a></li>
  							<li class="active"><a href="results.jsp">Результаты матчей</a></li>
  							<li ><a href="contacts.html" >Контакты</a></li>
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
			
			<div class="panel panel-info">
				<div class="panel-heading">1 тур</div>
				<div class="panel-body">
					<table class="table">
				<tr><td>12.10.2016</td><td>mfc Ciklum</td> <td><span class="badge">2</span></td><td>:</td>  <td ><span class="badge">2</span></td>   <td>Гипрококс</td></tr>
				<tr><td>12.10.2016</td><td>Хартрон</td> <td><span class="badge">2</span></td><td>:</td>  <td ><span class="badge">1</span></td>   <td>ЭХО</td></tr>

			</table>

				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">2 тур</div>
				<div class="panel-body">
					<table class="table">
				<tr><td>12.10.2016</td><td>mfc Ciklum</td> <td><span class="badge">5</span></td><td>:</td>  <td ><span class="badge">2</span></td>   <td>Porezka.net</td></tr>
				<tr><td>12.10.2016</td><td>Гранд Фасад</td> <td><span class="badge">2</span></td><td>:</td>  <td ><span class="badge">2</span></td>   <td>Клондайк</td></tr>

			</table>

				</div>
			</div>
			</div>
			<%@ include file="/WEB-INF/jspf/leftblock.jspf"%>
		</div>

	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>