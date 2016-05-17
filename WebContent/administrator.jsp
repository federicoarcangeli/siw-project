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

<!--[if lt IE 9]>
            <script src="js/vendor/html5-3.6-respond-1.4.2.min.js"></script>
        <![endif]-->
</head>

<body>
	<!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

	<!-- Preloder-->
	<div class="preloder animated">
		<div class="scoket">
			<img src="img/preloader.svg" alt="" />
		</div>
	</div>

	<div class="body">
		<div class="main-wrapper">
			<!-- Navigation-->


			<!-- Page Header -->


			<!-- Account Content -->
			<br>
			<br>
			<br>
			<br>
			<br>
			<div class="animated fadeInDownBig">
				<section class="reservation">
					<div class="container">
						<div class="col-md-12">
							<div class="box-content">
								<form class="logregform" action="processaAmministratore"
									method="post">
									<div class="row">
										<div class="form-group">
											<div class="col-md-12">
												<label>Username</label> <input type="text" name="username"
													placeholder="username" class="form-control">
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="row">
										<div class="form-group">
											<div class="col-md-12">
												<label>Password</label> <input type="password"
													name="password" placeholder="password" class="form-control">
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="row">
										<div class="col-md-6">
											<button type="submit" class="btn btn-default pull-right">Login</button>
										</div>
									</div>
								</form>
							</div>
							<br>
							<%
								if (request.getAttribute("ERROR") != null) {
							%>
							<div class="animated fadeInRight">
								<div class="alert alert-error">
									<span> ERRORE: </span>${usernameError} ${passwordError}
									${loginError}
								</div>
							</div>
							<%
								}
							%>
						</div>

					</div>

				</section>
			</div>
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
</body>

</html>
