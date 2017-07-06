<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

  <title>Modern | Home</title>
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
      <a class="navbar-brand" href="index.html">MFC Ciklum</a>

    </div>

    <%@ include file="/WEB-INF/views/jspf/statist_header.jspf"%>


    <div id="page-wrapper">
      <div class="graphs">
        <div class="widget_head">Команды</div>

        <div class="row col-lg-11">
          <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
            <div class="panel-heading">
              <h2>Игроки</h2>
              <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}"><span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span></div>
            </div>
            <div class="panel-body no-padding" style="display: block;">
              <table class="table table-striped">
                <thead>

                <tr class="warning">
                  <th>#</th>
                  <th>Команда</th>
                  <th>И</th>
                  <th>В</th>
                  <th>Н <i class="fa fa-at"></i></th>
                  <th>П</th>
                  <th>ГЗ</th>
                  <th>ГП</th>
                  <th>О</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tables}" var="table" varStatus="status" >
                  <tr>
                  <td>${status.index+1}</td>  <td><a href="show_team?id=${table.team.id}&type=team">${table.team}</a></td><td>${table.game}</td><td>${table.win}</td><td>${table.lose}</td><td>${table.draw}</td><td>${table.goalScored}</td><td>${table.goalMissed}</td><td>${table.points}</td>
                  </tr>

                </c:forEach>  </tbody>
              </table>
            </div>
          </div>
        </div>

        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- Bootstrap Core JavaScript -->
<script src="${contextPath}/resources/css/admin/js/bootstrap.min.js"></script>
</body>
</html>
