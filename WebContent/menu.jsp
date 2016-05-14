<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.uniroma3.project.controller.facade.Facade"%>
<%@page import="it.uniroma3.project.entity.CategoriaPiatto"%>
<%@page import="it.uniroma3.project.entity.Piatto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Tomato Responsive Restaurant HTML5 Template</title>
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

<%
	Facade facade = new Facade();
	List<CategoriaPiatto> categorie = facade.findAllCategorie();
	request.setAttribute("categorie", categorie);

	List<Piatto> piatti = facade.findAllPiatti();
	request.setAttribute("piatti", piatti);
%>

<!--[if lt IE 9]>
            <script src="js/vendor/html5-3.6-respond-1.4.2.min.js"></script>
        <![endif]-->
</head>

<body>
	<!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

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
							<li class="dropdown">
							<li><a href="./prenotazione.jsp">Prenotazioni</a></li>
							<li class="dropdown"><a href="./about.html"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Pages<span
									class="caret"></span></a>
							<li><a href="./contact.html">Contattaci</a></li>

						</ul>
					</div>
				</div>
			</nav>

			<!-- Page Header -->
			<section class="page_header">
				<div class="container">
					<div class="row">
						<div class="col-md-12 text-center">
							<h2 class="text-uppercase">Menu</h2>
							<p>Tomato is a delicious restaurant website template</p>
						</div>
					</div>
				</div>
			</section>

			<!-- menu-->
			<section class="menu space60">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="page-header wow fadeInDown">
								<h1>
									Tile Style<small>These fine folks trusted the award
										winning restaurant.</small>
								</h1>
							</div>
						</div>
					</div>
					<div class="food-menu wow fadeInUp">
						<div class="row">
							<div class="col-md-12">
								<div class="menu-tags3">
									<span data-filter="*" class="tagsort3-active">Tutti</span>
									<c:forEach var="categoria" items="${categorie}">
										<span data-filter=".${categoria.nome}">${categoria.nome}</span>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="row menu-items3">
							<c:forEach var="piatto" items="${piatti}">
								<div
									class="menu-item3 col-sm-6 col-xs-12 ${piatto.getPortata()}">
									<img src="img/menu/2/2.jpg" class="img-responsive" alt="" />
									<div class="menu-wrapper">
										<h4>${piatto.nome}</h4>
										<span class="price">
											${piatto.getDescrizionePiatto().getPrezzo() } &euro; </span>
										<div class="dotted-bg"></div>
										<p>${piatto.getDescrizionePiatto().getDescrizione()}</p>
									</div>
								</div>
							</c:forEach>
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
									by Surjithctly
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
	<script src="js/main.js"></script>
	<script src="js/vendor/mc/jquery.ketchup.all.min.js"></script>
	<script src="js/vendor/mc/main.js"></script>

</body>

</html> 	