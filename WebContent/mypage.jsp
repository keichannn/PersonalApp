<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8" http-equiv="Refresh" content="1740;URL=logout">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script>
		function clock() {
		var myDay = new Array("日","月","火","水","木","金","土");
		var now  = new Date();
		var year = now.getFullYear(); // 年
		var month = now.getMonth()+1; // 月
		var date = now.getDate(); // 日
		var day = now.getDay();
		var hour = now.getHours(); // 時
		var min  = now.getMinutes(); // 分
		var sec  = now.getSeconds(); // 秒

		// 数値が1桁の場合、頭に0を付けて2桁で表示する指定
		if(hour < 10) { hour = "0" + hour; }
		if(min < 10) { min = "0" + min; }
		if(sec < 10) { sec = "0" + sec; }

		var clock2 = year + ' 年 ' + month + ' 月 ' + date + ' 日 ' + ' (' + myDay[day] + ')　 '  + hour + ' 時 ' + min + ' 分 ' + sec + ' 秒';

		document . getElementById( 'clock-02' ) . innerHTML= clock2 . toLocaleString();

		// 1000ミリ秒ごとに処理を実効
		window . setTimeout( "clock()", 1000);
		}
		window . onload = clock;
	</script>

	<title>マイページ画面</title>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div id="mypage">
		<div style="position: fixed; top: 0px; width: 100%; height: 120px; z-index: 2" class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav4" aria-controls="navbarNav4" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<h1 class="text-white">管理画面</h1>
			<div class="collapse navbar-collapse justify-content-end">
				<ul class="navbar-nav">
					<li class="nav-item active">
						<a style="font-size: 20px; font-weight: bold" class="nav-link" href="logout">ログアウト</a>
					</li>
					<li class="nav-item active">
						<a style="font-size: 20px; font-weight: bold" class="nav-link" href="userDelete?selectPage=userDeletePage">退会</a>
					</li>
				</ul>
			</div>
		</div>

		<div id="clock-02"></div>
		<p><span style="color: darkcyan; font-weight:bold; font-size: 120%;">${fn:escapeXml(sessionInfo.loginUser.userName)}</span> さん、こんにちは！</p>
		<p>あなたのIDは【 <span id="user_id">${fn:escapeXml(sessionInfo.loginUser.id)}</span> 】です</p>

		<form id="googleSearch" method=get action="http://www.google.co.jp/search">
			<table style="margin: 0 auto; margin-bottom: 3%;">
				<tr>
					<td>
						<a href="http://www.google.co.jp/">
							<img src="http://www.google.com/logos/Logo_40wht.gif" border="0" alt="Google" align="absmiddle">
						</a>
			  			<input type=text name=q size=31 maxlength=255 value="">
						<input type=hidden name=ie value=UTF-8>
						<input type=hidden name=oe value=UTF-8>
						<input type=hidden name=hl value="ja">
						<input type=submit name=btnG value="Google 検索">
					</td>
				</tr>
			</table>
		</form>

		<c:if test="${not empty ageErrMsg1 and not empty ageErrMsg2}">
			<div style="margin: 3% 0;">
				<div class="error">${fn:escapeXml(ageErrMsg1)}</div>
				<div class="error">${fn:escapeXml(ageErrMsg2)}</div>
			</div>
		</c:if>

		<div style="margin-top: 5%;">
			<a class="mypage_center_button" href="mypage?selectPage=select">検索</a>
			<a class="mypage_center_button" href="mypage?selectPage=insert">登録</a>
			<a class="mypage_center_button" href="mypage?selectPage=update">更新</a>
			<a class="mypage_center_button" href="mypage?selectPage=delete">削除</a>
			<a class="mypage_center_button" href="review">口コミ</a>
		</div>
	</div>

</body>

</html>