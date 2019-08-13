//각 문자열 데이터를 화면에 출력하기 위한 함수
function initText(){
	
	var parent=document.getElementById("animate-container");
	//data=data.substring(1,data.length-1);
	//var data=data.split(", ");
	var data=["Welcome to","Team1 Project","Sport Matching","E-Sport Matching","try it now!"];
	
	//var data=data.split(", ");
	for(var i=0;i<data.length;i++){
		var newElement=createElement("div","letter-"+(i+1),data[i])
		parent.appendChild(newElement);
		
	} 
	 
}	
//DOM 객체를 사용하여 HTML 태그 생성하면서 태그의 속성 설정하는 함수 
function createElement(format,id,data){
	var newElement=document.createElement(format);
	newElement.setAttribute("class",id);
	/*newElement.addEventListener("click", function(){
		this.style.color=makeRandomGradient();
	});*/
	newElement.innerHTML=data;
	
	return newElement;
}	