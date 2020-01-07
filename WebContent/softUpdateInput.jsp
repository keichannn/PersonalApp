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

	<div id="updateSoftInput">
		<div id="softInsert_attention">
			<div style="font-size: 110%; color: red;">※ 価格は数字のみで入力してください<br>　(もし分からなければ「未定」「URL参照」と入力すること)。</div>
			<div style="font-size: 110%; color: red;">※ 発売日は「-」で区切るようにしてください。</div>
			<div style="font-size: 110%; color: red;">※ URLは「http://～」「https://～」で入力してください。</div>
		</div>

		<c:if test="${not empty errMsg}">
			<p class="error" style="font-size: 120%; ">${fn:escapeXml(errMsg)}</p>
		</c:if>

		<form action="softUpdateInput" method="post">
			<fieldset id="updateSoftInput_form">
				<div>
					<label class="item">ソフト名：</label>
					<input type="text" name="softName" value="${fn:escapeXml(sessionInfo.updateSoft.softName)}">
					<c:if test="${not empty nameErrMsg}">
						<p class="error" style="margin-top:1%;">${fn:escapeXml(nameErrMsg)}</p>
					</c:if>
				</div>
				<div>
					<label class="item">ジャンル：</label>
					<select name="genreId">
						<c:forEach var="genre" items="${sessionInfo.genreList}">
							<option value="${fn:escapeXml(genre.genreId)}"
								<c:if test="${sessionInfo.updateSoft.genreId == genre.genreId}">selected</c:if>>
								${fn:escapeXml(genre.genreStr)}
							</option>
						</c:forEach>
		  			</select>
				</div>
				<div>
					<label class="item">機種　　：</label>
					<select name="modelId">
						<c:forEach var="model" items="${sessionInfo.modelList}">
							<option value="${fn:escapeXml(model.modelId)}"
								<c:if test="${sessionInfo.updateSoft.modelId == model.modelId}">selected</c:if>>
								${fn:escapeXml(model.modelStr)}
							</option>
						</c:forEach>
		 			 </select>
				</div>
				<div>
					<label class="item">発売日　：</label>
					<input type="text" name="releaseDate" value="${fn:escapeXml(sessionInfo.updateSoft.releaseDate)}" style="width: 35%;">
					<c:if test="${not empty releaseErrMsg}">
						<p class="error" style="margin-top:1%;">${fn:escapeXml(releaseErrMsg)}</p>
					</c:if>
				</div>
				<div>
			 		<label class="item">価格　　：</label>
					<input type="text" name="price" value="${fn:escapeXml(sessionInfo.updateSoft.price)}" style="width: 25%; text-align: right;">
					<c:if test="${not empty priceErrMsg}">
						<p class="error" style="margin-top:1%;">${fn:escapeXml(priceErrMsg)}</p>
					</c:if>
				</div>
				<div>
					<label class="item">URL　　：</label>
					<input type="text" name="url" value="${fn:escapeXml(sessionInfo.updateSoft.url)}">
					<c:if test="${not empty urlErrMsg1 or not empty urlErrMsg2}">
						<p class="error" style="margin-top:1%;">${fn:escapeXml(urlErrMsg1)}</p>
						<p class="error">${fn:escapeXml(urlErrMsg2)}</p>
					</c:if>
				</div>
			</fieldset>
		    <p><button class="link_2" type="submit" name="resister" value="confirm">確認</button></p>
		</form>
	</div>

</body>

</html>