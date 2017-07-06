<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="/WEB-INF/views/jspf/head.jspf"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">


<script type="text/javascript" src="${contextPath}/resources/js/bootstrap.js"></script>
<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>

<body>
	<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
	
  					<div id="navbarCollapse" class="collapse navbar-collapse navbar-right">
  						<ul class="nav nav-pills">
  							<li class="active"><a href="controller?command=list_players" >Главная</a></li>
  							<li ><a  href="#"  >Статистика <i class="fa fa-user"></i></a></li>
  							<li ><a href="/players" >Игроки</a></li>
  							<li ><a href="results.jsp"  >Результаты матчей</a></li>
  							<li ><a href="contacts.html">Контакты</a></li>
  						</ul>
  					</div>
  					
  				</div>
  			</nav>
  		</div>
  	</div>
	<div class="container">
		<div id="carousel" class="carousel slide">
			<!-- Индикаторы слайдов -->
			<ol class="carousel-indicators">
				<li class="active" data-target="#carousel" data-slide="0"></li>
				<li data-target="#carousel" data-slide-to="1"></li>
				<li data-target="#carousel" data-slide-to="2"></li>
			</ol>
			<!-- Слайды -->
			<div class="carousel-inner">
				<div class="item active">
					<img alt="icon" src="resources/images/team1.jpg">
					<div class="carousel-caption">
						<h3>первый слайд</h3>
						<p>Празднование 2-го места на Кубке Харькова</p>
					</div>
				</div>
				<div class="item ">
					<img alt="icon" src="resources/images/team2.jpg">
					<div class="carousel-caption">
						<h3>Второй слайд</h3>
						<p>Празднование 2-го места на Кубке Харькова</p>
					</div>
				</div>
				<div class="item ">
					<img alt="icon" src="resources/images/team3.jpg">
					<div class="carousel-caption">
						<h3>Третий слайд</h3>
						<p>Новая форма! Благодарим нашему спонсору!</p>
					</div>
				</div>
			</div>
			<!-- Стрелки переключения слайдов -->
			<a href="#carousel" class="left carousel-control" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a> <a href="#carousel" class=" right carousel-control"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>


	</div>
	
	<div class="wrapper">
	<div class ="container">
	
	<div class="row">
	<div class="col-lg-12">
	</div>
	</div>
	</div>
	</class>
	
	<div class="wrapper">

		<div class="container">
			<div class="row">
				<div class="col-lg-9 col-lg-push-3">
					<h2>Последний матч</h2>
					<hr>
					<div class="row">
						<div class="movie_block col-lg-3">
							<iframe width="100%" height="100%"
								src="http://www.youtube.com/embed/yk6jRlyoi-I" frameborder="0"
								allowfullscreen></iframe>
							<div class="movie_label">Ciklum-Sytos</div>
						</div>
					</div>

					<a href="test">Test</a>
					<h2>Все матчи</h2>
					<hr>
					<div class="row">
						<div class="movie_block col-lg-3">
							<iframe width="100%" height="100%"
								src="http://www.youtube.com/embed/yk6jRlyoi-I" frameborder="0"
								allowfullscreen></iframe>
							<div class="movie_label">Ciklum-Sytos</div>
						</div>
						<div class="movie_block col-lg-3">
							<iframe width="100%" height="100%"
								src="http://www.youtube.com/embed/yk6jRlyoi-I" frameborder="0"
								allowfullscreen></iframe>
							<div class="movie_label">Ciklum-Sytos</div>
						</div>
						<div class="movie_block col-lg-3">
							<iframe width="100%" height="100%"
								src="http://www.youtube.com/embed/yk6jRlyoi-I" frameborder="0"
								allowfullscreen></iframe>
							<div class="movie_label">Ciklum-Sytos</div>
						</div>
						<div class="movie_block col-lg-3">
							<iframe width="100%" height="100%"
								src="http://www.youtube.com/embed/yk6jRlyoi-I" frameborder="0"
								allowfullscreen></iframe>
							<div class="movie_label">Ciklum-Sytos</div>
						</div>
						<div class="movie_block col-lg-3">
							<iframe width="100%" height="100%"
								src="http://www.youtube.com/embed/yk6jRlyoi-I" frameborder="0"
								allowfullscreen></iframe>
							<div class="movie_label">Ciklum-Sytos</div>
						</div>
					</div>
				</div>
<%@ include file="/WEB-INF/views/jspf/leftblock.jspf"%>
			</div>

		</div>
	</div>


	<div class="margin-8"></div>
	<div class="clear"></div>
	</div>

<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>