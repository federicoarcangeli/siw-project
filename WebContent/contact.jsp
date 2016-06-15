<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Contatti</title>
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
								<h:panelGroup rendered="#{utenteCorrente.username != null}">
									<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
								</h:panelGroup>
								<li><a href="./about.jsp">Chi siamo</a></li>
								<li><a href="./contact.html"><span
										style="color: #F9C56A;">Contatti</span></a></li>
								<h:panelGroup rendered="#{utenteCorrente.username == null}">
									<li><a href="./loginSignup.jsp">Login / Signup</a></li>
								</h:panelGroup>
								<h:panelGroup rendered="#{utenteCorrente.username != null}">
									<li class="dropdown"><a href="./index_parallax.jsp"
										class="dropdown-toggle" data-toggle="dropdown" role="button"
										aria-haspopup="true" aria-expanded="false">Benvenuto <h:outputText
												value="#{utenteCorrente.username}"></h:outputText> <span
											class="caret"></span></a>
										<ul class="dropdown-menu">
											<li class="text-center"><a href="./profilo.jsp">Profilo</a></li>
											<li><h:form>
													<h:commandButton action="#{utenteController.logout}"
														styleClass="btn btn-default btn-xs btn-block"
														value="Logout" />
												</h:form></li>
										</ul></li>
								</h:panelGroup>
							</ul>
						</div>
						<!--/.navbar-collapse -->
					</div>
				</nav>

				<!-- Page Header -->
				<section class="page_header fixed-bg">
					<div class="container">
						<div class="row">
							<div class="col-md-12 text-center">
								<h2 class="text-uppercase">Contatti</h2>
								<p>Come trovare il nostro ristorante e raggiungerci</p>
							</div>
						</div>
					</div>
				</section>

				<!-- Contact Form / Info -->
				<div class="col-md-12">
					<h:panelGroup rendered="#{not empty emailConfirm}">
						<div class="animated fadeInDown">
							<div class="alert alert-success alert-dismissable">
								<button type="button" class="close" data-dismiss="alert">
									<span class="fa fa-close"></span>
								</button>
								<span></span>
								<h:outputText value="#{emailConfirm}" />
							</div>
						</div>
					</h:panelGroup>
				</div>
				<section class="main-content contact-content">
					<div class="container">
						<div class="col-md-10 col-md-offset-1">
							<div class="row">
								<div class="col-md-6">
									<h3 class="text-left no-margin-top">Indirizzo</h3>
									<div class="footer-address contact-info">
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
									<br>

									<h3 class="text-left no-margin-top">Orario lavorativo</h3>
									<div class="contact-info text-muted">
										<p>10:00 - 23:00 Lun. Mar. Mer. Gio. Ven.</p>
										<p>11:00 - 23:30 Sab. Dom.</p>
									</div>
									<br>

									<h3 class="text-left no-margin-top">Seguici</h3>
									<div class="contact-social">
										<a href="http://www.facebook.com"><i
											class="fa fa-facebook"></i></a> <a href="http://www.twitter.com"><i
											class="fa fa-twitter"></i></a> <a href="http://www.dribbble.com"><i
											class="fa fa-dribbble"></i></a> <a
											href="http://www.instagram.com"><i
											class="fa fa-instagram"></i></a>
									</div>
								</div>
								<div class="col-md-6">
									<h:form>
										<div class="form-group">
											<label>Nome</label>
											<h:inputText value="#{contactController.nome}"
												styleClass="form-control" id="name" required="true"
												requiredMessage="Inserisci il tuo nome" />
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="name" /></span>
											</div>
										</div>
										<div class="form-group">
											<label>Indirizzo email</label>
											<h:inputText value="#{contactController.email}"
												styleClass="form-control" id="email" required="true"
												requiredMessage="Email necessaria" />
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="email" /></span>
											</div>
										</div>
										<div class="form-group">
											<label>Oggetto</label>
											<h:inputText value="#{contactController.subject}"
												styleClass="form-control" id="subject" required="true"
												requiredMessage="Oggetto del messaggio obbligatorio" />
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="subject" /></span>
											</div>
										</div>
										<div class="form-group">
											<label>Messaggio</label>
											<h:inputTextarea value="#{contactController.body}"
												styleClass="form-control" id="body" required="true"
												requiredMessage="Scrivi qualcosa nel corpo del messaggio" />
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="body" /></span>
											</div>
										</div>
										<h:commandLink styleClass="btn btn-default btn-block"
											value="Contattaci" action="#{contactController.sendMessage}">
										</h:commandLink>
									</h:form>
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
										<i class="fa fa-copyright"></i> 2015.DaPeppe.All rights
										reserved. Designed with <i class="fa fa-heart primary-color"></i>
										by Federico &amp; Alessandro
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
