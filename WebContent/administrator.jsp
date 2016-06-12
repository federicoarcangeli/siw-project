<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Autenticazione admin</title>

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

				<!-- Login Admin Content -->
				<br> <br> <br> <br> <br>
				<section class="reservation">
					<div class="container">
						<div class="col-md-12">
							<div class="box-content">
								<h:form styleClass="logregform">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>Username</label>
												<h:inputText id="username"
													value="#{utenteController.username}" required="true"
													requiredMessage="Inserisci username"
													styleClass="form-control" />
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
												<label>Password</label>
												<h:inputSecret id="password"
													value="#{utenteController.password}" required="true"
													requiredMessage="Inserisci password"
													styleClass="form-control" />
												<div class="animated fadeInDown">
													<span class="label label-danger"><h:message
															for="password" /></span>
												</div>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="row">
										<div class="col-md-12">
											<h:commandButton value="login"
												action="#{utenteController.loginAdmin}"
												styleClass="btn btn-default btn-block" />
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
								</h:form>
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
		<script src="/js/vendor/mc/main.js"></script>
	</f:view>
</body>

</html>
