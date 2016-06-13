<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Contatti</title>
<meta name="author" content="Surjith S M">

<!-- SEO -->
<meta name="description"
	content="Tomato is a Responsive HTML5 Template for Restaurants and food related services.">
<meta name="keywords"
	content="tomato, responsive, html5, restaurant, template, food, reservation">

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
							<a class="navbar-brand" href="./index_parallax.jsp"> <img
								src="img/nav-logo.png" alt="nav-logo">
							</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./index_parallax.jsp">Home</a></li>
								<li><a href="./menu.jsp">Men&ugrave;</a></li>
								<h:panelGroup rendered="#{utenteCorrente.username != null}">
									<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
								</h:panelGroup>
								<li><a href="./about.jsp">Chi siamo</a></li>
								<li><a href="./contact.html"><span
										style="color: #F9C56A;">Contatti</span></a></li>
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
				<section class="page_header">
					<div class="container">
						<div class="row">
							<div class="col-md-12 text-center">
								<h2 class="text-uppercase">Contatti</h2>
								<p>Come trovare il nostro ristorante e raggiungerci</p>
							</div>
						</div>
					</div>
				</section>

				<!-- Contact Form / Info -->
				<section class="main-content contact-content">
					<div class="container">
						<div class="col-md-10 col-md-offset-1">
							<div class="row">
								<div class="col-md-6">
									<h3 class="text-left no-margin-top">Indirizzo</h3>
									<div class="footer-address contact-info">
										<p>
											<i class="fa fa-map-marker"></i>Via della vasca navale 70,
											00146
										</p>
										<p>
											<i class="fa fa-phone"></i>Telefono: +39 123456789
										</p>
										<p>
											<i class="fa fa-envelope-o"></i>support@restaurant.com
										</p>
									</div>
									<br>

									<h3 class="text-left no-margin-top">Orario lavorativo</h3>
									<div class="contact-info text-muted">
										<p>10:00 - 23:00 Lun. Mar. Mer. Gio. Ven.</p>
										<p>11:00 - 23:30 Sab. Dom.</p>
									</div>
									<br>

									<h3 class="text-left no-margin-top">Seguici</h3>
									<div class="contact-social">
										<a href="http://www.facebook.com"><i
											class="fa fa-facebook"></i></a> <a href="http://www.twitter.com"><i
											class="fa fa-twitter"></i></a> <a href="http://www.dribbble.com"><i
											class="fa fa-dribbble"></i></a> <a
											href="http://www.instagram.com"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
								<div class="col-md-6">
									<form class="contact-form" id="contactForm"
										action="php/contact.php" method="post">
										<div class="form-group">
											<input class="form-control" name="name" id="name"
												placeholder="Full Name" type="text" required="required" />
										</div>
										<div class="form-group">
											<input class="form-control" type="email" name="email"
												id="email" placeholder="Email Address" required="required" />
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="Subject" type="text"
												id="subject" name="subject">
										</div>
										<div class="form-group">
											<textarea class="form-control" name="message" id="message"
												placeholder="Message" rows="5"></textarea>
										</div>
										<button class="btn btn-default btn-lg btn-block"
											id="js-contact-btn">Contattaci</button>
									</form>
									<div id="js-contact-result"
										data-success-msg="Form submitted successfully."
										data-error-msg="Oops. Something went wrong."></div>

								</div>
							</div>
						</div>
					</div>
				</section>

				<!-- Google Map -->
				<!-- Set latitude and Longitude (Get it from http://google.com/maps) -->
				<div id="map" data-latitude="41.889545" data-longitude="12.542194"></div>

				<!-- subscribe -->
				<section class="subscribe">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<h1>Newsletter</h1>
								<p>Get updates about new dishes and upcoming events</p>
								<form class="form-inline" action="php/subscribe.php" id="invite"
									method="POST">
									<div class="form-group">
										<input class="e-mail form-control" name="email" id="address"
											type="email" placeholder="Your Email Address" required>
									</div>
									<button type="submit" class="btn btn-default">
										<i class="fa fa-angle-right"></i>
									</button>
								</form>

							</div>
						</div>
					</div>
				</section>

				<!-- Footer-->
				<section class="footer">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-12">
								<h1>About us</h1>
								<p>Duis leo justo, condimentum at purus eu,Aenean sed dolor
									sem. Etiam massa libero, auctor vitae egestas et, accumsan quis
									nunc.Duis leo justo, condimentum at purus eu, posuere pretium
									tellus.</p>
								<a href="./about.html">Read more &rarr;</a>
							</div>
							<div class="col-md-4  col-sm-6">
								<h1>Recent post</h1>
								<div class="footer-blog clearfix">
									<a href="./blog_right_sidebar.html"> <img
										src="img/thumb8.png" class="img-responsive footer-photo"
										alt="blog photos">
										<p class="footer-blog-text">Hand picked ingredients for
											our best customers</p>
										<p class="footer-blog-date">29 may 2015</p>
									</a>
								</div>
								<div class="footer-blog clearfix last">
									<a href="./blog_right_sidebar.html"> <img
										src="img/thumb9.png" class="img-responsive footer-photo"
										alt="blog photos">
										<p class="footer-blog-text">Daily special foods that you
											will going to love</p>
										<p class="footer-blog-date">29 may 2015</p>
									</a>
								</div>
							</div>
							<div class="col-md-4  col-sm-6">
								<h1>Reach us</h1>
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
										<i class="fa fa-map-marker"></i>28 Seventh Avenue, Neew York,
										10014
									</p>
									<p>
										<i class="fa fa-phone"></i>Phone: (415) 124-5678
									</p>
									<p>
										<i class="fa fa-envelope-o"></i>support@restaurant.com
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
										<i class="fa fa-copyright"></i> 2015.Tomato.All rights
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
		<script src="js/vendor/mc/jquery.ketchup.all.min.js"></script>
		<script src="js/vendor/mc/main.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
		<script src="js/vendor/map.js"></script>
		<!-- Contact JS -->
		<script src="js/vendor/validate.js"></script>
		<script src="js/contact.js"></script>
		<!-- Main JS -->
		<script src="js/main.js"></script>
	</f:view>
</body>

</html>
