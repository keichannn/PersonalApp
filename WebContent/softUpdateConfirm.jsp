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
	<title>ソフト情報更新確認画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<h1 class="text-white">ソフト情報更新確認画面</h1>
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


	<div id="updateSoftConfirm">
  		<p class="fontWeight" style="font-size: 120%; margin-top: 3%;">これでよろしいですか？</p>
		<form action="softUpdateConfirm" method="post">
			<fieldset id="updateSoftConfirm_form">
				<div>
					<label class="item">ソフト名：</label>
					<input type="text" name="softName" value="${fn:escapeXml(sessionInfo.updateSoft.softName)}" readonly>
				</div>
				<div>
					<label class="item">ジャンル：</label>
					<input type="text" name="genreStr" value="${fn:escapeXml(sessionInfo.updateSoft.genreStr)}" readonly>
				</div>
				<div>
					<label class="item">機種　：</label>
					<input type="text" name="modelStr" value="${fn:escapeXml(sessionInfo.updateSoft.modelStr)}" readonly>
				</div>
				<div>
					<label class="item">発売日：</label>
					<input type="text" name="releaseDate" value="${fn:escapeXml(sessionInfo.updateSoft.releaseDate)}" readonly>
				</div>
				<div>
					<label class="item">価格　：</label>
					<input type="text" name="price" value="${fn:escapeXml(sessionInfo.updateSoft.price)}" readonly>
				</div>
				<div>
					<label class="item">URL　　：</label>
					<input type="text" name="url" value="${fn:escapeXml(sessionInfo.updateSoft.url)}" readonly>
				</div>
			</fieldset>
			<p><button class="link_2" type="submit" name="resister" value="confirm">確認</button></p>
		</form>
	</div>

</body>

</html>