<!DOCTYPE html>
<!-- saved from url=(0060)https://getbootstrap.com/docs/4.0/examples/starter-template/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="https://getbootstrap.com/favicon.ico">

		<title>Crowd Counter</title>

		<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/starter-template/">

		<!-- Bootstrap core CSS -->
		<link href="./Starter Template for Bootstrap_files/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="./Starter Template for Bootstrap_files/starter-template.css" rel="stylesheet">
	</head>

	<body cz-shortcut-listen="true">

		<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
			<a class="navbar-brand" href="#">Crowd Counter</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExampleDefault">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">-</a>
					</li>
					<li class="nav-item">
						<a class="nav-link disabled" href="#">-</a>
					</li>
					
				</ul>
				<!-- <form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form> -->
			</div>
		</nav>

		<main role="main" class="container">

			<div class="starter-template">
				<h1>Crowd Counter</h1>
				<p class="lead">Count stuff.<br>Together.</p>
			</div>
					<?php
						$mysqli = mysqli_connect("mysql.cs.binghamton.edu", "rburton2","ahchaich9Hoh","rburton2_cs441");
						$sql = "SELECT * FROM entries ORDER BY id DESC";
						$result = mysqli_query($mysqli, $sql);
						mysqli_close($mysqli);
						?>
						<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Event</th>
								<th scope="col">Guess</th>
								<th scope="col">Name</th>
								<th scope="col">Time</th>
							</tr>
						</thead>
						<tbody >
						<?php
						while ($row = $result->fetch_assoc()) {?>
							<tr id="<?php echo $row['id']; ?>">
								<th scope="row">
										<?php echo $row["id"]; ?>
								</td>
								<td>
										Jelly Beans
								</td>
								<td>
										<?php echo $row["guess"]; ?>
								</td>
								<td>
										<?php echo $row["name"]; ?>
								</td>
								<td>
										<?php echo $row["ts"]; ?>
								</td>
							</tr>
						<?php } ?>
							
		</main><!-- /.container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="./Starter Template for Bootstrap_files/jquery-3.2.1.slim.min.js.download" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
		<script src="./Starter Template for Bootstrap_files/popper.min.js.download"></script>
		<script src="./Starter Template for Bootstrap_files/bootstrap.min.js.download"></script>
	

</body></html>