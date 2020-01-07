<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<title>ソフト情報登録画面</title>
	<meta charset="UTF-8" http-equiv="Refresh" content="1740;URL=logout">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div id="insertSoft">
		<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<h1 class="text-white">ソフト情報登録画面</h1>
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

		<div id="softInsert_attention">
			<div style="font-size: 110%; color: red;">※ 価格は数字のみで入力してください<br>　(もし分からなければ「未定」「URL参照」と入力すること)。</div>
			<div style="font-size: 110%; color: red;">※ URLは「http://～」または「https://～」で入力してください。</div>
		</div>

		<form action="softInsert" method="post" >
			<fieldset id="insertSoft_form">
				<div>
					<label class="item" class="required">ソフト名：</label>
					<input type="text" name="softName" value="${fn:escapeXml(param.softName)}">
					<c:if test="${not empty nameErrMsg or not empty errMsg}">
						<p class="error" style="margin-top:1%;">${fn:escapeXml(nameErrMsg)}</p>
						<p class="error">${fn:escapeXml(errMsg)}</p>
					</c:if>
				</div>
				<div>
					<label class="item" class="required">ジャンル：</label>
					<select name="genreId">
						<c:forEach var="genre" items="${sessionInfo.genreList}">
							<option value="${fn:escapeXml(genre.genreId)}"
								<c:choose>
									<c:when test="${not empty sessionInfo.registerSoft}">
										<c:if test="${sessionInfo.registerSoft.genreId == genre.genreId}">selected</c:if>
									</c:when>
									<c:otherwise>
										<c:if test="${genre.genreId == 1}">selected</c:if>
									</c:otherwise>
								</c:choose>>
								${fn:escapeXml(genre.genreStr)}
							</option>
              			</c:forEach>
					</select>
				</div>
				<div>
					<label class="item" class="required">機種　　：</label>
					<select name="modelId">
						<c:forEach var="model" items="${sessionInfo.modelList}">
							<option value="${fn:escapeXml(model.modelId)}"
								<c:choose>
								<c:when test="${not empty sessionInfo.registerSoft}">
									<c:if test="${sessionInfo.registerSoft.modelId == model.modelId}">selected</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${model.modelId == 1}">selected</c:if>
								</c:otherwise>
								</c:choose>>
								${fn:escapeXml(model.modelStr)}
							</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label class="item" class="required">発売日　：</label>
					<input type="date" name="releaseDate" value="${fn:escapeXml(param.releaseDate)}">
					<c:if test="${not empty releaseErrMsg}">
						<p class="error" style="margin-top:1%;">${fn:escapeXml(releaseErrMsg)}</p>
					</c:if>
				</div>
				<div>
					<label class="item" class="required">価格　　：</label>
					<input type="text" name="price" value="${fn:escapeXml(param.price)}" style="width: 20%; text-align: right;">
					<c:if test="${not empty priceErrMsg}">
						<p class="error" style="margin-top:1%;">${fn:escapeXml(priceErrMsg)}</p>
					</c:if>
				</div>
				<div>
					<label class="item" class="required">URL　　：</label>
					<input type="text" name="url" value="${fn:escapeXml(param.url)}">
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