<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Pannello di controllo</title>
<meta name="author" content="Alessandro e Federico">
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
										<li><a href="./storicoComande.jsp">Storico Comande <i
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
												<table class="table table-hover">
													<thead>
														<tr class="warning">
															<th class="text-center">Id</th>
															<th class="text-center">Nominativo</th>
															<th class="text-center">Data - Ora</th>
															<th class="text-center">Tavolo</th>
															<th class="text-center">Ospiti</th>
															<th class="text-center">Stato</th>
															<th class="text-center">Elimina</th>
														</tr>
													</thead>
													<tbody>
														<h:panelGroup
															rendered="#{empty pannelloController.prenotazioni}">
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
															items="#{pannelloController.prenotazioni}">
															<tr>
																<td class="text-center"><h:outputText
																		value="#{prenotazione.id}" /></td>
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
																<h:panelGroup rendered="#{prenotazione.stato ==0}">
																	<td class="text-center"><a href="#"
																		data-toggle="modal" style="color: red;"
																		data-target='#<h:outputText
																					value="#{prenotazione.id}" />'
																		class="fa fa-trash-o fa-lg "></a></td>
																</h:panelGroup>
																<h:panelGroup rendered="#{prenotazione.stato != 0}">
																	<td class="text-center"><i style="color: red;"
																		class="fa fa-ban fa-lg" aria-hidden="true"></i></td>
																</h:panelGroup>

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
																						action="#{pannelloController.eliminaPrenotazione}">
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
												<br>
												<hr>
												<h4>Comande giornaliere completate</h4>
												<table class="table table-hover">
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
														<h:panelGroup
															rendered="#{empty pannelloController.comandeCompletateToday}">
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
														<c:forEach var="comanda"
															items="#{pannelloController.comandeCompletateToday}">
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
												<table class="table table-hover">
													<thead>
														<tr class="warning">
															<th class="text-center">Id</th>
															<th class="text-center">Username</th>
															<th class="text-center">Tavolo servito</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="utente"
															items="#{pannelloController.operatoriInServizio}">

															<tr>
																<td class="text-center"><h:outputText
																		value="#{utente.id}" /></td>
																<td class="text-center"><h:outputText
																		value="#{utente.username}" /></td>
																<td class="text-center"><c:forEach var="comanda"
																		items="#{utente.comanda}">
																		<h:panelGroup rendered="#{!comanda.completata}">
																			<h:outputText value="#{comanda.tavolo.codiceTavolo}" /> &nbsp;
																			</h:panelGroup>
																	</c:forEach></td>
															</tr>

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
												<h4>Comande in corso</h4>
												<h:form>
													<table class="table table-hover">
														<thead>
															<tr class="warning">
																<th class="text-center">Codice</th>
																<th class="text-center">Tavolo</th>
																<th class="text-center">Totale</th>
																<th class="text-center">Stato</th>
																<th class="text-center">Elimina</th>
																<th class="text-center">Scontrino</th>

															</tr>
														</thead>
														<tbody>
															<h:panelGroup
																rendered="#{empty pannelloController.comande}">
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
																		<td class="text-center"><i
																			class="fa fa-refresh fa-spin fa-lg fa-fw"></i> <span
																			class="sr-only">Loading...</span></td>
																		<td class="text-center"><a href="#"
																			style="color: red;" data-toggle="modal"
																			data-target='#<h:outputText
																					value="#{comanda.id}Eliminazione" />'
																			class="fa fa-trash-o fa-lg"></a></td>
																		<td class="text-center"><a href="#"
																			data-toggle="modal"
																			data-target='#<h:outputText
																					value="#{comanda.id}" />'
																			class="fa fa-shopping-cart"></a></td>
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

							<!-- GENERAZIONE MODALI PER OGNI COMANDA COMPLETATA -->
							<c:forEach var="comanda"
								items="#{pannelloController.comandeCompletateToday}">
								<h:form>
									<div id="<h:outputText value="#{comanda.id}" />"
										class="modal fade" aria-labelledby="myModal">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title">
														Tavolo N°
														<h:outputText value="#{comanda.tavolo.getCodiceTavolo()}" />
														- Comanda N°
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
																<th class="text-center"></th>
																<th class="text-center">Prezzo</th>
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
																	<td class="text-center">x</td>
																	<td class="text-center"><h:outputText
																			value="#{linea.piatto.descrizionePiatto.prezzo}" />&euro;</td>
																</tr>
															</c:forEach>
															<tr class="warning">
																<td class="text-center" colspan="4"><strong>Totale:</strong></td>
																<td class="text-center"><h:outputText
																		value="#{comanda.prezzoTotale}" />&euro;</td>
															</tr>
														</tbody>
													</table>
													<hr>

													<span class="text-left"><strong>Coperti N°
															: <h:outputText value="#{comanda.tavolo.coperti}" />
													</strong></span><br> <span> <strong>Data e ora : </strong> <h:outputText
															value="#{comanda.dataOraEmissione}">
															<f:convertDateTime pattern="dd/MM/yyyy    HH:mm" />
														</h:outputText> <br> <strong> Operatore : </strong> <h:outputText
															value="#{comanda.operatore.username}" />
													</span>
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

							<!-- GENERAZIONE MODALI PER OGNI COMANDA IN CORSO -->
							<c:forEach var="comanda" items="#{pannelloController.comande}">

								<!--  Modal conferma eliminazione comanda -->
								<h:form>
									<div id="<h:outputText value="#{comanda.id}Eliminazione" />"
										class="modal fade" aria-labelledby="myModal">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title">Sei sicuro di voler procedere
														all'eliminazione?</h4>
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
													<h:commandLink styleClass="btn btn-danger" value="Elimina"
														action="#{pannelloController.eliminaComanda}">
														<i class="fa fa-trash-o"></i>
														<f:param name="idComanda" value="#{comanda.id}"></f:param>
													</h:commandLink>
												</div>
											</div>
										</div>
									</div>
								</h:form>

								<!-- Modal visione comanda e scontrino  -->
								<h:form>
									<div id="<h:outputText value="#{comanda.id}" />"
										class="modal fade" aria-labelledby="myModal">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title">
														Tavolo N°
														<h:outputText value="#{comanda.tavolo.getCodiceTavolo()}" />
														- Comanda N°
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
																<th class="text-center"></th>
																<th class="text-center">Prezzo</th>
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
																	<td class="text-center">x</td>
																	<td class="text-center"><h:outputText
																			value="#{linea.piatto.descrizionePiatto.prezzo}" />&euro;</td>
																</tr>
															</c:forEach>
															<tr class="warning">
																<td class="text-center" colspan="4"><strong>Totale:</strong></td>
																<td class="text-center"><h:outputText
																		value="#{comanda.prezzoTotale}" />&euro;</td>
															</tr>
														</tbody>
													</table>
													<hr>

													<span class="text-left"><strong>Coperti N°
															: <h:outputText value="#{comanda.tavolo.coperti}" />
													</strong></span><br> <span> <strong>Data e ora : </strong> <h:outputText
															value="#{comanda.dataOraEmissione}">
															<f:convertDateTime pattern="dd/MM/yyyy    HH:mm" />
														</h:outputText> <br> <strong> Operatore : </strong> <h:outputText
															value="#{comanda.operatore.username}" />
													</span>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-warning"
														data-dismiss="modal">
														Chiudi <i class="fa fa-times"></i>
													</button>
													<h:commandLink styleClass="btn btn-success"
														value="Concludi comanda"
														action="#{pannelloController.confermaComanda}">
														<f:param name="idComanda" value="#{comanda.id}"></f:param>
														<i class="fa fa-check"></i>
													</h:commandLink>
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
		<script src="js/vendor/velocity.min.js"></script>
		<script src="js/vendor/velocity.ui.min.js"></script>
		<script src="js/animation.js"></script>
	</f:view>
</body>

</html>
