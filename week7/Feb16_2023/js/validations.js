/**
 * 
 */

function lengthis(input, k){
	if(input.value.length==k){
		return true;
	}
	return false;
}

function isNum(val){
	if(isNaN(val)){
		return false;
	}
	return true;
}

function hasSameNum(input){
	var arr=[0,0,0,0,0,0,0,0,0,0];
	for(var i=0;i<input.value.length;i++){
		var k=input.value[i];
		arr[k]++;
		if(arr[k]>=2){
			return true;
		}
	}
	return false;
}

function isAllNum(input){
	for(var i=0;i<input.value.length;i++){
		if(isNaN(input.value[i])){
			return false
		}
	}
	return true;
}