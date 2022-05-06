function validation(){
	var valid = true;
	formLabels = document.getElementsByTagName("label");
    var currentPassword=document.regForm.password.value;
    var newPassword=document.regForm.Npassword.value;
    var ConfirmPass=document.regForm.npassword.value;
    if(currentPassword == ""){
		formLabels[0].innerHTML="New Password: [Required]";
		formLabels[0].style="color: red";
		valid = false;
	}
    else{
        formLabels[0].innerHTML="Current Password:";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
    }
    if(newPassword == ""){
		formLabels[1].innerHTML="New Password: [Required]";
		formLabels[1].style="color: red";
		valid = false;
	}
	else if(newPassword.length < 8){
		formLabels[1].innerHTML="New Password: [Must be > 8]";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[1].innerHTML="New Password:";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
	}
    if(ConfirmPass == ""){
		formLabels[2].innerHTML="Confirm New Password: [Required]";
		formLabels[2].style="color: red";
		valid = false;
	}
	else if(ConfirmPass.length < 8){
		formLabels[2].innerHTML="Confirm New Password: [Must be > 8]";
		formLabels[2].style="color: red";
		valid = false;
	}
    else {
		formLabels[2].innerHTML="Confirm New Password:";
		formLabels[2].style="color: black";
		valid = (valid) ? true : false;
	}
    if(ConfirmPass==newPassword){
        formLabels[1].innerHTML="New Password:";
		formLabels[1].style="color: black";
        formLabels[2].innerHTML="Confirm New Password:";
		formLabels[2].style="color: black";
		valid = (valid) ? true : false;
    }
    else{
        formLabels[2].innerHTML="Both Password Not Equl!";
		formLabels[2].style="color: red";
		valid = false;
    }
    if(currentPassword==newPassword){
        formLabels[1].innerHTML="The Current Password Equl New Password";
		formLabels[1].style="color: red";
		valid = false;
    }
    else{
        formLabels[0].innerHTML="Current Password:";
		formLabels[0].style="color: black";
        formLabels[1].innerHTML="New Password:";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
    }
    return valid;
}
function clear2(){
	var myArray = new Array();
	myArray[0] = "Current Password:";
	myArray[1] = "New Password:";
	myArray[2] = "Confirm New Password:";
	for(var i=0 ; i < myArray.length ; i++){
		formLabels[i].innerHTML = myArray[i];
		formLabels[i].style = "color: black";
	}
}