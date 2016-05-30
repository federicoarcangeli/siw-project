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

<body id="intro4">

	<!-- Preloder-->
	<div class="preloder animated">
		<div class="scoket">
			<img src="img/preloader.svg" alt="" />
		</div>
	</div>

	<div class="body">

		<%
			if (session.getAttribute("utenteCorrente") == null) {
				String redirectURL = "./sessioneScadutaUtente.jsp";
				response.sendRedirect(redirectURL);

			} else {
		%>

		<!-- Navigation-->
		<nav class="navbar navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="./home_Utente.jsp"> <img
						src="img/nav-logo.png" alt="nav-logo">
					</a>
				</div>

				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="./index_parallax.jsp">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/ProcessaMenu">Men&ugrave;</a></li>
						<li><a href="./galleria.jsp">Galleria</a></li>
						<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
						<li><a href="./contact.html">Contact</a></li>
						<li class="dropdown"><a href="./home_Utente.jsp"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false">Benvenuto
								${utenteCorrente.nome}<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath}/processaProfilo">Profilo</a></li>
								<li><a href="./index_parallax.jsp">Logout</a></li>

							</ul></li>
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
				<h1>Ristorante Tomato</h1>
				<h2>La qualit� � di casa</h2>
			</div>
			<div class="scroll-down">
				<a href="#about"> <img src="img/arrow-down.png" alt="down-arrow">
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
											data-mfp-src="img/fullImages/pic2.jpg" class="img-responsive"
											alt="logo">
									</div>
									<div class="col-sm-6 about-photo hidden-xs">
										<img src="img/thumb3.png"
											data-mfp-src="img/fullImages/pic3.jpg" class="img-responsive"
											alt="logo">
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-8">
							<p>Cras ut viverra eros. Phasellus sollicitudin sapien id
								luctus tempor. Sed hendrerit interdum sagittis. Donec nunc
								lacus, dapibus nec interdum eget, ultrices eget justo. Nam purus
								lacus, efficitur eget laoreet sed, finibus nec neque. Cras eget
								enim in diam dapibus sagittis. In massa est, dignissim in libero
								ac, fringilla ornare mi. Etiam interdum ligula purus, placerat
								aliquam odio faucibus a. Pellentesque et pulvinar lectus. Fusce
								scelerisque nisi id nisl gravida ultricies.</p>
							<br>
							<p>Ultrices eget justo. Nam purus lacus, efficitur eget
								laoreet sed, finibus nec neque. Cras eget enim in diam dapibus
								sagittis. In massa est, dignissim in libero ac, fringilla ornare
								mi.</p>
							<img src="img/signature.png" alt="signature">
						</div>
					</div>
				</div>
			</section>

			<!-- Today's special page-->
			<section class="special fixed-bg" data-stellar-background-ratio="0.2">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="page-header wow fadeInDown">
								<h1 class="white">
									I piatti tipici<small>i piatti che ci hanno fatto
										diventare grandi</small>
								</h1>
							</div>
						</div>
					</div>
					<div class="row wow fadeInUp">
						<div class="col-md-offset-1 col-md-10">
							<div class="flexslider special-slider">
								<ul class="slides">
									<li>
										<div class="slider-img">
											<img src="img/thumb4.png" alt="" />
										</div>
										<div class="slider-content">
											<div class="page-header">
												<h1>
													Pancake with Caramel<small>If you are a fan of
														caramel cake, then you'll love our Pancake with caramel
														icecream. It's not thick, but very tasty.</small>
												</h1>
											</div>
											<p>Ultrices In massa est, dignissim in libero ac,
												fringilla ornare mi.Ultrices eget justo. Nam purus lacus,
												efficitur eget laoreet sed, finibus nec neque. Cras eget
												enim in diam dapibus sagittis. accumsan, habitant morbi
												tristique senectus et netus et malesuada fames ac turpis
												egestas.</p>
											<a class="btn btn-default" href="./index.html" role="button">Order
												now</a> <a class="btn btn-secondary" href="./index.html"
												role="button">Add to cart</a>
										</div>
									</li>
									<li>
										<div class="slider-img">
											<img src="img/thumb4.png" alt="" />
										</div>
										<div class="slider-content">
											<div class="page-header">
												<h1>
													Pancake with Caramel<small>If you are a fan of
														caramel cake, then you'll love our Pancake with caramel
														icecream. It's not thick, but very tasty.</small>
												</h1>
											</div>
											<p>Ultrices In massa est, dignissim in libero ac,
												fringilla ornare mi.Ultrices eget justo. Nam purus lacus,
												efficitur eget laoreet sed, finibus nec neque. Cras eget
												enim in diam dapibus sagittis. accumsan, habitant morbi
												tristique senectus et netus et malesuada fames ac turpis
												egestas.</p>
											<a class="btn btn-default" href="./index.html" role="button">Order
												now</a> <a class="btn btn-secondary" href="./index.html"
												role="button">Add to cart</a>
										</div>
									</li>
									<li>
										<div class="slider-img">
											<img src="img/thumb4.png" alt="" />
										</div>
										<div class="slider-content">
											<div class="page-header">
												<h1>
													Pancake with Caramel<small>If you are a fan of
														caramel cake, then you'll love our Pancake with caramel
														icecream. It's not thick, but very tasty.</small>
												</h1>
											</div>
											<p>Ultrices In massa est, dignissim in libero ac,
												fringilla ornare mi.Ultrices eget justo. Nam purus lacus,
												efficitur eget laoreet sed, finibus nec neque. Cras eget
												enim in diam dapibus sagittis. accumsan, habitant morbi
												tristique senectus et netus et malesuada fames ac turpis
												egestas.</p>
											<a class="btn btn-default" href="./index.html" role="button">Order
												now</a> <a class="btn btn-secondary" href="./index.html"
												role="button">Add to cart</a>
										</div>
									</li>
								</ul>
								<div class="direction-nav hidden-sm">
									<div class="next">
										<a><img src="img/right-arrow.png" alt="" /></a>
									</div>
									<div class="prev">
										<a><img src="img/left-arrow.png" alt="" /></a>
									</div>
								</div>
							</div>
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

				<!-- Quotes section-->
				<div class="trusted-quote fixed-bg"
					data-stellar-background-ratio="0.2">

					<div class="container">
						<div class="row">
							<div class="col-md-offset-1 col-md-10">
								<div class="trusted-slider">
									<ul class="slides">
										<li><img src="img/quote.png" alt="quote">
											<p class="quote-body">The world’s a big, big stage for
												this notorious deli smack in the middle of the theatre
												district, infamously famous for its over-the-top corned beef
												and pastrami sandwiches, chopped liver, blintzes,
												celebrities, salami, smoked fish and New York’s finest
												cheesecake.</p>
											<p class="quote-author">
												Anthony Reed, <span>New York</span>
											</p></li>
										<li><img src="img/quote.png" alt="quote">
											<p class="quote-body">You might not find dragon meat on
												the menu, but you’ll find pretty much anything else that
												walks, swims or flies, cooked up in more ways than there are
												people in the Guangdong province. This Midtown mainstay has
												a 20-year history of delivering mouth-watering and Cantonese
												style chow.</p>
											<p class="quote-author">
												Gemma Arterton, <span>Bay Area</span>
											</p></li>
										<li><img src="img/quote.png" alt="quote">
											<p class="quote-body">This NYC historical landmark in the
												heart of the Theatre District has been serving up suds and
												down home pub food since 1892, surviving prohibition by
												renting the front of its then Rockefeller Center façade to
												Greek florists, while the Hurley brothers ran a speak-easy
												in back.</p>
											<p class="quote-author">
												Zachary Burton, <span>Sanfransisco</span>
											</p></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			<!-- subscribe -->
			<section class="subscribe">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1>Subscribe</h1>
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
			<section class="footer fixed-bg" data-stellar-background-ratio="0.2">
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
									<p class="footer-blog-text">Hand picked ingredients for our
										best customers</p>
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
						</div>
					</div>
				</div>

				<!-- Footer - Copyright -->
				<div class="footer-copyrights">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<p>
									<i class="fa fa-copyright"></i> 2016.Tomato.All rights
									reserved. Designed with <i class="fa fa-heart primary-color"></i>
									by Federico & Alessandro
								</p>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<%
			}
		%>

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

