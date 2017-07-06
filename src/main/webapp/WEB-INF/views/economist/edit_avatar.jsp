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

  <title>Тренер| Редактирование аватара</title>
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
  <link href="${contextPath}/resources/css/datepicker.css" rel="stylesheet" >
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

    <%@ include file="/WEB-INF/views/jspf/economist_header.jspf"%>


    <div id="page-wrapper">
      <div class="container">
        <div class="row">

          <div class="tab-content">
            <H2 class="form-heading" >Редактировать пользователя</H2>
            <div class="tab-pane active" id="horizontal-form">
              <div class="col-sm-6">
                <p>Старое фото</p>
                <img src="ImageShow?type=user&id=${User.id}" style="width: 150px; height: 200px;">
              </div>
              <div class="col-sm-6">
                <p>Новое фото</p>
                <img id="image" style="width: 150px; height:200px;">
              </div>
<div class="col-sm-12">
              <form:form modelAttribute="editUser" method="post" cssClass="form-horizontal" enctype="multipart/form-data">

        <input type="file" id="files" name="file">

                <div class="form-group col-sm-2 " style="margin-left: 20px;"> <!-- Submit Button -->
                  <button type="submit" class="btn btn-danger ">Сохранить</button>
              </form:form>
</div>
            </div>
          </div>
        </div>
        <!-- /#page-wrapper -->
      </div>
      <!-- /#wrapper -->
      <!-- Bootstrap Core JavaScript -->
      <script src="${contextPath}/resources/css/admin/js/bootstrap.min.js"></script>
      <script>
        document.getElementById("files").onchange = function () {
          var reader = new FileReader();

          reader.onload = function (e) {
            // get loaded data and render thumbnail.
            document.getElementById("image").src = e.target.result;
          };

          // read the image file as a data URL.
          reader.readAsDataURL(this.files[0]);
        };
      </script>
</body>
</html>
