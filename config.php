<?php
$con=mysqli_connect("localhost:3307","root","") or die("Erro:We Can't connect Server");
$db=mysqli_select_db($con,"freska") or die("We Not Found Data Base");
?>