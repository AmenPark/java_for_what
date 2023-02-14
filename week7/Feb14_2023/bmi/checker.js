/**
 * 
 */

function check() {
	var f = document.f;
	if (f.name.value == "") {
		alert("이름이 비었음");
		f.name.focus();
		return false;
	}
	if (isNaN(f.height.value) || f.height.value < 0) {
		alert("키가 이상함");
		f.height.focus();
		return false;
	}
	if (f.height.value < 3) {
		alert("키는 cm단위");
		f.height.focus();
		return false;
	}
	if (isNaN(f.weight.value)) {
		alert("몸무게가 이상함");
		f.weight.focus();
		return false;
	}
	if (f.weight.value <= 0) {
		alert("몸무게가 0 이하일 수 없음");
		f.weight.focus();
		return false;
	}
	
	var fn = f.file.value.toLowerCase();
	if (!(fn.endsWith(".jpg")
		|| fn.endsWith(".png")
		|| fn.endsWith(".jpeg")
		|| fn.endsWith(".gif"))) {
		alert("파일이 이상함");
		f.file.value = "";
		return false;
	}
	return true;
}