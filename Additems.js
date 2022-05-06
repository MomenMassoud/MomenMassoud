function validation(){
	var valid = true;
    formLabels = document.getElementsByTagName("label");
    var name=document.regForm.name.value;
    var price=document.regForm.price.value;
    if(name==""){
		formLabels[0].innerHTML=" Name of Item: [Required]";
		formLabels[0].style="color: red";
		valid = false;
	}
    else if( !isNaN(name)){
		formLabels[0].innerHTML="Name of Item: [Text Only]";
		formLabels[0].style="color: red";
		valid = false;
	}
    else {
		formLabels[0].innerHTML="Name of Item:";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
	}
    if( isNaN(price)){
		formLabels[1].innerHTML="Price:[price: must be a number]";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[1].innerHTML="Price of Item:";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
	}
    return valid;
}
function clear2(){
	var myArray = new Array();
	myArray[0] = "Name Of Item:";
	myArray[1] = "Price of Item:";
	for(var i=0 ; i < myArray.length ; i++){
		formLabels[i].innerHTML = myArray[i];
		formLabels[i].style = "color: black";
	}
}
