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
    <div   dir="rtl" lang="ar"><!--Page-->
        <div id="Hader"><!--Head-->
            <img name="slide" src="IMAGE/logo2.jpeg" width="130px">
            فريسكاسوبرماركت
        </div>
        <br>
        <div class="topnav" id="myTopnav">
            <a href="Shopping_arb.php" class="active">الصفحة الرئيسية</a>
            <a href="ChangePassword_user_arb.php">تغير كلمة السر</a>
            <a href="logout_user.php">تسجيل الخروج</a>
            <a href="Shopping_eng.php">ENG</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <br>
        <div class="body"><!--Title-->
            <p>اهلا 
            <?php
                echo $FirstName,$LastName;
                ?>
            </p>
            <p>يمكنكم التسوق من هنا</p>
        </div>
        <div><!--Body-->
            <div >
                <!--Body-->
                <div class="fotter">
                    <p class="rr"> المشروبات</p>
                    <img name="juice" src="image/coca_large.jpg" width="180 px">&nbsp; &nbsp;
                    <a class="prev"  onclick="prev()">&#10094;</a>
                    <a class="next" onclick="next()">&#10095;</a>
                </div>
                <div class="fotter">
                    <p class="rr">مكسرات</p>
                    <img name="snaks" src="image/kajoo.jpg" width="150 px">&nbsp; &nbsp;
                    <a class="prev" onclick="prev2()">&#10094;</a>
                    <a class="next" onclick="next2()">&#10095;</a>
                </div>
                <div class="fotter">
                    <p class="rr"> شيبس</p>
                    <img name="foods" src="image/doredos.jpg" width="150 px">&nbsp; &nbsp;
                    <a class="prev" onclick="prev3()">&#10094;</a>
                    <a class="next" onclick="next3()">&#10095;</a>
                </div>
                <div class="body">التكلفة
                    <a href="cost_arb.html"> <input type="button" name="cost" value="التكلفة النهائية"></a>
                </div>
            </div>
    </div>
</body>
</html>
