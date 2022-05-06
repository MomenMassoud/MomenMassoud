<?php
$email=$_POST['email'];
$password=$_POST['password'];
include "config.php";
$query="SELECT * FROM `admin` WHERE `Email` LIKE '$email' AND `Password` LIKE '$password'";
$resu=mysqli_query($con,$query);
$count=mysqli_num_rows($resu);
if($count == 1){
    header('Location:Adminpage_arb.html');
}
else{
    header('Location:Login_admin_arb.html');
}
?>