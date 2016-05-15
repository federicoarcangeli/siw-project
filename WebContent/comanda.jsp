<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.uniroma3.project.controller.facade.Facade"%>
<%@page import="it.uniroma3.project.entity.CategoriaPiatto"%>
<%@page import="it.uniroma3.project.entity.Piatto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Inserimento nuovo piatto</title>


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
			<section class='page_header vertical-padding'></section>

			<!-- Shop Content -->
			<div class="container">
				<div class="food-menu wow fadeInUp">
					<div class="shop-content">
						<div class="row">
							<aside class="col-md-3">
								<div class="side-widget">
									<h5>Portate</h5>
									<div class="menu-tags3">
										<ul class="shop-cat">
											<c:forEach var="categoria" items="${categorie}">
												<li><span data-filter=".${categoria.nome}">${categoria.nome}</span>
													<i class="fa fa-caret-right"></i></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</aside>
							<div class="col-md-9">

								<div class="row menu-items3">
									<div class="shop-products">
										<c:forEach var="piatto" items="${piatti}">
											<div
												class="menu-item3 col-md-4 col-sm-6 ${piatto.getPortata().nome}">
												<div class="product-info">
													<div class="product-img">
														<img src="img/shop/1.png" alt="" />
													</div>
													<h4>
														<a href="./recipe_detail-image.html">${piatto.nome}</a>
													</h4>
													<div class="product-price">${piatto.getDescrizionePiatto().getPrezzo()}&euro;</div>
													<div class="shop-meta">
														<a href="./shop_single_left.html" class="pull-left"><i
															class="fa fa-shopping-cart"></i> Aggiungi alla comanda</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
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
