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
    var Salary=document.regForm.salary.value;
    var Barnch=document.regForm.Barnch.value;
    var NaID=document.regForm.NationalID.value;
    if(FirstName==""){
		formLabels[0].innerHTML="First Name: [Required]";
		formLabels[0].style="color: red";
		valid = false;
	}
    else if( !isNaN(FirstName)){
		formLabels[0].innerHTML="First Name: [Text Only]";
		formLabels[0].style="color: red";
		valid = false;
	}
    else {
		formLabels[0].innerHTML="First Name:";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
	}
    if(LastName==""){
		formLabels[1].innerHTML="Last Name: [Required]";
		formLabels[1].style="color: red";
		valid = false;
	}
	else if( !isNaN(LastName)){
		formLabels[1].innerHTML="Last Name: [Text Only]";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[1].innerHTML="Last Name:";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
	}
    if(Age < 0 || Age > 100){
		formLabels[2].innerHTML="Age: [Must be between 0 and 100]";
		formLabels[2].style="color: red";
		valid = false;
	}
	else if( isNaN(Age)){
		formLabels[2].innerHTML="Age: [Age must be a number]";
		formLabels[2].style="color: red";
		valid = false;
	}
	else {
		formLabels[2].innerHTML="Age:";
		formLabels[2].style="color: black";
		valid = (valid) ? true : false;
	}
    if( isNaN(PhoneNumber)){
		formLabels[4].innerHTML="Mobile: [Numbers Only]";
		formLabels[4].style="color: red";
		valid = false;
	}
	else {
		formLabels[4].innerHTML="Phone Number:";
		formLabels[4].style="color: black";
		valid = (valid) ? true : false;
	}
    if(Address==""){
		formLabels[5].innerHTML="Address: [Required]";
		formLabels[5].style="color: red";
		valid = false;
	}
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(Email==""){
		formLabels[6].innerHTML="Email: [Required]";
		formLabels[6].style="color: red";
		valid = false;
	}
	else if(!re.test(Email)){
		formLabels[6].innerHTML="Email: [Incorrect Email]";
		formLabels[6].style="color: red";
		valid = false;
	}
	else {
		formLabels[6].innerHTML="Email:";
		formLabels[6].style="color: black";
		valid = (valid) ? true : false;
	}
    if(Password == ""){
		formLabels[7].innerHTML="Password: [Required]";
		formLabels[7].style="color: red";
		valid = false;
	}
	else if(Password.length < 8){
		formLabels[7].innerHTML="Password: [Must be > 8]";
		formLabels[7].style="color: red";
		valid = false;
	}
	else {
		formLabels[7].innerHTML="Password:";
		formLabels[7].style="color: black";
		valid = (valid) ? true : false;
	}

    if(CPassword == ""){
		formLabels[8].innerHTML="Password: [Required]";
		formLabels[8].style="color: red";
		valid = false;
	}
	else if(CPassword.length < 8){
		formLabels[8].innerHTML="Password: [Must be > 8]";
		formLabels[8].style="color: red";
		valid = false;
	}
	else {
		formLabels[8].innerHTML="Password:";
		formLabels[8].style="color: black";
		valid = (valid) ? true : false;
	}
    if(CPassword==Password){
        formLabels[7].innerHTML="Password:";
		formLabels[7].style="color: black";
        formLabels[8].innerHTML="Password:";
		formLabels[8].style="color: black";
		valid = (valid) ? true : false;
    }
    else{
        formLabels[8].innerHTML="Password And Confirm Passowrd Not Equl";
		formLabels[8].style="color: Red";
		valid =  false;
    }
    if( isNaN(Salary)){
		formLabels[9].innerHTML="Salary: [Numbers Only]";
		formLabels[9].style="color: red";
		valid = false;
	}
	else {
		formLabels[9].innerHTML="Salary:";
		formLabels[9].style="color: black";
		valid = (valid) ? true : false;
	}
    if(Barnch==""){
		formLabels[10].innerHTML="Branch: [Required]";
		formLabels[10].style="color: red";
		valid = false;
	}
    else if( !isNaN(Barnch)){
		formLabels[10].innerHTML="Branch: [Text Only]";
		formLabels[10].style="color: red";
		valid = false;
	}
    else {
		formLabels[10].innerHTML="Branch:";
		formLabels[10].style="color: black";
		valid = (valid) ? true : false;
	}
    if( isNaN(NaID)){
		formLabels[11].innerHTML="National ID: [Numbers Only]";
		formLabels[11].style="color: red";
		valid = false;
	}
	else {
		formLabels[11].innerHTML="National ID:";
		formLabels[11].style="color: black";
		valid = (valid) ? true : false;
	}



    return valid;
}

function clear2(){
	var myArray = new Array();
	myArray[0] = "First Name:";
	myArray[1] = "Last Name: *";
	myArray[6] = "Email: *";
	myArray[7] = "Password: *";
    myArray[8] = "Confirm Password: *";
	myArray[2] = "Age:";
	myArray[4] = "Phone Number:";
    myArray[5] = "Address:";
    myArray[10] = "Branch:";
    myArray[11] = "National ID:";
    myArray[9] = "Salary:";
    myArray[3]="Gender:";
	for(var i=0 ; i < myArray.length ; i++){
		formLabels[i].innerHTML = myArray[i];
		formLabels[i].style = "color: black";
	}
}

