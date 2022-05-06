<?php
$email=$_POST['username'];
$password=$_POST['password'];
include "config.php";
$query="SELECT * FROM `user` WHERE `Email` LIKE '$email' AND `Password` LIKE '$password'";
$resu=mysqli_query($con,$query);
$count=mysqli_num_rows($resu);
if($count == 1){
    session_start();
    $_SESSION["loggedUser"]=$email;
    header('Location:Shopping_arb.php');
}
else{
    header('Location:Home_arb.html');
}
?>