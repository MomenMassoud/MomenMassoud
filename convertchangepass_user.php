<?php
session_start();
$email=$_SESSION["loggedUser"];
unset($_SESSION["loggedUser"]);
session_start();
$_SESSION["loggedUser"]=$email;
header('Location:ChangePassword_user_arb.php');
?>