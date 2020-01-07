<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>選択画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<h1 class="text-white">選択画面</h1>
		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a style="font-size: 20px; font-weight: bold; cursor: pointer;" class="nav-link" href="index.jsp" >TOP</a>
				</li>
			</ul>
		</div>
	</div>

	<c:if test="${not empty ageErrMsg1 and not empty ageErrMsg2 and not empty ageErrMsg3 and not empty ageErrMsg4}">
		<div style="width: 30%; text-align:left; margin-left: 40%; margin-top: 10%;">
			<div class="error">${fn:escapeXml(ageErrMsg1)}</div>
			<div class="error">${fn:escapeXml(ageErrMsg2)}</div>
			<div class="error">${fn:escapeXml(ageErrMsg3)}</div>
			<div class="error">${fn:escapeXml(ageErrMsg4)}</div>
		</div>
	</c:if>

	<div id="top-page">
		<a id="login_button" href="login">ログイン</a>
		<a id="userInsert_button" href="userInsert">新規登録</a>
	</div>

</body>

</html>