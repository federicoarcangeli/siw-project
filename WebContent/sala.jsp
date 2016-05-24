<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Gestione sala</title>
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
						<a class="navbar-brand"
							href="${pageContext.request.contextPath}/processaPannelloControllo">
							<img src="img/nav-logo.png" alt="nav-logo">
						</a>
					</div>

					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
							<li><a
								href="${pageContext.request.contextPath}/processaSala">Sala</a></li>
							<li><a
								href="${pageContext.request.contextPath}/processaComanda">Comanda</a></li>
							<li class="dropdown"><a href="./index.html"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Benvenuto
									${amministratoreCorrente.username} -
									${amministratoreCorrente.role}<span class="caret"></span>
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


			<!-- menu-->
			<section class="menu space60">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="page-header wow fadeInDown">
								<h1>Gestione sala</h1>
							</div>
						</div>
					</div>
				</div>
			</section>

			<div class="container-fluid">
				<div class="row">
					<form action="processaComanda" method="post">
						<div class="col-sm-12 centered">
							<c:forEach var="tavolo" items="${tavoli}">
								<div class="col-xs-6 col-sm-2">
									<c:choose>
										<c:when test="${tavolo.occupato=='0'}">
											<span class="label label-success">COPERTI :
												${tavolo.coperti}</span>
											<button id="libero" type="submit" class="btn btn-success"
												style="width: 100%; height: 150px;" name="tavolo"
												value='${tavolo.codiceTavolo}'>
												<h3>${tavolo.codiceTavolo}</h3>
											</button>
											<div class="col-md-12" style="height: 25px;"></div>
										</c:when>

										<c:when test="${tavolo.occupato=='1'}">
											<span class="label label-warning">COPERTI :
												${tavolo.coperti}</span>
											<span> </span>
											<button id="prenotato" type="submit" class="btn btn-warning"
												name="tavolo" style="width: 100%; height: 150px;"
												value='${tavolo.codiceTavolo}'>
												<h3>${tavolo.codiceTavolo}</h3>
											</button>
											<div class="col-md-12" style="height: 25px;"></div>
										</c:when>

										<c:when test="${tavolo.occupato=='2'}">
											<span class="label label-danger">COPERTI :
												${tavolo.coperti}</span>
											<button id="occupato" type="submit" class="btn btn-danger"
												name="tavolo" style="width: 100%; height: 150px;"
												value='${tavolo.codiceTavolo}'>
												<h3>${tavolo.codiceTavolo}</h3>
											</button>
											<div class="col-md-12" style="height: 25px;"></div>
										</c:when>
									</c:choose>
								</div>
							</c:forEach>

						</div>
					</form>
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

	<!-- 	scripts -->
	<script src="js/scripts/getComanda.js"></script>
	<script src="js/scripts/formAction.js"></script>

</body>

</html>
