<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8" http-equiv="Refresh" content="1740;URL=logout">
	<title>ソフト情報削除確認画面</title>
	<link href="css/common.css" rel="stylesheet">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<h1 class="text-white">ソフト情報削除確認画面</h1>
		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a style="font-size: 20px; font-weight: bold" class="nav-link" href="logout">ログアウト</a>
				</li>
				<li class="nav-item active">
					<a style="font-size: 20px; font-weight: bold" class="nav-link" href="userDelete?selectPage=userDeletePage">退会</a>
			    </li>
			    <li class="nav-item active">
					<a style="font-size: 20px; font-weight: bold; cursor: pointer;" class="nav-link" href="mypage.jsp">マイページ</a>
			    </li>
			    <li class="nav-item active">
					<a style="font-size: 20px; font-weight: bold; cursor: pointer;" class="nav-link" onclick="history.back(); return false;" >戻る</a>
				</li>
			</ul>
		</div>
	</div>


	<div id="deleteSoftConfirm">
		<p class="fontWeight" style="font-size: 120%;">これでよろしいですか？</p>
		<form action="softDeleteConfirm" method="post">
			<fieldset id="deleteSoftConfirm_form">
				<div>
					<label class="item">ソフト名：</label>
					<input type="text" name="userName" value="${fn:escapeXml(deleteSoft.softName)}" readonly>
				</div>
				<div>
					<label class="item">ジャンル：</label>
					<input type="text" name="genre" value="${fn:escapeXml(deleteSoft.genreStr)}" readonly>
				</div>
				<div>
					<label class="item">機種　：</label>
					<input type="text" name="model" value="${fn:escapeXml(deleteSoft.modelStr)}" readonly>
				</div>
				<input type="hidden" name="Id" value="${fn:escapeXml(deleteSoft.id)}" />
				<div>
					<label class="item">発売日：</label>
					<input type="text" name="releaseDate" value="${fn:escapeXml(deleteSoft.releaseDate)}" readonly>
				</div>
				<div>
					<label class="item">価格　：</label>
					<input type="text" name="price" value="${fn:escapeXml(deleteSoft.price)}" readonly>
				</div>
			</fieldset>
			<p><button class="link_2" type="submit">削除</button></p>
		</form>
	</div>

</body>

</html>