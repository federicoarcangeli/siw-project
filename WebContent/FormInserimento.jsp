<!DOCTYPE html>

<html lang="it">

<head>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/plugin.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/animate.min.css">
<meta charset="utf-8" />

<title>Iscrizione Studente</title>
</head>


<body data-scroll-animation="true">

	<section class="reservation">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header wow ">
						<h1>
							Iscrizione Studente<small> Benvenuto, compila i campi per
								iscriverti</small>
						</h1>
					</div>
				</div>
			</div>
			<div class="reservation-form wow">
				<form action="ProcessaStudente" method="post">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="email">Nome</label>
								<div <%if (request.getAttribute("nomeError") != null) {%>
									class="animated shake" <%}%>>
									<input type="text" class="form-control" id="nome" name="nome"
										placeholder="Nome" title="inserisci il tuo nome" tabindex=1
										value='${param["nome"]}'>
								</div>
								<i class="fa fa-user"></i>
							</div>
							<div class="form-group">
								<label for="name">Matricola</label>
								<div <%if (request.getAttribute("matricolaError") != null) {%>
									class="animated shake" <%}%>>
									<input type="text" class="form-control" id="matricola"
										name="matricola" placeholder="Matricola"
										title="Inserisco la tua matricola" tabindex=3
										value='${param["matricola"]}'>
								</div>
								<i class="fa fa-pencil-square-o"></i>
							</div>

						</div>
						<div class="col-md-6">

							<div class="form-group">
								<label for="guests" >Cognome</label>
								<div <%if (request.getAttribute("cognomeError") != null) {%>
									class="animated shake" <%}%>>
									<input class="form-control" type="text" id="cognome"
										name="cognome" placeholder="Cognome"
										title="inserisci il tuo cognome" tabindex=2
										value='${param["cognome"]}'>
								</div>
								<i class="fa fa-user"></i>
							</div>
							<div class="form-group">
								<label for="data">Data di nascita</label>
								<div <%if (request.getAttribute("dataError") != null) {%>
									class="animated shake" <%}%>>
									<input type="text" name="data" class="form-control"
										id="datepicker" placeholder="Data di nascita"
										title="inserisci la tua data di nascita" tabindex=4
										value='${param["data"]}'>
								</div>
								<i class="fa fa-calendar-o"></i>
							</div>
						</div>
						<div class="col-md-12 col-sm-12">
							<div class="reservation-btn">
								<input type="submit" value="invia domanda"
									class="btn btn-default btn-lg">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>

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
	<script src="js/vendor/validate.js"></script>
	<script src="js/reservation.js"></script>
	<script src="js/vendor/mc/main.js"></script>
</body>

</html>

