/**EUC-KR
 * 
 */


var s = "�׽�Ʈ�빮��";
alert(s.startsWith("�׽�Ʈ"));


function valcheck() {
	var f = document.form;
	var age = f.age.value;
	if (!f.id.value){
		alert("id is empty!");
		f.id.focus();
		return false;
	}
	if(!f.pw.value){
		alert("pw is empty!");
		f.pw.focus();
		return false;
	}
	if(f.pw.value.length<5){
		alert("�н����� �ʹ� ª��(5�ڹ̸�)");
		f.pw.focus();
		return false;
	}
	
	if(f.pw.value!=f.pw2.value){
		alert("�н����尡 �ٸ��ϴ�");
		f.pw.focus();
		return false;
	}
	
	if(age<1 & age>130){
		alert("���̰� �̻���");
		f.age.value="";
		return false;
	}
	if(isNaN(age)){		
		alert("���̰� ������");
		f.age.value="";
		return false;
	}
	
	return true;
}


function al(){
	var ages = document.form.age.value;
	alert(ages>1)
}

function testfunc(){
		
}

