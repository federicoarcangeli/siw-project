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
							<li><a href="./inserisciComanda.jsp">Nuova comanda</a></li>
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
				<div class="container">


					<div class="row">

						<aside class="col-md-3">
							<div class="side-widget">
								<h5>Operazione di sistema</h5>
								<ul class="shop-cat">

									<li><a href="./registraOperatore.jsp">Nuovo operatore
											di sala <i class="fa fa-caret-right"></i>
									</a></li>
									<li><a href="./shop_single_full.html">Almonds <i
											class="fa fa-caret-right"></i></a></li>
									<li><a href="./shop_single_full.html">Furniture <i
											class="fa fa-caret-right"></i></a></li>
									<li><a href="./shop_single_full.html">Amaranth <i
											class="fa fa-caret-right"></i></a></li>
									<li><a href="./shop_single_full.html">Broad Beans <i
											class="fa fa-caret-right"></i></a></li>
									<li><a href="./shop_single_full.html">Coriander <i
											class="fa fa-caret-right"></i></a></li>
								</ul>

							</div>
						</aside>
					</div>

					<div class="col-md-9">
						<!-- da implementare  -->
					</div>
				</div>
				<
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
