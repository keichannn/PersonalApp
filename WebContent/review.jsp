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
	<title>口コミ画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<h1 class="text-white">口コミ画面</h1>
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

	<p class="fontWeight" style="margin-top: 12%; text-align:center;">♪ ソフト情報を共有しよう!(^^)! ♪</p>

	<form  action="review" method="post">
		<fieldset id="review_form">
			<div>
				<label class="item">ソフト名：</label>
				<input type="text" name="softName" list="softName" placeholder="入力またはメニューから選択" autocomplete="off" style="width: 70%;">
				<datalist id="softName">
					<c:forEach var="soft" items="${softList}">
						<option value="${fn:escapeXml(soft.softName)}">
					</c:forEach>
				</datalist>
				<c:if test="${not empty nameErrMsg}"><br>
					<p class="error">${fn:escapeXml(nameErrMsg)}</p>
				</c:if>
			</div>

			<div>
				<label class="item">機種　　：</label>
				<select name="modelId">
					<c:forEach var="model" items="${sessionInfo.modelList}">
						<option value="${fn:escapeXml(model.modelId)}"
							<c:if test="${model.modelId == 1}">selected</c:if>>${fn:escapeXml(model.modelStr)}
						</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label class="item">コメント： </label>
				<input type="text" name="contents">
				<c:if test="${not empty contentsErrMsg}">
					<p class="error">${fn:escapeXml(contentsErrMsg)}</p>
				</c:if>
			</div>
			<button class="link_2" id="post_button" style ="float:left; margin-right: 3%;" type="submit">投稿</button>
		</fieldset>
	</form>

	<div id="review">
		<div>
			<c:forEach var="review" items="${reviewList}">
				<form action="reviewDelete" method="post">
					<div style="margin-bottom: 2%;">
						<div>No.${fn:escapeXml(review.reviewId)} テーマ【${fn:escapeXml(review.softStr)} / ${fn:escapeXml(review.modelStr)}】${fn:escapeXml(review.dateTime)}</div>
						<div>
							<span id="userName_review">${fn:escapeXml(review.userName)}【${fn:escapeXml(ageStrForReview)}】：</span>
							<span>${fn:escapeXml(review.contents)}　</span>
  							<input type="hidden" name="deleteReview" value="${fn:escapeXml(review.contents)}">
  							<button class="link_2">削除</button>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>

</body>

</html>