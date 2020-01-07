<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">
	<link href="css/common.css" rel="stylesheet">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>ログイン画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<h1 class="text-white">ログイン画面</h1>
		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a style="font-size: 20px; font-weight: bold;" class="nav-link" href="top">戻る</a>
				</li>
			</ul>
		</div>
	</div>

	<div id="login">
		<c:if test="${not empty errMsg}">
    		<p class="error">${fn:escapeXml(errMsg)}</p>
		</c:if>
		<form action="login" method="post">
			<fieldset id="login_form">
				<div>
					<label>ID　：</label>
					<input type="text" name="loginId" value="${fn:escapeXml(param.loginId)}">
					<c:if test="${not empty idErrMsg}">
						<p class="error">${fn:escapeXml(idErrMsg)}</p>
					</c:if>
				</div>
				<label>PASS：</label>
				<input type="password" name="pass" value="${fn:escapeXml(param.pass)}">
				<c:if test="${not empty passErrMsg}">
					<p class="error">${fn:escapeXml(passErrMsg)}</p>
				</c:if>
			</fieldset>
			<p><button class="link_2" type="submit">ログイン</button></p>
		</form>
	</div>

</body>

</html>