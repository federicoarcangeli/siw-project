<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Chi siamo</title>
<meta name="author" content="Alessandro e Federico">

<!-- Favicons -->
<link rel="shortcut icon" href="img/favicon.ico">

<!-- Responsive Tag -->
<meta name="viewport" content="width=device-width">

<!-- CSS Files -->

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/plugin.css">
<link rel="stylesheet" href="css/main.css">


</head>

<body>
	<f:view>
		<!-- Preloder-->
		<div class="preloder animated">
			<div class="scoket">
				<img src="img/preloader.svg" alt="" />
			</div>
		</div>

		<div class="body" data-scroll-animation="true">

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
							<a class="navbar-brand" href="./index_parallax.jsp"> <img
								src="img/nav-logo.png" alt="nav-logo">
							</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./index_parallax.jsp"><span>Home</span></a></li>
								<li><a href="./menu.jsp">Men&ugrave;</a></li>
								<h:panelGroup rendered="#{utenteCorrente.username != null}">
									<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
								</h:panelGroup>
								<li><a href="./about.jsp"><span style="color: #F9C56A;">Chi
											siamo</span></a></li>
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
				<!-- Page Header -->
				<section class="page_header fixed-bg"
					data-stellar-background-ratio="0.2">
					<div class="container">
						<div class="row">
							<div class="col-md-12 text-center">
								<h2 class="text-uppercase wow fadeInDown">Un po' di noi</h2>
								<p class="wow fadeInUp">Leggi la nostra storia, Come abbiamo
									iniziato ed il nostro team</p>
							</div>
						</div>
					</div>
				</section>

				<!-- Team -->
				<section class="team">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header wow fadeInDown">
									<h1>
										Il nostro team<small>Il duro lavoro dietro al nostro
											ristorante</small>
									</h1>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-sm-6 text-center">
								<div class="team-staff wow fadeInUp" data-wow-delay="0.2s">
									<img src="img/team/1.png" class="img-responsive center-block"
										alt="" />
									<h4>Alessandro Giannetti</h4>
									<p>Spazzino</p>
									<ul class="team-social">
										<li><a href="http://www.facebook.com"><i
												class="fa fa-facebook"></i></a></li>
										<li><a href="http://www.twitter.com"><i
												class="fa fa-twitter"></i></a></li>
										<li><a href="http://plus.google.com"><i
												class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="col-md-6 col-sm-6 text-center">
								<div class="team-staff wow fadeInUp" data-wow-delay="0.4s">
									<img src="img/team/2.png" class="img-responsive center-block"
										alt="" />
									<h4>Federico Arcangeli</h4>
									<p>Lava piatti</p>
									<ul class="team-social">
										<li><a href="http://www.facebook.com"><i
												class="fa fa-facebook"></i></a></li>
										<li><a href="http://www.twitter.com"><i
												class="fa fa-twitter"></i></a></li>
										<li><a href="http://plus.google.com"><i
												class="fa fa-google-plus"></i></a></li>
									</ul>
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
										<i class="fa fa-copyright"></i> 2015.Da Peppe.All rights
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
		<script src="js/vendor/velocity.min.js"></script>
		<script src="js/vendor/velocity.ui.min.js"></script>
		<script src="js/animation.js"></script>
	</f:view>
</body>

</html>
