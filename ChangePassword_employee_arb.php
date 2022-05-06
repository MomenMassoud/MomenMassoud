<?php
session_start();
if (!isset($_SESSION["loggedUser"])) {
    header('Location:Home_eng.html');
}
?>
<!DOCTYPE html>
<head>
    <Title>Freska Market</Title>
    <link rel="stylesheet" type="text/css" href="CSS/ChangePass_employee.css">
    <link rel="shortcut icon"  href="IMAGE/logo.jpeg">
    <script src="changepasswordemployee_arb.js"></script>
</head>
<body>
<?php
    $email = $_SESSION["loggedUser"];
    ?>
    <div dir="rtl" lang="ar"><!--Page-->
        <div id="Hader"><!--Header-->
            <h1>
                <img src="IMAGE/logo2.jpeg" alt="logo" width="150px">
                فريسكا ماركت
            </h1>
        </div>
        <br>
        <div class="topnav" id="myTopnav">
            <a href="EmployeePage_arb.html" class="active">الصفحة الرئيسية</a>
            <a href="EmployeePage_arb.html">العودة</a>
            <a href="ChangePassword_employee_eng.html">ENG</a>
            <a href="Home_arb.html">تسجيل الخروج</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <br>
        <div id="fotter"><!--Fotter-->
            <tfoot>تغير كلمة السر</tfoot>
        </div>
        <div id="body"><!--body-->
            <form onsubmit="return validation()" method="post" name="regForm">
            <img src="IMAGE/employee.jpeg" width="110px">
            <br><br>
                <label>أدخل كلمة السر الحالية:</label>
                <input type="password" name="password"  placeholder="ادخل كلمة السر الحالية:">
                <br><br>
                <label>كلمة السر الجديدة:</label>
                <input type="password" name="Npassword"   placeholder="ادخل كلمة السر الجديدة:">
                <br><br>
                <label> تاكيد كلمة السر الجديدة:</label>
                <input type="password" name="npassword"   placeholder="تاكيد كلمة السر الجديدة:">
                <br><br>
                <input type="submit" value="حفظ البيانات:">
                <input type="reset" value="حذف البيانات" onclick="clear2();">
            </form>
        </div>
</body>
</html>