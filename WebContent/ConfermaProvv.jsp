<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.uniroma3.model.Studente"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel='stylesheet' href='css/font-awesome/css/font-awesome.css'>
<link rel='stylesheet' href='css/plugin.css'>
<link rel='stylesheet' href='css/main.css'>
<link rel='stylesheet' href='css/animate.min.css'>
<meta charset='utf-8' />
<meta name='viewport' content='width=device-width'>
<title>Continuare?</title>
</head>
<body data-scroll-animation='true'>
	<section class='page_header vertical-padding'></section>
	<div class='container'>
		<div class='row'>
			<div class='col-md-12 text-center'>
				<div class='giant-space'>
					<p>
						<c:forEach var="studente" items="${STUDENTI}">
							<b>Nome:</b>  ${studente.nome}
						<b>Cognome:</b> ${studente.cognome} 
						<b>Matricola:</b> ${studente.matricola}
						<b>Data di nascita:</b> ${studente.dataNascita }<br>
						</c:forEach>
					</p>

					<input type="button"
						onClick="window.location.href='FormInserimento.jsp';"
						class="btn btn-default btn-lg" value="inserisci un altro studente" />

					<input type="button"
						onClick="window.location.href='ConfermaFin.jsp';"
						class="btn btn-default btn-lg" value="Conferma" />
				</div>
			</div>
		</div>
	</div>

	<script src='js/vendor/jquery-1.11.2.min.js'></script>
	<script src='js/vendor/bootstrap.min.js'></script>
	<script src='js/vendor/jquery.flexslider-min.js'></script>
	<script src='js/vendor/spectragram.js'></script>
	<script src='js/vendor/owl.carousel.min.js'></script>
	<script src='js/vendor/velocity.min.js'></script>
	<script src='js/vendor/velocity.ui.min.js'></script>
	<script src='js/vendor/bootstrap-datepicker.min.js'></script>
	<script src='js/vendor/bootstrap-clockpicker.min.js'></script>
	<script src='js/vendor/jquery.magnific-popup.min.js'></script>
	<script src='js/vendor/isotope.pkgd.min.js'></script>
	<script src='js/vendor/slick.min.js'></script>
	<script src='js/vendor/wow.min.js'></script>
	<script src='js/animation.js'></script>
	<script src='js/vendor/vegas/vegas.min.js'></script>
	<script src='js/vendor/jquery.mb.YTPlayer.js'></script>
	<script src='js/vendor/jquery.stellar.js'></script>
	<script src='js/main.js'></script>
	<script src='js/vendor/mc/jquery.ketchup.all.min.js'></script>
	<script src='js/vendor/mc/main.js'></script>
	");
</body>
</html>
