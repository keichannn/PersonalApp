<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<title>トップページ</title>

	<script>
		$(document).ready(function () {
		    $('.slider').bxSlider({
		        auto: true, pause: '3000'
		    });
		});
	</script>

</head>

<body style="background-image: url(pictures/top.PNG); background-size:cover">

	<div id="topPage">
		<h1 class="color_and_fontWeight" id="index_title">ゲームソフト情報管理システム</h1>
		<div id="index_attention">
			このシステムは、お気に入りのゲームソフトや、<br>今後購入する予定のソフトなどの情報を管理できるシステムです。
			<br>また、口コミなどのチャット機能があり、様々なゲームソフト情報を共有できます。
		</div>

		<div id="slideshow">
			<ul class="slider">
				<li>
					<a href="https://www.google.com/search?ei=Da5TXajQDce4mAWUza7oAw&q=%E3%83%95%E3%82%A1%E3%82%A4%E3%83%8A%E3%83%AB%E3%83%95%E3%82%A1%E3%83%B3%E3%82%BF%E3%82%B8%E3%83%BCX&oq=%E3%83%95%E3%82%A1%E3%82%A4%E3%83%8A%E3%83%AB%E3%83%95%E3%82%A1%E3%83%B3%E3%82%BF%E3%82%B8%E3%83%BCX&gs_l=psy-ab.3..35i39l2j0i131i4j0i4l5.3280.3280..9030...0.0..0.136.136.0j1......0....1..gws-wiz.......0i71.mPo5onb0zZ8&ved=0ahUKEwjoisXU4YHkAhVHHKYKHZSmCz0Q4dUDCAo&uact=5" target="_blank">
						<img src="pictures/ff10.jpg" height="220" width="300"/>
					</a>
				</li>
				<li>
					<a href="https://www.google.com/search?q=SIREN&source=lnms&sa=X&ved=0ahUKEwjOkerq3IHkAhUHfXAKHc2vBP8Q_AUIDCgA&biw=1366&bih=657&dpr=1" target="_blank">
						<img src="pictures/siren.PNG" height="220" width="300" />
					</a>
				</li>
				<li>
					<a href="https://www.google.com/search?biw=1366&bih=657&ei=iqpTXbn-LJyWr7wP64uqyAY&q=%E3%82%BC%E3%83%AB%E3%83%80%E3%81%AE%E4%BC%9D%E8%AA%AC%E3%83%96%E3%83%AC%E3%82%B9%E3%82%AA%E3%83%96%E3%82%B6%E3%83%AF%E3%82%A4%E3%83%AB%E3%83%89&oq=%E3%82%BC%E3%83%AB%E3%83%80%E3%81%AE&gs_l=psy-ab.1.1.0i67j0i131i4j0i4l2j0i131l2j0i4l2.11786.25699..28307...6.0..3.150.2322.0j19......0....1..gws-wiz.....10..0i71j35i39j0i4i10.S6JMZgHoukM" target="_blank">
						<img src="pictures/zeldaOfbless.PNG" height="220" width="300" />
					</a>
				</li>
			</ul>
		</div>

		<div id="div_margin_top">
			<a id="start_button" href="top">始める</a>
		</div>
	</div>

</body>

</html>