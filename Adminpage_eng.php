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
    <link rel="shortcut icon" href="IMAGE/logo.jpeg">
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
    <div>
        <!--Page-->
        <div id="Hader">
            <!--Header-->
            <h1>
                <img src="IMAGE/logo2.jpeg" alt="logo" width="100px">
                Freska Market
            </h1>
        </div>
        <br>
        <div class="topnav" id="myTopnav">
            <a href="logout_admin.php" class="active">Home</a>
            <a href="logout_admin.php">Log Out</a>
            <a href="ChangePassword_admin_eng.php">Change Password</a>
            <a href="conver_admin.php">Arabic</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <br>
        <div id="body">
            <!--Body-->
            <p>
                <img src="IMAGE/admin.jpeg" width="150px">
                <br>
                Welcome :
                <?php
                echo $FirstName;
                ?>
                <br><br>
                Name:
                <?php
                echo $FirstName,$LastName;
                ?>
                <br><br>
                Email:
                <?php
                echo $Email;
                ?>
            </p>
            <p>
                <a href="Signup_employee_eng.html"><button>ADD Employee</button></a>
                <a href="Additem_eng.html"><button>Add Items</button></a>
                <a href="Signup_admin_eng.html"><button>Add Admin</button></a>
            </p>
        </div>
    </div>
</body>

</html>