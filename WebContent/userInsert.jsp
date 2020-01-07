<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8" http-equiv="Refresh" content="1740;URL=top">
	<link href="css/common.css" rel="stylesheet">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>新規登録画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<h1 class="text-white">新規登録画面</h1>
		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a style="font-size: 20px; font-weight: bold;" class="nav-link" href="top">戻る</a>
				</li>
			</ul>
		</div>
	</div>

	<div id="insertUser">
		<div id="userInsert_attention">
			<div class="color_red" style="font-size: 110%;">※ IDは4文字以上（英字は大小で、数字も含む）にしてください。</div>
			<div class="color_red" style="font-size: 110%;">※ PASSは8文字以上16文字以下（<span style="font-weight: bold; color: red;">必ず</span>
    															英字は大小で、<br>　数字や「 $@$!%*?& 」特殊文字を含む）にしてください。</div>
		</div>

		<c:if test="${not empty errMsg}">
			<p class="error">${fn:escapeXml(errMsg)}</p>
		</c:if>

		<form action="userInsert" method="post">
			<fieldset id="insertUser_form">
				<div>
					<label class="required">ID　　：</label>
					<input type="text" name="loginId" value="${fn:escapeXml(param.loginId)}">
					<c:if test="${not empty idErrMsg}">
						<p class="error" style="margin-top: 2%;">${fn:escapeXml(idErrMsg)}</p>
					</c:if>
				</div>
				<div>
					<label class="required">名前　：</label>
					<input type="text" name="userName" value="${fn:escapeXml(param.userName)}">
					<c:if test="${not empty nameErrMsg}">
						<p class="error" style="margin-top: 2%;">${fn:escapeXml(nameErrMsg)}</p>
					</c:if>
				</div>
				<div>
					<label class="required">年代　：</label>
					<select name="ageId">
						<c:forEach var="age" items="${sessionInfo.ageList}">
							<option value="${fn:escapeXml(age.ageId)}"
								<c:choose>
									<c:when test="${not empty sessionInfo.registerUser}">
										<c:if test="${sessionInfo.registerUser.ageId == age.ageId}">selected</c:if>
									</c:when>
									<c:otherwise>
										<c:if test="${age.ageId == 1}">selected</c:if>
									</c:otherwise>
								</c:choose>>
								${fn:escapeXml(age.ageStr)}
							</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label class="required">PASS　：</label>
					<input type="password" name="pass" value="${fn:escapeXml(param.pass)}">
					<c:if test="${not empty passErrMsg}">
					<p class="error" style="margin-top: 2%;">${fn:escapeXml(passErrMsg)}</p>
					</c:if>
				</div>
			</fieldset>
			<p><button class="link_2" id="confirm_button" type="submit" name="resister" value="confirm">確認</button></p>
		</form>
	</div>

</body>

</html>