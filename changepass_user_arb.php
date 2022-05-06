<?php
$new=$_POST['npassword'];
include "config.php";
session_start();
if(!isset($_SESSION["loggedUser"])){
    header('Location:Home_eng.html');
}
$email=$_SESSION["loggedUser"];
$veiwuser="UPDATE `user` SET `Password` = '$new' WHERE `user`.`Email` = '$email';";
    $result=mysqli_query($con,$veiwuser);
header('Location:Shopping_arb.php');
?>