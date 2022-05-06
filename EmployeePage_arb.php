<?php
session_start();
if (!isset($_SESSION["loggedUser"])) {
    header('Location:Home_eng.html');
}
?>
<!DOCTYPE html>
<html>
    <head>
      <title>Freska Market</title>
      <link rel="shortcut icon" href="IMAGE/logo.jpeg" />
      <link rel="stylesheet" type="text/css" href="CSS/Employeepage.css">
    </head>
    <body>
    <?php
    include "config.php";
    $email = $_SESSION["loggedUser"];
    $veiwuser = "SELECT * FROM `employee` WHERE `Email` LIKE '$email'";
    $result = mysqli_query($con, $veiwuser);
    if (!$result) {
        echo "Error" . mysqli_error($con);
    }
    $row = mysqli_fetch_array($result);
    $FirstName=$row['First Name'];
    $LastName=$row['Last Name'];
    $Email =$row['Email'];
    ?>
        <div dir="rtl" lang="ar">
        <div id="Hader">
            <img src="IMAGE/logo2.jpeg" width="130px">
            فريسكا ماركت
        </div>
        <br>
        <div class="topnav" id="myTopnav">
            <a href="EmployeePage_arb.php" class="active">الصفحة الرئيسية</a>
            <a href="ChangePassword_employee_arb.php">تغير كلمة السر</a>
            <a href="EmployeePage_eng.php">ENG</a>
            <a href="logout_admin.php">تسجيل الخروج</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <br>
        <div class="body"><!--Title-->
            <h1>مرحبا: 
            <?php
                echo $FirstName,$LastName;
                ?>
            </h1>
        </div>
        <div class="body"><!--Title-->
            <h1>عمليات التوصيل التي يجب توصيلها</h1>
        </div>
      <div class="body">
          <div>
              <p>اسم العميل:#################
                  <br>
                  العنوان:#####################
                  <br>
                  رقم الهاتف:#################
                  <br>
              </p>
          </div>
        <div>
<div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=egypt&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://putlocker-is.org"></a><br><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}</style><a href="https://www.embedgooglemap.net">inserting google maps</a><style>.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style></div></div>
</div>  
</div>
</div>
    </body>
</html>
