/**
 * Check validation of id, pw, etc.
 */
 function isNull(input){
	 return !input.value;
 }

 function isNotNull(input){
	 return !!input.value;
 }
 
 function isDigit(ch){
	 return (0<=ch) && (ch<=9);
 }
 
 function isAlpha(ch){
	 console.log(ch);
	 return (ch.toLowerCase()>="a") && (ch.toLowerCase()<="z");
 }
 
 function isAlNum(ch){
	 return isDigit(ch)||isAlpha(ch);
 }
 
 function hasOnlyAlphaOrNum(input){
	 for(var i=0;i<a.length;i++){
		 if(!isAlNum(input.value[i])){
			 return false;
		 }
	 }
	 return true;
 }
 
function getIsSpecialFunc(specialChar){
	return function(ch){
		if(specialChar.indexOf(ch)==-1){
			return false;
		}
		return true;
	}
}

function hasOnlyTypedChar(input, funcs ){
	var check = true;
	for(var i=0;i<input.value.length;i++){
		check = false
		for(var k=0;k<funcs.length;k++){
			if(funcs[k](input.value[i])){
				check = true;
				break;
			}
		}
		if(!check){
			return false;
		}
	}
	return true;
}

function hasAllTypedChar(input, funcs){
	var ct=0;
	for(var i=0;i<funcs.length;i++){
		for(var j=0;j<input.value.length;j++){
			if(funcs[i](input.value[j])){
				ct++;
				break;
			}
		}
	}
	if(ct==funcs.length){
		return true;
	}
	return false;
}

function isEqual(input1, input2){
	return input1.value==input2.value;
}

function checkAge(input){
	input = input.trim();
	if(input.indexOf(".")>=0){
		return false;
	}
	if(0<=input && input<=150){
		return true;
	}
	return false;
}

function checkFile(filePath, type){
	return filePath.value.toLowerCase().endsWith("."+type.toLowerCase());
}

function checkFileTypes(filePath, types){
	for(var i=0;i<types.length;i++){
		if(checkFile(filePath, types[i])){
			return true;
		}
	}
	return false;
}