/**EUC-KR
 * 
 */


var s = "테스트용문자";
alert(s.startsWith("테스트"));


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
		alert("패스워드 너무 짧음(5자미만)");
		f.pw.focus();
		return false;
	}
	
	if(f.pw.value!=f.pw2.value){
		alert("패스워드가 다릅니다");
		f.pw.focus();
		return false;
	}
	
	if(age<1 & age>130){
		alert("나이가 이상함");
		f.age.value="";
		return false;
	}
	if(isNaN(age)){		
		alert("나이가 문자임");
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

