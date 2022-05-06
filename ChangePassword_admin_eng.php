<?php
session_start();
if(!isset($_SESSION["loggedUser"])){
    header('Location:Home_eng.html');
}
?>
<!DOCTYPE html>
<head>
    <Title>Freska Market</Title>
    <link rel="stylesheet" type="text/css" href="CSS/ChangePass_admin.css">
    <link rel="shortcut icon"  href="IMAGE/logo.jpeg">
    <script src="changepasswordAdmin.js"></script>
</head>
<body>
<?php
    $email = $_SESSION["loggedUser"];
    ?>
    <div><!--Page-->
        <div id="Hader"><!--Header-->
            <h1>
                <img src="IMAGE/logo2.jpeg" alt="logo" width="150px">
                Freska Market
                <a href="Adminpage_eng.php"><input type="button" name="back" value="Back"></a>
                <a href="convertchangepass_admin.php"><input type="button" name="arb" value="Arabic"></a>
            </h1>
        </div>
        <div id="fotter"><!--Fotter-->
            <tfoot>Change Password</tfoot>
        </div>
        <div id="body"><!--body-->
            <form onsubmit="return validation()" method="post" name="regForm" action="changepass_admin.php">
            <img src="IMAGE/admin.jpeg" width="110px">
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