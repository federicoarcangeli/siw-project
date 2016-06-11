<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="it">
<f:view>
	<head>
<meta charset="utf-8">

<title><h:outputText value="#{utenteCorrente.username}" /></title>


<!-- SEO -->
<meta name="description"
	content="Tomato is a Responsive HTML5 Template for Restaurants and food related services.">
<meta name="keywords"
	content="tomato, responsive, html5, restaurant, template, food, reservation">

<!-- Favicons -->
<link rel="shortcut icon" href="../img/favicon.ico">

<!-- Responsive Tag -->
<meta name="viewport" content="width=device-width">

<!-- CSS Files -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="../css/plugin.css">
<link rel="stylesheet" href="../js/vendor/vegas/vegas.min.css">
<link rel="stylesheet" href="../css/main.css">

	</head>

	<body id="intro4">

		<!-- Preloder-->
		<div class="preloder animated">
			<div class="scoket">
				<img src="../img/preloader.svg" alt="" />
			</div>
		</div>

		<div class="body">

			<div class="main-wrapper">

				<!-- Navigation-->
				<nav class="navbar navbar-fixed-top">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="./home_Operatore.jsp"> <img
								src="../img/nav-logo.png" alt="nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./home_Administrator.jsp">Pannello di
										controllo</a></li>
								<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
								<li><a href="../sala.jsp">Sala</a></li>
								<li class="dropdown"><a href="./home_Administrator.jsp"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">Benvenuto <h:outputText
											value="#{utenteCorrente.username}"></h:outputText> <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><h:form>
												<h:commandButton action="#{utenteController.logout}"
													styleClass="btn btn-default btn-xs btn-block"
													value="Logout" />
											</h:form></li>
									</ul></li>
							</ul>
						</div>

						<!--/.navbar-collapse -->
					</div>
				</nav>

				<!-- Page Header -->
				<section class='page_header vertical-padding'></section>

				<!-- Shop Content -->
				<div class="shop-content">
					<div class="container-fluid">
						<div class="row"></div>


					</div>

				</div>
			</div>
		</div>

		<!-- Javascript -->

		<script src="../js/vendor/jquery-1.11.2.min.js"></script>
		<script src="../js/vendor/bootstrap.min.js"></script>
		<script src="../js/vendor/jquery.flexslider-min.js"></script>
		<script src="../js/vendor/spectragram.js"></script>
		<script src="../js/vendor/owl.carousel.min.js"></script>
		<script src="../js/vendor/velocity.min.js"></script>
		<script src="../js/vendor/velocity.ui.min.js"></script>
		<script src="../js/vendor/bootstrap-datepicker.min.js"></script>
		<script src="../js/vendor/bootstrap-clockpicker.min.js"></script>
		<script src="../js/vendor/jquery.magnific-popup.min.js"></script>
		<script src="../js/vendor/isotope.pkgd.min.js"></script>
		<script src="../js/vendor/slick.min.js"></script>
		<script src="../js/vendor/wow.min.js"></script>
		<script src="../js/animation.js"></script>
		<script src="../js/vendor/vegas/vegas.min.js"></script>
		<script src="../js/vendor/jquery.mb.YTPlayer.js"></script>
		<script src="../js/vendor/jquery.stellar.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/vendor/mc/jquery.ketchup.all.min.js"></script>
		<script src="js/vendor/mc/main.js"></script>
	</body>
</f:view>
</html>
