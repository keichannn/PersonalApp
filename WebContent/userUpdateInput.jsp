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
	<title>ユーザ情報更新画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div id="updateUserInput">
		<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<h1 class="text-white">ユーザ情報更新画面</h1>
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

		<div id="updateUserInput">
			<div id="userInsert_attention">
				<div class="color_red" style="font-size: 110%;">※ IDは4文字以上（英字は大小で、数字も含む）にしてください。</div>
				<div class="color_red" style="font-size: 110%;">※ PASSは8文字以上16文字以下（<span style="font-weight: bold; color: red;">必ず</span>
																	英字は大小で、<br>　数字や「 $@$!%*?& 」特殊文字を含む）にしてください。</div>
			</div>

			<c:if test="${not empty errMsg}">
				<p class="error" style="font-size: 120%; position: relative; top: 40px;">${fn:escapeXml(errMsg)}</p>
			</c:if>

			<form action="userUpdateInput" method="post">
				<fieldset id="updateUserInput_form">
					<div>
						<label class="item">ID　：</label>
						<input type="text" name="loginId" value="${fn:escapeXml(sessionInfo.updateUser.loginId)}" style="width: 20%;">
						<c:if test="${not empty loginIdErrMsg}">
							<p class="error" style="margin-top:1%;">${fn:escapeXml(loginIdErrMsg)}</p>
						</c:if>
					</div>
					<div>
						<label class="item">名前：</label>
						<input type="text" name="userName" value="${fn:escapeXml(sessionInfo.updateUser.userName)}" style="width: 50%;">
						<c:if test="${not empty userNameErrMsg}">
							<p class="error" style="margin-top:1%;">${fn:escapeXml(userNameErrMsg)}</p>
						</c:if>
					</div>
					<div>
						<label class="item">年代：</label>
						<select name="age">
							<c:forEach var="age" items="${sessionInfo.ageList}">
								<option value="${fn:escapeXml(age.ageId)}"
									<c:if test="${sessionInfo.updateUser.ageId == age.ageId}">selected</c:if>>
									${fn:escapeXml(age.ageStr)}
								</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label class="item">PASS：</label>
						<input type="password" name="pass" value="${fn:escapeXml(sessionInfo.updateUser.pass)}" style="width: 25%;">
						<c:if test="${not empty passErrMsg}">
							<p class="error" style="margin-top:1%;">${fn:escapeXml(passErrMsg)}</p>
						</c:if>
					</div>
				</fieldset>
				<p><button class="link_2" type="submit" name="resister" value="confirm">確認</button></p>
			</form>
		</div>
	</div>

</body>

</html>