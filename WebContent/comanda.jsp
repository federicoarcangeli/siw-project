<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Inserimento comanda</title>
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

			<!-- Shop Content -->
			<div class="shop-content">
				<div class="col-md-12">
					<h1>Tavolo: ${comanda.tavolo.codiceTavolo} Comanda:
						${comanda.id}</h1>
				</div>
				<div class="food-menu wow fadeInUp">
					<div class="container-fluid">
						<div class="row">
							<aside class="col-md-1">
								<h4>Categoria</h4>
								<div class="menu-tags3">
									<div class="side-widget">
										<ul class="shop-cat">
											<c:forEach var="categoria" items="${categorie}">
												<li><span data-filter=".${categoria.nome}"><i
														class="fa fa-angle-right"></i>${categoria.nome}</span></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</aside>
							<form action="UpdateComanda" method="post">
								<div class="col-md-8">
									<h4>Piatti</h4>
									<div class="shop-grid">
										<div class="shop-products">
											<div class="row">
												<div class="row menu-items3">
													<c:forEach var="piatto" items="${piatti}">
														<div
															class="menu-item3 col-sm-4 ${piatto.getPortata().nome}">
															<div class="product-info">
																<h4>
																	<a href="">${piatto.nome}</a>
																</h4>
																<div class="shop-meta centered">
																	<button type="submit" name="piatto"
																		class="btn btn-success center-block"
																		value='${piatto.id}'>
																		<i class="fa fa-pencil-square-o"></i> Aggiungi
																	</button>
																</div>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
							<%
								if (request.getAttribute("error") != null) {
							%>
							<div class="animated fadeInDown">
								<div class="alert alert-error alert-dismissable">
									<button type="button" class="close" data-dismiss="alert">
										<span class="fa fa-close"></span>
									</button>
									<span> ERRORE: </span>${piattoError }
								</div>
							</div>
							<%
								}
							%>

							<aside class="col-md-3">
								<div class="side-widget">
									<form>
										<div class="row">
											<div class="form-group">
												<div class="shop-grid">
													<div class="shop-products">
														<div class="row">
															<div class="col-md-12">
																<h4>Ordine in corso</h4>
																<br>
																<table
																	class="cart-table account-table table table-bordered">
																	<thead>
																		<tr>
																			<th>Piatto</th>
																			<th>Quantità</th>
																			<th>Aggiungi</th>

																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="linea" items="${linee}">
																			<tr>
																				<td>${linea.piatto.nome}</td>
																				<td><input type="number" placeholder="qta"
																					value="${linea.quantita}" style="width: 65px;"></td>
																				<td><a class="fa fa-plus"
																					onclick="$(this).closest('form').submit()"></a></td>
																			</tr>
																		</c:forEach>
																		<tr>
																			<td></td>
																			<td><strong>Totale:</strong></td>
																			<td>${comanda.prezzoTotale}&euro;</td>
																		</tr>
																	</tbody>
																</table>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</aside>
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
