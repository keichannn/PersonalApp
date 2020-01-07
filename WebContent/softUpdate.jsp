<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8" http-equiv="Refresh" content="1740;URL=logout">
	<link href="css/common.css" rel="stylesheet">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>ソフト情報更新画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div id="updateSoft">
		<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<h1 class="text-white">ソフト情報更新画面</h1>
			<div class="collapse navbar-collapse justify-content-end">
				<ul class="navbar-nav">
					<li class="nav-item active">
						<a style="font-size: 20px; font-weight: bold" class="nav-link" href="logout">ログアウト</a>
					</li>
					<li class="nav-item active">
						<a style="font-size: 20px; font-weight: bold" class="nav-link" href="userDelete?selectPage=userDeletePage">退会</a>
					</li>
				    <li class="nav-item active">
						<a style="font-size: 20px; font-weight: bold; cursor: pointer;" class="nav-link" href="mypage.jsp" >マイページ</a>
					</li>
				    <li class="nav-item active">
						<a style="font-size: 20px; font-weight: bold; cursor: pointer;" class="nav-link" onclick="history.back(); return false;" >戻る</a>
					</li>
				</ul>
			</div>
		</div>
		<form action="softUpdate" method="post">
			<fieldset id="updateSoft_form">
				<div>
					<label class="item">ソフト名：</label>
					<input type="text" name="softName" value="${fn:escapeXml(param.softName)}">
					<c:if test="${not empty softNameErrMsg or not empty errMsg or (not empty errMsg1 and not empty errMsg2 and not empty errMsg3)}">
						<p class="error" style="margin-top:10px;">${fn:escapeXml(softNameErrMsg)}</p>
						<p class="error">${fn:escapeXml(errMsg)}</p>
						<div class="error">${fn:escapeXml(ageErrMsg1)}</div>
						<div class="error">${fn:escapeXml(ageErrMsg2)}</div>
						<div class="error">${fn:escapeXml(ageErrMsg3)}</div>
					</c:if>
				</div>
			</fieldset>
			<p><button class="link_2" type="submit">確認</button></p>
		</form>
		<p>忘れた場合は<a class="link_3" href="mypage?selectPage=select">こちら</a>へ</p>
	</div>
</body>
</html>