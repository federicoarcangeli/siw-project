<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Prenotazioni</title>
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

<body data-scroll-animation="true">
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
							<h:panelGroup rendered="#{utenteCorrente.role == 'admin'}">
								<a class="navbar-brand" href="./home_Administrator.jsp"> <img
									src="img/nav-logo.png" alt="nav-logo">
								</a>
							</h:panelGroup>
							<h:panelGroup rendered="#{utenteCorrente.role == 'operatore'}">
								<a class="navbar-brand" href="./home_Operatore.jsp"> <img
									src="img/nav-logo.png" alt="nav-logo">
								</a>
							</h:panelGroup>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<h:panelGroup rendered="#{utenteCorrente.role == 'operatore'}">
									<li><a href="./home_Operatore.jsp">Sala</a></li>
								</h:panelGroup>
								<h:panelGroup rendered="#{utenteCorrente.role == 'admin'}">
									<li><a href="./home_Administrator.jsp">Pannello di
											controllo</a></li>
								</h:panelGroup>
								<li><a href="./prenotazioneAdmin.jsp"><span
										style="color: #F9C56A;">Riserva un tavolo</span></a></li>
								<h:panelGroup rendered="#{utenteCorrente.role == 'admin'}">
									<li><a href="./sala.jsp">Sala</a></li>
								</h:panelGroup>
								<li class="dropdown"><a href="" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-haspopup="true"
									aria-expanded="false">Benvenuto <h:outputText
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

				<section class='page_header vertical-padding'></section>

				<!-- Reservations page-->
				<div class="col-md-12">
					<br> <br> <br>
				</div>
				<section class="reservation">
					<div class="container">
						<div class="row">
							<div class="page-header">
								<h1>
									<small>Prenotazioni disponibili dalle 19:00 alle 21:59.</small>
								</h1>
							</div>
						</div>
						<div class="reservation-form">
							<h:form id="prenotazioni">
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label for="nominativo">Nominativo</label>
											<h:inputText value="#{prenotazioneController.nominativo}"
												styleClass="form-control" required="true" id="nominativo"
												requiredMessage="Nominativo obbligatorio">
											</h:inputText>
											<i class="fa fa-user" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="nominativo" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="datepicker">Data</label>
											<h:inputText value="#{prenotazioneController.datepicker}"
												styleClass="form-control" required="true" id="datepicker"
												requiredMessage="Data prenotazione obbligatoria"
												converterMessage="Formato data errato dd/mm/yyyy">
												<f:convertDateTime pattern="dd/MM/yyyy" />
											</h:inputText>
											<i class="fa fa-calendar-o" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="datepicker" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="timepicker">Orario di arrivo</label>
											<h:inputText value="#{prenotazioneController.timepicker}"
												styleClass="form-control" required="true" id="timepicker"
												requiredMessage="Orario di arrivo obbligatorio"
												converterMessage="Formato ora errato hh:mm">
												<f:convertDateTime pattern="HH:mm" />
											</h:inputText>
											<i class="fa fa-clock-o" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="timepicker" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="coperti">Coperti</label>
											<h:inputText value="#{prenotazioneController.coperti}"
												styleClass="form-control" required="true"
												requiredMessage="Numero di coperti obbligatorio"
												validatorMessage="Tavoli non disponibili per questo numero di coperti"
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
									<div class="col-md-12 col-sm-12">
										<div class="reservation-btn">
											<input type="button" name="tableForm:tableBtn"
												value="Effettua prenotazione" id="conferma"
												data-toggle="modal" data-target="#confirm-submit"
												class="btn btn-default" />
										</div>
										<div class="animated fadeInDown">
											<h:messages globalOnly="true" styleClass="list-group"
												infoClass="list-group-item list-group-item-danger"></h:messages>
										</div>
									</div>
								</div>
								<div class="modal fade" id="confirm-submit" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-body">
												<h4>Confermare prenotazione?</h4>
												<table class="table">
													<tr>
														<th><span class="fa fa-user" aria-hidden="true"></span>
															Nominativo:</th>
														<td id="nom"></td>
													</tr>
													<tr>
														<th><span class="fa fa-calendar-o" aria-hidden="true"></span>
															Data:</th>
														<td id="date"></td>
													</tr>
													<tr>
														<th><span class="fa fa-clock-o" aria-hidden="true"></span>
															Ora:</th>
														<td id="time"></td>
													</tr>
													<tr>
														<th><span class="fa fa-users" aria-hidden="true"></span>
															Ospiti:</th>
														<td id="osp"></td>
													</tr>
												</table>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Annulla</button>
												<h:commandLink styleClass="btn btn-success"
													value="Effettua prenotazioni"
													action="#{prenotazioneController.createByAdmin}">
												</h:commandLink>

											</div>
										</div>
									</div>
								</div>
							</h:form>
							<h:panelGroup rendered="#{not empty prenotazioneCorrente}">
								<div class="animated fadeInDown">
									<div class="alert alert-success alert-dismissable">
										<button type="button" class="close" data-dismiss="alert">
											<span class="fa fa-close"></span>
										</button>
										<span></span>
										<h:outputText value="#{prenotazioneCorrente}" />
									</div>
								</div>
							</h:panelGroup>
							<h:panelGroup rendered="#{not empty prenotazioneError}">
								<div class="animated fadeInDown">
									<div class="alert alert-danger alert-dismissable">
										<button type="button" class="close" data-dismiss="alert">
											<span class="fa fa-close"></span>
										</button>
										<span> Attenzione: </span>
										<h:outputText value="#{prenotazioneError}" />
									</div>
								</div>
							</h:panelGroup>
						</div>
					</div>
				</section>
			</div>
		</div>

		<!-- Javascript -->
		<script src="js/vendor/jquery-1.11.2.min.js"></script>
		<script src="js/vendor/bootstrap.min.js"></script>
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
		<script src="js/main.js"></script>
		<script src="js/reservation.js"></script>
		<script src="js/vendor/mc/main.js"></script>
		<!-- 		scripts -->
		<script src="js/scripts/confermaInserimentoPrenotazioneAdmin.js"></script>

	</f:view>
</body>

</html>
