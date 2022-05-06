function login(){
    var valid = true;
	formLabels = document.getElementsByTagName("label");
    var username = document.regForm.username.value;
    var password = document.regForm.password.value;
    if(username==""){
        formLabels[0].innerHTML="User Name: [Required]";
		formLabels[0].style="color: red";
		valid = false;
    }
    else if( !isNaN(username)){
		formLabels[0].innerHTML="User Name: [Text Only]";
		formLabels[0].style="color: red";
		valid = false;
	}
    else {
		formLabels[0].innerHTML="user Name:";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
	}
    if(password == ""){
		formLabels[1].innerHTML="Password: [Required]";
		formLabels[1].style="color: red";
		valid = false;
	}
	else if(password.length < 8){
		formLabels[1].innerHTML="Password: [Must be > 8]";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[7].innerHTML="Password:";
		formLabels[7].style="color: black";
		valid = (valid) ? true : false;
	}
    if(username == "user" && password == "12345"){
        window.location.href = "Shopping_eng.html";
    }
    else {
        alert("wrong login");
    }
    return valid;
}
function clear2(){
	var myArray = new Array();
	myArray[0] = "User Name:";
	myArray[1] = "Password:";
	for(var i=0 ; i < myArray.length ; i++){
		formLabels[i].innerHTML = myArray[i];
		formLabels[i].style = "color: black";
	}
}
function openMenu(){
	var menu = document.getElementById("sideMenu");
	menu.style.width = "250px";
}

function closeMenu(){
	var menu = document.getElementById("sideMenu");
	menu.style.width = "0";
}
function myFunction() {
	var x = document.getElementById("myTopnav");
	if (x.className === "topnav") {
	  x.className += " responsive";
	} else {
	  x.className = "topnav";
	}
  }