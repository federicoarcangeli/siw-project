<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Pannello di controllo</title>

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
								src="img/nav-logo.png" alt="nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./home_Administrator.jsp"><span
										style="color: #F9C56A;">Pannello di controllo</span></a></li>
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

				<!-- Shop Content -->
				<div class="shop-content">
					<div class="container-fluid">
						<div class="row">
							<aside class="col-md-2">
								<div class="side-widget">
									<h5>Operazioni di sistema</h5>
									<ul class="shop-cat">
										<li><a href="./registraPersonale.jsp">Registra nuovo
												Personale <i class="fa fa-caret-right"></i>
										</a></li>
										<li><a href="./registraTavolo.jsp">Registra nuovo
												Tavolo <i class="fa fa-caret-right"></i>
										</a></li>
										<li><a href="./inserimentoPiatti.jsp">Registra nuovo
												piatto<i class="fa fa-caret-right"></i>
										</a></li>
										<li><a href="/storicoComande.jsp">Storico Comande <i
												class="fa fa-caret-right"></i>
										</a></li>
									</ul>
								</div>
							</aside>

							<div class="col-md-10">
								<div class="shop-grid">
									<div class="shop-products">
										<div class="row">
											<div class="col-md-4 col-sm-6">
												<h4>Prenotazioni</h4>
												<table class="table">
													<thead>
														<tr class="warning">
															<th class="text-center">Nominativo</th>
															<th class="text-center">Data - Ora</th>
															<th class="text-center">Tavolo</th>
															<th class="text-center">Ospiti</th>
															<th class="text-center">Stato</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="prenotazione"
															items="#{pannelloController.prenotazioni}">
															<tr>
																<td class="text-center"><h:outputText
																		value="#{prenotazione.nominativo}" /> <h:outputText
																		value="#{prenotazione.getUtente().getNome()}" /><br>
																	<h:outputText
																		value="#{prenotazione.getUtente().getCognome()}" /></td>
																<td class="text-center"><h:outputText
																		value="#{prenotazione.data}">
																		<f:convertDateTime pattern="dd/MM/yyyy" />
																	</h:outputText><br> <h:outputText value="#{prenotazione.ora}">
																		<f:convertDateTime pattern="HH:mm" />
																	</h:outputText></td>
																<td class="text-center"><h:outputText
																		value="#{prenotazione.tavoloPrenotato.getCodiceTavolo()}" /></td>
																<td class="text-center"><h:outputText
																		value="#{prenotazione.numeroOspiti}" /></td>
																<h:panelGroup rendered="#{!prenotazione.completato}">
																	<td class="text-center"><i
																		class="fa fa-refresh fa-spin fa-lg fa-fw"></i><span
																		class="sr-only">Loading...</span></td>
																</h:panelGroup>
																<h:panelGroup rendered="#{prenotazione.completato}">
																	<td class="text-center" class="success"
																		style="color: green;"><i
																		class="fa fa-check-circle"></i></td>
																</h:panelGroup>
														</c:forEach>
													</tbody>
												</table>
												<br>
												<hr>
												<h4>Comande giornaliere completate</h4>
												<table class="table">
													<thead>
														<tr class="warning">
															<th class="text-center">Codice</th>
															<th class="text-center">Tavolo</th>
															<th class="text-center">Totale</th>
															<th class="text-center">Stato</th>
															<th class="text-center">Dettagli</th>

														</tr>
													</thead>
													<tbody>
														<c:forEach var="comanda"
															items="#{pannelloController.comande}">
															<h:panelGroup rendered="#{comanda.completata}">
																<tr>
																	<td class="text-center"><h:outputText
																			value="#{comanda.id}" /></td>
																	<td class="text-center"><h:outputText
																			value="#{comanda.tavolo.getCodiceTavolo()}" /></td>
																	<td class="text-center"><h:outputText
																			value="#{comanda.prezzoTotale}" /> &euro;</td>
																	<h:panelGroup rendered="#{!comanda.completata}">
																		<td class="text-center"><i
																			class="fa fa-spinner fa-pulse fa-2x fa-fw"></i> <span
																			class="sr-only">Loading...</span></td>
																	</h:panelGroup>
																	<h:panelGroup rendered="#{comanda.completata}">
																		<td class="text-center" class="success"
																			style="color: green;"><i
																			class="fa fa-check-circle"></i></td>
																	</h:panelGroup>
																	<td class="text-center"><a href="#"
																		data-toggle="modal"
																		data-target='#<h:outputText
																				value="#{comanda.id}" />'
																		class="fa fa-info-circle"></a></td>
																</tr>
															</h:panelGroup>
														</c:forEach>
													</tbody>
												</table>
											</div>
											<div class="col-md-4 col-sm-6">
												<h4>Operatori in servizio</h4>
												<table class="table">
													<thead>
														<tr class="warning">
															<th class="text-center">Codice operatore</th>
															<th class="text-center">Username</th>
															<th class="text-center">Tavolo servito</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="comanda"
															items="#{pannelloController.comande}">
															<h:panelGroup rendered="#{!comanda.completata}">
																<tr>
																	<td class="text-center"><h:outputText
																			value="#{comanda.operatore.getId()}" /></td>
																	<td class="text-center"><h:outputText
																			value="#{comanda.operatore.getUsername()}" /></td>
																	<td class="text-center"><h:outputText
																			value="#{comanda.tavolo.getCodiceTavolo()}" /></td>
																</tr>
															</h:panelGroup>
														</c:forEach>
													</tbody>
												</table>
												<br>
												<hr>
												<h4>Panoramica tavoli</h4>
												<div class="progress">
													<div class="progress-bar progress-bar-success"
														role="progressbar"
														style="width: <h:outputText value="#{pannelloController.tavoliLiberiP}" />%">
														<h:outputText value="#{pannelloController.tavoliLiberi}" />
													</div>
													<div class="progress-bar progress-bar-warning"
														role="progressbar"
														style="width: <h:outputText value="#{pannelloController.tavoliPrenotatiP}" />%">
														<h:outputText
															value="#{pannelloController.tavoliPrenotati}" />
													</div>
													<div class="progress-bar progress-bar-danger"
														role="progressbar"
														style="width: <h:outputText value="#{pannelloController.tavoliOccupatiP}" />%">
														<h:outputText value="#{pannelloController.tavoliOccupati}" />
													</div>
												</div>
											</div>
											<div class="col-md-4 col-sm-6">
												<h4>Comande giornaliere in corso</h4>
												<h:form>
													<table class="table">
														<thead>
															<tr class="warning">
																<th class="text-center">Codice</th>
																<th class="text-center">Tavolo</th>
																<th class="text-center">Totale</th>
																<th class="text-center">Stato</th>
																<th class="text-center">Operazioni</th>

															</tr>
														</thead>
														<tbody>
															<c:forEach var="comanda"
																items="#{pannelloController.comande}">
																<h:panelGroup rendered="#{!comanda.completata}">
																	<tr>
																		<td class="text-center"><h:outputText
																				value="#{comanda.id}" /></td>
																		<td class="text-center"><h:outputText
																				value="#{comanda.tavolo.getCodiceTavolo()}" /></td>
																		<td class="text-center"><h:outputText
																				value="#{comanda.prezzoTotale}" /> &euro;</td>
																		<h:panelGroup rendered="#{!comanda.completata}">
																			<td class="text-center"><i
																				class="fa fa-refresh fa-spin fa-lg fa-fw"></i> <span
																				class="sr-only">Loading...</span></td>
																		</h:panelGroup>
																		<h:panelGroup rendered="#{comanda.completata}">
																			<td class="text-center" class="success"><i
																				class="fa fa-spinner fa-pulse fa-2x fa-fw"></i> <span
																				class="sr-only">Loading...</span></td>
																		</h:panelGroup>
																		<td class="text-center"><a href="#"
																			data-toggle="modal"
																			data-target='#<h:outputText
																					value="#{comanda.id}" />'
																			class="fa fa-wrench"></a></td>
																	</tr>
																</h:panelGroup>
															</c:forEach>
														</tbody>
													</table>
												</h:form>
												<br>
												<hr>
											</div>
										</div>
									</div>
								</div>
							</div>
							<c:forEach var="comanda" items="#{pannelloController.comande}">
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
																<th class="text-center">Linea N°</th>
																<th class="text-center">Piatto</th>
																<th class="text-center">Quantità</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="linea"
																items="#{comanda.getLineeComanda()}">
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
													<h:panelGroup rendered="#{!comanda.completata}">
														<h:commandLink styleClass="btn btn-danger" value="Elimina"
															action="#{pannelloController.eliminaComanda}">
															<i class="fa fa-trash-o"></i>
															<f:param name="idComanda" value="#{comanda.id}"></f:param>
														</h:commandLink>
														<h:commandLink styleClass="btn btn-success"
															value="Conferma"
															action="#{pannelloController.confermaComanda}">
															<f:param name="idComanda" value="#{comanda.id}"></f:param>
															<i class="fa fa-check"></i>
														</h:commandLink>
													</h:panelGroup>
												</div>
											</div>
										</div>
									</div>
								</h:form>
							</c:forEach>
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
		<script src="js/scripts/confermaEliminazione.js"></script>
	</f:view>
</body>

</html>
