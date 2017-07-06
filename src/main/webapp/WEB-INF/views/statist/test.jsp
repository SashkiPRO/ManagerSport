<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">


  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>mfc Ciklum</title>

  <!-- Bootstrap -->
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/datepicker.css">
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container">
  <div class="row">

    <div class="col-md-offset-3 col-md-6">
      <form class="form-horizontal">
        <span class="heading">АВТОРИЗАЦИЯ</span>
        <div class="form-group">
          <input type="email" class="form-control" id="inputEmail" placeholder="E-mail">
          <i class="fa fa-user"></i>
        </div>
        <div class="form-group help">
          <input type="password" class="form-control" id="inputPassword" placeholder="Password">
          <i class="fa fa-lock"></i>
          <a href="#" class="fa fa-question-circle"></a>
        </div>
        <div class="form-group">
          <div class="main-checkbox">
            <input type="checkbox" value="none" id="checkbox1" name="check"/>
            <label for="checkbox1"></label>
          </div>
          <span class="text">Запомнить</span>
          <button type="submit" class="btn btn-default">ВХОД</button>
        </div>
      </form>
    </div>

    <input type="text" id="datepicker"/>

  </div><!-- /.row -->
</div><!-- /.container -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>
<script>
  $('#datepicker').datepicker();
</script>
</body>
</html>