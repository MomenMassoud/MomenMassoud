<?php
session_start();
if(!isset($_SESSION["loggedUser"])){
    header('Location:Home_eng.html');
}
?>
<!DOCTYPE html>
<head>
    <title>Freska Market</title>
    <link rel="stylesheet" type="text/css" href="CSS/shopping.css">
    <link rel="shortcut icon" href="IMAGE/logo.jpeg" />
    <script src="shoppingscript.js"></script>
</head>

<body>
    <?php
    include "config.php";
    $email=$_SESSION["loggedUser"];
    $veiwuser="SELECT * FROM `user` WHERE `Email` LIKE '$email'";
    $result=mysqli_query($con,$veiwuser);
    if(!$result){
        echo "Error".mysqli_error($con);
    }
    $row=mysqli_fetch_array($result);
    $FirstName=$row['First Name'];
    $LastName=$row["Last Name"];
    $Age=$row["Age"];
    $Email=$row["Email"];
    $Password=$row["Password"];
    $Gender=$row["Gender"];
    $PhoneNumber=$row["PhoneNumber"];
    $Address=$row["Address"];
    
    ?>
    <div>
        <!--Page-->
        <div id="Hader">
            <!--Head-->
            <img name="slide" src="IMAGE/logo2.jpeg" width="130px">
            FreskaMarket

        </div>
        <br>
        <div class="topnav" id="myTopnav">
            <a href="Shopping_eng.html" class="active">Home</a>
            <a href="ChangePassword_user_eng.php">Change Password</a>
            <a href="logout_user.php">Log Out</a>
            <a href="convertLanguage.php">Arabic</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <br>
        <div class="body">
            <!--Title-->
            <p>Welcome:
                <?php
                echo $FirstName,$LastName;
                ?>
            </p>
            <p>You Can Shopping From Here</p>
        </div>
        <div >
            <!--Body-->
            <div class="fotter">
                <p class="rr"> drinks:</p>
                <img name="juice" src="image/coca_large.jpg" width="180 px">&nbsp; &nbsp;
                <a class="prev"  onclick="prev()">&#10094;</a>
                <a class="next" onclick="next()">&#10095;</a>
            </div>
            <div class="fotter">
                <p class="rr"> NUTS:</p>
                <img name="snaks" src="image/kajoo.jpg" width="150 px">&nbsp; &nbsp;
                <a class="prev" onclick="prev2()">&#10094;</a>
                <a class="next" onclick="next2()">&#10095;</a>
            </div>
            <div class="fotter">
                <p class="rr"> candies:</p>
                <img name="foods" src="image/doredos.jpg" width="150 px">&nbsp; &nbsp;
                <a class="prev" onclick="prev3()">&#10094;</a>
                <a class="next" onclick="next3()">&#10095;</a>
            </div>
            <div class="body">cost
                <a href="cost_eng.html"> <input type="button" name="cost" value="Final Cost"></a>
            </div>
        </div>
    </div>
</body>

</html>