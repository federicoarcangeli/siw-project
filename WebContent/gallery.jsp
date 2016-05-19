<!DOCTYPE html>
<html lang="en">

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
							<li><a
								href="${pageContext.request.contextPath}/ProcessaMenu">Men&ugrave;</a></li>
							<li><a href="./gallery.jsp">Galleria</a></li>
							<li><a href="./loginSignup.jsp">Login / Signup</a></li>
							<li><a href="./contact.html">Contact</a></li>
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
							<h2 class="text-uppercase">Gallery</h2>
							<p>Tomato is a delicious restaurant website template</p>
						</div>
					</div>
				</div>
			</section>

			<!-- Gallery -->
			<div class="gallery-content">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/1.jpg">
								<img src="img/gallery/1.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/2.jpg">
								<img src="img/gallery/2.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/3.jpg">
								<img src="img/gallery/1.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/4.jpg">
								<img src="img/gallery/4.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/5.jpg">
								<img src="img/gallery/5.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/6.jpg">
								<img src="img/gallery/6.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/7.jpg">
								<img src="img/gallery/1.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/8.jpg">
								<img src="img/gallery/2.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="gallery-item" data-mfp-src="img/gallery/9.jpg">
								<img src="img/gallery/3.jpg" class="img-responsive" alt="" />
								<div class="gi-overlay">
									<i class="fa fa-search"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

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
