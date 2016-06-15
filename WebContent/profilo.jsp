<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Profilo</title>
<meta name="author" content="Alessandro e Federico">

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
							<a class="navbar-brand" href="./index_parallax.jsp"> <img
								src="img/nav-logo.png" alt="nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./index_parallax.jsp">Home</a></li>
								<li><a href="./menu.jsp">Men&ugrave;</a></li>
								<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
								<li><a href="./about.jsp">Chi siamo</a></li>
								<li><a href="./contact.jsp">Contatti</a></li>
								<li class="dropdown"><a href="./index_parallax.jsp"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false"><span
										style="color: #F9C56A;">Benvenuto <h:outputText
												value="#{utenteCorrente.username}"></h:outputText> <span
											class="caret"></span></span></a>
									<ul class="dropdown-menu">
										<li class="text-center"><a href="./profilo.jsp">Profilo</a></li>
										<li>
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
				<section class='page_header vertical-padding fixed-bg'></section>

				<!-- Profile Content -->
				<div class="container">
					<div class="shop-content">
						<div class="row">
							<aside class="col-md-3">
								<div class="side-widget">
									<h3 class="text-left no-margin-top">Riepilogo dati utente</h3>
									<div class="footer-address contact-info">
										<p>
											<i class="fa fa-user"></i> <span><i
												class="fa fa-angle-right"></i> <h:outputText
													value="#{utenteCorrente.nome}" /></span>
											${utenteCorrente.cognome}
										</p>
										<p>
											<i class="fa fa-phone"></i> <span><i
												class="fa fa-angle-right"></i> <h:outputText
													value="#{utenteCorrente.telefono}" /></span>
										</p>
										<p>
											<i class="fa fa-envelope-o"></i> <span><i
												class="fa fa-angle-right"></i> <h:outputText
													value="#{utenteCorrente.email}" /></span>
										</p>
									</div>
								</div>
							</aside>
							<div class="col-md-9">
								<div class="shop-grid">
									<div class="shop-products">
										<div class="row">
											<div class="col-md-12">
												<h3>Prenotazione effettuate</h3>
												<br>
												<table class="cart-table account-table table table-bordered">
													<thead>
														<tr>
															<th>Codice Prenotazione</th>
															<th>Data</th>
															<th>Ora</th>
															<th>Numero ospiti</th>
															<th>Tavolo</th>
															<th>Stato</th>
															<th>Elimina</th>
														</tr>
													</thead>
													<tbody>
														<h:panelGroup
															rendered="#{empty profiloController.prenotazioniUtente}">
															<td class="text-center"><i class="fa fa-minus"
																aria-hidden="true"></i></td>
															<td class="text-center"><i class="fa fa-minus"
																aria-hidden="true"></i></td>
															<td class="text-center"><i class="fa fa-minus"
																aria-hidden="true"></i></td>
															<td class="text-center"><i class="fa fa-minus"
																aria-hidden="true"></i></td>
															<td class="text-center"><i class="fa fa-minus"
																aria-hidden="true"></i></td>
															<td class="text-center"><i class="fa fa-minus"
																aria-hidden="true"></i></td>
															<td class="text-center"><i class="fa fa-minus"
																aria-hidden="true"></i></td>
														</h:panelGroup>
														<c:forEach var="prenotazione"
															items="#{profiloController.prenotazioniUtente}">
															<tr>
																<td><h:outputText value="#{prenotazione.id}" /></td>
																<td><h:outputText value="#{prenotazione.data}">
																		<f:convertDateTime pattern="dd/MM/yyyy" />
																	</h:outputText></td>
																<td><h:outputText value="#{prenotazione.ora}">
																		<f:convertDateTime pattern="HH:mm" />
																	</h:outputText></td>
																<td><h:outputText
																		value="#{prenotazione.numeroOspiti}" /></td>
																<td><h:outputText
																		value="#{prenotazione.tavoloPrenotato.codiceTavolo}" /></td>
																<h:panelGroup rendered="#{prenotazione.stato == 0}">
																	<td class="text-center"><i
																		class="fa fa-refresh fa-spin fa-lg fa-fw"></i><span
																		class="sr-only">Loading...</span></td>
																</h:panelGroup>
																<h:panelGroup rendered="#{prenotazione.stato == 1}">
																	<td class="text-center" class="success"><i
																		class="fa fa-cutlery"></i></td>
																</h:panelGroup>
																<h:panelGroup rendered="#{prenotazione.stato == 2}">
																	<td class="text-center" class="success"
																		style="color: green;"><i
																		class="fa fa-check-circle"></i></td>
																</h:panelGroup>
																<h:panelGroup rendered="#{prenotazione.stato == 3}">
																	<td class="text-center" class="success"
																		style="color: orange;"><i
																		class="fa fa-exclamation-triangle"></i></td>
																</h:panelGroup>
																<h:panelGroup rendered="#{prenotazione.stato !=0 }">
																	<td class="text-center "><i style="color: red;"
																		class="fa fa-ban fa-lg" aria-hidden="true"></i></td>
																</h:panelGroup>
																<h:panelGroup rendered="#{prenotazione.stato == 0}">
																	<td class="text-center"><a href="#"
																		style="color: red;" data-toggle="modal"
																		data-target='#<h:outputText
																					value="#{prenotazione.id}" />'
																		class="fa fa-trash-o fa-lg"></a></td>
																</h:panelGroup>
															</tr>

															<!--  Modal conferma eliminazione prenotazione -->
															<h:form>
																<div id="<h:outputText value="#{prenotazione.id}" />"
																	class="modal fade" aria-labelledby="myModal">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close"
																					data-dismiss="modal">&times;</button>
																				<h4 class="modal-title">Sei sicuro di voler
																					procedere all'eliminazione?</h4>
																			</div>
																			<div class="modal-body">

																				<h5>
																					<i class="fa fa-exclamation-circle"
																						style="color: #F9C56A;" aria-hidden="true"></i>
																					L'eliminazione sarà irreversibile!
																				</h5>
																			</div>
																			<div class="modal-footer">
																				<button type="button" class="btn btn-warning"
																					data-dismiss="modal">
																					Chiudi <i class="fa fa-times"></i>
																				</button>
																				<h:commandLink styleClass="btn btn-danger"
																					value="Elimina"
																					action="#{profiloController.eliminaPrenotazioneDaProfilo}">
																					<i class="fa fa-trash-o"></i>
																					<f:param name="idPrenotazione"
																						value="#{prenotazione.id}"></f:param>
																				</h:commandLink>
																			</div>
																		</div>
																	</div>
																</div>
															</h:form>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Footer-->
				<section class="footer fixed-bg" data-stellar-background-ratio="0.2">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-12">
								<h1>Chi siamo</h1>
								<p>Due studenti di Roma Tre</p>
								<a href="./about.jsp">Leggi ancora &rarr;</a>
							</div>
							<div class="col-md-4  col-sm-6"></div>

							<div class="col-md-4  col-sm-6">
								<h1>Contattaci</h1>
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
										<i class="fa fa-map-marker"></i>Via della vasca navale 70,
										00146
									</p>
									<p>
										<i class="fa fa-phone"></i>Telefono: +39 123456789
									</p>
									<p>
										<i class="fa fa-envelope-o"></i>dapepperestaurant@gmail.com
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
										<i class="fa fa-copyright"></i> 2015.Da Peppe.All rights
										reserved. Designed with <i class="fa fa-heart primary-color"></i>
										by Alessandro &amp; Federico
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
		<script src="js/vendor/velocity.min.js"></script>
		<script src="js/vendor/velocity.ui.min.js"></script>
		<script src="js/animation.js"></script>
	</f:view>
</body>
</html>