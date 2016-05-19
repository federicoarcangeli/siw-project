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

		<div class="main-wrapper">
			<%
				if (session.getAttribute("amministratoreCorrente") == null) {
					String redirectURL = "./404.html";
					response.sendRedirect(redirectURL);

				} else {
			%>

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
						<a class="navbar-brand" href="./home_Administrator.jsp"> <img
							src="img/nav-logo.png" alt="nav-logo">
						</a>
					</div>

					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
							<li><a href="${pageContext.request.contextPath}/processaSala">Sala</a></li>
							<li><a href="${pageContext.request.contextPath}/processaComanda">Comanda</a></li>
							<li><a href="/siw-project/ProcessaCategoria">Inserisci
									nuovi piatti</a></li>
							<li class="dropdown"><a href="./index.html"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Benvenuto
									${amministratoreCorrente.username}<span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="./index_parallax.jsp">Logout</a></li>
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
					<div class="row">
						<aside class="col-md-3">
							<div class="side-widget">
								<h5>Our Food</h5>
								<ul class="shop-cat">
									<li><a href="./registraOperatore.jsp">Registra nuovo
											operatore <i class="fa fa-caret-right"></i>
									</a></li>

								</ul>
							</div>

						</aside>

						<div class="col-md-9">
							<div class="shop-grid">
								<h1>PANNELLO DI CONTROLLO</h1>


								<div class="shop-products">
									<div class="row">
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/1.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/2.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/3.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/4.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/5.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/6.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/7.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/8.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="product-info">
												<div class="product-img">
													<img src="img/shop/9.png" alt="" />
												</div>
												<h4>
													<a href="./recipe_detail-image.html">Food Name</a>
												</h4>
												<div class="rc-ratings">
													<span class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span
														class="fa fa-star active"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span>
												</div>
												<div class="product-price">$100</div>
												<div class="shop-meta">
													<a href="./shop_single_left.html" class="pull-left"><i
														class="fa fa-shopping-cart"></i> Add to cart</a> <a
														href="./shop_right_sidebar.html" class="pull-right"><i
														class="fa fa-heart-o"></i> Wishlist</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<a href="./index.html" class="btn btn-default load-more">Load
									more</a>
							</div>
						</div>
					</div>
				</div>




			</div>
			<%
				}
			%>

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
