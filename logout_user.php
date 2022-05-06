<?php
session_start();
unset($_SESSION["loggedUser"]);
header('Location:Home_eng.html');
?>