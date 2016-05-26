<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Pannello di controllo</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<%
				if (session.getAttribute("amministratoreCorrente") == null) {
					String redirectURL = "./404.html";
					response.sendRedirect(redirectURL);

				} else {
			%>

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
						<a class="navbar-brand"
							href="${pageContext.request.contextPath}/processaPannelloControllo">
							<img src="img/nav-logo.png" alt="nav-logo">
						</a>
					</div>

					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
							<li><a
								href="${pageContext.request.contextPath}/processaSala">Sala</a></li>
							<li class="dropdown"><a href="./index.html"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Benvenuto
									${amministratoreCorrente.username} -
									${amministratoreCorrente.role}<span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="./index_parallax.jsp">Logout</a></li>
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
									<li><a
										href="${pageContext.request.contextPath}/ProcessaCategoria">Registra
											nuovo Piatto <i class="fa fa-caret-right"></i>
									</a></li>
									<li><a
										href="${pageContext.request.contextPath}/processaStorico">Storico
											Comande <span class="label label-danger">hot</span><i
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
											<table class="table">
												<thead>
													<tr>
														<th class="text-center">Nominativo</th>
														<th class="text-center">Data - Ora</th>
														<th class="text-center">Tavolo</th>
														<th class="text-center">Ospiti</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="prenotazione" items="${prenotazioni}">
														<tr>
															<td class="text-center">${prenotazione.nominativo}
																${prenotazione.getUtente().getNome()}<br>
																${prenotazione.getUtente().getCognome()}
															</td>
															<td class="text-center">${prenotazione.data}<br>
																${prenotazione.ora}
															</td>
															<td class="text-center">${prenotazione.tavoloPrenotato.getCodiceTavolo()}</td>
															<td class="text-center">${prenotazione.numeroOspiti}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>

										<div class="col-md-4 col-sm-6">
											<h4>Operatori in servizio</h4>
											<table class="table">
												<thead>
													<tr>
														<th class="text-center">Codice operatore</th>
														<th class="text-center">Username</th>
														<th class="text-center">Tavolo servito</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="comanda" items="${comandePannello}">
														<tr>
															<td class="text-center">${comanda.operatore.getId()}</td>
															<td class="text-center">${comanda.operatore.getUsername()}</td>
															<td class="text-center">${comanda.tavolo.getCodiceTavolo()}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<h4>Panoramica tavoli</h4>
											<div class="progress">
												<div class="progress-bar progress-bar-success"
													role="progressbar" style="width: ${liberiP}%">
													${liberi}</div>
												<div class="progress-bar progress-bar-warning"
													role="progressbar" style="width: ${prenotatiP}%">
													${prenotati}</div>
												<div class="progress-bar progress-bar-danger"
													role="progressbar" style="width: ${occupatiP}%">
													${occupati}</div>
											</div>
										</div>

										<div class="col-md-4 col-sm-6">
											<h4>Comande giornaliere</h4>
											<form action="" method="post">
												<table class="table">
													<thead>
														<tr>
															<th class="text-center">Codice</th>
															<th class="text-center">Tavolo</th>
															<th class="text-center">Totale</th>
															<th class="text-center">Stato</th>
															<th class="text-center">Operazioni</th>

														</tr>
													</thead>
													<tbody>

														<c:forEach var="comanda" items="${comandePannello}">
															<tr>
																<td class="text-center">${comanda.id}</td>
																<td class="text-center">${comanda.tavolo.getCodiceTavolo()}</td>
																<td class="text-center">${comanda.prezzoTotale}</td>
																<c:if test="${comanda.completata=='false'}">
																	<td class="text-center"><i class="fa fa-spinner"></i></td>
																</c:if>
																<c:if test="${comanda.completata=='true'}">
																	<td class="text-center" class="success"><i
																		class="fa fa-check-circle"></i></td>
																</c:if>
																<td class="text-center"><a href="#"
																	data-toggle="modal" data-target='#${comanda.id}'
																	class="fa fa-wrench"></a></td>

															</tr>
														</c:forEach>
													</tbody>
												</table>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<c:forEach var="comanda" items="${comandePannello}">
						<form action="processaFineComanda" method="get" id="formfield">
							<div id="${comanda.id}" class="modal fade"
								aria-labelledby="myModal">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Tavolo:
												${comanda.tavolo.getCodiceTavolo()} - Comanda: ${comanda.id}</h4>
										</div>
										<div class="modal-body">

											<table class="table">
												<thead>
													<tr>
														<th class="text-center">Linea N°</th>
														<th class="text-center">Piatto</th>
														<th class="text-center">Quantità</th>

													</tr>
												</thead>
												<tbody>
													<c:forEach var="linea" items="${comanda.getLineeComanda()}">
														<tr>
															<td class="text-center">${linea.numeroLinea}</td>
															<td class="text-center">${linea.piatto.nome}</td>
															<td class="text-center">${linea.quantita}</td>
														</tr>
													</c:forEach>
													<tr class="warning">
														<td></td>
														<td class="text-center"><strong>Totale:</strong></td>
														<td class="text-center">${comanda.prezzoTotale}&euro;</td>
													</tr>
													<tr>
														<td>Data e ora : ${comanda.dataOraEmissione}<br>
															Operatore : ${comanda.operatore.getUsername()}
														</td>
														<td class="text-center"></td>
														<td></td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="submit" class="btn btn-danger" name="elimina"
												value='${comanda.id}'>
												Elimina <i class="fa fa-trash-o"></i>
											</button>
											<button type="button" class="btn btn-warning"
												data-dismiss="modal">
												Chiudi <i class="fa fa-times"></i>
											</button>
											<button type="submit" class="btn btn-success" name="conferma"
												onSubmit='function () {location.reload(true);}'
												value='${comanda.id}'>
												Conferma <i class="fa fa-check"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</form>
					</c:forEach>

				</div>
			</div>

			<%
				}
			%>
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
	<script src="js/scripts/confermaEliminazione.js"></script>

</body>

</html>
