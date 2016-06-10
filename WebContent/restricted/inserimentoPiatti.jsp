<%@page import="it.uniroma3.project.facade.*"%>
<%@page import="it.uniroma3.project.model.CategoriaPiatto"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Inserimento nuovo piatto</title>


<!-- Favicons -->
<link rel="shortcut icon" href="../img/favicon.ico">

<!-- Responsive Tag -->
<meta name="viewport" content="width=device-width">

<!-- CSS Files -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="../css/plugin.css">
<link rel="stylesheet" href="../css/main.css">



</head>

<body data-scroll-animation="true">
	<f:view>
		<!-- Preloder-->
		<div class="preloder animated">
			<div class="scoket">
				<img src="../img/preloader.svg" alt="" />
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
								src="../img/nav-logo.png" alt="nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
								<li><a
									href="${pageContext.request.contextPath}/processaSala">Sala</a></li>
								<li class="dropdown"><a href="./home_Administrator.jsp"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">Benvenuto <h:outputText
											value="#{utenteCorrente.username}"></h:outputText> <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="./index_parallax.jsp">Logout</a></li>
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
							<h:form id="inserimentoPiatti" enctype="multipart/form-data">
								<div class="col-md-12">
									<div id="OT_searchWrapper">
										<div id="OT_defList" class="">
											<div id="OT_partySize" class="">
												<div class="form-group">
													<label for="name">Categoria</label>
													<h:selectOneMenu
														value="#{piattoControllerBean.nomeCategoria}"
														id="categoria">

														<f:selectItems
															value="#{piattoControllerBean.nomiCategorie}" />

													</h:selectOneMenu>
													<h:messages for="categoria" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 col-sm-6">
										<div class="form-group">
											<label for="name">Nome</label>
											<h:inputText value="#{piattoControllerBean.nome}"
												styleClass="form-control" required="true"
												requiredMessage="Nome obbligatorio" id="nome" />
											<i class="fa fa-cutlery" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="nome" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6">
										<div class="form-group">

											<label for="immagine">Immagine</label>

											<t:inputFileUpload
												value="#{piattoControllerBean.uploadedFile}"
												styleClass="form-control" required="true"
												requiredMessage="Inserisci un'immagine per il piatto"
												id="img" />
											<i class="fa fa-picture-o" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="img" /></span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 col-sm-6">
										<div class="form-group">
											<label for="descrizione">Descrizione</label>
											<h:inputTextarea value="#{piattoControllerBean.descrizione}"
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
											<h:inputText value="#{piattoControllerBean.prezzo}"
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
												value="#{piattoControllerBean.surgelati}" />
										</div>
									</div>
									<div id="OT_partySize" class="col-md-6 col-sm-6">
										<div class="form-group">
											<label for="allergeni">Contiene allergeni?</label>
											<h:selectBooleanCheckbox
												value="#{piattoControllerBean.allergeni}" />
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
													action="#{piattoControllerBean.create}">
												</h:commandLink>
											</div>
										</div>
									</div>
								</div>
							</h:form>
						</div>
					</div>
				</section>

				<!-- Footer-->
				<section class="footer">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-12">
								<h1>Dicono di noi</h1>
								<p></p>
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
								<h1>Seguici sui social!</h1>
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
										<i class="fa fa-copyright"></i> 2016. Copyright. Designed with
										<i class="fa fa-heart primary-color"></i>
									</p>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>

		</div>

		<!-- Javascript -->
		<script src="../js/vendor/jquery-1.11.2.min.js"></script>
		<script src="../js/vendor/bootstrap.min.js"></script>
		<script src="../js/vendor/jquery.flexslider-min.js"></script>
		<script src="../js/vendor/spectragram.js"></script>
		<script src="../js/vendor/owl.carousel.min.js"></script>
		<script src="../js/vendor/velocity.min.js"></script>
		<script src="../js/vendor/velocity.ui.min.js"></script>
		<script src="../js/vendor/bootstrap-datepicker.min.js"></script>
		<script src="../js/vendor/bootstrap-clockpicker.min.js"></script>
		<script src="../js/vendor/jquery.magnific-popup.min.js"></script>
		<script src="../js/vendor/isotope.pkgd.min.js"></script>
		<script src="../js/vendor/slick.min.js"></script>
		<script src="../js/vendor/wow.min.js"></script>
		<script src="../js/animation.js"></script>
		<script src="../js/vendor/vegas/vegas.min.js"></script>
		<script src="../js/vendor/jquery.mb.YTPlayer.js"></script>
		<script src="../js/vendor/jquery.stellar.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/vendor/mc/jquery.ketchup.all.min.js"></script>
		<script src="../js/vendor/validate.js"></script>
		<script src="../js/reservation.js"></script>
		<script src="../js/vendor/mc/main.js"></script>
		<script src="../js/scripts/confermaInserimentoPiatto.js"></script>
	</f:view>
</body>

</html>
