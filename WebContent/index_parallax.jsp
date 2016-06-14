<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Ristorante Da Peppe</title>
<meta name="author" content="Alessandro e Federico">

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

<body id="intro4" data-scroll-animation="true">
	<f:view>
		<!-- Preloder-->
		<div class="preloder animated">
			<div class="scoket">
				<img src="img/preloader.svg" alt="" />
			</div>
		</div>

		<div class="body">

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
						<a class="navbar-brand" href="./index_parallax.jsp"> <img
							src="img/nav-logo.png" alt="nav-logo">
						</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="./index_parallax.jsp"><span
									style="color: #F9C56A;">Home</span></a></li>
							<li><a href="./menu.jsp">Men&ugrave;</a></li>
							<h:panelGroup rendered="#{utenteCorrente.username != null}">
								<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
							</h:panelGroup>
							<li><a href="./about.jsp">Chi siamo</a></li>
							<li><a href="./contact.jsp">Contatti</a></li>
							<h:panelGroup rendered="#{utenteCorrente.username == null}">
								<li><a href="./loginSignup.jsp">Login / Signup</a></li>
							</h:panelGroup>
							<h:panelGroup rendered="#{utenteCorrente.username != null}">
								<li class="dropdown"><a href="./index_parallax.jsp"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">Benvenuto <h:outputText
											value="#{utenteCorrente.username}"></h:outputText> <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li class="text-center"><a href="./profilo.jsp">Profilo</a></li>
										<li><h:form>
												<h:commandButton action="#{utenteController.logout}"
													styleClass="btn btn-default btn-xs btn-block"
													value="Logout" />
											</h:form></li>
									</ul></li>
							</h:panelGroup>
						</ul>
					</div>
					<!--/.navbar-collapse -->
				</div>
			</nav>

			<!-- Home page-->
			<section class="home" data-stellar-background-ratio="0.2">
				<div class="tittle-block">
					<div class="logo">
						<a href="./index.html"> <img src="img/logo.png" alt="logo">
						</a>
					</div>
					<h1>Ristorante Da peppe</h1>
					<h2>La qualit&aacute; &egrave; di casa</h2>
				</div>
				<div class="scroll-down">
					<a href="#about"> <img src="img/arrow-down.png"
						alt="down-arrow">
					</a>
				</div>
			</section>

			<div class="main-wrapper">
				<!-- About page-->
				<section class="about" id="about">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header wow fadeInDown">
									<h1>
										Il nostro ristorante<small>Un po 'di noi e una breve
											storia di come abbiamo iniziato.</small>
									</h1>
								</div>
							</div>
						</div>
						<div class="row wow fadeInUp">
							<div class="col-md-4">
								<div class="container-fluid">
									<div class="row">
										<div class="col-xs-12 hidden-sm about-photo">
											<div class="image-thumb">
												<img src="img/thumb1.png"
													data-mfp-src="img/fullImages/pic1.jpg"
													class="img-responsive" alt="logo">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-6 about-photo hidden-xs">
											<img src="img/thumb2.png"
												data-mfp-src="img/fullImages/pic2.jpg"
												class="img-responsive" alt="logo">
										</div>
										<div class="col-sm-6 about-photo hidden-xs">
											<img src="img/thumb3.png"
												data-mfp-src="img/fullImages/pic3.jpg"
												class="img-responsive" alt="logo">
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-8">
								<p>In attività dal 2016</p>
								<br>
								<img src="img/signature.png" alt="signature">
							</div>
						</div>
					</div>
				</section>

				<!-- Trusted BY-->
				<section class="trusted">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header wow fadeInDown">
									<h1>
										Riconoscimenti <small>Certificazioni di eccellenza del
											nostro ristorante</small>
									</h1>
								</div>
							</div>
						</div>
						<div class="row wow fadeInUp">
							<div class="col-md-12">
								<div class="trusted-sponsors">
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/foodsquare.png" alt="sponsors">
										</a>
									</div>
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/opentable.png" alt="sponsors">
										</a>
									</div>
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/tripadvisor.png" alt="sponsors">
										</a>
									</div>
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/zomato.png" alt="sponsors">
										</a>
									</div>
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/foodsquare.png" alt="sponsors">
										</a>
									</div>
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/opentable.png" alt="sponsors">
										</a>
									</div>
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/tripadvisor.png" alt="sponsors">
										</a>
									</div>
									<div class="item">
										<a href="./index_parallax.jsp"> <img
											src="img/sponsor/zomato.png" alt="sponsors">
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<!-- Footer-->
				<section class="footer fixed-bg" data-stellar-background-ratio="0.2">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-12">
								<h1>Chi siamo</h1>
								<p>Due studenti di Roma Tre</p>
								<a href="./about.jsp">Leggi ancora &rarr;</a>
							</div>
							<div class="col-md-4  col-sm-6"></div>

							<div class="col-md-4  col-sm-6">
								<h1>Contattaci</h1>
								<div class="footer-social-icons">
									<a href="http://www.facebook.com"> <i
										class="fa fa-facebook-square"></i>
									</a> <a href="http://www.twitter.com"> <i class="fa fa-twitter"></i>
									</a> <a href="http://plus.google.com"> <i class="fa fa-google"></i>
									</a> <a href="http://www.youtube.com"> <i
										class="fa fa-youtube-play"></i>
									</a> <a href="http://www.vimeo.com"> <i class="fa fa-vimeo"></i>
									</a> <a href="http://www.pinterest.com"> <i
										class="fa fa-pinterest-p"></i>
									</a> <a href="http://www.linkedin.com"> <i
										class="fa fa-linkedin"></i>
									</a>
								</div>
								<div class="footer-address">
									<p>
										<i class="fa fa-map-marker"></i>Via della vasca navale 70,
										00146
									</p>
									<p>
										<i class="fa fa-phone"></i>Telefono: +39 123456789
									</p>
									<p>
										<i class="fa fa-envelope-o"></i>dapepperestaurant@gmail.com
									</p>
								</div>
							</div>
						</div>
					</div>

					<!-- Footer - Copyright -->
					<div class="footer-copyrights">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<p>
										<i class="fa fa-copyright"></i> 2016.Da Peppe. All rights
										reserved. Designed with <i class="fa fa-heart primary-color"></i>
										by Federico &amp; Alessandro
									</p>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>

		<!-- Javascript -->
		<script src="js/vendor/jquery-1.11.2.min.js"></script>
		<script src="js/vendor/bootstrap.min.js"></script>
		<script src="js/vendor/owl.carousel.min.js"></script>
		<script src="js/vendor/wow.min.js"></script>
		<script src="js/vendor/velocity.min.js"></script>
		<script src="js/vendor/velocity.ui.min.js"></script>
		<script src="js/vendor/isotope.pkgd.min.js"></script>
		<script src="js/vendor/slick.min.js"></script>
		<script src="js/animation.js"></script>
		<script src="js/main.js"></script>
		<script src="js/vendor/mc/main.js"></script>
	</f:view>
</body>

</html>
