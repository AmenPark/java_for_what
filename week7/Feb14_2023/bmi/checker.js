/**
 * 
 */

function check() {
	var f = document.f;
	if (f.name.value == "") {
		alert("�̸��� �����");
		f.name.focus();
		return false;
	}
	if (isNaN(f.height.value) || f.height.value < 0) {
		alert("Ű�� �̻���");
		f.height.focus();
		return false;
	}
	if (f.height.value < 3) {
		alert("Ű�� cm����");
		f.height.focus();
		return false;
	}
	if (isNaN(f.weight.value)) {
		alert("�����԰� �̻���");
		f.weight.focus();
		return false;
	}
	if (f.weight.value <= 0) {
		alert("�����԰� 0 ������ �� ����");
		f.weight.focus();
		return false;
	}
	
	var fn = f.file.value.toLowerCase();
	if (!(fn.endsWith(".jpg")
		|| fn.endsWith(".png")
		|| fn.endsWith(".jpeg")
		|| fn.endsWith(".gif"))) {
		alert("������ �̻���");
		f.file.value = "";
		return false;
	}
	return true;
}