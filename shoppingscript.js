var i = 0;
var k = 0;
var j = 0;
image = [];
imagee = [];
imageee = [];
image[0] = 'IMAGE/juhayna.jpg';
image[1] = 'IMAGE/coca_large.jpg';
image[2] = 'IMAGE/coca.jpeg';

imagee[0] = 'IMAGE/kajoo.jpg';
imagee[1] = 'IMAGE/sourry.jpg';
imagee[2] = 'IMAGE/louz.jpg';
imagee[3] = 'IMAGE/fsd2.jpg';

imageee[0] = 'IMAGE/doredos.jpg';
imageee[1] = 'IMAGE/breaks.png';
imageee[2] = 'IMAGE/bekrolz.jpg';
imageee[3] = 'IMAGE/shabsy.jpg';

function next(){
	if(i != 2){
		i++;
	}
	else {
		i = 0;
	}
	document.juice.src=image[i];
}
function prev(){
	if(i != 0){
		i--;
	}
	else {
		i = 2;
	}
	document.juice.src=image[i];
}
window.onload=next;
window.onload=prev;
function next2(){
	if(j != 3){
		j++;
	}
	else {
		j = 0;
	}
	document.snaks.src=imagee[j];
}
function prev2(){
	if(j != 0){
		j--;
	}
	else {
		j = 3;
	}
	document.snaks.src=imagee[j];
}
window.onload=next2;
window.onload=prev2;


function next3(){
	if(k != 2){
		k++;
	}
	else {
		k = 0;
	}
	document.foods.src=imageee[k];
}
function prev3(){
	if(k != 0){
		k--;
	}
	else {
		k = 2;
	}
	document.foods.src=imageee[k];
}
window.onload=next3;
window.onload=prev3;
