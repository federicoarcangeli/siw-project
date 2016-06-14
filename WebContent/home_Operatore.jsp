<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<!DOCTYPE html>
<html lang="it">
<f:view>
	<head>
<meta charset="utf-8">

<title><h:outputText value="#{utenteCorrente.username}" /></title>
<meta name="author" content="Alessandro e Federico">

<!-- Favicons -->
<link rel="shortcut icon" href="../img/favicon.ico">

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
							<a class="navbar-brand" href="./home_Operatore.jsp"> <img
								src="img/nav-logo.png" alt="nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./home_Operatore.jsp"><span
										style="color: #F9C56A;">Sala</span></a></li>
								<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
								<li class="dropdown"><a href="./home_Operatore.jsp"
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

				<!-- sala -->
				<div class="col-md-12">
					<br> <br> <br>
				</div>
				<div class="container-fluid">
					<div class="row">
						<h:form id="sala">
							<div class="col-sm-12 centered">
								<c:forEach var="tavolo" items="#{salaController.tavoliSala}">
									<div class="col-xs-6 col-sm-2">

										<h:panelGroup rendered="#{tavolo.stato eq '0'}">
											<span class="label label-success">COPERTI : <h:outputText
													value="#{tavolo.coperti}" />
											</span>
											<h:commandButton styleClass="btn btn-success" id="libero"
												style="width: 100%; height: 150px; font-size:25px;"
												action="#{salaController.openComanda}"
												value='#{tavolo.codiceTavolo}'>
												<f:param name="codiceTavolo" value="#{tavolo.codiceTavolo}"></f:param>
											</h:commandButton>
											<div class="col-md-12" style="height: 25px;"></div>
										</h:panelGroup>
										<h:panelGroup rendered="#{tavolo.stato eq '1'}">
											<span class="label label-warning">COPERTI : <h:outputText
													value="#{tavolo.coperti}" />
											</span>
											<h:commandButton styleClass="btn btn-warning" id="prenotato"
												style="width: 100%; height: 150px; font-size:25px;"
												action="#{salaController.openComanda}"
												value='#{tavolo.codiceTavolo}'>
												<f:param name="codiceTavolo" value="#{tavolo.codiceTavolo}"></f:param>
											</h:commandButton>
											<div class="col-md-12" style="height: 25px;"></div>
										</h:panelGroup>
										<h:panelGroup rendered="#{tavolo.stato eq '2'}">
											<span class="label label-danger">COPERTI : <h:outputText
													value="#{tavolo.coperti}" />
											</span>
											<h:commandButton styleClass="btn btn-danger" id="occupato"
												style="width: 100%; height: 150px; font-size:25px;"
												action="#{salaController.openComanda}"
												value='#{tavolo.codiceTavolo}'>
												<f:param name="codiceTavolo" value="#{tavolo.codiceTavolo}"></f:param>
											</h:commandButton>
											<div class="col-md-12" style="height: 25px;"></div>
										</h:panelGroup>

									</div>
								</c:forEach>
							</div>
						</h:form>
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
	</body>
</f:view>
</html>
