<?php
session_start();
if (!isset($_SESSION["loggedUser"])) {
    header('Location:Home_eng.html');
}
?>
<!DOCTYPE html>
<head>
    <Title>Freska Market</Title>
    <link rel="stylesheet" type="text/css" href="CSS/adminPage.css">
    <link rel="shortcut icon"  href="IMAGE/logo.jpeg">
</head>
<body>
<?php
    include "config.php";
    $email = $_SESSION["loggedUser"];
    $veiwuser = "SELECT * FROM `admin` WHERE `Email` LIKE '$email'";
    $result = mysqli_query($con, $veiwuser);
    if (!$result) {
        echo "Error" . mysqli_error($con);
    }
    $row = mysqli_fetch_array($result);
    $FirstName=$row['First Name'];
    $LastName=$row['Last Name'];
    $Email=$row['Email'];
    $Password=$row['Password'];
    ?>
    <div dir="rtl" lang="ar"><!--Page-->
        <div id="Hader"><!--Header-->
            <h1>
            <img src="IMAGE/logo2.jpeg" alt="logo" width="100px">
         فريسكا ماركت
            </h1>
        </div>
        <br>
        <div class="topnav" id="myTopnav">
            <a href="logout_admin.php" class="active">الصفحة الرئيسية</a>
            <a href="logout_admin.php">تسجيل الخروج</a>
            <a href="ChangePassword_admin_arb.php">تغير كلمة السر</a>
            <a href="conver_admin_arb.php">ENG</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <br>
        <div id="body"> <!--Body-->
            <p>
                <img src="IMAGE/admin.jpeg" width="150px">
                <br>
                اهلا:
                <?php
                echo $FirstName;
                ?>
                <br><br>
                الاسم:
                <?php
                echo $FirstName,$LastName;
                ?>
                <br><br>
                البريد الاكتروني:
                <?php
                echo $Email;
                ?>
            </p>
            <p>
            <a href="Signup_employee_arb.html"><button>اضافة موظف جديد</button></a>
            <a href="Additem_arb.html"><button>اضافة منتج جديد</button></a>
            <a href="Signup_admin_arb.html"><button>اضافة مسؤول جديد</button></a>
            </p>
        </div>
    </div>
</body>
</html>