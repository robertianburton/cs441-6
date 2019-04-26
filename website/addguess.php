<?php
	$mysqli = mysqli_connect("mysql.cs.binghamton.edu", "rburton2","ahchaich9Hoh","rburton2_cs441");
	$sql = "INSERT INTO entries (event, guess, name, email) VALUES(1, 20,'John Brown','example@example.com');";
	$result = mysqli_query($mysqli, $sql);
	echo $result;
?>