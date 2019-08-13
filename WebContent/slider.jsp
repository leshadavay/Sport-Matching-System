<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/slidePage.css">

<title>Insert title here</title>
<style>
.mySlides {
    display:none;
    overflow: hidden;

}
   .slide-images img{
        z-index: -99;
    }
    
   .slide-images{
    	
    	display:none;
    }
    
@keyframes nextFadeOut {
    0%{
        transform: scale(1);
        margin-left: 0;
        opacity: 0.6;
    }
    100%{
        margin-left: -2500px;
        transform: scale(0.5);
        opacity: 0;
    }
}
@keyframes prevFadeOut {
    0%{
        transform: scale(1);
        margin-left: 0;
        opacity: 0.6;
    }
    100%{
        margin-left: +1500px;
        transform: scale(0.5);
        opacity: 0;
    }
}
#letters{
	position:absolute;
  
	top:30%;
	width:80%;
	 
  
	text-align:center;
	left:auto;
	margin:auto 10%;
 	z-index:10;
}
#letters h1{
	font-size:7em;
	animation: h1Tag 1.5s;
  	color:white;
 font-family: 'Black Han Sans', cursive;
}
#letters p{
 	color:white;
	margin-top:30px;
	font-size:4em;
	animation: pTag 2s;
 	font-family: 'Black Han Sans', sans-serif;
 	font-weight:normal;
}
#letters button{
	content:"";
	animation: buttonTag 2.5s;
	font-family: 'Barlow Condensed', sans-serif;
	background-color:unset;  
	padding:15px;
	color:white;
	border:1px solid white;
	text-transform:uppercase;
 	transition:height 1s;
 	outline:none;
}
#letters button:hover{
	color:black;
	cursor:pointer;
	background: white;
 
}
 
@keyframes background{
	

}
@keyframes h1Tag{
	from{
		opacity:0;
	 
	}
	50%{
		opacity:0;
		margin-top:30px;
	 
	}
	to{
		opacity:1;
		margin-top:0;
		 
	}
}
@keyframes pTag{
	from{
		opacity:0;
		 
	}
	50%{
		opacity:0;
		margin-top:60px;
	}
	to{
		 
		margin-top:30px;
		opacity:1;
	}
}
@keyframes buttonTag{
	from{
	 	opacity:0;
	}
	50%{
		opacity:0;
		margin-top:30px;
	}
	to{
		margin-top:0;
		opacity:1;
	}
}


