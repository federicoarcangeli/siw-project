<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Login - Signup</title>

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
								<li><a href="./loginSignup.jsp"><span
										style="color: #F9C56A;">Login / Signup</span></a></li>
								<li><a href="./contact.html">Contact</a></li>
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

				<!-- subscribe -->
				<section class="subscribe">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<h1>Subscribe</h1>
								<p>Get updates about new dishes and upcoming events</p>
								<form class="form-inline" action="php/subscribe.php" id="invite"
									method="POST">
									<div class="form-group">
										<input class="e-mail form-control" name="email" id="address"
											type="email" placeholder="Your Email Address" required>
									</div>
									<button type="submit" class="btn btn-default">
										<i class="fa fa-angle-right"></i>
									</button>
								</form>

							</div>
						</div>
					</div>
				</section>

				<!-- Footer-->
				<section class="footer">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-12">
								<h1>About us</h1>
								<p>Duis leo justo, condimentum at purus eu,Aenean sed dolor
									sem. Etiam massa libero, auctor vitae egestas et, accumsan quis
									nunc.Duis leo justo, condimentum at purus eu, posuere pretium
									tellus.</p>
								<a href="./about.html">Read more &rarr;</a>
							</div>
							<div class="col-md-4  col-sm-6">
								<h1>Recent post</h1>
								<div class="footer-blog clearfix">
									<a href="./blog_right_sidebar.html"> <img
										src="img/thumb8.png" class="img-responsive footer-photo"
										alt="blog photos">
										<p class="footer-blog-text">Hand picked ingredients for
											our best customers</p>
										<p class="footer-blog-date">29 may 2015</p>
									</a>
								</div>
								<div class="footer-blog clearfix last">
									<a href="./blog_right_sidebar.html"> <img
										src="img/thumb9.png" class="img-responsive footer-photo"
										alt="blog photos">
										<p class="footer-blog-text">Daily special foods that you
											will going to love</p>
										<p class="footer-blog-date">29 may 2015</p>
									</a>
								</div>
							</div>
							<div class="col-md-4  col-sm-6">
								<h1>Reach us</h1>
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
										<i class="fa fa-map-marker"></i>28 Seventh Avenue, Neew York,
										10014
									</p>
									<p>
										<i class="fa fa-phone"></i>Phone: (415) 124-5678
									</p>
									<p>
										<i class="fa fa-envelope-o"></i>support@restaurant.com
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
										<i class="fa fa-copyright"></i> 2015.Tomato.All rights
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
		<!-- 		scripts -->
		<script src="js/scripts/confermaRegistrazioneUtente.js"></script>
	</f:view>
</body>

</html>
