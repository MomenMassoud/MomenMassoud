function validation(){
	var valid = true;
    formLabels = document.getElementsByTagName("label");
    var name=document.regForm.name.value;
    var price=document.regForm.price.value;
    if(name==""){
		formLabels[0].innerHTML=" اسم المنتج مطلوب";
		formLabels[0].style="color: red";
		valid = false;
	}
    else if( !isNaN(name)){
		formLabels[0].innerHTML="اسم المنتج نص فقط";
		formLabels[0].style="color: red";
		valid = false;
	}
    else {
		formLabels[0].innerHTML="اسم المنتج:";
		formLabels[0].style="color: black";
		valid = (valid) ? true : false;
	}
    if( isNaN(price)){
		formLabels[1].innerHTML="سعر المنتج ارقام فقط:";
		formLabels[1].style="color: red";
		valid = false;
	}
	else {
		formLabels[1].innerHTML="سعر المنتج:";
		formLabels[1].style="color: black";
		valid = (valid) ? true : false;
	}
    return valid;
}
function clear2(){
	var myArray = new Array();
	myArray[0] = "اسم المنتج:";
	myArray[1] = "سعر المنتج:";
	for(var i=0 ; i < myArray.length ; i++){
		formLabels[i].innerHTML = myArray[i];
		formLabels[i].style = "color: black";
	}
}
