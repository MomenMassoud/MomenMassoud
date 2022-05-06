function validation(){
	var valid = true;
	formLabels = document.getElementsByTagName("label");
    var currentPassword=document.regForm.password.value;
    var newPassword=document.regForm.Npassword.value;
    var ConfirmPass=document.regForm.npassword.value;
    if(currentPassword == ""){
		formLabels[0].innerHTML="كلمة السر الحالية مطلوبة:";
		formLabels[0].style="color: red";
		valid = false;
	}
    else{
        formLabels[0].innerHTML="كلمة السر الحالية:";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
    }
    if(newPassword == ""){
		formLabels[1].innerHTML="كلمة السر الجديدة مطلوبة:";
		formLabels[1].style="color: red";
		valid = false;
	}
	else if(newPassword.length < 8){
		formLabels[1].innerHTML="كلمة السر اقل من 8:";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[1].innerHTML="كلمة السر الجديدة:";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
	}
    if(ConfirmPass == ""){
		formLabels[2].innerHTML="كلمة السر مطلوبة:";
		formLabels[2].style="color: red";
		valid = false;
	}
	else if(ConfirmPass.length < 8){
		formLabels[2].innerHTML="كلمة السر اقل من 8:";
		formLabels[2].style="color: red";
		valid = false;
	}
    else {
		formLabels[2].innerHTML="تاكيد كلمة السر:";
		formLabels[2].style="color: black";
		valid = (valid) ? true : false;
	}
    if(ConfirmPass==newPassword){
        formLabels[1].innerHTML="كلمة السر الجديدة:";
		formLabels[1].style="color: black";
        formLabels[2].innerHTML="تاكيد كلمة السر:";
		formLabels[2].style="color: black";
		valid = (valid) ? true : false;
    }
    else{
        formLabels[2].innerHTML="الكلمتان غير متطابقتان:";
		formLabels[2].style="color: red";
		valid = false;
    }
    if(currentPassword==newPassword){
        formLabels[1].innerHTML="كلمة السر الحالية و الجديدة متطابقتان:";
		formLabels[1].style="color: red";
		valid = false;
    }
    else{
        formLabels[0].innerHTML="كلمة السر الحالية:";
		formLabels[0].style="color: black";
        formLabels[1].innerHTML="كلمة السر الجديدة:";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
    }
    return valid;
}
function clear2(){
	var myArray = new Array();
	myArray[0] = "ادخل كلمة السر الحالية:";
	myArray[1] = "كلمة السر الجديدة:";
	myArray[2] = "تاكيد كلمة السر:";
	for(var i=0 ; i < myArray.length ; i++){
		formLabels[i].innerHTML = myArray[i];
		formLabels[i].style = "color: black";
	}
}