</style>
</head>
<body>
<div id="slide-page-container">
<div id="letter-container"></div>
        <input type="radio" id="img-rad1" name="images"  checked/>
        <input type="radio" id="img-rad2" name="images"/>
        <input type="radio" id="img-rad3" name="images" />
        <input type="radio" id="img-rad4" name="images" />

		
            <div class="slide-images" id="slide-page1">
            <img src="resource/bk_matching.jpg" alt="slide page1">
            <label for="img-rad4" class="previous" onclick="turnPrevPage(this,'slide-page',4);"><span>&#x2039;</span></label>
            <label for="img-rad2" class="next" onclick="turnNextPage(this,'slide-page',2);"><span>&#x203a;</span></label>
        </div>
        <div class="slide-images" id="slide-page2">
            <img src="resource/bk_basketball.jpg" alt="slide page2">
            <label for="img-rad1" class="previous" onclick="turnPrevPage(this,'slide-page',1);"><span>&#x2039;</span></label>
            <label for="img-rad3" class="next"  onclick="turnNextPage(this,'slide-page',3);"><span>&#x203a;</span></label>
        </div>
        <div class="slide-images" id="slide-page3">
            <img src="resource/bk_battle.jpg" alt="slide page3">
            <label for="img-rad2" class="previous" onclick="turnPrevPage(this,'slide-page',2);"><span>&#x2039;</span></label>
            <label for="img-rad4" class="next"  onclick="turnNextPage(this,'slide-page',4);"><span>&#x203a;</span></label>

        </div>
        <div class="slide-images" id="slide-page4">
            <img src="resource/bk_lol.jpg" alt="slide page4">
            <label for="img-rad3" class="previous" onclick="turnPrevPage(this,'slide-page',3);"><span>&#x2039;</span></label>
            <label for="img-rad1" class="next" onclick="turnNextPage(this,'slide-page',1);"><span>&#x203a;</span></label>
        </div>

		<!--  <div class="slide-images" id="slide-page5">
            <img src="resources/images/bk_lol.jpg" alt="slide page4">
            <label for="img-rad3" class="previous"><span>&#x2039;</span></label>
            <label for="img-rad1" class="next"><span>&#x203a;</span></label>
		 </div> -->
		 
		 
		 
        <!-- making bottom dots -->
        <div id="slide-navigation">
            <label for="img-rad1" class="dots" id="dot1" ></label>
            <label for="img-rad2" class="dots" id="dot2" ></label>
            <label for="img-rad3" class="dots" id="dot3" ></label>
            <label for="img-rad4" class="dots" id="dot4" ></label>
        </div>
    </div>
  
    <script>
    	var letters=["지금 바로 참여 하세요","언제 까지 맨투맨만 할건가?","언제 까지 사람 없어서 풋살만 하는가?","만년 브론즈 버스 받고 싶나?"];
		var titles=["Sports Matching","Basket Ball","Soccer","L O L"];
    	turnNextPage(document.getElementsByClassName("next")[3],'slide-page',1);

    	/* var next=0;
    	var prev=4;
 
     	carousel();
    	function carousel() {
    	next+=1;
    	prev-=1;
    	if(next>3) next=1;
    	if(prev<0) prev=3;
    	console.log(prev+" vs "+next);
    	 turnNextPage(document.getElementsByClassName("next")[prev],'slide-page',next);
    	
    	 
    	  setTimeout(carousel, 4000); // Change image every 2 seconds
    	}   */
    	
    	
	    function turnNextPage(currentNode, nextNode,id) {
	  
	    	 
	        var next=document.getElementById(nextNode+""+id).firstElementChild;
	        var prev=currentNode.previousElementSibling.previousElementSibling;
			
	     	prev.parentNode.style.display="block";
	        next.parentNode.style.display="block";
	     	
	        next.style.marginLeft="300px";
	        next.style.display="block";
	        prev.style.animation="nextFadeOut 1s";
	         
	        
	        //next.style.opacity="1";
	
	        var posNext = 300;
	        var posPrev=0;
	        var temp = setInterval(frame,1);
	        function frame() {
	            if (posNext < 0) {
	                clearInterval(temp);
	                prev.style.animation="";
	
	                prev.style.display="none";
	
	            } else {
	                posNext-=2;
	//                posPrev-=20;
	                next.style.marginLeft = posNext + "px";
	//                        prev.style.marginLeft = posPrev + "px";
	            }
	        }
	        printText(id);
	     }
	
	    function turnPrevPage(currentNode, nextNode,id){
	    	
	        var next=document.getElementById(nextNode+""+id).firstElementChild;
	        var prev=currentNode.previousElementSibling;
	        
	    	prev.parentNode.style.display="block";
	        next.parentNode.style.display="block";
	        
	        next.style.marginLeft="-300px";
	        next.style.display="block";
	        prev.style.animation="prevFadeOut 1s";
	
	        var posNext = -500;
	        var posPrev=0;
	        var temp= setInterval(frame,1);
	        function frame() {
	            if (posNext >0) {
	                clearInterval(temp);
	                prev.style.animation="";
	
	                prev.style.display="none";
	
	            } else {
	                posNext+=4;
	//                posPrev-=20;
	                next.style.marginLeft = posNext + "px";
	                //                        prev.style.marginLeft = posPrev + "px";
	            }
	        }
	        printText(id);
	    }
	    function printText(id){
	    	
	    	var parent=document.getElementById("slide-page-container");
	    	
	    	var temp=document.getElementById("letter-container");
	    	console.log(temp);
	   		if(temp.hasChildNodes()){
	    		while(temp.hasChildNodes()){
	    			temp.removeChild(temp.lastChild);
	    		}
	    	} 
	    	
	    	var div=document.createElement("div");
	    	var h1=document.createElement("h1");
	    	var p=document.createElement("p");
	    	var button=document.createElement("button");
	    	
	    	button.innerHTML="learn more";
	    	button.setAttribute("onclick","redirectPage(letters[id-1]);");
	    	div.setAttribute("id","letters");

	    	
	    	p.innerHTML=letters[id-1];
	    	h1.innerHTML=titles[id-1];
	    	
	    	div.appendChild(h1);
	    	div.appendChild(p);
	    	div.appendChild(button);
	    	
	    	temp.appendChild(div);
			
	    }
	    function redirectPage(paramName){
	    	alert(paramName);
	    }
</script>

  
</body>
</html>