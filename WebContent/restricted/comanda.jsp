<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Inserimento comanda</title>
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
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="../css/plugin.css">
<link rel="stylesheet" href="../js/vendor/vegas/vegas.min.css">
<link rel="stylesheet" href="../css/main.css">

</head>

<body id="intro4">
	<f:view>
		<!-- Preloder-->
		<div class="preloder animated">
			<div class="scoket">
				<img src="../img/preloader.svg" alt="" />
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
							<a class="navbar-brand" href="./home_Administrator.jsp"> <img
								src="../img/nav-logo.png" alt="nav-logo">
							</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
								<li><a href="./sala.jsp">Sala</a></li>
								<li class="dropdown"><a href="./home_Administrator.jsp"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">Benvenuto <h:outputText
											value="#{utenteCorrente.username}"></h:outputText> <span
										class="caret"> </span></a>
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
						<h1>
							Tavolo:
							<h:outputText value="#{comandaCorrente.tavolo.codiceTavolo}" />
							Comanda:
							<h:outputText value="#{comandaCorrente.id}" />
							<span class="badge"><h:outputText
									value="#{comandaCorrente.operatore.username}" /></span>
						</h1>
						<hr>
					</div>
					<div class="food-menu wow fadeInUp">
						<div class="container-fluid">
							<div class="row">
								<aside class="col-md-1">
									<h4>Categoria</h4>
									<div class="menu-tags3">
										<ul class="shop-cat">
											<c:forEach var="categoria"
												items="#{comandaController.categorie}">
												<li><span
													data-filter=".<h:outputText
													value="#{categoria.nome}" />"><h:outputText
															value="#{categoria.nome}" /></span></li>
											</c:forEach>
										</ul>
									</div>
								</aside>
								<h:form>
									<div class="col-md-8">

										<div class="row menu-items3">
											<c:forEach var="piatto" items="#{comandaController.piatti}">
												<div
													class="menu-item3 col-md-2 col-sm-3 <h:outputText
													value="#{piatto.getPortata().nome}" />">
													<div class="pricing">
														<div class="plan-title">
															<h:outputText value="#{piatto.nome}" />
														</div>
														<h:commandLink styleClass="btn btn-success btn-block"
															action="#{comandaController.addLineaComanda}">
															add <i class="fa fa-pencil-square-o"></i>
															<f:param name="piatto" value="#{piatto.id}"></f:param>
														</h:commandLink>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</h:form>

								<aside class="col-md-3">
									<div class="side-widget">
										<h:form>
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
																				<th></th>
																				<th></th>
																				<th></th>

																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach var="linea"
																				items="#{comandaController.linee}">
																				<tr>
																					<td><h:outputText value="#{linea.piatto.nome}" /></td>
																					<td><h:outputText value="#{linea.quantita}" /></td>
																					<td><h:commandLink
																							action="#{comandaController.aggiungiQuantita}">
																							<i class="fa fa-plus fa-lg"></i>
																							<f:param name="idLineaComanda"
																								value="#{linea.id}"></f:param>
																						</h:commandLink></td>
																					<td><h:commandLink
																							action="#{comandaController.sottraiQuantita}">
																							<i class="fa fa-minus fa-lg"></i>
																							<f:param name="idLineaComanda"
																								value="#{linea.id}"></f:param>
																						</h:commandLink></td>
																					<td><h:commandLink
																							action="#{comandaController.eliminaLineaComanda}">
																							<i class="fa fa-trash-o fa-lg"></i>
																							<f:param name="idLineaComanda"
																								value="#{linea.id}"></f:param>
																						</h:commandLink></td>
																				</tr>
																			</c:forEach>
																			<tr>
																				<td colspan="2"><strong>Totale:</strong></td>
																				<td colspan="3"><h:outputText
																						value="#{comandaCorrente.prezzoTotale}" />&euro;</td>
																			</tr>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</h:form>
									</div>
								</aside>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- Javascript -->
		<script src="../js/vendor/jquery-1.11.2.min.js"></script>
		<script src="../js/vendor/bootstrap.min.js"></script>
		<script src="../js/vendor/jquery.flexslider-min.js"></script>
		<script src="../js/vendor/spectragram.js"></script>
		<script src="../js/vendor/owl.carousel.min.js"></script>
		<script src="../js/vendor/velocity.min.js"></script>
		<script src="../js/vendor/velocity.ui.min.js"></script>
		<script src="../js/vendor/bootstrap-datepicker.min.js"></script>
		<script src="../js/vendor/bootstrap-clockpicker.min.js"></script>
		<script src="../js/vendor/jquery.magnific-popup.min.js"></script>
		<script src="../js/vendor/isotope.pkgd.min.js"></script>
		<script src="../js/vendor/slick.min.js"></script>
		<script src="../js/vendor/wow.min.js"></script>
		<script src="../js/animation.js"></script>
		<script src="../js/vendor/vegas/vegas.min.js"></script>
		<script src="../js/vendor/jquery.mb.YTPlayer.js"></script>
		<script src="../js/vendor/jquery.stellar.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/vendor/mc/jquery.ketchup.all.min.js"></script>
		<script src="../js/vendor/mc/main.js"></script>
	</f:view>
</body>

</html>
