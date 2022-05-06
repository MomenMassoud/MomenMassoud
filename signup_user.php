<!DOCTYPE html>
<html>
<head>
    <title>Freska Market</title>
    <link rel="stylesheet" type="text/css" href="CSS/AddIteams.css">
    <link rel="shortcut icon" href="IMAGE/logo.jpeg">
</head>
<body>
<?php
include "config.php";
if (!$con){
    die("Connection error: " . mysqli_connect_errno());
}
$fname=$_POST["firstname"];
$lname=$_POST["lastname"];
$AGE=$_POST["age"];
$Gender="Male";
$phoneNumber=$_POST["phoneNumber"];
$Address=$_POST["Address"];
$email=$_POST["email"];
$password=$_POST["password"];
$statment1= "INSERT INTO `user` (`First Name`, `Last Name`, `Age`, `Email`, `Password`, `Gender`, `PhoneNumber`, `Address`) VALUES ('$fname', '$lname', '$AGE', '$email', '$password','$Gender','$phoneNumber','$Address')";
$flag =mysqli_query($con,$statment1);
if(!$flag){
    die("Eroor:".mysqli_error($con));
}
?>
<div id="Hader">
            <!--Head-->
            <h1>
                <img src="IMAGE/logo2.jpeg" alt="logo" width="100px">
                Freska Market
            </h1>
    </div>
    <br>
        <div id="fotter">
            <!--Title-->
            Welcome <?php 
            echo $fname,$lname;
            ?>
        </div>
        <br>
        <div id="body">
            <h1>You Can Login Now</h1>
            <h1>Go Login Page:<a href="Home_eng.html">Login!</a></h1>
        </div>

</body>
</html>