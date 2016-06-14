<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Inserimento nuovo piatto</title>
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

				<section class='page_header vertical-padding'></section>

				<!-- Inserimento Piatti page-->
				<section class="reservation">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header">
									<h1>Inserisci un nuovo piatto</h1>
								</div>
							</div>
						</div>

						<div class="reservation-form">
							<h:form id="inserimentoPiatti">
								<div class="col-md-6">
									<div id="OT_searchWrapper">
										<div id="OT_defList" class="">
											<div id="OT_partySize" class="">
												<div class="form-group">
													<label for="name">Categoria</label>
													<h:selectOneMenu value="#{piattoController.nomeCategoria}"
														id="categoria">

														<f:selectItems value="#{piattoController.nomiCategorie}" />

													</h:selectOneMenu>
													<h:messages for="categoria" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 col-sm-12">
										<div class="form-group">
											<label for="name">Nome</label>
											<h:inputText value="#{piattoController.nome}"
												styleClass="form-control" required="true"
												requiredMessage="Nome obbligatorio" id="nome" />
											<i class="fa fa-cutlery" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="nome" /></span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 col-sm-6">
										<div class="form-group">
											<label for="descrizione">Descrizione</label>
											<h:inputTextarea value="#{piattoController.descrizione}"
												styleClass="form-control" required="true"
												requiredMessage="La descrizione del piatto è obbligatoria"
												cols="20" rows="5" id="descrizione" />
											<i class="fa fa-sticky-note" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="descrizione" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6">
										<div class="form-group">
											<label for="prezzo">Prezzo</label>
											<h:inputText value="#{piattoController.prezzo}"
												styleClass="form-control" required="true"
												requiredMessage="Il prezzo è obbligatorio"
												converterMessage="Il prezzo deve essere un numero"
												id="prezzo" />
											<i class="fa fa-eur" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="prezzo" /></span>
											</div>
										</div>
									</div>
									<div id="OT_partySize" class="col-md-6 col-sm-6">
										<div class="form-group">
											<label for="surgelati">Contiene prodotti surgelati?</label>
											<h:selectBooleanCheckbox
												value="#{piattoController.surgelati}" />
										</div>
									</div>
									<div id="OT_partySize" class="col-md-6 col-sm-6">
										<div class="form-group">
											<label for="allergeni">Contiene allergeni?</label>
											<h:selectBooleanCheckbox
												value="#{piattoController.allergeni}" />
										</div>
									</div>
								</div>

								<div id="OT_searchWrapper">
									<div id="OT_defList" class="row">
										<div class="col-md-12 col-sm-12">
											<div class="reservation-btn">
												<input type="button" name="btn" value="Registra piatto"
													id="conferma" data-toggle="modal" data-target="#myModal"
													class="btn btn-default center-block" />
											</div>
										</div>
									</div>
								</div>
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-body">
												<h4>Confermare inserimento?</h4>
												<table class="table">
													<tr>
														<th><span class="fa fa-cutlery" aria-hidden="true"></span>
															Categoria:</th>
														<td id="cat"></td>
													</tr>
													<tr>
														<th><span class="fa fa-cutlery" aria-hidden="true"></span>
															Nome:</th>
														<td id="nom"></td>
													</tr>
													<tr>
														<th><span class="fa fa-sticky-note"
															aria-hidden="true"></span> Descrizione:</th>
														<td id="des"></td>
													</tr>
													<tr>
														<th><span class="fa fa-eur" aria-hidden="true"></span>
															Prezzo:</th>
														<td id="pre"></td>
													</tr>
												</table>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Annulla</button>
												<h:commandLink styleClass="btn btn-success"
													value="inserisci piatto"
													action="#{piattoController.create}">
												</h:commandLink>
											</div>
										</div>
									</div>
								</div>
							</h:form>
							<h:panelGroup rendered="#{not empty piattoCorrente}">
								<div class="animated fadeInDown">
									<div class="alert alert-success alert-dismissable">
										<button type="button" class="close" data-dismiss="alert">
											<span class="fa fa-close"></span>
										</button>
										<span></span>
										<h:outputText value="#{piattoCorrente}" />
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
		<script src="js/vendor/velocity.min.js"></script>
		<script src="js/vendor/velocity.ui.min.js"></script>
		<script src="js/animation.js"></script>
		<script src="js/scripts/confermaInserimentoPiatto.js"></script>
	</f:view>
</body>

</html>
