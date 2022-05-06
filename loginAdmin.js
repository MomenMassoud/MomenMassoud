function login(){
    var username = document.loginForm.email.value;
    var password = document.loginForm.password.value;
    
    if(username == "Admin" && password == "admin"){
        window.location.href = "Adminpage_eng.html";
    }
    else {
        alert("wrong login");
    }
}
function myFunction() {
	var x = document.getElementById("myTopnav");
	if (x.className === "topnav") {
	  x.className += " responsive";
	} else {
	  x.className = "topnav";
	}
  }
