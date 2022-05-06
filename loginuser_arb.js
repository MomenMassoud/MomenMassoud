function login(){
    var valid = true;
	formLabels = document.getElementsByTagName("label");
    var username = document.regForm.username.value;
    var password = document.regForm.password.value;
    if(username==""){
        formLabels[0].innerHTML="اسم المستخدم مطلوب:";
		formLabels[0].style="color: red";
		valid = false;
    }
    else if( !isNaN(username)){
		formLabels[0].innerHTML="اسم المستخدم نص فقط:";
		formLabels[0].style="color: red";
		valid = false;
	}
    else {
		formLabels[0].innerHTML="اسم المستخدم:";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
	}
    if(password == ""){
		formLabels[1].innerHTML="كلمة السر مطلوبة:";
		formLabels[1].style="color: red";
		valid = false;
	}
	else if(password.length < 8){
		formLabels[1].innerHTML="كلمة السر اقل من 8:";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[7].innerHTML="كلمة السر:";
		formLabels[7].style="color: black";
		valid = (valid) ? true : false;
	}
    if(username == "user" && password == "12345"){
        window.location.href = "Shopping_arb.html";
    }
    else {
        alert("كلمة السر اة اسم المستخدم خطاء");
    }
    return valid;
}
function clear2(){
	var myArray = new Array();
	myArray[0] = "اسم المستخدم:";
	myArray[1] = "كلمة السر:";
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