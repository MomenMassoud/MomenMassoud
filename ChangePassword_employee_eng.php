<?php
session_start();
if (!isset($_SESSION["loggedUser"])) {
    header('Location:Home_eng.html');
}
?>
<!DOCTYPE html>
<head>
    Title>Freska Market</Title>
    <link rel="stylesheet" type="text/css" href="CSS/ChangePass_user.css">
    <link rel="shortcut icon"  href="IMAGE/logo.jpeg">
    <script src="changepasswordemployee.js"></script>
</head>
<body>
    <?php
    $email = $_SESSION["loggedUser"];
    ?>
    <div><!--Page-->
        <div id="Hader"><!--Header-->
            <h1>
                <img src="IMAGE/logo2.jpeg" alt="logo" width="150px">
                فريسكا سوبرماركت
            </h1>
        </div>
        <br>
        <div class="topnav" id="myTopnav">
            <a href="EmployeePage_eng.html" class="active">Home</a>
            <a href="EmployeePage_eng.html">Back</a>
            <a href="ChangePassword_employee_arb.html">ENG</a>
            <a href="Home_eng.html">Log Out</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <br>
        <div id="fotter"><!--Fotter-->
            <tfoot>Change Password</tfoot>
        </div>
        <div id="body"><!--body-->
            <form onsubmit="return validation()" method="post" name="regForm">
            <img src="IMAGE/employee.jpeg" width="110px">
            <br><br>
                <label>Enter Password:</label>
                <input type="password" name="password"  placeholder="Enter Passwprd:" >
                <br><br>
                <label>New Password:</label>
                <input type="password" name="Npassword"   placeholder="Enter New Password:">
                <br><br>
                <label> Confirm New Password:</label>
                <input type="password" name="npassword"   placeholder="Confirm New Password:">
                <br><br>
                <input type="submit" value="Save">
                <input type="reset" value="Clear" onclick="clear2();">
            </form>
        </div>
</body>
</html>