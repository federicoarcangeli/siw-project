<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Ristorante da Peppe</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- SEO -->
<meta name="description"
	content="Tomato is a Responsive HTML5 Template for Restaurants and food related services.">
<meta name="keywords"
	content="tomato, responsive, html5, restaurant, template, food, reservation">
<c:if test="${amministratoreCorrente.role=='amministratore'}">
	<meta http-equiv="refresh"
		content="3;URL=${pageContext.request.contextPath}/processaPannelloControllo">
</c:if>
<c:if test="${amministratoreCorrente.role=='operatore'}">
	<meta http-equiv="refresh"
		content="3;URL=${pageContext.request.contextPath}/processaSala">
</c:if>
<!-- Favicons -->
<link rel="shortcut icon" href="img/favicon.ico">

<!-- Responsive Tag -->
<meta name="viewport" content="width=device-width">

<!-- CSS Files -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/plugin.css">
<link rel="stylesheet" href="js/vendor/vegas/vegas.min.css">
<link rel="stylesheet" href="css/main.css">

</head>

<body>

	<!-- Preloder-->
	<div class="preloder animated">
		<div class="scoket">
			<img src="img/preloader.svg" alt="" />
		</div>
	</div>

	<div class="body">
		<div class="main-wrapper">
			<%-- 			<%
				if (session.getAttribute("amministratoreCorrente") == null) {
					String redirectURL = "./404.html";
					response.sendRedirect(redirectURL);

				} else {
			%> --%>
			<section class="reservation">
				<div class="container">
					<div class="row">
						<div class="animated fadeInDown">
							<div class="alert alert-success">
								<span> SUCCESS: </span> benvenuto:<strong>
									${amministratoreCorrente.username}</strong> ruolo:<strong>
									${amministratoreCorrente.role}</strong>
							</div>
						</div>
					</div>

				</div>
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<img src="img/preloader.svg" alt=""
					class="img-responsive center-block" />
			</section>
		</div>
		<%-- 			<%
				}
			%> --%>

	</div>


	<!-- Javascript -->

	<script src="js/vendor/jquery-1.11.2.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/vendor/jquery.flexslider-min.js"></script>
	<script src="js/vendor/spectragram.js"></script>
	<script src="js/vendor/owl.carousel.min.js"></script>
	<script src="js/vendor/velocity.min.js"></script>
	<script src="js/vendor/velocity.ui.min.js"></script>
	<script src="js/vendor/bootstrap-datepicker.min.js"></script>
	<script src="js/vendor/bootstrap-clockpicker.min.js"></script>
	<script src="js/vendor/jquery.magnific-popup.min.js"></script>
	<script src="js/vendor/isotope.pkgd.min.js"></script>
	<script src="js/vendor/slick.min.js"></script>
	<script src="js/vendor/wow.min.js"></script>
	<script src="js/animation.js"></script>
	<script src="js/vendor/vegas/vegas.min.js"></script>
	<script src="js/vendor/jquery.mb.YTPlayer.js"></script>
	<script src="js/vendor/jquery.stellar.js"></script>
	<script src="js/main.js"></script>
	<script src="js/vendor/mc/jquery.ketchup.all.min.js"></script>
	<script src="js/vendor/mc/main.js"></script>

</body>

</html>
