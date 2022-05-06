function validation(){
	var valid = true;
	formLabels = document.getElementsByTagName("label");
	var FirstName=document.regForm.firstname.value;
    var LastName=document.regForm.lastname.value;
    var Age=document.regForm.age.value;
    var PhoneNumber=document.regForm.phoneNumber.value;
    var Address=document.regForm.Address.value;
    var Email=document.regForm.email.value;
    var Password=document.regForm.password.value;
    var CPassword=document.regForm.cpassword.value;
    if(FirstName==""){
		formLabels[0].innerHTML="الاسم الاول    مطلوب";
		formLabels[0].style="color: red";
		valid = false;
	}
    else if( !isNaN(FirstName)){
		formLabels[0].innerHTML="الاسم الاول  نص فقط";
		formLabels[0].style="color: red";
		valid = false;
	}
    else {
		formLabels[0].innerHTML="الاسم :";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
	}
    if(LastName==""){
		formLabels[1].innerHTML="اسم العائلة مطلوب";
		formLabels[1].style="color: red";
		valid = false;
	}
	else if( !isNaN(LastName)){
		formLabels[1].innerHTML="اسم العائلة نص فقط";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[1].innerHTML="اسم العائلي";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
	}
    if(Age < 0 || Age > 100){
		formLabels[2].innerHTML="العمر يجب ان يكون بين 0 و 100";
		formLabels[2].style="color: red";
		valid = false;
	}
	else if( isNaN(Age)){
		formLabels[2].innerHTML="العمر يجب ان يكون ارقام";
		formLabels[2].style="color: red";
		valid = false;
	}
	else {
		formLabels[2].innerHTML="العمر";
		formLabels[2].style="color: black";
		valid = (valid) ? true : false;
	}
    if( isNaN(PhoneNumber)){
		formLabels[4].innerHTML="رقم الهاتف ارقام فقط";
		formLabels[4].style="color: red";
		valid = false;
	}
	else {
		formLabels[4].innerHTML="رقم الهاتف:";
		formLabels[4].style="color: black";
		valid = (valid) ? true : false;
	}
    if(Address==""){
		formLabels[5].innerHTML="العنوان مطلوب";
		formLabels[5].style="color: red";
		valid = false;
	}
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(Email==""){
		formLabels[6].innerHTML="البريد الالكتروني مطلوب";
		formLabels[6].style="color: red";
		valid = false;
	}
	else if(!re.test(Email)){
		formLabels[6].innerHTML="البريد الالكتروني غير صحيح";
		formLabels[6].style="color: red";
		valid = false;
	}
	else {
		formLabels[6].innerHTML="البريد الالكتروني";
		formLabels[6].style="color: black";
		valid = (valid) ? true : false;
	}
    if(Password == ""){
		formLabels[7].innerHTML="كلمة السر مطلوبة";
		formLabels[7].style="color: red";
		valid = false;
	}
	else if(Password.length < 8){
		formLabels[7].innerHTML="كلمة السر يجب ان تكون اكبر من 8";
		formLabels[7].style="color: red";
		valid = false;
	}
	else {
		formLabels[7].innerHTML="كلمة السر:";
		formLabels[7].style="color: black";
		valid = (valid) ? true : false;
	}

    if(CPassword == ""){
		formLabels[8].innerHTML="تاكيد كلمة السر مطلوبة";
		formLabels[8].style="color: red";
		valid = false;
	}
    else if(CPassword!=Password){
        formLabels[8].innerHTML="الكلمتان غير متطابقتان:";
		formLabels[8].style="color: Red";
		valid =  false;
    }

	else if(CPassword.length < 8){
		formLabels[8].innerHTML="يجب ان تكون اكبر من 8";
		formLabels[8].style="color: red";
		valid = false;
	}
	else {
		formLabels[8].innerHTML="تاكيد كلمة السر:";
		formLabels[8].style="color: black";
		valid = (valid) ? true : false;
	}
    
    



    return valid;
}

function clear2(){
	var myArray = new Array();
	myArray[0] = "الاسم:";
	myArray[1] = "اسم العائلي:";
	myArray[6] = "البريد الالكتروني:";
	myArray[7] = "كلمة السر:";
    myArray[8] = "تاكيد كلمة السر:";
	myArray[2] = "العمر:";
	myArray[4] = "رقم الهاتف:";
    myArray[5] = "العنوان:";
    myArray[3] = "الجنس";
	for(var i=0 ; i < myArray.length ; i++){
		formLabels[i].innerHTML = myArray[i];
		formLabels[i].style = "color: black";
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

