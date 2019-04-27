<?php
	$mysqli = mysqli_connect("mysql.cs.binghamton.edu", "rburton2","ahchaich9Hoh","rburton2_cs441");
	$sql = "INSERT INTO entries (event, guess, name, email) VALUES(1, ".$_GET['guess'].",'".$_GET['name']."','example@example.com');";
	$result = mysqli_query($mysqli, $sql);
	mysqli_close($mysqli);
	if($_GET['guess']==261) {
		echo "1";
	} else {
		echo "0";
	}
?>