/**
 * 
 */

 function isNotNum(input){
	 for (var i=0;i<input.length;i++){
		 if(0<=i && i<=9){
			 continue;
		 }else{
			 return true;
		 }
	 }
	 if(input.length==0){
		 return true;
	 }
	 return false;
 }
 