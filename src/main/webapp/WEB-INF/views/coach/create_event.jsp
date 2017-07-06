<%@ page import="net.proselyte.springsecurityapp.enums.EventType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 04.06.2017
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html>
<head>

  <title>Тренер| Создания события</title>
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <!-- Bootstrap Core CSS -->
  <link href="${contextPath}/resources/css/admin/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
  <!-- Custom CSS -->
  <link href="${contextPath}/resources/css/admin/css/style.css" rel='stylesheet' type='text/css' />
  <!-- Graph CSS -->
  <link href="${contextPath}/resources/css/admin/css/lines.css" rel='stylesheet' type='text/css' />
  <link href="${contextPath}/resources/css/admin/css/font-awesome.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet" >
  <!-- jQuery -->
  <script src="${contextPath}/resources/css/admin/js/jquery.min.js"></script>
  <!----webfonts--->
  <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
  <!---//webfonts--->
  <!-- Nav CSS -->
  <link href="${contextPath}/resources/css/admin/css/custom.css" rel="stylesheet">
  <!-- Metis Menu Plugin JavaScript -->
  <script src="${contextPath}/resources/css/admin/js/metisMenu.min.js"></script>
  <script src="${contextPath}/resources/css/admin/js/custom.js"></script>
  <!-- Graph JavaScript -->
  <script src="${contextPath}/resources/css/admin/js/d3.v3.js"></script>
  <script src="${contextPath}/resources/css/admin/js/rickshaw.js"></script>
</head>
<body>
<div id="wrapper">
  <!-- Navigation -->
  <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <img src="${contextPath}/resources/images/cik.png">
      <a class="navbar-brand" href="index.html">Modern</a>

    </div>

    <%@ include file="/WEB-INF/views/jspf/coach_header.jspf"%>


    <div id="page-wrapper">
      <div class="container">
        <div class="row">
          <c:set var="enumValues" value="<%=EventType.values()%>"/>
          <div class="tab-content">
            <H2 class="form-heading" >Добавить событие</H2>
            <div class="tab-pane active" id="horizontal-form">
              <form:form modelAttribute="newEvent" method="post" cssClass="form-horizontal">
                <div class="form-group">
                  <label for="type_event" class="col-sm-2 control-label">Тип события <i class="fa fa-asterisk req"></i></label>
                  <div class="col-sm-8">
                    <form:select cssClass="form-control1" path="type" id="type">
                    <form:option value="" id="type_event">Тип события</form:option>
                    <c:forEach items="${enumValues}" var="event">
                      <form:option value="${event}">${event}</form:option>
                    </c:forEach>
                    </form:select>
                  </div>

                </div>
                <div class="form-group">
                  <label for="type_hall" class="col-sm-2 control-label">Зал <i class="fa fa-asterisk req"></i></label>
                  <div class="col-sm-8" id="type_hall">
                    <form:select cssClass="form-control1" path="hall" id="type_hall">
                    <form:option value="">Select Hall</form:option>
                    <c:forEach items="${halls}" var="hall">
                      <form:option value="${hall.id}">${hall}</form:option>
                    </c:forEach>
                    </form:select>
                  </div>

                </div>

                <div class="form-group">
                  <label for="date" class="col-sm-2 control-label">Дата </label>
                  <div class="col-lg-8">
                    <div class='input-group' id='datetimepicker9'>
                      <form:input path="date" id="date" cssClass="form-control1"  />
                   <span class="input-group-addon">

                   <span class="glyphicon glyphicon-calendar">
                    </span>


                </span>
                    </div>
                  </div>
                </div>


                <div class="form-group col-sm-2 " style="margin-left: 20px;"> <!-- Submit Button -->
                  <button type="submit" class="btn btn-danger ">Сохранить</button>
                </div>



              </form:form>

            </div>
          </div>
        </div>
        <!-- /#page-wrapper -->
      </div>
      <!-- /#wrapper -->
      <!-- Bootstrap Core JavaScript -->
      <script src="${contextPath}/resources/css/admin/js/bootstrap.min.js"></script>
      <script src="${contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
      <script>
        $('#date').datetimepicker();
      </script>
</body>
</html>
