<!DOCTYPE html>
<html>
<head>
    <title>Freska Market</title>
    <link rel="stylesheet" type="text/css" href="CSS/AddIteams.css">
    <link rel="shortcut icon" href="IMAGE/logo.jpeg">
</head>
<body>
<?php
$firstname=$_POST['firstname'];
$lastname=$_POST['lastname'];
$age=$_POST['age'];
$phoneNumber=$_POST['phoneNumber'];
$Address=$_POST['Address'];
$email=$_POST['email'];
$password=$_POST['password'];
$salary=$_POST['salary'];
$Barnch=$_POST['Barnch'];
$NationalID=$_POST['NationalID'];
$gender='Male';
$con=mysqli_connect("localhost:3307","root","") or die("Error We Not Found Server!") ;
$db=mysqli_select_db($con,"freska");
$query="INSERT INTO `admin` ( `First Name`, `Last Name`, `Age`, `Gender`, `PhoneNamber`, `Address`, `Email`, `Password`, `Salary`, `Branch`, `National ID`) VALUES ('$firstname', '$lastname', '$age', '$gender', '$phoneNumber', '$Address', '$email', '$password', '$salary', '$Barnch', '$NationalID')";
$result=mysqli_query($con,$query);
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
            <img src="IMAGE/admin.jpeg" width="100px">
        </div>
        <br>
        <div id="body">
            <h1>You Can Login Now</h1>
            <h1>Go Login Page:<a href="Login_admin_eng.html">Login!</a></h1>
        </div>

</body>
</html>