<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Login - Signup</title>
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
							<a class="navbar-brand" href="./index_parallax.jsp"> <img
								src="img/nav-logo.png" alt="nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./index_parallax.jsp">Home</a></li>
								<li><a href="./menu.jsp">Men&ugrave;</a></li>
								<li><a href="./about.jsp">Chi siamo</a></li>
								<li><a href="./contact.jsp">Contatti</a></li>
								<li><a href="./loginSignup.jsp"><span
										style="color: #F9C56A;">Login / Signup</span></a></li>
							</ul>
						</div>

						<!--/.navbar-collapse -->
					</div>
				</nav>

				<!-- Page Header -->
				<section class='page_header vertical-padding fixed-bg'></section>

				<!-- Account Content -->
				<section class="reservation">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header">
									<h1>
										Login / Signup<small>Registrati o accedi per poter
											prenotare un tavolo</small>
									</h1>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="row shop-login">
									<div class="col-md-6">
										<div class="box-content">
											<h3 class="text-center">Utente registrato</h3>
											<br>
											<div class="reservation-form">
												<h:form id="loginUtente">
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label for="username">Username</label>
																<h:inputText value="#{utenteController.username}"
																	styleClass="form-control" required="true"
																	requiredMessage="Username obbligatorio" id="username" />
																<i class="fa fa-barcode" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="username" /></span>
																</div>
															</div>
														</div>
													</div>
													<div class="clearfix"></div>
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label for="password">Password</label>
																<h:inputSecret value="#{utenteController.password}"
																	styleClass="form-control" required="true"
																	requiredMessage="Password obbligatoria" id="password" />
																<i class="fa fa-lock" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="password" /></span>
																</div>
															</div>
														</div>
													</div>
													<div class="clearfix"></div>
													<div class="row">
														<div class="col-md-6">
															<h:commandLink styleClass="btn btn-default pull-left"
																value="Accedi" action="#{utenteController.loginUtente}">
															</h:commandLink>
														</div>
													</div>
												</h:form>
											</div>
										</div>
										<br>
										<h:panelGroup rendered="#{not empty utenteError}">
											<div class="animated fadeInDown">
												<div class="alert alert-danger alert-dismissable">
													<button type="button" class="close" data-dismiss="alert">
														<span class="fa fa-close"></span>
													</button>
													<span> Errore: </span>
													<h:outputText value="#{utenteError}" />
												</div>
											</div>
										</h:panelGroup>

									</div>
									<div class="col-md-6">
										<div class="box-content">
											<h3 class="text-center">Registra un account</h3>
											<br>
											<div class="reservation-form">
												<h:form id="registrazioneUtente">
													<div class="clearfix space20"></div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label for="nome">Nome</label>
																<h:inputText value="#{utenteController.nome}"
																	styleClass="form-control" required="true"
																	requiredMessage="Nome obbligatorio" id="nome" />
																<i class="fa fa-user" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="nome" /></span>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="cognome">Cognome</label>
																<h:inputText value="#{utenteController.cognome}"
																	styleClass="form-control" required="true"
																	requiredMessage="Cognome obbligatorio" id="cognome" />
																<i class="fa fa-user" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="cognome" /></span>
																</div>
															</div>
														</div>
														<div class="col-md-12">
															<div class="form-group">
																<label for="username">Email</label>
																<h:inputText value="#{utenteController.email}"
																	styleClass="form-control" required="true"
																	requiredMessage="Email obbligatoria" id="email"
																	validatorMessage="inserire un indirizzo email valido">
																	<f:validateRegex
																		pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" />
																</h:inputText>
																<i class="fa fa-envelope" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="email" /></span>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="username">Username</label>
																<h:inputText value="#{utenteController.username}"
																	styleClass="form-control" required="true"
																	requiredMessage="Username obbligatorio" id="username" />
																<i class="fa fa-barcode" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="username" /></span>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="username">Telefono</label>
																<h:inputText value="#{utenteController.telefono}"
																	styleClass="form-control" required="true"
																	requiredMessage="Telefono obbligatorio" id="telefono" />
																<i class="fa fa-phone" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="telefono" /></span>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="password">Password</label>
																<h:inputSecret value="#{utenteController.password}"
																	styleClass="form-control" required="true"
																	requiredMessage="Password obbligatoria" id="password" />
																<i class="fa fa-lock" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="password" /></span>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="password">Conferma password</label>
																<h:inputSecret value="#{utenteController.confPassword}"
																	styleClass="form-control" required="true"
																	requiredMessage="Conferma password obbligatoria"
																	id="confPassword" />
																<i class="fa fa-lock" aria-hidden="true"></i>
																<div class="animated fadeInDown">
																	<span class="label label-danger"><h:message
																			for="confPassword" /></span>
																</div>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="col-md-12">
															<div class="space20"></div>
															<div class="reservation-btn">
																<input type="button" name="btn" value="Registrati"
																	id="conferma" data-toggle="modal"
																	data-target="#confirm-submit"
																	class="btn btn-default pull-right" />
															</div>
														</div>
													</div>

													<div class="modal fade" id="confirm-submit" tabindex="-1"
														role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-body">
																	<h4>Confermare Registrazione?</h4>
																	<table class="table">
																		<tr>
																			<th><span class="fa fa-user" aria-hidden="true"></span>
																				Nome:</th>
																			<td id="nom"></td>
																		</tr>
																		<tr>
																			<th><span class="fa fa-user" aria-hidden="true"></span>
																				Cognome:</th>
																			<td id="cog"></td>
																		</tr>
																		<tr>
																			<th><span class="fa fa-envelope"
																				aria-hidden="true"></span> Email:</th>
																			<td id="ema"></td>
																		</tr>
																		<tr>
																			<th><span class="fa fa-barcode"
																				aria-hidden="true"></span> Username:</th>
																			<td id="use"></td>
																		</tr>
																		<tr>
																			<th><span class="fa fa-phone" aria-hidden="true"></span>
																				Telefono:</th>
																			<td id="tel"></td>
																		</tr>
																	</table>
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Annulla</button>
																	<h:commandLink styleClass="btn btn-success"
																		value="Registrati" action="#{utenteController.create}">
																	</h:commandLink>
																</div>
															</div>
														</div>
													</div>
												</h:form>
											</div>
										</div>
										<br>

									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

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
										by Federico e Alessandro
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
		<!-- 		scripts -->
		<script src="js/scripts/confermaRegistrazioneUtente.js"></script>
	</f:view>
</body>

</html>
