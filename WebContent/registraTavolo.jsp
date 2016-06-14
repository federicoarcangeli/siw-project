<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Inserimento nuovo tavolo</title>
<meta name="author" content="Alessandro&Federico">

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

				<!-- Account Content -->
				<section class="reservation">
					<div class="container">
						<div class="row">

							<div class="col-md-12">
								<div class="row shop-login">
									<div class="box-content">
										<h3 class="text-center">Registra nuovo tavolo</h3>
										<br>
										<div class="reservation-form">
											<h:form id="inserimentoTavoli">

												<input type="hidden" name="action" value="add_form" />
												<div class="clearfix space20"></div>
												<div class="row">

													<div class="col-md-12">

														<div class="form-group">
															<label for="codiceTavolo">Numero tavolo</label>
															<h:inputText value="#{tavoloController.codice}"
																styleClass="form-control" required="true"
																requiredMessage="Numero tavolo obbligatorio"
																id="codiceTavolo" />
															<i class="fa fa-barcode" aria-hidden="true"></i>
															<div class="animated fadeInDown">
																<span class="label label-danger"><h:message
																		for="codiceTavolo" /></span>
															</div>
														</div>

														<div class="form-group">
															<label for="coperti">Coperti</label>
															<h:inputText value="#{tavoloController.coperti}"
																styleClass="form-control" required="true"
																requiredMessage="Numero di coperti obbligatorio"
																validatorMessage="Tavoli disponibili da 1 a 12 coperti"
																id="coperti">
																<f:validateLongRange minimum="1" maximum="12" />
															</h:inputText>
															<i class="fa fa-sort-numeric-asc" aria-hidden="true"></i>
															<div class="animated fadeInDown">
																<span class="label label-danger"><h:message
																		for="coperti" /></span>
															</div>
														</div>
													</div>

												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="space20"></div>
														<div class="reservation-btn">
															<input type="button" name="tableForm:tableBtn"
																value="Registra tavolo" id="conferma"
																data-toggle="modal" data-target="#confirm-submit"
																class="btn btn-default" />
														</div>
													</div>
												</div>
												<div class="modal fade" id="confirm-submit" tabindex="-1"
													role="dialog" aria-labelledby="myModalLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-body">
																<h4>Confermare inserimento?</h4>
																<table class="table">
																	<tr>
																		<th><span class="fa fa-barcode"
																			aria-hidden="true"></span> Codice tavolo:</th>
																		<td id="cod"></td>
																	</tr>
																	<tr>
																		<th><span class="fa fa-users" aria-hidden="true"></span>
																			Numero di coperti:</th>
																		<td id="cop"></td>
																	</tr>
																</table>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">Annulla</button>
																<h:commandLink styleClass="btn btn-success"
																	value="Registra tavolo"
																	action="#{tavoloController.create}">
																</h:commandLink>
															</div>
														</div>
													</div>
												</div>
											</h:form>
											<h:panelGroup rendered="#{not empty tavoloCorrente}">
												<div class="animated fadeInDown">
													<div class="alert alert-success alert-dismissable">
														<button type="button" class="close" data-dismiss="alert">
															<span class="fa fa-close"></span>
														</button>
														<span> Nuovo tavolo: </span>
														<h:outputText value="#{tavoloCorrente}" />
													</div>
												</div>
											</h:panelGroup>
											<h:panelGroup rendered="#{not empty tavoloError}">
												<div class="animated fadeInDown">
													<div class="alert alert-danger alert-dismissable">
														<button type="button" class="close" data-dismiss="alert">
															<span class="fa fa-close"></span>
														</button>
														<span> ERRORE: </span>
														<h:outputText value="#{tavoloError}" />
													</div>
												</div>
											</h:panelGroup>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
		<br>

		<!-- Javascript -->
		<script src="js/vendor/jquery-1.11.2.min.js"></script>
		<script src="js/vendor/bootstrap.min.js"></script>
		<script src="js/vendor/velocity.min.js"></script>
		<script src="js/vendor/velocity.ui.min.js"></script>
		<script src="js/animation.js"></script>
		<!-- 		scripts -->
		<script src="js/scripts/confermaInserimentoTavoli.js"></script>
	</f:view>
</body>

</html>
