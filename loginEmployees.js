function login(){
    var username = document.loginForm.email.value;
    var password = document.loginForm.password.value;
    
    if(username == "Momen" && password == "12345"){
        window.location.href = "EmployeePage_eng.html";
    }
    else {
        alert("wrong login");
    }
}