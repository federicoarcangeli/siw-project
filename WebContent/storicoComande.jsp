<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Pannello di controllo</title>
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
<link rel="stylesheet" href="css/main.css">

</head>

<body id="intro4">
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
							<a class="navbar-brand" href="./home_Administrator.jsp"> <img
								src="img/nav-logo.png" alt="../nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./home_Administrator.jsp">Pannello di
										controllo</a></li>
								<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
								<li><a href="./sala.jsp">Sala</a></li>
								<li class="dropdown"><a href="./home_Administrator.jsp"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">Benvenuto <h:outputText
											value="#{utenteCorrente.username}"></h:outputText> <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><h:form>
												<h:commandButton action="#{utenteController.logout}"
													styleClass="btn btn-default btn-xs btn-block"
													value="Logout" />
											</h:form></li>
									</ul></li>
							</ul>
						</div>

						<!--/.navbar-collapse -->
					</div>
				</nav>

				<!-- Page Header -->
				<section class='page_header vertical-padding'></section>

				<!-- Page Storico  -->
				<div class="shop-grid">
					<h2>Storico comande</h2>
					<div class="shop-products">
						<div class="row">
							<div class="col-md-12">
								<table class="table">
									<thead>
										<tr class="warning">
											<th class="text-center">ID</th>
											<th class="text-center">Data - Ora</th>
											<th class="text-center">Prezzo</th>
											<th class="text-center">Operatore</th>
											<th class="text-center">Tavolo</th>
											<th class="text-center">Dettagli ordine</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="comanda" items="#{storicoController.comande}">
											<tr>
												<td class="text-center"><h:outputText
														value="#{comanda.id}" /></td>
												<td class="text-center"><h:outputText
														value="#{comanda.dataOraEmissione}">
														<f:convertDateTime pattern="dd/MM/yyyy HH:mm" />
													</h:outputText></td>
												<td class="text-center"><h:outputText
														value="#{comanda.prezzoTotale}" />0 &euro;</td>
												<td class="text-center"><h:outputText
														value="#{comanda.operatore.getUsername()}" /></td>
												<td class="text-center"><h:outputText
														value="#{comanda.tavolo.getCodiceTavolo()}" /></td>
												<td class="text-center"><a href="#" data-toggle="modal"
													data-target='#<h:outputText value="#{comanda.id}" />'
													class="fa fa-info-circle"></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

				<c:forEach var="comanda" items="#{storicoController.comande}">
					<h:form>
						<div id="<h:outputText value="#{comanda.id}" />"
							class="modal fade" aria-labelledby="myModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">
											Tavolo:
											<h:outputText value="#{comanda.tavolo.getCodiceTavolo()}" />
											- Comanda:
											<h:outputText value="#{comanda.id}" />
										</h4>
									</div>
									<div class="modal-body">

										<table class="table">
											<thead>
												<tr class="warning">
													<th class="text-center">Linea N�</th>
													<th class="text-center">Piatto</th>
													<th class="text-center">Quantit�</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="linea" items="#{comanda.getLineeComanda()}">
													<tr>
														<td class="text-center"><h:outputText
																value="#{linea.numeroLinea}" /></td>
														<td class="text-center"><h:outputText
																value="#{linea.piatto.nome}" /></td>
														<td class="text-center"><h:outputText
																value="#{linea.quantita}" /></td>
													</tr>
												</c:forEach>
												<tr class="warning">
													<td class="text-center" colspan="2"><strong>Totale:</strong></td>
													<td class="text-center"><h:outputText
															value="#{comanda.prezzoTotale}" />&euro;</td>
												</tr>
											</tbody>
										</table>
										<span><strong>Data e ora : </strong> <h:outputText
												value="#{comanda.dataOraEmissione}">
												<f:convertDateTime pattern="dd/MM/yyyy HH:mm" />
											</h:outputText> <br> <strong> Operatore : </strong> <h:outputText
												value="#{comanda.operatore.getUsername()}" /> </span>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-warning"
											data-dismiss="modal">
											Chiudi <i class="fa fa-times"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</h:form>
				</c:forEach>

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
	</f:view>
</body>

</html>